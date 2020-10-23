package com.example.dynamicbinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends FragmentActivity implements MainCallbacks{

    FragmentTransaction ft;
    FragmentBlue blueFragment;
    FragmentRed redFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //create fragment blue
        ft=getSupportFragmentManager().beginTransaction();
        blueFragment = FragmentBlue.newIntance("first_blue");
        ft.replace(R.id.main_holder_blue,blueFragment);
        ft.commit();

        //create fragment red
        ft = getSupportFragmentManager().beginTransaction();
        redFragment = FragmentRed.newIntance("first_red");
        ft.replace(R.id.main_holder_red,redFragment);
        ft.commit();
    }

    @Override
    public void onMsgFromFragToMain(String sender, String position, Student stu) {
        if(sender.equals("RED_FRAG")==true)
        {
            try {
                blueFragment.onMsgFromMainToFragment(position,stu);
            }
            catch (Exception e){
                Log.e("ERROR","onStrFromFragToMain"+e.getMessage());
            }
        }
        if(sender.equals("BLUE_FRAG")==true)
        {
            try {
                redFragment.onMsgFromMainToFragment(position,stu);
            }
            catch (Exception e){
                Log.e("ERROR","onStrFromFragToMain"+e.getMessage());
            }
        }
    }
}
