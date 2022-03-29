package com.jad.forgemods;
// test
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import java.lang.reflect.Field;

public class AttackMods {
    Class<EntityLivingBase> baseEntity = EntityLivingBase.class;
    @SubscribeEvent
    public void triggerBot(TickEvent event) throws NoSuchFieldException, IllegalAccessException {
        final Minecraft mc = Minecraft.getMinecraft();
        if (mc.player != null) {
            if (mc.objectMouseOver != null) {
                if (mc.objectMouseOver.entityHit != null) {
                    Entity e = mc.objectMouseOver.entityHit;
                    if (e.isEntityAlive()) {
                        EntityLiving living = (EntityLiving) e;
                        Field f = baseEntity.getDeclaredField("ticksSinceLastSwing");
                        f.setAccessible(true);
                        int ticksSinceLastSwing = (int) f.get(mc.player);
                        if (living.attackable() && ticksSinceLastSwing > mc.player.getCooldownPeriod()) {
                            mc.playerController.attackEntity(mc.player, living);
                        }
                    }
                }
            }
        }
    }
}
