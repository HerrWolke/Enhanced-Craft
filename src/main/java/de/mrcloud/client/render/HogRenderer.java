package de.mrcloud.client.render;

import de.mrcloud.client.model.HogModel;
import de.mrcloud.entities.HogEntity;
import de.mrcloud.main.CraftingMod;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.tutorial.Tutorial;
import net.minecraft.util.ResourceLocation;

public class HogRenderer extends MobRenderer<HogEntity, HogModel<HogEntity>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(CraftingMod.MOD_ID,"textures/entity/hog.png");

    public HogRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new HogModel<>(),0.7F);
    }

    @Override
    public ResourceLocation getEntityTexture(HogEntity entity) {
        return TEXTURE;
    }
}
