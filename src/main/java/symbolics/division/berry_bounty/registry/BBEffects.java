package symbolics.division.berry_bounty.registry;

import net.fabricmc.api.ModInitializer;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.entity.effect.StatusEffect;

import symbolics.division.berry_bounty.effects.ConvectionEffect;
import symbolics.division.berry_bounty.effects.WarmthEffect;
import symbolics.division.berry_bounty.effects.AiryEffect;
import symbolics.division.berry_bounty.effects.FreezingEffect;

public class BBEffects implements ModInitializer {
    public static final RegistryEntry<StatusEffect> WARMTH;
    public static final RegistryEntry<StatusEffect> CONVECTION;
    public static final RegistryEntry<StatusEffect> AIRY;
    public static final RegistryEntry<StatusEffect> FREEZING;

    static {
        WARMTH = Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of("berry_bounty", "warmth"), new WarmthEffect());
        CONVECTION = Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of("berry_bounty", "convection"), new ConvectionEffect());
        AIRY = Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of("berry_bounty", "airy"), new AiryEffect());
        FREEZING = Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of("berry_bounty", "freezing"), new FreezingEffect());
    }

    @Override
    public void onInitialize() {
        // ...
    }

    public static void init() {}
}