package com.example.hellovasya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class Welcome extends AppCompatActivity implements View.OnClickListener {
    Button start;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_welcom);
        Intent intent = getIntent();
        String name = intent.getStringExtra("inName");
        TextView newT = findViewById(R.id.result);
        newT.setText(newT.getText() + name);

        start = findViewById(R.id.next);
        start.setOnClickListener(this);

    }
    public  void nextActivity(View v)
    {
        Intent i = new Intent(this, MyList.class);
        startActivity(i);
    }

    @Override
    public void onClick(View v) {
        nextActivity(v);
    }

}
