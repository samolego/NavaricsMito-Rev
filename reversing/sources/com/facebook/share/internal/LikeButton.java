package com.facebook.share.internal;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.p011v7.content.res.AppCompatResources;
import android.util.AttributeSet;
import com.facebook.FacebookButtonBase;
import com.facebook.common.R;

@Deprecated
/* loaded from: classes.dex */
public class LikeButton extends FacebookButtonBase {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.FacebookButtonBase
    public int getDefaultRequestCode() {
        return 0;
    }

    @Deprecated
    public LikeButton(Context context, boolean z) {
        super(context, null, 0, 0, "fb_like_button_create", "fb_like_button_did_tap");
        setSelected(z);
    }

    @Override // android.widget.TextView, android.view.View
    @Deprecated
    public void setSelected(boolean z) {
        super.setSelected(z);
        m10179a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.FacebookButtonBase
    /* renamed from: a */
    public void mo9716a(Context context, AttributeSet attributeSet, int i, int i2) {
        super.mo9716a(context, attributeSet, i, i2);
        m10179a();
    }

    @Override // com.facebook.FacebookButtonBase
    protected int getDefaultStyleResource() {
        return R.style.com_facebook_button_like;
    }

    /* renamed from: a */
    private void m10179a() {
        if (isSelected()) {
            setCompoundDrawablesWithIntrinsicBounds(R.drawable.com_facebook_button_like_icon_selected, 0, 0, 0);
            setText(getResources().getString(R.string.com_facebook_like_button_liked));
            return;
        }
        setCompoundDrawablesWithIntrinsicBounds(AppCompatResources.getDrawable(getContext(), R.drawable.com_facebook_button_icon), (Drawable) null, (Drawable) null, (Drawable) null);
        setText(getResources().getString(R.string.com_facebook_like_button_not_liked));
    }
}
