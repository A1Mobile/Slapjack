package com.a1mobile.Slapjack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class openSpeed extends AppCompatActivity {
    private Button playSpeed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_speed);

        playButton();
    }

    protected void playButton() {
        playSpeed = findViewById(R.id.playButton);

        playSpeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPlaySpeed();
            }
        });
    }

    public void openPlaySpeed() {
        Intent openPlaySpeed = new Intent(this, playSpeed.class);
        startActivity(openPlaySpeed);
        finish();
    }
}
