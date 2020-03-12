package com.impact.ontmobileapp.services

import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

public class FirstFirebaseInstanceService : FirebaseMessagingService() {
    override fun onMessageReceived(p0: RemoteMessage?) {
        super.onMessageReceived(p0)
    }

    override fun onNewToken(p0: String?) {
        super.onNewToken(p0)
    }

    fun showNotification(title: String, body: String) {
        /*
        * https://www.youtube.com/watch?v=QXPgMUSfYFI&feature=emb_logo
        * 9:00
        * */
    }
}