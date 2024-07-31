package com.p034dd.morphingbutton;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.StateSet;
import android.view.ViewGroup;
import android.widget.Button;
import com.p034dd.morphingbutton.MorphingAnimation;

/* renamed from: com.dd.morphingbutton.MorphingButton */
/* loaded from: classes.dex */
public class MorphingButton extends Button {

    /* renamed from: a */
    protected boolean f1317a;

    /* renamed from: b */
    private C0798a f1318b;

    /* renamed from: c */
    private int f1319c;

    /* renamed from: d */
    private int f1320d;

    /* renamed from: e */
    private int f1321e;

    /* renamed from: f */
    private int f1322f;

    /* renamed from: g */
    private int f1323g;

    /* renamed from: h */
    private int f1324h;

    /* renamed from: i */
    private StrokeGradientDrawable f1325i;

    /* renamed from: j */
    private StrokeGradientDrawable f1326j;

    public MorphingButton(Context context) {
        super(context);
        m11554a();
    }

    public MorphingButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m11554a();
    }

    public MorphingButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m11554a();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.f1319c != 0 || this.f1320d != 0 || i == 0 || i2 == 0) {
            return;
        }
        this.f1319c = getHeight();
        this.f1320d = getWidth();
    }

    public StrokeGradientDrawable getDrawableNormal() {
        return this.f1325i;
    }

    /* renamed from: a */
    public void mo11488a(@NonNull C0799b c0799b) {
        if (this.f1317a) {
            return;
        }
        this.f1326j.m11497c(c0799b.f1340e);
        this.f1326j.m11502a(c0799b.f1336a);
        this.f1326j.m11499b(c0799b.f1344i);
        this.f1326j.m11501a(c0799b.f1343h);
        if (c0799b.f1341f == 0) {
            m11550c(c0799b);
        } else {
            m11551b(c0799b);
        }
        this.f1321e = c0799b.f1339d;
        this.f1322f = c0799b.f1336a;
        this.f1323g = c0799b.f1343h;
        this.f1324h = c0799b.f1344i;
    }

    /* renamed from: b */
    private void m11551b(@NonNull final C0799b c0799b) {
        this.f1317a = true;
        setText((CharSequence) null);
        setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        setPadding(this.f1318b.f1331a, this.f1318b.f1333c, this.f1318b.f1332b, this.f1318b.f1334d);
        new MorphingAnimation(MorphingAnimation.C0807b.m11525a(this).m11526a(this.f1321e, c0799b.f1339d).m11522b(this.f1322f, c0799b.f1336a).m11516e(this.f1323g, c0799b.f1343h).m11514f(this.f1324h, c0799b.f1344i).m11520c(getHeight(), c0799b.f1338c).m11518d(getWidth(), c0799b.f1337b).m11527a(c0799b.f1341f).m11524a(new MorphingAnimation.InterfaceC0806a() { // from class: com.dd.morphingbutton.MorphingButton.1
            @Override // com.p034dd.morphingbutton.MorphingAnimation.InterfaceC0806a
            /* renamed from: a */
            public void mo11528a() {
                MorphingButton.this.m11549d(c0799b);
            }
        })).m11530a();
    }

    /* renamed from: c */
    private void m11550c(@NonNull C0799b c0799b) {
        this.f1325i.m11497c(c0799b.f1339d);
        this.f1325i.m11502a(c0799b.f1336a);
        this.f1325i.m11499b(c0799b.f1344i);
        this.f1325i.m11501a(c0799b.f1343h);
        if (c0799b.f1337b != 0 && c0799b.f1338c != 0) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            layoutParams.width = c0799b.f1337b;
            layoutParams.height = c0799b.f1338c;
            setLayoutParams(layoutParams);
        }
        m11549d(c0799b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m11549d(@NonNull C0799b c0799b) {
        this.f1317a = false;
        if (c0799b.f1342g == 0 || c0799b.f1345j == null) {
            if (c0799b.f1342g != 0) {
                setIcon(c0799b.f1342g);
            } else if (c0799b.f1345j != null) {
                setText(c0799b.f1345j);
            }
        } else {
            setIconLeft(c0799b.f1342g);
            setText(c0799b.f1345j);
        }
        if (c0799b.f1346k != null) {
            c0799b.f1346k.mo11528a();
        }
    }

    /* renamed from: a */
    private void m11554a() {
        this.f1318b = new C0798a();
        this.f1318b.f1331a = getPaddingLeft();
        this.f1318b.f1332b = getPaddingRight();
        this.f1318b.f1333c = getPaddingTop();
        this.f1318b.f1334d = getPaddingBottom();
        Resources resources = getResources();
        int dimension = (int) resources.getDimension(R.dimen.mb_corner_radius_2);
        int color = resources.getColor(R.color.mb_blue);
        int color2 = resources.getColor(R.color.mb_blue_dark);
        StateListDrawable stateListDrawable = new StateListDrawable();
        this.f1325i = m11553a(color, dimension, 0);
        this.f1326j = m11553a(color2, dimension, 0);
        this.f1321e = color;
        this.f1324h = color;
        this.f1322f = dimension;
        stateListDrawable.addState(new int[]{16842919}, this.f1326j.m11498c());
        stateListDrawable.addState(StateSet.WILD_CARD, this.f1325i.m11498c());
        setBackgroundCompat(stateListDrawable);
    }

    /* renamed from: a */
    private StrokeGradientDrawable m11553a(int i, int i2, int i3) {
        StrokeGradientDrawable strokeGradientDrawable = new StrokeGradientDrawable(new GradientDrawable());
        strokeGradientDrawable.m11498c().setShape(0);
        strokeGradientDrawable.m11497c(i);
        strokeGradientDrawable.m11502a(i2);
        strokeGradientDrawable.m11499b(i);
        strokeGradientDrawable.m11501a(i3);
        return strokeGradientDrawable;
    }

    private void setBackgroundCompat(@Nullable Drawable drawable) {
        if (Build.VERSION.SDK_INT <= 16) {
            setBackgroundDrawable(drawable);
        } else {
            setBackground(drawable);
        }
    }

    public void setIcon(@DrawableRes final int i) {
        post(new Runnable() { // from class: com.dd.morphingbutton.MorphingButton.2
            @Override // java.lang.Runnable
            public void run() {
                int width = (MorphingButton.this.getWidth() / 2) - (MorphingButton.this.getResources().getDrawable(i).getIntrinsicWidth() / 2);
                MorphingButton.this.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
                MorphingButton.this.setPadding(width, 0, 0, 0);
            }
        });
    }

    public void setIconLeft(@DrawableRes int i) {
        setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.dd.morphingbutton.MorphingButton$a */
    /* loaded from: classes.dex */
    public class C0798a {

        /* renamed from: a */
        public int f1331a;

        /* renamed from: b */
        public int f1332b;

        /* renamed from: c */
        public int f1333c;

        /* renamed from: d */
        public int f1334d;

        private C0798a() {
        }
    }

    /* renamed from: com.dd.morphingbutton.MorphingButton$b */
    /* loaded from: classes.dex */
    public static class C0799b {

        /* renamed from: a */
        private int f1336a;

        /* renamed from: b */
        private int f1337b;

        /* renamed from: c */
        private int f1338c;

        /* renamed from: d */
        private int f1339d;

        /* renamed from: e */
        private int f1340e;

        /* renamed from: f */
        private int f1341f;

        /* renamed from: g */
        private int f1342g;

        /* renamed from: h */
        private int f1343h;

        /* renamed from: i */
        private int f1344i;

        /* renamed from: j */
        private String f1345j;

        /* renamed from: k */
        private MorphingAnimation.InterfaceC0806a f1346k;

        private C0799b() {
        }

        /* renamed from: a */
        public static C0799b m11548a() {
            return new C0799b();
        }

        /* renamed from: a */
        public C0799b m11547a(int i) {
            this.f1336a = i;
            return this;
        }

        /* renamed from: b */
        public C0799b m11545b(int i) {
            this.f1337b = i;
            return this;
        }

        /* renamed from: c */
        public C0799b m11543c(int i) {
            this.f1338c = i;
            return this;
        }

        /* renamed from: d */
        public C0799b m11541d(int i) {
            this.f1339d = i;
            return this;
        }

        /* renamed from: e */
        public C0799b m11539e(int i) {
            this.f1340e = i;
            return this;
        }

        /* renamed from: f */
        public C0799b m11537f(int i) {
            this.f1341f = i;
            return this;
        }
    }
}
