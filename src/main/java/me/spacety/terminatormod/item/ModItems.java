package me.spacety.terminatormod.item;

import me.spacety.terminatormod.item.custom.TerminatorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemTier;
import net.minecraft.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import me.spacety.terminatormod.TerminatorMod;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TerminatorMod.MODID);
    public static final RegistryObject<Item> TERMINATOR = ITEMS.register("terminator",
            () -> new TerminatorItem(ItemTier.NETHERITE, 0, 20F, new Item.Properties()
                    .group(ItemGroup.COMBAT)
                    .isImmuneToFire()
                    .maxStackSize(1)
                    .rarity(Rarity.EPIC)
                    .maxDamage(0)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
