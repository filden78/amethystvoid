package ru.filden.amethystvoid.datagen;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.data.DataGenerator;
import ru.filden.amethystvoid.block.blocks;

public class AVDataGeneration implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        fabricDataGenerator.addProvider(AVLootTables::new);
    }
    private static class AVLootTables extends FabricBlockLootTableProvider {
        protected AVLootTables(FabricDataGenerator dataGenerator) {
            super(dataGenerator);
        }

        @Override
        protected void generateBlockLootTables() {
            addDrop(blocks.AMETHYST_DIRT);
            addDrop(blocks.AMETHYST_STONE);
            addDrop(blocks.AMETHYST_ClEANER);
        }
    }
}
