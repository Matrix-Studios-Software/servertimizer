package ltd.matrixstudios.servertimizer.freeze.menus

import ltd.matrixstudios.servertimizer.freeze.FrozenServerJsonConfig
import ltd.matrixstudios.servertimizer.freeze.model.FrozenServerEntry
import ltd.matrixstudios.servertimizer.tps.TPSTracker
import ltd.matrixstudios.servertimizer.util.Chat
import ltd.matrixstudios.servertimizer.util.menu.Button
import ltd.matrixstudios.servertimizer.util.menu.pagination.PaginatedMenu
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.event.inventory.ClickType
import java.util.Date

class FreezeEntryMenu(val player: Player) : PaginatedMenu(18, player) {

    override fun getPagesButtons(player: Player): MutableMap<Int, Button> {
        val buttons = hashMapOf<Int, Button>()

        var index = 0

        for (entry in FrozenServerJsonConfig.frozenServerEntries)
        {
            buttons[index++] = EntryButton(entry)
        }

        return buttons
    }

    override fun getTitle(player: Player): String {
        return "Viewing All Entries"
    }

    class EntryButton(val entry: FrozenServerEntry) : Button()
    {
        override fun getMaterial(player: Player): Material {
            return Material.ICE
        }

        override fun getDescription(player: Player): MutableList<String>? {
            val desc = mutableListOf<String>()
            desc.add(" ")
            desc.add(Chat.format("&dAt: &f" + Date(entry.executed)))
            desc.add(Chat.format("&dTPS At Time: &f" + TPSTracker.formatTPS(entry.heartbeat.tps, true)))
            desc.add(" ")
            return desc
        }

        override fun getDisplayName(player: Player): String? {
            return Chat.format("&5" + entry.uniqueId)
        }

        override fun getData(player: Player): Short {
            return 0
        }

        override fun onClick(player: Player, slot: Int, type: ClickType) {
            return
        }


    }
}