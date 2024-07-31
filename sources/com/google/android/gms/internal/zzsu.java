package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.internal.zzsv;
import java.lang.reflect.Field;

/* loaded from: classes.dex */
public final class zzsu {

    /* renamed from: Ow */
    private static zzsv f3364Ow;

    /* renamed from: OD */
    private final Context f3368OD;

    /* renamed from: Ox */
    private static final zzb.zza f3365Ox = new zzb.zza() { // from class: com.google.android.gms.internal.zzsu.1
        @Override // com.google.android.gms.internal.zzsu.zzb.zza
        public int zzaa(Context context, String str) {
            return zzsu.zzaa(context, str);
        }

        @Override // com.google.android.gms.internal.zzsu.zzb.zza
        public int zzc(Context context, String str, boolean z) {
            return zzsu.zzc(context, str, z);
        }
    };

    /* renamed from: Oy */
    public static final zzb f3366Oy = new zzb() { // from class: com.google.android.gms.internal.zzsu.2
        @Override // com.google.android.gms.internal.zzsu.zzb
        public zzb.C3258zzb zza(Context context, String str, zzb.zza zzaVar) {
            zzb.C3258zzb c3258zzb = new zzb.C3258zzb();
            c3258zzb.f3371OG = zzaVar.zzc(context, str, true);
            if (c3258zzb.f3371OG != 0) {
                c3258zzb.f3372OH = 1;
            } else {
                c3258zzb.f3370OF = zzaVar.zzaa(context, str);
                if (c3258zzb.f3370OF != 0) {
                    c3258zzb.f3372OH = -1;
                }
            }
            return c3258zzb;
        }
    };

    /* renamed from: Oz */
    public static final zzb f3367Oz = new zzb() { // from class: com.google.android.gms.internal.zzsu.3
        @Override // com.google.android.gms.internal.zzsu.zzb
        public zzb.C3258zzb zza(Context context, String str, zzb.zza zzaVar) {
            zzb.C3258zzb c3258zzb = new zzb.C3258zzb();
            c3258zzb.f3370OF = zzaVar.zzaa(context, str);
            if (c3258zzb.f3370OF != 0) {
                c3258zzb.f3372OH = -1;
            } else {
                c3258zzb.f3371OG = zzaVar.zzc(context, str, true);
                if (c3258zzb.f3371OG != 0) {
                    c3258zzb.f3372OH = 1;
                }
            }
            return c3258zzb;
        }
    };

    /* renamed from: OA */
    public static final zzb f3361OA = new zzb() { // from class: com.google.android.gms.internal.zzsu.4
        @Override // com.google.android.gms.internal.zzsu.zzb
        public zzb.C3258zzb zza(Context context, String str, zzb.zza zzaVar) {
            int i;
            zzb.C3258zzb c3258zzb = new zzb.C3258zzb();
            c3258zzb.f3370OF = zzaVar.zzaa(context, str);
            c3258zzb.f3371OG = zzaVar.zzc(context, str, true);
            if (c3258zzb.f3370OF == 0 && c3258zzb.f3371OG == 0) {
                i = 0;
            } else if (c3258zzb.f3370OF < c3258zzb.f3371OG) {
                c3258zzb.f3372OH = 1;
                return c3258zzb;
            } else {
                i = -1;
            }
            c3258zzb.f3372OH = i;
            return c3258zzb;
        }
    };

    /* renamed from: OB */
    public static final zzb f3362OB = new zzb() { // from class: com.google.android.gms.internal.zzsu.5
        @Override // com.google.android.gms.internal.zzsu.zzb
        public zzb.C3258zzb zza(Context context, String str, zzb.zza zzaVar) {
            int i;
            zzb.C3258zzb c3258zzb = new zzb.C3258zzb();
            c3258zzb.f3370OF = zzaVar.zzaa(context, str);
            c3258zzb.f3371OG = zzaVar.zzc(context, str, true);
            if (c3258zzb.f3370OF == 0 && c3258zzb.f3371OG == 0) {
                i = 0;
            } else if (c3258zzb.f3371OG >= c3258zzb.f3370OF) {
                c3258zzb.f3372OH = 1;
                return c3258zzb;
            } else {
                i = -1;
            }
            c3258zzb.f3372OH = i;
            return c3258zzb;
        }
    };

