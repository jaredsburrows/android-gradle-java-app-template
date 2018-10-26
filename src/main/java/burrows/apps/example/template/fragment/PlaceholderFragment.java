package burrows.apps.example.template.fragment;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.appcompat.widget.AppCompatButton;
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

public class PlaceholderFragment extends Fragment {
    /**
     * Static Adview.
     */
    private AdView adView;
    /**
     * AdMob Full-Page Ad.
     */
    private InterstitialAd interstitialAd;
    /**
     * Button to launch Interstitial Ad.
     */
    private AppCompatButton startInterstitial;
    /**
     * ClickListener for Button.
     */
    private final OnClickListener onClickListener = v -> showInterstitialAd();
    private final AdListener adListener = new AdListener() {
        @Override
        public void onAdClosed() {
            super.onAdClosed();
            Toast.makeText(requireActivity(), "Ad has closed.", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onAdFailedToLoad(final int errorCode) {
            super.onAdFailedToLoad(errorCode);
            Toast.makeText(requireActivity(), "Ad has failed to load: " + AdUtils.getErrorReason(errorCode), Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onAdLeftApplication() {
            super.onAdLeftApplication();
            Toast.makeText(requireActivity(), "Ad has left the application.", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onAdOpened() {
            super.onAdOpened();
            Toast.makeText(requireActivity(), "Ad has opened.", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onAdLoaded() {
            super.onAdLoaded();
            Toast.makeText(requireActivity(), "Ad has loaded.", Toast.LENGTH_SHORT).show();
        }
    };

    @NonNull
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        final View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        startInterstitial = rootView.findViewById(R.id.buttonStartInterstitial);
        startInterstitial.setOnClickListener(onClickListener);

        adView = rootView.findViewById(R.id.adView);
        adView.setAdListener(adListener);
        adView.loadAd(new AdRequest.Builder().build());

        interstitialAd = new InterstitialAd(rootView.getContext());
        interstitialAd.setAdUnitId(getString(R.string.app_ad_interstitial));
        interstitialAd.setAdListener(adListener);
        interstitialAd.loadAd(new AdRequest.Builder().build());

        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();

        if (adView != null) {
            adView.resume();
        }
    }

    @Override
    public void onPause() {
        if (adView != null) {
            adView.pause();
        }

        super.onPause();
    }

    @Override
    public void onDestroy() {
        if (adView != null) {
            adView.destroy();
        }

        super.onDestroy();
    }

    private void showInterstitialAd() {
        if (interstitialAd.isLoaded()) {
            interstitialAd.show();
        } else {
            // Simply let the user know it has not been loaded and try again.
            Toast.makeText(requireActivity(), "Interstitial Ad has not loaded.", Toast.LENGTH_SHORT).show();
            interstitialAd.loadAd(new AdRequest.Builder().build());
        }
    }
}
