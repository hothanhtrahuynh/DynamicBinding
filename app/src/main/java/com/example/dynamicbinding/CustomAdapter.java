package com.example.dynamicbinding;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends ArrayAdapter<Student> {


    private Context context;
    private int resource;
    ArrayList<Student> _list;
    public CustomAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Student> list) {
        super(context, resource, list);
        this.resource = resource;
        this.context = context;
        _list = list;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
      View row =convertView;

      if(row==null)
      {
          LayoutInflater inflater =((Activity)context).getLayoutInflater();
          row = inflater.inflate(R.layout.customlistiview_layout,null);

          ImageView img =row.findViewById(R.id.avatar);
          TextView id =(TextView)  row.findViewById(R.id.txtBLueID);


          id.setText(_list.get(position).getID());
          img.setImageResource(_list.get(position).getAvatar());
      }

      return row;
    }
}
