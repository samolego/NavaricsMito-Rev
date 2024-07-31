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
    public abstract State mo12886a();

    @MainThread
    /* renamed from: a */
    public abstract void mo12882a(@NonNull LifecycleObserver lifecycleObserver);

    @MainThread
    /* renamed from: b */
    public abstract void mo12877b(@NonNull LifecycleObserver lifecycleObserver);

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
