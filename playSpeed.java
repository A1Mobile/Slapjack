package com.a1mobile.Slapjack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class playSpeed extends speedAction {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_speed);

        runSpeedSlap();
    }
}
