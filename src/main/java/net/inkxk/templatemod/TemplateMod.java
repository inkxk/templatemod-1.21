package net.inkxk.templatemod;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.inkxk.templatemod.block.ModBlock;
import net.inkxk.templatemod.item.ModItemGroups;
import net.inkxk.templatemod.item.ModItems;

public class TemplateMod implements ModInitializer {
	public static final String MOD_ID = "templatemod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();

		ModItems.registerModItem();
		ModBlock.registerModBlock();
	}
}