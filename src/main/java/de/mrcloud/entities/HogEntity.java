package de.mrcloud.entities;

import de.mrcloud.registry.CmEntityTypes;
import net.minecraft.block.BlockState;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;

public class HogEntity extends AnimalEntity {

    public static final Ingredient TEMPTATION_ITEM = Ingredient.fromItems(Items.CARROT,Items.POTATO,Items.CARROT);

    private EatGrassGoal eatGrassGoal;
    private int hogEatTimer;

    public HogEntity(EntityType<? extends AnimalEntity> type, World worldIn) {
        super(type, worldIn);
    }

    //func_233666_p_() --> registerAttributes
    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
        return MobEntity.func_233666_p_()
                .createMutableAttribute(Attributes.MAX_HEALTH, 12.0D)
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.5D);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0,new SwimGoal(this));
        this.goalSelector.addGoal(1,new PanicGoal(this,1.25D));
        this.goalSelector.addGoal(2,new BreedGoal(this,1.0D));
        this.goalSelector.addGoal(3,new TemptGoal(this,1.1D,TEMPTATION_ITEM,false));
        this.goalSelector.addGoal(4,new FollowParentGoal(this,1.1D));
        this.goalSelector.addGoal(5,this.eatGrassGoal);
        this.goalSelector.addGoal(6,new WaterAvoidingRandomWalkingGoal(this,1.0D));
        this.goalSelector.addGoal(7,new LookAtGoal(this, PlayerEntity.class,6.0F));
        this.goalSelector.addGoal(8,new LookRandomlyGoal(this));
    }

    @Override
    protected int getExperiencePoints(PlayerEntity player) {
        return 2 + this.world.rand.nextInt(10);
    }


    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_PIGLIN_AMBIENT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_PIG_DEATH;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.ENTITY_PIGLIN_HURT;
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState blockIn) {
        this.playSound(SoundEvents.ENTITY_PIGLIN_STEP,0.20F,0.8F);
    }

    @Nullable
    @Override
    public AgeableEntity createChild(AgeableEntity ageable) {
        return CmEntityTypes.HOG.get().create(this.world);
    }

    @Override
    protected void updateAITasks() {
       this.hogEatTimer = this.eatGrassGoal.getEatingGrassTimer();
       super.updateAITasks();
    }

    @Override
    public void livingTick() {
        if(this.world.isRemote()) {
            this.hogEatTimer = Math.max(0,this.hogEatTimer-1);
        }
        super.livingTick();
    }

    @OnlyIn(Dist.CLIENT)
    public void handleStatusUpdate(byte id) {
        if(id == 10) {
            this.hogEatTimer = 40;
        } else {
            super.handleStatusUpdate(id);
        }
    }
}
