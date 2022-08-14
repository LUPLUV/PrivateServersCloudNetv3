package de.lupu.psm;

import de.lupu.bmapi.mysql.MySQL;
import de.lupu.psm.utils.FileManager;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class Master extends JavaPlugin {

    private static Master plugin;
    private static MySQL mySQL;
    private static FileManager fileManager;

    @Override
    public void onEnable() {
        plugin = this;
    }

    @Override
    public void onDisable() {
        mySQL.disconnect();
    }

    public static Master getPlugin() {
        return plugin;
    }

    public MySQL getMySQL() {
        return mySQL;
    }

    public static FileManager getFileManager() {
        return fileManager;
    }

    public static void reloadMysqlConnection(){
        if(mySQL.isConnected()) mySQL.disconnect();
        FileConfiguration cfg = fileManager.getMysql();
        mySQL = new MySQL(cfg.getString("Host"), cfg.getString("Port"), cfg.getString("Database"), cfg.getString("Username")
                , cfg.getString("Password"));
        mySQL.connect();
        if(mySQL.isConnected()){
            mySQL.update("CREATE TABLE IF NOT EXISTS PS_NameFetcher (UUID VARCHAR(100),NAME VARCHAR(100))");
            mySQL.update("CREATE TABLE IF NOT EXISTS PS_Servers (OWNER VARCHAR(100),)");
        }
    }

}
