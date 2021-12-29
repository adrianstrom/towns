package plugin.persistence;

import java.util.ArrayList;
import java.util.UUID;

import plugin.settlements.Settlement;

public interface HistoryAccess 
{
  public Settlement createSettlement(String name, org.bukkit.Location location);
  public Settlement getSettlement(UUID id);
  public boolean deleteSettlement(String name);
  public ArrayList<Settlement> getSettlements();
}