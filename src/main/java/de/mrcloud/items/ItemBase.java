package de.mrcloud.items;

import de.mrcloud.main.CraftingMod;
import net.minecraft.item.Item;

public class ItemBase extends Item {

    public ItemBase() {
        super(new Item.Properties().group(CraftingMod.TAB));
    }
}
