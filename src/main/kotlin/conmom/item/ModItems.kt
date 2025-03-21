package conmom.item

import conmom.item.`throw`.Cupcake
import conmom.toontownmc.ToontownMC
import net.minecraft.item.Item
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.RegistryKeys
import net.minecraft.util.Identifier

object ModItems {
    val CUPCAKE = registerItem("cupcake", Item.Settings(), ItemTypes.DEFAULT)
    val CUPCAKE2 = registerItem("cupcake2", Item.Settings().maxCount(10), ItemTypes.THROW)

    private fun registerItem(name: String, itemSettings: Item.Settings, type: ItemTypes): Item {
        val key = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(ToontownMC.MOD_ID, name))
        val item: Item = if (type == ItemTypes.THROW) {
            Cupcake(itemSettings.registryKey(key))
        } else {
            Item(itemSettings.registryKey(key))
        }
        return Registry.register(Registries.ITEM, key, item)
    }

    fun registerModItems() {
        ToontownMC.logger.info("Registering mod items for ${ToontownMC.MOD_ID}")

        ModItemGroups.registerItemGroups()
    }
}