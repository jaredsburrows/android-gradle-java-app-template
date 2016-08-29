package burrows.apps.example.template.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Toast;
import burrows.apps.example.template.R;
import burrows.apps.example.template.util.AdUtils;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

/**
 * @author <a href="mailto:jaredsburrows@gmail.com">Jared Burrows</a>
 */
public class PlaceholderFragment extends Fragment {
    /**
     * Static Adview.
     */
    private AdView mAdView;
    /**
     * AdMob Full-Page Ad.
     */
    private InterstitialAd mInterstitialAd;
    /**
     * Button to launch Interstitial Ad.
     */
    private AppCompatButton mButtonStartInterstitial;
    /**
     * ClickListener for Button.
     */
    private final OnClickListener mOnClickListener = new OnClickListener() {
        @Override
        public void onClick(final View v) {
            showInterstitialAd();
        }
    };
    /**
     * Adview listener.
     */
    private final AdListener mAdListener = new AdListener() {
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
        super.onCreateView(inflater, container, savedInstanceState);

        final View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        this.mButtonStartInterstitial = (AppCompatButton) rootView.findViewById(R.id.buttonStartInterstitial);
        this.mButtonStartInterstitial.setOnClickListener(this.mOnClickListener);

        this.mAdView = (AdView) rootView.findViewById(R.id.adView);
        this.mAdView.setAdListener(this.mAdListener);
        this.mAdView.loadAd(new AdRequest.Builder().build());

        this.mInterstitialAd = new InterstitialAd(this.getActivity());
        this.mInterstitialAd.setAdUnitId(this.getString(R.string.app_ad));
        this.mInterstitialAd.setAdListener(this.mAdListener);
        this.mInterstitialAd.loadAd(new AdRequest.Builder().build());

        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();

        if (this.mAdView != null) {
            this.mAdView.resume();
        }
    }

    @Override
    public void onPause() {
        if (this.mAdView != null) {
            this.mAdView.pause();
        }

        super.onPause();
    }

    @Override
    public void onDestroy() {
        if (this.mAdView != null) {
            this.mAdView.destroy();
        }

        super.onDestroy();
    }

    private void showInterstitialAd() {
        if (this.mInterstitialAd.isLoaded()) {
            this.mInterstitialAd.show();
        } else {
            // Simply let the user know it has not been loaded and try again.
            Toast.makeText(this.getActivity(), "Interstitial Ad has not loaded.", Toast.LENGTH_SHORT).show();
            this.mInterstitialAd.loadAd(new AdRequest.Builder().build());
        }
    }
}
