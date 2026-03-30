package com.magistuarmory.api.addon;

import com.magistuarmory.api.addon.AddonRegistryHelper;

public interface EpicKnightsAddon {

    /**
     * Unique addon id (snake-case) used for logging and conflicts.
     */
    String getAddonId();

    /**
     * Register items/blocks/recipes via the helper APIs before the game registry is finalized.
     */
    void onRegister(AddonRegistryHelper registry);

    /**
     * Client-side initialization hooks.
     */
    default void onClientInit() {
    }

    /**
     * Common initialization hooks.
     */
    default void onInitialize() {
    }
}
