package plugin.settlements.base;

import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonIgnore;
import plugin.utils.Utils;

public abstract class LowDensitySettlement extends Settlement {
	
    public ArrayList<String> laws = new ArrayList<String>();

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

	@JsonIgnore 
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

	@Override
	public String getSettlementInfo() {
		String baseInfo = super.getSettlementInfo();
		String info = Utils.chat("\n"
		+ "&7Regler: &f \n" + getFormattedLaws());
		return baseInfo.concat(info);
	}
}