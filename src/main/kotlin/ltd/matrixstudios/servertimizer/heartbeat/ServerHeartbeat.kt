package ltd.matrixstudios.servertimizer.heartbeat

data class ServerHeartbeat(
    var tps: Double,
    var time: Long,
)