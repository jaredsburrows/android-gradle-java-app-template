package burrows.apps.example.template.activity;

import android.os.Bundle;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;

import burrows.apps.example.template.test.TestBase;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsNull.nullValue;
import static org.robolectric.Robolectric.buildActivity;

/**
 * @author <a href="mailto:jaredsburrows@gmail.com">Jared Burrows</a>
 * @since 0.0.1
 */
@RunWith(RobolectricGradleTestRunner.class)
public class MainActivityTest extends TestBase {

    @Test
    public void test_notNull() {
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
    public void test_onCreate_notNull() {
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
