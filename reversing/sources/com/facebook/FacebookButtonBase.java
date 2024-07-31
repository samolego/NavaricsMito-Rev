package com.facebook;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.support.p008v4.app.Fragment;
import android.support.p008v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.common.R;
import com.facebook.internal.FragmentWrapper;

/* loaded from: classes.dex */
public abstract class FacebookButtonBase extends Button {

    /* renamed from: a */
    private String f1446a;

    /* renamed from: b */
    private String f1447b;

    /* renamed from: c */
    private View.OnClickListener f1448c;

    /* renamed from: d */
    private View.OnClickListener f1449d;

    /* renamed from: e */
    private boolean f1450e;

    /* renamed from: f */
    private int f1451f;

    /* renamed from: g */
    private int f1452g;

    /* renamed from: h */
    private FragmentWrapper f1453h;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int getDefaultRequestCode();

    protected int getDefaultStyleResource() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public FacebookButtonBase(Context context, AttributeSet attributeSet, int i, int i2, String str, String str2) {
        super(context, attributeSet, 0);
        i2 = i2 == 0 ? getDefaultStyleResource() : i2;
        mo9716a(context, attributeSet, i, i2 == 0 ? R.style.com_facebook_button : i2);
        this.f1446a = str;
        this.f1447b = str2;
        setClickable(true);
        setFocusable(true);
    }

    public void setFragment(Fragment fragment) {
        this.f1453h = new FragmentWrapper(fragment);
    }

    public void setFragment(android.app.Fragment fragment) {
        this.f1453h = new FragmentWrapper(fragment);
    }

    public Fragment getFragment() {
        FragmentWrapper fragmentWrapper = this.f1453h;
        if (fragmentWrapper != null) {
            return fragmentWrapper.m10646b();
        }
        return null;
    }

    public android.app.Fragment getNativeFragment() {
        FragmentWrapper fragmentWrapper = this.f1453h;
        if (fragmentWrapper != null) {
            return fragmentWrapper.m10648a();
        }
        return null;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f1448c = onClickListener;
    }

    public int getRequestCode() {
        return getDefaultRequestCode();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isInEditMode()) {
            return;
        }
        m11423a(getContext());
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        if ((getGravity() & 1) != 0) {
            int compoundPaddingLeft = getCompoundPaddingLeft();
            int compoundPaddingRight = getCompoundPaddingRight();
            int min = Math.min((((getWidth() - (getCompoundDrawablePadding() + compoundPaddingLeft)) - compoundPaddingRight) - m11419a(getText().toString())) / 2, (compoundPaddingLeft - getPaddingLeft()) / 2);
            this.f1451f = compoundPaddingLeft - min;
            this.f1452g = compoundPaddingRight + min;
            this.f1450e = true;
        }
        super.onDraw(canvas);
        this.f1450e = false;
    }

    @Override // android.widget.TextView
    public int getCompoundPaddingLeft() {
        return this.f1450e ? this.f1451f : super.getCompoundPaddingLeft();
    }

    @Override // android.widget.TextView
    public int getCompoundPaddingRight() {
        return this.f1450e ? this.f1452g : super.getCompoundPaddingRight();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Activity getActivity() {
        boolean z;
        Context context = getContext();
        while (true) {
            z = context instanceof Activity;
            if (z || !(context instanceof ContextWrapper)) {
                break;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        if (z) {
            return (Activity) context;
        }
        throw new FacebookException("Unable to get Activity.");
    }

    /* renamed from: a */
    protected int m11419a(String str) {
        return (int) Math.ceil(getPaint().measureText(str));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void mo9716a(Context context, AttributeSet attributeSet, int i, int i2) {
        m11417b(context, attributeSet, i, i2);
        m11415c(context, attributeSet, i, i2);
        m11414d(context, attributeSet, i, i2);
        m11413e(context, attributeSet, i, i2);
        m11424a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void m11422a(View view) {
        View.OnClickListener onClickListener = this.f1448c;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setInternalOnClickListener(View.OnClickListener onClickListener) {
        this.f1449d = onClickListener;
    }

    /* renamed from: a */
    private void m11423a(Context context) {
        new InternalAppEventsLogger(context).m11062a(this.f1446a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m11418b(Context context) {
        new InternalAppEventsLogger(context).m11062a(this.f1447b);
    }

    /* renamed from: b */
    private void m11417b(Context context, AttributeSet attributeSet, int i, int i2) {
        if (isInEditMode()) {
            return;
        }
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, new int[]{16842964}, i, i2);
        try {
            if (obtainStyledAttributes.hasValue(0)) {
                int resourceId = obtainStyledAttributes.getResourceId(0, 0);
                if (resourceId != 0) {
                    setBackgroundResource(resourceId);
                } else {
                    setBackgroundColor(obtainStyledAttributes.getColor(0, 0));
                }
            } else {
                setBackgroundColor(ContextCompat.getColor(context, R.color.com_facebook_blue));
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    @SuppressLint({"ResourceType"})
    /* renamed from: c */
    private void m11415c(Context context, AttributeSet attributeSet, int i, int i2) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, new int[]{16843119, 16843117, 16843120, 16843118, 16843121}, i, i2);
        try {
            setCompoundDrawablesWithIntrinsicBounds(obtainStyledAttributes.getResourceId(0, 0), obtainStyledAttributes.getResourceId(1, 0), obtainStyledAttributes.getResourceId(2, 0), obtainStyledAttributes.getResourceId(3, 0));
            setCompoundDrawablePadding(obtainStyledAttributes.getDimensionPixelSize(4, 0));
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    /* renamed from: d */
    private void m11414d(Context context, AttributeSet attributeSet, int i, int i2) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, new int[]{16842966, 16842967, 16842968, 16842969}, i, i2);
        try {
            setPadding(obtainStyledAttributes.getDimensionPixelSize(0, 0), obtainStyledAttributes.getDimensionPixelSize(1, 0), obtainStyledAttributes.getDimensionPixelSize(2, 0), obtainStyledAttributes.getDimensionPixelSize(3, 0));
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    /* renamed from: e */
    private void m11413e(Context context, AttributeSet attributeSet, int i, int i2) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, new int[]{16842904}, i, i2);
        try {
            setTextColor(obtainStyledAttributes.getColorStateList(0));
            obtainStyledAttributes.recycle();
            obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, new int[]{16842927}, i, i2);
            try {
                setGravity(obtainStyledAttributes.getInt(0, 17));
                obtainStyledAttributes.recycle();
                obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, new int[]{16842901, 16842903, 16843087}, i, i2);
                try {
                    setTextSize(0, obtainStyledAttributes.getDimensionPixelSize(0, 0));
                    setTypeface(Typeface.defaultFromStyle(obtainStyledAttributes.getInt(1, 1)));
                    setText(obtainStyledAttributes.getString(2));
                } finally {
                }
            } finally {
            }
        } finally {
        }
    }

    /* renamed from: a */
    private void m11424a() {
        super.setOnClickListener(new View.OnClickListener() { // from class: com.facebook.FacebookButtonBase.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FacebookButtonBase facebookButtonBase = FacebookButtonBase.this;
                facebookButtonBase.m11418b(facebookButtonBase.getContext());
                if (FacebookButtonBase.this.f1449d != null) {
                    FacebookButtonBase.this.f1449d.onClick(view);
                } else if (FacebookButtonBase.this.f1448c != null) {
                    FacebookButtonBase.this.f1448c.onClick(view);
                }
            }
        });
    }
}
