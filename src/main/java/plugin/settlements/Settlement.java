package plugin.settlements;

import java.util.ArrayList;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public abstract class Settlement {
	protected String settlementName;
	protected Location settlementLocation;
	ArrayList<Player> citizens = new ArrayList<Player>();
	protected int weightedValue;
	protected boolean deleted;
	
	public Settlement(String settlementName, Location settlementLocation)
	{
		this.settlementName = settlementName;
		this.settlementLocation = settlementLocation;
	}
	
	public String getSettlementName()
	{
		return this.settlementName;
	}
	
	public void setSettlementName(String newSettlementName)
	{
		this.settlementName = newSettlementName;
	}
	
	public Location getSettlementLocation()
	{
		return this.settlementLocation;
	}
	
	public void setSettlementLocation(Location newSettlementLocation)
	{
		this.settlementLocation = newSettlementLocation;
	}
	
	public ArrayList<Player> getCitizens()
	{
		return this.citizens;
	}
	
	public void setCitizens(ArrayList<Player> newCitizens)
	{
		this.citizens = newCitizens;
	}
	
	public int getWeightedValue()
	{
		return this.weightedValue;
	}
	
	public void setWeightedValue(int value)
	{
		this.weightedValue = value;
	}
	
	public boolean getDeleted()
	{
		return this.deleted;
	}
	
	public void setDeleted()
	{
		this.deleted = true;
	}
}
