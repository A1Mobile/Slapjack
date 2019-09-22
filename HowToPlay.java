package com.a1mobile.Slapjack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;

public class HowToPlay extends AppCompatActivity {

    protected void runHowToPlay() {
        quitButton();
        practiceButton();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                runGetCardButton();
            }
        }, 1500);
    }

    protected void runGetCardButton() {
        final ImageButton getCardButton = findViewById(R.id.cardPlayer2);
        final TextView teacher1 = findViewById(R.id.teacher1);
        final TextView cardCounter = findViewById(R.id.player2Count);
        getCardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((ImageView) findViewById(R.id.communityDeck)).setImageResource(getResources().getIdentifier("d8", "drawable", getPackageName()));
                teacher1.setText("You got an 8 of diamonds. So now you know when and how to draw new cards, and since you just drew a card it is now your opponents turn to draw a card. Click next directly above this text.");
                cardCounter.setText("25");
                cardCounter.setTextColor(getColor(R.color.black));
                cardCounter.setBackground(getDrawable(R.drawable.border));
                getCardButton.setClickable(false);
                nextTextButton();
            }
        });
    }

    protected void nextTextButton() {
        final Button nextButton = findViewById(R.id.nextButton);
        final ImageButton getCardButton = findViewById(R.id.cardPlayer2);
        final TextView teacher1 = findViewById(R.id.teacher1);
        final TextView cardCounter = findViewById(R.id.player2Count);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                teacher1.setText("Notice that the card counter has changed colors to indicate it isn't your turn to draw a card, and it has went down to 25 to indicate that you only have 25 cards left. Click next to have your opponent draw a card.");
                nextButton.setClickable(false);
                next1Button();
            }
        });
    }

    protected void next1Button() {
        final Button nextButton = findViewById(R.id.nextButton);
        final Button slapButton = findViewById(R.id.slapPlayer2);
        final TextView teacher1 = findViewById(R.id.teacher1);
        final TextView cardCounter = findViewById(R.id.player2Count);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((ImageView) findViewById(R.id.communityDeck)).setImageResource(getResources().getIdentifier("h8", "drawable", getPackageName()));
                cardCounter.setTextColor(getColor(R.color.green));
                cardCounter.setBackground(getDrawable(R.drawable.bordergreen));
                teacher1.setText("As you can see your card counter has turned green again meaning it is your turn to place a card, but instead lets hit the slap button (which is located in the bottom right). Click it now.");
                nextButton.setClickable(false);
                slapButtonAction();
            }
        });
    }

    protected void slapButtonAction() {
        Button nextButton = findViewById(R.id.nextButton);
        final Button slapButton = findViewById(R.id.slapPlayer2);
        final TextView teacher1 = findViewById(R.id.teacher1);
        final TextView cardCounter = findViewById(R.id.player2Count);

        slapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slapButton.setText("Good Slap!");
                slapButton.setBackground(getDrawable(R.drawable.transparentgreen));
                slapButton.setTextColor(getColor(R.color.green));
                cardCounter.setText("27");

                teacher1.setText("As you can see your card counter went from 25 to 27 after you slapped. The goal of the game is to make your opponent have no cards left. Click next.");
                slapButton.setClickable(false);
                nextText2Button();
            }
        });
    }

    protected void nextText2Button() {
        final Button nextButton = findViewById(R.id.nextButton);
        final Button slapButton = findViewById(R.id.slapPlayer2);
        final TextView teacher1 = findViewById(R.id.teacher1);
        final TextView cardCounter = findViewById(R.id.player2Count);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                teacher1.setText("If you slap correctly then you get the stack of cards in the middle, if you slap incorrectly your opponent gets the stack of cards in the middle. Click next to figure out when to slap.");
                nextButton.setClickable(false);
                next2Button();
            }
        });
    }

    protected void next2Button() {
        Button nextButton = findViewById(R.id.nextButton);
        final Button slapButton = findViewById(R.id.slapPlayer2);
        final TextView teacher1 = findViewById(R.id.teacher1);
        final TextView cardCounter = findViewById(R.id.player2Count);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                teacher1.setText("(Note: The suit of the card doesn't matter in this game.) There are three times to correctly slap. The first time is when you have two consecutive cards of the same face value. Click next.");
                ((ImageView) findViewById(R.id.example1)).setImageResource(getResources().getIdentifier("hq", "drawable", getPackageName()));
                ((ImageView) findViewById(R.id.example2)).setImageResource(getResources().getIdentifier("dq", "drawable", getPackageName()));
                ((ImageView) findViewById(R.id.communityDeck)).setImageResource(0);
                teacher1.bringToFront();
                nextText3Button();
            }
        });
    }

    protected void nextText3Button() {
        final Button nextButton = findViewById(R.id.nextButton);
        final Button slapButton = findViewById(R.id.slapPlayer2);
        final TextView teacher1 = findViewById(R.id.teacher1);
        final TextView cardCounter = findViewById(R.id.player2Count);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                teacher1.setText("For example an 8 and 8; or a Q and Q. Shown on screen now. Remember you are only able to see the card on top, so you need to remember the previous card. Click next.");
                nextButton.setClickable(false);
                next3Button();
            }
        });
    }

    protected void next3Button() {
        final Button nextButton = findViewById(R.id.nextButton);
        final Button slapButton = findViewById(R.id.slapPlayer2);
        final TextView teacher1 = findViewById(R.id.teacher1);
        final TextView cardCounter = findViewById(R.id.player2Count);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                teacher1.setText("The second way is called a sandwich. You need to know the previous 2 cards and the card on top to slap this. A sandwich is two identical face value cards with exactly one card in between them. Click next.");
                ((ImageView) findViewById(R.id.example1)).setImageResource(getResources().getIdentifier("c8", "drawable", getPackageName()));
                ((ImageView) findViewById(R.id.example2)).setImageResource(getResources().getIdentifier("d6", "drawable", getPackageName()));
                ((ImageView) findViewById(R.id.example3)).setImageResource(getResources().getIdentifier("d8", "drawable", getPackageName()));
                teacher1.bringToFront();
                nextText4Button();
            }
        });
    }

    //For example an 8 then a 6 then another 8; or a Q then a 3 then another Q. Show on screen now. Remember you are only able to see the card on top, so you need to remember the previous card.
    protected void nextText4Button() {
        final Button nextButton = findViewById(R.id.nextButton);
        final Button slapButton = findViewById(R.id.slapPlayer2);
        final TextView teacher1 = findViewById(R.id.teacher1);
        final TextView cardCounter = findViewById(R.id.player2Count);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                teacher1.setText("For example an 8 then a 6 then another 8; or a Q then a 3 then another Q. Shown on screen now. Remember you are only able to see the card on top, so you need to remember the previous cards. Click next.");
                nextButton.setClickable(false);
                next4Button();
            }
        });
    }


    protected void next4Button() {
        final Button nextButton = findViewById(R.id.nextButton);
        final Button slapButton = findViewById(R.id.slapPlayer2);
        final TextView teacher1 = findViewById(R.id.teacher1);
        final TextView cardCounter = findViewById(R.id.player2Count);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                teacher1.setText("The last way is simple. If a jack is the top card then slap it. Shown on screen now. Remember you have to be quick and slap before your opponent slaps or before another card is drawn. Click next.");
                ((ImageView) findViewById(R.id.example1)).setImageResource(0);
                ((ImageView) findViewById(R.id.example2)).setImageResource(getResources().getIdentifier("sj", "drawable", getPackageName()));
                ((ImageView) findViewById(R.id.example3)).setImageResource(0);
                nextButton.setClickable(false);
                nextText5Button();
            }
        });
    }

    protected void nextText5Button() {
        final Button nextButton = findViewById(R.id.nextButton);
        final Button slapButton = findViewById(R.id.slapPlayer2);
        final TextView teacher1 = findViewById(R.id.teacher1);
        final TextView cardCounter = findViewById(R.id.player2Count);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                teacher1.setText("A time delay is added inbetween card draws to allow time for players to slap. Now click quit at the top and go play for yourself! Or click practice in the top right and go practice when to slap!");
                nextButton.setClickable(false);
            }
        });
    }

    protected void practiceButton() {
        Button practiceButton = findViewById(R.id.practiceButton);
        practiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPractice();
            }
        });
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

    protected void openMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    protected void openPractice() {
        Intent intent1 = new Intent(this, practiceSlapjack.class);
        startActivity(intent1);
        finish();
    }
}
