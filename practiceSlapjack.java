package com.a1mobile.Slapjack;

import android.os.Bundle;

public class practiceSlapjack extends runPracticeSlapjack {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice_slapjack);

        runPractice();
    }
}
