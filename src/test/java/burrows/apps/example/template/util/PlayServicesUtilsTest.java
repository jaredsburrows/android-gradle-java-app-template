package burrows.apps.example.template.util;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import androidx.annotation.IntRange;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static burrows.apps.example.template.util.PlayServicesUtils.hasGooglePlayServices;
import static com.google.android.gms.common.ConnectionResult.SUCCESS;
import static org.easymock.EasyMock.anyObject;
import static org.easymock.EasyMock.expect;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.powermock.api.easymock.PowerMock.createMock;
import static org.powermock.api.easymock.PowerMock.expectLastCall;
import static org.powermock.api.easymock.PowerMock.mockStatic;
import static org.powermock.api.easymock.PowerMock.replay;
import static org.powermock.api.easymock.PowerMock.replayAll;
import static org.powermock.api.easymock.PowerMock.verifyAll;
import static org.powermock.api.support.SuppressCode.suppressConstructor;

/**
 * Junit Test using Powermock/Easymock with Hamcrest matchers.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(GoogleApiAvailability.class)
public class PlayServicesUtilsTest {
    private Activity mockActivity;
    private Dialog mockDialog;
    private GoogleApiAvailability mockSingleton;

    @Before
    public void setUp() {
        mockActivity = createMock(Activity.class);
        mockDialog = createMock(Dialog.class);

        suppressConstructor(GoogleApiAvailability.class);
        mockStatic(GoogleApiAvailability.class);
        mockSingleton = createMock(GoogleApiAvailability.class);
        expect(GoogleApiAvailability.getInstance()).andReturn(mockSingleton).anyTimes();
    }

    @Test
    public void testSuccess() {
        expect(mockSingleton.isGooglePlayServicesAvailable(mockActivity)).andReturn(SUCCESS);

        replay(GoogleApiAvailability.class);
        replay(mockSingleton);
        replayAll(mockActivity);

        assertThat(hasGooglePlayServices(mockActivity, GoogleApiAvailability.getInstance()), is(true));
        verifyAll();
    }

    @Test
    public void testServiceDisabled() {
        failTest(ConnectionResult.SERVICE_DISABLED);
    }

    @Test
    public void testServiceInvalid() {
        failTest(ConnectionResult.SERVICE_INVALID);
    }

    @Test
    public void testServiceMissing() {
        failTest(ConnectionResult.SERVICE_MISSING);
    }

    @Test
    public void testServiceVersionUpdateRequired() {
        failTest(ConnectionResult.SERVICE_VERSION_UPDATE_REQUIRED);
    }

    private void failTest(@IntRange(from = ConnectionResult.SUCCESS,
        to = ConnectionResult.RESTRICTED_PROFILE) int error) {
        expect(mockSingleton.isGooglePlayServicesAvailable(mockActivity)).andReturn(error);
        expect(mockSingleton.getErrorDialog(mockActivity, error, 0)).andReturn(mockDialog);

        mockDialog.setOnCancelListener(anyObject(DialogInterface.OnCancelListener.class));
        expectLastCall().once();

        mockDialog.show();
        expectLastCall().once();

        replayAll(mockActivity, mockDialog);
        assertThat(hasGooglePlayServices(mockActivity, GoogleApiAvailability.getInstance()), is(false));
        verifyAll();
    }
}
