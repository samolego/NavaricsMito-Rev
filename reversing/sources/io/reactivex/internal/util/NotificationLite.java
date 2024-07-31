package io.reactivex.internal.util;

import io.reactivex.InterfaceC2900o;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.p100a.ObjectHelper;
import java.io.Serializable;
import org.p109a.Subscriber;
import org.p109a.Subscription;

/* loaded from: classes2.dex */
public enum NotificationLite {
    COMPLETE;

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T getValue(Object obj) {
        return obj;
    }

    public static <T> Object next(T t) {
        return t;
    }

    @Override // java.lang.Enum
    public String toString() {
        return "NotificationLite.Complete";
    }

    /* loaded from: classes2.dex */
    static final class ErrorNotification implements Serializable {
        private static final long serialVersionUID = -8759979445933046293L;

        /* renamed from: e */
        final Throwable f9865e;

        ErrorNotification(Throwable th) {
            this.f9865e = th;
        }

        public String toString() {
            return "NotificationLite.Error[" + this.f9865e + "]";
        }

        public int hashCode() {
            return this.f9865e.hashCode();
        }

        public boolean equals(Object obj) {
            if (obj instanceof ErrorNotification) {
                return ObjectHelper.m3189a(this.f9865e, ((ErrorNotification) obj).f9865e);
            }
            return false;
        }
    }

    /* loaded from: classes2.dex */
    static final class SubscriptionNotification implements Serializable {
        private static final long serialVersionUID = -1322257508628817540L;
        final Subscription upstream;

        SubscriptionNotification(Subscription subscription) {
            this.upstream = subscription;
        }

        public String toString() {
            return "NotificationLite.Subscription[" + this.upstream + "]";
        }
    }

    /* loaded from: classes2.dex */
    static final class DisposableNotification implements Serializable {
        private static final long serialVersionUID = -7482590109178395495L;
        final Disposable upstream;

        DisposableNotification(Disposable disposable) {
            this.upstream = disposable;
        }

        public String toString() {
            return "NotificationLite.Disposable[" + this.upstream + "]";
        }
    }

    public static Object complete() {
        return COMPLETE;
    }

    public static Object error(Throwable th) {
        return new ErrorNotification(th);
    }

    public static Object subscription(Subscription subscription) {
        return new SubscriptionNotification(subscription);
    }

    public static Object disposable(Disposable disposable) {
        return new DisposableNotification(disposable);
    }

    public static boolean isComplete(Object obj) {
        return obj == COMPLETE;
    }

    public static boolean isError(Object obj) {
        return obj instanceof ErrorNotification;
    }

    public static boolean isSubscription(Object obj) {
        return obj instanceof SubscriptionNotification;
    }

    public static boolean isDisposable(Object obj) {
        return obj instanceof DisposableNotification;
    }

    public static Throwable getError(Object obj) {
        return ((ErrorNotification) obj).f9865e;
    }

    public static Subscription getSubscription(Object obj) {
        return ((SubscriptionNotification) obj).upstream;
    }

    public static Disposable getDisposable(Object obj) {
        return ((DisposableNotification) obj).upstream;
    }

    public static <T> boolean accept(Object obj, Subscriber<? super T> subscriber) {
        if (obj == COMPLETE) {
            subscriber.m2199a();
            return true;
        } else if (obj instanceof ErrorNotification) {
            subscriber.m2197a(((ErrorNotification) obj).f9865e);
            return true;
        } else {
            subscriber.m2198a((Subscriber<? super T>) obj);
            return false;
        }
    }

    public static <T> boolean accept(Object obj, InterfaceC2900o<? super T> interfaceC2900o) {
        if (obj == COMPLETE) {
            interfaceC2900o.onComplete();
            return true;
        } else if (obj instanceof ErrorNotification) {
            interfaceC2900o.onError(((ErrorNotification) obj).f9865e);
            return true;
        } else {
            interfaceC2900o.onNext(obj);
            return false;
        }
    }

    public static <T> boolean acceptFull(Object obj, Subscriber<? super T> subscriber) {
        if (obj == COMPLETE) {
            subscriber.m2199a();
            return true;
        } else if (obj instanceof ErrorNotification) {
            subscriber.m2197a(((ErrorNotification) obj).f9865e);
            return true;
        } else if (obj instanceof SubscriptionNotification) {
            subscriber.m2196a(((SubscriptionNotification) obj).upstream);
            return false;
        } else {
            subscriber.m2198a((Subscriber<? super T>) obj);
            return false;
        }
    }

    public static <T> boolean acceptFull(Object obj, InterfaceC2900o<? super T> interfaceC2900o) {
        if (obj == COMPLETE) {
            interfaceC2900o.onComplete();
            return true;
        } else if (obj instanceof ErrorNotification) {
            interfaceC2900o.onError(((ErrorNotification) obj).f9865e);
            return true;
        } else if (obj instanceof DisposableNotification) {
            interfaceC2900o.onSubscribe(((DisposableNotification) obj).upstream);
            return false;
        } else {
            interfaceC2900o.onNext(obj);
            return false;
        }
    }
}
