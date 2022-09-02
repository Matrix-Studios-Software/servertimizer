package ltd.matrixstudios.servertimizer.freeze

import com.google.common.io.Files
import com.google.gson.reflect.TypeToken
import ltd.matrixstudios.servertimizer.Servertimizer
import ltd.matrixstudios.servertimizer.freeze.model.FrozenServerEntry
import java.io.File
import java.lang.reflect.Type

object FrozenServerJsonConfig
{
    var frozenServerEntries = mutableListOf<FrozenServerEntry>()

    val CONFIG_TYPE: Type = object : TypeToken<MutableList<FrozenServerEntry>>() {}.type

    fun loadEntries()
    {
        val file = File(Servertimizer.instance.dataFolder, "frozen-server-data.json")

        if (file.exists())
        {
            val reader = Files.newReader(file, Charsets.UTF_8)

            if (reader != null) {
                Servertimizer.instance.GSON.fromJson<
                        MutableList<FrozenServerEntry>
                        >(
                    reader, CONFIG_TYPE
                ).forEach {
                    frozenServerEntries.add(it)
                }
            }
        } else
        {
            file.createNewFile()

            Files.write(
                Servertimizer.instance.GSON.toJson
                    (
                    frozenServerEntries,
                    CONFIG_TYPE
                ), file,
                Charsets.UTF_8
            )
        }
    }

    fun insertEntry(entry: FrozenServerEntry)
    {
        val file = File(Servertimizer.instance.dataFolder, "reclaimed-players.json")


        frozenServerEntries.add(entry)


        if (file.exists())
        {
            Files.write(
               Servertimizer.instance.GSON.toJson
                    (
                    frozenServerEntries,
                    CONFIG_TYPE
                ), file,
                Charsets.UTF_8
            )

        }
    }
}