package burrows.apps.example.template.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

import burrows.apps.example.template.R;
import burrows.apps.example.template.util.AdUtils;

public final class PlaceholderFragment extends Fragment {
  /**
   * Static Adview.
   */
  private AdView adView;
  /**
   * AdMob Full-Page Ad.
   */
  InterstitialAd loadedInterstitialAd;
  /**
   * Button to launch Interstitial Ad.
   */
  private Button startInterstitial;
  /**
   * ClickListener for Button.
   */
  private final OnClickListener onClickListener = v -> showInterstitialAd();
  private final AdListener adListener = new AdListener() {
    @Override
    public void onAdClicked() {
      super.onAdClicked();
      Toast.makeText(requireActivity(), "Ad clicked.", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAdClosed() {
      super.onAdClosed();
      Toast.makeText(requireActivity(), "Ad closed.", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAdFailedToLoad(LoadAdError errorCode) {
      super.onAdFailedToLoad(errorCode);
      Toast.makeText(requireActivity(), "Ad failed to load: " +
        AdUtils.getErrorReason(errorCode.getCode()), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAdImpression() {
      super.onAdImpression();
      Toast.makeText(requireActivity(), "Ad impression.", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAdLoaded() {
      super.onAdLoaded();
      Toast.makeText(requireActivity(), "Ad loaded.", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAdOpened() {
      super.onAdOpened();
      Toast.makeText(requireActivity(), "Ad opened.", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAdSwipeGestureClicked() {
      super.onAdSwipeGestureClicked();
      Toast.makeText(requireActivity(), "Ad swipe gesture.", Toast.LENGTH_SHORT).show();
    }
  };

  private final InterstitialAdLoadCallback interstitialAdLoadCallback =
    new InterstitialAdLoadCallback() {
      @Override
      public void onAdLoaded(InterstitialAd interstitialAd) {
        // The interstitialAd has loaded, show the ad.
        Toast.makeText(requireActivity(), "Ad loaded.", Toast.LENGTH_SHORT).show();
        loadedInterstitialAd = interstitialAd;
      }

      @Override
      public void onAdFailedToLoad(LoadAdError loadAdError) {
        // Handle the error
        Toast.makeText(requireActivity(), "Ad failed to load: " +
          AdUtils.getErrorReason(loadAdError.getCode()), Toast.LENGTH_SHORT).show();
      }
    };

  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                           @Nullable Bundle savedInstanceState) {
    super.onCreateView(inflater, container, savedInstanceState);

    final View rootView = inflater.inflate(R.layout.fragment_main, container, false);

    startInterstitial = rootView.findViewById(R.id.buttonStartInterstitial);
    startInterstitial.setOnClickListener(onClickListener);

    adView = rootView.findViewById(R.id.adView);
    adView.setAdListener(adListener);
    adView.loadAd(new AdRequest.Builder().build());

    InterstitialAd.load(requireActivity(), getString(R.string.app_ad_interstitial),
      new AdRequest.Builder().build(), interstitialAdLoadCallback);

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
    if (loadedInterstitialAd != null) {
      loadedInterstitialAd.show(requireActivity());
    } else {
      Toast.makeText(requireActivity(), "Interstitial Ad has not loaded.",
        Toast.LENGTH_SHORT).show();
    }
  }
}
