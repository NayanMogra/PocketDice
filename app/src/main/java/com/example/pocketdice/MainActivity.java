package com.example.pocketdice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button bPlay,bHelp,bExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initalDataSetup();
    }

    private void initalDataSetup() {
        bPlay=(Button)findViewById(R.id.bPlayGame);
        bHelp=(Button)findViewById(R.id.bHelp);
        bExit=(Button)findViewById(R.id.bExit);
        bPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,NameGetActivity.class);
                startActivity(intent);
            }
        });
        bExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
                System.exit(0);
            }
        });
        bHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,HelpActivity.class);
                startActivity(intent);
            }
        });
    }
}
