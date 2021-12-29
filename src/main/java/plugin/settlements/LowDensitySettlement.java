package plugin.settlements;

import java.util.ArrayList;
import plugin.extensions.Location;

public abstract class LowDensitySettlement extends Settlement {
	
    public ArrayList<String> laws = new ArrayList<String>();

    public LowDensitySettlement(String settlementName, Location location) {
		super(settlementName, location);
	}

	public LowDensitySettlement() {
		super();
	}
}
