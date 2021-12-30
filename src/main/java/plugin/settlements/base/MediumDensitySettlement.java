package plugin.settlements.base;

import java.util.ArrayList;

import org.bukkit.entity.Player;

import plugin.extensions.Location;
import plugin.utils.Utils;

public abstract class MediumDensitySettlement extends LowDensitySettlement {
	
	public Player mayor;
	public ArrayList<Player> council = new ArrayList<Player>();
	public Location mallLocation;

	public MediumDensitySettlement() {
		super();
	}

	public Player getMayor() {
		return this.mayor;
	}

	public void setMayor(Player mayor) {
		this.mayor = mayor;
	}

	public ArrayList<Player> getCouncil() {
		return this.council;
	}

	public void setCouncil(ArrayList<Player> council) {
		this.council = council;
	}

	public Location getMallLocation() {
		return this.mallLocation;
	}

	public void setMallLocation(Location mallLocation) {
		this.mallLocation = mallLocation;
	}

	private String getFormattedCouncil() {
		String councilNames = "";
		for (Player player : council) {
			councilNames += player.getDisplayName() + ", ";
		}
		return councilNames;
	}

	@Override
	public String getSettlementInfo() {
		String baseInfo = super.getSettlementInfo();
		String info = Utils.chat(""
		+ "&7Borgermester: &f" + mayor != null ? mayor.getDisplayName() : "Ikke satt" + "\n" 
		+ "&7Byråd: &f" + getFormattedCouncil() + "\n");
		return baseInfo.concat(info);
	}
}
