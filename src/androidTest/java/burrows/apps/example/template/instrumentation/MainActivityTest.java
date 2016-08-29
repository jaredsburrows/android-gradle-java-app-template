package burrows.apps.example.template.instrumentation;

import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import burrows.apps.example.template.activity.MainActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Espresso Test.
 *
 * @author <a href="mailto:jaredsburrows@gmail.com">Jared Burrows</a>
 */
public class MainActivityTest {
    @Rule public ActivityTestRule<MainActivity> activity = new ActivityTestRule<>(MainActivity.class);

    @Test public void shouldDisplayMainScreenWithCorrectTitle() {
        onView(withText("AndroidGradleTemplate")).check(matches(isDisplayed()));
    }
}
