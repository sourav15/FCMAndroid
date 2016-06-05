package com.sourav.fcm.fcmservices;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by sourav on 5/6/16.
 */
public class FCMIDService extends FirebaseInstanceIdService {

    public static String TAG = FCMIDService.class.getName();

    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();

       // Get updated InstanceID token.
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG, "Refreshed token: " + refreshedToken);

    }
}
