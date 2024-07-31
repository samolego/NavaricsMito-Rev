package io.objectbox.internal;

import io.objectbox.annotation.apihint.Internal;
import io.objectbox.relation.ToOne;
import java.io.Serializable;

@Internal
/* loaded from: classes2.dex */
public interface ToOneGetter<SOURCE> extends Serializable {
    <TARGET> ToOne<TARGET> getToOne(SOURCE source);
}
