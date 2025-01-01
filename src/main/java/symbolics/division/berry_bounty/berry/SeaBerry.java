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

public class SeaBerry extends Berry{
    public SeaBerry(Item.Settings settings) {
        super(settings);
    }

    private void addAir(LivingEntity target, int air)
    {
        target.setAir((target.getAir() + air < target.getMaxAir()) ? target.getAir() + air : target.getMaxAir());
    }

    @Override
    //the standard effect given to the user. effectively up to 6 extra seconds of oxygen
    public void strongEffect(LivingEntity target) {
        //immediately give user +60 ticks (2 air bubbles/3 seconds) of oxygen
        addAir(target,60);
        //give user water breathing for 3 seconds
        target.addStatusEffect(new StatusEffectInstance(StatusEffects.WATER_BREATHING, 60, 0));
    }

    @Override
    //what happens to all entities affected by the user eating this berry with convection
    //effectively 3.5 extra seconds of oxygen
    public void weakEffect(LivingEntity target) {
        //immediately give user +30 ticks (1 air bubbles/1.5 seconds) of oxygen
        addAir(target,30);
        //give user water breathing for 2 seconds
        target.addStatusEffect(new StatusEffectInstance(StatusEffects.WATER_BREATHING, 40, 0));
    }


}
