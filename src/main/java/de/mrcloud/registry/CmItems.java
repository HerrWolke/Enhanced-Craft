package de.mrcloud.registry;

import de.mrcloud.blocks.BlockItemBase;
import de.mrcloud.items.ItemBase;
import de.mrcloud.items.RubyApple;
import de.mrcloud.main.CraftingMod;
import de.mrcloud.util.enums.ModArmourMaterial;
import de.mrcloud.util.enums.ModItemTier;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class CmItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, CraftingMod.MOD_ID);

    //Items
    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby", ItemBase::new);

    public static final RegistryObject<Item> REDSTONE_MOLD = ITEMS.register("redstone_mold", ItemBase::new);

    public static final RegistryObject<RubyApple> RUBY_APPLE = ITEMS.register("ruby_apple", RubyApple::new);


    //Tools
    public static final RegistryObject<SwordItem> RUBY_SWORD = ITEMS.register("ruby_sword",
            () -> new SwordItem(ModItemTier.RUBY, 80, 0F, new Item.Properties().group(CraftingMod.TAB)));

    public static final RegistryObject<PickaxeItem> RUBY_PICKAXE = ITEMS.register("ruby_pickaxe",
            () -> new PickaxeItem(ModItemTier.RUBY, 2, -2.8F, new Item.Properties().group(CraftingMod.TAB)));

    public static final RegistryObject<ShovelItem> RUBY_SHOVEL = ITEMS.register("ruby_shovel",
            () -> new ShovelItem(ModItemTier.RUBY, 1, 0F, new Item.Properties().group(CraftingMod.TAB)));

    public static final RegistryObject<AxeItem> RUBY_AXE = ITEMS.register("ruby_axe",
            () -> new AxeItem(ModItemTier.RUBY, 9, -3F, new Item.Properties().group(CraftingMod.TAB)));


    //Block Items
    public static final RegistryObject<Item> RUBY_BLOCK_ITEM = ITEMS.register("ruby_block",
            () -> new BlockItemBase(CmBlocks.RUBY_BLOCK.get()));

    public static final RegistryObject<Item> RUBY_ORE_ITEM = ITEMS.register("ruby_ore",
            () -> new BlockItemBase(CmBlocks.RUBY_ORE.get()));

    public static final RegistryObject<Item> OVEN_ITEM = ITEMS.register("oven",
            () -> new BlockItemBase(CmBlocks.OVEN.get()));

    public static final RegistryObject<Item> PRESS_ITEM = ITEMS.register("press",
            () -> new BlockItemBase(CmBlocks.PRESS.get()));


    //Armour
    private static final RegistryObject<ArmorItem> RUBY_HELMET = ITEMS.register("ruby_helmet",
            () -> new ArmorItem(ModArmourMaterial.RUBY, EquipmentSlotType.HEAD, new Item.Properties().group(CraftingMod.TAB)));

    private static final RegistryObject<ArmorItem> RUBY_CHESTPLATE = ITEMS.register("ruby_chestplate",
            () -> new ArmorItem(ModArmourMaterial.RUBY, EquipmentSlotType.CHEST, new Item.Properties().group(CraftingMod.TAB)));

    private static final RegistryObject<ArmorItem> RUBY_LEGGINGS = ITEMS.register("ruby_leggings",
            () -> new ArmorItem(ModArmourMaterial.RUBY, EquipmentSlotType.LEGS, new Item.Properties().group(CraftingMod.TAB)));

    private static final RegistryObject<ArmorItem> RUBY_BOOTS = ITEMS.register("ruby_boots",
            () -> new ArmorItem(ModArmourMaterial.RUBY, EquipmentSlotType.FEET, new Item.Properties().group(CraftingMod.TAB)));
}
