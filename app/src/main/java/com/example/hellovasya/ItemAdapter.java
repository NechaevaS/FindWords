package com.example.hellovasya;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

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

public class ItemAdapter extends ArrayAdapter<ListItem>
{
    private List<ListItem> items;
    private Context context;
    public ItemAdapter(List<ListItem> items, Context context) {
        super(context, R.layout.row, items);
        this.items = items;
        this.context = context;
    }
//    private static class ItemHolder
//    {
//        TextView ItemName;
//        TextView ItemCount;
//        CheckBox check;
//        Button plus;
//        Button minus;
//    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
//        ItemHolder holder = new ItemHolder();
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.row, null);

//            holder.ItemName = v.findViewById(R.id.nameView);
//            holder.ItemCount = v.findViewById(R.id.countView);
//            holder.plus =  v.findViewById(R.id.addButton);
//            holder.minus =  v.findViewById(R.id.removeButton);
//            holder.check = setOnCheckedChangeListener((MyList) context);
        }
//        else{
//            holder = (ItemHolder) v.getTag();
//        }
//        ListItem elem = items.get(position);
//        holder.ItemName.setText(elem.getName());
//        holder.ItemCount.setText(elem.getCount());
//        holder.check.setChecked(elem.isSelect());
//        holder.check.setTag(elem);
        TextView ItemName = v.findViewById(R.id.nameView);
        ItemName.setText(items.get(position).getName());
        TextView ItemCount =  v.findViewById(R.id.countView);
        ItemCount.setText(String.valueOf(items.get(position).getCount()));
        return v;
    }
}


