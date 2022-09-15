package ltd.matrixstudios.servertimizer.command.menu

import ltd.matrixstudios.servertimizer.freeze.menus.FreezeEntryMenu
import ltd.matrixstudios.servertimizer.util.menu.Button
import ltd.matrixstudios.servertimizer.util.menu.Menu
import ltd.matrixstudios.servertimizer.util.menu.buttons.PlaceholderButton
import ltd.matrixstudios.servertimizer.util.menu.buttons.SimpleActionButton
import org.bukkit.Material
import org.bukkit.entity.Player

class MetricsMenu(val player: Player) : Menu(18, player) {
    override fun getButtons(player: Player): MutableMap<Int, Button> {
        val buttons = hashMapOf<Int, Button>()
        buttons[0] = SimpleActionButton(
            Material.ICE,
            mutableListOf(),
            "&bFrozen Server Entries",
            0
        ).setClickAction { player, i, clickType ->
            FreezeEntryMenu(player).updateMenu()
        }

        return buttons
    }

    override fun getTitle(player: Player): String {
        return "Metrics Menu"
    }
}