package de.mrcloud.items;

import de.mrcloud.main.CraftingMod;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class RubyApple extends Item {
    public RubyApple() {
        super(new Item.Properties()
        .group(ItemGroup.FOOD)
        .food( new Food.Builder()
                .hunger(16)
                .saturation(1.5f)
                .effect(() -> new EffectInstance(Effects.ABSORPTION,4 * 60 * 20, 2),0.8f)
                .effect(() -> new EffectInstance(Effects.REGENERATION,2 * 60 * 20, 1),1f)
                .effect(() -> new EffectInstance(Effects.RESISTANCE,2 * 60 * 20, 1),1f)
                .effect(() -> new EffectInstance(Effects.SPEED,10 * 20, 5),0.05f)
                .setAlwaysEdible()
                .build())
        );
    }
}
