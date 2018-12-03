package com.example.alunos.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {


    public native String stringFromJNI();
    private NotificationManager notificationManager;
    private NotificationCompat.Builder notificationBuilder;
    private final String NOTIFICATION_CHANNEL_ID = "my_channel_id_01";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent resultIntent = new Intent(this, ResultActivity.class);
        PendingIntent resultPendingIntent = TaskStackBuilder.create(this).addNextIntentWithParentStack(resultIntent).getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
    }

    button notif = findViewById(R.id.btnNotif);
    notif.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view){
            notificationManager.notify(0, notificationBuilder;build());
        }
    });
}
