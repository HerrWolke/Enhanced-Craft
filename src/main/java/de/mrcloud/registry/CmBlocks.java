package de.mrcloud.registry;


import de.mrcloud.blocks.BlockBase;
import de.mrcloud.blocks.Oven;
import de.mrcloud.blocks.Press;
import de.mrcloud.main.CraftingMod;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class CmBlocks {

    //To register the items/blocks etc

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, CraftingMod.MOD_ID);

    //Blocks
    public static final RegistryObject<Block> RUBY_BLOCK = BLOCKS.register("ruby_block", () -> new BlockBase(Material.IRON, 6.0f, 5.0f, SoundType.METAL, 2, ToolType.PICKAXE));
    public static final RegistryObject<Block> RUBY_ORE = BLOCKS.register("ruby_ore", () -> new BlockBase(Material.IRON, 3.0f, 3.0f, SoundType.STONE, 2, ToolType.PICKAXE));
    public static final RegistryObject<Block> OVEN = BLOCKS.register("oven", () -> new Oven());
    public static final RegistryObject<Block> PRESS = BLOCKS.register("press", () -> new Press());

}
