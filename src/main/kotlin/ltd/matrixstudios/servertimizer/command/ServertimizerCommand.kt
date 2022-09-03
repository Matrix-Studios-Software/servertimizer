package ltd.matrixstudios.servertimizer.command

import co.aikar.commands.BaseCommand
import co.aikar.commands.annotation.CommandAlias
import co.aikar.commands.annotation.CommandPermission
import co.aikar.commands.annotation.HelpCommand
import ltd.matrixstudios.servertimizer.util.Chat
import org.bukkit.entity.Player

@CommandAlias("servertimizer|lag")
@CommandPermission("servertimizer.commands")
class ServertimizerCommand : BaseCommand()
{

    @HelpCommand
    fun help(player: Player)
    {
        player.sendMessage(Chat.format("&d=&5=&d= &dServertimizer &fHelp &d=&5=&d="))
        player.sendMessage(Chat.format("&d/servertimizer metrics &7- &fOpens the metrics menu"))
        player.sendMessage(Chat.format("&d/servertimizer freezeServer &7- &fFreezes the server"))
        player.sendMessage(Chat.format("&d/servertimizer threads &7- &fView all threads"))
        player.sendMessage(Chat.format("&d/servertimizer environment &7- &fLooks at environment info"))
        player.sendMessage(Chat.format("&d=&5=&d= &dLooking at &f4 &dresults. &d=&5=&d="))
    }
}