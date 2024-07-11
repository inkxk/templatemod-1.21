package net.inkxk.templatemod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.inkxk.templatemod.TemplateMod;
import net.inkxk.templatemod.block.ModBlock;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
  public static void registerItemGroups() {
    TemplateMod.LOGGER.info("Registering Item Groups for " + TemplateMod.MOD_ID);

    Registry.register(Registries.ITEM_GROUP, RUBY_GROUP_KEY, RUBY_GROUP);

    ItemGroupEvents.modifyEntriesEvent(RUBY_GROUP_KEY).register(itemGroup -> {
      itemGroup.add(ModItems.RUBY);
      itemGroup.add(ModItems.RAW_RUBY);
      itemGroup.add(ModBlock.RUBY_BLOCK);
      itemGroup.add(ModBlock.RAW_RUBY_BLOCK);
    });
  }

  public static final RegistryKey<ItemGroup> RUBY_GROUP_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(),
      Identifier.of(TemplateMod.MOD_ID, "ruby"));

  public static final ItemGroup RUBY_GROUP = FabricItemGroup.builder()
      .icon(() -> new ItemStack(ModItems.RUBY))
      .displayName(Text.translatable("itemGroup.ruby"))
      .build();
}
