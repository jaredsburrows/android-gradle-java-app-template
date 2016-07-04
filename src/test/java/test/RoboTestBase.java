package test;

import android.app.Application;
import android.content.Context;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.RuntimeEnvironment;

import static org.robolectric.Robolectric.flushBackgroundThreadScheduler;
import static org.robolectric.Robolectric.flushForegroundThreadScheduler;
import static org.robolectric.shadows.ShadowApplication.runBackgroundTasks;
import static org.robolectric.shadows.ShadowLooper.runUiThreadTasksIncludingDelayedTasks;

/**
 * Robolectric + JUnit Tests.
 *
 * @author <a href="mailto:jaredsburrows@gmail.com">Jared Burrows</a>
 */
@RunWith(RobolectricGradleTestRunner.class)
public abstract class RoboTestBase extends TestBase {

    // Android Related
    protected static final Context context = RuntimeEnvironment.application;
    protected static final Application application = RuntimeEnvironment.application;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        // Turn off Google Analytics - Does not need to work anymore
//        final ShadowApplication shadowApplication = Shadows.shadowOf(RuntimeEnvironment.application);
//        shadowApplication.declareActionUnbindable("com.google.android.gms.analytics.service.START");

        // Force success
//        ShadowGooglePlayServicesUtil.setIsGooglePlayServicesAvailable(ConnectionResult.SUCCESS);
    }

    @After
    public void tearDown() throws Exception {
        super.tearDown();
    }

    public void finishThreads() {
        runBackgroundTasks();
        flushForegroundThreadScheduler();
        flushBackgroundThreadScheduler();
        runUiThreadTasksIncludingDelayedTasks();
    }
}
