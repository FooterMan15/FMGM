package footer.fmgm.block

import footer.fmgm.GeneralMachinery
import footer.fmgm.item.Items
import net.minecraft.world.item.Item
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.state.BlockBehaviour
import net.minecraft.world.level.material.Material
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import net.minecraftforge.registries.RegistryObject

object Blocks {
    val bRegistry = DeferredRegister.create(ForgeRegistries.BLOCKS, GeneralMachinery.ID)
    val beRegistry = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, GeneralMachinery.ID)

    private fun registerBlock(
        name: String,
        material : Material,
        configureItemProperties: Item.Properties.() -> Unit = {},
        configureProperties: BlockBehaviour.Properties.() -> Unit = {
            strength(1.5F)
            explosionResistance(1.5F)
        }
    ): RegistryObject<Block> {
        val b = bRegistry.register(name) {
            Block(BlockBehaviour.Properties.of(material).apply(configureProperties))
        }
        Items.registerBlockItem(b, configureItemProperties)
        return b
    }


    val crudeSteelBlock = registerBlock("crude_steel_block", Material.METAL) {
        strength(4.0f)
    }
    val steelBlock = registerBlock("steel_block", Material.HEAVY_METAL) {
        strength(6.0F)
    }

    /* Tile */

    val crusherBlock = registerBlock("crusher", Material.METAL)
}