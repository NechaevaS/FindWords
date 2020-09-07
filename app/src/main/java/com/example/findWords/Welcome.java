package com.example.findWords;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.hellovasya.R;

public class Welcome extends AppCompatActivity implements View.OnClickListener {
    Button start;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_welcom);
        Intent intent = getIntent();
        String name = intent.getStringExtra("inName");
        String welcome = ", let's play a game, the rules are very easy.";
        TextView newT = findViewById(R.id.result);
        newT.setText(newT.getText() + name + welcome);

        start = findViewById(R.id.next);
        start.setOnClickListener(this);

    }
    public  void nextActivity(View v)
    {
        Intent i = new Intent(this, Game.class);
        startActivity(i);
    }

    @Override
    public void onClick(View v) {
        nextActivity(v);
    }

}
