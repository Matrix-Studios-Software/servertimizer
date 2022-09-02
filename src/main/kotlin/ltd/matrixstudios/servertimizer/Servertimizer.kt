package ltd.matrixstudios.servertimizer

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.LongSerializationPolicy
import ltd.matrixstudios.servertimizer.freeze.FrozenServerJsonConfig
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
    }

    private fun loadData()
    {
        FrozenServerJsonConfig.loadEntries()
    }
}