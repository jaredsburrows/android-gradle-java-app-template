package burrows.apps.example.template.fragment;

import android.support.v4.app.FragmentActivity;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;

import burrows.apps.example.template.R;
import burrows.apps.example.template.test.TestBase;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.robolectric.util.SupportFragmentTestUtil.startFragment;
import static org.robolectric.util.SupportFragmentTestUtil.startVisibleFragment;

/**
 * @author <a href="mailto:jaredsburrows@gmail.com">Jared Burrows</a>
 * @since 0.0.1
 */
@RunWith(RobolectricGradleTestRunner.class)
@SuppressWarnings({"ConstantConditions", "ResourceType"})
public class PlaceHolderFragmentTest extends TestBase {

    PlaceholderFragment fragment;

    @Before
    public void setUp() {
        fragment = new PlaceholderFragment();
        startFragment(fragment, FragmentActivity.class);
    }

    // --------------------------------------------
    // Testing the Fragment itself
    // --------------------------------------------

    @Test
    public void test_startFragmentView() {
        assertThat(fragment, not(nullValue()));
        assertThat(fragment.getView(), not(nullValue()));
        assertThat(fragment.getActivity(), not(nullValue()));
        assertThat(fragment.getActivity(), instanceOf(FragmentActivity.class));
    }

    @Test
    public void test_startFragmentUniqueView() {
        assertThat(fragment.getView().findViewById(R.id.buttonStartInterstitial), not(nullValue()));
        assertThat(fragment.getView().findViewById(R.id.adView), not(nullValue()));
    }

    @Test
    public void test_startVisible() {
        PlaceholderFragment fragment = new PlaceholderFragment();
        assertThat(fragment.isVisible(), is(false));
        assertThat(fragment.isAdded(), is(false));

        startVisibleFragment(fragment);

        assertThat(fragment, not(nullValue()));
        assertThat(fragment.getView(), not(nullValue()));
        assertThat(fragment.getView().getWindowToken(), not(nullValue()));
        assertThat(fragment.getActivity(), not(nullValue()));
        assertThat(fragment.isAdded(), is(true));
        assertThat(fragment.isVisible(), is(true));
    }

    // --------------------------------------------
    // Testing the button clicks
    // --------------------------------------------

    @Test
    public void test_showInterstitialAd() throws Exception {
        fragment.getView().findViewById(R.id.buttonStartInterstitial).performClick();

        Thread.sleep(3000);

        fragment.getView().findViewById(R.id.buttonStartInterstitial).performClick();
    }

    // --------------------------------------------
    // Testing ad listeners
    // --------------------------------------------

    @Test
    public void test_adViewListeners() {
        AdListener adListener = ((AdView) fragment.getView().findViewById(R.id.adView)).getAdListener();
        adListener.onAdClosed();
        adListener.onAdFailedToLoad(AdRequest.ERROR_CODE_INTERNAL_ERROR);
        adListener.onAdFailedToLoad(AdRequest.ERROR_CODE_INVALID_REQUEST);
        adListener.onAdFailedToLoad(AdRequest.ERROR_CODE_NETWORK_ERROR);
        adListener.onAdFailedToLoad(AdRequest.ERROR_CODE_NO_FILL);
        adListener.onAdLeftApplication();
        adListener.onAdLoaded();
        adListener.onAdOpened();
    }
}
