package com.magistuarmory.api.addon;

import com.magistuarmory.util.DiagnosticDumper;
import com.magistuarmory.util.EpicKnightsLogger;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

public final class AddonLoader {
    private static final List<EpicKnightsAddon> LOADED_ADDONS = new ArrayList<>();

    private AddonLoader() {
    }

    public static void discoverAddons() {
        EpicKnightsLogger.info("Scanning for Epic Knights addons via ServiceLoader...");
        ServiceLoader<EpicKnightsAddon> loader = ServiceLoader.load(EpicKnightsAddon.class);
        for (EpicKnightsAddon addon : loader) {
            try {
                EpicKnightsLogger.info("Discovered addon: {}", addon.getAddonId());
                LOADED_ADDONS.add(addon);
            } catch (Throwable t) {
                EpicKnightsLogger.warn("Failed to load addon implementation: {}", t.getMessage());
                DiagnosticDumper.dump("Failed to load addon: " + addon.getClass().getName(), t);
            }
        }
    }

    public static List<EpicKnightsAddon> getLoadedAddons() {
        return List.copyOf(LOADED_ADDONS);
    }

    public static void runRegistration() {
        for (EpicKnightsAddon addon : LOADED_ADDONS) {
            try {
                EpicKnightsLogger.info("Running onRegister for addon {}", addon.getAddonId());
                addon.onRegister(new AddonRegistryHelper());
            } catch (Throwable t) {
                EpicKnightsLogger.error("Addon {} onRegister failed", t, addon.getAddonId());
                DiagnosticDumper.dump("Addon onRegister failure for " + addon.getAddonId(), t);
            }
        }
    }

    public static void runInitialize() {
        for (EpicKnightsAddon addon : LOADED_ADDONS) {
            try {
                EpicKnightsLogger.info("Initializing addon {}", addon.getAddonId());
                addon.onInitialize();
            } catch (Throwable t) {
                EpicKnightsLogger.error("Addon {} onInitialize failed", t, addon.getAddonId());
                DiagnosticDumper.dump("Addon onInitialize failure for " + addon.getAddonId(), t);
            }
        }
    }

    public static void runClientInit() {
        for (EpicKnightsAddon addon : LOADED_ADDONS) {
            try {
                EpicKnightsLogger.info("Client init addon {}", addon.getAddonId());
                addon.onClientInit();
            } catch (Throwable t) {
                EpicKnightsLogger.error("Addon {} onClientInit failed", t, addon.getAddonId());
                DiagnosticDumper.dump("Addon onClientInit failure for " + addon.getAddonId(), t);
            }
        }
    }
}
