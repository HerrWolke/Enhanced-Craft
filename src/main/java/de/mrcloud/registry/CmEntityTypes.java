package de.mrcloud.registry;

import de.mrcloud.entities.HogEntity;
import de.mrcloud.main.CraftingMod;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class CmEntityTypes {

    public static DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, CraftingMod.MOD_ID);

    //Entity Types
    public static final RegistryObject<EntityType<HogEntity>> HOG = ENTITY_TYPES.register("hog",
            () -> EntityType.Builder.create(HogEntity::new, EntityClassification.CREATURE)
            .size(1.0f,1.5f)
            .build(new ResourceLocation(CraftingMod.MOD_ID,"hog").toString())
    );
}