    /* renamed from: OC */
    public static final zzb f3363OC = new zzb() { // from class: com.google.android.gms.internal.zzsu.6
        @Override // com.google.android.gms.internal.zzsu.zzb
        public zzb.C3258zzb zza(Context context, String str, zzb.zza zzaVar) {
            zzb.C3258zzb c3258zzb = new zzb.C3258zzb();
            c3258zzb.f3370OF = zzaVar.zzaa(context, str);
            c3258zzb.f3371OG = c3258zzb.f3370OF != 0 ? zzaVar.zzc(context, str, false) : zzaVar.zzc(context, str, true);
            if (c3258zzb.f3370OF == 0 && c3258zzb.f3371OG == 0) {
                c3258zzb.f3372OH = 0;
            } else if (c3258zzb.f3371OG >= c3258zzb.f3370OF) {
                c3258zzb.f3372OH = 1;
            } else {
                c3258zzb.f3372OH = -1;
            }
            return c3258zzb;
        }
    };

    /* loaded from: classes.dex */
    public static class zza extends Exception {
        private zza(String str) {
            super(str);
        }

        private zza(String str, Throwable th) {
            super(str, th);
        }
    }

    /* loaded from: classes.dex */
    public interface zzb {

        /* loaded from: classes.dex */
        public interface zza {
            int zzaa(Context context, String str);

            int zzc(Context context, String str, boolean z);
        }

        /* renamed from: com.google.android.gms.internal.zzsu$zzb$zzb  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C3258zzb {

            /* renamed from: OF */
            public int f3370OF = 0;

            /* renamed from: OG */
            public int f3371OG = 0;

            /* renamed from: OH */
            public int f3372OH = 0;
        }

