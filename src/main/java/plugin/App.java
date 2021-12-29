package plugin;

import org.bukkit.plugin.java.JavaPlugin;

import plugin.commands.CreateSettlement;
import plugin.persistence.HistoryAccess;
import plugin.persistence.JsonAccess;

public class App extends JavaPlugin
{
    public HistoryAccess historyAccess;

    @Override
    public void onEnable() 
    {
        InitializePersitence();
		InitializeClasses();
    }

    @Override
    public void onDisable() 
    {
        
    }

    private void InitializePersitence()
    {
        historyAccess = new JsonAccess(this);
    }

    private void InitializeClasses()
    {
        new CreateSettlement(this);
    }
}
