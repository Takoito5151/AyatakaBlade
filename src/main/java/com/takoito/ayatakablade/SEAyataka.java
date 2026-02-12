package com.takoito.ayatakablade;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import mods.flammpfeil.slashblade.ItemSlashBlade;
import mods.flammpfeil.slashblade.specialeffect.ISpecialEffect;
import mods.flammpfeil.slashblade.specialeffect.SpecialEffects;
import mods.flammpfeil.slashblade.util.SlashBladeEvent;
import mods.flammpfeil.slashblade.util.SlashBladeHooks;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;

import java.util.List;

public class SEAyataka implements ISpecialEffect {
    private static final String EffectKey = "WaveAyataka";

//    private List<EntityCreature> nearMobs(World world){
//        AxisAlignedBB range = AxisAlignedBB.getBoundingBox()
//    }


    @SubscribeEvent
    public void onUpdateItemSlashBlade(SlashBladeEvent.OnUpdateEvent event){
        if (SpecialEffects.isPlayer(event.entity)) {
            EntityPlayer player = (EntityPlayer)event.entity;

            List nearbyEntities = player.worldObj.getEntitiesWithinAABB(
                EntityLiving.class,
                player.boundingBox.expand(50.0D, 50.0D, 50.0D));

            for (Object obj : nearbyEntities) {
                if (obj instanceof EntityMob mob) {

                    // Mobのターゲットをプレイヤーに設定
                    // プレイヤーとの距離を計算
                    double distance = player.getDistanceToEntity(mob);

                    // もしMobの感知距離（通常は16ブロック）の2倍、つまり32ブロック以内ならターゲットをプレイヤーにする
                    if (distance <= 32.0D) {
                        mob.setAttackTarget(player);
                    }
                }
            }
        }


    }

    @Override
    public void register() {
        SlashBladeHooks.EventBus.register(this);
    }

    @Override
    public int getDefaultRequiredLevel() {
        return 0;
    }

    @Override
    public String getEffectKey() {
        return EffectKey;
    }
}
