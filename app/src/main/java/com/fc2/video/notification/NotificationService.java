package com.fc2.video.notification;

import android.content.Context;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.util.Log;

public class NotificationService extends NotificationListenerService {
    private String TAG = this.getClass().getSimpleName();
    Context context;
    static NotificationListener myListener;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    @Override
    public void onNotificationPosted(StatusBarNotification sbn) {
        String title = sbn.getNotification().extras.getString("android.title");
        String text = sbn.getNotification().extras.getString("android.text");
        String package_name = sbn.getPackageName();

        myListener .setValue( package_name, title, text) ;
    }

    @Override
    public void onNotificationRemoved(StatusBarNotification sbn) {
        String title = sbn.getNotification().extras.getString("android.title");
        String text = sbn.getNotification().extras.getString("android.text");
        String package_name = sbn.getPackageName();
        myListener .setValue( package_name, title, text) ;
    }

    public void setListener(NotificationListener listener) {
        NotificationService.myListener = listener;
    }
}
