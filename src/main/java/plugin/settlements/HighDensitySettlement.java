package plugin.settlements;

import java.util.ArrayList;
import plugin.city.CityBank;
import plugin.extensions.Location;

public abstract class HighDensitySettlement extends MediumDensitySettlement {

	public CityBank cityBank;
	public ArrayList<Settlement> twinTows;

    public HighDensitySettlement(String settlementName, Location location) {
		super(settlementName, location);
	}

	public HighDensitySettlement() {
		super();
	}
}
