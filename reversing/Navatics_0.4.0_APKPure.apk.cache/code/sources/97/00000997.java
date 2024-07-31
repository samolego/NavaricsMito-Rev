package androidx.versionedparcelable;

import android.os.Parcelable;
import android.support.annotation.RestrictTo;
import java.lang.reflect.InvocationTargetException;

/* compiled from: VersionedParcel.java */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* renamed from: androidx.versionedparcelable.a, reason: use source file name */
/* loaded from: classes.dex */
public abstract class VersionedParcel {
    /* renamed from: a */
    protected abstract void mo126a(int i);

    /* renamed from: a */
    protected abstract void mo128a(Parcelable parcelable);

    /* renamed from: a */
    protected abstract void mo131a(String str);

    /* renamed from: a */
    public void m133a(boolean z, boolean z2) {
    }

    /* renamed from: a */
    protected abstract void mo134a(byte[] bArr);

    /* renamed from: a */
    public boolean m136a() {
        return false;
    }

    /* renamed from: b */
    protected abstract void mo140b();

    /* renamed from: b */
    protected abstract boolean mo141b(int i);

    /* renamed from: c */
    protected abstract VersionedParcel mo143c();

    /* renamed from: c */
    protected abstract void mo144c(int i);

    /* renamed from: d */
    protected abstract int mo145d();

    /* renamed from: e */
    protected abstract String mo146e();

    /* renamed from: f */
    protected abstract byte[] mo147f();

    /* renamed from: g */
    protected abstract <T extends Parcelable> T mo148g();

    /* renamed from: a */
    public void m135a(byte[] bArr, int i) {
        mo144c(i);
        mo134a(bArr);
    }

    /* renamed from: a */
    public void m127a(int i, int i2) {
        mo144c(i2);
        mo126a(i);
    }

    /* renamed from: a */
    public void m132a(String str, int i) {
        mo144c(i);
        mo131a(str);
    }

    /* renamed from: a */
    public void m129a(Parcelable parcelable, int i) {
        mo144c(i);
        mo128a(parcelable);
    }

    /* renamed from: b */
    public int m137b(int i, int i2) {
        return !mo141b(i2) ? i : mo145d();
    }

    /* renamed from: b */
    public String m139b(String str, int i) {
        return !mo141b(i) ? str : mo146e();
    }

    /* renamed from: b */
    public byte[] m142b(byte[] bArr, int i) {
        return !mo141b(i) ? bArr : mo147f();
    }

    /* renamed from: b */
    public <T extends Parcelable> T m138b(T t, int i) {
        return !mo141b(i) ? t : (T) mo148g();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void m130a(VersionedParcelable versionedParcelable) {
        if (versionedParcelable == null) {
            mo131a((String) null);
            return;
        }
        m124b(versionedParcelable);
        VersionedParcel mo143c = mo143c();
        m123a(versionedParcelable, mo143c);
        mo143c.mo140b();
    }

    /* renamed from: b */
    private void m124b(VersionedParcelable versionedParcelable) {
        try {
            mo131a(m122a((Class<? extends VersionedParcelable>) versionedParcelable.getClass()).getName());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(versionedParcelable.getClass().getSimpleName() + " does not have a Parcelizer", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: h */
    public <T extends VersionedParcelable> T m149h() {
        String mo146e = mo146e();
        if (mo146e == null) {
            return null;
        }
        return (T) m121a(mo146e, mo143c());
    }

    /* renamed from: a */
    protected static <T extends VersionedParcelable> T m121a(String str, VersionedParcel versionedParcel) {
        try {
            return (T) Class.forName(str, true, VersionedParcel.class.getClassLoader()).getDeclaredMethod("read", VersionedParcel.class).invoke(null, versionedParcel);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e2);
        } catch (NoSuchMethodException e3) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e3);
        } catch (InvocationTargetException e4) {
            if (e4.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e4.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e4);
        }
    }

    /* renamed from: a */
    protected static <T extends VersionedParcelable> void m123a(T t, VersionedParcel versionedParcel) {
        try {
            m125c(t).getDeclaredMethod("write", t.getClass(), VersionedParcel.class).invoke(null, t, versionedParcel);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e2);
        } catch (NoSuchMethodException e3) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e3);
        } catch (InvocationTargetException e4) {
            if (e4.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e4.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e4);
        }
    }

    /* renamed from: c */
    private static <T extends VersionedParcelable> Class m125c(T t) throws ClassNotFoundException {
        return m122a((Class<? extends VersionedParcelable>) t.getClass());
    }

    /* renamed from: a */
    private static Class m122a(Class<? extends VersionedParcelable> cls) throws ClassNotFoundException {
        return Class.forName(String.format("%s.%sParcelizer", cls.getPackage().getName(), cls.getSimpleName()), false, cls.getClassLoader());
    }
}