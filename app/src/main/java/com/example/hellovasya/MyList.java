package com.example.hellovasya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class MyList extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {
    ListView list;
    Button b;
    int acc = 1;
    Button quantity;
    EditText new_item;
    Button plus;

    ArrayList<ListItem> items;
    ItemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        b = findViewById(R.id.add_item);
        quantity = findViewById(R.id.count);
        new_item = findViewById(R.id.item_text);
        list = findViewById(R.id.list_view);

        items = new ArrayList<>();

        adapter = new ItemAdapter(items, this);

        quantity.setOnClickListener(this);
        b.setOnClickListener(this);
//        list.setOnItemClickListener(this);

//        plus = findViewById(R.id.addButton);
//        plus.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        ListView listView = findViewById(R.id.list_view);
        switch(v.getId())
        {
            case R.id.add_item:
                String itemName = new_item.getText().toString();
                int itemCount = acc;
                ListItem elem = new ListItem(itemName, itemCount);
                acc = 1;
                items.add(elem);

                listView.setAdapter(adapter);
                new_item.setText("");
                quantity.setText("1");
                Toast.makeText(this, "Item added", Toast.LENGTH_SHORT).show();
                break;
            case R.id.count:
                acc++;
                String i=String.valueOf(acc);
                quantity.setText(i);
                listView.setAdapter(adapter);
                break;
            case R.id.addButton:
                TextView c = findViewById(R.id.countView);
                int q = Integer.parseInt(String.valueOf(c.getText()));
                q++;
                c.setText(String.valueOf(q));
                listView.setAdapter(adapter);

        }

        }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        items.remove(position);
    }
}

