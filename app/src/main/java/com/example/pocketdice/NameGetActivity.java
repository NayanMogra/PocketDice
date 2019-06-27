package com.example.pocketdice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NameGetActivity extends AppCompatActivity {
EditText player1name,player2name;
Button play;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_get);
        player1name=(EditText)findViewById(R.id.player1Name);
        player2name=(EditText)findViewById(R.id.player2Name);
        player1name.setText("Player 1");
        player2name.setText("Player 2");

        play=(Button)findViewById(R.id.play);
        initialdatasetup();
         }

    private void initialdatasetup() {

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string1 = player1name.getText().toString();
                String string2 = player2name.getText().toString();
                Intent intent=new Intent(NameGetActivity.this,PlayGameActivity.class);
                intent.putExtra("name1",string1);
                intent.putExtra("name2",string2);
                startActivity(intent);

            }
        });
    }
}
