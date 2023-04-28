package com.example.game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    // 0== yellow 1== red 2== empty
    public int[] gamestate={2,2,2,2,2,2,2,2,2};
    public int[][] winningpositions={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,5,8},{2,5,7}};
    public int player = 0;
    public void dropin(View view){
        ImageView counter = (ImageView) view;
        //at start the places should be empty
        counter.setTranslationY(-2000);

        //array update
        Log.i("tag-------",counter.getTag().toString());
        int tag_of_place=Integer.parseInt(counter.getTag().toString());
        gamestate[tag_of_place]=player;

        // placing the coins
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