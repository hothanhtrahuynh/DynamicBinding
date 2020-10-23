package com.example.dynamicbinding;

import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.Date;

public class FragmentRed extends Fragment implements FragmenCallbacks {

    MainActivity main;
    TextView txtRedID,txtRedGrade,txtRedName,txtRedMark;
    Button btnRedF,btnRedN,btnRedP,btnRedL;
    int pos;
    Student student;
    public static FragmentRed newIntance(String strArg1)
    {
        FragmentRed fragment = new FragmentRed();
        Bundle bundle = new Bundle();
        bundle.putString("arg1",strArg1);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(!(getActivity() instanceof MainCallbacks))
        {
            throw new IllegalStateException(("Activity must implement MainCallbacks"));
        }
        main = (MainActivity) getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //super.onCreateView(inflater, container, savedInstanceState);
        LinearLayout layout_red = (LinearLayout) inflater.inflate(R.layout.layout_red,null);

        txtRedID = (TextView) layout_red.findViewById(R.id.txtID);
        txtRedName = (TextView) layout_red.findViewById(R.id.txtName);
        txtRedGrade = (TextView) layout_red.findViewById(R.id.txtGrade);
        txtRedMark = (TextView) layout_red.findViewById(R.id.txtMark);

        try {
            Bundle arguments  =getArguments();
          // txtRedID.setText(arguments.getString("arg1",""));
        }catch (Exception e) {
            Log.e("RED BUNDLE ERROR - ",""+e.getMessage());
        }

        btnRedF = layout_red.findViewById(R.id.btnFirst);
        btnRedN = layout_red.findViewById(R.id.btnNext);;
        btnRedP= layout_red.findViewById(R.id.btnPrevious);;
        btnRedL= layout_red.findViewById(R.id.btnLast);;

        btnRedF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pos=0;
                String position = Integer.toString(pos);
                main.onMsgFromFragToMain("RED_FRAG",position,student);
            }
        });

        btnRedP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pos=pos-1;
                String position = Integer.toString(pos);
                main.onMsgFromFragToMain("RED_FRAG",position,student);
            }
        });

        btnRedN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pos=pos+1;
                String position = Integer.toString(pos);
                main.onMsgFromFragToMain("RED_FRAG",position,student);
            }
        });

        btnRedL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pos=-1;
                String position = Integer.toString(pos);
                main.onMsgFromFragToMain("RED_FRAG",position,student);
            }
        });
        return layout_red;
    }


    @Override
    public void onMsgFromMainToFragment(String position, Student student) {
        this.student=student;
        pos = Integer.parseInt(position);
        txtRedID.setText(student.getID());;
        txtRedMark.setText(student.getMark());
        txtRedGrade.setText(student.getGrade());
        txtRedName.setText(student.getName());
    }
}
