package plugin.settlements;

import java.util.ArrayList;

import org.bukkit.entity.Player;

import plugin.extensions.Location;

public class Suburb extends Settlement {
	public ArrayList<String> laws = new ArrayList<String>();
	public Player mayor;
	public ArrayList<Player> settlementCouncil = new ArrayList<Player>();
	public Location shoppingMallLocation;
	
	public Suburb(String settlementName, Location location) {
		super(settlementName, location);
	}

	public Suburb() {
		super();
	}
}
