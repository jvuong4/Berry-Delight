package symbolics.division.berry_bounty.berry;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.passive.FoxEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import net.minecraft.entity.effect.StatusEffectInstance;
import symbolics.division.berry_bounty.registry.BBEffects;

import net.minecraft.util.math.Box;
import net.minecraft.util.TypeFilter;
import java.util.List;
import net.minecraft.entity.passive.FoxEntity;

public class AiryBerry extends Berry {
    public AiryBerry(Item.Settings settings) {
        super(settings);
    }

    @Override
    //the standard effect given to the user
    public void strongEffect(LivingEntity target) {
        //get launched into the air!! yay :D
        Vec3d vel= target.getVelocity();
        double newYVel = vel.getY() + 2;
        if(newYVel < 2)
            newYVel = 2;
        target.setVelocity(vel.getX(), newYVel, vel.getZ());
        //give consumer slow falling and speed 4 effect for 6 seconds
        target.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOW_FALLING, 120, 0));
        target.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 120, 3));
    }

    @Override
    //what happens to all entities affected by the user eating this berry with convection
    public void weakEffect(LivingEntity target) {
        //get launched into the air!! yay :D
        Vec3d vel= target.getVelocity();
        double newYVel = vel.getY() + 1.75;
        if(newYVel < 1.75)
            newYVel = 1.75;
        target.setVelocity(vel.getX(), newYVel, vel.getZ());
        //give consumer slow falling and speed 2 effect for 5 seconds
        target.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOW_FALLING, 100, 0));
        target.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 100, 1));
    }
}

