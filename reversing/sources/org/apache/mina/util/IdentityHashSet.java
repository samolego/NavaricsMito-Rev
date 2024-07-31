package org.apache.mina.util;

import java.util.Collection;
import java.util.IdentityHashMap;

/* loaded from: classes2.dex */
public class IdentityHashSet<E> extends MapBackedSet<E> {
    private static final long serialVersionUID = 6948202189467167147L;

    public IdentityHashSet() {
        super(new IdentityHashMap());
    }

    public IdentityHashSet(int i) {
        super(new IdentityHashMap(i));
    }

    public IdentityHashSet(Collection<E> collection) {
        super(new IdentityHashMap(), collection);
    }
}
