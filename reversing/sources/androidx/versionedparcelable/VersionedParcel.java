package androidx.versionedparcelable;

import android.os.Parcelable;
import android.support.annotation.RestrictTo;
import java.lang.reflect.InvocationTargetException;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* renamed from: androidx.versionedparcelable.a */
/* loaded from: classes.dex */
public abstract class VersionedParcel {
    /* renamed from: a */
    protected abstract void mo12818a(int i);

    /* renamed from: a */
    protected abstract void mo12817a(Parcelable parcelable);

    /* renamed from: a */
    protected abstract void mo12816a(String str);

    /* renamed from: a */
    public void m12827a(boolean z, boolean z2) {
    }

    /* renamed from: a */
    protected abstract void mo12815a(byte[] bArr);

    /* renamed from: a */
    public boolean m12835a() {
        return false;
    }

    /* renamed from: b */
    protected abstract void mo12814b();

    /* renamed from: b */
    protected abstract boolean mo12813b(int i);

    /* renamed from: c */
    protected abstract VersionedParcel mo12812c();

    /* renamed from: c */
    protected abstract void mo12811c(int i);

    /* renamed from: d */
    protected abstract int mo12810d();

    /* renamed from: e */
    protected abstract String mo12808e();

    /* renamed from: f */
    protected abstract byte[] mo12807f();

    /* renamed from: g */
    protected abstract <T extends Parcelable> T mo12806g();

    /* renamed from: a */
    public void m12826a(byte[] bArr, int i) {
        mo12811c(i);
        mo12815a(bArr);
    }

    /* renamed from: a */
    public void m12834a(int i, int i2) {
        mo12811c(i2);
        mo12818a(i);
    }

    /* renamed from: a */
    public void m12829a(String str, int i) {
        mo12811c(i);
        mo12816a(str);
    }

    /* renamed from: a */
    public void m12833a(Parcelable parcelable, int i) {
        mo12811c(i);
        mo12817a(parcelable);
    }

    /* renamed from: b */
    public int m12825b(int i, int i2) {
        return !mo12813b(i2) ? i : mo12810d();
    }

    /* renamed from: b */
    public String m12822b(String str, int i) {
        return !mo12813b(i) ? str : mo12808e();
    }

    /* renamed from: b */
    public byte[] m12821b(byte[] bArr, int i) {
        return !mo12813b(i) ? bArr : mo12807f();
    }

    /* renamed from: b */
    public <T extends Parcelable> T m12824b(T t, int i) {
        return !mo12813b(i) ? t : (T) mo12806g();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void m12832a(VersionedParcelable versionedParcelable) {
        if (versionedParcelable == null) {
            mo12816a((String) null);
            return;
        }
        m12823b(versionedParcelable);
        VersionedParcel mo12812c = mo12812c();
        m12831a(versionedParcelable, mo12812c);
        mo12812c.mo12814b();
    }

    /* renamed from: b */
    private void m12823b(VersionedParcelable versionedParcelable) {
        try {
            mo12816a(m12830a((Class<? extends VersionedParcelable>) versionedParcelable.getClass()).getName());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(versionedParcelable.getClass().getSimpleName() + " does not have a Parcelizer", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: h */
    public <T extends VersionedParcelable> T m12819h() {
        String mo12808e = mo12808e();
        if (mo12808e == null) {
            return null;
        }
        return (T) m12828a(mo12808e, mo12812c());
    }

    /* renamed from: a */
    protected static <T extends VersionedParcelable> T m12828a(String str, VersionedParcel versionedParcel) {
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
    protected static <T extends VersionedParcelable> void m12831a(T t, VersionedParcel versionedParcel) {
        try {
            m12820c(t).getDeclaredMethod("write", t.getClass(), VersionedParcel.class).invoke(null, t, versionedParcel);
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
    private static <T extends VersionedParcelable> Class m12820c(T t) throws ClassNotFoundException {
        return m12830a((Class<? extends VersionedParcelable>) t.getClass());
    }

    /* renamed from: a */
    private static Class m12830a(Class<? extends VersionedParcelable> cls) throws ClassNotFoundException {
        return Class.forName(String.format("%s.%sParcelizer", cls.getPackage().getName(), cls.getSimpleName()), false, cls.getClassLoader());
    }
}
