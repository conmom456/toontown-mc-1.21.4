package conmom.item

import conmom.item.`throw`.Cupcake
import conmom.toontownmc.ToontownMC
import net.minecraft.component.type.FoodComponent
import net.minecraft.item.Item
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.RegistryKeys
import net.minecraft.util.Identifier

object ModItems {
    val CUPCAKE = registerItem("cupcake", Item(Item.Settings()
        .registryKey(getKey("cupcake"))))
    val CUPCAKE2 = registerItem("cupcake2", Cupcake(Item.Settings()
        .maxCount(10)
        .food(FoodComponent(2, 4F, false))
        .registryKey(getKey("cupcake2"))))

    private fun registerItem(name: String, item: Item): Item {
        val key = getKey(name)
        return Registry.register(Registries.ITEM, key, item)
    }

    private fun getKey(path: String): RegistryKey<Item>? {
        return RegistryKey.of(RegistryKeys.ITEM, Identifier.of(ToontownMC.MOD_ID, path))
    }

    fun registerModItems() {
        ToontownMC.logger.info("Registering mod items for ${ToontownMC.MOD_ID}")

        ModItemGroups.registerItemGroups()
    }
}