package ltd.matrixstudios.servertimizer.util.menu.buttons

import ltd.matrixstudios.servertimizer.util.menu.Button
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.event.inventory.ClickType

class SimpleActionButton(
    val material: Material,
    val description: MutableList<String>,
    val name: String, val data: Short,
) : Button() {

    lateinit var body: (Player, Int, ClickType) -> Unit

    override fun getMaterial(player: Player): Material {
        return material
    }

    override fun getDescription(player: Player): MutableList<String>? {
        return description
    }

    override fun getDisplayName(player: Player): String? {
        return name
    }

    override fun getData(player: Player): Short {
        return data
    }

    fun setClickAction(body: (Player, Int, ClickType) -> Unit) : SimpleActionButton
    {
        return this.apply { this.body = body }
    }

    override fun onClick(player: Player, slot: Int, type: ClickType) {
        body.invoke(player, slot, type)
    }
}