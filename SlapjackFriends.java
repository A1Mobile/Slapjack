package com.a1mobile.Slapjack;

import android.os.Bundle;

public class SlapjackFriends extends playSlapjack {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slapjack_friends);
    }

    protected void onStart() {
        super.onStart();
        playSlapjackFriendFirst();
    }
}
