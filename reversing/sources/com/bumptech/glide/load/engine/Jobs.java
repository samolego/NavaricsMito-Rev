package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Key;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.bumptech.glide.load.engine.p */
/* loaded from: classes.dex */
final class Jobs {

    /* renamed from: a */
    private final Map<Key, EngineJob<?>> f965a = new HashMap();

    /* renamed from: b */
    private final Map<Key, EngineJob<?>> f966b = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public EngineJob<?> m12036a(Key key, boolean z) {
        return m12035a(z).get(key);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m12037a(Key key, EngineJob<?> engineJob) {
        m12035a(engineJob.m12063a()).put(key, engineJob);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public void m12034b(Key key, EngineJob<?> engineJob) {
        Map<Key, EngineJob<?>> m12035a = m12035a(engineJob.m12063a());
        if (engineJob.equals(m12035a.get(key))) {
            m12035a.remove(key);
        }
    }

    /* renamed from: a */
    private Map<Key, EngineJob<?>> m12035a(boolean z) {
        return z ? this.f966b : this.f965a;
    }
}
