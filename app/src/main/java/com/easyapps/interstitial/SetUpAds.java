package com.easyapps.interstitial;

import android.content.Context;
import android.widget.Toast;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;


public class SetUpAds{

    Context context;
    private InterstitialAd mInterstitialAd;

    public SetUpAds(Context context) {
        this.context=context;
        MobileAds.initialize(context, "ca-app-pub-3940256099942544~3347511713");
        mInterstitialAd = new InterstitialAd(context);
        mInterstitialAd.setAdUnitId(context.getString(R.string.ad_unit_id)); // setting up the ad unit
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                startLoadingAds();
            }
        });

        startLoadingAds();
    }

    public void showInterstitial() {
        // Show the ad if it's ready. Otherwise toast and restart the game.
        if (mInterstitialAd != null && mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            Toast.makeText(context,"Ad not loaded yet",Toast.LENGTH_LONG).show();
            startLoadingAds();
        }
    }

    private void startLoadingAds() {
        // Request a new ad if one isn't already loaded, hide the button, and kick off the timer.
        if (!mInterstitialAd.isLoading() && !mInterstitialAd.isLoaded()) {
            AdRequest adRequest = new AdRequest.Builder().build();
            mInterstitialAd.loadAd(adRequest);
        }

    }

}
