package com.example.application4;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;

public class MyService extends Service {

    public void onCreate() {
        super.onCreate();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        String message = intent.getStringExtra(MyFragment.MESSAGE);
        Intent intnt = new Intent(MyFragment.BROADCAST_ACTION).putExtra(MyFragment.MESSAGE, message);
        sendBroadcast(intnt);
        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

}


