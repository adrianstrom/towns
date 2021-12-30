package plugin.persistence;

import java.util.ArrayList;

import org.bukkit.Location;
import plugin.settlements.base.Settlement;

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
    public <T extends Settlement> T createSettlement(String name, Location location, Class<T> classType) {
        return null;
    }

    @Override
    public <T extends Settlement> T getSettlement(String name) {
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

    @Override
    public boolean degradeSettlement(String name) {
        return false;
    }
}