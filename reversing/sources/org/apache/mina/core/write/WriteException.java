package org.apache.mina.core.write;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import org.apache.mina.util.MapBackedSet;

/* loaded from: classes2.dex */
public class WriteException extends IOException {
    private static final long serialVersionUID = -4174407422754524197L;
    private final List<InterfaceC3088b> requests;

    public WriteException(InterfaceC3088b interfaceC3088b) {
        this.requests = m965a(interfaceC3088b);
    }

    public WriteException(InterfaceC3088b interfaceC3088b, String str) {
        super(str);
        this.requests = m965a(interfaceC3088b);
    }

    public WriteException(InterfaceC3088b interfaceC3088b, String str, Throwable th) {
        super(str);
        initCause(th);
        this.requests = m965a(interfaceC3088b);
    }

    public WriteException(InterfaceC3088b interfaceC3088b, Throwable th) {
        initCause(th);
        this.requests = m965a(interfaceC3088b);
    }

    public WriteException(Collection<InterfaceC3088b> collection) {
        this.requests = m966a(collection);
    }

    public WriteException(Collection<InterfaceC3088b> collection, String str) {
        super(str);
        this.requests = m966a(collection);
    }

    public WriteException(Collection<InterfaceC3088b> collection, String str, Throwable th) {
        super(str);
        initCause(th);
        this.requests = m966a(collection);
    }

    public WriteException(Collection<InterfaceC3088b> collection, Throwable th) {
        initCause(th);
        this.requests = m966a(collection);
    }

    public List<InterfaceC3088b> getRequests() {
        return this.requests;
    }

    public InterfaceC3088b getRequest() {
        return this.requests.get(0);
    }

    /* renamed from: a */
    private static List<InterfaceC3088b> m966a(Collection<InterfaceC3088b> collection) {
        if (collection == null) {
            throw new IllegalArgumentException("requests");
        }
        if (collection.isEmpty()) {
            throw new IllegalArgumentException("requests is empty.");
        }
        MapBackedSet mapBackedSet = new MapBackedSet(new LinkedHashMap());
        for (InterfaceC3088b interfaceC3088b : collection) {
            mapBackedSet.add(interfaceC3088b.mo954c());
        }
        return Collections.unmodifiableList(new ArrayList(mapBackedSet));
    }

    /* renamed from: a */
    private static List<InterfaceC3088b> m965a(InterfaceC3088b interfaceC3088b) {
        if (interfaceC3088b == null) {
            throw new IllegalArgumentException("request");
        }
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(interfaceC3088b.mo954c());
        return Collections.unmodifiableList(arrayList);
    }
}
