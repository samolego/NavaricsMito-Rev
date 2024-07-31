package com.theartofdev.edmodo.cropper;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.p008v4.content.ContextCompat;
import android.support.p011v7.app.ActionBar;
import android.support.p011v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;
import java.io.File;
import java.io.IOException;

/* loaded from: classes2.dex */
public class CropImageActivity extends AppCompatActivity implements CropImageView.InterfaceC2616b, CropImageView.InterfaceC2620f {

    /* renamed from: a */
    private CropImageView f8190a;

    /* renamed from: b */
    private Uri f8191b;

    /* renamed from: c */
    private CropImageOptions f8192c;

    @Override // android.support.p011v7.app.AppCompatActivity, android.support.p008v4.app.FragmentActivity, android.support.p008v4.app.ComponentActivity, android.app.Activity
    @SuppressLint({"NewApi"})
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.crop_image_activity);
        this.f8190a = (CropImageView) findViewById(R.id.cropImageView);
        Bundle bundleExtra = getIntent().getBundleExtra("CROP_IMAGE_EXTRA_BUNDLE");
        this.f8191b = (Uri) bundleExtra.getParcelable("CROP_IMAGE_EXTRA_SOURCE");
        this.f8192c = (CropImageOptions) bundleExtra.getParcelable("CROP_IMAGE_EXTRA_OPTIONS");
        if (bundle == null) {
            Uri uri = this.f8191b;
            if (uri == null || uri.equals(Uri.EMPTY)) {
                if (CropImage.m4737b(this)) {
                    requestPermissions(new String[]{"android.permission.CAMERA"}, 2011);
                } else {
                    CropImage.m4746a((Activity) this);
                }
            } else if (CropImage.m4742a(this, this.f8191b)) {
                requestPermissions(new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 201);
            } else {
                this.f8190a.setImageUriAsync(this.f8191b);
            }
        }
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            CropImageOptions cropImageOptions = this.f8192c;
            supportActionBar.setTitle((cropImageOptions == null || cropImageOptions.f8196D == null || this.f8192c.f8196D.length() <= 0) ? getResources().getString(R.string.crop_image_activity_title) : this.f8192c.f8196D);
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.p011v7.app.AppCompatActivity, android.support.p008v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.f8190a.setOnSetImageUriCompleteListener(this);
        this.f8190a.setOnCropImageCompleteListener(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.p011v7.app.AppCompatActivity, android.support.p008v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.f8190a.setOnSetImageUriCompleteListener(null);
        this.f8190a.setOnCropImageCompleteListener(null);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.crop_image_menu, menu);
        if (!this.f8192c.f8207O) {
            menu.removeItem(R.id.crop_image_menu_rotate_left);
            menu.removeItem(R.id.crop_image_menu_rotate_right);
        } else if (this.f8192c.f8209Q) {
            menu.findItem(R.id.crop_image_menu_rotate_left).setVisible(true);
        }
        if (!this.f8192c.f8208P) {
            menu.removeItem(R.id.crop_image_menu_flip);
        }
        if (this.f8192c.f8213U != null) {
            menu.findItem(R.id.crop_image_menu_crop).setTitle(this.f8192c.f8213U);
        }
        Drawable drawable = null;
        try {
            if (this.f8192c.f8214V != 0) {
                drawable = ContextCompat.getDrawable(this, this.f8192c.f8214V);
                menu.findItem(R.id.crop_image_menu_crop).setIcon(drawable);
            }
        } catch (Exception e) {
            Log.w("AIC", "Failed to read menu crop drawable", e);
        }
        if (this.f8192c.f8197E != 0) {
            m4723a(menu, R.id.crop_image_menu_rotate_left, this.f8192c.f8197E);
            m4723a(menu, R.id.crop_image_menu_rotate_right, this.f8192c.f8197E);
            m4723a(menu, R.id.crop_image_menu_flip, this.f8192c.f8197E);
            if (drawable != null) {
                m4723a(menu, R.id.crop_image_menu_crop, this.f8192c.f8197E);
            }
        }
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.crop_image_menu_crop) {
            m4726a();
            return true;
        } else if (menuItem.getItemId() == R.id.crop_image_menu_rotate_left) {
            m4725a(-this.f8192c.f8210R);
            return true;
        } else if (menuItem.getItemId() == R.id.crop_image_menu_rotate_right) {
            m4725a(this.f8192c.f8210R);
            return true;
        } else if (menuItem.getItemId() == R.id.crop_image_menu_flip_horizontally) {
            this.f8190a.m4716a();
            return true;
        } else if (menuItem.getItemId() == R.id.crop_image_menu_flip_vertically) {
            this.f8190a.m4702b();
            return true;
        } else if (menuItem.getItemId() == 16908332) {
            m4720c();
            return true;
        } else {
            return super.onOptionsItemSelected(menuItem);
        }
    }

    @Override // android.support.p008v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        m4720c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.p008v4.app.FragmentActivity, android.app.Activity
    @SuppressLint({"NewApi"})
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 200) {
            if (i2 == 0) {
                m4720c();
            }
            if (i2 == -1) {
                this.f8191b = CropImage.m4744a(this, intent);
                if (CropImage.m4742a(this, this.f8191b)) {
                    requestPermissions(new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 201);
                } else {
                    this.f8190a.setImageUriAsync(this.f8191b);
                }
            }
        }
    }

    @Override // android.support.p008v4.app.FragmentActivity, android.app.Activity, android.support.p008v4.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (i == 201) {
            Uri uri = this.f8191b;
            if (uri != null && iArr.length > 0 && iArr[0] == 0) {
                this.f8190a.setImageUriAsync(uri);
            } else {
                Toast.makeText(this, R.string.crop_image_activity_no_permissions, 1).show();
                m4720c();
            }
        }
        if (i == 2011) {
            CropImage.m4746a((Activity) this);
        }
    }

    @Override // com.theartofdev.edmodo.cropper.CropImageView.InterfaceC2620f
    /* renamed from: a */
    public void mo4683a(CropImageView cropImageView, Uri uri, Exception exc) {
        if (exc == null) {
            if (this.f8192c.f8205M != null) {
                this.f8190a.setCropRect(this.f8192c.f8205M);
            }
            if (this.f8192c.f8206N > -1) {
                this.f8190a.setRotatedDegrees(this.f8192c.f8206N);
                return;
            }
            return;
        }
        m4724a((Uri) null, exc, 1);
    }

    @Override // com.theartofdev.edmodo.cropper.CropImageView.InterfaceC2616b
    /* renamed from: a */
    public void mo4687a(CropImageView cropImageView, CropImageView.C2615a c2615a) {
        m4724a(c2615a.m4694b(), c2615a.m4693c(), c2615a.m4688h());
    }

    /* renamed from: a */
    protected void m4726a() {
        if (this.f8192c.f8204L) {
            m4724a((Uri) null, (Exception) null, 1);
            return;
        }
        this.f8190a.m4709a(m4722b(), this.f8192c.f8199G, this.f8192c.f8200H, this.f8192c.f8201I, this.f8192c.f8202J, this.f8192c.f8203K);
    }

    /* renamed from: a */
    protected void m4725a(int i) {
        this.f8190a.m4714a(i);
    }

    /* renamed from: b */
    protected Uri m4722b() {
        Uri uri = this.f8192c.f8198F;
        if (uri == null || uri.equals(Uri.EMPTY)) {
            try {
                return Uri.fromFile(File.createTempFile("cropped", this.f8192c.f8199G == Bitmap.CompressFormat.JPEG ? ".jpg" : this.f8192c.f8199G == Bitmap.CompressFormat.PNG ? ".png" : ".webp", getCacheDir()));
            } catch (IOException e) {
                throw new RuntimeException("Failed to create temp file for output image", e);
            }
        }
        return uri;
    }

    /* renamed from: a */
    protected void m4724a(Uri uri, Exception exc, int i) {
        setResult(exc == null ? -1 : 204, m4721b(uri, exc, i));
        finish();
    }

    /* renamed from: c */
    protected void m4720c() {
        setResult(0);
        finish();
    }

    /* renamed from: b */
    protected Intent m4721b(Uri uri, Exception exc, int i) {
        CropImage.ActivityResult activityResult = new CropImage.ActivityResult(this.f8190a.getImageUri(), uri, exc, this.f8190a.getCropPoints(), this.f8190a.getCropRect(), this.f8190a.getRotatedDegrees(), this.f8190a.getWholeImageRect(), i);
        Intent intent = new Intent();
        intent.putExtras(getIntent());
        intent.putExtra("CROP_IMAGE_EXTRA_RESULT", activityResult);
        return intent;
    }

    /* renamed from: a */
    private void m4723a(Menu menu, int i, int i2) {
        Drawable icon;
        MenuItem findItem = menu.findItem(i);
        if (findItem == null || (icon = findItem.getIcon()) == null) {
            return;
        }
        try {
            icon.mutate();
            icon.setColorFilter(i2, PorterDuff.Mode.SRC_ATOP);
            findItem.setIcon(icon);
        } catch (Exception e) {
            Log.w("AIC", "Failed to update menu item color", e);
        }
    }
}
