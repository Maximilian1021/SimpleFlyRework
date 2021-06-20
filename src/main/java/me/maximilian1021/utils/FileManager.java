package me.maximilian1021.utils;

import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class FileManager {
    public static void createLangFile() {
        File file = new File("plugins/SimplePlugins", "SimpleFlyLang.yml");
        YamlConfiguration LangFly = YamlConfiguration.loadConfiguration(file);
        if (!file.exists()) {
            LangFly.set("Language", "German");
            LangFly.set("German.Prefix", "§f[§bFly§f]");
            LangFly.set("German.NoPerm", " §cDu hast nicht genügend Permission");
            LangFly.set("German.NoPlayer", " §cDu musst ein Spieler sein um den Command auszuführen");
            LangFly.set("German.NotOn", " §cDieser Speieler ist nicht online!");
            LangFly.set("German.FlyOn", " §bDein Flugmodus wurde §aaktiviert");
            LangFly.set("German.FlyOff", " §bDein Flugmodus wurde §cdeaktiviert");
            LangFly.set("German.FlyOnOther", " §bDein Flugmodus wurde von §6{player}  §aaktiviert");
            LangFly.set("German.FlyOffOther", " §bDein Flugmodus wurde von §6{player} §cdeaktiviert");
            LangFly.set("German.ChFlyOtherOn", " §bDu hast den Fly von §6{target} §aaktiviert!");
            LangFly.set("German.ChFlyOtherOff", " §bDu hast den Fly von §6{target} §cdeaktiviert!");
            LangFly.set("German.Usage", " §cBitte benutze §a/fly <Name>§b!");



            LangFly.set("English.Prefix", "§f[§bFly§f]");
            LangFly.set("English.NoPerm", " §cYou don't have the permission to do this!");
            LangFly.set("English.NoPlayer", " §cYou have to be a player to use this command!");
            LangFly.set("English.NotOn", " §cThe selected Player isn´t online!");
            LangFly.set("English.FlyOn", " §bYour Flightmode has been §aenabled");
            LangFly.set("English.FlyOff", " §bYour Flightmode has been §cdisabled");
            LangFly.set("English.FlyOnOther", "§bYour flight mode was §aenabled by §a{player}.");
            LangFly.set("English.FlyOffOther", "§bYour flight mode was §cdisabled by §a{player}.");
            LangFly.set("English.ChFlyOtherOn", " §bYou have §aenabled the flight mode of §6{target}.");
            LangFly.set("English.ChFlyOtherOff", " §bYou have §cdisable the flight mode of §6{target}.");
            LangFly.set("English.Usage", " §cUsage: §/fly <name>§b!");

        }
        try {
            LangFly.save(file);
        }
        catch (IOException e) {
            System.out.println("Fehler in der Configuration SimpleFlyLang.yml");
            e.printStackTrace();
        }
    }

    public static File getSFlyLangFile() {
        return new File("plugins/SimplePlugins", "SimpleFlyLang.yml");
    }
}

