package com.example.covidfight;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

class SessionManager {
    private SharedPreferences.Editor editor;
    private static final String PREF_NAME = "get_token";
    private static final String KEY_TOKEN = "token";
    @SuppressLint("CommitPrefEdits")
    SessionManager(Context context){
        int PRIVATE_MODE = 0;
        SharedPreferences pref = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }
    void createLoginSession(String token) {
        editor.putString(KEY_TOKEN,token);
        editor.commit();
    }

}
