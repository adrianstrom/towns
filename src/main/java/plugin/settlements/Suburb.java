package plugin.settlements;

import plugin.extensions.Location;
import plugin.settlements.base.MediumDensitySettlement;

public class Suburb extends MediumDensitySettlement {
	
	public Suburb(String settlementName, Location location) {
		super(settlementName, location);
	}

	public Suburb() {
		super();
	}
}
