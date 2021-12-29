package plugin.commands;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import plugin.App;
import plugin.settlements.Homestead;
import plugin.settlements.Settlement;
import plugin.utils.Utils;

public class CreateSettlement implements CommandExecutor {

	private App plugin;

	public CreateSettlement(App plugin) {
		this.plugin = plugin;
		plugin.getCommand("bosetting").setExecutor(this);
	}

	@Override
	public boolean onCommand(CommandSender sender, org.bukkit.command.Command cmd, String label, String[] args) {
		Player player = (Player) sender;
		
		if (args.length == 0) {
			player.sendMessage("Hvilken kommando ønsker du å bruke og hvilek bosetting?");
			return true;

		} else if (args.length == 1) {
			player.sendMessage("Hvilken bosetting ønsker du å gjøre noe med?");
			return true;

		} else if (args.length == 2) {
			String action = args[0];
			String settlementName = args[1];

			if (action.equals("opprett")) {
				Homestead settlement = (Homestead) plugin.historyAccess.<Homestead>createSettlement(settlementName, player.getLocation(), Homestead.class);

				if(settlement != null) {
					player.sendMessage(Utils.success("Bosettingen med navn " + settlement.getSettlementName() + " ble opprettet!"));
					return true;
				}
				player.sendMessage(Utils.fail("Bosettingen ble ikke opprettet!"));
				return true;

			} else if (action.equals("fjern")) {
				boolean settlementDeleted = plugin.historyAccess.deleteSettlement(settlementName);

				if(settlementDeleted) {
					player.sendMessage("Bosettingen med navn " + settlementName + " ble fjernet!");
					return true;
				}
				player.sendMessage("Fant ikke den gjeldende bosettingen!");
				return true;

			} else if (action.equals("oppgrader")) {
				boolean settlementUpgraded = plugin.historyAccess.upgradeSettlement(settlementName);

				if(settlementUpgraded) {
					player.sendMessage("Bosetting med navn " + settlementName + " ble oppgradert!");
					return true;
				}
                player.sendMessage("Bosettingen kunne ikke bli oppgradert!");
				return true;
				
			} else if(action.equals("info")) {
				Settlement settlement = plugin.historyAccess.getSettlement(null);

				if(settlement != null) {
					// Show settlement info in a well formatted string.
					return true;
				}
                player.sendMessage("Bosettingen eksisterer ikke!");
				return true;
			}
		}
		return true;
	}
}
