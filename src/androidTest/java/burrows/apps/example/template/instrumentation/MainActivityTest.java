package burrows.apps.example.template.instrumentation;

import androidx.annotation.NonNull;
import androidx.test.rule.ActivityTestRule;
import burrows.apps.example.template.activity.MainActivity;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

public class MainActivityTest {
    @NonNull
    @Rule
    public ActivityTestRule<MainActivity> activity = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void shouldDisplayMainScreenWithCorrectTitle() {
        onView(withText("AndroidGradleTemplate")).check(matches(isDisplayed()));
    }
}
