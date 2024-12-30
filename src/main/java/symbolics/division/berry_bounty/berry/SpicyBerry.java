package symbolics.division.berry_bounty.berry;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.FoxEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import net.minecraft.entity.effect.StatusEffectInstance;
import symbolics.division.berry_bounty.registry.BBEffects;

import net.minecraft.util.math.Box;
import net.minecraft.util.TypeFilter;
import java.util.List;
import net.minecraft.entity.passive.FoxEntity;

/**
 * Eating this berry sets the user on fire for 2 seconds, which should deal one heart of damage overall
 *  Fire resistance/protection or being in water should help against this
 *
 * This berry also negates freezing, which can be useful in powdered snow
 */
public class SpicyBerry extends Item {
    public SpicyBerry(Item.Settings settings) {
        super(settings);
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        //burn for 2 seconds, deals 1 heart of damage
        if(user.getType() != EntityType.FOX)
            user.setOnFireFor(2);
        //instantly reduce freezing by 80 ticks
        int newFrozenTicks = user.getFrozenTicks() - 80;
        if(newFrozenTicks < 0)
            newFrozenTicks = 0;
        user.setFrozenTicks(newFrozenTicks);
        //give consumer warmth II effect for 4 seconds to halt the rate of freezing
        user.addStatusEffect(new StatusEffectInstance(BBEffects.WARMTH, 80, 1));

        //it spreads.
        //warm up nearby mobs too !!
        if(user.hasStatusEffect(BBEffects.CONVECTION))
        {
            int radius = 3 + user.getStatusEffect(BBEffects.CONVECTION).getAmplifier();
            Box myBox = new Box(user.getBlockPos()).expand(radius);
            List<LivingEntity> entityList = user.getWorld().getEntitiesByClass(LivingEntity.class,myBox,e->e.isAlive());
            entityList.remove(user);

            for(LivingEntity entity : entityList)
            {
                //burn for 1 seconds, deals 1/2 heart of damage
                if(entity.getType() != EntityType.FOX)
                    entity.setOnFireFor(1);
                //instantly reduce freezing by 40 ticks
                newFrozenTicks = entity.getFrozenTicks() - 40;
                if(newFrozenTicks < 0)
                    newFrozenTicks = 0;
                entity.setFrozenTicks(newFrozenTicks);
                //give consumer warmth I effect for 4 seconds to halve the rate of freezing
                entity.addStatusEffect(new StatusEffectInstance(BBEffects.WARMTH, 80, 1));
            }
        }


        return super.finishUsing(stack, world, user);
    }
}
