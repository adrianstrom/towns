package plugin.settlements;

import plugin.extensions.Location;
import plugin.settlements.base.HighDensitySettlement;

public class Town extends HighDensitySettlement {

	public Town(String settlementName, Location location) {
		super(settlementName, location);
	}

	public Town() {
		super();	
	}
}
