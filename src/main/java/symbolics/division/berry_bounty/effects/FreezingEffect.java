package symbolics.division.berry_bounty.effects;

//setInPowderSnow

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import symbolics.division.berry_bounty.registry.BBEffects;

public class FreezingEffect extends StatusEffect {
    public FreezingEffect() {
        // category: StatusEffectCategory - describes if the effect is helpful (BENEFICIAL), harmful (HARMFUL) or useless (NEUTRAL)
        // color: int - Color is the color assigned to the effect (in RGB)
        super(StatusEffectCategory.HARMFUL, 0xe9b8b3);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    @Override
    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
        //while the frozen effect is active, you are considered to be in powder snow regardless
        entity.setInPowderSnow(true);
        //if they can freeze, possibly freeze them faster/freeze them even more  !!
        //they can't freeze if they don't have leather armor/equivalent on

        //this quite literally does not affect us but i'm having it here just in case someone wants to make a Freezing II+
        if(entity.canFreeze())
        {
            entity.setFrozenTicks(Math.min(entity.getFrozenTicks() + amplifier,entity.getMinFreezeDamageTicks()));
        }
        return super.applyUpdateEffect(entity, amplifier);
    }
}
