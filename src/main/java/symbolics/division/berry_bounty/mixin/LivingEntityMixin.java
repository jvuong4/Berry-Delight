package symbolics.division.berry_bounty.mixin;

import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import net.minecraft.registry.entry.RegistryEntry;
import symbolics.division.berry_bounty.registry.BBEffects;


//ok so this does NOT work as intended so i'm gonna look at it again later
@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {
    @Shadow public abstract boolean hasStatusEffect(RegistryEntry<StatusEffect> effect);

    @WrapMethod(method = "takeKnockback")
    private void modifyKnockback(double strength, double x, double z, Operation<Void> original) {
        double newStrength = strength;
        if(this.hasStatusEffect(BBEffects.AIRY))
            newStrength *= 4;
        if(this.hasStatusEffect(BBEffects.HEAVY))
            newStrength /= 2;
        original.call(newStrength, x, z);
    }
}
