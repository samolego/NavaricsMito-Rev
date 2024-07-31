package com.navatics.app.activities;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.media.ExifInterface;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.p008v4.app.FragmentActivity;
import android.support.p008v4.view.ViewCompat;
import android.support.p011v7.widget.LinearLayoutManager;
import android.support.p011v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import cn.pedant.SweetAlert.SweetAlertDialog;
import com.bumptech.glide.Glide;
import com.navatics.app.NvBaseActivity;
import com.navatics.app.R;
import com.navatics.app.adapters.FilterListAdapter;
import com.navatics.app.framework.Settings;
import com.navatics.app.framework.p051c.OpenGLFilter;
import com.navatics.app.utils.ImageUtils;
import com.navatics.app.utils.StringUtils;
import com.navatics.p057cv.GLES3JNIView;
import com.navatics.p057cv.NavaticsFilter;
import com.navatics.robot.utils.DpiUtils;
import io.reactivex.Observable;
import io.reactivex.p093a.p095b.AndroidSchedulers;
import io.reactivex.p096b.Consumer;
import io.reactivex.p096b.Function;
import io.reactivex.p099e.Schedulers;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.apache.log4j.C3044k;
import org.opencv.android.Utils;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

/* loaded from: classes.dex */
public class PhotoEditor extends NvBaseActivity {

    /* renamed from: a */
    private static final C3044k f3655a = C3044k.m1564a(PhotoEditor.class);

    /* renamed from: b */
    private String f3656b;

    /* renamed from: c */
    private FilterListAdapter f3657c;

    /* renamed from: d */
    private AnimatorSet f3658d;

    /* renamed from: e */
    private ViewMode f3659e = ViewMode.NORMAL;

    /* renamed from: f */
    private BottomBarMode f3660f = BottomBarMode.EDIT;

    /* renamed from: g */
    private Bitmap f3661g;
    @BindView
    GLES3JNIView glImageContent;

    /* renamed from: h */
    private Bitmap f3662h;

    /* renamed from: i */
    private Mat f3663i;
    @BindView
    ImageView ivBack_Editor;
    @BindView
    ImageView ivFilter_Editor;
    @BindView
    ImageView ivImageContent;
    @BindView
    ImageView ivOff_Filter;
    @BindView
    ImageView ivRotate_Editor;
    @BindView
    ImageView ivSave_Editor;
    @BindView
    ImageView ivSave_Filter;

    /* renamed from: j */
    private Bitmap f3664j;

    /* renamed from: k */
    private Mat f3665k;

    /* renamed from: l */
    private boolean f3666l;

    /* renamed from: m */
    private boolean f3667m;
    @BindView
    RecyclerView mFilterList;
    @BindView
    ViewGroup mPhotoViewBackground;
    @BindView
    ViewGroup mPhotoViewFilterBar;
    @BindView
    ViewGroup mPhotoViewerEditorBar;

    /* renamed from: n */
    private SweetAlertDialog f3668n;

    /* loaded from: classes.dex */
    public enum BottomBarMode {
        EDIT,
        FILTER
    }

    /* loaded from: classes.dex */
    public enum ViewMode {
        NORMAL,
        CINEMA
    }

    /* renamed from: com.navatics.app.activities.PhotoEditor$a */
    /* loaded from: classes.dex */
    public interface InterfaceC1611a {
        /* renamed from: a */
        Mat mo9310a(Mat mat);

        /* renamed from: a */
        void mo9309a();

        /* renamed from: b */
        void mo9308b();
    }

    /* renamed from: lambda$0L-ucmLw_Im6PsiQxs_y75gusEo */
    public static /* synthetic */ void m12979lambda$0LucmLw_Im6PsiQxs_y75gusEo(PhotoEditor photoEditor, View view, int i) {
        photoEditor.m9347a(view, i);
    }

    /* renamed from: a */
    private boolean m9348a(Bundle bundle) {
        if (bundle == null) {
            return false;
        }
        String string = bundle.getString("key_path_of_photo");
        if (TextUtils.isEmpty(string)) {
            return false;
        }
        this.f3656b = string;
        return true;
    }

