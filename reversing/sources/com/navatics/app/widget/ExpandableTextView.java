package com.navatics.app.widget;

import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleableRes;
import android.support.p011v7.content.res.AppCompatResources;
import android.util.AttributeSet;
import android.util.SparseBooleanArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.navatics.app.R;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;

/* loaded from: classes.dex */
public class ExpandableTextView extends LinearLayout implements View.OnClickListener {

    /* renamed from: a */
    protected TextView f5251a;

    /* renamed from: b */
    protected TextView f5252b;

    /* renamed from: c */
    protected LinearLayout f5253c;

    /* renamed from: d */
    private boolean f5254d;

    /* renamed from: e */
    private boolean f5255e;

    /* renamed from: f */
    private boolean f5256f;

    /* renamed from: g */
    private int f5257g;

    /* renamed from: h */
    private int f5258h;

    /* renamed from: i */
    private int f5259i;

    /* renamed from: j */
    private int f5260j;

    /* renamed from: k */
    private Drawable f5261k;

    /* renamed from: l */
    private Drawable f5262l;

    /* renamed from: m */
    private int f5263m;

    /* renamed from: n */
    private float f5264n;

    /* renamed from: o */
    private boolean f5265o;

    /* renamed from: p */
    private ObjectAnimator f5266p;

    /* renamed from: q */
    private ObjectAnimator f5267q;

    /* renamed from: r */
    private InterfaceC1929b f5268r;

    /* renamed from: s */
    private SparseBooleanArray f5269s;

    /* renamed from: t */
    private int f5270t;

    /* renamed from: com.navatics.app.widget.ExpandableTextView$b */
    /* loaded from: classes.dex */
    public interface InterfaceC1929b {
        /* renamed from: a */
        void m7252a(TextView textView, boolean z);
    }

    public ExpandableTextView(Context context) {
        super(context);
        this.f5255e = false;
        this.f5256f = true;
        m7266a((AttributeSet) null);
    }

