package com.magistuarmory.fabric;

import com.magistuarmory.EpicKnights;
import com.magistuarmory.event.ClientEvents;
import net.fabricmc.api.ClientModInitializer;

public class EpicKnightsFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EpicKnights.checkBetterCombatOrEpicFightInstalled();
        ClientEvents.init();
    }
}
