package com.example.mytp1;

import android.app.Application;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.preference.PreferenceManager;

import java.util.Locale;

public class MyApplication extends Application {


        @Override
        public void onCreate() {
            super.onCreate();
            updateLanguage();
        }

        public void updateLanguage() {
            SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
            String language = sharedPreferences.getString("language", "");
            Locale locale;
            if (language.equals("fr")) {
                locale = new Locale("fr");
            } else {
                locale = new Locale("en");
            }
            Resources res = getResources();
            Configuration config = new Configuration(res.getConfiguration());
            config.setLocale(locale);
            res.updateConfiguration(config, res.getDisplayMetrics());
        }
    }


