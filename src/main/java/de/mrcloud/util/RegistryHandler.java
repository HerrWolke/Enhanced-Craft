package de.mrcloud.util;


import de.mrcloud.armour.ModArmourMaterial;
import de.mrcloud.blocks.BlockBase;
import de.mrcloud.blocks.BlockItemBase;
import de.mrcloud.items.ItemBase;
import de.mrcloud.items.RubyApple;
import de.mrcloud.main.CraftingMod;
import de.mrcloud.tools.ModItemTier;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryHandler {

    //To register the items/blocks etc
    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, CraftingMod.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, CraftingMod.MOD_ID);
    //Items
    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby", ItemBase::new);
    public static final RegistryObject<Item> REDSTONE_MOLD = ITEMS.register("redstone_mold", ItemBase::new);
    public static final RegistryObject<RubyApple> RUBY_APPLE = ITEMS.register("ruby_apple",RubyApple::new);
    //Blocks
    public static final RegistryObject<Block> RUBY_BLOCK = BLOCKS.register("ruby_block", () -> new BlockBase(Material.IRON, 6.0f, 5.0f, SoundType.METAL, 2, ToolType.PICKAXE));
    //Block Items
    public static final RegistryObject<Item> RUBY_BLOCK_ITEM = ITEMS.register("ruby_block", () -> new BlockItemBase(RUBY_BLOCK.get()));
    //Tools
    public static final RegistryObject<SwordItem> RUBY_SWORD = ITEMS.register("ruby_sword", () ->
            new SwordItem(ModItemTier.RUBY, 8, 0F, new Item.Properties().group(CraftingMod.TAB)));
    public static final RegistryObject<PickaxeItem> RUBY_PICKAXE = ITEMS.register("ruby_pickaxe", () ->
            new PickaxeItem(ModItemTier.RUBY, 2, -2.8F, new Item.Properties().group(CraftingMod.TAB)));
    public static final RegistryObject<ShovelItem> RUBY_SHOVEL = ITEMS.register("ruby_shovel", () ->
            new ShovelItem(ModItemTier.RUBY, 1, 0F, new Item.Properties().group(CraftingMod.TAB)));
    public static final RegistryObject<AxeItem> RUBY_AXE = ITEMS.register("ruby_axe", () ->
            new AxeItem(ModItemTier.RUBY, 9, 0F, new Item.Properties().group(CraftingMod.TAB)));

    public static void init() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    //Armour
    private static final RegistryObject<ArmorItem> RUBY_HELMET = ITEMS.register("ruby_helmet", () -> new ArmorItem(ModArmourMaterial.RUBY,
            EquipmentSlotType.HEAD,new Item.Properties().group(CraftingMod.TAB)));

    private static final RegistryObject<ArmorItem> RUBY_CHESTPLATE = ITEMS.register("ruby_chestplate", () -> new ArmorItem(ModArmourMaterial.RUBY,
            EquipmentSlotType.CHEST,new Item.Properties().group(CraftingMod.TAB)));

    private static final RegistryObject<ArmorItem> RUBY_LEGGINGS = ITEMS.register("ruby_leggings", () -> new ArmorItem(ModArmourMaterial.RUBY,
            EquipmentSlotType.LEGS,new Item.Properties().group(CraftingMod.TAB)));

    private static final RegistryObject<ArmorItem> RUBY_BOOTS = ITEMS.register("ruby_boots", () -> new ArmorItem(ModArmourMaterial.RUBY,
            EquipmentSlotType.FEET,new Item.Properties().group(CraftingMod.TAB)));


}
