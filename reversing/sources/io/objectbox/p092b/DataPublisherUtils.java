package io.objectbox.p092b;

import io.objectbox.annotation.apihint.Internal;
import java.util.Set;

@Internal
/* renamed from: io.objectbox.b.c */
/* loaded from: classes2.dex */
public class DataPublisherUtils {
    /* renamed from: a */
    public static <T> void m3371a(Set<DataObserver<T>> set, DataObserver<T> dataObserver) {
        if (set != null) {
            for (DataObserver<T> dataObserver2 : set) {
                if (dataObserver2.equals(dataObserver)) {
                    set.remove(dataObserver2);
                } else if (dataObserver2 instanceof DelegatingObserver) {
                    DataObserver<T> dataObserver3 = dataObserver2;
                    while (dataObserver3 instanceof DelegatingObserver) {
                        dataObserver3 = ((DelegatingObserver) dataObserver3).mo3348a();
                    }
                    if (dataObserver3 == null || dataObserver3.equals(dataObserver)) {
                        set.remove(dataObserver2);
                    }
                }
            }
        }
    }
}
