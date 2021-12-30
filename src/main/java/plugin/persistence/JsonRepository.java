package plugin.persistence;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import plugin.App;
import plugin.extensions.Location;
import plugin.settlements.base.Settlement;

public class JsonRepository implements SettlementRepository
{
    private App plugin;
    private File townsFile;
    private ObjectMapper mapper;

    public JsonRepository(App plugin) {
        this.plugin = plugin;
        mapper = new ObjectMapper();
        SetFile();
    }

    @Override
    public <T extends Settlement> T getSettlement(String name) {
        try {
            ObjectNode node = (ObjectNode) mapper.readTree(townsFile);
            ArrayNode settlementsNode = (ArrayNode) node.get("settlements");

            for (JsonNode settlementNode : settlementsNode) {
                T settlement = mapper.readValue(settlementNode.toString(), new TypeReference<T>() { });

                if(settlement.name.equals(name)) {
                    return settlement;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Settlement> getSettlements()  {
        ArrayList<Settlement> settlements = new ArrayList<Settlement>();
        try {
            ObjectNode node = (ObjectNode) mapper.readTree(townsFile);
            ArrayNode settlementsNode = (ArrayNode) node.get("settlements");

            for (JsonNode settlementNode : settlementsNode) {
                Settlement settlement = mapper.readValue(settlementNode.toString(), Settlement.class);
                settlements.add(settlement);
            }
            return settlements;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

/** Returns null if settlement wasn't created. */

    @Override
    public <T extends Settlement> T createSettlement(String settlementName, org.bukkit.Location location, Class<T> classType) {
        try {
            JsonNode node = mapper.readTree(townsFile);
            ArrayNode settlementsNode = null;

            if(node instanceof ObjectNode)
            {
                settlementsNode = (ArrayNode) node.get("settlements");
            } else
            {
                node = mapper.createObjectNode();
                settlementsNode = ((ObjectNode) node).putArray("settlements");
            }
            T settlement = classType.newInstance();
            settlement.setUUID();
            settlement.setName(settlementName);
            settlement.setLocation(new Location (location.getWorld().getUID(), location.getX(), location.getY(), location.getZ(), location.getYaw(), location.getPitch()));
            
            settlementsNode.addPOJO(settlement);
            mapper.writeValue(townsFile, node);
            return settlement;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean deleteSettlement(String name) {
        try {
            ObjectNode node = (ObjectNode) mapper.readTree(townsFile);
            ArrayNode settlementsNode = (ArrayNode) node.get("settlements");

            for (JsonNode settlementNode : settlementsNode) {
                Settlement settlement = mapper.readValue(settlementNode.toString(), Settlement.class);

                if(settlement.name.equals(name)) {
                    ((ObjectNode)settlementNode).put("deleted", true);
                    mapper.writeValue(townsFile, node);
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    
    @Override
    public boolean upgradeSettlement(String name) {
        return false;
    }
    
    private void SetFile() {
        townsFile = new File("plugins/Towns/towns.json");
        try {
            if (!plugin.getDataFolder().exists())
            { 
                plugin.getDataFolder().mkdir();

                if(townsFile.createNewFile()) {
                    plugin.getLogger().info(("Created towns.json."));
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean degradeSettlement(String name) {
        return false;
    }
}
