package com.a1mobile.Slapjack;

import android.support.v7.app.AppCompatActivity;

import java.util.Arrays;
import java.util.Random;

public class fillCards extends AppCompatActivity {
    protected Card[] deckOfCards = new Card[52];
    protected int suit = 0;
    protected int num = 0;
    protected String cardSuit = "";
    protected String cardNum = "";
    protected String cardAdd = "";
    protected String sameCard = "True";

    //Checks which position has been used
    protected int[] positionHolder = new int[52];

    //Checks which card has been used using suit + faceValue
    protected String[] cardHolder = new String[52];

    //Fill the deck of cards randomly
    protected void fillDeck() {
        for (int i = 0; i < 52; i++) {
            cardHolder[i] = "0";
        }

        for (int i = 0; i < 52; i++) {
            sameCard = "True";
            while (sameCard.equals("True")) {
                Random s = new Random();
                Random n = new Random();
                suit = s.nextInt(4);
                num = n.nextInt(13);
                num = num + 2;

                switch (suit) {
                    case 0:
                        cardSuit = "s";
                        break;
                    case 1:
                        cardSuit = "h";
                        break;
                    case 2:
                        cardSuit = "c";
                        break;
                    case 3:
                        cardSuit = "d";
                        break;
                }

                switch (num) {
                    case 2:
                        cardNum = "2";
                        break;
                    case 3:
                        cardNum = "3";
                        break;
                    case 4:
                        cardNum = "4";
                        break;
                    case 5:
                        cardNum = "5";
                        break;
                    case 6:
                        cardNum = "6";
                        break;
                    case 7:
                        cardNum = "7";
                        break;
                    case 8:
                        cardNum = "8";
                        break;
                    case 9:
                        cardNum = "9";
                        break;
                    case 10:
                        cardNum = "10";
                        break;
                    case 11:
                        cardNum = "j";
                        break;
                    case 12:
                        cardNum = "q";
                        break;
                    case 13:
                        cardNum = "k";
                        break;
                    case 14:
                        cardNum = "a";
                        break;
                }

                cardAdd = cardSuit + "" + cardNum;
                if (Arrays.asList(cardHolder).contains(cardAdd)) {
                    sameCard = "True";
                }
                else {
                    sameCard = "False";
                    cardHolder[i] = cardAdd;
                    deckOfCards[i] = new Card(cardSuit, cardNum, num, i);
                }
            }
        }
    }
}

