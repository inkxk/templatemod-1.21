package net.inkxk.templatemod.item;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import net.inkxk.templatemod.TemplateMod;

public class ModItems {
	public static void registerModItem() {
		TemplateMod.LOGGER.info("Registering Mod Items for " + TemplateMod.MOD_ID);
	}

	public static Item register(Item item, String name) {
		// Create the identifier for the item.
		Identifier itemId = Identifier.of(TemplateMod.MOD_ID, name);

		// Register the item.
		Item registeredItem = Registry.register(Registries.ITEM, itemId, item);

		return registeredItem;
	}

	public static final Item RUBY = ModItems.register(new Item(new Item.Settings()), "ruby");
	public static final Item RAW_RUBY = ModItems.register(new Item(new Item.Settings()), "raw_ruby");
}