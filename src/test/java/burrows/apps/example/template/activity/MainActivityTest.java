package burrows.apps.example.template.activity;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.robolectric.util.ActivityController;
import test.RoboTestBase;

import static org.assertj.core.api.Assertions.assertThat;
import static org.robolectric.Robolectric.buildActivity;

/**
 * Robolectric test.
 *
 * @author <a href="mailto:jaredsburrows@gmail.com">Jared Burrows</a>
 */
public class MainActivityTest extends RoboTestBase {
    private ActivityController<MainActivity> mController;
    private MainActivity sut;

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();

        // Create new activity
        this.mController = buildActivity(MainActivity.class);
        this.sut = this.mController.create().postCreate(null).start().resume().visible().get();
    }

    @Override
    @After
    public void tearDown() throws Exception {
        super.tearDown();

        // Destroy activity
        this.mController.pause().stop().destroy();
        this.sut.finish();
    }

    @Test
    public void testOnCreateNotNull() {
        assertThat(this.sut).isNotNull();
    }
}
