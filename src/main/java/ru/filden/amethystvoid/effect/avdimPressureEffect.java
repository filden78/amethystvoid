package ru.filden.amethystvoid.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;

public class avdimPressureEffect extends StatusEffect{
    public avdimPressureEffect(){
        super(
                StatusEffectCategory.HARMFUL,0x4B0082);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity instanceof PlayerEntity) {
            ((PlayerEntity) entity).damage(PRESSURE, 3.0f);
        }
    }
    private static final DamageSource PRESSURE = new DamageSource("pressure");
}
