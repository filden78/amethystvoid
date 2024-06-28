package ru.filden.amethystvoid.dimension;


import net.minecraft.util.Identifier;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.util.registry.Registry;

import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;
import ru.filden.amethystvoid.Amethystvoid;


public class ModDimension {
    public static final RegistryKey<World> AVDIM_LEVEL_KEY = RegistryKey.of(Registry.WORLD_KEY, new Identifier(Amethystvoid.MOD_ID, "avdim"));
    public static final RegistryKey<DimensionType> AVDIM_TYPE = RegistryKey.of(Registry.DIMENSION_TYPE_KEY, new Identifier(Amethystvoid.MOD_ID, "avdimt"));


    public static void init(){}
}
