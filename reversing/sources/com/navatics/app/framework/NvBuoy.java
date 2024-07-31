package com.navatics.app.framework;

import android.support.annotation.NonNull;
import android.support.p008v4.app.FragmentTransaction;
import com.navatics.app.framework.NvBuoy;
import com.navatics.robot.transport.NvCallback;
import com.navatics.robot.transport.NvSocket;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.p096b.Cancellable;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.C3044k;

/* renamed from: com.navatics.app.framework.q */
/* loaded from: classes.dex */
public class NvBuoy extends NvDevice implements NvCallback<BuoyStatus> {

    /* renamed from: a */
    private static final C3044k f4776a = C3044k.m1564a(NvBuoy.class);

    /* renamed from: b */
    private INvBuoyAdapter f4777b;

    /* renamed from: c */
    private BuoyStatus f4778c;

    /* renamed from: d */
    private List<BuoyStateHandler> f4779d;

    public NvBuoy(@NonNull NvSocket nvSocket, @NonNull INvBuoyAdapter iNvBuoyAdapter) {
        super(nvSocket, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        this.f4779d = new ArrayList();
        this.f4777b = iNvBuoyAdapter;
        this.f4777b.mo8050a(this);
    }

    /* renamed from: a */
    public BuoyStatus m7907a() {
        return this.f4778c;
    }

    @Override // com.navatics.robot.transport.NvCallback
    /* renamed from: a */
    public void mo6276a(BuoyStatus buoyStatus) {
        this.f4778c = buoyStatus;
        m7901b(buoyStatus);
    }

    /* compiled from: NvBuoy.java */
    /* renamed from: com.navatics.app.framework.q$1 */
    /* loaded from: classes.dex */
    public class C18451 implements ObservableOnSubscribe<BuoyStatus> {
        /* renamed from: lambda$8OzDL0p16-rzPPJ7COoyM78vPFc */
        public static /* synthetic */ void m13073lambda$8OzDL0p16rzPPJ7COoyM78vPFc(C18451 c18451, BuoyStateHandler buoyStateHandler) {
            c18451.m7900a(buoyStateHandler);
        }

        C18451() {
            NvBuoy.this = r1;
        }

        @Override // io.reactivex.ObservableOnSubscribe
        public void subscribe(final ObservableEmitter<BuoyStatus> observableEmitter) throws Exception {
            if (NvBuoy.this.f4778c != null) {
                observableEmitter.onNext(NvBuoy.this.f4778c);
            }
            observableEmitter.getClass();
            final BuoyStateHandler buoyStateHandler = new BuoyStateHandler() { // from class: com.navatics.app.framework.-$$Lambda$vSROZ14rfQZOOS9hFDMirB3UuqY
                @Override // com.navatics.app.framework.BuoyStateHandler
                public final void onBuoyStateUpdate(BuoyStatus buoyStatus) {
                    ObservableEmitter.this.onNext(buoyStatus);
                }
            };
            NvBuoy.this.m7906a(buoyStateHandler);
            observableEmitter.setCancellable(new Cancellable() { // from class: com.navatics.app.framework.-$$Lambda$q$1$8OzDL0p16-rzPPJ7COoyM78vPFc
                @Override // io.reactivex.p096b.Cancellable
                public final void cancel() {
                    NvBuoy.C18451.m13073lambda$8OzDL0p16rzPPJ7COoyM78vPFc(NvBuoy.C18451.this, buoyStateHandler);
                }
            });
        }

        /* renamed from: a */
        public /* synthetic */ void m7900a(BuoyStateHandler buoyStateHandler) throws Exception {
            NvBuoy.this.m7902b(buoyStateHandler);
        }
    }

    /* renamed from: b */
    public Observable<BuoyStatus> m7903b() {
        return Observable.m3097a((ObservableOnSubscribe) new C18451());
    }

    /* renamed from: a */
    public void m7906a(BuoyStateHandler buoyStateHandler) {
        if (buoyStateHandler != null) {
            this.f4779d.add(buoyStateHandler);
        }
    }

    /* renamed from: b */
    public void m7902b(BuoyStateHandler buoyStateHandler) {
        this.f4779d.remove(buoyStateHandler);
    }

    /* renamed from: b */
    private void m7901b(BuoyStatus buoyStatus) {
        for (BuoyStateHandler buoyStateHandler : this.f4779d) {
            buoyStateHandler.onBuoyStateUpdate(buoyStatus);
        }
    }
}
