package io.objectbox;

import io.objectbox.annotation.apihint.Internal;
import io.objectbox.internal.CursorFactory;
import io.objectbox.internal.IdGetter;
import java.io.Serializable;

@Internal
/* loaded from: classes2.dex */
public interface EntityInfo<T> extends Serializable {
    Property<T>[] getAllProperties();

    CursorFactory<T> getCursorFactory();

    String getDbName();

    Class<T> getEntityClass();

    int getEntityId();

    String getEntityName();

    IdGetter<T> getIdGetter();

    Property<T> getIdProperty();
}
