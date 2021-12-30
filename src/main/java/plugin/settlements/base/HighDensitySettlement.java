package plugin.settlements.base;

import java.util.ArrayList;
import plugin.bank.CityBank;

public abstract class HighDensitySettlement extends MediumDensitySettlement {

	public CityBank cityBank;
	public ArrayList<Settlement> twinTowns;

	public HighDensitySettlement() {
		super();
	}

	public CityBank getCityBank() {
		return this.cityBank;
	}

	public void setCityBank(CityBank cityBank) {
		this.cityBank = cityBank;
	}

	public ArrayList<Settlement> getTwinTowns() {
		return this.twinTowns;
	}

	public void setTwinTowns(ArrayList<Settlement> twinTowns) {
		this.twinTowns = twinTowns;
	}
}