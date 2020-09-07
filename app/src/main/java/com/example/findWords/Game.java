package com.example.findWords;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Window;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hellovasya.R;

public class Game extends AppCompatActivity {

    String[] data =new String[]{"Swift", "Kotlin", "ObjectiveC", "Variable", "Java", "Mobile"};
    private TextView mTimer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_game);

        mTimer =findViewById(R.id.tv);

        final CountDownTimer start=new CountDownTimer(10000, 1000) {
            @SuppressLint("SetTextI18n")
            public void onTick(long millisUntilFinished) {
                mTimer.setText("time " + millisUntilFinished / 1000);
            }

            @Override
            public void onFinish() {
                mTimer.setText("Time is up");
            }
        }
                .start();
    }
}
