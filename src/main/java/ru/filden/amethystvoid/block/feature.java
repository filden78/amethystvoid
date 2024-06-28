package ru.filden.amethystvoid.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static ru.filden.amethystvoid.Amethystvoid.MOD_ID;

public class feature {
    

    /////////////////////////////////////////////////////////////////////////////////////
    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registry.ITEM, new Identifier(MOD_ID, name), new BlockItem(block, new FabricItemSettings()));
    }
    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name,block);
        return Registry.register(Registry.BLOCK, new Identifier(MOD_ID, name), block);
    }
    public static void init(){}
}
