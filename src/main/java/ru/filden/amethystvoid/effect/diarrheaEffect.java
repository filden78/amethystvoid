package ru.filden.amethystvoid.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;



public class diarrheaEffect extends StatusEffect {
    private int duration;
    public diarrheaEffect() {
        super(StatusEffectCategory.HARMFUL,0x8B4513);
    }
    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        this.duration = duration;
        return true;
    }
    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity instanceof PlayerEntity) {
            ((PlayerEntity) entity).damage(DIARRHEA, 0.2f);
            if(!entity.getActiveStatusEffects().containsKey(StatusEffects.NAUSEA)){
                    entity.setStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, duration, 5,true,false, false), null);
                }
            if(!entity.getActiveStatusEffects().containsKey(StatusEffects.HUNGER)) {
                entity.setStatusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 200, 1,true,false, false), null);

                }
            }
        }
    private static final DamageSource DIARRHEA = new DamageSource("diarrhea");
}


