package com.twitter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;

/* loaded from: classes2.dex */
public class Extractor {

    /* renamed from: a */
    protected boolean f8442a = true;

    /* loaded from: classes2.dex */
    public static class Entity {

        /* renamed from: a */
        protected int f8443a;

        /* renamed from: b */
        protected int f8444b;

        /* renamed from: c */
        protected final String f8445c;

        /* renamed from: d */
        protected final String f8446d;

        /* renamed from: e */
        protected final Type f8447e;

        /* renamed from: f */
        protected String f8448f;

        /* renamed from: g */
        protected String f8449g;

        /* loaded from: classes2.dex */
        public enum Type {
            URL,
            HASHTAG,
            MENTION,
            CASHTAG
        }

        public Entity(int i, int i2, String str, String str2, Type type) {
            this.f8448f = null;
            this.f8449g = null;
            this.f8443a = i;
            this.f8444b = i2;
            this.f8445c = str;
            this.f8446d = str2;
            this.f8447e = type;
        }

        public Entity(int i, int i2, String str, Type type) {
            this(i, i2, str, null, type);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Entity)) {
                return false;
            }
            Entity entity = (Entity) obj;
            return this.f8447e.equals(entity.f8447e) && this.f8443a == entity.f8443a && this.f8444b == entity.f8444b && this.f8445c.equals(entity.f8445c);
        }

        public int hashCode() {
            return this.f8447e.hashCode() + this.f8445c.hashCode() + this.f8443a + this.f8444b;
        }

        public String toString() {
            return this.f8445c + "(" + this.f8447e + ") [" + this.f8443a + "," + this.f8444b + "]";
        }
    }

    /* renamed from: a */
    public List<Entity> m8266a(String str) {
        if (str != null && str.length() != 0) {
            if (str.indexOf(this.f8442a ? 46 : 58) != -1) {
                ArrayList arrayList = new ArrayList();
                Matcher matcher = C2502a.f8458h.matcher(str);
                while (matcher.find()) {
                    if (matcher.group(4) != null || (this.f8442a && !C2502a.f8460j.matcher(matcher.group(2)).matches())) {
                        String group = matcher.group(3);
                        int start = matcher.start(3);
                        int end = matcher.end(3);
                        Matcher matcher2 = C2502a.f8459i.matcher(group);
                        if (matcher2.find()) {
                            group = matcher2.group();
                            end = group.length() + start;
                        }
                        arrayList.add(new Entity(start, end, group, Entity.Type.URL));
                    }
                }
                return arrayList;
            }
        }
        return Collections.emptyList();
    }
}