package burrows.apps.example.template.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import burrows.apps.example.template.R;
import burrows.apps.example.template.util.AdUtils;
import burrows.apps.example.template.util.PlayServicesUtils;

/**
 * @author <a href="mailto:jaredsburrows@gmail.com">Jared Burrows</a>
 * @since 0.0.1
 */
public class PlaceholderFragment extends Fragment {

    /** Static Adview. */
    private AdView adView;
    /** AdMob Full-Page Ad. */
    private InterstitialAd interstitialAd;
    /** Button to launch Interstitial Ad. */
    private Button buttonStartInterstitial;
    /** ClickListener for Button. */
    private final OnClickListener onClickListener = new OnClickListener() {
        @Override
        public void onClick(final View v) {
            showInterstitialAd();
        }
    };
    /** Adview listener. */
    private final AdListener adListener = new AdListener() {
        @Override
        public void onAdClosed() {
            super.onAdClosed();
            Toast.makeText(getActivity(), "Ad has closed.", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onAdFailedToLoad(final int errorCode) {
            super.onAdFailedToLoad(errorCode);
            Toast.makeText(getActivity(), "Ad has failed to load: " + AdUtils.getErrorReason(errorCode), Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onAdLeftApplication() {
            super.onAdLeftApplication();
            Toast.makeText(getActivity(), "Ad has left the application.", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onAdOpened() {
            super.onAdOpened();
            Toast.makeText(getActivity(), "Ad has opened.", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onAdLoaded() {
            super.onAdLoaded();
            Toast.makeText(getActivity(), "Ad has loaded.", Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        this.buttonStartInterstitial = (Button) rootView.findViewById(R.id.buttonStartInterstitial);
        this.buttonStartInterstitial.setOnClickListener(this.onClickListener);

        this.adView = (AdView) rootView.findViewById(R.id.adView);
        this.adView.setAdListener(this.adListener);
        this.adView.loadAd(new AdRequest.Builder().build());

        this.interstitialAd = new InterstitialAd(this.getActivity());
        this.interstitialAd.setAdUnitId(this.getString(R.string.app_ad));
        this.interstitialAd.setAdListener(this.adListener);
        this.interstitialAd.loadAd(new AdRequest.Builder().build());

        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();

        /* Check for Google Play Services */

        PlayServicesUtils.checkGooglePlayServices(this.getActivity());

        if (this.adView != null) {
            this.adView.resume();
        }
    }

    @Override
    public void onPause() {
        if (this.adView != null) {
            this.adView.pause();
        }

        super.onPause();
    }

    @Override
    public void onDestroy() {
        if (this.adView != null) {
            this.adView.destroy();
        }

        super.onDestroy();
    }

    private void showInterstitialAd() {
        if (this.interstitialAd.isLoaded()) {
            this.interstitialAd.show();
        } else {
            /* Simply let the user know it has not been loaded and try again. */
            Toast.makeText(this.getActivity(), "Interstitial Ad has not loaded.", Toast.LENGTH_SHORT).show();
            this.interstitialAd.loadAd(new AdRequest.Builder().build());
        }
    }
}
