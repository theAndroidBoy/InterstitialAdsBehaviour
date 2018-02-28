package com.easyapps.interstitial;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

//steps done in this project
//............
// include class "SetUpAds" in your project.
// put this line in build.gradle file ,inside dependencies   .. compile 'com.google.android.gms:play-services-ads:11.6.0'
//replace dummy adunit in Strings.xml file with your ad unit.
//in your Mainactivity put following three lines of code
    //SetUpAds setUpAds;
    //setUpAds=new SetUpAds(this);  (inside the oncreate function)
    //setUpAds.showInterstitial();   (inside the onClickListener of a button ,pressing on which will load the ad)

public class MainActivity extends AppCompatActivity {

    SetUpAds setUpAds;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      setUpAds=new SetUpAds(this);
    }


    //thi
    public void exampleButton(View view) {  //we have made this button in Xml
        setUpAds.showInterstitial();   //put this line of code in any button where your you want the ad to open.
    }
}
