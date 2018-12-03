package com.example.alunos.myapplication;

public class MyFirebaseMessagingService extends FirebaseMessagingService {
    private final String TAG = "MessageService: ";
    @Override
    public void onNewToken(String s){
        super.onNewToken(s);
    }
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        Log.d(TAG, "From: " + remoteMessage.getFrom());
        if(remoteMessage.getData().size() > 0){
            Log.d(TAG, "Message data payload:" + remoteMessage.getData());

            if(true){

            }else{

            }

            if(remoteMessage.getNotification() != null){
                Log.d(TAG, "Message Notification Body:  " + remoteMessage.getNotification().getBody());
            }

        }
    }
}
