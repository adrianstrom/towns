package plugin;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.bukkit.Location;
import org.junit.Test;
import plugin.persistence.MockRepository;
import plugin.settlements.Hamlet;
import plugin.settlements.Homestead;
import plugin.settlements.Town;
import plugin.settlements.base.Settlement;

public class AppTest 
{
    public MockRepository getRepo() {
        MockRepository settlementRepository = new MockRepository();
        settlementRepository.createSettlement("Skien", new Location(null, 1, 2, 3, 4, 5), Homestead.class);
        settlementRepository.createSettlement("Porsgrunn", new Location(null, 1, 2, 3, 4, 5), Hamlet.class);
        settlementRepository.createSettlement("Bamble", new Location(null, 1, 2, 3, 4, 5), Town.class);
        return settlementRepository;
    }

    @Test
    public void hasSettlement() {
        // arrange
        MockRepository mockRepository = getRepo();

        // act
        Settlement settlement = mockRepository.getSettlement("Skien");

        // assert
        assertNull(settlement);
    }

    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
}
