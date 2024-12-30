package symbolics.division.berry_bounty.effects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;


/**
 * When eating special berries while having the convection effect,
 *      some of the berries' effects will be transferred to nearby entities.
 *
 * Effect Radius = 3 + amp blocks (min 3 blocks)
 *
 */
public class ConvectionEffect extends StatusEffect {
    public ConvectionEffect() {
        // category: StatusEffectCategory - describes if the effect is helpful (BENEFICIAL), harmful (HARMFUL) or useless (NEUTRAL)
        // color: int - Color is the color assigned to the effect (in RGB)
        super(StatusEffectCategory.BENEFICIAL, 0xe9b8b3);
    }

    // Called every tick to check if the effect can be applied or not
    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        // Applies the effect never
        return false;
    }

    // Called when the effect is applied.
    @Override
    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
        //go girl give us nothing !!
        return super.applyUpdateEffect(entity, amplifier);
    }
}
