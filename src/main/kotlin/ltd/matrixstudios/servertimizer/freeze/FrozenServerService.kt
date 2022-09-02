package ltd.matrixstudios.servertimizer.freeze

import ltd.matrixstudios.servertimizer.freeze.model.FrozenServerEntry
import ltd.matrixstudios.servertimizer.heartbeat.ServerHeartbeat
import java.util.*

object FrozenServerService
{
    private var serverFrozen = false

    fun commenceFreeze()
    {
        serverFrozen = true

        val entry = generateEntry()
        FrozenServerJsonConfig.insertEntry(entry)
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
                20.0,
                System.currentTimeMillis()
            )
        )
    }
}