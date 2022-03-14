package com.jad.forgemods;

import net.minecraft.item.Item;
import com.google.common.collect.ImmutableList;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import java.util.List;
import java.util.Random;

public class DropListener {
    public static Item getRandomItem() {
        List<Item> items = ImmutableList.copyOf(Item.REGISTRY);
        Random r = new Random();
        int index = r.nextInt(items.size());
        return items.get(index);
    }
    @SubscribeEvent
    public void OnDrop(LivingDropsEvent event) {
        if (event.getDrops().size() > 0) {
            event.setCanceled(true);
            event.getEntity().dropItem(getRandomItem(), 1);

        }
    }
}