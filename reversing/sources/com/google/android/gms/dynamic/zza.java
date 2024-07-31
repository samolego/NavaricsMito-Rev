package com.google.android.gms.dynamic;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.zzi;
import com.google.android.gms.dynamic.LifecycleDelegate;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: classes.dex */
public abstract class zza<T extends LifecycleDelegate> {

    /* renamed from: Oi */
    private T f3038Oi;

    /* renamed from: Oj */
    private Bundle f3039Oj;

    /* renamed from: Ok */
    private LinkedList<InterfaceC3245zza> f3040Ok;

    /* renamed from: Ol */
    private final zzf<T> f3041Ol = (zzf<T>) new zzf<T>() { // from class: com.google.android.gms.dynamic.zza.1
        @Override // com.google.android.gms.dynamic.zzf
        public void zza(T t) {
            zza.this.f3038Oi = t;
            Iterator it = zza.this.f3040Ok.iterator();
            while (it.hasNext()) {
                ((InterfaceC3245zza) it.next()).zzb(zza.this.f3038Oi);
            }
            zza.this.f3040Ok.clear();
            zza.this.f3039Oj = null;
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.google.android.gms.dynamic.zza$zza  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC3245zza {
        int getState();

        void zzb(LifecycleDelegate lifecycleDelegate);
    }

    private void zza(Bundle bundle, InterfaceC3245zza interfaceC3245zza) {
        T t = this.f3038Oi;
        if (t != null) {
            interfaceC3245zza.zzb(t);
            return;
        }
        if (this.f3040Ok == null) {
            this.f3040Ok = new LinkedList<>();
        }
        this.f3040Ok.add(interfaceC3245zza);
        if (bundle != null) {
            Bundle bundle2 = this.f3039Oj;
            if (bundle2 == null) {
                this.f3039Oj = (Bundle) bundle.clone();
            } else {
                bundle2.putAll(bundle);
            }
        }
        zza(this.f3041Ol);
    }

    public static void zzb(FrameLayout frameLayout) {
        final Context context = frameLayout.getContext();
        final int isGooglePlayServicesAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(context);
        String zzi = zzi.zzi(context, isGooglePlayServicesAvailable);
        String zzk = zzi.zzk(context, isGooglePlayServicesAvailable);
        LinearLayout linearLayout = new LinearLayout(frameLayout.getContext());
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        frameLayout.addView(linearLayout);
        TextView textView = new TextView(frameLayout.getContext());
        textView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        textView.setText(zzi);
        linearLayout.addView(textView);
        if (zzk != null) {
            Button button = new Button(context);
            button.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            button.setText(zzk);
            linearLayout.addView(button);
            button.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.gms.dynamic.zza.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    context.startActivity(GooglePlayServicesUtil.zzfm(isGooglePlayServicesAvailable));
                }
            });
        }
    }

    private void zzno(int i) {
        while (!this.f3040Ok.isEmpty() && this.f3040Ok.getLast().getState() >= i) {
            this.f3040Ok.removeLast();
        }
    }

    public void onCreate(final Bundle bundle) {
        zza(bundle, new InterfaceC3245zza() { // from class: com.google.android.gms.dynamic.zza.3
            @Override // com.google.android.gms.dynamic.zza.InterfaceC3245zza
            public int getState() {
                return 1;
            }

            @Override // com.google.android.gms.dynamic.zza.InterfaceC3245zza
            public void zzb(LifecycleDelegate lifecycleDelegate) {
                zza.this.f3038Oi.onCreate(bundle);
            }
        });
    }

    public View onCreateView(final LayoutInflater layoutInflater, final ViewGroup viewGroup, final Bundle bundle) {
        final FrameLayout frameLayout = new FrameLayout(layoutInflater.getContext());
        zza(bundle, new InterfaceC3245zza() { // from class: com.google.android.gms.dynamic.zza.4
            @Override // com.google.android.gms.dynamic.zza.InterfaceC3245zza
            public int getState() {
                return 2;
            }

            @Override // com.google.android.gms.dynamic.zza.InterfaceC3245zza
            public void zzb(LifecycleDelegate lifecycleDelegate) {
                frameLayout.removeAllViews();
                frameLayout.addView(zza.this.f3038Oi.onCreateView(layoutInflater, viewGroup, bundle));
            }
        });
        if (this.f3038Oi == null) {
            zza(frameLayout);
        }
        return frameLayout;
    }

    public void onDestroy() {
        T t = this.f3038Oi;
        if (t != null) {
            t.onDestroy();
        } else {
            zzno(1);
        }
    }

    public void onDestroyView() {
        T t = this.f3038Oi;
        if (t != null) {
            t.onDestroyView();
        } else {
            zzno(2);
        }
    }

    public void onInflate(final Activity activity, final Bundle bundle, final Bundle bundle2) {
        zza(bundle2, new InterfaceC3245zza() { // from class: com.google.android.gms.dynamic.zza.2
            @Override // com.google.android.gms.dynamic.zza.InterfaceC3245zza
            public int getState() {
                return 0;
            }

            @Override // com.google.android.gms.dynamic.zza.InterfaceC3245zza
            public void zzb(LifecycleDelegate lifecycleDelegate) {
                zza.this.f3038Oi.onInflate(activity, bundle, bundle2);
            }
        });
    }

    public void onLowMemory() {
        T t = this.f3038Oi;
        if (t != null) {
            t.onLowMemory();
        }
    }

    public void onPause() {
        T t = this.f3038Oi;
        if (t != null) {
            t.onPause();
        } else {
            zzno(5);
        }
    }

    public void onResume() {
        zza((Bundle) null, new InterfaceC3245zza() { // from class: com.google.android.gms.dynamic.zza.7
            @Override // com.google.android.gms.dynamic.zza.InterfaceC3245zza
            public int getState() {
                return 5;
            }

            @Override // com.google.android.gms.dynamic.zza.InterfaceC3245zza
            public void zzb(LifecycleDelegate lifecycleDelegate) {
                zza.this.f3038Oi.onResume();
            }
        });
    }

    public void onSaveInstanceState(Bundle bundle) {
        T t = this.f3038Oi;
        if (t != null) {
            t.onSaveInstanceState(bundle);
            return;
        }
        Bundle bundle2 = this.f3039Oj;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
    }

    public void onStart() {
        zza((Bundle) null, new InterfaceC3245zza() { // from class: com.google.android.gms.dynamic.zza.6
            @Override // com.google.android.gms.dynamic.zza.InterfaceC3245zza
            public int getState() {
                return 4;
            }

            @Override // com.google.android.gms.dynamic.zza.InterfaceC3245zza
            public void zzb(LifecycleDelegate lifecycleDelegate) {
                zza.this.f3038Oi.onStart();
            }
        });
    }

    public void onStop() {
        T t = this.f3038Oi;
        if (t != null) {
            t.onStop();
        } else {
            zzno(4);
        }
    }

    protected void zza(FrameLayout frameLayout) {
        zzb(frameLayout);
    }

    protected abstract void zza(zzf<T> zzfVar);

    public T zzbdt() {
        return this.f3038Oi;
    }
}
