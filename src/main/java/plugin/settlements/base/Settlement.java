package plugin.settlements.base;

import java.util.ArrayList;
import java.util.UUID;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.bukkit.entity.Player;

import plugin.extensions.Location;
import plugin.settlements.Hamlet;
import plugin.settlements.Homestead;
import plugin.settlements.Megapolis;
import plugin.settlements.Metropolis;
import plugin.settlements.Suburb;
import plugin.settlements.Town;
import plugin.settlements.Village;
import plugin.utils.Utils;

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

	public Settlement() {
		
	}

	public abstract void upgrade();
	public abstract void degrade();

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

	@JsonIgnore
	public String getSettlementInfo() { 
		return Utils.chat("&a------------{ &l&6" + name.toUpperCase().replace("", " ").trim() + "&r&a }------------\n"
		+ "&7Type: &f" + getClass().getSimpleName() + "\n"
		+ "&7Lokasjon: &f(" + Math.round(location.x) + ", " + Math.round(location.y) + ", " + Math.round(location.z) + ") \n"
		+ "&7Innbyggere: &f" + citizens.size());
	}
}
