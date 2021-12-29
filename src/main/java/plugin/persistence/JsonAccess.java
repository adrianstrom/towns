package plugin.persistence;

import java.io.File;
import java.io.IOException;
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

public class JsonAccess implements HistoryAccess 
{
    private App plugin;
    private File townsFile;

    public JsonAccess(App plugin)
    {
        this.plugin = plugin;
        SetFile();
    }

    @Override
    public Settlement getSettlement(UUID id) 
    {
        return null;
    }

    @Override
    public ArrayList<Settlement> getSettlements() 
    {
        return null;
    }

/** Returns null if settlement wasn't created. */
    @Override
    public Settlement createSettlement(String settlementName, org.bukkit.Location location) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            ObjectNode node = (ObjectNode) mapper.readTree(townsFile);
            ArrayNode settlements = (ArrayNode) node.get("settlements");

            // create xml tree if settlements doesnt exist
            if(settlements == null)
            {
                node = mapper.createObjectNode();
                settlements = node.putArray("settlements");
            }

            Homestead settlement = new Homestead(settlementName, new Location(location.getX(), location.getY(), location.getZ(), location.getYaw(), location.getPitch()));
            settlements.addPOJO(settlement);

            mapper.writeValue(townsFile, node);
            return (Settlement)settlement;

        } catch (IOException e) {
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

            for (JsonNode settlementNode : settlementsNode)
            {
                ObjectNode object = (ObjectNode) settlementNode;

                if(object != null)
                {
                    String settlementNameNode = object.get("settlementName").toString().replace("\"", "");

                    if(settlementNameNode.equals(name))
                    {
                        object.removeAll();
                        mapper.writeValue(townsFile, node);
                        return true;
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    private void SetFile()
    {
        townsFile = new File("plugins/Towns/towns.json");
        try 
        {
            if (!plugin.getDataFolder().exists())
            { 
                plugin.getDataFolder().mkdir();
                if(townsFile.createNewFile())
                {
                    plugin.getLogger().info(("Created towns.json."));
                }
            }
        }
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }
}
