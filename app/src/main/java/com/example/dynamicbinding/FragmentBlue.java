
package com.example.dynamicbinding;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class FragmentBlue extends Fragment implements FragmenCallbacks{
    MainActivity main;
    Context context;
    String message="";
    int preposition;

    TextView textViewBlue;
    ListView listView  ;
    LinearLayout layout_blue ;
    //item for listview
    ArrayList<Student> list;

    //constructor
    public static FragmentBlue newIntance(String strArg)
    {
        FragmentBlue fragment = new FragmentBlue();
        Bundle args = new Bundle();
        args.putString("strArg",strArg);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        list = new ArrayList<>();
        list.add(new Student("A1_9829","Lê Thị A","A1","8",R.drawable.avatar_male));
        list.add(new Student("A1_9830","Bành Văn Toàn","B2","9",R.drawable.img_avatar2));
        list.add(new Student("A1_9831","Sầu Thị Riêng","B1","10",R.drawable.avatar_male));
        list.add(new Student("A1_9832","Lê Thị Đào","A2","7",R.drawable.img_avatar2));
        list.add(new Student("A1_9833","Nguyễn Minh Mẩn","F1","6.5",R.drawable.avatar_male));
        list.add(new Student("A1_9834","Trần Trọng Tuấn","F2","8.5",R.drawable.img_avatar2));
        list.add(new Student("A1_9835","Huỳnh Tông Trạch","C1","9.5",R.drawable.avatar_male));
        list.add(new Student("A1_9836","Hồ Hải Giang","C2","10",R.drawable.img_avatar2));
        list.add(new Student("A1_9837","Đinh Gia Bảo","D3","7",R.drawable.avatar_male));
        list.add(new Student("A1_9838","Tạ Minh Minh","D5","7.5",R.drawable.img_avatar2));
        list.add(new Student("A1_9839","Hầu Tử Tửu","C6","6",R.drawable.avatar_male));
        try {
            context = getActivity();
            main = (MainActivity) getActivity();
        }
        catch (IllegalStateException e)
        {
            throw new IllegalStateException("MainActivity must implement callbacks");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        layout_blue= (LinearLayout) inflater.inflate(R.layout.layout_blue,null);

        textViewBlue = (TextView) layout_blue.findViewById(R.id.textView1Blue);
        listView  = (ListView) layout_blue.findViewById(R.id.listView1Blue);

        listView.setBackgroundColor(Color.parseColor("#ffccddff"));

        CustomAdapter adapter = new CustomAdapter(context,R.layout.layout_blue,list);

        listView.setAdapter(adapter);

        listView.setSelection(0);
        listView.smoothScrollToPosition(0);

        listView.setOnItemClickListener((parent, view, position, id) -> {

            listView.getChildAt(preposition).setBackgroundColor(Color.GRAY);
            preposition = position;
            Student stu = list.get(position);
            String pos = Integer.toString(position);
            main.onMsgFromFragToMain("BLUE_FRAG",pos,stu);
            textViewBlue.setText(list.get(position).getID());
            listView.setBackgroundColor(Color.GRAY);
            listView.getChildAt(position).setBackgroundColor(Color.parseColor("#9bff00"));
        });
        return layout_blue;
    }

    @Override
    public void onMsgFromMainToFragment(String position, Student student) {
        int pos;
        pos = Integer.parseInt(position);
        if(pos < 0){
           pos = list.size() -1;
        }
        if(pos >= list.size()){
            pos=0;
        }
        position = Integer.toString(pos);
        main.onMsgFromFragToMain("BLUE_FRAG",position,(Student)list.get(pos));
        listView.setSelection(pos);
        listView.performItemClick(listView.getChildAt(pos),pos,pos);

    }
}
