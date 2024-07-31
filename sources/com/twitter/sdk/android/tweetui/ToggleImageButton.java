package com.twitter.sdk.android.tweetui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ImageButton;

/* loaded from: classes2.dex */
public class ToggleImageButton extends ImageButton {

    /* renamed from: e */
    private static final int[] f8901e = {R.attr.state_toggled_on};

    /* renamed from: a */
    boolean f8902a;

    /* renamed from: b */
    String f8903b;

    /* renamed from: c */
    String f8904c;

    /* renamed from: d */
    final boolean f8905d;

    public ToggleImageButton(Context context) {
        this(context, null);
    }

    public ToggleImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ToggleImageButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray typedArray = null;
        try {
            typedArray = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.ToggleImageButton, i, 0);
            String string = typedArray.getString(R.styleable.ToggleImageButton_contentDescriptionOn);
            String string2 = typedArray.getString(R.styleable.ToggleImageButton_contentDescriptionOff);
            this.f8903b = string == null ? (String) getContentDescription() : string;
            this.f8904c = string2 == null ? (String) getContentDescription() : string2;
            this.f8905d = typedArray.getBoolean(R.styleable.ToggleImageButton_toggleOnClick, true);
            setToggledOn(false);
        } finally {
            if (typedArray != null) {
                typedArray.recycle();
            }
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 2);
        if (this.f8902a) {
            mergeDrawableStates(onCreateDrawableState, f8901e);
        }
        return onCreateDrawableState;
    }

    @Override // android.view.View
    public boolean performClick() {
        if (this.f8905d) {
            m4147a();
        }
        return super.performClick();
    }

    public void setToggledOn(boolean z) {
        this.f8902a = z;
        setContentDescription(z ? this.f8903b : this.f8904c);
        refreshDrawableState();
    }

    /* renamed from: a */
    public void m4147a() {
        setToggledOn(!this.f8902a);
    }
}
