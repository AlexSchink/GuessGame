package com.example.alexanderschink.guessgame;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences preferences;
    private TextView statusText;
    private TextView guessRange;
    private EditText guessField;

    private int secretNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferences = getSharedPreferences("guessgame", MODE_PRIVATE);


        //define boarders of secret number here



        statusText = (TextView) findViewById(R.id.statusText);
        guessField = (EditText) findViewById(R.id.guessField);
        guessRange = (TextView) findViewById(R.id.guessRange);



        //statusText.setText("" + preferences.getInt("seekBarHigh", 0));


        guessField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence string, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {

                    int value = Integer.parseInt(s.toString());

                    if (value == secretNumber){
                        statusText.setText("you won!");
                    }
                    else {
                        if (value != secretNumber) {
                            statusText.setText("Keep trying.");

                        }
                    }


                }catch (Exception e){

                }

            }

            @Override
            public void afterTextChanged(Editable s) {

                System.out.println("done...");

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        int progressLow = preferences.getInt("seekBarLow", 0);
        int progressUp = preferences.getInt("seekBarUp", 0);

        guessRange.setText("Guess a value between " + progressLow + " and " + progressUp);


        Random random = new Random();
        secretNumber = 1 + random.nextInt( (progressUp-progressLow)+1)+progressLow;

    }


    public void Settings(View view){

        Intent goSettings = new Intent(this, Main2Activity.class);
        startActivity(goSettings);
    }
}
