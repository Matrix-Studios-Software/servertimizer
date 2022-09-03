package ltd.matrixstudios.servertimizer.freeze

import ltd.matrixstudios.servertimizer.Servertimizer
import ltd.matrixstudios.servertimizer.freeze.model.FrozenServerEntry
import ltd.matrixstudios.servertimizer.heartbeat.ServerHeartbeat
import ltd.matrixstudios.servertimizer.tps.TPSTracker
import ltd.matrixstudios.servertimizer.util.Chat
import org.bukkit.Bukkit
import java.util.*

object FrozenServerService
{
    var serverFrozen = false

    fun commenceFreeze()
    {
        serverFrozen = true

        val entry = generateEntry()

        val config = Servertimizer.instance.config
        if (config.getBoolean("freezeServer.shouldWrite"))
        {
            FrozenServerJsonConfig.insertEntry(entry)
        }

        Bukkit.broadcastMessage(Chat.format("freezeServer.broadcast"))
    }

    fun generateEntry() : FrozenServerEntry
    {
        return FrozenServerEntry(
            UUID.randomUUID()
                .toString().substring(
                    4
                ),
            System.currentTimeMillis(),
            ServerHeartbeat(
                TPSTracker.TPS,
                System.currentTimeMillis()
            )
        )
    }
}