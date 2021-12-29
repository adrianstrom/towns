package plugin.commands;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import plugin.App;
import plugin.settlements.Settlement;

public class CreateSettlement implements CommandExecutor {

	private App plugin;

	public CreateSettlement(App plugin) 
    {
		this.plugin = plugin;
		plugin.getCommand("bosetting").setExecutor(this);
	}

	@Override
	public boolean onCommand(CommandSender sender, org.bukkit.command.Command cmd, String label, String[] args) {
		Player player = (Player) sender;
		if (args.length == 0) 
		{
			player.sendMessage("Hvilken kommando ønsker du å bruke og hvilek bosetting?");
			return true;
		} 
        else if (args.length == 1) 
        {
			player.sendMessage("Hvilken bosetting ønsker du å gjøre noe med?");
			return true;
		} 
        else if (args.length == 2) 
        {
			String action = args[0];
			String settlementName = args[1];

			if (action.equals("opprett"))
            {
				Settlement settlement = plugin.historyAccess.createSettlement(settlementName, player.getLocation());
				if(settlement != null)
				{
					player.sendMessage("Bosettingen med navn " + settlement.getSettlementName() + " ble opprettet!");
					return true;
				}
				player.sendMessage("Bosettingen ble ikke opprettet!");
				return true;
			} 
            else if (action.equals("fjern")) 
            {
				if(plugin.historyAccess.deleteSettlement(settlementName))
				{
					player.sendMessage("Bosettingen med navn " + settlementName + " ble fjernet!");
					return true;
				}
				player.sendMessage("Fant ikke den gjeldende bosettingen!");
				return true;
			} 
            else if (action.equals("oppgrader")) 
            {
                player.sendMessage("Bosetting med navn " + settlementName + " ble oppgradert!");
				return true;
			}
		}
		return true;
	}
}
