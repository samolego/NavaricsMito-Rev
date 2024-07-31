package com.theartofdev.edmodo.cropper;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.theartofdev.edmodo.cropper.CropImageView;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public final class CropImage {
    /* renamed from: a */
    public static void m4746a(@NonNull Activity activity) {
        activity.startActivityForResult(m4745a((Context) activity), 200);
    }

    /* renamed from: a */
    public static Intent m4745a(@NonNull Context context) {
        return m4741a(context, context.getString(R.string.pick_image_intent_chooser_title), false, true);
    }

    /* renamed from: a */
    public static Intent m4741a(@NonNull Context context, CharSequence charSequence, boolean z, boolean z2) {
        Intent intent;
        ArrayList arrayList = new ArrayList();
        PackageManager packageManager = context.getPackageManager();
        if (!m4737b(context) && z2) {
            arrayList.addAll(m4743a(context, packageManager));
        }
        List<Intent> m4738a = m4738a(packageManager, "android.intent.action.GET_CONTENT", z);
        if (m4738a.size() == 0) {
            m4738a = m4738a(packageManager, "android.intent.action.PICK", z);
        }
        arrayList.addAll(m4738a);
        if (arrayList.isEmpty()) {
            intent = new Intent();
        } else {
            intent = (Intent) arrayList.get(arrayList.size() - 1);
            arrayList.remove(arrayList.size() - 1);
        }
        Intent createChooser = Intent.createChooser(intent, charSequence);
        createChooser.putExtra("android.intent.extra.INITIAL_INTENTS", (Parcelable[]) arrayList.toArray(new Parcelable[arrayList.size()]));
        return createChooser;
    }

    /* renamed from: a */
    public static List<Intent> m4743a(@NonNull Context context, @NonNull PackageManager packageManager) {
        ArrayList arrayList = new ArrayList();
        Uri m4735c = m4735c(context);
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        for (ResolveInfo resolveInfo : packageManager.queryIntentActivities(intent, 0)) {
            Intent intent2 = new Intent(intent);
            intent2.setComponent(new ComponentName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name));
            intent2.setPackage(resolveInfo.activityInfo.packageName);
            if (m4735c != null) {
                intent2.putExtra("output", m4735c);
            }
            arrayList.add(intent2);
        }
        return arrayList;
    }

    /* renamed from: a */
    public static List<Intent> m4738a(@NonNull PackageManager packageManager, String str, boolean z) {
        ArrayList arrayList = new ArrayList();
        Intent intent = str == "android.intent.action.GET_CONTENT" ? new Intent(str) : new Intent(str, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/*");
        for (ResolveInfo resolveInfo : packageManager.queryIntentActivities(intent, 0)) {
            Intent intent2 = new Intent(intent);
            intent2.setComponent(new ComponentName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name));
            intent2.setPackage(resolveInfo.activityInfo.packageName);
            arrayList.add(intent2);
        }
        if (!z) {
            Iterator it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Intent intent3 = (Intent) it.next();
                if (intent3.getComponent().getClassName().equals("com.android.documentsui.DocumentsActivity")) {
                    arrayList.remove(intent3);
                    break;
                }
            }
        }
        return arrayList;
    }

    /* renamed from: b */
    public static boolean m4737b(@NonNull Context context) {
        return Build.VERSION.SDK_INT >= 23 && m4740a(context, "android.permission.CAMERA") && context.checkSelfPermission("android.permission.CAMERA") != 0;
    }

    /* renamed from: a */
    public static boolean m4740a(@NonNull Context context, @NonNull String str) {
        try {
            String[] strArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions;
            if (strArr != null && strArr.length > 0) {
                for (String str2 : strArr) {
                    if (str2.equalsIgnoreCase(str)) {
                        return true;
                    }
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    /* renamed from: c */
    public static Uri m4735c(@NonNull Context context) {
        File externalCacheDir = context.getExternalCacheDir();
        if (externalCacheDir != null) {
            return Uri.fromFile(new File(externalCacheDir.getPath(), "pickImageResult.jpeg"));
        }
        return null;
    }

    /* renamed from: a */
    public static Uri m4744a(@NonNull Context context, @Nullable Intent intent) {
        String action;
        boolean z = true;
        if (intent != null && intent.getData() != null && ((action = intent.getAction()) == null || !action.equals("android.media.action.IMAGE_CAPTURE"))) {
            z = false;
        }
        return (z || intent.getData() == null) ? m4735c(context) : intent.getData();
    }

    /* renamed from: a */
    public static boolean m4742a(@NonNull Context context, @NonNull Uri uri) {
        return Build.VERSION.SDK_INT >= 23 && context.checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") != 0 && m4736b(context, uri);
    }

    /* renamed from: b */
    public static boolean m4736b(@NonNull Context context, @NonNull Uri uri) {
        try {
            InputStream openInputStream = context.getContentResolver().openInputStream(uri);
            if (openInputStream != null) {
                openInputStream.close();
                return false;
            }
            return false;
        } catch (Exception unused) {
            return true;
        }
    }

    /* renamed from: a */
    public static C2612a m4747a() {
        return new C2612a(null);
    }

    /* renamed from: a */
    public static ActivityResult m4739a(@Nullable Intent intent) {
        if (intent != null) {
            return (ActivityResult) intent.getParcelableExtra("CROP_IMAGE_EXTRA_RESULT");
        }
        return null;
    }

    /* renamed from: com.theartofdev.edmodo.cropper.CropImage$a */
    /* loaded from: classes2.dex */
    public static final class C2612a {
        @Nullable

        /* renamed from: a */
        private final Uri f8188a;

        /* renamed from: b */
        private final CropImageOptions f8189b;

        private C2612a(@Nullable Uri uri) {
            this.f8188a = uri;
            this.f8189b = new CropImageOptions();
        }

        /* renamed from: a */
        public Intent m4730a(@NonNull Context context) {
            return m4729a(context, CropImageActivity.class);
        }

        /* renamed from: a */
        public Intent m4729a(@NonNull Context context, @Nullable Class<?> cls) {
            this.f8189b.m4719a();
            Intent intent = new Intent();
            intent.setClass(context, cls);
            Bundle bundle = new Bundle();
            bundle.putParcelable("CROP_IMAGE_EXTRA_SOURCE", this.f8188a);
            bundle.putParcelable("CROP_IMAGE_EXTRA_OPTIONS", this.f8189b);
            intent.putExtra("CROP_IMAGE_EXTRA_BUNDLE", bundle);
            return intent;
        }

        /* renamed from: a */
        public void m4731a(@NonNull Activity activity) {
            this.f8189b.m4719a();
            activity.startActivityForResult(m4730a((Context) activity), 203);
        }

        /* renamed from: a */
        public C2612a m4728a(@NonNull CropImageView.Guidelines guidelines) {
            this.f8189b.f8218d = guidelines;
            return this;
        }

        /* renamed from: a */
        public C2612a m4727a(boolean z) {
            this.f8189b.f8226l = z;
            return this;
        }

        /* renamed from: a */
        public C2612a m4732a(int i, int i2) {
            CropImageOptions cropImageOptions = this.f8189b;
            cropImageOptions.f8227m = i;
            cropImageOptions.f8228n = i2;
            cropImageOptions.f8226l = true;
            return this;
        }
    }

    /* loaded from: classes2.dex */
    public static final class ActivityResult extends CropImageView.C2615a implements Parcelable {
        public static final Parcelable.Creator<ActivityResult> CREATOR = new Parcelable.Creator<ActivityResult>() { // from class: com.theartofdev.edmodo.cropper.CropImage.ActivityResult.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public ActivityResult createFromParcel(Parcel parcel) {
                return new ActivityResult(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public ActivityResult[] newArray(int i) {
                return new ActivityResult[i];
            }
        };

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public ActivityResult(Uri uri, Uri uri2, Exception exc, float[] fArr, Rect rect, int i, Rect rect2, int i2) {
            super(null, uri, null, uri2, exc, fArr, rect, rect2, i, i2);
        }

        protected ActivityResult(Parcel parcel) {
            super(null, (Uri) parcel.readParcelable(Uri.class.getClassLoader()), null, (Uri) parcel.readParcelable(Uri.class.getClassLoader()), (Exception) parcel.readSerializable(), parcel.createFloatArray(), (Rect) parcel.readParcelable(Rect.class.getClassLoader()), (Rect) parcel.readParcelable(Rect.class.getClassLoader()), parcel.readInt(), parcel.readInt());
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(m4695a(), i);
            parcel.writeParcelable(m4694b(), i);
            parcel.writeSerializable(m4693c());
            parcel.writeFloatArray(m4692d());
            parcel.writeParcelable(m4691e(), i);
            parcel.writeParcelable(m4690f(), i);
            parcel.writeInt(m4689g());
            parcel.writeInt(m4688h());
        }
    }
}
