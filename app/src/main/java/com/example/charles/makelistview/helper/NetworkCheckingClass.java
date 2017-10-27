package com.example.charles.makelistview.helper;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by charles on 2017. 10. 27..
 * Newwork Checking Class
 */

public class NetworkCheckingClass {

    public static boolean isNetworkAvailable(Context context) {
        boolean ret = false;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager != null) {
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            ret = networkInfo != null && networkInfo.isConnected();
        }
        return ret;
    }

}
