package com.example.game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    // 0== yellow 1== red 2== empty
    public int player = 0;
    public void dropin(View view){
        ImageView counter = (ImageView) view;
        counter.setTranslationY(-2000);
        if (player==0){
            counter.setImageResource(R.drawable.yellow);
            player=1;
        }
        else{
            counter.setImageResource(R.drawable.red);
            player=0;
        }
        counter.animate().translationYBy(2000).setDuration(500).rotation(60000);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}