package com.magistuarmory.api.addon;

import com.magistuarmory.block.ModBlocks;
import com.magistuarmory.item.ModItems;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.Objects;
import java.util.function.Supplier;

public final class AddonRegistryHelper {
    public AddonRegistryHelper() {
    }

    public static RegistrySupplier<Item> registerItem(String name, Supplier<? extends Item> supplier) {
        Objects.requireNonNull(name, "item name cannot be null");
        return ModItems.ITEMS.register(name, () -> supplier.get());
    }

    public static RegistrySupplier<Block> registerBlock(String name, Supplier<? extends Block> supplier) {
        Objects.requireNonNull(name, "block name cannot be null");
        return ModBlocks.BLOCKS.register(name, () -> supplier.get());
    }

    // recipe registration requires data pack or runtime registry; simplified helper
    public static void registerRecipe(String id) {
        // placeholder for addon recipe registration; currently expects JSON data files under data/<addon>/recipes
    }
}
