package symbolics.division.berry_bounty.berry;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.passive.FoxEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import symbolics.division.berry_bounty.berry.Berry;

import net.minecraft.entity.effect.StatusEffectInstance;
import symbolics.division.berry_bounty.registry.BBEffects;

public class FrostBerry extends Berry{
    public FrostBerry(Item.Settings settings) {
        super(settings);
    }

    @Override
    //the standard effect given to the user. effectively up to 6 extra seconds of oxygen
    public void strongEffect(LivingEntity target) {
        //immediately give user +140 freezing ticks (enough to start taking damage)
        target.setFrozenTicks(target.getFrozenTicks() + 140);
        //TODO: add freezing effect

        //give user fire res for 3 seconds
        target.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 60, 0));
    }

    @Override
    //what happens to all entities affected by the user eating this berry with convection
    //effectively 3.5 extra seconds of oxygen
    public void weakEffect(LivingEntity target) {
        //immediately give user +140 freezing ticks (enough to start taking damage)
        target.setFrozenTicks(target.getFrozenTicks() + 140);
        //TODO: add freezing effect

        //give user fire res for 2 seconds
        target.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 40, 0));
    }


}