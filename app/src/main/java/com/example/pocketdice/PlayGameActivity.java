package com.example.pocketdice;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class PlayGameActivity extends AppCompatActivity {
    Button bReset,bHold;
    private ImageView imageViewDice1,imageViewDice2;
    int chanceCount,countHold,countPlayer1,countPlayer2;
    TextView tvHold,tvPlayer1,tvPlayer2,indication,p1name,p2name,p1dice,p2dice;
    String player1name, player2name;
    private Random rng = new Random();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_game);
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
         player1name= extras.getString("name1");
         player2name= extras.getString("name2");


        initialDataSetup();
    }

    private void initialDataSetup() {

        chanceCount=0;countHold=0;countPlayer1=0;countPlayer2=0;
        bReset=(Button)findViewById(R.id.bReset);
        p1name=(TextView)findViewById(R.id.name1);
        p2name=(TextView)findViewById(R.id.name2);
        p1name.setText(player1name);
        p2name.setText(player2name);
        bHold=(Button)findViewById(R.id.bHold);
        imageViewDice1 = findViewById(R.id.image_view_dice1);
        imageViewDice2 = findViewById(R.id.image_view_dice2);
        tvHold=(TextView)findViewById(R.id.tvHold);
        indication=(TextView)findViewById(R.id.playerIndication);
        tvPlayer1=(TextView)findViewById(R.id.playOneHoldScore);
        tvPlayer2=(TextView)findViewById(R.id.playTwoHoldScore);
        p1dice=(TextView)findViewById(R.id.p1dice);
        p2dice=(TextView)findViewById(R.id.p2dice);
        tvHold.setText("0");
        tvPlayer1.setText("0");
        tvPlayer2.setText("0");
        bReset.setEnabled(true);
        bHold.setEnabled(true);
        imageViewDice1.setEnabled(true);
        imageViewDice2.setEnabled(false);

        diceDecider();

        bHold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultGenrator();
            }
        });
        bReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            initialDataSetup();
            }
        });
    }

    private void diceDecider() {
        if(chanceCount % 2 == 0)
        {
            imageViewDice1.setEnabled(true);
            imageViewDice2.setEnabled(false);
            indication.setText(player1name+" Chance");
            imageViewDice1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    rollDice(imageViewDice1);

                }
            });

        }
        else
        {
            imageViewDice1.setEnabled(false);
            imageViewDice2.setEnabled(true);
            indication.setText(player2name+" chance");
            imageViewDice2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    rollDice(imageViewDice2);
                }
            });

        }
    }

    private void rollDice(ImageView imageViewDice) {
        checkWinner();

        int randomNumber = rng.nextInt(6) + 1;

        switch (randomNumber) {
            case 1:
                imageViewDice.setImageResource(R.drawable.dice1);
                holdGenerator(1);break;
            case 2:
                imageViewDice.setImageResource(R.drawable.dice2);
                holdGenerator(2);break;
            case 3:
                imageViewDice.setImageResource(R.drawable.dice3);
                holdGenerator(3);break;
            case 4:
                imageViewDice.setImageResource(R.drawable.dice4);
                holdGenerator(4);break;
            case 5:
                imageViewDice.setImageResource(R.drawable.dice5);
                holdGenerator(5);break;
            case 6:

                imageViewDice.setImageResource(R.drawable.dice6);
                holdGenerator(6);break;
        }

    }

    private void resultGenrator() {

        if(chanceCount%2==0)
        {
            diceDecider();
            countPlayer1+=countHold;
            indication.setText(player2name+"chance");
            chanceCount++;
            tvPlayer1.setText(String.valueOf(countPlayer1));
            countHold=0;
            tvHold.setText(String.valueOf(countHold));
            diceDecider();
            checkWinner();

        }
        else
        {

            chanceCount++;
            indication.setText(player1name+"chance");
            countPlayer2+=countHold;
            tvPlayer2.setText(String.valueOf(countPlayer2));
            countHold=0;
            tvHold.setText(String.valueOf(countHold));
            diceDecider();
            checkWinner();
        }
    }


    private void checkWinner() {
        if(countPlayer1>=100)
        {
            indication.setText(player1name+" Win");
            bHold.setEnabled(false);

        }
        else if(countPlayer2>=100)
        {
            indication.setText(player2name+" Win");
            bHold.setEnabled(false);
         }

    }


    private void holdGenerator(int i) {
        if(i == 1) {
            countHold = 0;
            chanceCount++;
            diceDecider();
            tvHold.setText(String.valueOf(countHold));
            if(chanceCount%2==0) {
                indication.setText(player1name+" Chance");
            }
            else
            {
                diceDecider();
                indication.setText(player2name+" Chance");
            }
            }

        else
        {
            countHold = countHold + i;
        }

        tvHold.setText(String.valueOf(countHold));
        checkWinner();
    }
}
