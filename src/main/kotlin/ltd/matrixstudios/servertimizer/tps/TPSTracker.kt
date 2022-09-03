package ltd.matrixstudios.servertimizer.tps

import net.md_5.bungee.api.ChatColor
import org.bukkit.scheduler.BukkitRunnable
import java.lang.Exception
import java.text.DecimalFormat


class TPSTracker : BukkitRunnable() {

    override fun run()
    {
        TICKS[TICK_COUNT % TICKS.size] = System.currentTimeMillis()
        ++TICK_COUNT
    }

    companion object {
        private var TICK_COUNT = 0
        private val TICKS = LongArray(600)
        val TPS: Double
            get() = getTPS(100)

        fun getTPS(ticks: Int): Double
        {
            return try {
                if (TICK_COUNT < ticks)
                {
                    return 20.0
                }
                val target = (TICK_COUNT - 1 - ticks) % TICKS.size
                val elapsed = System.currentTimeMillis() - TICKS[target]
                ticks.toDouble() / (elapsed.toDouble() / 1000.0)
            } catch (e: Exception)
            {
                return 0.0
            }
        }

        fun formatTPS(tps: Double, color: Boolean): String
        {
            val format = DecimalFormat("##.##")
            val colour: ChatColor
            colour = if (tps >= 18.0)
            {
                ChatColor.GREEN
            } else {
                if (tps >= 15.0)
                {
                    ChatColor.YELLOW
                } else {
                    ChatColor.RED
                }
            }
            val tpsnew = format.format(tps)
            return (if (color) colour else "").toString() + tpsnew
        }
    }
}