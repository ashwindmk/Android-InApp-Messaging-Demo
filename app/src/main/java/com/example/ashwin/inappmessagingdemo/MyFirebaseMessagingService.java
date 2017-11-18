package com.example.ashwin.inappmessagingdemo;

import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by ashwin on 18/11/17.
 */

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    private String channelId = "firebase_console";

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        // Executed when app is in foreground
        Intent intent = new Intent(this, DialogActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("title", "Title");
        intent.putExtra("message", remoteMessage.getNotification().getBody());
        Log.i("NOTIFICATION", "body : " + remoteMessage.getNotification().getBody());
        getApplicationContext().startActivity(intent);
    }

}
