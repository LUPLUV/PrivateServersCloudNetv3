package de.lupu.psm.utils;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class FileManager {

    File configFile;
    File mysqlFile;

    public void loadFiles() throws IOException {
        File folder = new File("plugins//PsMaster");
        configFile = new File("plugins//PsMaster//config.yml");
        mysqlFile = new File("plugins//PsMaster//mysql.yml");
        if(!folder.exists()) folder.mkdir();
        if(!configFile.exists()){
            configFile.createNewFile();
            FileConfiguration cfg = YamlConfiguration.loadConfiguration(configFile);
            cfg.set("Prefix", "&6PS-System &7»");
            cfg.set("PsTemplatePath", "/home/Netzwerk/Cloud/local/templates/PS/");
            cfg.save(configFile);
        }
        if(!mysqlFile.exists()){
            mysqlFile.createNewFile();
            FileConfiguration cfg = YamlConfiguration.loadConfiguration(mysqlFile);
            cfg.set("Host", "localhost");
            cfg.set("Port", "3306");
            cfg.set("Database", "PsDB");
            cfg.set("Username", "PSadmin");
            cfg.set("Password", "password");
            cfg.save(mysqlFile);
        }
    }

    public File getConfigFile() {
        return configFile;
    }

    public File getMysqlFile() {
        return mysqlFile;
    }

    public FileConfiguration getConfig(){
        return YamlConfiguration.loadConfiguration(configFile);
    }

    public FileConfiguration getMysql(){
        return YamlConfiguration.loadConfiguration(mysqlFile);
    }
}
