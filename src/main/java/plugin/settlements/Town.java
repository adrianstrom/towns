package plugin.settlements;

import java.util.ArrayList;

import org.bukkit.entity.Player;

import plugin.city.CityBank;
import plugin.extensions.Location;

public class Town extends Settlement {
	ArrayList<String> laws = new ArrayList<String>();
	public Player mayor;
	ArrayList<Player> settlementCouncil = new ArrayList<Player>();
	public Location shoppingMallLocation;
	public CityBank cityBank;
	public ArrayList<Settlement> twinTows;
	
	public Town(String settlementName, Location location) {
		super(settlementName, location);
		this.weightedValue = 5;
	}
}
