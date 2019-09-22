package com.a1mobile.Slapjack;

import android.content.Intent;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

public class speedAction extends fillCards {
    protected int cardCountHolder = 0;
    protected String slap = "False";
    protected int cardBottom;
    protected int cardMiddle;
    protected int cardTop;
    protected String check = "False";
    protected int player1Counter = 0;
    protected int player2Counter = 0;
    protected int player3Counter = 0;
    protected int player4Counter = 0;
    private InterstitialAd interstitialAdRestart;

    protected void runSpeedSlap() {
        cardBottom = -1;
        cardMiddle = -1;
        cardTop = -1;

        interstitialAdRestart = new InterstitialAd(this);
        interstitialAdRestart.setAdUnitId("ca-app-pub-6280210391658207/7018268214");
        interstitialAdRestart.loadAd(new AdRequest.Builder().build());

        interstitialAdRestart.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                resetGame();
            }
        });

        fillDeck();
        getCard();
        slapButton();
        quitButton();
    }

    protected void getCard() {
        if (slap.equals("False")) {
            ((ImageView) findViewById(R.id.imageView)).setImageResource(getResources().getIdentifier(cardHolder[cardCountHolder], "drawable", getPackageName()));
            ((ImageView) findViewById(R.id.imageView2)).setImageResource(getResources().getIdentifier(cardHolder[cardCountHolder], "drawable", getPackageName()));
            cardBottom = cardMiddle;
            cardMiddle = cardTop;
            cardTop = cardCountHolder;
            cardCountHolder = cardCountHolder + 1;
            if (cardCountHolder == 52) {
                cardCountHolder = 0;
            }
        }

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                getCard();
            }
        }, 700);
    }

    protected void slapButton() {
        final Button slapPlayer1 = findViewById(R.id.slapPlayer1);
        final Button slapPlayer2 = findViewById(R.id.slapPlayer2);
        final Button slapPlayer3 = findViewById(R.id.slapPlayer3);
        final Button slapPlayer4 = findViewById(R.id.slapPlayer4);
        slapPlayer1.setClickable(true);
        slapPlayer2.setClickable(true);
        slapPlayer3.setClickable(true);
        slapPlayer4.setClickable(true);

        slapPlayer1.setText("Player 1: Tap here to slap");
        slapPlayer1.setTextColor(getColor(R.color.black));
        slapPlayer1.setBackground(getDrawable(R.drawable.transparent));

        slapPlayer2.setText("Player 2: Tap here to slap");
        slapPlayer2.setTextColor(getColor(R.color.black));
        slapPlayer2.setBackground(getDrawable(R.drawable.transparent));

        slapPlayer3.setText("Player 3: Tap here to slap");
        slapPlayer3.setTextColor(getColor(R.color.black));
        slapPlayer3.setBackground(getDrawable(R.drawable.transparent));

        slapPlayer4.setText("Player 4: Tap here to slap");
        slapPlayer4.setTextColor(getColor(R.color.black));
        slapPlayer4.setBackground(getDrawable(R.drawable.transparent));

        slapPlayer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (slap.equals("False")) {
                    slap = "True";
                    slapPlayer1.setClickable(false);
                    slapPlayer2.setClickable(false);
                    slapPlayer3.setClickable(false);
                    slapPlayer4.setClickable(false);
                    checkSlap();
                    if (check.equals("True")) {
                        slapPlayer1.setTextColor(getColor(R.color.green));
                        slapPlayer1.setBackground(getDrawable(R.drawable.transparentgreen));
                        slapPlayer1.setText("Good slap!");
                        slapPlayer1Win();
                    } else {
                        slapPlayer1.setTextColor(getColor(R.color.red));
                        slapPlayer1.setBackground(getDrawable(R.drawable.transparentred));
                        slapPlayer1.setText("Incorrect Slap");
                        slapPlayer1Lose();
                    }
                }
            }
        });

        slapPlayer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (slap.equals("False")) {
                    slap = "True";
                    slapPlayer1.setClickable(false);
                    slapPlayer2.setClickable(false);
                    slapPlayer3.setClickable(false);
                    slapPlayer4.setClickable(false);
                    checkSlap();
                    if (check.equals("True")) {
                        slapPlayer2.setTextColor(getColor(R.color.green));
                        slapPlayer2.setBackground(getDrawable(R.drawable.transparentgreen));
                        slapPlayer2.setText("Good slap!");
                        slapPlayer2Win();
                    } else {
                        slapPlayer2.setTextColor(getColor(R.color.red));
                        slapPlayer2.setBackground(getDrawable(R.drawable.transparentred));
                        slapPlayer2.setText("Incorrect Slap");
                        slapPlayer2Lose();
                    }
                }
            }
        });

        slapPlayer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (slap.equals("False")) {
                    slap = "True";
                    slapPlayer1.setClickable(false);
                    slapPlayer2.setClickable(false);
                    slapPlayer3.setClickable(false);
                    slapPlayer4.setClickable(false);
                    checkSlap();
                    if (check.equals("True")) {
                        slapPlayer3.setTextColor(getColor(R.color.green));
                        slapPlayer3.setBackground(getDrawable(R.drawable.transparentgreen));
                        slapPlayer3.setText("Good slap!");
                        slapPlayer3Win();
                    } else {
                        slapPlayer3.setTextColor(getColor(R.color.red));
                        slapPlayer3.setBackground(getDrawable(R.drawable.transparentred));
                        slapPlayer3.setText("Incorrect Slap");
                        slapPlayer3Lose();
                    }
                }
            }
        });

        slapPlayer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (slap.equals("False")) {
                    slap = "True";
                    slapPlayer1.setClickable(false);
                    slapPlayer2.setClickable(false);
                    slapPlayer3.setClickable(false);
                    slapPlayer4.setClickable(false);
                    checkSlap();
                    if (check.equals("True")) {
                        slapPlayer4.setTextColor(getColor(R.color.green));
                        slapPlayer4.setBackground(getDrawable(R.drawable.transparentgreen));
                        slapPlayer4.setText("Good slap!");
                        slapPlayer4Win();
                    } else {
                        slapPlayer4.setTextColor(getColor(R.color.red));
                        slapPlayer4.setBackground(getDrawable(R.drawable.transparentred));
                        slapPlayer4.setText("Incorrect Slap");
                        slapPlayer4Lose();
                    }
                }
            }
        });
    }

    protected void slapPlayer1Win() {
        TextView player1Text = findViewById(R.id.player1Text);
        String player1Display = "";
        player1Counter = player1Counter + 1;

        switch (player1Counter) {
            case 0: player1Display = ""; break;
            case 1: player1Display = "S"; break;
            case 2: player1Display = "Sl"; break;
            case 3: player1Display = "Sla"; break;
            case 4: player1Display = "Slap"; break;
            case 5: player1Display = "Slapj"; break;
            case 6: player1Display = "Slapja"; break;
            case 7: player1Display = "Slapjac"; break;
            case 8: player1Display = "Slapjack"; break;
        }

        player1Text.setText("" + player1Display);
        checkForWinner();
    }

    protected void slapPlayer1Lose() {
        TextView player1Text = findViewById(R.id.player1Text);
        String player1Display = "";
        player1Counter = player1Counter - 1;
        if (player1Counter == -1) {
            player1Counter = 0;
        }

        switch (player1Counter) {
            case 0: player1Display = ""; break;
            case 1: player1Display = "S"; break;
            case 2: player1Display = "Sl"; break;
            case 3: player1Display = "Sla"; break;
            case 4: player1Display = "Slap"; break;
            case 5: player1Display = "Slapj"; break;
            case 6: player1Display = "Slapja"; break;
            case 7: player1Display = "Slapjac"; break;
            case 8: player1Display = "Slapjack"; break;
        }

        player1Text.setText("" + player1Display);
        afterSlapReset();
    }

    protected void slapPlayer2Win() {
        TextView player2Text = findViewById(R.id.player2Text);
        String player2Display = "";
        player2Counter = player2Counter + 1;

        switch (player2Counter) {
            case 0: player2Display = ""; break;
            case 1: player2Display = "S"; break;
            case 2: player2Display = "Sl"; break;
            case 3: player2Display = "Sla"; break;
            case 4: player2Display = "Slap"; break;
            case 5: player2Display = "Slapj"; break;
            case 6: player2Display = "Slapja"; break;
            case 7: player2Display = "Slapjac"; break;
            case 8: player2Display = "Slapjack"; break;
        }

        player2Text.setText("" + player2Display);
        checkForWinner();
    }

    protected void slapPlayer2Lose() {
        TextView player2Text = findViewById(R.id.player2Text);
        String player2Display = "";
        player2Counter = player2Counter - 1;
        if (player2Counter == -1) {
            player2Counter = 0;
        }

        switch (player2Counter) {
            case 0: player2Display = ""; break;
            case 1: player2Display = "S"; break;
            case 2: player2Display = "Sl"; break;
            case 3: player2Display = "Sla"; break;
            case 4: player2Display = "Slap"; break;
            case 5: player2Display = "Slapj"; break;
            case 6: player2Display = "Slapja"; break;
            case 7: player2Display = "Slapjac"; break;
            case 8: player2Display = "Slapjack"; break;
        }

        player2Text.setText("" + player2Display);
        afterSlapReset();
    }

    protected void slapPlayer3Win() {
        TextView player3Text = findViewById(R.id.player3Text);
        String player3Display = "";
        player3Counter = player3Counter + 1;

        switch (player3Counter) {
            case 0: player3Display = ""; break;
            case 1: player3Display = "S"; break;
            case 2: player3Display = "Sl"; break;
            case 3: player3Display = "Sla"; break;
            case 4: player3Display = "Slap"; break;
            case 5: player3Display = "Slapj"; break;
            case 6: player3Display = "Slapja"; break;
            case 7: player3Display = "Slapjac"; break;
            case 8: player3Display = "Slapjack"; break;
        }

        player3Text.setText("" + player3Display);
        checkForWinner();
    }

    protected void slapPlayer3Lose() {
        TextView player3Text = findViewById(R.id.player3Text);
        String player3Display = "";
        player3Counter = player3Counter - 1;
        if (player3Counter == -1) {
            player3Counter = 0;
        }

        switch (player3Counter) {
            case 0: player3Display = ""; break;
            case 1: player3Display = "S"; break;
            case 2: player3Display = "Sl"; break;
            case 3: player3Display = "Sla"; break;
            case 4: player3Display = "Slap"; break;
            case 5: player3Display = "Slapj"; break;
            case 6: player3Display = "Slapja"; break;
            case 7: player3Display = "Slapjac"; break;
            case 8: player3Display = "Slapjack"; break;
        }

        player3Text.setText("" + player3Display);
        afterSlapReset();
    }

    protected void slapPlayer4Win() {
        TextView player4Text = findViewById(R.id.player4Text);
        String player4Display = "";
        player4Counter = player4Counter + 1;

        switch (player4Counter) {
            case 0: player4Display = ""; break;
            case 1: player4Display = "S"; break;
            case 2: player4Display = "Sl"; break;
            case 3: player4Display = "Sla"; break;
            case 4: player4Display = "Slap"; break;
            case 5: player4Display = "Slapj"; break;
            case 6: player4Display = "Slapja"; break;
            case 7: player4Display = "Slapjac"; break;
            case 8: player4Display = "Slapjack"; break;
        }

        player4Text.setText("" + player4Display);
        checkForWinner();
    }

    protected void slapPlayer4Lose() {
        TextView player4Text = findViewById(R.id.player4Text);
        String player4Display = "";
        player4Counter = player4Counter - 1;
        if (player4Counter == -1) {
            player4Counter = 0;
        }

        switch (player4Counter) {
            case 0: player4Display = ""; break;
            case 1: player4Display = "S"; break;
            case 2: player4Display = "Sl"; break;
            case 3: player4Display = "Sla"; break;
            case 4: player4Display = "Slap"; break;
            case 5: player4Display = "Slapj"; break;
            case 6: player4Display = "Slapja"; break;
            case 7: player4Display = "Slapjac"; break;
            case 8: player4Display = "Slapjack"; break;
        }

        player4Text.setText("" + player4Display);
        afterSlapReset();
    }

    protected void checkForWinner() {
        TextView player1Text = findViewById(R.id.player1Text);
        TextView player2Text = findViewById(R.id.player2Text);
        TextView player3Text = findViewById(R.id.player3Text);
        TextView player4Text = findViewById(R.id.player4Text);
        final Button quitButton = findViewById(R.id.quitButton);

        if (player1Counter == 8) {
            player1Text.setTextColor(getColor(R.color.green));
            player1Text.setBackground(getDrawable(R.drawable.bordergreen));
            player2Text.setText("Loser");
            player3Text.setText("Loser");
            player4Text.setText("Loser");
            quitButton.setTextColor(getColor(R.color.green));
            quitButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openMain();
                }
            });
        }
        if (player2Counter == 8) {
            player2Text.setTextColor(getColor(R.color.green));
            player2Text.setBackground(getDrawable(R.drawable.bordergreen));
            player1Text.setText("Loser");
            player3Text.setText("Loser");
            player4Text.setText("Loser");
            quitButton.setTextColor(getColor(R.color.green));
            quitButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openMain();
                }
            });
        }
        if (player3Counter == 8) {
            player3Text.setTextColor(getColor(R.color.green));
            player3Text.setBackground(getDrawable(R.drawable.bordergreen));
            player2Text.setText("Loser");
            player1Text.setText("Loser");
            player4Text.setText("Loser");
            quitButton.setTextColor(getColor(R.color.green));
            quitButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openMain();
                }
            });
        }
        if (player4Counter == 8) {
            player4Text.setTextColor(getColor(R.color.green));
            player4Text.setBackground(getDrawable(R.drawable.bordergreen));
            player2Text.setText("Loser");
            player3Text.setText("Loser");
            player1Text.setText("Loser");
            quitButton.setTextColor(getColor(R.color.green));
            quitButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openMain();
                }
            });
        }
        if (player1Counter != 8 & player2Counter != 8 & player3Counter != 8 & player4Counter != 8) {
            afterSlapReset();
        }
    }

    protected void resetGame() {
        runSpeedSlap();
    }

    protected void afterSlapReset() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                slap = "False";
                ((ImageView) findViewById(R.id.imageView)).setImageResource(0);
                ((ImageView) findViewById(R.id.imageView2)).setImageResource(0);
                slapButton();
                cardTop = -1;
                cardBottom = -1;
                cardMiddle = -1;
            }
        }, 1000);
    }

    protected void checkSlap() {
        check = "False";

        if (cardTop != -1) {
            if (deckOfCards[cardTop].getFaceValue() == 11) {
                check = "True";
            }
        }
        if (cardTop != -1 & cardMiddle != -1) {
            if (deckOfCards[cardTop].getFaceValue() == deckOfCards[cardMiddle].getFaceValue()) {
                check = "True";
            }
        }
        if (cardTop != -1 & cardBottom != -1) {
            if (deckOfCards[cardTop].getFaceValue() == deckOfCards[cardBottom].getFaceValue()) {
                check = "True";
            }
        }
    }

    protected void quitButton() {
        Button quitButton = (Button) findViewById(R.id.quitButton);
        quitButton.setText("Quit");
        quitButton.setTextColor(getColor(R.color.black));
        quitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMain();
            }
        });
    }

    public void openMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
