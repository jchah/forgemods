package com.jad.forgemods;
//
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class WorldMods {
    Minecraft mc = Minecraft.getMinecraft();
    @SubscribeEvent
    public void waterWalk(TickEvent.PlayerTickEvent event) {
        if (mc.player != null) {
            BlockPos posBelow = mc.player.getPosition().down();
            IBlockState blockStateBelow = mc.world.getBlockState(posBelow);
            if (blockStateBelow.getMaterial() == Material.WATER) {
                mc.player.motionY = 0;
            }
        }
    }
    @SubscribeEvent
    public void higherJump(LivingEvent.LivingJumpEvent event) {
        if (mc.player != null) {
            if (event.getEntity() instanceof EntityPlayerMP) {
                mc.player.motionY *= 2;
            }
        }
    }
}
