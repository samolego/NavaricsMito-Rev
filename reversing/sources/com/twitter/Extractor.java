package com.twitter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;

/* loaded from: classes2.dex */
public class Extractor {

    /* renamed from: a */
    protected boolean f8402a = true;

    /* loaded from: classes2.dex */
    public static class Entity {

        /* renamed from: a */
        protected int f8403a;

        /* renamed from: b */
        protected int f8404b;

        /* renamed from: c */
        protected final String f8405c;

        /* renamed from: d */
        protected final String f8406d;

        /* renamed from: e */
        protected final Type f8407e;

        /* renamed from: f */
        protected String f8408f;

        /* renamed from: g */
        protected String f8409g;

        /* loaded from: classes2.dex */
        public enum Type {
            URL,
            HASHTAG,
            MENTION,
            CASHTAG
        }

        public Entity(int i, int i2, String str, String str2, Type type) {
            this.f8408f = null;
            this.f8409g = null;
            this.f8403a = i;
            this.f8404b = i2;
            this.f8405c = str;
            this.f8406d = str2;
            this.f8407e = type;
        }

        public Entity(int i, int i2, String str, Type type) {
            this(i, i2, str, null, type);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Entity) {
                Entity entity = (Entity) obj;
                return this.f8407e.equals(entity.f8407e) && this.f8403a == entity.f8403a && this.f8404b == entity.f8404b && this.f8405c.equals(entity.f8405c);
            }
            return false;
        }

        public int hashCode() {
            return this.f8407e.hashCode() + this.f8405c.hashCode() + this.f8403a + this.f8404b;
        }

        public String toString() {
            return this.f8405c + "(" + this.f8407e + ") [" + this.f8403a + "," + this.f8404b + "]";
        }
    }

    /* renamed from: a */
    public List<Entity> m4587a(String str) {
        if (str != null && str.length() != 0) {
            if (str.indexOf(this.f8402a ? 46 : 58) != -1) {
                ArrayList arrayList = new ArrayList();
                Matcher matcher = Regex.f8418h.matcher(str);
                while (matcher.find()) {
                    if (matcher.group(4) != null || (this.f8402a && !Regex.f8420j.matcher(matcher.group(2)).matches())) {
                        String group = matcher.group(3);
                        int start = matcher.start(3);
                        int end = matcher.end(3);
                        Matcher matcher2 = Regex.f8419i.matcher(group);
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
