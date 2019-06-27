package com.example.pocketdice;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.*;
import android.widget.ArrayAdapter;


public class HelpActivity extends Activity {


    private TextView t1;

    private ListView l1;
    private String[] list = {"Start the game.Click On Play Game.",
            "Its Two player game so its starts from player 1.There are two dices one for player 1 followed by player 2", "You have two option roll hold.",
            "If u wanna roll then click on dice ,the number occur in the dice is hold for timing.",
            "Now you have again option to roll or holed if u click roll then last hold value and this new dice value added up and you get new hold value.",
            "But if you get 1 in dice your hold score become zero and turn goes to next player.",
            "But if you press hold the your hold value get stored permanently and no matters if one occurs anytime this value will not become zero.",
            "Player who reach 100 will win!!"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        l1 = (ListView) findViewById(R.id.lvHelp);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
        l1.setAdapter(adapter);
    }
}

