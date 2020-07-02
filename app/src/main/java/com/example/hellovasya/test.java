package com.example.hellovasya;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class test extends AppCompatActivity implements View.OnClickListener {
    Button b;
    int acc = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        b = findViewById(R.id.plus);
        b.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        acc++;
        String count = String.valueOf(acc);
        b.setText(count);
    }
}
