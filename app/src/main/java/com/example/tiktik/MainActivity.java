package com.example.tiktik;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
//    0 - X
//    1_- 0
//    2 - Blank
    int activePlayer = 0;
    int gameState[] = {2,2,2,2,2,2,2,2,2};
    int winposition [] [] = {{0,1,2},{3,4,5},{6,7,8},
            {0,3,6},{1,4,7},{2,5,8},
            {0,4,8},{2,4,6}};
    boolean gameActive = true;
    public void playerTap(View view){

        ImageView img = (ImageView) view;
        int tappedImage = Integer.parseInt(img.getTag().toString());
        if(!gameActive){
            gameReset(view);
        }
        if(gameState[tappedImage]==2){
            gameState[tappedImage] = activePlayer;
            if(activePlayer==0){
                img.setImageResource(R.drawable.xx);
                activePlayer = 1;
                TextView status =  findViewById(R.id.status);
                status.setText("O's turn - Tap to play");
            }
            else{
                img.setImageResource(R.drawable.o);
                activePlayer = 0;
                TextView status = findViewById(R.id.status);
                status.setText("X's turn - Tap to play");
            }
        }

        for(int[] winpositions:winposition){
            if(gameState[winpositions[0]]==gameState[winpositions[1]] && gameState[winpositions[1]] == gameState[winpositions[2]]&&
            gameState[winpositions[0]]!=2){
                gameActive = false;
                String winner;
                if(gameState[winpositions[0]]==0){
                    winner = "X has won the game.";
                }
                else{
                    winner = "O has won the game.";
                }
                TextView status = findViewById(R.id.status);
                status.setText(winner);

            }


        }

    }
    public void gameReset(View view){
        gameActive = true;
        activePlayer = 0;
        for(int i =0;i<gameState.length;i++){
            gameState[i] = 2;
        }
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView9)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView10)).setImageResource(0);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}