package symbolics.division.berry_bounty.effects;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.util.math.Vec3d;
import symbolics.division.berry_bounty.registry.BBEffects;

public class HeavyEffect extends StatusEffect {
    public HeavyEffect() {
        // category: StatusEffectCategory - describes if the effect is helpful (BENEFICIAL), harmful (HARMFUL) or useless (NEUTRAL)
        // color: int - Color is the color assigned to the effect (in RGB)
        super(StatusEffectCategory.NEUTRAL, 0xe9b8b3);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    @Override
    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
        //while the heavy effect is active, foxes take no fall damage
        if(entity.getType() == EntityType.FOX) entity.fallDistance = 0;
        //accelerate downwards, and (if not a fox) slow down horizontal movement
        Vec3d vel= entity.getVelocity();
        entity.setVelocity(entity.getType() != EntityType.FOX ? vel.getX() * (0.98 - 0.2 * amplifier) : vel.getX(),
                vel.getY() - 0.05 * amplifier,
                entity.getType() != EntityType.FOX ? vel.getZ() * (0.98 - 0.2 * amplifier) : vel.getZ());
        return super.applyUpdateEffect(entity, amplifier);
    }
}