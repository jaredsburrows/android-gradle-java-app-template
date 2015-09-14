package burrows.apps.example.template.util;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;

import com.google.android.gms.common.GooglePlayServicesUtil;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static burrows.apps.example.template.util.PlayServicesUtils.checkGooglePlayServices;
import static com.google.android.gms.common.ConnectionResult.SERVICE_DISABLED;
import static com.google.android.gms.common.ConnectionResult.SERVICE_INVALID;
import static com.google.android.gms.common.ConnectionResult.SERVICE_MISSING;
import static com.google.android.gms.common.ConnectionResult.SERVICE_VERSION_UPDATE_REQUIRED;
import static com.google.android.gms.common.ConnectionResult.SUCCESS;
import static com.google.android.gms.common.GooglePlayServicesUtil.getErrorDialog;
import static com.google.android.gms.common.GooglePlayServicesUtil.isGooglePlayServicesAvailable;
import static org.easymock.EasyMock.anyObject;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.expectLastCall;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.powermock.api.easymock.PowerMock.mockStatic;
import static org.powermock.api.easymock.PowerMock.replayAll;
import static org.powermock.api.easymock.PowerMock.verifyAll;

/**
 * @author <a href="mailto:jaredsburrows@gmail.com">Jared Burrows</a>
 * @since 0.0.1
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(GooglePlayServicesUtil.class)
public class PlayServicesUtilsTest {

    Activity mockActivity;
    Dialog mockDialog;
    DialogInterface.OnCancelListener mockCancelListener;

    @Before
    public void setUp() {
        mockActivity = createMock(Activity.class);
        mockDialog = createMock(Dialog.class);
        mockCancelListener = createMock(DialogInterface.OnCancelListener.class);
        mockStatic(GooglePlayServicesUtil.class);

        // since there is only 1 static method in the class
        PlayServicesUtils playServicesUtils = new PlayServicesUtils();
        assertThat(playServicesUtils, not(nullValue()));
    }

//    @After
//    public void tearDown() {
//        verifyAll();
//    }

    @Test
    public void test_success() {
        mockStatic(GooglePlayServicesUtil.class);
        expect(isGooglePlayServicesAvailable(mockActivity)).andReturn(SUCCESS);
        replayAll(mockActivity);
        assertThat(checkGooglePlayServices(mockActivity), is(true));
        verifyAll();
    }

    @Test
    public void test_serviceDisabled() {
        failTest(SERVICE_DISABLED);
    }

    @Test
    public void test_serviceInvalid() {
        failTest(SERVICE_INVALID);
    }

    @Test
    public void test_serviceMissing() {
        failTest(SERVICE_MISSING);
    }

    @Test
    public void test_serviceVersionUpdateRequired() {
        failTest(SERVICE_VERSION_UPDATE_REQUIRED);
    }

    @Test
    public void test_failSwitchCase() {
        failTest(-1);
    }

    public void failTest(int error) {
        expect(isGooglePlayServicesAvailable(mockActivity)).andReturn(error);
        expect(getErrorDialog(error, mockActivity, 0)).andReturn(mockDialog);

        mockDialog.setOnCancelListener(anyObject(DialogInterface.OnCancelListener.class));
        expectLastCall().once();

        mockDialog.show();
        expectLastCall().once();

        replayAll(mockActivity, mockDialog);
        assertThat(checkGooglePlayServices(mockActivity), is(false));
        verifyAll();
    }
}
