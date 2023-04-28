package com.example.game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // 0== yellow 1== red 2== empty
    public int[] gamestate={2,2,2,2,2,2,2,2,2};
    public int[][] winningpositions={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    public int player = 0;
    boolean gameactive = true;
    public void dropin(View view){
        ImageView counter = (ImageView) view;
        //at start the places should be empty
        counter.setTranslationY(-2000);

        //array update
        Log.i("tag-------",counter.getTag().toString());
        int tag_of_place=Integer.parseInt(counter.getTag().toString());


        if (gamestate[tag_of_place]==2 && gameactive){

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

        //the main part of the game deciding who had won the game
        for(int[] winningposition:winningpositions){
            if ((gamestate[winningposition[0]]!=2) && (gamestate[winningposition[0]]==gamestate[winningposition[1]]) && (gamestate[winningposition[1]]==gamestate[winningposition[2]])){
                String won = "";
                if (player==1){
                    won= "YELLOW";
                    gameactive=false;
                }
                else{
                    won="RED";
                    gameactive=false;
                }

                Button restart = (Button) findViewById(R.id.button);
                TextView te =(TextView) findViewById(R.id.textView);
                te.setText(won+" HAS WON THE GAME");
                te.setVisibility(View.VISIBLE);
                restart.setVisibility(View.VISIBLE);
            }
            }
        }
    }
    public void res(View view){
        Button restart = (Button) findViewById(R.id.button);
        TextView te =(TextView) findViewById(R.id.textView);
        te.setVisibility(View.INVISIBLE);
        restart.setVisibility(View.INVISIBLE);
        Log.i("running goooood","agdshfsghjgkfjhjkdsjahdg");
        androidx.gridlayout.widget.GridLayout gridLayout =  findViewById(R.id.gridLayout);
        for (int i = 0; i < gridLayout.getChildCount(); i++) {
            ((ImageView) gridLayout.getChildAt(i)).setImageResource(0);
        }

        for(int i=0;i<gamestate.length;i++){
            gamestate[i]=2;
        }
        player = 0;
        gameactive = true;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}