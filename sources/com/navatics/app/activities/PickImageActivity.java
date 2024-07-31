package com.navatics.app.activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.p011v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import com.navatics.app.R;
import java.io.FileNotFoundException;

/* loaded from: classes.dex */
public class PickImageActivity extends AppCompatActivity implements View.OnClickListener {

    /* renamed from: a */
    private Uri f3727a;

    /* renamed from: b */
    private Button f3728b;

    /* renamed from: c */
    private ImageView f3729c;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.p011v7.app.AppCompatActivity, android.support.p008v4.app.FragmentActivity, android.support.p008v4.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.pick_activity);
        this.f3728b = (Button) findViewById(R.id.button);
        this.f3728b.setOnClickListener(this);
        this.f3727a = Uri.parse("file:///sdcard/temp.png");
        this.f3729c = (ImageView) findViewById(R.id.imageview);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != R.id.button) {
            return;
        }
        Intent intent = new Intent("android.intent.action.PICK", (Uri) null);
        intent.setType("image/*");
        intent.putExtra("crop", "true");
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        intent.putExtra("outputX", 200);
        intent.putExtra("outputY", 100);
        intent.putExtra("scale", true);
        intent.putExtra("return-data", false);
        intent.putExtra("output", this.f3727a);
        intent.putExtra("outputFormat", Bitmap.CompressFormat.PNG.toString());
        intent.putExtra("noFaceDetection", false);
        startActivityForResult(intent, 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.p008v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Uri uri;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 1 && (uri = this.f3727a) != null) {
            this.f3729c.setImageBitmap(m9287a(uri));
        }
    }

    /* renamed from: a */
    private Bitmap m9287a(Uri uri) {
        try {
            return BitmapFactory.decodeStream(getContentResolver().openInputStream(uri));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
