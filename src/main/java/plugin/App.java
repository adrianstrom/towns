package plugin;

import org.bukkit.plugin.java.JavaPlugin;

import plugin.commands.CreateSettlement;
import plugin.persistence.JsonRepository;
import plugin.persistence.SettlementRepository;

public class App extends JavaPlugin {
    
    public SettlementRepository historyAccess;

    @Override
    public void onEnable() {
        InitializePersitence();
		InitializeClasses();
    }

    @Override
    public void onDisable() {
        
    }

    private void InitializePersitence() {
        historyAccess = new JsonRepository(this);
    }

    private void InitializeClasses() {
        new CreateSettlement(this);
    }
}