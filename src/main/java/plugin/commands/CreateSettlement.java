package plugin.commands;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import plugin.App;
import plugin.settlements.Hamlet;
import plugin.settlements.Homestead;
import plugin.settlements.Suburb;
import plugin.settlements.base.Settlement;
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
			String action = args[0];

			if(action.equals("hjelp"))
			{
				player.sendMessage(
					"/bosetting info (bynavn)] \n" +
					"/bosetting opprett (bynavn)] \n" +
					"/bosetting fjern (bynavn)] \n" +
					"/bosetting oppgrader (bynavn)] \n");
				return true;
			}
			player.sendMessage("Hvilken bosetting ønsker du å gjøre noe med?");
			return true;

		} else if (args.length == 2) {
			String action = args[0];
			String settlementName = args[1];

			if (action.equals("opprett")) {
				Homestead settlement = plugin.historyAccess.createSettlement(settlementName + "1", player.getLocation(), Homestead.class);
				Hamlet settlement2 = plugin.historyAccess.createSettlement(settlementName + "2", player.getLocation(), Hamlet.class);
				Suburb settlement3 = plugin.historyAccess.createSettlement(settlementName + "3", player.getLocation(), Suburb.class);

				if(settlement != null && settlement2 != null && settlement3 != null) {
					//player.sendMessage(Utils.success("Bosettingen med navn " + settlement.name + " ble opprettet!"));
					player.sendMessage("opprettet");
					return true;
				}
				player.sendMessage(Utils.fail("Bosettingen ble ikke opprettet!"));
				return true;

			} else if (action.equals("fjern")) {
				boolean settlementDeleted = plugin.historyAccess.deleteSettlement(settlementName);

				if(settlementDeleted) {
					player.sendMessage(Utils.success("Bosettingen med navn " + settlementName + " ble fjernet!"));
					return true;
				}
				player.sendMessage(Utils.fail("Fant ikke den gjeldende bosettingen!"));
				return true;

			} else if (action.equals("oppgrader")) {
				boolean settlementUpgraded = plugin.historyAccess.upgradeSettlement(settlementName);

				if(settlementUpgraded) {
					player.sendMessage(Utils.success("Bosetting med navn " + settlementName + " ble oppgradert!"));
					return true;
				}
                player.sendMessage(Utils.fail("Bosettingen kunne ikke bli oppgradert!"));
				return true;
				
			} else if(action.equals("info")) {
				Settlement settlement = plugin.historyAccess.getSettlement(settlementName);

				if(settlement != null) {
					player.sendMessage(settlement.getSettlementInfo());
					return true;
				}
                player.sendMessage("Bosettingen eksisterer ikke!");
				return true;
			} else if(action.equals("tp") || action.equals("teleporter")) {
				Settlement settlement = plugin.historyAccess.getSettlement(settlementName);

				if(settlement != null) {
					// teleport to location
					//player.teleport(location)
					return true;
				}
                player.sendMessage("Bosettingen eksisterer ikke, så du kunne ikke teleporteres!");
				return true;
			}
		}
		return true;
	}
}
