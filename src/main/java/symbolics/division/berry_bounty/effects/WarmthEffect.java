package symbolics.division.berry_bounty.effects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

/**
 *  Warmth is granted when eating spicy berries or food that explicitly uses spicy berries.
 *
 *  Every other tick, it'll reduce freezing based on the amplifier.
 *
 *  Warmth I   cuts the rate of freezing in half
 *  Warmth II  negates the rate of freezing
 *  Warmth III and above will warm the player up faster than they can be frozen
*/
public class WarmthEffect extends StatusEffect {
    public WarmthEffect() {
        // category: StatusEffectCategory - describes if the effect is helpful (BENEFICIAL), harmful (HARMFUL) or useless (NEUTRAL)
        // color: int - Color is the color assigned to the effect (in RGB)
        super(StatusEffectCategory.BENEFICIAL, 0xe9b8b3);
    }

    // Called every tick to check if the effect can be applied or not
    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        // Applies the effect every other tick
        return duration % 2 == 0;
    }

    // Called when the effect is applied.
    @Override
    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
        //with Warming I, don't try to unfreeze anymore while fully frozen.
        //otherwise, the game will stagger between displaying normal and frozen hearts and look ugly :(
        if(amplifier == 0 && entity.getFrozenTicks() == 140)
            return super.applyUpdateEffect(entity, amplifier);

        //reduces freezing based on ticks. freezing cannot go below 0.
        int newFrozenTicks = entity.getFrozenTicks() - 1 - amplifier;
        if(newFrozenTicks < 0)
            newFrozenTicks = 0;
        entity.setFrozenTicks(newFrozenTicks);

        return super.applyUpdateEffect(entity, amplifier);
    }
}
