package de.mrcloud.util;

import de.mrcloud.client.render.HogRenderer;
import de.mrcloud.main.CraftingMod;
import de.mrcloud.registry.CmEntityTypes;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = CraftingMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {
    
        @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
            RenderingRegistry.registerEntityRenderingHandler(CmEntityTypes.HOG.get(), HogRenderer::new);
        }
}
