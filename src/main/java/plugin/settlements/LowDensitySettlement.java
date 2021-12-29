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

	public ArrayList<String> getLaws() {
		return this.laws;
	}

	public void setLaws(ArrayList<String> laws) {
		this.laws = laws;
	}

	public void setLaw(String law) {
		laws.add(law);
	}

	public String getFormattedLaws() {
		String formattedString = "";
		int count = 1;
		for (String law : this.laws)
		{
			formattedString += "  " + count + ": " + law + "\n";
			count++;
		}
		return formattedString;
	}
}
