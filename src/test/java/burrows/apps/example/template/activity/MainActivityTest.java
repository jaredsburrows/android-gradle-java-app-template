package burrows.apps.example.template.activity;

import android.os.Bundle;
import org.junit.Test;
import org.robolectric.Robolectric;
import test.RoboTestBase;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsNull.nullValue;
import static org.robolectric.Robolectric.buildActivity;

/**
 * @author <a href="mailto:jaredsburrows@gmail.com">Jared Burrows</a>
 */
public class MainActivityTest extends RoboTestBase {

    @Test
    public void testNotNull() {
        MainActivity mainActivity = buildActivity(MainActivity.class)
                .create()
                .start()
                .resume()
                .pause()
                .destroy()
                .visible()
                .get();
        assertThat(mainActivity, not(nullValue()));
    }

    @Test
    public void testOnCreateNotNull() {
        Bundle savedInstanceState = new Bundle();
        MainActivity mainActivity = Robolectric.buildActivity(MainActivity.class)
                .create(savedInstanceState)
                .start()
                .resume()
                .pause()
                .destroy()
                .visible()
                .get();
        assertThat(mainActivity, not(nullValue()));
    }
}
