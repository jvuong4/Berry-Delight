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

abstract class Berry extends Item {
    public Berry(Settings settings) {
        super(settings);
    }

    //the standard effect given to the user
    abstract void strongEffect(LivingEntity target);
    //what happens to all entities affected by the user eating this berry with convection
    abstract void weakEffect(LivingEntity target);

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        //it spreads.
        if(user.hasStatusEffect(BBEffects.CONVECTION))
        {
            int radius = 3 + user.getStatusEffect(BBEffects.CONVECTION).getAmplifier();
            Box myBox = new Box(user.getBlockPos()).expand(radius);
            List<LivingEntity> entityList = user.getWorld().getEntitiesByClass(LivingEntity.class,myBox,e->e.isAlive());

            for(LivingEntity entity : entityList)
            {
                weakEffect(entity);
            }
        }
        //standard effect when the user doesn't have convection
        else {
            strongEffect(user);
        }
        return super.finishUsing(stack, world, user);
    }
}
