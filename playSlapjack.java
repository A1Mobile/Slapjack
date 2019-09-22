package com.a1mobile.Slapjack;

import android.content.Intent;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import java.util.ArrayList;

public class playSlapjack extends fillCards {
    protected String check = "False";
    //protected Integer[] cardListPlayer1 = new Integer[52];
    //protected Integer[] cardListPlayer2 = new Integer[52];
    //protected Integer[] cardsInPile = new Integer[52];
    protected int player1CardCountHolder = 26;
    protected int player2CardCountHolder = 26;
    ArrayList<Integer> cardListPlayer1 = new ArrayList<Integer>();
    ArrayList<Integer> cardListPlayer2 = new ArrayList<Integer>();
    ArrayList<Integer> cardsInPile = new ArrayList<Integer>();
    protected int cardTop = -1;
    protected int cardMiddle = -1;
    protected int cardBottom = -1;
    protected String player1Slap = "False";
    protected String player2Slap = "False";
    protected String checkSlapWinner = "False";
    protected String checkWinnerHolder = "False";
    protected String player1Turn = "True";
    protected String player2Turn = "False";
    private InterstitialAd interstitialAdRestart;
    protected String winner = "False";

    protected void playSlapjackFriendFirst() {
        TextView player1CardCount = findViewById(R.id.player1Text);
        TextView player2CardCount = findViewById(R.id.player2Count);
        slapButton();
        cardDeliverButton();
        fillDeck();
        quitButton();
        player1CardCountHolder = 26;
        player2CardCountHolder = 26;
        player1Turn = "True";
        player2Turn = "False";
        player1CardCount.setText("" + player1CardCountHolder);
        player1CardCount.setTextColor(getColor(R.color.green));
        player1CardCount.setBackground(getDrawable(R.drawable.bordergreen));
        player2CardCount.setText("" + player2CardCountHolder);
        player2CardCount.setTextColor(getColor(R.color.black));
        player2CardCount.setBackground(getDrawable(R.drawable.border));

        for (int i = 0; i < 26; i++) {
            cardListPlayer1.add(i);
        }
        for (int i = 26; i < 52; i++) {
            cardListPlayer2.add(i);
        }

        interstitialAdRestart = new InterstitialAd(this);
        interstitialAdRestart.setAdUnitId("ca-app-pub-6280210391658207/7018268214");
        interstitialAdRestart.loadAd(new AdRequest.Builder().build());

        interstitialAdRestart.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                resetGame();
            }
        });
    }

    protected void playSlapjackFriend() {
        TextView player1CardCount = findViewById(R.id.player1Text);
        TextView player2CardCount = findViewById(R.id.player2Count);

        for (int i = 0; i < 26; i++) {
            cardListPlayer1.add(i);
        }
        for (int i = 26; i < 52; i++) {
            cardListPlayer2.add(i);
        }

        slapButton();
        cardDeliverButton();
        fillDeck();
        quitButton();
        player1CardCountHolder = 26;
        player2CardCountHolder = 26;
        player1Turn = "True";
        player2Turn = "False";
        player1CardCount.setText("" + player1CardCountHolder);
        player1CardCount.setTextColor(getColor(R.color.green));
        player1CardCount.setBackground(getDrawable(R.drawable.bordergreen));
        player2CardCount.setText("" + player2CardCountHolder);
        player2CardCount.setTextColor(getColor(R.color.black));
        player2CardCount.setBackground(getDrawable(R.drawable.border));
    }

    protected void cardPlayer1Get() {
        TextView player1CardCount = findViewById(R.id.player1Text);
        player1CardCountHolder = player1CardCountHolder - 1;
        ((ImageView) findViewById(R.id.communityDeck)).setImageResource(getResources().getIdentifier(cardHolder[cardListPlayer1.get(0)], "drawable", getPackageName()));
        cardsInPile.add(cardListPlayer1.get(0));
        cardBottom = cardMiddle;
        cardMiddle = cardTop;
        cardTop = cardListPlayer1.get(0);
        cardListPlayer1.remove(0);
        player1CardCount.setText("" + player1CardCountHolder);
        player2Turn = "True";
        player1Turn = "False";
    }

    protected void cardPlayer2Get() {
        TextView player2CardCount = findViewById(R.id.player2Count);
        player2CardCountHolder = player2CardCountHolder - 1;
        ((ImageView) findViewById(R.id.communityDeck)).setImageResource(getResources().getIdentifier(cardHolder[cardListPlayer2.get(0)], "drawable", getPackageName()));
        cardsInPile.add(cardListPlayer2.get(0));
        cardBottom = cardMiddle;
        cardMiddle = cardTop;
        cardTop = cardListPlayer2.get(0);
        cardListPlayer2.remove(0);
        player2CardCount.setText("" + player2CardCountHolder);
        player1Turn = "True";
        player2Turn = "False";
    }

    protected void cardDeliverButton() {
        final ImageButton cardPlayer1 = findViewById(R.id.cardPlayer1);
        final ImageButton cardPlayer2 = findViewById(R.id.cardPlayer2);
        final TextView player1CardCount = findViewById(R.id.player1Text);
        final TextView player2CardCount = findViewById(R.id.player2Count);
        final Button slapPlayer1 = findViewById(R.id.slapPlayer1);
        final Button slapPlayer2 = findViewById(R.id.slapPlayer2);

        cardPlayer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (player2Slap.equals("False") & player1Slap.equals("False") & winner.equals("False")) {
                    cardPlayer1Get();
                    cardPlayer1.setClickable(false);
                    player1CardCount.setTextColor(getColor(R.color.black));
                    player1CardCount.setBackground(getDrawable(R.drawable.border));
                    checkWinner();
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            if (checkWinnerHolder.equals("False")) {
                                cardPlayer2.setClickable(true);
                                player2CardCount.setTextColor(getColor(R.color.green));
                                player2CardCount.setBackground(getDrawable(R.drawable.bordergreen));
                            }
                        }
                    }, 650);
                }
            }
        });

        cardPlayer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (player2Slap.equals("False") & player1Slap.equals("False") & winner.equals("False")) {
                    cardPlayer2Get();
                    cardPlayer2.setClickable(false);
                    player2CardCount.setTextColor(getColor(R.color.black));
                    player2CardCount.setBackground(getDrawable(R.drawable.border));
                    checkWinner();
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            if (checkWinnerHolder.equals("False")) {
                                cardPlayer1.setClickable(true);
                                player1CardCount.setTextColor(getColor(R.color.green));
                                player1CardCount.setBackground(getDrawable(R.drawable.bordergreen));
                            }
                        }
                    }, 650);
                }
            }
        });

        cardPlayer1.setClickable(true);
        cardPlayer2.setClickable(false);
        player1CardCount.setTextColor(getColor(R.color.green));
        player1CardCount.setBackground(getDrawable(R.drawable.bordergreen));
    }

    protected void slapButton() {
        final ImageButton cardPlayer1 = findViewById(R.id.cardPlayer1);
        final ImageButton cardPlayer2 = findViewById(R.id.cardPlayer2);
        final TextView player1CardCount = findViewById(R.id.player1Text);
        final TextView player2CardCount = findViewById(R.id.player2Count);
        final Button slapPlayer1 = findViewById(R.id.slapPlayer1);
        final Button slapPlayer2 = findViewById(R.id.slapPlayer2);
        player1Slap = "False";
        player2Slap = "False";

        slapPlayer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (player2Slap.equals("False")) {
                    player1Slap = "True";
                    player2Slap = "True";
                    slapPlayer1.setClickable(false);
                    slapPlayer2.setClickable(false);
                    cardPlayer1.setClickable(false);
                    cardPlayer2.setClickable(false);
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
                if (player1Slap.equals("False")) {
                    player1Slap = "True";
                    player2Slap = "True";
                    slapPlayer1.setClickable(false);
                    slapPlayer2.setClickable(false);
                    cardPlayer1.setClickable(false);
                    cardPlayer2.setClickable(false);
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

        slapPlayer1.setClickable(true);
        slapPlayer2.setClickable(true);
        if (player1Turn.equals("True")) {
            cardPlayer1.setClickable(true);
        }
        if (player2Turn.equals("True")) {
            cardPlayer2.setClickable(true);
        }
        check = "False";
    }

    protected void slapPlayer1Win() {
        player1CardCountHolder = 52 - player2CardCountHolder;
        cardListPlayer1.addAll(cardsInPile);
        cardsInPile.clear();
        afterSlapReset();
    }

    protected void slapPlayer1Lose() {
        player2CardCountHolder = 52 - player1CardCountHolder;
        cardListPlayer2.addAll(cardsInPile);
        cardsInPile.clear();
        afterSlapReset();
    }

    protected void slapPlayer2Win() {
        player2CardCountHolder = 52 - player1CardCountHolder;
        cardListPlayer2.addAll(cardsInPile);
        cardsInPile.clear();
        afterSlapReset();
    }

    protected void slapPlayer2Lose() {
        player1CardCountHolder = 52 - player2CardCountHolder;
        cardListPlayer1.addAll(cardsInPile);
        cardsInPile.clear();
        afterSlapReset();
    }

    protected void checkSlap() {
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

    protected void checkWinner() {
        final ImageButton cardPlayer1 = findViewById(R.id.cardPlayer1);
        final ImageButton cardPlayer2 = findViewById(R.id.cardPlayer2);

        checkSlapWinner = "False";
        checkWinnerHolder = "False";
        if (player1CardCountHolder == 0 | player2CardCountHolder == 0) {
            winner = "True";
            checkWinnerHolder = "True";
            cardPlayer1.setClickable(false);
            cardPlayer2.setClickable(false);
            if (cardTop != -1) {
                if (deckOfCards[cardTop].getFaceValue() == 11) {
                    checkSlapWinner = "True";
                }
            }
            if (cardTop != -1 & cardMiddle != -1) {
                if (deckOfCards[cardTop].getFaceValue() == deckOfCards[cardMiddle].getFaceValue()) {
                    checkSlapWinner = "True";
                }
            }
            if (cardTop != -1 & cardBottom != -1) {
                if (deckOfCards[cardTop].getFaceValue() == deckOfCards[cardBottom].getFaceValue()) {
                    checkSlapWinner = "True";
                }
            }
            if (checkSlapWinner.equals("True")) {
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (player1CardCountHolder == 0) {
                            player2Wins();
                        }
                        if (player2CardCountHolder == 0) {
                            player1Wins();
                        }
                        if (player1CardCountHolder != 0 & player2CardCountHolder != 0) {
                        winner = "False";
                        afterSlapReset();
                        }
                    }
                }, 800);
            }
            else {
                if (player1CardCountHolder == 0) {
                    player2Wins();
                }
                if (player2CardCountHolder == 0) {
                    player1Wins();
                }
            }
        }
    }

    protected void player1Wins() {
        final ImageButton cardPlayer1 = findViewById(R.id.cardPlayer1);
        final ImageButton cardPlayer2 = findViewById(R.id.cardPlayer2);
        final TextView player1CardCount = findViewById(R.id.player1Text);
        final TextView player2CardCount = findViewById(R.id.player2Count);
        final Button slapPlayer1 = findViewById(R.id.slapPlayer1);
        final Button slapPlayer2 = findViewById(R.id.slapPlayer2);
        final Button quitButton = findViewById(R.id.quitButton);

        slapPlayer1.setClickable(false);
        slapPlayer2.setClickable(false);
        cardPlayer1.setClickable(false);
        cardPlayer2.setClickable(false);

        player1CardCount.setText("Winner!");
        player1CardCount.setTextColor(getColor(R.color.green));
        player1CardCount.setBackground(getDrawable(R.drawable.bordergreen));
        player2CardCount.setText("Loser.");
        player2CardCount.setTextColor(getColor(R.color.black));
        player2CardCount.setBackground(getDrawable(R.drawable.border));

        quitButton.setText("Restart");
        quitButton.setTextColor(getColor(R.color.green));
        quitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (interstitialAdRestart.isLoaded()) {
                    interstitialAdRestart.show();
                } else {
                    resetGame();
                }
            }
        });
    }

    protected void player2Wins() {
        final ImageButton cardPlayer1 = findViewById(R.id.cardPlayer1);
        final ImageButton cardPlayer2 = findViewById(R.id.cardPlayer2);
        final TextView player1CardCount = findViewById(R.id.player1Text);
        final TextView player2CardCount = findViewById(R.id.player2Count);
        final Button slapPlayer1 = findViewById(R.id.slapPlayer1);
        final Button slapPlayer2 = findViewById(R.id.slapPlayer2);
        final Button quitButton = findViewById(R.id.quitButton);

        slapPlayer1.setClickable(false);
        slapPlayer2.setClickable(false);
        cardPlayer1.setClickable(false);
        cardPlayer2.setClickable(false);

        player2CardCount.setText("Winner!");
        player2CardCount.setTextColor(getColor(R.color.green));
        player2CardCount.setBackground(getDrawable(R.drawable.bordergreen));
        player1CardCount.setText("Loser.");
        player1CardCount.setTextColor(getColor(R.color.black));
        player1CardCount.setBackground(getDrawable(R.drawable.border));

        quitButton.setText("Restart");
        quitButton.setTextColor(getColor(R.color.green));
        quitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (interstitialAdRestart.isLoaded()) {
                    interstitialAdRestart.show();
                } else {
                    resetGame();
                }
            }
        });
    }

    protected void resetGame() {
        cardListPlayer1.clear();
        cardListPlayer2.clear();
        cardsInPile.clear();
        winner = "False";
        ((ImageView) findViewById(R.id.communityDeck)).setImageResource(0);
        playSlapjackFriend();
    }

    public void openMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
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

    protected void afterSlapReset() {
        ((ImageView) findViewById(R.id.communityDeck)).setImageResource(0);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                TextView player1CardCount = findViewById(R.id.player1Text);
                TextView player2CardCount = findViewById(R.id.player2Count);
                Button slapPlayer1 = findViewById(R.id.slapPlayer1);
                Button slapPlayer2 = findViewById(R.id.slapPlayer2);
                cardTop = -1;
                cardMiddle = -1;
                cardBottom = -1;
                ((ImageView) findViewById(R.id.communityDeck)).setImageResource(0);
                player1CardCount.setText("" + player1CardCountHolder);
                player2CardCount.setText("" + player2CardCountHolder);
                slapPlayer1.setText("Tap here to slap");
                slapPlayer1.setTextColor(getColor(R.color.black));
                slapPlayer1.setBackground(getDrawable(R.drawable.transparent));
                slapPlayer2.setText("Tap here to slap");
                slapPlayer2.setTextColor(getColor(R.color.black));
                slapPlayer2.setBackground(getDrawable(R.drawable.transparent));
                slapButton();
            }
        }, 1000);
    }
}
