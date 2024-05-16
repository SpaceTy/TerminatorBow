package me.spacety.terminatormod;

import me.spacety.terminatormod.item.ModItems;
import me.spacety.terminatormod.item.custom.TerminatorUseListener;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(TerminatorMod.MODID)
public class TerminatorMod {
    public static final String MODID = "terminatormod";

    public TerminatorMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(new TerminatorUseListener());

        ModItems.register(modEventBus);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
    }
}
