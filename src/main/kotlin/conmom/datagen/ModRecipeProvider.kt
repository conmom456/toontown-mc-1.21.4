package conmom.datagen

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider
import net.minecraft.data.recipe.RecipeExporter
import net.minecraft.data.recipe.RecipeGenerator
import net.minecraft.registry.RegistryKeys
import net.minecraft.registry.RegistryWrapper
import java.util.concurrent.CompletableFuture


class ModRecipeProvider(generator: FabricDataOutput, registriesFuture: CompletableFuture<RegistryWrapper.WrapperLookup>?):
    FabricRecipeProvider(generator, registriesFuture) {
    override fun getName(): String {
        return "ToontownMCRecipeProvider"
    }

    override fun getRecipeGenerator(registryLookup: RegistryWrapper.WrapperLookup?, exporter: RecipeExporter?): RecipeGenerator {
        return object : RecipeGenerator(registryLookup, exporter) {
            override fun generate() {
                val itemLookup = registries.getOrThrow(RegistryKeys.ITEM)
            }
        }
    }
}