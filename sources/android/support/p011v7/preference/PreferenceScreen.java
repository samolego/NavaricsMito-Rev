package android.support.p011v7.preference;

import android.content.Context;
import android.support.annotation.RestrictTo;
import android.support.p008v4.content.res.TypedArrayUtils;
import android.support.p011v7.preference.PreferenceManager;
import android.util.AttributeSet;

/* renamed from: android.support.v7.preference.PreferenceScreen */
/* loaded from: classes.dex */
public final class PreferenceScreen extends PreferenceGroup {
    private boolean mShouldUseGeneratedIds;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.p011v7.preference.PreferenceGroup
    public boolean isOnSameScreenAsChildren() {
        return false;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public PreferenceScreen(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, TypedArrayUtils.getAttr(context, C0447R.attr.preferenceScreenStyle, 16842891));
        this.mShouldUseGeneratedIds = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.p011v7.preference.Preference
    public void onClick() {
        PreferenceManager.OnNavigateToScreenListener onNavigateToScreenListener;
        if (getIntent() != null || getFragment() != null || getPreferenceCount() == 0 || (onNavigateToScreenListener = getPreferenceManager().getOnNavigateToScreenListener()) == null) {
            return;
        }
        onNavigateToScreenListener.onNavigateToScreen(this);
    }

    public boolean shouldUseGeneratedIds() {
        return this.mShouldUseGeneratedIds;
    }

    public void setShouldUseGeneratedIds(boolean z) {
        if (isAttached()) {
            throw new IllegalStateException("Cannot change the usage of generated IDs while attached to the preference hierarchy");
        }
        this.mShouldUseGeneratedIds = z;
    }
}
