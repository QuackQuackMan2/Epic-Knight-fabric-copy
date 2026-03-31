package com.magistuarmory.block;

import com.magistuarmory.EpicKnights;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.function.Supplier;

public class ModBlockEntityTypes
{
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(EpicKnights.ID, Registries.BLOCK_ENTITY_TYPE);

    public static RegistrySupplier<BlockEntityType<PaviseBlockEntity>> PAVISE;

    public static void init()
    {
        PAVISE = BLOCK_ENTITY_TYPES.register("pavise", () -> FabricBlockEntityTypeBuilder.create(PaviseBlockEntity::new, 
            ModBlocks.WOOD_PAVISE.get(), ModBlocks.GOLD_PAVISE.get(), ModBlocks.STONE_PAVISE.get(), ModBlocks.IRON_PAVISE.get(),
            ModBlocks.DIAMOND_PAVISE.get(), ModBlocks.NETHERITE_PAVISE.get(), ModBlocks.TIN_PAVISE.get(), ModBlocks.COPPER_PAVISE.get(),
            ModBlocks.SILVER_PAVISE.get(), ModBlocks.BRONZE_PAVISE.get(), ModBlocks.STEEL_PAVISE.get()).build());
        BLOCK_ENTITY_TYPES.register();
    }

    public static RegistrySupplier<BlockEntityType<PaviseBlockEntity>> getPaviseBlockEntityType() {
        return PAVISE;
    }
}

