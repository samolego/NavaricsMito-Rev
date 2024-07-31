package com.bumptech.glide.load.p020b;

import com.bumptech.glide.load.p020b.LazyHeaders;
import java.util.Collections;
import java.util.Map;

/* renamed from: com.bumptech.glide.load.b.h */
/* loaded from: classes.dex */
public interface Headers {
    @Deprecated

    /* renamed from: a */
    public static final Headers f632a = new Headers() { // from class: com.bumptech.glide.load.b.h.1
        @Override // com.bumptech.glide.load.p020b.Headers
        /* renamed from: a */
        public Map<String, String> mo12336a() {
            return Collections.emptyMap();
        }
    };

    /* renamed from: b */
    public static final Headers f633b = new LazyHeaders.C0650a().m12333a();

    /* renamed from: a */
    Map<String, String> mo12336a();
}
