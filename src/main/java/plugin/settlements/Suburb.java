package plugin.settlements;

import java.util.ArrayList;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public class Suburb extends Settlement {
	ArrayList<String> laws = new ArrayList<String>();
	public Player mayor;
	ArrayList<Player> settlementCouncil = new ArrayList<Player>();
	public Location shoppingMallLocation;
	
	public Suburb(String settlementName, Location location) {
		super(settlementName, location);
		this.weightedValue = 4;
	}
}
