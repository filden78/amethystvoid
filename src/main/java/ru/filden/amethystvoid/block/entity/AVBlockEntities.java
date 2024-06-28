package ru.filden.amethystvoid.block.entity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import ru.filden.amethystvoid.Amethystvoid;

import static ru.filden.amethystvoid.block.blocks.AMETHYST_ClEANER;

public class AVBlockEntities {
    public static BlockEntityType<AmethystCleanerBlockEntity> AMETHYST_CLEANER_BLOCK_ENTITY_TYPE;
    public static void init(){
        AMETHYST_CLEANER_BLOCK_ENTITY_TYPE = Registry.register(Registry.BLOCK_ENTITY_TYPE,
                new Identifier(Amethystvoid.MOD_ID, "amethyst_cleaner"),
                FabricBlockEntityTypeBuilder.create(AmethystCleanerBlockEntity::new, AMETHYST_ClEANER).build(null));
    }

}
