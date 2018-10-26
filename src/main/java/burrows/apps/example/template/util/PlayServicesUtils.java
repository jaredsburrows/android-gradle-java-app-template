package burrows.apps.example.template.util;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import androidx.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;

/**
 * Google Play Services utility class.
 * https://developers.google.com/android/reference/com/google/android/gms/analytics/GoogleAnalytics. I have stopped
 * checking for Google Play Services because it pops up a dialog forcing a user to upgrade.
 */
public final class PlayServicesUtils {
    private PlayServicesUtils() {
        throw new AssertionError("No instances.");
    }

    /**
     * Check if device has the correct Google Play Services version.
     *
     * @param activity     Current activity.
     * @param availability New instance of GoogleApiAvailability.
     * @return True if there was a successful connection ot Google Play Services.
     */
    public static boolean hasGooglePlayServices(@NonNull Activity activity, @NonNull GoogleApiAvailability availability) {
        final int result = availability.isGooglePlayServicesAvailable(activity);

        if (result == ConnectionResult.SUCCESS) {
            return true;
        } else {
            final Dialog dialog = availability.getErrorDialog(activity, result, 0);
            // Let user use the application
            dialog.setOnCancelListener(DialogInterface::cancel);
            dialog.show();
        }
        return false;
    }
}
