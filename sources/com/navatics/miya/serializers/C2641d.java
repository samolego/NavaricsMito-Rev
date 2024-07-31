package com.navatics.miya.serializers;

import com.navatics.miya.Miya;
import com.navatics.miya.MiyaException;
import com.navatics.miya.Registration;
import com.navatics.miya.Serializer;
import com.navatics.miya.p059a.Output;
import com.navatics.miya.p060b.Generics;
import com.navatics.miya.serializers.FieldSerializer;
import java.lang.reflect.Field;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.navatics.miya.serializers.d */
/* loaded from: classes.dex */
public class ReflectField extends FieldSerializer.AbstractC2017a {

    /* renamed from: g */
    final FieldSerializer f6081g;

    /* renamed from: h */
    final Generics.C2010a f6082h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ReflectField(Field field, FieldSerializer fieldSerializer, Generics.C2010a c2010a) {
        super(field);
        this.f6081g = fieldSerializer;
        this.f6082h = c2010a;
    }

    /* renamed from: a */
    public Object m6617a(Object obj) throws IllegalAccessException {
        return this.f6062a.get(obj);
    }

    @Override // com.navatics.miya.serializers.FieldSerializer.AbstractC2017a
    /* renamed from: a */
    public void mo6616a(Output output, Object obj) {
        Miya miya = this.f6081g.f6057a;
        try {
            Object m6617a = m6617a(obj);
            Serializer serializer = this.f6065d;
            Class m6618a = m6618a();
            if (m6618a != null) {
                if (serializer == null) {
                    serializer = miya.m6726e(m6618a);
                }
                miya.m6725f().m6711a(this.f6082h);
                if (this.f6066e) {
                    miya.m6734b(output, m6617a, serializer);
                } else if (m6617a == null) {
                    throw new MiyaException("Field value cannot be null when canBeNull is false: " + this.f6063b + " (" + obj.getClass().getName() + ")");
                } else {
                    miya.m6741a(output, m6617a, serializer);
                }
            } else if (m6617a == null) {
                miya.m6743a(output, (Class) null);
                return;
            } else {
                Registration m6743a = miya.m6743a(output, (Class) m6617a.getClass());
                if (serializer == null) {
                    serializer = m6743a.m6650d();
                }
                miya.m6725f().m6711a(this.f6082h);
                miya.m6741a(output, m6617a, serializer);
            }
            miya.m6725f().m6713a();
        } catch (MiyaException e) {
            e.addTrace(this.f6063b + " (" + obj.getClass().getName() + ")");
            throw e;
        } catch (IllegalAccessException e2) {
            throw new MiyaException("Error accessing field: " + this.f6063b + " (" + obj.getClass().getName() + ")", e2);
        } catch (Throwable th) {
            th.printStackTrace();
            MiyaException miyaException = new MiyaException(th);
            miyaException.addTrace(this.f6063b + " (" + obj.getClass().getName() + ")");
            throw miyaException;
        }
    }

