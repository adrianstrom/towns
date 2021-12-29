package plugin.settlements;

import java.util.ArrayList;

import org.bukkit.entity.Player;

import plugin.city.CityBank;
import plugin.extensions.Location;

public class Town extends Settlement {
	public ArrayList<String> laws = new ArrayList<String>();
	public Player mayor;
	public ArrayList<Player> settlementCouncil = new ArrayList<Player>();
	public Location shoppingMallLocation;
	public CityBank cityBank;
	public ArrayList<Settlement> twinTows;

	public Town(String settlementName, Location location) {
		super(settlementName, location);
	}

	public Town() {
		super();	
	}
}
