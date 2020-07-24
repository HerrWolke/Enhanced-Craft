package de.mrcloud.events;

import de.mrcloud.main.CraftingMod;
import de.mrcloud.registry.CmBlocks;
import de.mrcloud.registry.CmItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.boss.dragon.EnderDragonEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = CraftingMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ModClientEvents {


    //Testing Stuff

    //func_233580_cy_() == livingEntity.getPosition
//    @SubscribeEvent
//    public static void onJumpWithStick(LivingEvent.LivingJumpEvent event) {
//        LivingEntity player = event.getEntityLiving();
//        if(event.getEntityLiving() instanceof PlayerEntity) {
//            if(player.getHeldItemMainhand().getItem() == Items.NETHER_STAR) {
//                World world = player.getEntityWorld();
//                if(world.getBlockState(player.func_233580_cy_().add(0,-1,0)).getBlock() == Blocks.DIAMOND_BLOCK) {
//                    world.setBlockState(player.func_233580_cy_().add(0,-1,0), RegistryHandler.RUBY_BLOCK.get().getDefaultState());
//                }
//            }
//        }
//    }


    //Give your apple to any player by hitting them
    @SubscribeEvent
    public static void onDamageEnitiy(AttackEntityEvent event) {
        PlayerEntity player = event.getPlayer();
        if (player.getHeldItemMainhand().getItem() == CmItems.RUBY_APPLE.get()) {
            if (event.getTarget().isAlive()) {
                Entity test = event.getTarget();
                if (test instanceof PlayerEntity) {
                    LivingEntity target = event.getEntityLiving();
                    target.addPotionEffect(new EffectInstance(Effects.ABSORPTION, 4 * 60 * 20, 2));
                    target.addPotionEffect(new EffectInstance(Effects.REGENERATION, 2 * 60 * 20, 1));
                    target.addPotionEffect(new EffectInstance(Effects.RESISTANCE, 2 * 60 * 20, 1));

                    player.getHeldItemMainhand().getStack().setCount(player.getHeldItemMainhand().getStack().getCount() - 1);

                    if (event.getPlayer().getEntityWorld().isRemote) {
                        String msg = TextFormatting.RED + "you gave your Ruby Apple to " + target.getScoreboardName();
                        player.sendMessage(new StringTextComponent(msg), player.getUniqueID());
                        String msg2 = TextFormatting.GREEN + target.getScoreboardName() + " healed you";
                        target.sendMessage(new StringTextComponent(msg2), player.getUniqueID());
                    }
                }
            }
        }
    }
    //Same but for right click
    @SubscribeEvent
    public static void onPlayerRightClick(PlayerInteractEvent.EntityInteractSpecific event) {
        PlayerEntity player = event.getPlayer();
        if (player.getHeldItemMainhand().getItem() == CmItems.RUBY_APPLE.get()) {
            if (event.getTarget().isAlive()) {
                Entity test = event.getTarget();
                if (test instanceof SheepEntity) {
                    LivingEntity target = event.getEntityLiving();
                    target.addPotionEffect(new EffectInstance(Effects.ABSORPTION, 4 * 60 * 20, 2));
                    target.addPotionEffect(new EffectInstance(Effects.REGENERATION, 2 * 60 * 20, 1));
                    target.addPotionEffect(new EffectInstance(Effects.RESISTANCE, 2 * 60 * 20, 1));

                    player.getHeldItemMainhand().getStack().setCount(player.getHeldItemMainhand().getStack().getCount() - 1);

                    if (event.getPlayer().getEntityWorld().isRemote) {
                        String msg = TextFormatting.RED + "you gave your Ruby Apple to " + target.getScoreboardName();
                        player.sendMessage(new StringTextComponent(msg), player.getUniqueID());
                        String msg2 = TextFormatting.GREEN + target.getScoreboardName() + " healed you";
                        target.sendMessage(new StringTextComponent(msg2), player.getUniqueID());
                    }
                }
            }
        }
    }

    //Wrong Event(Commented out)

//    @SubscribeEvent
//    public static void onEnderdragonSpawnBuff(LivingSpawnEvent event) {
//        if (event.getEntityLiving() instanceof EnderDragonEntity) {
//            System.out.println("Is ender dragon");
//            LivingEntity spawnedEntity = event.getEntityLiving();
//            spawnedEntity.addPotionEffect(new EffectInstance(Effects.HEALTH_BOOST, 60 * 60 * 20, 50));
//            spawnedEntity.addPotionEffect(new EffectInstance(Effects.STRENGTH, 60 * 60 * 20, 50));
//            spawnedEntity.setHealth(10000);
//            CraftingMod.LOGGER.error("Enderdragon successfully spawned with effect buffs!");
//
//        }
//    }

    @SubscribeEvent
    public static void onEnderdragonSpawn(EntityJoinWorldEvent event) {
        if (event.getEntity() instanceof EnderDragonEntity) {
            System.out.println("Is ender dragon");
            EnderDragonEntity enderDragon = (EnderDragonEntity) event.getEntity();

            enderDragon.setHealth(500);
            CraftingMod.LOGGER.error("Enderdragon successfully spawned with effect buffs!");
        }
    }

    @SubscribeEvent
    public static void onEnderdragonDamagePlayer(LivingHurtEvent event) {
        if (event.getSource().getTrueSource() instanceof EnderDragonEntity) {
            if (event.getEntityLiving() instanceof PlayerEntity) {
                System.out.println(event.getSource().damageType);
                if(!event.getSource().isMagicDamage()) {
                    CraftingMod.LOGGER.error("Ender Dragon attacked Player Calling further code");
                    event.getEntityLiving().addPotionEffect(new EffectInstance(Effects.BLINDNESS, 5 * 20, 2));
                    event.getEntityLiving().addPotionEffect(new EffectInstance(Effects.NIGHT_VISION, 10 * 5, 2));
                    event.getEntityLiving().addPotionEffect(new EffectInstance(Effects.SLOWNESS, 10 * 5, 4));
                } else {
                    CraftingMod.LOGGER.error("ERROR: Dragon Magic damage. Not adding effects to player");
                }

            }
        }
    }
}
