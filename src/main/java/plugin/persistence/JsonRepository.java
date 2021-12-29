package plugin.persistence;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.UUID;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import plugin.App;
import plugin.extensions.Location;
import plugin.settlements.Homestead;
import plugin.settlements.Settlement;

public class JsonRepository implements SettlementRepository
{
    private App plugin;
    private File townsFile;

    public JsonRepository(App plugin) {
        this.plugin = plugin;
        SetFile();
    }

    @Override
    public Settlement getSettlement(UUID id) {
        return null;
    }

    @Override
    public ArrayList<Settlement> getSettlements()  {
        return null;
    }

/** Returns null if settlement wasn't created. */
    @Override
    public <T extends Settlement> Settlement createSettlement(String settlementName, org.bukkit.Location location, Class<T> classType) {
        ObjectMapper mapper = new ObjectMapper();
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
            settlement.setSettlementName(settlementName);
            settlement.setSettlementLocation(new Location (location.getX(), location.getY(), location.getZ(), location.getYaw(), location.getPitch()));
            
            settlementsNode.addPOJO(settlement);
            mapper.writeValue(townsFile, node);
            return settlement;

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean deleteSettlement(String name) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            ObjectNode node = (ObjectNode) mapper.readTree(townsFile);
            ArrayNode settlementsNode = (ArrayNode) node.get("settlements");

            for (JsonNode settlementNode : settlementsNode) {
                plugin.getLogger().info("start");
                plugin.getLogger().info(settlementNode.toString());
                plugin.getLogger().info("end");
                if(settlementNode.toString().equals("{}"))
                {
                    continue;
                }
                Settlement settlement = mapper.readValue(settlementNode.toString(), Settlement.class);
                plugin.getLogger().info(settlement.toString());

                if(settlement.getSettlementName().equals(name)) {
                    settlement.setDeleted();
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
}
