package symbolics.division.berry_bounty.effects;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import symbolics.division.berry_bounty.registry.BBEffects;

public class AiryEffect extends StatusEffect{
    public AiryEffect() {
        // category: StatusEffectCategory - describes if the effect is helpful (BENEFICIAL), harmful (HARMFUL) or useless (NEUTRAL)
        // color: int - Color is the color assigned to the effect (in RGB)
        super(StatusEffectCategory.BENEFICIAL, 0xe9b8b3);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    @Override
    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
        //while the airy effect is active, fall damage isn't considered/calculated
        entity.fallDistance = 0; //there's probably a better way to handle it than this

        //checks if entity is on the ground. If so, remove the status effect prematurely.
        //This does not affect foxes though :P
        if(entity.isOnGround() && entity.getType() != EntityType.FOX && entity.getVelocity().getY() <=0) {
            //onRemoved(entity, entity.getAttributes(), amplifier);
            entity.removeStatusEffect(BBEffects.AIRY);
        }
        return super.applyUpdateEffect(entity, amplifier);
    }
}