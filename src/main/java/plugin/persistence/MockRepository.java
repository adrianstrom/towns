package plugin.persistence;

import java.util.ArrayList;
import org.bukkit.Location;
import plugin.settlements.base.Settlement;

public class MockRepository implements SettlementRepository {

    private ArrayList<Settlement> settlements = new ArrayList<Settlement>();

    @SuppressWarnings( "deprecation" )
    @Override
    public <T extends Settlement> T createSettlement(String name, Location location, Class<T> classType) {
        try {
            T settlement = classType.newInstance();
            settlements.add(settlement);
            return settlement;
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    @SuppressWarnings (value="unchecked")
    @Override
    public <T extends Settlement> T getSettlement(String name) {
        for (Settlement settlement : this.settlements) {
            if(settlement.name == name)
            {
                return (T) settlement;
            }
        }
        return null;
    }

    @Override
    public boolean deleteSettlement(String name) {
        for (Settlement settlement : this.settlements) {
            if(settlement.name == name)
            {
                settlements.remove(settlement);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean upgradeSettlement(String name) {
        return false;
    }

    @Override
    public ArrayList<Settlement> getSettlements() {
        return settlements;
    }

    @Override
    public boolean degradeSettlement(String name) {
        return false;
    }
}
