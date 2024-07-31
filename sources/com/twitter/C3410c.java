package com.twitter;

import com.twitter.Extractor;
import java.text.Normalizer;

/* renamed from: com.twitter.c */
/* loaded from: classes2.dex */
public class Validator {

    /* renamed from: a */
    protected int f8429a = 23;

    /* renamed from: b */
    protected int f8430b = 23;

    /* renamed from: c */
    private Extractor f8431c = new Extractor();

    /* renamed from: a */
    public int m4585a(String str) {
        String normalize = Normalizer.normalize(str, Normalizer.Form.NFC);
        int codePointCount = normalize.codePointCount(0, normalize.length());
        for (Extractor.Entity entity : this.f8431c.m4587a(normalize)) {
            codePointCount = codePointCount + (entity.f8403a - entity.f8404b) + (entity.f8405c.toLowerCase().startsWith("https://") ? this.f8430b : this.f8429a);
        }
        return codePointCount;
    }
}
