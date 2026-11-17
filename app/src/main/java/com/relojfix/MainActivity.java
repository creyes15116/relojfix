package com.relojfix;

import android.app.Activity;
import android.os.Bundle;

/**
 * Se abre, corrige el ajuste si hace falta, y se cierra sola.
 * Sirve para probar la app a mano con:
 *   adb shell am start -n com.relojfix/.MainActivity
 */
public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SettingFix.apply(this, "activity");
        finish();
    }
}
