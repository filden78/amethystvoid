package ru.filden.amethystvoid.block;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import ru.filden.amethystvoid.block.entity.AmethystCleanerBlock;
import ru.filden.amethystvoid.item.modItemGroup;

import static ru.filden.amethystvoid.Amethystvoid.MOD_ID;

public class blocks {
    public static final Block AMETHYST_STONE = registerBlock("amethyst_stone", new Block(FabricBlockSettings.copyOf(Blocks.STONE)), modItemGroup.AMETHYST_VOID_GROUP);
    public static final Block AMETHYST_DIRT = registerBlock("amethyst_dirt", new Block(FabricBlockSettings.copyOf(Blocks.DIRT)), modItemGroup.AMETHYST_VOID_GROUP);
    //public static final Block AMETHYST_STONE = registerBlock("amethyst_stone", new Block(FabricBlockSettings.copyOf(Blocks.STONE)));
    //public static final Block AMETHYST_STONE = registerBlock("amethyst_stone", new Block(FabricBlockSettings.copyOf(Blocks.STONE)));
    public static final Block BUSH_OF_TEA = registerBlock("bush_of_tea", new Block(FabricBlockSettings.copyOf(Blocks.GRASS)),  modItemGroup.AMETHYST_VOID_GROUP);
    public static final Block AMETHYST_ClEANER = registerBlock("amethyst_cleaner", new AmethystCleanerBlock(FabricBlockSettings.of(Material.AMETHYST).nonOpaque()), modItemGroup.AMETHYST_VOID_GROUP);

    private static Item registerBlockItem(String name, Block block, ItemGroup tab) {
        return Registry.register(Registry.ITEM, new Identifier(MOD_ID, name), new BlockItem(block, new FabricItemSettings().group(tab)));
    }
    private static Block registerBlock(String name, Block block, ItemGroup tab) {
        registerBlockItem(name,block, tab);
        return Registry.register(Registry.BLOCK, new Identifier(MOD_ID, name), block);
    }

    public static void init() {

    }
}
