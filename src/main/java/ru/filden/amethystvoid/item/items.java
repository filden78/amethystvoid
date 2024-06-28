package ru.filden.amethystvoid.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import ru.filden.amethystvoid.Amethystvoid;
import ru.filden.amethystvoid.item.armor.amethystArmor;


public class items {
    public static final ArmorMaterial AMETHYST_ARMOR = new amethystArmor();
    private static Item registryItem(String name, Item item){
        return Registry.register(Registry.ITEM, new Identifier(Amethystvoid.MOD_ID, name),item);
    }
    /*

    */
    public static final Item TEA_ITEM = registryItem("tea", new Item(new FabricItemSettings().group(modItemGroup.AMETHYST_VOID_GROUP)));
    public static final Item PURE_AMETHYST = registryItem("pure_amethyst", new Item(new FabricItemSettings().group(modItemGroup.AMETHYST_VOID_GROUP)));
    public static final Item CUP = registryItem("cup", new Item(new FabricItemSettings().group(modItemGroup.AMETHYST_VOID_GROUP)));
    public static final Item TEA_CUP;

    static {
        TEA_CUP = registryItem("tea_cup", new Item(new FabricItemSettings().group(modItemGroup.AMETHYST_VOID_GROUP).food(new FoodComponent.Builder().hunger(1).saturationModifier(0.5F).statusEffect(new StatusEffectInstance(Amethystvoid.APPEASEMENT, 400), 1.0f).build())));
    }

    public static final Item BAD_TEA_CUP = registryItem("bad_tea", new Item(new FabricItemSettings().group(modItemGroup.AMETHYST_VOID_GROUP).food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).statusEffect(new StatusEffectInstance(Amethystvoid.DIARRHEA, 400), 0.9f).build())));

    public static final Item AMETHYST_HELMET = registryItem("amethyst_helmet", new ArmorItem(AMETHYST_ARMOR, EquipmentSlot.HEAD,new FabricItemSettings().group(modItemGroup.AMETHYST_VOID_GROUP)));
    public static final Item AMETHYST_CHEST = registryItem("amethyst_chest", new ArmorItem(AMETHYST_ARMOR, EquipmentSlot.CHEST,new FabricItemSettings().group(modItemGroup.AMETHYST_VOID_GROUP)));
    public static final Item AMETHYST_LEGS = registryItem("amethyst_legs", new ArmorItem(AMETHYST_ARMOR, EquipmentSlot.LEGS,new FabricItemSettings().group(modItemGroup.AMETHYST_VOID_GROUP)));
    public static final Item AMETHYST_BOOTS = registryItem("amethyst_boots", new ArmorItem(AMETHYST_ARMOR, EquipmentSlot.FEET,new FabricItemSettings().group(modItemGroup.AMETHYST_VOID_GROUP)));


    public static void init(){}
}
