package com.a1mobile.Slapjack;

import android.os.Bundle;

public class howTo extends HowToPlay {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_how_to);

        runHowToPlay();
    }
}
