package plugin.settlements.base;

import java.util.ArrayList;

import org.bukkit.entity.Player;

import plugin.extensions.Location;

public abstract class MediumDensitySettlement extends LowDensitySettlement {
	
	public Player mayor;
	public ArrayList<Player> settlementCouncil = new ArrayList<Player>();
	public Location shoppingMallLocation;

    public MediumDensitySettlement(String settlementName, Location location) {
		super(settlementName, location);
	}

	public MediumDensitySettlement() {
		super();
	}
}
