package io.objectbox.query;

import io.objectbox.Property;
import io.objectbox.annotation.apihint.Experimental;
import io.objectbox.annotation.apihint.Internal;
import io.objectbox.exception.DbException;
import java.util.Date;
import javax.annotation.Nullable;

@Experimental
@Internal
/* loaded from: classes2.dex */
public interface QueryCondition {

    /* renamed from: io.objectbox.query.QueryCondition$a */
    /* loaded from: classes2.dex */
    public static abstract class AbstractC2837a implements QueryCondition {

        /* renamed from: a */
        public final Object f9573a;

        /* renamed from: b */
        protected final Object[] f9574b;

        AbstractC2837a(Object obj) {
            this.f9573a = obj;
            this.f9574b = null;
        }

        AbstractC2837a(@Nullable Object[] objArr) {
            this.f9573a = null;
            this.f9574b = objArr;
        }
    }

    /* loaded from: classes2.dex */
    public static class PropertyCondition extends AbstractC2837a {

        /* renamed from: c */
        public final Property f9569c;

        /* renamed from: d */
        private final Operation f9570d;

        /* loaded from: classes2.dex */
        public enum Operation {
            EQUALS,
            NOT_EQUALS,
            BETWEEN,
            IN,
            GREATER_THAN,
            LESS_THAN,
            IS_NULL,
            IS_NOT_NULL,
            CONTAINS,
            STARTS_WITH,
            ENDS_WITH
        }

        public PropertyCondition(Property property, Operation operation, @Nullable Object obj) {
            super(m3284a(property, obj));
            this.f9569c = property;
            this.f9570d = operation;
        }

        public PropertyCondition(Property property, Operation operation, @Nullable Object[] objArr) {
            super(m3285a(property, operation, objArr));
            this.f9569c = property;
            this.f9570d = operation;
        }

        /* renamed from: a */
        private static Object m3284a(Property property, @Nullable Object obj) {
            if (obj != null && obj.getClass().isArray()) {
                throw new DbException("Illegal value: found array, but simple object required");
            }
            if (property.type == Date.class) {
                if (obj instanceof Date) {
                    return Long.valueOf(((Date) obj).getTime());
                }
                if (obj instanceof Long) {
                    return obj;
                }
                throw new DbException("Illegal date value: expected java.util.Date or Long for value " + obj);
            }
            if (property.type == Boolean.TYPE || property.type == Boolean.class) {
                if (obj instanceof Boolean) {
                    return Integer.valueOf(((Boolean) obj).booleanValue() ? 1 : 0);
                }
                if (obj instanceof Number) {
                    int intValue = ((Number) obj).intValue();
                    if (intValue != 0 && intValue != 1) {
                        throw new DbException("Illegal boolean value: numbers must be 0 or 1, but was " + obj);
                    }
                } else if (obj instanceof String) {
                    String str = (String) obj;
                    if ("TRUE".equalsIgnoreCase(str)) {
                        return 1;
                    }
                    if ("FALSE".equalsIgnoreCase(str)) {
                        return 0;
                    }
                    throw new DbException("Illegal boolean value: Strings must be \"TRUE\" or \"FALSE\" (case insensitive), but was " + obj);
                }
            }
            return obj;
        }

        /* renamed from: a */
        private static Object[] m3285a(Property property, Operation operation, @Nullable Object[] objArr) {
            if (objArr == null) {
                if (operation == Operation.IS_NULL || operation == Operation.IS_NOT_NULL) {
                    return null;
                }
                throw new IllegalArgumentException("This operation requires non-null values.");
            }
            for (int i = 0; i < objArr.length; i++) {
                objArr[i] = m3284a(property, objArr[i]);
            }
            return objArr;
        }
    }
}
