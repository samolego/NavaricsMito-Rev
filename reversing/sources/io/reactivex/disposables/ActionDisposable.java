package io.reactivex.disposables;

import io.reactivex.annotations.NonNull;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.p096b.InterfaceC2848a;

/* loaded from: classes2.dex */
final class ActionDisposable extends ReferenceDisposable<InterfaceC2848a> {
    private static final long serialVersionUID = -8219729196779211169L;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ActionDisposable(InterfaceC2848a interfaceC2848a) {
        super(interfaceC2848a);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.reactivex.disposables.ReferenceDisposable
    public void onDisposed(@NonNull InterfaceC2848a interfaceC2848a) {
        try {
            interfaceC2848a.run();
        } catch (Throwable th) {
            throw ExceptionHelper.m3131a(th);
        }
    }
}
