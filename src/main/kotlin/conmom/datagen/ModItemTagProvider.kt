package conmom.datagen

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider
import net.minecraft.registry.RegistryWrapper
import java.util.concurrent.CompletableFuture

class ModItemTagProvider(generator: FabricDataOutput,
                          registriesFuture: CompletableFuture<RegistryWrapper.WrapperLookup>?
) :
    FabricTagProvider.ItemTagProvider(generator, registriesFuture) {
    override fun configure(p0: RegistryWrapper.WrapperLookup?) {
//        implement pls
    }
}