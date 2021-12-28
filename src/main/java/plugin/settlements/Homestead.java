package plugin.settlements;

import plugin.extensions.Location;

public class Homestead extends Settlement {

	public Homestead(String settlementName, Location location) {
		super(settlementName, location);
		this.weightedValue = 1;
	}

	public Homestead()
	{
		super();
	}
}
