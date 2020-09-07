package com.example.findWords;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.hellovasya.R;

import java.util.ArrayList;
import java.util.List;

class ListItem {
    private String name;
    private int count;
    private boolean select = false;

   ListItem (String name, int count)
    {
        this.name = name;
        this.count = count;
    }
    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean isSelect() {
        return select;
    }

    public void setSelect(boolean select) {
        this.select = select;
    }
}


public class ItemAdapter extends ArrayAdapter<ListItem> {
    private List<ListItem> itemList=new ArrayList<ListItem>();
    private Context context;

    public ItemAdapter(List<ListItem> items, Context context) {
        super(context, R.layout.row, items);
        this.itemList=items;
        this.context=context;
    }

    public ListItem getItem(int index) {
        return this.itemList.get(index);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView=convertView;
        if (convertView == null) {
            LayoutInflater inflater=(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            rowView=inflater.inflate(R.layout.row, parent, false);
        }

        TextView ItemName=rowView.findViewById(R.id.nameView);
        ItemName.setText(itemList.get(position).getName());
        TextView ItemCount=rowView.findViewById(R.id.countView);
        ItemCount.setText(String.valueOf(itemList.get(position).getCount()));
        Button plus=rowView.findViewById(R.id.addButton);
        plus.setOnClickListener(new AddButtonListener(itemList, position));
        Button minus=rowView.findViewById(R.id.removeButton);
        minus.setOnClickListener(new RemoveButtonListener(itemList, position));

        return rowView;
    }

    //class AddButtonListener implements View.OnClickListener{
//    private View rowView;
//
//    AddButtonListener(View rowView)
//    {
//        this.rowView = rowView;
//    }
//
//    @Override
//    public void onClick(View v) {
//        TextView c = rowView.findViewById(R.id.countView);
//        int q = Integer.parseInt(String.valueOf(c.getText()));
//        q++;
//        c.setText(String.valueOf(q));
//    }
//}
    class AddButtonListener implements View.OnClickListener {
        private List<ListItem> itemList;
        private int pos;

        AddButtonListener(List<ListItem> itemList, int position) {
            this.itemList=itemList;
            this.pos=position;
        }

        @Override
        public void onClick(View v) {
            itemList.get(pos).setCount(itemList.get(pos).getCount() + 1);
            ListView listView=(ListView) (v.getParent().getParent());
            listView.setAdapter(listView.getAdapter());
        }
    }

    class RemoveButtonListener implements View.OnClickListener {
        private List<ListItem> itemList;
        private int pos;

        RemoveButtonListener(List<ListItem> itemList, int position) {
            this.itemList=itemList;
            this.pos=position;
        }

        @Override
        public void onClick(View v) {
            if (itemList.get(pos).getCount() > 1) {
                itemList.get(pos).setCount(itemList.get(pos).getCount() - 1);
                ListView listView=(ListView) (v.getParent().getParent());
                listView.setAdapter(listView.getAdapter());
            }
        }
    }
}