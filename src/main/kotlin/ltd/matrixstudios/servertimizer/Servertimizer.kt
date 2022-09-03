package ltd.matrixstudios.servertimizer

import co.aikar.commands.PaperCommandManager
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.LongSerializationPolicy
import ltd.matrixstudios.servertimizer.command.ServertimizerCommand
import ltd.matrixstudios.servertimizer.freeze.FrozenServerJsonConfig
import ltd.matrixstudios.servertimizer.freeze.events.FrozenServerSubscriber
import ltd.matrixstudios.servertimizer.tps.TPSTracker
import me.lucko.helper.plugin.ExtendedJavaPlugin
import me.lucko.helper.plugin.ap.Plugin

@Plugin(
    name = "Servertimizer",
    description = "Server optimization made simple and quick",
    version = "1.0.0",
    authors = ["Matrix Studios"]
)
class Servertimizer : ExtendedJavaPlugin()
{
    companion object
    {
        lateinit var instance: Servertimizer
    }

    val GSON: Gson = GsonBuilder()
        .serializeNulls()
        .setLongSerializationPolicy(LongSerializationPolicy.STRING)
        .setPrettyPrinting().create()

    override fun enable()
    {
        saveDefaultConfig()
        instance = this

        loadData()
        loadListeners()
        startTracking()

        loadCommands()
    }

    private fun startTracking()
    {
        (TPSTracker()).runTaskTimer(this, 1L, 1L)
    }

    private fun loadData()
    {
        FrozenServerJsonConfig.loadEntries()
    }

    private fun loadListeners()
    {
        FrozenServerSubscriber.loadAll()
    }

    private fun loadCommands()
    {
        val commandManager = PaperCommandManager(
            this
        ).apply {
            this.registerCommand(ServertimizerCommand())
        }

    }
}