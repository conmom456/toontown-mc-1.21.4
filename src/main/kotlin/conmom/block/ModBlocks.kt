package conmom.block

import conmom.toontownmc.ToontownMC
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.minecraft.block.AbstractBlock
import net.minecraft.block.Block
import net.minecraft.item.BlockItem
import net.minecraft.item.Item
import net.minecraft.item.ItemGroups
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.RegistryKeys
import net.minecraft.sound.BlockSoundGroup
import net.minecraft.util.Identifier


object ModBlocks {
    val MISSING_NO = registerBlock("missing_no", AbstractBlock.Settings.create().strength(4f)
        .requiresTool().sounds(BlockSoundGroup.MOSS_BLOCK).noBlockBreakParticles())


    private fun registerBlock(name: String, blockSettings: AbstractBlock.Settings): Block {
        val key = RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(ToontownMC.MOD_ID, name))
        val block = Block(blockSettings.registryKey(key))
        registerBlockItem(name, block)
        return Registry.register(Registries.BLOCK, key, block)
    }

    private fun registerBlockItem(name: String, block: Block) {
        val key = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(ToontownMC.MOD_ID, name))
        val item = BlockItem(block, Item.Settings().registryKey(key))
        Registry.register(Registries.ITEM, key, item)
    }

    fun registerModBlocks() {
        ToontownMC.logger.info("Registering mod blocks for ${ToontownMC.MOD_ID}")

//        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register { entries ->
//            entries.add(ModBlocks.MISSING_NO)
//        }
    }
}