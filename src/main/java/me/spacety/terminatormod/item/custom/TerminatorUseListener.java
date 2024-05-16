package me.spacety.terminatormod.item.custom;

import me.spacety.terminatormod.TerminatorMod;
import me.spacety.terminatormod.item.ModItems;
import me.spacety.terminatormod.util.TerminatorUtil;
import net.minecraft.util.Hand;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
public class TerminatorUseListener {

    @SubscribeEvent
    public void onPlayerInteractEvent(PlayerInteractEvent event) {
        if (event.getWorld().isRemote) {
            return;
        }
        if (event.getPlayer().getHeldItem(Hand.MAIN_HAND).getItem() == ModItems.TERMINATOR.get()){
            event.setCanceled(true);
            TerminatorUtil.launchArrows(event.getPlayer());
        }
    }

    @SubscribeEvent
    public void onPlayerLeftClickEvent(PlayerInteractEvent.LeftClickEmpty event) {
        System.out.println("Left click empty");
        if (event.getWorld().isRemote) {
            return;
        }
        if (event.getPlayer().getHeldItem(Hand.MAIN_HAND).getItem() == ModItems.TERMINATOR.get()){
            event.setCanceled(true);
            TerminatorUtil.launchArrows(event.getPlayer());
        }
    }

}
