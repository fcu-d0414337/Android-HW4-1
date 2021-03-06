package com.example.user.myapplication;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class Main2Activity extends BroadcastReceiver{
    static int id=70000;

    @Override
    public void onReceive(Context context , Intent intent)
    {
        String msg = intent.getStringExtra("KEY_STR");
        Intent newintent = new Intent();
        newintent.setClass(context,MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context,0,newintent,0);
        Notification notify = newNotification(context,pendingIntent,"(New) Broadcast is received.",msg);
        NotificationManager notificationManager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(id++,notify);
    }

    @SuppressLint("NewApi")
    private Notification newNotification(Context context,PendingIntent pi,String title,String msg)
    {
        Notification.Builder builder = new Notification.Builder(context);
        builder.setContentTitle(title);
        builder.setContentText(msg);
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setContentIntent(pi);
        builder.setTicker(msg);
        builder.setWhen(System.currentTimeMillis());
        Notification notify = builder.build();
        return notify;
    }
}