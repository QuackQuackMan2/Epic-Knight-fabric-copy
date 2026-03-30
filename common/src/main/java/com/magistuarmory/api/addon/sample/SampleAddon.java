package com.magistuarmory.api.addon.sample;

import com.magistuarmory.api.addon.AddonRegistryHelper;
import com.magistuarmory.api.addon.EpicKnightsAddon;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item.Properties;

public class SampleAddon implements EpicKnightsAddon {

    @Override
    public String getAddonId() {
        return "sample-addon";
    }

    @Override
    public void onRegister(AddonRegistryHelper registry) {
        registry.registerItem("sample_sword", () -> new Item(new Properties().stacksTo(1)));
    }

    @Override
    public void onInitialize() {
        // no-op
    }

    @Override
    public void onClientInit() {
        // no-op
    }
}
