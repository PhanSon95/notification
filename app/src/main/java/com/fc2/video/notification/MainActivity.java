package com.fc2.video.notification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements  NotificationListener{

    private List<Notification> list;
    private ListView listView;
    private Adapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = new ArrayList<>();
        new NotificationService().setListener(this);
        listView = findViewById(R.id.lstNoti);
        adapter = new Adapter(getApplicationContext(), R.layout.notification,list);
        listView.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu) {
        getMenuInflater().inflate(R.menu. menu_main , menu) ; //Menu Resource, Menu
        return true;
    }
    @Override
    public boolean onOptionsItemSelected (MenuItem item) {
        switch (item.getItemId()) {
            case R.id. action_settings :
                Intent intent = new Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS" ) ;
                startActivity(intent) ;
                return true;
            default :
                return super .onOptionsItemSelected(item) ;
        }
    }

    @Override
    public void setValue(String packageName, String title, String body) {
        Notification noti = new Notification();
        noti.setPackageName(packageName);
        noti.setTitle(title);
        noti.setBody(body);
        list.add(noti);
        adapter.notifyDataSetChanged();
    }
}
