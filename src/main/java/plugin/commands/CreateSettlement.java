package plugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import plugin.App;
import plugin.settlements.Homestead;
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
				player.sendMessage(Utils.chat("&6===============[ MineNorge ]=============== \n" +
					"&a/bosetting opprett (bynavn)] \n" +
					"&c/bosetting fjern (bynavn)] \n" +
					"&b/bosetting info (bynavn)] \n" +
					"&d/bosetting tp (bynavn)] \n" +
					"&2/bosetting oppgrader (bynavn)] \n" +
					"&4/bosetting degrader (bynavn)] \n"));
				return true;
			}
			player.sendMessage("Hvilken bosetting ønsker du å gjøre noe med?");
			return true;

		} else if (args.length == 2) {
			String action = args[0];
			String settlementName = args[1];

			if (action.equals("opprett")) {
				Homestead settlement = plugin.historyAccess.createSettlement(settlementName, player.getLocation(), Homestead.class);

				if(settlement != null) {
					player.sendMessage(Utils.success("Bosettingen med navn &2" + settlement.name + " &able opprettet!"));
					return true;
				}
				player.sendMessage(Utils.fail("Bosettingen ble ikke opprettet!"));
				return true;

			} else if (action.equals("fjern")) {
				boolean settlementDeleted = plugin.historyAccess.deleteSettlement(settlementName);

				if(settlementDeleted) {
					player.sendMessage(Utils.success("Bosettingen med navn &2" + settlementName + " &able fjernet!"));
					return true;
				}
				player.sendMessage(Utils.fail("Denne bosettingen finnes ikke, og kunne derfor ikke fjernes!"));
				return true;

			} else if (action.equals("oppgrader")) {
				Settlement settlement = plugin.historyAccess.getSettlement(settlementName);
				settlement.upgrade();
				player.sendMessage(Utils.success("Bosetting med navn &2" + settlementName + " &able oppgradert!"));
				return true;
				
			} else if(action.equals("info")) {
				Settlement settlement = plugin.historyAccess.getSettlement(settlementName);

				if(settlement != null) {
					player.sendMessage(settlement.getSettlementInfo());
					return true;
				}
                player.sendMessage(Utils.fail("Denne bosettingen finnes ikke!"));
				return true;
			} else if(action.equals("tp") || action.equals("teleporter")) {
				Settlement settlement = plugin.historyAccess.getSettlement(settlementName);

				if(settlement != null) {
					Location loc = new org.bukkit.Location(Bukkit.getWorld(settlement.location.id), settlement.location.x, settlement.location.y, settlement.location.z);
					player.teleport(loc);
					player.sendMessage(Utils.success(" Du ble teleportert til &2" + settlement.name + "&a!"));
					return true;
				}
                player.sendMessage(Utils.fail("Denne bosettingen finnes ikke, så du kunne ikke teleporteres!"));
				return true;
			}
		}
		return true;
	}
}
