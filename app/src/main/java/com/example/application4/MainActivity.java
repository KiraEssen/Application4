package com.example.application4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         FragmentManager fragMan = getSupportFragmentManager();
         FragmentTransaction fragmentTransaction = fragMan.beginTransaction();
         MyFragment myFrag = MyFragment.newInstance();
         fragmentTransaction.add(R.id.activityId, myFrag);
         fragmentTransaction.commit();
    }
}