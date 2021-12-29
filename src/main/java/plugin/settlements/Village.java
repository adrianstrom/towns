package plugin.settlements;

import plugin.extensions.Location;
import plugin.settlements.base.LowDensitySettlement;

public class Village extends LowDensitySettlement {

	public Village(String settlementName, Location location) {
		super(settlementName, location);
	}

	public Village() {
		super();	
	}
}

