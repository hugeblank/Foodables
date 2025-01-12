package truth.foodables.registry;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import truth.foodables.Foodables;

public class FoodableConfiguredFeatures {
    // ConfiguredFeatures methods that apply Foodables own ID.
    // Ripped straight from Bagel's Baking - https://github.com/hugeblank/bagels-baking/
    // ~ hugeblank - June 2022
    public static <FC extends FeatureConfig, F extends Feature<FC>> RegistryEntry<ConfiguredFeature<?, ?>> register(String name, F feature, FC config) {
        RegistryKey<ConfiguredFeature<?, ?>> registryKey = RegistryKey.of(BuiltinRegistries.CONFIGURED_FEATURE.getKey(), new Identifier(Foodables.MOD_ID, name));
        return BuiltinRegistries.add(BuiltinRegistries.CONFIGURED_FEATURE, registryKey, new ConfiguredFeature<>(feature, config));
    }
}
