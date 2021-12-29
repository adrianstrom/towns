package plugin.persistence;

import java.util.ArrayList;
import plugin.settlements.base.Settlement;

public interface SettlementRepository 
{
  public <T extends Settlement> T createSettlement(String name, org.bukkit.Location location, Class<T> classType);
  public Settlement getSettlement(String name);
  public boolean deleteSettlement(String name);
  public boolean upgradeSettlement(String name);
  public ArrayList<Settlement> getSettlements();
}