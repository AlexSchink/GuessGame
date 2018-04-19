package com.example.alexanderschink.guessgame;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;

public class Main2Activity extends AppCompatActivity {
    private SharedPreferences preferences;

    private SeekBar seekBarLow;
    private SeekBar seekBarUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        preferences = getSharedPreferences("guessgame", MODE_PRIVATE);

        seekBarLow = (SeekBar) findViewById(R.id.seekBarLow);
        seekBarUp = (SeekBar) findViewById(R.id.seekBarUp);
    }

    @Override
    protected void onResume() {
        super.onResume();
        preferences = getSharedPreferences("guessgame", MODE_PRIVATE);


        int progressLow = preferences.getInt("seekBarLow", 0);
        seekBarLow.setProgress(progressLow);


        int progressUp = preferences.getInt("seekBarUp", 0);
        seekBarUp.setProgress(progressUp);

        System.out.println(preferences.getInt("seekBarLow", 0));
        System.out.println(progressLow);
        System.out.println(preferences.getInt("seekBarUp", 0));
        System.out.println(progressUp);

    }

    @Override
    protected void onPause() {
        super.onPause();
        int low = seekBarLow.getProgress();
        int up = seekBarUp.getProgress();


        preferences = getSharedPreferences("guessgame", MODE_PRIVATE);
        preferences.edit()
                .putInt("seekBarLow", low)
                .apply();
        preferences.edit()
                .putInt("seekBarUp", up )
                .apply();

        System.out.println(low);
        System.out.println(preferences.getInt("seekBarLow", 0));
        System.out.println(up);
        System.out.println(preferences.getInt("seekBarUp", 0));
    }

    @Override
    protected void onStop() {
        super.onStop();

        int low = seekBarLow.getProgress();
        int up = seekBarUp.getProgress();


        preferences = getSharedPreferences("guessgame", MODE_PRIVATE);
        preferences.edit()
                .putInt("seekBarLow", low)
                .apply();
        preferences.edit()
                .putInt("seekBarUp", up )
                .apply();

        System.out.println(low);
        System.out.println(preferences.getInt("seekBarLow", 0));
        System.out.println(up);
        System.out.println(preferences.getInt("seekBarUp", 0));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        preferences = getSharedPreferences("guessgame", MODE_PRIVATE);
        preferences.edit()
                .putInt("seekBarLow", seekBarLow.getProgress())
                .apply();
        preferences.edit()
                .putInt("seekBarUp", seekBarUp.getProgress())
                .apply();
    }
}
