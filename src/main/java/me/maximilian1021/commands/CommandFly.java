package me.maximilian1021.commands;

import me.maximilian1021.utils.FileManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;

public class CommandFly implements CommandExecutor {


    private final File file = FileManager.getSFlyLangFile();

    private final FileConfiguration LangFly = YamlConfiguration.loadConfiguration(file);
    private final String language = LangFly.getString("Language");
    private final String prefix = LangFly.getString(language + ".Prefix");

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (args.length == 0) {
                if (p.hasPermission("SimpleFly.fly.self") || p.hasPermission("SimpleFly.fly.*")) {
                    if (!p.getAllowFlight()) {
                        p.setAllowFlight(true);
                        p.sendMessage(prefix + LangFly.getString(language + ".FlyOn"));
                    } else {
                        p.setAllowFlight(false);
                        p.sendMessage(prefix + LangFly.getString(language + ".FlyOff"));
                    }
                } else {
                    p.sendMessage(prefix + LangFly.getString(language + ".NoPerm"));
                }
                return true;

            } else if (args.length == 1) {
                if (p.hasPermission("SimpleFly.fly.others") || p.hasPermission("SimpleFly.fly.*")) {
                    Player target = Bukkit.getPlayer(args[0]);

                    if (target != null) {
                        if (!target.getAllowFlight()) {
                            target.setAllowFlight(true);
                            target.sendMessage(prefix + LangFly.getString(language + ".FlyOnOther").replace("{player}", p.getName()));
                            p.sendMessage(prefix + LangFly.getString(language + ".ChFlyOtherOn").replace("{target}", target.getName()));
                        } else {
                            target.setAllowFlight(false);
                            target.sendMessage(prefix + LangFly.getString(language + ".FlyOffOther").replace("{player}", p.getName()));
                            p.sendMessage(prefix + LangFly.getString(language + ".ChFlyOtherOff").replace("{target}", target.getName()));
                        }
                        return true;
                    } else {
                        p.sendMessage(prefix + LangFly.getString(language + ".NotOn"));
                        return true;
                    }
                } else {
                    p.sendMessage(prefix + LangFly.getString(language + ".NoPerm"));
                    return true;
                }
            } else {
                p.sendMessage(prefix + LangFly.getString(language + ".Usage"));
                return true;
            }
        } else {
            sender.sendMessage(prefix + LangFly.getString(language + ".NoPlayer"));
            return true;
        }


    }
}
