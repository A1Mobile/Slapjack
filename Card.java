package com.a1mobile.Slapjack;

public class Card {
    private String faceName, suit;
    private int faceValue, position;

    public Card(String suit, String face, int value, int position){
        this.suit = suit;
        this.faceName = face;
        this.faceValue = value;
        this.position = position;
    }

    public int getPosition() {return position;}
    public int getFaceValue(){ return faceValue; }
    public String getFaceName() {
        return faceName;
    }
    public String getSuit() {
        return suit;
    }
}
