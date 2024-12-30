package symbolics.division.berry_bounty.registry;

import net.fabricmc.api.ModInitializer;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.entity.effect.StatusEffect;

import symbolics.division.berry_bounty.effects.ConvectionEffect;
import symbolics.division.berry_bounty.effects.WarmthEffect;

public class BBEffects implements ModInitializer {
    public static final RegistryEntry<StatusEffect> WARMTH;
    public static final RegistryEntry<StatusEffect> CONVECTION;

    static {
        WARMTH = Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of("berry_bounty", "warmth"), new WarmthEffect());
        CONVECTION = Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of("berry_bounty", "convection"), new ConvectionEffect());
    }

    @Override
    public void onInitialize() {
        // ...
    }

    public static void init() {}
}