package com.twitter;

import com.twitter.Extractor;
import java.text.Normalizer;

/* compiled from: Validator.java */
/* renamed from: com.twitter.c, reason: use source file name */
/* loaded from: classes2.dex */
public class Validator {

    /* renamed from: a */
    protected int f8469a = 23;

    /* renamed from: b */
    protected int f8470b = 23;

    /* renamed from: c */
    private Extractor f8471c = new Extractor();

    /* renamed from: a */
    public int m8268a(String str) {
        String normalize = Normalizer.normalize(str, Normalizer.Form.NFC);
        int codePointCount = normalize.codePointCount(0, normalize.length());
        for (Extractor.Entity entity : this.f8471c.m8266a(normalize)) {
            codePointCount = codePointCount + (entity.f8443a - entity.f8444b) + (entity.f8445c.toLowerCase().startsWith("https://") ? this.f8470b : this.f8469a);
        }
        return codePointCount;
    }
}