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
	public String name;
	public Location location;
	public ArrayList<Player> citizens = new ArrayList<Player>();
	public boolean deleted;
	
	public Settlement(String name, Location location) {
		this.uuid = UUID.randomUUID();
		this.name = name;
		this.location = location;
	}

	public Settlement() {
		
	}

	public UUID getUUID() {
		return this.uuid;
	}

	public void setUUID() {
		this.uuid = UUID.randomUUID();
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {	
		this.name = name;
	}
	
	public Location getLocation() {
		return this.location;
	}
	
	public void setLocation(Location location) {
		this.location = location;
	}
	
	public ArrayList<Player> getCitizens() {
		return this.citizens;
	}
	
	public void setCitizens(ArrayList<Player> citizens) {
		this.citizens = citizens;
	}
	
	public boolean getDeleted() {
		return this.deleted;
	}
	
	public void setDeleted() {
		this.deleted = true;
	}
}
