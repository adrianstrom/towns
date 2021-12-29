package plugin.persistence;

import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.Location;

import plugin.settlements.Settlement;

public class SqlAccess implements HistoryAccess 
{

    @Override
    public Settlement createSettlement(String name, Location location) {
        return null;
    }

    @Override
    public Settlement getSettlement(UUID id) {
        return null;
    }

    @Override
    public boolean deleteSettlement(String name) {
        return false;
    }

    @Override
    public ArrayList<Settlement> getSettlements() {
        return null;
    }

}