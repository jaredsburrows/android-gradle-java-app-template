package burrows.apps.example.template.util;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import android.app.Activity;
import android.app.Dialog;

import androidx.annotation.IntRange;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

@RunWith(AndroidJUnit4.class)
public final class PlayServicesUtilsTest {
  @Rule
  public final MockitoRule rule = MockitoJUnit.rule();
  @Mock
  private Activity mockActivity;
  @Mock
  private Dialog mockDialog;
  @Mock
  private GoogleApiAvailability mockSingleton;

  private static MockedStatic<GoogleApiAvailability> mockedStatic;

  @Before
  public void setUp() {
    mockedStatic = mockStatic(GoogleApiAvailability.class);
    when(GoogleApiAvailability.getInstance()).thenReturn(mockSingleton);
  }

  @After
  public void tearDown() {
    mockedStatic.close();
  }

  @Test
  public void testSuccess() {
    when(mockSingleton.isGooglePlayServicesAvailable(mockActivity)).thenReturn(ConnectionResult.SUCCESS);

    assertTrue(PlayServicesUtils.hasGooglePlayServices(mockActivity, GoogleApiAvailability.getInstance()));
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

  private void failTest(@IntRange(from = ConnectionResult.SUCCESS, to = ConnectionResult.RESTRICTED_PROFILE) int error) {
    when(mockSingleton.isGooglePlayServicesAvailable(mockActivity)).thenReturn(error);
    when(mockSingleton.getErrorDialog(mockActivity, error, 0)).thenReturn(mockDialog);
    doNothing().when(mockDialog).setOnCancelListener(any());
    doNothing().when(mockDialog).show();

    assertFalse(PlayServicesUtils.hasGooglePlayServices(mockActivity, GoogleApiAvailability.getInstance()));

    verify(mockDialog).setOnCancelListener(any());
    verify(mockDialog).show();
  }
}
