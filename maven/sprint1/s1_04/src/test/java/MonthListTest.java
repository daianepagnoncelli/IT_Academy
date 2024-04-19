import n1exercise1.MonthList;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

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
        assertEquals("agost", monthList.getMonths().get(7));
    }
}

