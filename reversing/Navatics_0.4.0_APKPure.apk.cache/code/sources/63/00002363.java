package io.objectbox.internal;

import io.objectbox.annotation.apihint.Internal;
import java.io.Serializable;
import java.util.List;

@Internal
/* loaded from: classes2.dex */
public interface ToManyGetter<SOURCE> extends Serializable {
    <TARGET> List<TARGET> getToMany(SOURCE source);
}