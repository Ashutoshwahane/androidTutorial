package com.example.tutorialpoint;

import androidx.appcompat.app.AppCompatActivity;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.drawable.Icon;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ShortcutManager shortcutManager =
                (MainActivity.this).getSystemService(ShortcutManager.class);

        Intent dynamicIntent = new Intent(this,MainActivity.class);
        dynamicIntent.setAction(Intent.ACTION_VIEW);


        if (shortcutManager.isRequestPinShortcutSupported()) {
            // Assumes there's already a shortcut with the ID "my-shortcut".
            // The shortcut must be enabled.
            ShortcutInfo pinShortcutInfo =
                    new ShortcutInfo.Builder(this, "s1")
                            .setShortLabel("MainActivity")
                            .setLongLabel("Launch MainActivity")
                            .setIcon(Icon.createWithResource(this, R.mipmap.ic_launcher))
                            .setIntent(dynamicIntent)
                            .build();

            // Create the PendingIntent object only if your app needs to be notified
            // that the user allowed the shortcut to be pinned. Note that, if the
            // pinning operation fails, your app isn't notified. We assume here that the
            // app has implemented a method called createShortcutResultIntent() that
            // returns a broadcast intent.
            Intent pinnedShortcutCallbackIntent =
                    shortcutManager.createShortcutResultIntent(pinShortcutInfo);

            // Configure the intent so that your app's broadcast receiver gets
            // the callback successfully.For details, see PendingIntent.getBroadcast().
            PendingIntent successCallback = PendingIntent.getBroadcast(this, /* request code */ 0,
                    pinnedShortcutCallbackIntent, /* flags */ 0);

            shortcutManager.requestPinShortcut(pinShortcutInfo,
                    successCallback.getIntentSender());
        }
    }






}
