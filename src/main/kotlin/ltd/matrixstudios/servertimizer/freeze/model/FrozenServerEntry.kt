package ltd.matrixstudios.servertimizer.freeze.model

import ltd.matrixstudios.servertimizer.heartbeat.ServerHeartbeat

data class FrozenServerEntry(
    var uniqueId: String,
    var executed: Long,
    var heartbeat: ServerHeartbeat
)