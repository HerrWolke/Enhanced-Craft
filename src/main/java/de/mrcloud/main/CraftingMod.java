package de.mrcloud.main;

import de.mrcloud.entities.HogEntity;
import de.mrcloud.registry.CmBlocks;
import de.mrcloud.registry.CmEntityTypes;
import de.mrcloud.registry.CmItems;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("craftingmod")
public class CraftingMod {
    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "craftingmod";
    public static final ItemGroup TAB = new ItemGroup("CraftingMod") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(CmItems.RUBY.get());
        }
    };



    public CraftingMod() {
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register the doClientStuff method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        CmBlocks.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        CmItems.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        CmEntityTypes.ENTITY_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        LOGGER.debug("!LOADED!");
        LOGGER.error("The Mod loaded");
        DeferredWorkQueue.runLater(() -> {
            GlobalEntityTypeAttributes.put(CmEntityTypes.HOG.get(), HogEntity.setCustomAttributes().create());
        });
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
    }
}
