package plugin.settlements;

import org.bukkit.Location;

public class Homestead extends Settlement {

	public Homestead(String settlementName, Location location) {
		super(settlementName, location);
		this.weightedValue = 1;
	}
}
