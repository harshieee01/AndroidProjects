package com.vairagicodes.sharedprefexample.util;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefUtil {

    public static String PRF_NAME = "userPref";
    public static String IS_USER_LOGIN = "isUserLogin";

    public static void userLogeedInOrNot(Context context, boolean isUserLogin) {

        SharedPreferences sharedPreferences = context.getSharedPreferences(PRF_NAME, Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putBoolean(IS_USER_LOGIN, isUserLogin);

        editor.apply();

    }


    public static Boolean isUserLoggedIn(Context context) {

        SharedPreferences sharedPreferences = context.getSharedPreferences(PRF_NAME, Context.MODE_PRIVATE);


        return sharedPreferences.getBoolean(IS_USER_LOGIN,false);

    }
}