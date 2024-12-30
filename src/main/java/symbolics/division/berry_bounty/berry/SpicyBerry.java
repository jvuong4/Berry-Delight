package symbolics.division.berry_bounty.berry;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import net.minecraft.entity.effect.StatusEffectInstance;
import symbolics.division.berry_bounty.registry.BBEffects;


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
        user.setOnFireFor(2);
        //instantly reduce freezing by 70 ticks
        int newFrozenTicks = user.getFrozenTicks() - 70;
        if(newFrozenTicks < 0)
            newFrozenTicks = 0;
        user.setFrozenTicks(newFrozenTicks);
        //give consumer warmth i effect for 7 seconds to halve the rate of freezing
        user.addStatusEffect(new StatusEffectInstance(BBEffects.WARMTH, 140, 0));
        return super.finishUsing(stack, world, user);
    }
}
