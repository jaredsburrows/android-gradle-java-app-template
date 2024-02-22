package burrows.apps.example.template.activity;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.MobileAds;

import burrows.apps.example.template.R;
import burrows.apps.example.template.fragment.PlaceholderFragment;

public final class MainActivity extends AppCompatActivity {
  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    MobileAds.initialize(this, initializationStatus -> {
      Toast.makeText(this, "Mobile Ads initialized.", Toast.LENGTH_SHORT).show();
    });

    if (savedInstanceState == null) {
      getSupportFragmentManager().beginTransaction().add(R.id.container, new PlaceholderFragment(),
        PlaceholderFragment.class.getSimpleName()).commit();
    }
  }
}