        C3258zzb zza(Context context, String str, zza zzaVar);
    }

    private zzsu(Context context) {
        this.f3368OD = (Context) com.google.android.gms.common.internal.zzac.zzy(context);
    }

    public static zzsu zza(Context context, zzb zzbVar, String str) throws zza {
        zzb.C3258zzb zza2 = zzbVar.zza(context, str, f3365Ox);
        int i = zza2.f3370OF;
        int i2 = zza2.f3371OG;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 68 + String.valueOf(str).length());
        sb.append("Considering local module ");
        sb.append(str);
        sb.append(":");
        sb.append(i);
        sb.append(" and remote module ");
        sb.append(str);
        sb.append(":");
        sb.append(i2);
        Log.i("DynamiteModule", sb.toString());
        if (zza2.f3372OH == 0 || ((zza2.f3372OH == -1 && zza2.f3370OF == 0) || (zza2.f3372OH == 1 && zza2.f3371OG == 0))) {
            int i3 = zza2.f3370OF;
            int i4 = zza2.f3371OG;
            StringBuilder sb2 = new StringBuilder(91);
            sb2.append("No acceptable module found. Local version is ");
            sb2.append(i3);
            sb2.append(" and remote version is ");
            sb2.append(i4);
            sb2.append(".");
            throw new zza(sb2.toString());
        } else if (zza2.f3372OH == -1) {
            return zzac(context, str);
        } else {
            if (zza2.f3372OH != 1) {
                int i5 = zza2.f3372OH;
                StringBuilder sb3 = new StringBuilder(47);
                sb3.append("VersionPolicy returned invalid code:");
                sb3.append(i5);
                throw new zza(sb3.toString());
            }
            try {
                return zza(context, str, zza2.f3371OG);
            } catch (zza e) {
                String valueOf = String.valueOf(e.getMessage());
                Log.w("DynamiteModule", valueOf.length() != 0 ? "Failed to load remote module: ".concat(valueOf) : new String("Failed to load remote module: "));
                if (zza2.f3370OF != 0) {
                    final int i6 = zza2.f3370OF;
                    if (zzbVar.zza(context, str, new zzb.zza() { // from class: com.google.android.gms.internal.zzsu.7
                        @Override // com.google.android.gms.internal.zzsu.zzb.zza
                        public int zzaa(Context context2, String str2) {
                            return i6;
                        }

                        @Override // com.google.android.gms.internal.zzsu.zzb.zza
                        public int zzc(Context context2, String str2, boolean z) {
                            return 0;
                        }
                    }).f3372OH == -1) {
                        return zzac(context, str);
                    }
                }
                throw new zza("Remote load failed. No local fallback found.", e);
            }
        }
    }

    private static zzsu zza(Context context, String str, int i) throws zza {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 51);
        sb.append("Selected remote version of ");
        sb.append(str);
        sb.append(", version >= ");
        sb.append(i);
        Log.i("DynamiteModule", sb.toString());
        zzsv zzcv = zzcv(context);
        if (zzcv != null) {
            try {
                com.google.android.gms.dynamic.zzd zza2 = zzcv.zza(com.google.android.gms.dynamic.zze.zzac(context), str, i);
                if (com.google.android.gms.dynamic.zze.zzae(zza2) != null) {
                    return new zzsu((Context) com.google.android.gms.dynamic.zze.zzae(zza2));
                }
                throw new zza("Failed to load remote module.");
            } catch (RemoteException e) {
                throw new zza("Failed to load remote module.", e);
            }
        }
        throw new zza("Failed to create IDynamiteLoader.");
    }

    public static int zzaa(Context context, String str) {
        try {
            ClassLoader classLoader = context.getApplicationContext().getClassLoader();
            String valueOf = String.valueOf("com.google.android.gms.dynamite.descriptors.");
            String valueOf2 = String.valueOf("ModuleDescriptor");
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 1 + String.valueOf(str).length() + String.valueOf(valueOf2).length());
            sb.append(valueOf);
            sb.append(str);
            sb.append(".");
            sb.append(valueOf2);
            Class<?> loadClass = classLoader.loadClass(sb.toString());
            Field declaredField = loadClass.getDeclaredField("MODULE_ID");
            Field declaredField2 = loadClass.getDeclaredField("MODULE_VERSION");
            if (declaredField.get(null).equals(str)) {
                return declaredField2.getInt(null);
            }
            String valueOf3 = String.valueOf(declaredField.get(null));
            StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf3).length() + 51 + String.valueOf(str).length());
            sb2.append("Module descriptor id '");
            sb2.append(valueOf3);
            sb2.append("' didn't match expected id '");
            sb2.append(str);
            sb2.append("'");
            Log.e("DynamiteModule", sb2.toString());
            return 0;
        } catch (ClassNotFoundException unused) {
            StringBuilder sb3 = new StringBuilder(String.valueOf(str).length() + 45);
            sb3.append("Local module descriptor class for ");
            sb3.append(str);
            sb3.append(" not found.");
            Log.w("DynamiteModule", sb3.toString());
            return 0;
        } catch (Exception e) {
            String valueOf4 = String.valueOf(e.getMessage());
            Log.e("DynamiteModule", valueOf4.length() != 0 ? "Failed to load module descriptor class: ".concat(valueOf4) : new String("Failed to load module descriptor class: "));
            return 0;
        }
    }

    public static int zzab(Context context, String str) {
        return zzc(context, str, false);
    }

    private static zzsu zzac(Context context, String str) {
        String valueOf = String.valueOf(str);
        Log.i("DynamiteModule", valueOf.length() != 0 ? "Selected local version of ".concat(valueOf) : new String("Selected local version of "));
        return new zzsu(context.getApplicationContext());
    }

    public static int zzc(Context context, String str, boolean z) {
        zzsv zzcv = zzcv(context);
        if (zzcv == null) {
            return 0;
        }
        try {
            return zzcv.zza(com.google.android.gms.dynamic.zze.zzac(context), str, z);
        } catch (RemoteException e) {
            String valueOf = String.valueOf(e.getMessage());
            Log.w("DynamiteModule", valueOf.length() != 0 ? "Failed to retrieve remote module version: ".concat(valueOf) : new String("Failed to retrieve remote module version: "));
            return 0;
        }
    }

    private static zzsv zzcv(Context context) {
        synchronized (zzsu.class) {
            if (f3364Ow != null) {
                return f3364Ow;
            } else if (com.google.android.gms.common.zzc.zzapd().isGooglePlayServicesAvailable(context) != 0) {
                return null;
            } else {
                try {
                    zzsv zzff = zzsv.zza.zzff((IBinder) context.createPackageContext("com.google.android.gms", 3).getClassLoader().loadClass("com.google.android.gms.chimera.container.DynamiteLoaderImpl").newInstance());
                    if (zzff != null) {
                        f3364Ow = zzff;
                        return zzff;
                    }
                } catch (Exception e) {
                    String valueOf = String.valueOf(e.getMessage());
                    Log.e("DynamiteModule", valueOf.length() != 0 ? "Failed to load IDynamiteLoader from GmsCore: ".concat(valueOf) : new String("Failed to load IDynamiteLoader from GmsCore: "));
                }
                return null;
            }
        }
    }

    public Context zzbdy() {
        return this.f3368OD;
    }

    public IBinder zzjd(String str) throws zza {
        try {
            return (IBinder) this.f3368OD.getClassLoader().loadClass(str).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            String valueOf = String.valueOf(str);
            throw new zza(valueOf.length() != 0 ? "Failed to instantiate module class: ".concat(valueOf) : new String("Failed to instantiate module class: "), e);
        }
    }
}
