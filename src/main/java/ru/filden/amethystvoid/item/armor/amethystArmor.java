package ru.filden.amethystvoid.item.armor;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

public class amethystArmor implements ArmorMaterial {

    private static final int[] BASE_DURABILITY = new int[] {456, 678, 578, 556};
    private static final int[] PROTECTION_VALUES = new int[] {2, 4, 4, 3};
    @Override
    public int getDurability(EquipmentSlot slot) {
        return BASE_DURABILITY[slot.getEntitySlotId()];
    }

    @Override
    public int getProtectionAmount(EquipmentSlot slot) {
        return PROTECTION_VALUES[slot.getEntitySlotId()];
    }

    @Override
    public int getEnchantability() {
        return 0;
    }

    @Override
    public SoundEvent getEquipSound() {
        return SoundEvents.BLOCK_AMETHYST_BLOCK_BREAK;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return null;
    }

    @Override
    public String getName() {
        return "amethyst_armor";
    }

    @Override
    public float getToughness() {
        return 0.1f;
    }

    @Override
    public float getKnockbackResistance() {
        return 0;
    }
}

