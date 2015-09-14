package burrows.apps.example.template.test;

import com.google.android.gms.common.ConnectionResult;

import org.junit.After;
import org.junit.Before;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.Shadows;
import org.robolectric.shadows.ShadowApplication;
import org.robolectric.shadows.gms.ShadowGooglePlayServicesUtil;
import org.robolectric.util.ReflectionHelpers;


import burrows.apps.example.template.BuildConfig;

/**
 * @author <a href="mailto:jaredsburrows@gmail.com">Jared Burrows</a>
 * @since 0.0.1
 */
public class TestBase {

    @Before
    public void setUp() throws Exception {
        // Turn off Google Analytics - Does not need to work anymore
        final ShadowApplication shadowApplication = Shadows.shadowOf(RuntimeEnvironment.application);
        shadowApplication.declareActionUnbindable("com.google.android.gms.analytics.service.START");

        // Force success
        ShadowGooglePlayServicesUtil.setIsGooglePlayServicesAvailable(ConnectionResult.SUCCESS);

        // Use the debug configuration
        ReflectionHelpers.setStaticField(BuildConfig.class, "DEBUG", false);
    }

    @After
    public void tearDown() throws Exception {

    }
}
