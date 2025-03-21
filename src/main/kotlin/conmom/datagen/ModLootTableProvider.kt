package conmom.datagen

import conmom.block.ModBlocks
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider
import net.minecraft.registry.RegistryWrapper
import java.util.concurrent.CompletableFuture

class ModLootTableProvider(generator: FabricDataOutput,
                           registriesFuture: CompletableFuture<RegistryWrapper.WrapperLookup>?
) :
    FabricBlockLootTableProvider(generator, registriesFuture) {
    override fun generate() {
        addDrop(ModBlocks.MISSING_NO)
    }
}