package net.inkxk.templatemod.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.inkxk.templatemod.TemplateMod;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlock {
  public static void registerModBlock() {
    TemplateMod.LOGGER.info("Registering Mod Block for " + TemplateMod.MOD_ID);
  }

  public static Block register(Block block, String name, boolean shouldRegisterItem) {
    Identifier blockId = Identifier.of(TemplateMod.MOD_ID, name);

    // Sometimes, you may not want to register an item for the block.
    // Eg: if it's a technical block like `minecraft:air` or `minecraft:end_gateway`
    if (shouldRegisterItem) {
      BlockItem blockItem = new BlockItem(block, new Item.Settings());
      Registry.register(Registries.ITEM, blockId, blockItem);
    }

    return Registry.register(Registries.BLOCK, blockId, block);
  }

  public static final Block RUBY_BLOCK = ModBlock.register(
      new Block(AbstractBlock.Settings.copy(Blocks.EMERALD_BLOCK)),
      "ruby_block",
      true);

  public static final Block RAW_RUBY_BLOCK = ModBlock.register(
      new Block(AbstractBlock.Settings.copy(Blocks.EMERALD_ORE)),
      "raw_ruby_block",
      true);

  public static final Block RUBY_ORE = ModBlock.register(
    new ExperienceDroppingBlock(
      UniformIntProvider.create(3, 7), 
      AbstractBlock.Settings.copy(Blocks.STONE).strength(3f)
    ), 
    "ruby_ore",
    true
  );
}
