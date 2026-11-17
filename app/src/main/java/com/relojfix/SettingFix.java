package com.relojfix;

import android.content.Context;
import android.provider.Settings;
import android.util.Log;

/**
 * Unica tarea de esta app: asegurarse de que el ajuste
 * persist.switch_mishow_oob_mode este en "0".
 * No hace nada mas: no manda broadcasts, no programa alarmas,
 * no toca ningun otro paquete.
 */
public final class SettingFix {
    private static final String TAG = "RelojFix";
    private static final String KEY = "persist.switch_mishow_oob_mode";

    private SettingFix() {}

    public static void apply(Context context, String source) {
        try {
            String current = Settings.Global.getString(context.getContentResolver(), KEY);
            if ("0".equals(current)) {
                Log.i(TAG, source + ": ajuste ya estaba en 0");
            } else {
                boolean ok = Settings.Global.putString(context.getContentResolver(), KEY, "0");
                Log.i(TAG, source + ": ajuste era " + current + ", escrito 0, ok=" + ok);
            }
        } catch (Throwable t) {
            Log.w(TAG, source + ": no se pudo escribir el ajuste (falta el permiso?)", t);
        }
    }
}
