package de.mrcloud.armour;

import de.mrcloud.main.CraftingMod;
import de.mrcloud.util.RegistryHandler;
import net.minecraft.block.SoundType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.function.Supplier;

public enum ModArmourMaterial implements IArmorMaterial {

    //Pathway to layer = ruby_layer_1 and ruby_layer_2
    //maxDamageFactor detemines the durability by multiplying this value with the contents of MAX_DAMAGE_ARRAY(1 = Helmet, 2 = Leggins, 3 =Chestplate, 4 = Boots)
    //Toughness increases the protection(not visible but invisible actual)
    RUBY(CraftingMod.MOD_ID + ":ruby",38,new int[] {2, 6, 7, 2},18, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN,3.5F,() ->
    {return Ingredient.fromItems(RegistryHandler.RUBY.get()); });

    private static final int[] MAX_DAMAGE_ARRAY = new int[] {11,16,15,13};
    private final String name;
    private final int maxDamageFactor;
    private final int[] damageReductionAmountArray;
    private final int enchantability;
    private final SoundEvent soundEvent;
    private final float toughness;
    private final Supplier<Ingredient> repairMaterial;

    ModArmourMaterial(String name, int maxDamageFactor,int[] damageReductionAmountArray, int enchantability, SoundEvent soundEvent,float toughness,Supplier<Ingredient> repairMaterial) {
        this.name = name;
        this.maxDamageFactor = maxDamageFactor;
        this.damageReductionAmountArray = damageReductionAmountArray;
        this.enchantability = enchantability;
        this.soundEvent = soundEvent;
        this.toughness = toughness;
        this.repairMaterial = repairMaterial;
    }

    @Override
    public int getDurability(EquipmentSlotType slotIn) {
        return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamageFactor;
    }

    @Override
    public int getDamageReductionAmount(EquipmentSlotType slotIn) {
        return this.damageReductionAmountArray[slotIn.getIndex()];
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public SoundEvent getSoundEvent() {
        return this.soundEvent;
    }


    @Override
    public Ingredient getRepairMaterial() {
        return this.repairMaterial.get();
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }
}
