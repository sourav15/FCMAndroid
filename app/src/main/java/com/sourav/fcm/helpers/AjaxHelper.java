package com.sourav.fcm.helpers;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sourav.fcm.helpers.beans.response.ResponseBean;

import java.lang.reflect.Type;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by sourav on 5/6/16.
 */
public class AjaxHelper {

    private static final String TAG = "AjaxHelper";

    public static ResponseBean ajax() {

        String response = null;
        String url = "";
        try {
            OkHttpClient okHttpClient = new OkHttpClient();

            Request request = new Request.Builder()
                    .url(url)
                    .get()
                    .build();
            Response responsehttp = okHttpClient.newCall(request).execute();
            response = responsehttp.body().string();
            Log.d(TAG,"response== "+response);
        } catch (Exception e) {
            if(e.getMessage() != null) {
                Log.e(TAG, e.getMessage());
            }
        }

        ResponseBean finalObject = null;
        Gson gson = new Gson();
        Type finalType = new TypeToken<ResponseBean>() {}.getType();
        try {
            finalObject = gson.fromJson(response, finalType);
        } catch (Exception e) {
            Log.e(TAG, "exception " + e.getMessage());
        }
        if (response != null && !response.equals("")) {
            return finalObject;
        } else {
            return null;
        }
    }
}
