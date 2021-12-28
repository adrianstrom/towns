package plugin;
import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.bukkit.plugin.java.JavaPlugin;

import plugin.commands.CreateSettlement;
import plugin.settlements.Homestead;

public class App extends JavaPlugin
{
    public File townsFile;

    @Override
    public void onEnable() 
    {
        InitializePersitence();
		InitializeClasses();
        SetFile();
    }

    @Override
    public void onDisable() 
    {
        getLogger().info(("Disabling..."));
        ObjectMapper mapper = new ObjectMapper();
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

    private void InitializePersitence()
    {
        
    }

    private void InitializeClasses()
    {
        new CreateSettlement(this);
    }

    private void SetFile()
    {
        try 
        {
            if (!getDataFolder().exists())
            { 
                getDataFolder().mkdir();
                townsFile = new File("plugins/Towns/towns.json");
                if(townsFile.createNewFile())
                {
                    getLogger().info(("Created towns.json."));
                }
            }
        }
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }

}
