package co.com.nullpoint.testcourse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

public class InterstitialActivity extends AppCompatActivity {

    Button btnShow;
    InterstitialAd interstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interstitial);
        btnShow = findViewById(R.id.btn_create_interstitial);
        btnShow.setEnabled(false);

    }

    public void onClickLoad(View view) {
        btnShow.setEnabled(false);
        btnShow.setText(R.string.interstitial_loading);

        interstitialAd = new InterstitialAd(this);
        interstitialAd.setAdUnitId(getString(R.string.interstitial_ad_unit_id));
        interstitialAd.setAdListener(new ToastAdListener(this) {
            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
                btnShow.setEnabled(true);
                btnShow.setText(R.string.interstitial_show);
            }

            @Override
            public void onAdFailedToLoad(int i) {
                super.onAdFailedToLoad(i);
                btnShow.setText(getErrorReason());
            }
        });

        AdRequest request = new AdRequest.Builder().build();
        interstitialAd.loadAd(request);
    }

    public void onClickCreate(View view) {
        if(interstitialAd.isLoaded()){
            interstitialAd.show();
        }

        btnShow.setText(R.string.interstitial_not_ready);
        btnShow.setEnabled(false);
    }

}
