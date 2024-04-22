import n2exercise1.StringLengthMatcher;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class StringLengthMatcherTest {

    @Test
    public void testStringLengthMatcher() {
        String testString = "Mordor";

        assertThat(testString, StringLengthMatcher.hasLength(is(6)));
    }
}
