package net.mikitstrees.packy.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.mikitstrees.packy.Packy;
import net.mikitstrees.packy.item.custom.ChiselItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item PINK_GARNET = registerItem("pink_garnet", new Item(new Item.Settings()));
    public static final Item RAW_PINK_GARNET = registerItem("raw_pink_garnet", new Item(new Item.Settings()));

    public static final Item CHISEL = registerItem("chisel", new ChiselItem(new Item.Settings().maxDamage(32)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Packy.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Packy.LOGGER.info("Registering Mod Items for " + Packy.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> { //entries into the creative inventory, outside of a group i think?
            entries.add(PINK_GARNET);
            entries.add(RAW_PINK_GARNET);
        });
    }
}