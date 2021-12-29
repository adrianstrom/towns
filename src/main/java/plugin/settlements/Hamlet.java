package plugin.settlements;

import plugin.extensions.Location;
import plugin.settlements.base.LowDensitySettlement;

public class Hamlet extends LowDensitySettlement {
	
	public Hamlet(String settlementName, Location settlementLocation) {
		super(settlementName, settlementLocation);
	}

	public Hamlet() {
		super();
	}
	
}
