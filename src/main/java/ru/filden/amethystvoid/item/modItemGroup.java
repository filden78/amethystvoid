package ru.filden.amethystvoid.item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import ru.filden.amethystvoid.Amethystvoid;

public class modItemGroup {
    public static final ItemGroup AMETHYST_VOID_GROUP = FabricItemGroupBuilder.build(new Identifier(Amethystvoid.MOD_ID, "amethyst_void"),()-> new ItemStack(Items.AMETHYST_CLUSTER));
}
