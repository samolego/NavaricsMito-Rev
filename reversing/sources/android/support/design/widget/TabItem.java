package android.support.design.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.design.C0062R;
import android.support.p011v7.widget.TintTypedArray;
import android.util.AttributeSet;
import android.view.View;

/* loaded from: classes.dex */
public class TabItem extends View {
    public final int customLayout;
    public final Drawable icon;
    public final CharSequence text;

    public TabItem(Context context) {
        this(context, null);
    }

    public TabItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, C0062R.styleable.TabItem);
        this.text = obtainStyledAttributes.getText(C0062R.styleable.TabItem_android_text);
        this.icon = obtainStyledAttributes.getDrawable(C0062R.styleable.TabItem_android_icon);
        this.customLayout = obtainStyledAttributes.getResourceId(C0062R.styleable.TabItem_android_layout, 0);
        obtainStyledAttributes.recycle();
    }
}
