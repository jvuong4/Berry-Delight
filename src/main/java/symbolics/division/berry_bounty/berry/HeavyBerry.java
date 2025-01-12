package symbolics.division.berry_bounty.berry;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import symbolics.division.berry_bounty.registry.BBEffects;

public class HeavyBerry extends Berry {
    public HeavyBerry(Item.Settings settings) {
        super(settings);
    }

    @Override
    //the standard effect given to the user
    public void strongEffect(LivingEntity user) {
        //extra filling when eaten
        if(user.getType() == EntityType.PLAYER) {
            //sweet berries akready give +2 food, +0.4 saturation.
            //this gives a net +4 food, +9.6 saturation
            ((PlayerEntity) user).getHungerManager().setFoodLevel(((PlayerEntity) user).getHungerManager().getFoodLevel() +3);
            ((PlayerEntity) user).getHungerManager().setSaturationLevel(((PlayerEntity) user).getHungerManager().getSaturationLevel() + 9.2f);
        }
        //give consumer heavy II and resistance 2 (40% damage reduction) and effect for 5 seconds
        user.addStatusEffect(new StatusEffectInstance(BBEffects.HEAVY, 100, 1));
        user.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 100, 1));
    }

    @Override
    //what happens to all entities affected by the user eating this berry with convection
    public void weakEffect(LivingEntity entity) {
        //extra filling when eaten
        if(entity.getType() == EntityType.PLAYER) {
            //sweet berries akready give +2 food, +0.4 saturation.
            //this gives a net +4 food, +9.6 saturation
            ((PlayerEntity) entity).getHungerManager().setFoodLevel(((PlayerEntity) entity).getHungerManager().getFoodLevel() +3);
            ((PlayerEntity) entity).getHungerManager().setSaturationLevel(((PlayerEntity) entity).getHungerManager().getSaturationLevel() + 9.2f);
        }
        //give consumer heavy and resistance (20% damage reduction) and effect for 4 seconds
        entity.addStatusEffect(new StatusEffectInstance(BBEffects.HEAVY, 80, 0));
        entity.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 80, 0));
    }
}