    /* renamed from: a */
    Class m6618a() {
        Class m6705a;
        return (this.f6064c == null && (m6705a = this.f6082h.m6705a(this.f6081g.f6057a.m6725f())) != null && this.f6081g.f6057a.m6724f(m6705a)) ? m6705a : this.f6064c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ReflectField.java */
    /* renamed from: com.navatics.miya.serializers.d$f */
    /* loaded from: classes.dex */
    public static final class C2037f extends FieldSerializer.AbstractC2017a {
        public C2037f(Field field) {
            super(field);
        }

        @Override // com.navatics.miya.serializers.FieldSerializer.AbstractC2017a
        /* renamed from: a */
        public void mo6616a(Output output, Object obj) {
            try {
                if (this.f6067f) {
                    output.m6758a(this.f6062a.getInt(obj), false);
                } else {
                    output.m6746c(this.f6062a.getInt(obj));
                }
            } catch (Throwable th) {
                MiyaException miyaException = new MiyaException(th);
                miyaException.addTrace(this.f6063b + " (int)");
                throw miyaException;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ReflectField.java */
    /* renamed from: com.navatics.miya.serializers.d$e */
    /* loaded from: classes.dex */
    public static final class C2036e extends FieldSerializer.AbstractC2017a {
        public C2036e(Field field) {
            super(field);
        }

        @Override // com.navatics.miya.serializers.FieldSerializer.AbstractC2017a
        /* renamed from: a */
        public void mo6616a(Output output, Object obj) {
            try {
                output.m6760a(this.f6062a.getFloat(obj));
            } catch (Throwable th) {
                MiyaException miyaException = new MiyaException(th);
                miyaException.addTrace(this.f6063b + " (float)");
                throw miyaException;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ReflectField.java */
    /* renamed from: com.navatics.miya.serializers.d$h */
    /* loaded from: classes.dex */
    public static final class C2039h extends FieldSerializer.AbstractC2017a {
        public C2039h(Field field) {
            super(field);
        }

        @Override // com.navatics.miya.serializers.FieldSerializer.AbstractC2017a
        /* renamed from: a */
        public void mo6616a(Output output, Object obj) {
            try {
                output.m6745d(this.f6062a.getShort(obj));
            } catch (Throwable th) {
                MiyaException miyaException = new MiyaException(th);
                miyaException.addTrace(this.f6063b + " (short)");
                throw miyaException;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ReflectField.java */
    /* renamed from: com.navatics.miya.serializers.d$b */
    /* loaded from: classes.dex */
    public static final class C2033b extends FieldSerializer.AbstractC2017a {
        public C2033b(Field field) {
            super(field);
        }

        @Override // com.navatics.miya.serializers.FieldSerializer.AbstractC2017a
        /* renamed from: a */
        public void mo6616a(Output output, Object obj) {
            try {
                output.m6763a(this.f6062a.getByte(obj));
            } catch (Throwable th) {
                MiyaException miyaException = new MiyaException(th);
                miyaException.addTrace(this.f6063b + " (byte)");
                throw miyaException;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ReflectField.java */
    /* renamed from: com.navatics.miya.serializers.d$a */
    /* loaded from: classes.dex */
    public static final class C2032a extends FieldSerializer.AbstractC2017a {
        public C2032a(Field field) {
            super(field);
        }

        @Override // com.navatics.miya.serializers.FieldSerializer.AbstractC2017a
        /* renamed from: a */
        public void mo6616a(Output output, Object obj) {
            try {
                output.m6752a(this.f6062a.getBoolean(obj));
            } catch (Throwable th) {
                MiyaException miyaException = new MiyaException(th);
                miyaException.addTrace(this.f6063b + " (boolean)");
                throw miyaException;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ReflectField.java */
    /* renamed from: com.navatics.miya.serializers.d$c */
    /* loaded from: classes.dex */
    public static final class C2034c extends FieldSerializer.AbstractC2017a {
        public C2034c(Field field) {
            super(field);
        }

        @Override // com.navatics.miya.serializers.FieldSerializer.AbstractC2017a
        /* renamed from: a */
        public void mo6616a(Output output, Object obj) {
            try {
                output.m6762a(this.f6062a.getChar(obj));
            } catch (Throwable th) {
                MiyaException miyaException = new MiyaException(th);
                miyaException.addTrace(this.f6063b + " (char)");
                throw miyaException;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ReflectField.java */
    /* renamed from: com.navatics.miya.serializers.d$g */
    /* loaded from: classes.dex */
    public static final class C2038g extends FieldSerializer.AbstractC2017a {
        public C2038g(Field field) {
            super(field);
        }

        @Override // com.navatics.miya.serializers.FieldSerializer.AbstractC2017a
        /* renamed from: a */
        public void mo6616a(Output output, Object obj) {
            try {
                if (this.f6067f) {
                    output.m6756a(this.f6062a.getLong(obj), false);
                } else {
                    output.m6757a(this.f6062a.getLong(obj));
                }
            } catch (Throwable th) {
                MiyaException miyaException = new MiyaException(th);
                miyaException.addTrace(this.f6063b + " (long)");
                throw miyaException;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ReflectField.java */
    /* renamed from: com.navatics.miya.serializers.d$d */
    /* loaded from: classes.dex */
    public static final class C2035d extends FieldSerializer.AbstractC2017a {
        public C2035d(Field field) {
            super(field);
        }

        @Override // com.navatics.miya.serializers.FieldSerializer.AbstractC2017a
        /* renamed from: a */
        public void mo6616a(Output output, Object obj) {
            try {
                output.m6761a(this.f6062a.getDouble(obj));
            } catch (Throwable th) {
                MiyaException miyaException = new MiyaException(th);
                miyaException.addTrace(this.f6063b + " (double)");
                throw miyaException;
            }
        }
    }
}
