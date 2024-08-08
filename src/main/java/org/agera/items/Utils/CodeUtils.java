package org.agera.items.Utils;

import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;

public class CodeUtils {
    public static void logToConsole(String message) {
        ConsoleCommandSender console = Bukkit.getConsoleSender();
        console.sendMessage("[ItemsTest Logger] " + message);
    }
}
