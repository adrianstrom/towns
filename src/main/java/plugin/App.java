package plugin;
import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import org.bukkit.plugin.java.JavaPlugin;

import plugin.settlements.Homestead;

public class App extends JavaPlugin
{
    private File townsFile;

    @Override
    public void onEnable() 
    {
        townsFile = new File("plugins/Towns/towns.xml");
        getLogger().info(("Enabling..."));
        if (!getDataFolder().exists())
        { 
            getDataFolder().mkdir();
        }
        ObjectMapper mapper = new XmlMapper();
        try {
            mapper.writeValue(townsFile, new Homestead("My First Homestead", null));
        } catch (IOException e) {
            e.printStackTrace();
        }
        getLogger().info(("Enabled!"));
    }

    @Override
    public void onDisable() 
    {
        getLogger().info(("Disabling..."));
        ObjectMapper mapper = new XmlMapper();
        try {
            Homestead homestad = mapper.readValue(townsFile, Homestead.class);
            getLogger().info(homestad.getSettlementName());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        getLogger().info(("Disabled..."));
    }

}
