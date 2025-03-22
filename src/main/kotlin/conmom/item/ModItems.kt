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
//    Throw Gags
    val CUPCAKE = registerItem("cupcake", Cupcake(Item.Settings()
        .maxCount(10)
        .food(FoodComponent(2, 4F, false))
        .registryKey(getKey("cupcake"))))
    val FRUIT_PIE_SLICE = registerItem("fruit_pie_slice", Cupcake(Item.Settings()
        .maxCount(10)
        .food(FoodComponent(2, 4F, false))
        .registryKey(getKey("fruit_pie_slice"))))
    val CREAM_PIE_SLICE = registerItem("cream_pie_slice", Cupcake(Item.Settings()
        .maxCount(10)
        .food(FoodComponent(2, 4F, false))
        .registryKey(getKey("cream_pie_slice"))))
    val WHOLE_FRUIT_PIE = registerItem("whole_fruit_pie", Cupcake(Item.Settings()
        .maxCount(10)
        .food(FoodComponent(2, 4F, false))
        .registryKey(getKey("whole_fruit_pie"))))
    val WHOLE_CREAM_PIE = registerItem("whole_cream_pie", Cupcake(Item.Settings()
        .maxCount(10)
        .food(FoodComponent(2, 4F, false))
        .registryKey(getKey("whole_cream_pie"))))
    val BIRTHDAY_CAKE = registerItem("birthday_cake", Cupcake(Item.Settings()
        .maxCount(10)
        .food(FoodComponent(2, 4F, false))
        .registryKey(getKey("birthday_cake"))))
    val WEDDING_CAKE = registerItem("wedding_cake", Cupcake(Item.Settings()
        .maxCount(10)
        .food(FoodComponent(2, 4F, false))
        .registryKey(getKey("wedding_cake"))))



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