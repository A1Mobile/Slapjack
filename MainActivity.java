package com.a1mobile.Slapjack;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

public class MainActivity extends playSlapjackComputer implements RewardedVideoAdListener {
    private Button button;
    private Button buttonComputer;
    private Button buttonHow;
    private Button buttonSpeed;
    private Button buttonDifficulty;
    private Button buttonComputerDifficulty;
    private Button buttonHowDifficulty;
    private InterstitialAd interstitialAd;
    private InterstitialAd interstitialAd1;
    private InterstitialAd interstitialAd2;
    private InterstitialAd interstitialAd3;
    protected static String difficulty = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileAds.initialize(this, "ca-app-pub-6280210391658207~1036804482");

        interstitialAd = new InterstitialAd(this);
        interstitialAd.setAdUnitId("ca-app-pub-6280210391658207/7018268214");
        interstitialAd.loadAd(new AdRequest.Builder().build());

        interstitialAd1 = new InterstitialAd(this);
        interstitialAd1.setAdUnitId("ca-app-pub-6280210391658207/7018268214");
        interstitialAd1.loadAd(new AdRequest.Builder().build());

        interstitialAd2 = new InterstitialAd(this);
        interstitialAd2.setAdUnitId("ca-app-pub-6280210391658207/7018268214");
        interstitialAd2.loadAd(new AdRequest.Builder().build());

        interstitialAd3 = new InterstitialAd(this);
        interstitialAd3.setAdUnitId("ca-app-pub-6280210391658207/7018268214");
        interstitialAd3.loadAd(new AdRequest.Builder().build());

        loadRewardedVideoAd();

        interstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                startActivity(new Intent(MainActivity.this, SlapjackFriends.class));
                interstitialAd.loadAd(new AdRequest.Builder().build());
            }
        });

        interstitialAd1.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                startActivity(new Intent(MainActivity.this, howTo.class));
                interstitialAd.loadAd(new AdRequest.Builder().build());
            }
        });

        interstitialAd2.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                startActivity(new Intent(MainActivity.this, playSlapjackComputer.class));
                interstitialAd.loadAd(new AdRequest.Builder().build());
            }
        });

        interstitialAd3.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                startActivity(new Intent(MainActivity.this, openSpeed.class));
                interstitialAd.loadAd(new AdRequest.Builder().build());
            }
        });

        button = (Button) findViewById(R.id.slapjackFriendsButton);
        buttonComputer = (Button) findViewById(R.id.slapjackComputer);
        buttonHow = (Button) findViewById(R.id.howToPlay);
        buttonSpeed = (Button) findViewById(R.id.speedSlap);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (interstitialAd.isLoaded()) {
                    interstitialAd.show();
                }
                else {
                    openSlapjack();
                }
            }
        });

        buttonComputer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                difficulty();
            }
        });

        buttonHow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (interstitialAd1.isLoaded()) {
                    interstitialAd1.show();
                }
                else {
                    openHowTo();
                }
            }
        });

        buttonSpeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (interstitialAd3.isLoaded()) {
                    interstitialAd3.show();
                }
                else {
                    openSpeedSlap();
                }
            }
        });
    }

    public void openSpeedSlap() {
        Intent openSpeedSlap = new Intent(this, openSpeed.class);
        startActivity(openSpeedSlap);
        finish();
    }

    public void openHowTo() {
        Intent openHowTo = new Intent(this, howTo.class);
        startActivity(openHowTo);
        finish();
    }

    protected void onResume() {
        super.onResume();
        button = (Button) findViewById(R.id.slapjackFriendsButton);
        buttonComputer = (Button) findViewById(R.id.slapjackComputer);
        buttonHow = (Button) findViewById(R.id.howToPlay);

        button.setText("Play With Friends");
        buttonComputer.setText("Play Against A Computer");
        buttonHow.setText("How To Play");
    }

    public void difficulty() {
        button = (Button) findViewById(R.id.slapjackFriendsButton);
        buttonComputer = (Button) findViewById(R.id.slapjackComputer);
        buttonHow = (Button) findViewById(R.id.howToPlay);
        buttonSpeed = (Button) findViewById(R.id.speedSlap);

        button.setText("Easy Computer");
        buttonComputer.setText("Medium Computer");
        buttonSpeed.setText("Hard Computer");
        buttonHow.setText("Impossible Computer");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (interstitialAd2.isLoaded()) {
                    difficulty = "Easy";
                    interstitialAd2.show();
                } else {
                    difficulty = "Easy";
                    openSlapjackComputer();
                }
            }
        });

        buttonComputer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (interstitialAd2.isLoaded()) {
                    difficulty = "Medium";
                    interstitialAd2.show();
                } else {
                    difficulty = "Medium";
                    openSlapjackComputer();
                }
            }
        });

        buttonSpeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (interstitialAd2.isLoaded()) {
                    difficulty = "Hard";
                    interstitialAd2.show();
                } else {
                    difficulty = "Hard";
                    openSlapjackComputer();
                }
            }
        });

        buttonHow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (interstitialAd2.isLoaded()) {
                    difficulty = "Impossible";
                    interstitialAd2.show();
                } else {
                    difficulty = "Impossible";
                    openSlapjackComputer();
                }
            }
        });
    }

    public void openSlapjack() {
        Intent openSlapjack = new Intent(this, SlapjackFriends.class);
        startActivity(openSlapjack);
        finish();
    }

    public void openSlapjackComputer() {
        Intent openSlapjackComputer = new Intent(this, playSlapjackComputer.class);
        startActivity(openSlapjackComputer);
        finish();
    }

    private void loadRewardedVideoAd() {
        //rewardedVideoAdMain.loadAd("ca-app-pub-6280210391658207/3533662238",
          //      new AdRequest.Builder().build());
    }

    @Override
    public void onRewarded(RewardItem reward) {
        openSlapjackComputer();
        finish();
    }

    @Override
    public void onRewardedVideoAdLeftApplication() {

    }

    @Override
    public void onRewardedVideoAdClosed() {

    }

    @Override
    public void onRewardedVideoAdFailedToLoad(int errorCode) {

    }

    @Override
    public void onRewardedVideoAdLoaded() {

    }

    @Override
    public void onRewardedVideoAdOpened() {

    }

    @Override
    public void onRewardedVideoStarted() {

    }
}