    public ExpandableTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5255e = false;
        this.f5256f = true;
        m7266a(attributeSet);
    }

    @TargetApi(11)
    public ExpandableTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5255e = false;
        this.f5256f = true;
        m7266a(attributeSet);
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int i) {
        super.setOrientation(i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        C1928a c1928a;
        if (this.f5252b.getVisibility() == 0 && this.f5251a.getLineCount() > this.f5259i) {
            this.f5256f = !this.f5256f;
            if (this.f5256f) {
                this.f5267q.start();
            } else {
                this.f5266p.start();
            }
            SparseBooleanArray sparseBooleanArray = this.f5269s;
            if (sparseBooleanArray != null) {
                sparseBooleanArray.put(this.f5270t, this.f5256f);
            }
            this.f5265o = true;
            if (this.f5256f) {
                c1928a = new C1928a(this, getHeight(), this.f5257g);
            } else {
                c1928a = new C1928a(this, getHeight(), (getHeight() + this.f5258h) - this.f5251a.getHeight());
            }
            c1928a.setFillAfter(true);
            c1928a.setAnimationListener(new Animation.AnimationListener() { // from class: com.navatics.app.widget.ExpandableTextView.1
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    ExpandableTextView.m7257b(ExpandableTextView.this.f5251a, ExpandableTextView.this.f5264n);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    ExpandableTextView.this.clearAnimation();
                    ExpandableTextView.this.f5265o = false;
                    if (ExpandableTextView.this.f5268r != null) {
                        ExpandableTextView.this.f5268r.m7252a(ExpandableTextView.this.f5251a, !ExpandableTextView.this.f5256f);
                    }
                }
            });
            clearAnimation();
            startAnimation(c1928a);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f5265o;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        if (!this.f5254d || getVisibility() == 8) {
            super.onMeasure(i, i2);
            return;
        }
        this.f5254d = false;
        this.f5251a.setMaxLines(Integer.MAX_VALUE);
        super.onMeasure(i, i2);
        if (this.f5251a.getLineCount() <= this.f5259i) {
            return;
        }
        this.f5258h = m7264a(this.f5251a);
        if (this.f5256f) {
            this.f5251a.setMaxLines(this.f5259i);
        }
        super.onMeasure(i, i2);
        if (this.f5256f) {
            this.f5251a.post(new Runnable() { // from class: com.navatics.app.widget.ExpandableTextView.2
                @Override // java.lang.Runnable
                public void run() {
                    ExpandableTextView expandableTextView = ExpandableTextView.this;
                    expandableTextView.f5260j = expandableTextView.getHeight() - ExpandableTextView.this.f5251a.getHeight();
                }
            });
            this.f5257g = getMeasuredHeight();
        }
    }

    public void setOnExpandStateChangeListener(@Nullable InterfaceC1929b interfaceC1929b) {
        this.f5268r = interfaceC1929b;
    }

    public void setText(@Nullable CharSequence charSequence) {
        if (this.f5255e) {
            return;
        }
        this.f5255e = true;
        this.f5254d = true;
        this.f5251a.setText(charSequence);
    }

    @Nullable
    public CharSequence getText() {
        TextView textView = this.f5251a;
        return textView == null ? "" : textView.getText();
    }

    /* renamed from: a */
    private void m7266a(AttributeSet attributeSet) {
        m7258b(attributeSet);
        setOrientation(1);
    }

    /* renamed from: b */
    private void m7258b(AttributeSet attributeSet) {
        if (isInEditMode()) {
            return;
        }
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ExpandableTextView);
        this.f5259i = obtainStyledAttributes.getInt(4, 8);
        this.f5263m = obtainStyledAttributes.getInt(1, IjkMediaCodecInfo.RANK_SECURE);
        this.f5264n = obtainStyledAttributes.getFloat(0, 0.7f);
        this.f5261k = m7267a(getContext(), obtainStyledAttributes, 3);
        this.f5262l = m7267a(getContext(), obtainStyledAttributes, 2);
        if (this.f5261k == null) {
            this.f5261k = m7268a(getContext(), (int) R.drawable.indicator_black);
        }
        if (this.f5262l == null) {
            this.f5262l = m7268a(getContext(), (int) R.drawable.iso_normal);
        }
        obtainStyledAttributes.recycle();
    }

    /* renamed from: a */
    public void m7263a(TextView textView, TextView textView2, LinearLayout linearLayout) {
        this.f5251a = textView;
        this.f5251a.setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.widget.-$$Lambda$V_CQlpr3gZ3RRy8fdSgcJUtYu-4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ExpandableTextView.this.onClick(view);
            }
        });
        this.f5252b = textView2;
        this.f5252b.setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.widget.-$$Lambda$V_CQlpr3gZ3RRy8fdSgcJUtYu-4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ExpandableTextView.this.onClick(view);
            }
        });
        this.f5253c = linearLayout;
        this.f5253c.setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.widget.-$$Lambda$V_CQlpr3gZ3RRy8fdSgcJUtYu-4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ExpandableTextView.this.onClick(view);
            }
        });
        this.f5266p = ObjectAnimator.ofFloat(textView2, "rotation", 0.0f, 90.0f);
        this.f5266p.setDuration(this.f5263m);
        this.f5267q = ObjectAnimator.ofFloat(textView2, "rotation", 90.0f, 0.0f);
        this.f5267q.setDuration(this.f5263m);
    }

    public boolean getmRelayout() {
        return this.f5254d;
    }

    /* renamed from: a */
    private static boolean m7269a() {
        return Build.VERSION.SDK_INT >= 11;
    }

    /* renamed from: b */
    private static boolean m7259b() {
        return Build.VERSION.SDK_INT >= 21;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(11)
    /* renamed from: b */
    public static void m7257b(View view, float f) {
        if (m7269a()) {
            view.setAlpha(f);
            return;
        }
        AlphaAnimation alphaAnimation = new AlphaAnimation(f, f);
        alphaAnimation.setDuration(0L);
        alphaAnimation.setFillAfter(true);
        view.startAnimation(alphaAnimation);
    }

    @TargetApi(21)
    /* renamed from: a */
    private static Drawable m7268a(@NonNull Context context, @DrawableRes int i) {
        Resources resources = context.getResources();
        if (m7259b()) {
            return resources.getDrawable(i, context.getTheme());
        }
        return resources.getDrawable(i);
    }

    /* renamed from: a */
    private static int m7264a(@NonNull TextView textView) {
        return textView.getLayout().getLineTop(textView.getLineCount()) + textView.getCompoundPaddingTop() + textView.getCompoundPaddingBottom();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.navatics.app.widget.ExpandableTextView$a */
    /* loaded from: classes.dex */
    public class C1928a extends Animation {

        /* renamed from: b */
        private final View f5274b;

        /* renamed from: c */
        private final int f5275c;

        /* renamed from: d */
        private final int f5276d;

        @Override // android.view.animation.Animation
        public boolean willChangeBounds() {
            return true;
        }

        public C1928a(View view, int i, int i2) {
            this.f5274b = view;
            this.f5275c = i;
            this.f5276d = i2;
            setDuration(ExpandableTextView.this.f5263m);
        }

        @Override // android.view.animation.Animation
        protected void applyTransformation(float f, Transformation transformation) {
            int i = this.f5276d;
            int i2 = this.f5275c;
            int i3 = (int) (((i - i2) * f) + i2);
            ExpandableTextView.this.f5251a.setMaxHeight(i3 - ExpandableTextView.this.f5260j);
            if (Float.compare(ExpandableTextView.this.f5264n, 1.0f) != 0) {
                ExpandableTextView.m7257b(ExpandableTextView.this.f5251a, ExpandableTextView.this.f5264n + (f * (1.0f - ExpandableTextView.this.f5264n)));
            }
            this.f5274b.getLayoutParams().height = i3;
            this.f5274b.requestLayout();
        }

        @Override // android.view.animation.Animation
        public void initialize(int i, int i2, int i3, int i4) {
            super.initialize(i, i2, i3, i4);
        }
    }

    /* renamed from: a */
    public static Drawable m7267a(Context context, TypedArray typedArray, @StyleableRes int i) {
        if (Build.VERSION.SDK_INT >= 21) {
            return typedArray.getDrawable(i);
        }
        int resourceId = typedArray.getResourceId(i, -1);
        if (resourceId != -1) {
            return AppCompatResources.getDrawable(context, resourceId);
        }
        return null;
    }
}
