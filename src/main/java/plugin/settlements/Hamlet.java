package plugin.settlements;

import java.util.ArrayList;

import org.bukkit.Location;

public class Hamlet extends Settlement {
	ArrayList<String> laws = new ArrayList<String>();
	
	public Hamlet(String settlementName, Location settlementLocation)
	{
		super(settlementName, settlementLocation);
		this.weightedValue = 2;
	}
	
}