    @Override // com.navatics.app.NvBaseActivity, android.support.p011v7.app.AppCompatActivity, android.support.p008v4.app.FragmentActivity, android.support.p008v4.app.ComponentActivity, android.app.Activity
    @SuppressLint({"CheckResult"})
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(1024, 1024);
        if (!m9348a(getIntent().getExtras())) {
            finish();
            return;
        }
        setContentView(R.layout.photo_editor_activity);
        ButterKnife.m12805a(this);
        m9335b();
        Observable.m3088a(this.f3656b).m3075b(Schedulers.m3217b()).m3070c(new Function<String, C1613c>() { // from class: com.navatics.app.activities.PhotoEditor.8
            {
                PhotoEditor.this = this;
            }

            /* renamed from: b */
            private String m9311b(String str) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault());
                File file = new File(str);
                if (file.exists() && file.canRead()) {
                    return simpleDateFormat.format(new Date(file.lastModified()));
                }
                return null;
            }

            @Override // io.reactivex.p096b.Function
            /* renamed from: a */
            public C1613c apply(String str) throws Exception {
                C1613c c1613c = new C1613c();
                c1613c.f3690a = str;
                try {
                    Bitmap bitmap = Glide.m12521a((FragmentActivity) PhotoEditor.this).mo8810f().mo8825a(str).m12450a(Integer.MIN_VALUE, Integer.MIN_VALUE).get();
                    if (bitmap != null) {
                        c1613c.f3692c = bitmap;
                    }
                    if (str.endsWith(".jpg")) {
                        String attribute = new ExifInterface(str).getAttribute(android.support.media.ExifInterface.TAG_DATETIME);
                        if (!TextUtils.isEmpty(attribute)) {
                            attribute = m9311b(str);
                        }
                        c1613c.f3691b = attribute;
                    } else {
                        c1613c.f3691b = m9311b(str);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return c1613c;
            }
        }).m3091a(AndroidSchedulers.m3250a()).m3071c(new Consumer<C1613c>() { // from class: com.navatics.app.activities.PhotoEditor.1
            {
                PhotoEditor.this = this;
            }

            @Override // io.reactivex.p096b.Consumer
            /* renamed from: a */
            public void accept(C1613c c1613c) throws Exception {
                if (c1613c == null) {
                    return;
                }
                PhotoEditor.this.f3661g = c1613c.f3692c;
                if (PhotoEditor.this.f3661g != null) {
                    PhotoEditor.this.ivImageContent.setImageBitmap(PhotoEditor.this.f3661g);
                }
            }
        });
    }

    /* renamed from: b */
    private void m9335b() {
        this.ivImageContent.setOnClickListener(new View$OnClickListenerC1612b());
        ViewCompat.setElevation(this.mPhotoViewerEditorBar, 2.0f);
        this.ivBack_Editor.setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.activities.PhotoEditor.9
            {
                PhotoEditor.this = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PhotoEditor.this.m9331c();
            }
        });
        this.ivRotate_Editor.setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.activities.PhotoEditor.10
            {
                PhotoEditor.this = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PhotoEditor.this.m9323g();
            }
        });
        this.ivFilter_Editor.setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.activities.PhotoEditor.11
            {
                PhotoEditor.this = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PhotoEditor.this.f3660f = BottomBarMode.FILTER;
                PhotoEditor photoEditor = PhotoEditor.this;
                photoEditor.m9346a(photoEditor.mPhotoViewFilterBar, PhotoEditor.this.mPhotoViewerEditorBar, 200);
            }
        });
        this.ivSave_Editor.setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.activities.PhotoEditor.12
            {
                PhotoEditor.this = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PhotoEditor.this.m9325f();
            }
        });
        this.mFilterList.setLayoutManager(new LinearLayoutManager(this, 0, false));
        this.mFilterList.addItemDecoration(new C1615e(this, 35));
        this.f3657c = new FilterListAdapter(this);
        this.f3657c.setOnItemClickedListener(new FilterListAdapter.InterfaceC1706b() { // from class: com.navatics.app.activities.-$$Lambda$PhotoEditor$0L-ucmLw_Im6PsiQxs_y75gusEo
            @Override // com.navatics.app.adapters.FilterListAdapter.InterfaceC1706b
            public final void onItemClicked(View view, int i) {
                PhotoEditor.m12979lambda$0LucmLw_Im6PsiQxs_y75gusEo(PhotoEditor.this, view, i);
            }
        });
        this.mFilterList.setAdapter(this.f3657c);
        this.ivOff_Filter.setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.activities.PhotoEditor.14
            {
                PhotoEditor.this = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PhotoEditor.this.m9327e();
            }
        });
        this.ivSave_Filter.setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.activities.PhotoEditor.15
            {
                PhotoEditor.this = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PhotoEditor.this.m9325f();
            }
        });
    }

    /* renamed from: a */
    public /* synthetic */ void m9347a(View view, int i) {
        if (this.f3659e == ViewMode.CINEMA) {
            return;
        }
        final NavaticsFilter m8840a = this.f3657c.m8840a(i);
        m9345a(new AbstractC1614d() { // from class: com.navatics.app.activities.PhotoEditor.13
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
                PhotoEditor.this = this;
            }

            @Override // com.navatics.app.activities.PhotoEditor.AbstractC1614d, com.navatics.app.activities.PhotoEditor.InterfaceC1611a
            /* renamed from: a */
            public void mo9309a() {
                NavaticsFilter navaticsFilter = m8840a;
                if (navaticsFilter instanceof OpenGLFilter) {
                    ((OpenGLFilter) navaticsFilter).m8555a(PhotoEditor.this.glImageContent);
                    PhotoEditor.this.glImageContent.setVisibility(0);
                }
            }

            @Override // com.navatics.app.activities.PhotoEditor.InterfaceC1611a
            /* renamed from: a */
            public Mat mo9310a(Mat mat) {
                return m8840a.process(mat);
            }
        });
    }

    @Override // android.support.p011v7.app.AppCompatActivity, android.support.p008v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Bitmap bitmap;
        Bitmap bitmap2;
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 2) {
            getWindow().setFlags(1024, 1024);
        }
        m9335b();
        C3044k c3044k = f3655a;
        c3044k.mo1511a((Object) ("mBottomBarMode = " + this.f3660f + ", mViewMode = " + this.f3659e));
        switch (this.f3660f) {
            case EDIT:
                this.mPhotoViewerEditorBar.setVisibility(0);
                this.mPhotoViewFilterBar.setVisibility(4);
                break;
            case FILTER:
                this.mPhotoViewerEditorBar.setVisibility(4);
                this.mPhotoViewFilterBar.setVisibility(0);
                break;
            default:
                C3044k c3044k2 = f3655a;
                c3044k2.mo1504b((Object) ("unknown BottomBarMode : " + this.f3660f));
                break;
        }
        if (this.f3666l && (((bitmap = this.f3664j) != null && !bitmap.isRecycled()) || ((bitmap2 = this.f3662h) != null && !bitmap2.isRecycled()))) {
            this.ivSave_Editor.setImageResource(R.drawable.save_ok);
            this.ivSave_Filter.setImageResource(R.drawable.save_ok);
        }
        if (this.f3659e == ViewMode.CINEMA) {
            this.mPhotoViewBackground.setBackgroundColor(getResources().getColor(R.color.black));
            this.mPhotoViewerEditorBar.setAlpha(0.0f);
            this.mPhotoViewFilterBar.setAlpha(0.0f);
            m9336a(false);
        } else {
            this.mPhotoViewBackground.setBackgroundColor(getResources().getColor(R.color.lightGray));
            this.mPhotoViewerEditorBar.setAlpha(1.0f);
            this.mPhotoViewFilterBar.setAlpha(1.0f);
            m9336a(true);
        }
        Bitmap bitmap3 = this.f3664j;
        if (bitmap3 != null && !bitmap3.isRecycled()) {
            this.ivImageContent.setImageBitmap(this.f3664j);
            return;
        }
        Bitmap bitmap4 = this.f3662h;
        if (bitmap4 != null && !bitmap4.isRecycled()) {
            this.ivImageContent.setImageBitmap(this.f3662h);
            return;
        }
        Bitmap bitmap5 = this.f3661g;
        if (bitmap5 != null && !bitmap5.isRecycled()) {
            this.ivImageContent.setImageBitmap(this.f3661g);
        } else {
            f3655a.mo1503b("impossible", new Exception());
        }
    }

    @Override // android.support.p008v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        switch (this.f3660f) {
            case EDIT:
                m9331c();
                return;
            case FILTER:
                m9327e();
                return;
            default:
                C3044k c3044k = f3655a;
                c3044k.mo1504b((Object) ("onBackPressed, unknown BottomBarMode : " + this.f3660f));
                return;
        }
    }

    /* renamed from: a */
    private void m9336a(boolean z) {
        this.ivBack_Editor.setClickable(z);
        this.ivRotate_Editor.setClickable(z);
        this.ivFilter_Editor.setClickable(z);
        this.ivSave_Editor.setClickable(z);
        this.ivOff_Filter.setClickable(z);
        this.ivSave_Filter.setClickable(z);
    }

    /* renamed from: c */
    public void m9331c() {
        f3655a.mo1511a((Object) "ivBack_Editor onClick");
        Bitmap bitmap = this.f3662h;
        if (bitmap != null) {
            bitmap.recycle();
            this.f3662h = null;
        }
        Mat mat = this.f3663i;
        if (mat != null) {
            mat.m283g();
            this.f3663i = null;
        }
        m9329d();
    }

    /* renamed from: d */
    private void m9329d() {
        finish();
        overridePendingTransition(0, 0);
    }

    /* renamed from: e */
    public void m9327e() {
        Bitmap bitmap = this.f3664j;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.f3664j.recycle();
            this.f3664j = null;
        }
        Mat mat = this.f3665k;
        if (mat != null) {
            mat.m283g();
            this.f3665k = null;
        }
        Bitmap bitmap2 = this.f3662h;
        if (bitmap2 != null && !bitmap2.isRecycled()) {
            this.ivImageContent.setImageBitmap(this.f3662h);
        } else {
            Bitmap bitmap3 = this.f3661g;
            if (bitmap3 != null && !bitmap3.isRecycled()) {
                this.ivImageContent.setImageBitmap(this.f3661g);
            }
        }
        this.ivSave_Filter.setImageResource(R.drawable.save_not_ok);
        this.f3660f = BottomBarMode.EDIT;
        m9346a(this.mPhotoViewerEditorBar, this.mPhotoViewFilterBar, 200);
    }

    /* renamed from: a */
    public void m9346a(final View view, View view2, int i) {
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationY", view.getHeight(), 0.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view2, "translationY", 0.0f, view2.getHeight());
        long j = i;
        ofFloat.setDuration(j);
        ofFloat2.setDuration(j);
        ofFloat2.addListener(new Animator.AnimatorListener() { // from class: com.navatics.app.activities.PhotoEditor.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            {
                PhotoEditor.this = this;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                view.setVisibility(0);
            }
        });
        animatorSet.play(ofFloat).after(ofFloat2);
        animatorSet.start();
    }

    /* renamed from: a */
    private void m9349a(Bitmap bitmap) {
        String m8606f = Settings.m8618a().m8606f();
        String m7392a = ImageUtils.m7392a(this, bitmap, m8606f, ImageUtils.m7390a(m8606f));
        if (!StringUtils.m7354a(m7392a)) {
            m9337a(m7392a, this);
            Toast.makeText(this, (int) R.string.save_success, 0).show();
            m9321h();
            return;
        }
        Toast.makeText(this, (int) R.string.save_error, 0).show();
    }

    /* renamed from: a */
    private void m9337a(String str, Context context) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("datetaken", Long.valueOf(System.currentTimeMillis()));
        contentValues.put("mime_type", "image/jpeg");
        contentValues.put("_data", str);
        context.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
    }

    /* renamed from: f */
    public void m9325f() {
        Bitmap bitmap;
        Bitmap bitmap2 = this.f3664j;
        if (bitmap2 != null && !bitmap2.isRecycled()) {
            bitmap = this.f3664j;
        } else {
            Bitmap bitmap3 = this.f3662h;
            bitmap = (bitmap3 == null || bitmap3.isRecycled()) ? null : this.f3662h;
        }
        if (bitmap == null) {
            return;
        }
        m9349a(bitmap);
    }

    /* renamed from: g */
    public void m9323g() {
        synchronized (this) {
            if (this.f3667m) {
                Toast.makeText(this, "Other task running...", 0).show();
                return;
            }
            this.f3667m = true;
            if (this.f3662h == null) {
                this.f3662h = this.f3661g.copy(Bitmap.Config.ARGB_8888, true);
            }
            if (this.f3663i == null) {
                this.f3663i = new Mat();
                Utils.m343a(this.f3662h, this.f3663i);
            }
            Mat mat = this.f3663i;
            ImageUtils.m7389a(mat, mat);
            Bitmap.Config config = this.f3662h.getConfig();
            if (this.f3662h.getHeight() != this.f3663i.m282h() || this.f3662h.getWidth() != this.f3663i.m288b() || (config != Bitmap.Config.ARGB_8888 && config != Bitmap.Config.RGB_565)) {
                this.f3662h.recycle();
                this.f3662h = Bitmap.createBitmap(this.f3663i.m288b(), this.f3663i.m282h(), Bitmap.Config.ARGB_8888);
            }
            Utils.m341a(this.f3663i, this.f3662h);
            this.f3666l = true;
            this.ivSave_Editor.setImageResource(R.drawable.save_ok);
            this.ivSave_Filter.setImageResource(R.drawable.save_ok);
            this.ivImageContent.setImageBitmap(this.f3662h);
            this.f3667m = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.navatics.app.activities.PhotoEditor$d */
    /* loaded from: classes.dex */
    public abstract class AbstractC1614d implements InterfaceC1611a {
        @Override // com.navatics.app.activities.PhotoEditor.InterfaceC1611a
        /* renamed from: a */
        public void mo9309a() {
        }

        AbstractC1614d() {
            PhotoEditor.this = r1;
        }

        @Override // com.navatics.app.activities.PhotoEditor.InterfaceC1611a
        /* renamed from: b */
        public void mo9308b() {
            PhotoEditor.this.f3666l = true;
            PhotoEditor.this.ivSave_Filter.setImageResource(R.drawable.save_ok);
            PhotoEditor.this.ivImageContent.setImageBitmap(PhotoEditor.this.f3664j);
            synchronized (this) {
                PhotoEditor.this.f3667m = false;
            }
            if (PhotoEditor.this.f3668n != null) {
                PhotoEditor.this.f3668n.cancel();
                PhotoEditor.this.f3668n = null;
            }
        }
    }

    /* renamed from: a */
    private void m9345a(InterfaceC1611a interfaceC1611a) {
        if (interfaceC1611a == null) {
            throw new IllegalArgumentException("asyncProcessFilter got null callback.");
        }
        synchronized (this) {
            if (this.f3667m) {
                Toast.makeText(this, "Other task running...", 0).show();
                return;
            }
            this.f3667m = true;
            Mat mat = this.f3663i;
            if (mat != null) {
                this.f3665k = mat.clone();
            } else {
                this.f3665k = new Mat();
                Bitmap bitmap = this.f3664j;
                if (bitmap != null && !bitmap.isRecycled()) {
                    Utils.m343a(this.f3664j, this.f3665k);
                } else {
                    Utils.m343a(this.f3661g, this.f3665k);
                }
            }
            Mat mat2 = this.f3665k;
            Imgproc.m266a(mat2, mat2, 3);
            this.f3668n = new SweetAlertDialog(this, 5);
            this.f3668n.m12664b().m12674a(Color.parseColor("#A5DC86"));
            this.f3668n.m12666a("Processing");
            this.f3668n.setCancelable(false);
            this.f3668n.show();
            Observable.m3088a(interfaceC1611a).m3075b(AndroidSchedulers.m3250a()).m3079b(new Consumer<InterfaceC1611a>() { // from class: com.navatics.app.activities.PhotoEditor.6
                {
                    PhotoEditor.this = this;
                }

                @Override // io.reactivex.p096b.Consumer
                /* renamed from: a */
                public void accept(InterfaceC1611a interfaceC1611a2) throws Exception {
                    C3044k c3044k = PhotoEditor.f3655a;
                    c3044k.mo1500c((Object) ("doOnNext Thread : " + Thread.currentThread().getName()));
                    interfaceC1611a2.mo9309a();
                }
            }).m3091a(Schedulers.m3218a()).m3079b(new Consumer<InterfaceC1611a>() { // from class: com.navatics.app.activities.PhotoEditor.5
                {
                    PhotoEditor.this = this;
                }

                @Override // io.reactivex.p096b.Consumer
                /* renamed from: a */
                public void accept(InterfaceC1611a interfaceC1611a2) throws Exception {
                    C3044k c3044k = PhotoEditor.f3655a;
                    c3044k.mo1500c((Object) ("Background Thread : " + Thread.currentThread().getName()));
                    long currentTimeMillis = System.currentTimeMillis();
                    Mat mo9310a = interfaceC1611a2.mo9310a(PhotoEditor.this.f3665k);
                    C3044k c3044k2 = PhotoEditor.f3655a;
                    c3044k2.mo1511a((Object) ("render end : " + (System.currentTimeMillis() - currentTimeMillis)));
                    if (mo9310a != null) {
                        PhotoEditor.f3655a.mo1511a((Object) "filter success.");
                        PhotoEditor.this.f3665k = mo9310a;
                        boolean z = true;
                        if (PhotoEditor.this.f3664j != null) {
                            Bitmap.Config config = PhotoEditor.this.f3664j.getConfig();
                            if (PhotoEditor.this.f3664j.getHeight() == PhotoEditor.this.f3665k.m282h() && PhotoEditor.this.f3664j.getWidth() == PhotoEditor.this.f3665k.m288b() && (config == Bitmap.Config.ARGB_8888 || config == Bitmap.Config.RGB_565)) {
                                z = false;
                            } else {
                                PhotoEditor.this.f3664j.recycle();
                            }
                        }
                        if (z) {
                            PhotoEditor photoEditor = PhotoEditor.this;
                            photoEditor.f3664j = Bitmap.createBitmap(photoEditor.f3665k.m288b(), PhotoEditor.this.f3665k.m282h(), Bitmap.Config.ARGB_8888);
                        }
                        Imgproc.m266a(PhotoEditor.this.f3665k, PhotoEditor.this.f3665k, 2);
                        Utils.m341a(PhotoEditor.this.f3665k, PhotoEditor.this.f3664j);
                        PhotoEditor.f3655a.mo1511a((Object) "Filter Done.");
                        return;
                    }
                    PhotoEditor.f3655a.mo1504b((Object) "NavaticsCV return null.");
                    throw new RuntimeException("NavaticsCV ccm1 return null");
                }
            }).m3091a(AndroidSchedulers.m3250a()).m3107a(new Consumer<InterfaceC1611a>() { // from class: com.navatics.app.activities.PhotoEditor.3
                {
                    PhotoEditor.this = this;
                }

                @Override // io.reactivex.p096b.Consumer
                /* renamed from: a */
                public void accept(InterfaceC1611a interfaceC1611a2) throws Exception {
                    interfaceC1611a2.mo9308b();
                }
            }, new Consumer<Throwable>() { // from class: com.navatics.app.activities.PhotoEditor.4
                {
                    PhotoEditor.this = this;
                }

                @Override // io.reactivex.p096b.Consumer
                /* renamed from: a */
                public void accept(Throwable th) throws Exception {
                    synchronized (PhotoEditor.this) {
                        PhotoEditor.this.f3667m = false;
                        if (PhotoEditor.this.f3668n != null) {
                            PhotoEditor.this.f3668n.cancel();
                            PhotoEditor.this.f3668n = null;
                        }
                    }
                    C3044k c3044k = PhotoEditor.f3655a;
                    c3044k.mo1503b("process iamge error : " + th.getMessage(), th);
                    Toast.makeText(PhotoEditor.this, (int) R.string.img_process_failed, 0).show();
                }
            });
        }
    }

    /* renamed from: h */
    private void m9321h() {
        this.f3666l = false;
        this.ivSave_Editor.setImageResource(R.drawable.save_not_ok);
        this.ivSave_Filter.setImageResource(R.drawable.save_not_ok);
    }

    /* renamed from: i */
    public void m9319i() {
        AnimatorSet animatorSet = this.f3658d;
        if (animatorSet != null && animatorSet.isRunning()) {
            this.f3658d.cancel();
        }
        switch (this.f3659e) {
            case NORMAL:
                int color = getResources().getColor(R.color.black);
                this.f3658d = new AnimatorSet();
                ObjectAnimator ofInt = ObjectAnimator.ofInt(this.mPhotoViewBackground, "backgroundColor", color);
                ofInt.setEvaluator(new ArgbEvaluator());
                this.f3658d.play(ofInt).with(ObjectAnimator.ofFloat(this.mPhotoViewerEditorBar, "alpha", 0.0f)).with(ObjectAnimator.ofFloat(this.mPhotoViewFilterBar, "alpha", 0.0f));
                this.f3658d.setDuration(500L);
                this.f3658d.start();
                m9336a(false);
                this.f3659e = ViewMode.CINEMA;
                return;
            case CINEMA:
                int i = ViewCompat.MEASURED_STATE_MASK;
                Drawable background = this.mPhotoViewBackground.getBackground();
                if (background instanceof ColorDrawable) {
                    i = ((ColorDrawable) background).getColor();
                }
                int color2 = getResources().getColor(R.color.lightGray);
                this.f3658d = new AnimatorSet();
                ObjectAnimator ofInt2 = ObjectAnimator.ofInt(this.mPhotoViewBackground, "backgroundColor", i, color2);
                ofInt2.setEvaluator(new ArgbEvaluator());
                this.f3658d.play(ofInt2).with(ObjectAnimator.ofFloat(this.mPhotoViewerEditorBar, "alpha", 1.0f)).with(ObjectAnimator.ofFloat(this.mPhotoViewFilterBar, "alpha", 1.0f));
                this.f3658d.setDuration(500L);
                this.f3658d.start();
                m9336a(true);
                this.f3659e = ViewMode.NORMAL;
                return;
            default:
                C3044k c3044k = f3655a;
                c3044k.mo1504b((Object) ("unknown ViewMode : " + this.f3659e));
                return;
        }
    }

    /* renamed from: com.navatics.app.activities.PhotoEditor$b */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC1612b implements View.OnClickListener {
        View$OnClickListenerC1612b() {
            PhotoEditor.this = r1;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PhotoEditor.this.m9319i();
        }
    }

    /* renamed from: com.navatics.app.activities.PhotoEditor$e */
    /* loaded from: classes.dex */
    public class C1615e extends RecyclerView.ItemDecoration {

        /* renamed from: b */
        private int f3696b;

        C1615e(Context context, int i) {
            PhotoEditor.this = r1;
            this.f3696b = DpiUtils.m5887a(context, i);
        }

        @Override // android.support.p011v7.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            if (recyclerView.getChildAdapterPosition(view) > 0) {
                rect.left = this.f3696b;
            }
        }
    }

    /* renamed from: com.navatics.app.activities.PhotoEditor$c */
    /* loaded from: classes.dex */
    public class C1613c {

        /* renamed from: a */
        String f3690a;

        /* renamed from: b */
        String f3691b;

        /* renamed from: c */
        Bitmap f3692c;

        C1613c() {
            PhotoEditor.this = r1;
        }
    }
}
