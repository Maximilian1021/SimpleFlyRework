package me.maximilian1021.main;

import me.maximilian1021.commands.CommandFly;
import me.maximilian1021.utils.FileManager;
import me.maximilian1021.utils.Metrics;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class SimpleFly extends JavaPlugin {

    @Override
    public void onEnable() {
        int pluginId = 11758;
        Metrics metrics = new Metrics(this, pluginId);

        FileManager.createLangFile();
        registerCommands();
        // Plugin startup logic

    }

    private void registerCommands() {

        Objects.requireNonNull(getCommand("fly")).setExecutor(new CommandFly());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
