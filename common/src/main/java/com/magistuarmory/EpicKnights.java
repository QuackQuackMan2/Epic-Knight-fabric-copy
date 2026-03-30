package com.magistuarmory;

import com.magistuarmory.api.addon.AddonLoader;
import com.magistuarmory.api.addon.AddonRegistryHelper;
import com.magistuarmory.block.ModBlockEntityTypes;
import com.magistuarmory.block.ModBlocks;
import com.magistuarmory.client.render.model.ModModels;
import com.magistuarmory.component.ModDataComponents;
import com.magistuarmory.config.GeneralConfig;
import com.magistuarmory.config.ModConfig;import com.magistuarmory.misc.ModMerchOffers;import com.magistuarmory.effects.ModEffects;
import com.magistuarmory.event.ClientEvents;
import com.magistuarmory.event.CommonEvents;
import com.magistuarmory.item.ModItems;
import com.magistuarmory.item.armor.ArmorTypes;
import com.magistuarmory.item.crafting.ModRecipes;
import com.magistuarmory.misc.ModCreativeTabs;
import com.magistuarmory.misc.ModReloadListenerRegistry;
import com.magistuarmory.network.ModPackets;
import com.magistuarmory.util.DiagnosticDumper;
import com.magistuarmory.util.EpicKnightsLogger;
import dev.architectury.platform.Platform;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import me.shedaniel.autoconfig.serializer.PartitioningSerializer;
import net.fabricmc.api.EnvType;


public class EpicKnights
{
    public static boolean BC_or_EF_installed;
	public static final String ID = "magistuarmory";
    public static final ModConfig CONFIG;
    public static final GeneralConfig GENERAL_CONFIG;
    
    static
    {
        AutoConfig.register(ModConfig.class, PartitioningSerializer.wrap(JanksonConfigSerializer::new));
        CONFIG = AutoConfig.getConfigHolder(ModConfig.class).getConfig();
        GENERAL_CONFIG = CONFIG.general;
    }
    
    public static void init()
    {
        EpicKnightsLogger.info("Initializing Epic Knights mod...");
        AddonLoader.discoverAddons();

        safeInit("ModDataComponents", ModDataComponents::init);
        safeInit("ModEffects", ModEffects::init);
        safeInit("ModPackets", ModPackets::init);
        safeInit("ModBlocks", ModBlocks::register);
        safeInit("ModBlockEntityTypes", ModBlockEntityTypes::init);
        safeInit("CommonEvents", CommonEvents::init);

        if (Platform.getEnv() == EnvType.CLIENT)
        {
            safeInit("ClientEvents", ClientEvents::init);
            safeInit("ModModels", () -> ModModels.INSTANCE.init(ModItems.INSTANCE));
        }

        safeInit("ArmorTypes", ArmorTypes::init);
        safeInit("ModItems", ModItems.INSTANCE::init);
        safeInit("ModItems static", ModItems::register);
        safeInit("ModRecipes", ModRecipes::init);
        safeInit("ModCreativeTabs", ModCreativeTabs::init);
        safeInit("ModReloadListenerRegistry", ModReloadListenerRegistry::init);

        AddonLoader.runRegistration();
        AddonLoader.runInitialize();

        EpicKnightsLogger.info("Epic Knights initialization complete.");
    }

    private static void safeInit(String stage, Runnable runnable) {
        try {
            runnable.run();
            EpicKnightsLogger.debug("{} completed", stage);
        } catch (Throwable throwable) {
            String message = "Error during initialization stage: " + stage;
            EpicKnightsLogger.error(message, throwable);
            DiagnosticDumper.dump(message, throwable);
        }
    }
    
    public static void checkBetterCombatOrEpicFightInstalled()
	{
        BC_or_EF_installed = Platform.isModLoaded("bettercombat") || Platform.isModLoaded("epicfight");
    }
}
