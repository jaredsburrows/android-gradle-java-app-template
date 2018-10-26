package burrows.apps.example.template.activity;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import burrows.apps.example.template.R;
import burrows.apps.example.template.fragment.PlaceholderFragment;
import com.google.android.gms.ads.MobileAds;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileAds.initialize(this, getString(R.string.app_ads_id));

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                .add(R.id.container, new PlaceholderFragment(), PlaceholderFragment.class.getSimpleName())
                .commit();
        }
    }
}
