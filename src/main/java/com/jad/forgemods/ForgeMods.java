package com.jad.forgemods;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.Mod;
@Mod(
        modid = ForgeMods.MOD_ID,
        name = ForgeMods.MOD_NAME,
        version = ForgeMods.VERSION
)
public class ForgeMods {

    public static final String MOD_ID = "forgemods";
    public static final String MOD_NAME = "forgemods";
    public static final String VERSION = "1.0-SNAPSHOT";

    @Mod.Instance(MOD_ID)
    public static ForgeMods INSTANCE;

    @Mod.EventHandler
    public void preinit(FMLPreInitializationEvent event) {

    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {

    }

    @Mod.EventHandler
    public void postinit(FMLPostInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new AttackMods());
        MinecraftForge.EVENT_BUS.register(new WorldMods());
        MinecraftForge.EVENT_BUS.register(new DropListener());
    }

}
