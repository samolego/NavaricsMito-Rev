package com.navatics.app.model;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class Photo {
    private Map<String, Object> tags = new HashMap();
    private String uri;

    public boolean delete() {
        return false;
    }

    public Photo(String str) {
        this.uri = str;
    }

    public String getUri() {
        return this.uri;
    }

    public void setTag(String str, Object obj) {
        this.tags.put(str, obj);
    }

    public Object getTag(String str) {
        return this.tags.get(str);
    }
}