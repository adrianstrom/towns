package plugin.settlements;

import java.util.ArrayList;

import plugin.extensions.Location;

public class Village extends Settlement {
	ArrayList<String> laws = new ArrayList<String>();
	
	public Village(String settlementName, Location location) {
		super(settlementName, location);
		this.weightedValue = 3;
	}
}

