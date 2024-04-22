import n1exercise1.MonthList;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class MonthListTest {

    private MonthList monthList;

    @Before
    public void setUp() {
        monthList = new MonthList();
    }

    @Test
    public void testListSize() {
        assertEquals(12, monthList.getMonths().size());
    }

    @Test
    public void testListNotNull() {
        assertNotNull(monthList.getMonths());
    }

    @Test
    public void testAugustPosition() {
        assertEquals("August", monthList.getMonths().get(7));
    }
}