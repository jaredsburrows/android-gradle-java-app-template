package burrows.apps.example.template.util;

import org.junit.Test;

import static burrows.apps.example.template.util.AdUtils.getErrorReason;
import static com.google.android.gms.ads.AdRequest.ERROR_CODE_INTERNAL_ERROR;
import static com.google.android.gms.ads.AdRequest.ERROR_CODE_INVALID_REQUEST;
import static com.google.android.gms.ads.AdRequest.ERROR_CODE_NETWORK_ERROR;
import static com.google.android.gms.ads.AdRequest.ERROR_CODE_NO_FILL;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author <a href="mailto:jaredsburrows@gmail.com">Jared Burrows</a>
 */
public class AdUtilsTest {

    @Test
    public void testGetErrorReason() {
        assertThat(getErrorReason(-1), is("Internal Error"));
        assertThat(getErrorReason(ERROR_CODE_INTERNAL_ERROR), is("Internal Error"));
        assertThat(getErrorReason(ERROR_CODE_INVALID_REQUEST), is("Invalid Request"));
        assertThat(getErrorReason(ERROR_CODE_NETWORK_ERROR), is("Network Error"));
        assertThat(getErrorReason(ERROR_CODE_NO_FILL), is("No Fill"));
    }
}
