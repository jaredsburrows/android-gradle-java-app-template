package burrows.apps.example.template.util;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import com.google.android.gms.ads.AdRequest;

public final class AdUtils {
    private AdUtils() {
        throw new AssertionError("No instances.");
    }

    @NonNull
    public static String getErrorReason(@IntRange(from = AdRequest.ERROR_CODE_INTERNAL_ERROR,
            to = AdRequest.ERROR_CODE_NO_FILL) int errorCode) {
        switch (errorCode) {
            default:
            case AdRequest.ERROR_CODE_INTERNAL_ERROR:
                return "Internal Error";

            case AdRequest.ERROR_CODE_INVALID_REQUEST:
                return "Invalid Request";

            case AdRequest.ERROR_CODE_NETWORK_ERROR:
                return "Network Error";

            case AdRequest.ERROR_CODE_NO_FILL:
                return "No Fill";
        }
    }
}
