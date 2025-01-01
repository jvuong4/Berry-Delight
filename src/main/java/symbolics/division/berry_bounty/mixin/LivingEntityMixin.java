package symbolics.division.berry_bounty.mixin;


//LivingEntity.getAttributeValue
//(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE)

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.nbt.NbtCompound;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import symbolics.division.berry_bounty.registry.BBEffects;


import java.util.Map;
import symbolics.division.berry_bounty.BerryBounty;


//ok so this does NOT work as intended so i'm gonna look at it again later
@Mixin(LivingEntity.class)
public class LivingEntityMixin {

    /*
    @Inject(method = "takeKnockback", at = @At("Head"))
    private void boostStrength(@Local(ordinal = 0) double strength) {
        strength *= 2;
    }
     */

    /*
    @ModifyArg(method = "takeKnockback()V", at = @At(value = "INVOKE", target = "La/b/c/Something;takeKnockback(DDD)V"), index = 0)
    private double boostStrength(double strength) {
        return strength * 2;
    }
     */

    //@Shadow
    //private Map<StatusEffect,StatusEffectInstance> activeStatusEffects;

    //i think this was a failure
    /*
    private double calculateNewKB(double original, EntityAttribute attribute)
    {
        if (((LivingEntity)(Object)this).hasStatusEffect(BBEffects.AIRY) && attribute == EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE) {
        //if (attribute == EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE) {
            //System.out.println("Succeeded in Airy KBRes Reduction!");
            BerryBounty.LOGGER.debug("Succeeded in Airy KBRes Reduction!");
            return original - 100;
        }
        BerryBounty.LOGGER.debug("Did not succeed in Airy KBRes Reduction!");
        return original;
    }
    */


    /*
    @ModifyReturnValue(
            method = "getAttributeValue",
            at = @At("RETURN")
    )
    private double increaseKB(double original, @Local(ordinal = 0) RegistryEntry<EntityAttribute> REGattribute) {
        return calculateNewKB(original, REGattribute.value());
    }
    */


    //for some reason the code doesn't work while doing this
    /*
    @ModifyReturnValue(
            method = "Lnet/minecraft/entity/LivingEntity;getAttributeValue(Lnet/minecraft/entity/attribute/EntityAttribute;)D",
            at = @At("RETURN")
    )
    private double increaseKB(double original, @Local(ordinal = 0) EntityAttribute attribute) {
        return calculateNewKB(original, attribute);
    }
    */

}
