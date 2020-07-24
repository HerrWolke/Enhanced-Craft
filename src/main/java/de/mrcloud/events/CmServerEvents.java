package de.mrcloud.events;

import de.mrcloud.main.CraftingMod;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = CraftingMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.DEDICATED_SERVER)
public class CmServerEvents {

    @SubscribeEvent
    public static void onServerChat(ServerChatEvent event) {
    }
}
