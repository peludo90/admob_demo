package co.com.nullpoint.testcourse;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickBanner(View view) {
        startActivity(new Intent(this, AdBannerActivity.class));
    }

    public void onClickAdActivity(View view) {
        startActivity(new Intent(this, InterstitialActivity.class));
    }
}
