package android.arch.lifecycle;

import android.support.annotation.MainThread;
import android.support.annotation.NonNull;

/* loaded from: classes.dex */
public abstract class Lifecycle {

    /* loaded from: classes.dex */
    public enum Event {
        ON_CREATE,
        ON_START,
        ON_RESUME,
        ON_PAUSE,
        ON_STOP,
        ON_DESTROY,
        ON_ANY
    }

    @NonNull
    @MainThread
    /* renamed from: a */
    public abstract State mo56a();

    @MainThread
    /* renamed from: a */
    public abstract void mo57a(@NonNull LifecycleObserver lifecycleObserver);

    @MainThread
    /* renamed from: b */
    public abstract void mo58b(@NonNull LifecycleObserver lifecycleObserver);

    /* loaded from: classes.dex */
    public enum State {
        DESTROYED,
        INITIALIZED,
        CREATED,
        STARTED,
        RESUMED;

        public boolean isAtLeast(@NonNull State state) {
            return compareTo(state) >= 0;
        }
    }
}