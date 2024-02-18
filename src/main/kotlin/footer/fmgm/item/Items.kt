package footer.fmgm.item

import footer.fmgm.GeneralMachinery
import footer.fmgm.GeneralMachinery.bTab
import footer.fmgm.GeneralMachinery.iTab
import net.minecraft.world.item.BlockItem
import net.minecraft.world.item.Item
import net.minecraft.world.level.block.Block
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import net.minecraftforge.registries.RegistryObject

object Items {
    val iRegistry: DeferredRegister<Item> = DeferredRegister.create(ForgeRegistries.ITEMS, GeneralMachinery.ID)

    fun registerBlockItem(
        block: RegistryObject<Block>,
        configureItemProperties: Item.Properties.() -> Unit = {}
    ): RegistryObject<BlockItem>? {
        return iRegistry.register(block.id.path) {
            BlockItem(block.get(), Item.Properties().apply(configureItemProperties).tab(bTab))
        }
    }

    private fun registerItem(
        name: String,
        configureProperties: Item.Properties.() -> Unit
    ): RegistryObject<Item> {
        val i = iRegistry.register(name) {
            Item(Item.Properties().apply(configureProperties).tab(iTab))
        }
        return i
    }

    val crudeSteelIngot = registerItem("crude_steel_ingot") {}
    val steelIngot = registerItem("steel_ingot") {}
}