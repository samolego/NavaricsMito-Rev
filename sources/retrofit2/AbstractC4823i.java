package retrofit2;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Map;
import javax.annotation.Nullable;
import okhttp3.C2984s;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: retrofit2.i */
/* loaded from: classes2.dex */
public abstract class ParameterHandler<T> {
    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract void mo94a(C3202k c3202k, @Nullable T t) throws IOException;

    ParameterHandler() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final ParameterHandler<Iterable<T>> m102a() {
        return new ParameterHandler<Iterable<T>>() { // from class: retrofit2.i.1
            @Override // retrofit2.ParameterHandler
            /* renamed from: a */
            /* bridge */ /* synthetic */ void mo94a(C3202k c3202k, @Nullable Object obj) throws IOException {
                m100a(c3202k, (Iterable) ((Iterable) obj));
            }

            /* renamed from: a */
            void m100a(C3202k c3202k, @Nullable Iterable<T> iterable) throws IOException {
                if (iterable == null) {
                    return;
                }
                for (T t : iterable) {
                    ParameterHandler.this.mo94a(c3202k, t);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public final ParameterHandler<Object> m101b() {
        return new ParameterHandler<Object>() { // from class: retrofit2.i.2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // retrofit2.ParameterHandler
            /* renamed from: a */
            void mo94a(C3202k c3202k, @Nullable Object obj) throws IOException {
                if (obj == null) {
                    return;
                }
                int length = Array.getLength(obj);
                for (int i = 0; i < length; i++) {
                    ParameterHandler.this.mo94a(c3202k, Array.get(obj, i));
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ParameterHandler.java */
    /* renamed from: retrofit2.i$m */
    /* loaded from: classes2.dex */
    public static final class C3197m extends ParameterHandler<Object> {
        @Override // retrofit2.ParameterHandler
        /* renamed from: a */
        void mo94a(C3202k c3202k, @Nullable Object obj) {
            C3208o.m25a(obj, "@Url parameter is null.");
            c3202k.m86a(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ParameterHandler.java */
    /* renamed from: retrofit2.i$d */
    /* loaded from: classes2.dex */
    public static final class C3188d<T> extends ParameterHandler<T> {

        /* renamed from: a */
        private final String f12646a;

        /* renamed from: b */
        private final Converter<T, String> f12647b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C3188d(String str, Converter<T, String> converter) {
            this.f12646a = (String) C3208o.m25a(str, "name == null");
            this.f12647b = converter;
        }

        @Override // retrofit2.ParameterHandler
        /* renamed from: a */
        void mo94a(C3202k c3202k, @Nullable T t) throws IOException {
            String mo153a;
            if (t == null || (mo153a = this.f12647b.mo153a(t)) == null) {
                return;
            }
            c3202k.m85a(this.f12646a, mo153a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ParameterHandler.java */
    /* renamed from: retrofit2.i$h */
    /* loaded from: classes2.dex */
    public static final class C3192h<T> extends ParameterHandler<T> {

        /* renamed from: a */
        private final String f12653a;

        /* renamed from: b */
        private final Converter<T, String> f12654b;

        /* renamed from: c */
        private final boolean f12655c;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C3192h(String str, Converter<T, String> converter, boolean z) {
            this.f12653a = (String) C3208o.m25a(str, "name == null");
            this.f12654b = converter;
            this.f12655c = z;
        }

        @Override // retrofit2.ParameterHandler
        /* renamed from: a */
        void mo94a(C3202k c3202k, @Nullable T t) throws IOException {
            if (t == null) {
                throw new IllegalArgumentException("Path parameter \"" + this.f12653a + "\" value must not be null.");
            }
            c3202k.m84a(this.f12653a, this.f12654b.mo153a(t), this.f12655c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ParameterHandler.java */
    /* renamed from: retrofit2.i$i */
    /* loaded from: classes2.dex */
    public static final class C3193i<T> extends ParameterHandler<T> {

        /* renamed from: a */
        private final String f12656a;

        /* renamed from: b */
        private final Converter<T, String> f12657b;

        /* renamed from: c */
        private final boolean f12658c;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C3193i(String str, Converter<T, String> converter, boolean z) {
            this.f12656a = (String) C3208o.m25a(str, "name == null");
            this.f12657b = converter;
            this.f12658c = z;
        }

        @Override // retrofit2.ParameterHandler
        /* renamed from: a */
        void mo94a(C3202k c3202k, @Nullable T t) throws IOException {
            String mo153a;
            if (t == null || (mo153a = this.f12657b.mo153a(t)) == null) {
                return;
            }
            c3202k.m78b(this.f12656a, mo153a, this.f12658c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ParameterHandler.java */
    /* renamed from: retrofit2.i$k */
    /* loaded from: classes2.dex */
    public static final class C3195k<T> extends ParameterHandler<T> {

        /* renamed from: a */
        private final Converter<T, String> f12661a;

        /* renamed from: b */
        private final boolean f12662b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C3195k(Converter<T, String> converter, boolean z) {
            this.f12661a = converter;
            this.f12662b = z;
        }

        @Override // retrofit2.ParameterHandler
        /* renamed from: a */
        void mo94a(C3202k c3202k, @Nullable T t) throws IOException {
            if (t == null) {
                return;
            }
            c3202k.m78b(this.f12661a.mo153a(t), null, this.f12662b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ParameterHandler.java */
    /* renamed from: retrofit2.i$j */
    /* loaded from: classes2.dex */
    public static final class C3194j<T> extends ParameterHandler<Map<String, T>> {

        /* renamed from: a */
        private final Converter<T, String> f12659a;

        /* renamed from: b */
        private final boolean f12660b;

        @Override // retrofit2.ParameterHandler
        /* renamed from: a */
        /* bridge */ /* synthetic */ void mo94a(C3202k c3202k, @Nullable Object obj) throws IOException {
            m96a(c3202k, (Map) ((Map) obj));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public C3194j(Converter<T, String> converter, boolean z) {
            this.f12659a = converter;
            this.f12660b = z;
        }

        /* renamed from: a */
        void m96a(C3202k c3202k, @Nullable Map<String, T> map) throws IOException {
            if (map == null) {
                throw new IllegalArgumentException("Query map was null.");
            }
            for (Map.Entry<String, T> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key == null) {
                    throw new IllegalArgumentException("Query map contained null key.");
                }
                T value = entry.getValue();
                if (value == null) {
                    throw new IllegalArgumentException("Query map contained null value for key '" + key + "'.");
                }
                String mo153a = this.f12659a.mo153a(value);
                if (mo153a == null) {
                    throw new IllegalArgumentException("Query map value '" + value + "' converted to null by " + this.f12659a.getClass().getName() + " for key '" + key + "'.");
                }
                c3202k.m78b(key, mo153a, this.f12660b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ParameterHandler.java */
    /* renamed from: retrofit2.i$e */
    /* loaded from: classes2.dex */
    public static final class C3189e<T> extends ParameterHandler<Map<String, T>> {

        /* renamed from: a */
        private final Converter<T, String> f12648a;

        @Override // retrofit2.ParameterHandler
        /* renamed from: a */
        /* bridge */ /* synthetic */ void mo94a(C3202k c3202k, @Nullable Object obj) throws IOException {
            m98a(c3202k, (Map) ((Map) obj));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public C3189e(Converter<T, String> converter) {
            this.f12648a = converter;
        }

        /* renamed from: a */
        void m98a(C3202k c3202k, @Nullable Map<String, T> map) throws IOException {
            if (map == null) {
                throw new IllegalArgumentException("Header map was null.");
            }
            for (Map.Entry<String, T> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key == null) {
                    throw new IllegalArgumentException("Header map contained null key.");
                }
                T value = entry.getValue();
                if (value == null) {
                    throw new IllegalArgumentException("Header map contained null value for key '" + key + "'.");
                }
                c3202k.m85a(key, this.f12648a.mo153a(value));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ParameterHandler.java */
    /* renamed from: retrofit2.i$b */
    /* loaded from: classes2.dex */
    public static final class C3186b<T> extends ParameterHandler<T> {

        /* renamed from: a */
        private final String f12641a;

        /* renamed from: b */
        private final Converter<T, String> f12642b;

        /* renamed from: c */
        private final boolean f12643c;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C3186b(String str, Converter<T, String> converter, boolean z) {
            this.f12641a = (String) C3208o.m25a(str, "name == null");
            this.f12642b = converter;
            this.f12643c = z;
        }

        @Override // retrofit2.ParameterHandler
        /* renamed from: a */
        void mo94a(C3202k c3202k, @Nullable T t) throws IOException {
            String mo153a;
            if (t == null || (mo153a = this.f12642b.mo153a(t)) == null) {
                return;
            }
            c3202k.m77c(this.f12641a, mo153a, this.f12643c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ParameterHandler.java */
    /* renamed from: retrofit2.i$c */
    /* loaded from: classes2.dex */
    public static final class C3187c<T> extends ParameterHandler<Map<String, T>> {

        /* renamed from: a */
        private final Converter<T, String> f12644a;

        /* renamed from: b */
        private final boolean f12645b;

        @Override // retrofit2.ParameterHandler
        /* renamed from: a */
        /* bridge */ /* synthetic */ void mo94a(C3202k c3202k, @Nullable Object obj) throws IOException {
            m99a(c3202k, (Map) ((Map) obj));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public C3187c(Converter<T, String> converter, boolean z) {
            this.f12644a = converter;
            this.f12645b = z;
        }

        /* renamed from: a */
        void m99a(C3202k c3202k, @Nullable Map<String, T> map) throws IOException {
            if (map == null) {
                throw new IllegalArgumentException("Field map was null.");
            }
            for (Map.Entry<String, T> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key == null) {
                    throw new IllegalArgumentException("Field map contained null key.");
                }
                T value = entry.getValue();
                if (value == null) {
                    throw new IllegalArgumentException("Field map contained null value for key '" + key + "'.");
                }
                String mo153a = this.f12644a.mo153a(value);
                if (mo153a == null) {
                    throw new IllegalArgumentException("Field map value '" + value + "' converted to null by " + this.f12644a.getClass().getName() + " for key '" + key + "'.");
                }
                c3202k.m77c(key, mo153a, this.f12645b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ParameterHandler.java */
    /* renamed from: retrofit2.i$f */
    /* loaded from: classes2.dex */
    public static final class C3190f<T> extends ParameterHandler<T> {

        /* renamed from: a */
        private final C2984s f12649a;

        /* renamed from: b */
        private final Converter<T, RequestBody> f12650b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C3190f(C2984s c2984s, Converter<T, RequestBody> converter) {
            this.f12649a = c2984s;
            this.f12650b = converter;
        }

        @Override // retrofit2.ParameterHandler
        /* renamed from: a */
        void mo94a(C3202k c3202k, @Nullable T t) {
            if (t == null) {
                return;
            }
            try {
                c3202k.m81a(this.f12649a, this.f12650b.mo153a(t));
            } catch (IOException e) {
                throw new RuntimeException("Unable to convert " + t + " to RequestBody", e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ParameterHandler.java */
    /* renamed from: retrofit2.i$l */
    /* loaded from: classes2.dex */
    public static final class C3196l extends ParameterHandler<MultipartBody.C2989b> {

        /* renamed from: a */
        static final C3196l f12663a = new C3196l();

        private C3196l() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // retrofit2.ParameterHandler
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public void mo94a(C3202k c3202k, @Nullable MultipartBody.C2989b c2989b) {
            if (c2989b != null) {
                c3202k.m80a(c2989b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ParameterHandler.java */
    /* renamed from: retrofit2.i$g */
    /* loaded from: classes2.dex */
    public static final class C3191g<T> extends ParameterHandler<Map<String, T>> {

        /* renamed from: a */
        private final Converter<T, RequestBody> f12651a;

        /* renamed from: b */
        private final String f12652b;

        @Override // retrofit2.ParameterHandler
        /* renamed from: a */
        /* bridge */ /* synthetic */ void mo94a(C3202k c3202k, @Nullable Object obj) throws IOException {
            m97a(c3202k, (Map) ((Map) obj));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public C3191g(Converter<T, RequestBody> converter, String str) {
            this.f12651a = converter;
            this.f12652b = str;
        }

        /* renamed from: a */
        void m97a(C3202k c3202k, @Nullable Map<String, T> map) throws IOException {
            if (map == null) {
                throw new IllegalArgumentException("Part map was null.");
            }
            for (Map.Entry<String, T> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key == null) {
                    throw new IllegalArgumentException("Part map contained null key.");
                }
                T value = entry.getValue();
                if (value == null) {
                    throw new IllegalArgumentException("Part map contained null value for key '" + key + "'.");
                }
                c3202k.m81a(C2984s.m2499a("Content-Disposition", "form-data; name=\"" + key + "\"", "Content-Transfer-Encoding", this.f12652b), this.f12651a.mo153a(value));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ParameterHandler.java */
    /* renamed from: retrofit2.i$a */
    /* loaded from: classes2.dex */
    public static final class C3185a<T> extends ParameterHandler<T> {

        /* renamed from: a */
        private final Converter<T, RequestBody> f12640a;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C3185a(Converter<T, RequestBody> converter) {
            this.f12640a = converter;
        }

        @Override // retrofit2.ParameterHandler
        /* renamed from: a */
        void mo94a(C3202k c3202k, @Nullable T t) {
            if (t == null) {
                throw new IllegalArgumentException("Body parameter value must not be null.");
            }
            try {
                c3202k.m82a(this.f12640a.mo153a(t));
            } catch (IOException e) {
                throw new RuntimeException("Unable to convert " + t + " to RequestBody", e);
            }
        }
    }
}
