package symbolics.division.berry_bounty.berry;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;

public class BeastBerry extends Berry {
    public BeastBerry(Item.Settings settings) {
        super(settings);
    }

    @Override
    //the standard effect given to the user
    public void strongEffect(LivingEntity target) {
        //give consumer HUNGER 120 !!!! for 1 second :p
        //honnggrrryyyyy (reduces saturation by 3, for a net total of +2.4-3= -0.6 saturation overall)
        //this berry makes you hungrier than before you ate it...
        target.addStatusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 20, 119));
        //give strength 3 for 3 seconds (+9 damage per hit !! yikes)
        target.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 60, 2));
    }

    @Override
    //what happens to all entities affected by the user eating this berry with convection
    public void weakEffect(LivingEntity target) {
        //give consumer HUNGER 80 !!!! for 1 second :p
        //honnggrrryyyyy (reduces saturation by 2, for a net total of +2.4-2= +0.4 saturation overall)
        target.addStatusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 20, 79));
        //give strength 2 for 3 seconds (+6 damage per hit !! yikes)
        target.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 60, 1));
    }
}
