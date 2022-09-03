package ltd.matrixstudios.servertimizer.freeze.events

import ltd.matrixstudios.servertimizer.Servertimizer
import ltd.matrixstudios.servertimizer.freeze.FrozenServerService
import ltd.matrixstudios.servertimizer.util.Chat
import me.lucko.helper.Events
import org.bukkit.event.player.PlayerMoveEvent

class FrozenServerSubscriber {
    companion object
    {
        fun loadAll()
        {
            val frozen = FrozenServerService.serverFrozen

            Events.subscribe(PlayerMoveEvent::class.java)
                .filter { frozen }
                .handler {
                    val from = it.from
                    val to = it.to!!

                    if (it.player.hasPermission("servertimier.freeze.bypass"))
                    {
                        return@handler
                    }

                    if (to.x != from.x || to.y != from.y)
                    {
                        it.isCancelled = true

                        val config = Servertimizer.instance.config
                        if (config.getBoolean("freezeServer.players.sendMessageToPlayer"))
                        {
                            it.player.sendMessage(Chat.format(config.getString("freezeServer.players.messageToSend")))
                        }
                    }
                }
        }
    }
}