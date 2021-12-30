package plugin.settlements.base;

import java.util.ArrayList;
import plugin.city.CityBank;

public abstract class HighDensitySettlement extends MediumDensitySettlement {

	public CityBank cityBank;
	public ArrayList<Settlement> twinTows;

	public HighDensitySettlement() {
		super();
	}
}
