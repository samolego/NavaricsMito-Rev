package com.takisoft.fix.support.p069v7.preference;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.p011v7.preference.Preference;

/* renamed from: com.takisoft.fix.support.v7.preference.PreferenceActivityResultListener */
/* loaded from: classes2.dex */
public interface PreferenceActivityResultListener {
    void onActivityResult(int i, int i2, @Nullable Intent intent);

    void onPreferenceClick(@NonNull PreferenceFragmentCompat preferenceFragmentCompat, @NonNull Preference preference);
}
