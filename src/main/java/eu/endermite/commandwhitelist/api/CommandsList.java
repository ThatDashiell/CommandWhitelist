package eu.endermite.commandwhitelist.api;

import eu.endermite.commandwhitelist.bungee.CommandWhitelistBungee;
import eu.endermite.commandwhitelist.spigot.CommandWhitelist;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import org.bukkit.entity.Player;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CommandsList {

    public static List<String> getCommands(Player player) {

        List<String> commandList = new ArrayList<>();
        for (Map.Entry<String, List<String>> s : CommandWhitelist.getConfigCache().getPermList().entrySet()) {
            if (player.hasPermission("commandwhitelist.commands." + s.getKey())) {
                commandList.addAll(s.getValue());
            }
        }
        return commandList;
    }

    public static List<String> getCommands(ProxiedPlayer player) {

        List<String> commandList = new ArrayList<>();
        for (Map.Entry<String, List<String>> s : CommandWhitelistBungee.getConfigCache().getPermList().entrySet()) {
            if (player.hasPermission("commandwhitelist.commands." + s.getKey())) {
                commandList.addAll(s.getValue());
            }
        }
        return commandList;
    }

}
