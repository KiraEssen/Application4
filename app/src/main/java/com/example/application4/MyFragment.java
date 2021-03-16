package com.example.application4;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MyFragment extends Fragment {

    public final static String MESSAGE = "message";
    public final static String BROADCAST_ACTION = "com.example.application4.serviceBroadcastTest01";
    final String LOG_TAG = "myLogs";

    EditText et;
    TextView tv;
    Button bt;
    BroadcastReceiver br;

    public static MyFragment newInstance(){
        return new MyFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.my_fragment, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        et = (EditText) view.findViewById(R.id.editText);
        tv = (TextView) view.findViewById(R.id.textView);
        bt = (Button) view.findViewById(R.id.button);

        br = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                tv.setText(intent.getStringExtra(MESSAGE));
                Log.d(LOG_TAG, "onReceive: set = " + intent.getStringExtra(MESSAGE));
            }
        };

        IntentFilter intFilter = new IntentFilter(BROADCAST_ACTION);
        getActivity().registerReceiver(br, intFilter);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().startService(
                        new Intent(getActivity(), MyService.class).putExtra(MESSAGE, et.getText().toString()));
                Log.d(LOG_TAG, "onReceive: get = " + et.getText().toString());
            }
        });
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        getActivity().unregisterReceiver(br);
    }
}
