package io.reactivex.exceptions;

import io.reactivex.annotations.NonNull;
import io.reactivex.internal.util.ExceptionHelper;

/* compiled from: Exceptions.java */
/* renamed from: io.reactivex.exceptions.a, reason: use source file name */
/* loaded from: classes2.dex */
public final class Exceptions {
    @NonNull
    /* renamed from: a */
    public static RuntimeException m9628a(@NonNull Throwable th) {
        throw ExceptionHelper.m9706a(th);
    }

    /* renamed from: b */
    public static void m9629b(@NonNull Throwable th) {
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