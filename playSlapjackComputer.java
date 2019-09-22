package com.a1mobile.Slapjack;

import android.os.Bundle;

public class playSlapjackComputer extends SlapjackComputer {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_slapjack_computer);

        playSlapjackComputerFirst();
    }
}
