package com.google.android.gms.internal;

import java.math.BigInteger;

/* loaded from: classes.dex */
public final class zzaon extends zzaoh {
    private static final Class<?>[] blf = {Integer.TYPE, Long.TYPE, Short.TYPE, Float.TYPE, Double.TYPE, Byte.TYPE, Boolean.TYPE, Character.TYPE, Integer.class, Long.class, Short.class, Float.class, Double.class, Byte.class, Boolean.class, Character.class};
    private Object value;

    public zzaon(Boolean bool) {
        setValue(bool);
    }

    public zzaon(Number number) {
        setValue(number);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaon(Object obj) {
        setValue(obj);
    }

    public zzaon(String str) {
        setValue(str);
    }

    private static boolean zza(zzaon zzaonVar) {
        Object obj = zzaonVar.value;
        if (obj instanceof Number) {
            Number number = (Number) obj;
            return (number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte);
        }
        return false;
    }

    private static boolean zzcn(Object obj) {
        if (obj instanceof String) {
            return true;
        }
        Class<?> cls = obj.getClass();
        for (Class<?> cls2 : blf) {
            if (cls2.isAssignableFrom(cls)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.zzaoh
    /* renamed from: aQ */
    public Number mo9661aQ() {
        Object obj = this.value;
        return obj instanceof String ? new zzape((String) obj) : (Number) obj;
    }

    @Override // com.google.android.gms.internal.zzaoh
    /* renamed from: aR */
    public String mo9660aR() {
        return m9657bb() ? mo9661aQ().toString() : m9658ba() ? mo9659aZ().toString() : (String) this.value;
    }

    @Override // com.google.android.gms.internal.zzaoh
    /* renamed from: aZ */
    Boolean mo9659aZ() {
        return (Boolean) this.value;
    }

    /* renamed from: ba */
    public boolean m9658ba() {
        return this.value instanceof Boolean;
    }

    /* renamed from: bb */
    public boolean m9657bb() {
        return this.value instanceof Number;
    }

    /* renamed from: bc */
    public boolean m9656bc() {
        return this.value instanceof String;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        zzaon zzaonVar = (zzaon) obj;
        if (this.value == null) {
            return zzaonVar.value == null;
        } else if (zza(this) && zza(zzaonVar)) {
            return mo9661aQ().longValue() == zzaonVar.mo9661aQ().longValue();
        } else if ((this.value instanceof Number) && (zzaonVar.value instanceof Number)) {
            double doubleValue = mo9661aQ().doubleValue();
            double doubleValue2 = zzaonVar.mo9661aQ().doubleValue();
            if (doubleValue != doubleValue2) {
                return Double.isNaN(doubleValue) && Double.isNaN(doubleValue2);
            }
            return true;
        } else {
            return this.value.equals(zzaonVar.value);
        }
    }

    @Override // com.google.android.gms.internal.zzaoh
    public boolean getAsBoolean() {
        return m9658ba() ? mo9659aZ().booleanValue() : Boolean.parseBoolean(mo9660aR());
    }

    @Override // com.google.android.gms.internal.zzaoh
    public double getAsDouble() {
        return m9657bb() ? mo9661aQ().doubleValue() : Double.parseDouble(mo9660aR());
    }

    @Override // com.google.android.gms.internal.zzaoh
    public int getAsInt() {
        return m9657bb() ? mo9661aQ().intValue() : Integer.parseInt(mo9660aR());
    }

    @Override // com.google.android.gms.internal.zzaoh
    public long getAsLong() {
        return m9657bb() ? mo9661aQ().longValue() : Long.parseLong(mo9660aR());
    }

    public int hashCode() {
        long doubleToLongBits;
        if (this.value == null) {
            return 31;
        }
        if (zza(this)) {
            doubleToLongBits = mo9661aQ().longValue();
        } else {
            Object obj = this.value;
            if (!(obj instanceof Number)) {
                return obj.hashCode();
            }
            doubleToLongBits = Double.doubleToLongBits(mo9661aQ().doubleValue());
        }
        return (int) ((doubleToLongBits >>> 32) ^ doubleToLongBits);
    }

    void setValue(Object obj) {
        if (obj instanceof Character) {
            obj = String.valueOf(((Character) obj).charValue());
        } else {
            zzaoz.zzbs((obj instanceof Number) || zzcn(obj));
        }
        this.value = obj;
    }
}
