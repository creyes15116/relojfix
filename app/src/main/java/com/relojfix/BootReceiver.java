package com.relojfix;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Se activa solo al arrancar el reloj. Corrige el ajuste y no hace nada mas:
 * no programa alarmas repetidas, no manda broadcasts.
 */
public class BootReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        SettingFix.apply(context, "boot");
    }
}
