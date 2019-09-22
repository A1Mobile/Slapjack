package com.a1mobile.Slapjack;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.Random;

public class runPracticeSlapjack extends AppCompatActivity {
    protected String cardAdd = "";
    protected int suit = 0;
    protected int num = 0;
    protected String cardSuit = "";
    protected String cardNum = "";
    protected String sameCard = "True";
    protected Card topCard;
    protected Card middleCard;
    protected Card bottomCard;
    protected String check = "False";
    protected String noCard = "True";

    protected void runPractice() {
        getCardButton();
        slapButton();
        quitButton();
        topCard = new Card("s", "-2", -2, 1);
        middleCard = new Card("s", "-2", -4, 1);
        bottomCard = new Card("s", "-2", -3, 1);
    }

    protected void getCardButton() {
        final ImageButton cardPlayer2 = findViewById(R.id.cardPlayer2);
        cardPlayer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                noCard = "False";
                Random s = new Random();
                Random n = new Random();
                suit = s.nextInt(4);
                num = n.nextInt(13);
                num = num + 2;

                switch (suit) {
                    case 0: cardSuit = "s";
                    break;
                    case 1: cardSuit = "h";
                    break;
                    case 2: cardSuit = "c";
                    break;
                    case 3: cardSuit = "d";
                    break;
                }

                switch (num) {
                    case 2: cardNum = "2";
                    break;
                    case 3: cardNum = "3";
                    break;
                    case 4: cardNum = "4";
                    break;
                    case 5: cardNum = "5";
                    break;
                    case 6: cardNum = "6";
                    break;
                    case 7: cardNum = "7";
                    break;
                    case 8: cardNum = "8";
                    break;
                    case 9: cardNum = "9";
                    break;
                    case 10: cardNum = "10";
                    break;
                    case 11: cardNum = "j";
                    break;
                    case 12: cardNum = "q";
                    break;
                    case 13: cardNum = "k";
                    break;
                    case 14: cardNum = "a";
                    break;
                }
                bottomCard = middleCard;
                middleCard = topCard;
                topCard = new Card(cardSuit, cardNum, num, 1);
                cardAdd = cardSuit + "" + cardNum;
                ((ImageView) findViewById(R.id.communityDeck)).setImageResource(getResources().getIdentifier(cardAdd, "drawable", getPackageName()));
            }
        });
    }

    protected void slapButton() {
        final Button slapPlayer2 = findViewById(R.id.slapPlayer2);
        final ImageButton cardPlayer2 = findViewById(R.id.cardPlayer2);
        slapPlayer2.setClickable(true);
        cardPlayer2.setClickable(true);
        final Handler handler = new Handler();

        slapPlayer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slapPlayer2.setClickable(false);
                cardPlayer2.setClickable(false);
                checkSlap();
                if (check.equals("True") & noCard.equals("False")) {
                    slapPlayer2.setTextColor(getColor(R.color.green));
                    slapPlayer2.setBackground(getDrawable(R.drawable.transparentgreen));
                    slapPlayer2.setText("Good slap!");
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            resetGame();
                        }
                    },1000);
                } else {
                    slapPlayer2.setTextColor(getColor(R.color.red));
                    slapPlayer2.setBackground(getDrawable(R.drawable.transparentred));
                    slapPlayer2.setText("Incorrect Slap");
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            resetGame();
                        }
                    },1000);
                }
            }
        });
    }

    protected void resetGame() {
        final Button slapPlayer2 = findViewById(R.id.slapPlayer2);
        slapPlayer2.setText("Tap here to slap");
        slapPlayer2.setTextColor(getColor(R.color.black));
        slapPlayer2.setBackground(getDrawable(R.drawable.transparent));
        ((ImageView) findViewById(R.id.communityDeck)).setImageResource(0);
        runPractice();
    }

    protected void checkSlap() {
        check = "False";
        if (topCard.getFaceValue() == 11) {
            check = "True";
        }

        if (topCard.getFaceValue() == middleCard.getFaceValue()) {
            check = "True";
        }

        if (topCard.getFaceValue() == bottomCard.getFaceValue()) {
            check = "True";
        }
    }

    protected void openMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    protected void quitButton() {
        Button quitButton = (Button) findViewById(R.id.quitButton);
        quitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMain();
            }
        });
    }
}
