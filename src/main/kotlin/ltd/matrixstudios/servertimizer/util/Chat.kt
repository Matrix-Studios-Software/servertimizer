package ltd.matrixstudios.servertimizer.util

import org.bukkit.ChatColor

class Chat
{
    companion object
    {
        fun format(string: String) : String
        {
            return ChatColor.translateAlternateColorCodes('&', string)
        }
    }
}