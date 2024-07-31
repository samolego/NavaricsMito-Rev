package io.reactivex.exceptions;

import io.reactivex.annotations.NonNull;
import io.reactivex.internal.util.ExceptionHelper;

/* renamed from: io.reactivex.exceptions.a */
/* loaded from: classes2.dex */
public final class Exceptions {
    @NonNull
    /* renamed from: a */
    public static RuntimeException m3208a(@NonNull Throwable th) {
        throw ExceptionHelper.m3131a(th);
    }

    /* renamed from: b */
    public static void m3207b(@NonNull Throwable th) {
        if (th instanceof VirtualMachineError) {
            throw ((VirtualMachineError) th);
        }
        if (th instanceof ThreadDeath) {
            throw ((ThreadDeath) th);
        }
        if (th instanceof LinkageError) {
            throw ((LinkageError) th);
        }
    }
}
