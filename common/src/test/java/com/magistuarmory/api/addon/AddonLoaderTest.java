package com.magistuarmory.api.addon;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

public class AddonLoaderTest {

    @Test
    public void testAddonLoaderDiscoversSampleAddon() {
        AddonLoader.discoverAddons();
        assertNotNull(AddonLoader.getLoadedAddons());
        assertFalse(AddonLoader.getLoadedAddons().isEmpty());
    }
}
