package footer.fmgm

import footer.fmgm.block.Blocks
import footer.fmgm.item.Items
import net.minecraft.world.item.CreativeModeTab
import net.minecraft.world.item.ItemStack
import net.minecraftforge.fml.common.Mod
import org.apache.logging.log4j.Level
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import thedarkcolour.kotlinforforge.forge.MOD_BUS

@Mod(GeneralMachinery.ID)
object GeneralMachinery {
    const val ID = "fmgm"

    private val LOGGER: Logger = LogManager.getLogger(ID)

    init {
        LOGGER.log(Level.INFO, "General Machinery")

        Blocks.bRegistry.register(MOD_BUS)
        Items.iRegistry.register(MOD_BUS)
    }

    val bTab = object : CreativeModeTab("fmgm_blocks") {
        override fun makeIcon(): ItemStack {
            return ItemStack(Blocks.crudeSteelBlock.get())
        }
    }
    val iTab = object : CreativeModeTab("fmgm_items") {
        override fun makeIcon(): ItemStack {
            return ItemStack(Items.crudeSteelIngot.get())
        }
    }
}