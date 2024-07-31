package com.senseplay.control;

import android.os.Bundle;
import android.support.p011v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

/* loaded from: classes2.dex */
public class MainActivity extends AppCompatActivity {
    SPControlServer spControlServer;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.p011v7.app.AppCompatActivity, android.support.p008v4.app.FragmentActivity, android.support.p008v4.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_main);
        this.spControlServer = SPControlServer.getInstance();
    }

    /* renamed from: s1 */
    public void m5828s1(View view) {
        this.spControlServer.setLinKInfo(true, 11, 22);
    }

    /* renamed from: r1 */
    public void m5829r1(View view) {
        this.spControlServer.setJoystickListener(new JoystickListener() { // from class: com.senseplay.control.MainActivity.1
            @Override // com.senseplay.control.JoystickListener
            public void joyStock1(int i) {
                Log.w("rec", "joyStock1: " + i);
            }

            @Override // com.senseplay.control.JoystickListener
            public void joyStock2(int i) {
                Log.w("rec", "joyStock2: " + i);
            }
        });
        this.spControlServer.setKeyListener(new KeyListener() { // from class: com.senseplay.control.MainActivity.2
            @Override // com.senseplay.control.KeyListener
            public void onKye(String str, String str2) {
            }
        });
    }
}
