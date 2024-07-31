package com.google.android.gms.tasks;

import android.support.annotation.NonNull;

/* loaded from: classes.dex */
public interface OnCompleteListener<TResult> {
    void onComplete(@NonNull Task<TResult> task);
}
