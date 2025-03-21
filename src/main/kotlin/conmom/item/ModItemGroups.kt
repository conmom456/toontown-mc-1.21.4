package conmom.item

import conmom.block.ModBlocks
import conmom.toontownmc.ToontownMC
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.text.Text
import net.minecraft.util.Identifier

object ModItemGroups {
    val THROW = registerItemGroup("throw", "itemgroup.toontownmc.throw", ItemStack(ModItems.CUPCAKE), mutableListOf(
        ItemStack(ModItems.CUPCAKE),
        ItemStack(ModItems.CUPCAKE2)
    ))

    val MISC = registerItemGroup("misc", "itemgroup.toontownmc.misc", ItemStack(ModBlocks.MISSING_NO), mutableListOf(
        ItemStack(ModBlocks.MISSING_NO)))

    private fun registerItemGroup(path: String, translate: String, icon: ItemStack, items: MutableList<ItemStack>): ItemGroup? {
        val key = Identifier.of(ToontownMC.MOD_ID, path)
        val group = FabricItemGroup.builder()
            .icon { icon }
            .displayName(Text.translatable(translate))
            .entries { _: ItemGroup.DisplayContext, entries: ItemGroup.Entries ->
                entries.addAll(items)
            }
            .build()
        return Registry.register(Registries.ITEM_GROUP, key, group)
    }

    fun registerItemGroups() {
        ToontownMC.logger.info("Registering item groups for ${ToontownMC.MOD_ID}")
    }
}