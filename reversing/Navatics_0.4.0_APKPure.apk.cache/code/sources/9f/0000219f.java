package com.twitter.sdk.android.core.models;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
class Entity implements Serializable {

    @SerializedName("indices")
    public final List<Integer> indices;

    public Entity(int i, int i2) {
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(0, Integer.valueOf(i));
        arrayList.add(1, Integer.valueOf(i2));
        this.indices = Collections.unmodifiableList(arrayList);
    }

    public int getStart() {
        return this.indices.get(0).intValue();
    }

    public int getEnd() {
        return this.indices.get(1).intValue();
    }
}