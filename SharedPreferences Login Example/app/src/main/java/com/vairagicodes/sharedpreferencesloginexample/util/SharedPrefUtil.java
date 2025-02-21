package com.vairagicodes.sharedpreferencesloginexample.util;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefUtil {

    public static final String USER_PREF = "user_pref";
    public static final String IS_USER_LOGGED_IN = "is_user_logged_in";


    public static void saveIfUserIsLoggedIn(Context context,
                                            boolean isUserLoggedIn) {

        SharedPreferences sharedPreferences =
                context.getSharedPreferences(USER_PREF,
                        Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putBoolean(IS_USER_LOGGED_IN, isUserLoggedIn);
        editor.apply();

    }

    public static Boolean isUserLoggedIn(Context context) {
        SharedPreferences sharedPreferences =
                context.getSharedPreferences(USER_PREF,
                        Context.MODE_PRIVATE);

        return sharedPreferences.getBoolean(IS_USER_LOGGED_IN, false);
    }

}
