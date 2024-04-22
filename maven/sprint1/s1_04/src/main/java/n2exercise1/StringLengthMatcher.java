package n2exercise1;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class StringLengthMatcher extends TypeSafeMatcher<String> {

    private final Matcher<? super Integer> lengthMatcher;

    public StringLengthMatcher(Matcher<? super Integer> lengthMatcher) {
        this.lengthMatcher = lengthMatcher;
    }

    @Override
    protected boolean matchesSafely(String item) {
        return lengthMatcher.matches(item.length());
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("a string with length ").appendDescriptionOf(lengthMatcher);
    }

    public static StringLengthMatcher hasLength(Matcher<? super Integer> lengthMatcher) {
        return new StringLengthMatcher(lengthMatcher);
    }
}
