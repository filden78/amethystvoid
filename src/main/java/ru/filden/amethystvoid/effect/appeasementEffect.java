package ru.filden.amethystvoid.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;

public class appeasementEffect extends StatusEffect {
    public appeasementEffect() {
        super(StatusEffectCategory.HARMFUL,0xE0FFFF);
    }
    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        entity.setMovementSpeed(entity.getMovementSpeed()+1.0f);
        entity.heal(0.01f);
    }
}

