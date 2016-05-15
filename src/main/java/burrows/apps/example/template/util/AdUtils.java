package burrows.apps.example.template.util;

import com.google.android.gms.ads.AdRequest;

/**
 * @author <a href="mailto:jaredsburrows@gmail.com">Jared Burrows</a>
 * @since 0.0.1
 */
public final class AdUtils {

    private AdUtils() {}

    public static String getErrorReason(final int errorCode) {
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
