package com.navatics.app.activities;

import android.os.Bundle;
import android.support.p011v7.app.AppCompatActivity;
import com.navatics.app.R;
import com.navatics.p057cv.GLES3JNIView;
import java.io.IOException;
import org.opencv.android.Utils;

/* loaded from: classes.dex */
public class TestOpenGLActivity extends AppCompatActivity {

    /* renamed from: a */
    GLES3JNIView f3916a;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.p011v7.app.AppCompatActivity, android.support.p008v4.app.FragmentActivity, android.support.p008v4.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f3916a = new GLES3JNIView(this);
        try {
            this.f3916a.setImageMat(Utils.m345a(this, (int) R.drawable.test3));
        } catch (IOException e) {
            e.printStackTrace();
        }
        setContentView(this.f3916a);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.p008v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.f3916a.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.p008v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.f3916a.onResume();
    }
}
