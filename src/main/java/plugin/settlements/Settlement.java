package plugin.settlements;

import java.util.ArrayList;
import java.util.UUID;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.bukkit.entity.Player;

import plugin.extensions.Location;

@JsonTypeInfo(use=JsonTypeInfo.Id.CLASS, property="type")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSubTypes({
    @JsonSubTypes.Type(value = Hamlet.class, name = "Hamlet"),
    @JsonSubTypes.Type(value = Homestead.class, name = "Homestead"),
	@JsonSubTypes.Type(value = Megapolis.class, name = "Megapolis"),
    @JsonSubTypes.Type(value = Metropolis.class, name = "Metropolis"),
	@JsonSubTypes.Type(value = Suburb.class, name = "Suburb"),
    @JsonSubTypes.Type(value = Town.class, name = "Town"),
	@JsonSubTypes.Type(value = Village.class, name = "Village")
})
public abstract class Settlement {
	
	public UUID uuid;
	public String settlementName;
	public Location settlementLocation;
	public ArrayList<Player> citizens = new ArrayList<Player>();
	public boolean deleted;
	
	public Settlement(String settlementName, Location settlementLocation) {
		this.uuid = UUID.randomUUID();
		this.settlementName = settlementName;
		this.settlementLocation = settlementLocation;
	}

	public Settlement() {
		
	}

	public UUID getUUID() {
		return this.uuid;
	}

	public void setUUID() {
		this.uuid = UUID.randomUUID();
	}
	
	public String getSettlementName() {
		return this.settlementName;
	}
	
	public void setSettlementName(String newSettlementName) {	
		this.settlementName = newSettlementName;
	}
	
	public Location getSettlementLocation() {
		return this.settlementLocation;
	}
	
	public void setSettlementLocation(Location newSettlementLocation) {
		this.settlementLocation = newSettlementLocation;
	}
	
	public ArrayList<Player> getCitizens() {
		return this.citizens;
	}
	
	public void setCitizens(ArrayList<Player> newCitizens) {
		this.citizens = newCitizens;
	}
	
	public boolean getDeleted() {
		return this.deleted;
	}
	
	public void setDeleted() {
		this.deleted = true;
	}
}
