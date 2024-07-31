package org.greenrobot.essentials.collections;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: classes2.dex */
public class MultimapSet<K, V> extends AbstractMultimap<K, V, Set<V>> {

    /* renamed from: b */
    private final SetType f11756b;

    /* loaded from: classes2.dex */
    public enum SetType {
        REGULAR,
        THREAD_SAFE
    }

    /* renamed from: a */
    public static <K, V> MultimapSet<K, V> m12053a(SetType setType) {
        return new MultimapSet<>(new HashMap(), setType);
    }

    protected MultimapSet(Map<K, Set<V>> map, SetType setType) {
        super(map);
        this.f11756b = setType;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.essentials.collections.AbstractMultimap
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Set<V> mo12054a() {
        switch (this.f11756b) {
            case REGULAR:
                return new HashSet();
            case THREAD_SAFE:
                return new CopyOnWriteArraySet();
            default:
                throw new IllegalStateException("Unknown set type: " + this.f11756b);
        }
    }
}