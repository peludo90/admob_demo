package co.com.nullpoint.testcourse;

import android.content.Context;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;

import static com.google.android.gms.ads.AdRequest.ERROR_CODE_INTERNAL_ERROR;
import static com.google.android.gms.ads.AdRequest.ERROR_CODE_INVALID_REQUEST;
import static com.google.android.gms.ads.AdRequest.ERROR_CODE_NETWORK_ERROR;
import static com.google.android.gms.ads.AdRequest.ERROR_CODE_NO_FILL;

/**
 * Created by obed.gonzalez on 30/01/2018.
 */

public class ToastAdListener extends AdListener {

    Context mContext;
    String errorReason = null;

    public ToastAdListener(Context context) {
        mContext = context;
    }

    @Override
    public void onAdFailedToLoad(int i) {
        super.onAdFailedToLoad(i);
        switch (i) {
            case ERROR_CODE_INTERNAL_ERROR:
                errorReason = "Internal error";
                break;
            case ERROR_CODE_INVALID_REQUEST:
                errorReason = "Invalid request";
                break;
            case ERROR_CODE_NETWORK_ERROR:
                errorReason = "Network error";
                break;
            case ERROR_CODE_NO_FILL:
                errorReason = "No fill";
                break;
            default:
                errorReason = "Unknown";
                break;
        }
        Toast.makeText(mContext, String.format("onAdFailedToLoad(%s)", errorReason), Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onAdLoaded() {
        super.onAdLoaded();
        Toast.makeText(mContext, "onAdLoaded", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAdOpened() {
        Toast.makeText(mContext, "onAdOpened", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAdClosed() {
        Toast.makeText(mContext, "onAdClosed", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAdClicked() {
        Toast.makeText(mContext, "onAdClicked", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAdLeftApplication() {
        Toast.makeText(mContext, "onAdLeftApplication", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAdImpression() {
        Toast.makeText(mContext, "onAdImpression", Toast.LENGTH_SHORT).show();
    }

    public String getErrorReason() {
        return (errorReason == null) ? "" : errorReason;
    }
}