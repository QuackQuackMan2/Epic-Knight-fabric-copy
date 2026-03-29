package com.magistuarmory.item.crafting;

import com.magistuarmory.item.ArmorDecoration;
import com.magistuarmory.item.ArmorDecorationItem;
import com.magistuarmory.item.armor.WearableArmorDecorationItem;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistryAccess;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class ArmorDecorationRecipe extends CustomRecipe {
    public static final RecipeSerializer<ArmorDecorationRecipe> SERIALIZER = new CustomRecipe.Serializer<>(ArmorDecorationRecipe::new);
    
    public ArmorDecorationRecipe(CraftingBookCategory category) {
        super(category);
        //super(location, CraftingBookCategory.MISC);
    }

    @Override
    public boolean matches(CraftingInput container, Level level) {
        ItemStack wearabledecorationstack = ItemStack.EMPTY;
        ItemStack armorstack = ItemStack.EMPTY;
        ItemStack decorationstack = ItemStack.EMPTY;

        for(int i = 0; i < container.size(); ++i) {
            ItemStack stack = container.getItem(i);
            if (stack.isEmpty())
                continue;

            if (stack.getItem() instanceof ArmorItem && stack.getItem() instanceof ArmorDecoration) {
                if (!wearabledecorationstack.isEmpty())
                    return false;

                wearabledecorationstack = stack;
                continue;
            }
            
            if (stack.getItem() instanceof ArmorDecoration) {
                if (!decorationstack.isEmpty())
                    return false;

                decorationstack = stack;
                continue;
            }

            if (stack.getItem() instanceof ArmorItem) {
                if (!armorstack.isEmpty())
                    return false;

                armorstack = stack;
                continue;
            }
            
            return false;
        }

        if (!wearabledecorationstack.isEmpty()) {
            if (!decorationstack.isEmpty() && armorstack.isEmpty()) {
                armorstack = wearabledecorationstack;
            } else if (decorationstack.isEmpty() && !armorstack.isEmpty()) {
                decorationstack = wearabledecorationstack;
            } else {
                return false;
            }
        }

        if (decorationstack.getItem() instanceof ArmorDecoration decoration) {
            return decoration.isApplicableForDecoration(armorstack);
        }

        return false;
    }

    @Override
    public @NotNull ItemStack assemble(CraftingInput container, @NotNull HolderLookup.Provider access) {
        ItemStack wearabledecorationstack = ItemStack.EMPTY;
        ItemStack armorstack = ItemStack.EMPTY;
        ItemStack decorationstack = ItemStack.EMPTY;

        for(int i = 0; i < container.size(); ++i) {
            ItemStack stack = container.getItem(i);
            if (stack.isEmpty())
                continue;
            if (stack.getItem() instanceof ArmorDecoration && stack.getItem() instanceof ArmorItem)
                wearabledecorationstack = stack;
            else if (stack.getItem() instanceof ArmorDecoration)
                decorationstack = stack;
            else if (stack.getItem() instanceof ArmorItem)
                armorstack = stack.copy();
        }

        if (!wearabledecorationstack.isEmpty()) {
            if (!decorationstack.isEmpty() && armorstack.isEmpty()) {
                armorstack = wearabledecorationstack.copy();
            } else if (decorationstack.isEmpty() && !armorstack.isEmpty()) {
                decorationstack = wearabledecorationstack;
            } else {
                return armorstack;
            }
        }

        if (!armorstack.isEmpty() && !decorationstack.isEmpty() && decorationstack.getItem() instanceof ArmorDecoration decoration)
            decoration.decorate(armorstack, decorationstack);
        
        return armorstack;
    }

    @Override
    public RecipeSerializer<? extends CustomRecipe> getSerializer() {
        return getSerializerInstance();
    }

    public static RecipeSerializer<ArmorDecorationRecipe> getSerializerInstance()
    {
        return ArmorDecorationRecipe.SERIALIZER;
    }
}