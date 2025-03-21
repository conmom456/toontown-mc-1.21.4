package conmom.datagen

import conmom.block.ModBlocks
import conmom.item.ModItems
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.minecraft.client.data.BlockStateModelGenerator
import net.minecraft.client.data.ItemModelGenerator
import net.minecraft.client.data.Models

class ModModelProvider(generator: FabricDataOutput) :
    FabricModelProvider(generator) {
    override fun generateBlockStateModels(blockStateModelGenerator: BlockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MISSING_NO)
    }

    override fun generateItemModels(itemModelGenerator: ItemModelGenerator) {
        itemModelGenerator.register(ModItems.CUPCAKE, Models.GENERATED)
        itemModelGenerator.register(ModItems.CUPCAKE2, Models.GENERATED)
    }
}