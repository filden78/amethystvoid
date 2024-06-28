package ru.filden.amethystvoid.dimension;

import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import ru.filden.amethystvoid.Amethystvoid;

public class ModBiome {
    public static final RegistryKey<Biome> AV_LOW_BIOME = RegistryKey.of(Registry.BIOME_KEY, new Identifier(Amethystvoid.MOD_ID, "avlowbiome"));
    public static final RegistryKey<Biome> AV_HIGH_BIOME = RegistryKey.of(Registry.BIOME_KEY, new Identifier(Amethystvoid.MOD_ID, "avhighbiome"));
    public static void init(){}
}
