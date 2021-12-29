package plugin.persistence;

import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.Location;

import plugin.settlements.Settlement;

/* 
    Create PostgreSQL database or MySQL database.
    Have one table named Settlements.
    This table should include all properties including settlement type (discriminator). 
*/

public class SqlRepository implements SettlementRepository
{
    public SqlRepository() {

    }

    @Override
    public <T extends Settlement> Settlement createSettlement(String name, Location location, Class<T> classType) {
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

    @Override
    public boolean upgradeSettlement(String name) {
        return false;
    }
}