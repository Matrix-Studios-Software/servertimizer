package ltd.matrixstudios.servertimizer.command.menu

import ltd.matrixstudios.servertimizer.util.menu.Button
import ltd.matrixstudios.servertimizer.util.menu.Menu
import org.bukkit.entity.Player

class MetricsMenu(val player: Player) : Menu(18, player) {
    override fun getButtons(player: Player): MutableMap<Int, Button> {
        val buttons = hashMapOf<Int, Button>()

        return buttons
    }

    override fun getTitle(player: Player): String {
        return "Metrics Menu"
    }
}