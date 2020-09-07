package com.example.findWords;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hellovasya.R;

public class MainActivity extends AppCompatActivity {
    public void showWelcome(String name)
    {
        Intent intent = new Intent(this, Welcome.class);
        intent.putExtra("inName", name);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        EditText name = findViewById(R.id.editText);
        name.setOnEditorActionListener(new EditText.OnEditorActionListener() {

            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE){
                    showWelcome(v.getText().toString());
                    return true;
                }
                return false;
            }
        });
    }
}
