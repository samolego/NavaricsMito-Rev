package com.navatics.app.framework.p052d;

import android.util.Log;
import com.example.divelog.dao.entity.BaseDiveLogInfo;
import com.example.divelog.dao.entity.CommandCard;
import com.example.divelog.dao.entity.DiveLogItem;
import com.example.divelog.dao.p036a.BaseListener;
import com.example.divelog.dao.p036a.DivelogHelper;
import com.google.gson.Gson;
import com.navatics.app.framework.Navatics;
import com.navatics.app.framework.divelog.DiveLog;
import com.navatics.app.framework.divelog.DiveLogNetHelper;
import com.navatics.app.framework.divelog.DiveLog_;
import com.navatics.app.framework.divelog.LocalDiveLogRecord;
import com.navatics.app.framework.divelog.LocalDiveLogRecord_;
import com.navatics.app.framework.user.NvUser;
import com.navatics.app.framework.user.NvUserManager;
import io.objectbox.Box;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.p096b.Consumer;
import java.util.Map;

/* renamed from: com.navatics.app.framework.d.a */
/* loaded from: classes.dex */
public class DiveLogBuildHelper {
    /* renamed from: a */
    public static synchronized LocalDiveLogRecord m8551a(String str) {
        synchronized (DiveLogBuildHelper.class) {
            Box m3474d = Navatics.m7933f().m3474d(LocalDiveLogRecord.class);
            NvUser m7806d = NvUserManager.m7828b().m7806d();
            LocalDiveLogRecord localDiveLogRecord = (LocalDiveLogRecord) m3474d.m3416e().m3290a(LocalDiveLogRecord_.email, m7806d.getEmail()).m3290a(LocalDiveLogRecord_.startTime, str).m3288b().m3301d();
            if (localDiveLogRecord != null) {
                return localDiveLogRecord;
            }
            LocalDiveLogRecord localDiveLogRecord2 = new LocalDiveLogRecord();
            localDiveLogRecord2.m8498b(m7806d.getEmail());
            localDiveLogRecord2.m8502a(str);
            localDiveLogRecord2.m8495e();
            return localDiveLogRecord2;
        }
    }

    /* renamed from: b */
    public static void m8549b(String str) {
        DiveLog diveLog = (DiveLog) Navatics.m7933f().m3474d(DiveLog.class).m3416e().m3290a(DiveLog_.email, NvUserManager.m7828b().m7806d().getEmail()).m3291a(DiveLog_.startTime, Long.valueOf(str).longValue()).m3288b().m3301d();
        if (diveLog != null) {
            Log.i("info1", "deleteDiveLogByStartTime: delete ");
            diveLog.delete();
        }
    }

    /* renamed from: b */
    private static DivelogHelper m8550b(DiveLog diveLog) {
        NvUserManager m7828b = NvUserManager.m7828b();
        BaseDiveLogInfo buildBaseDiveLogInfo = diveLog.buildBaseDiveLogInfo();
        Map<String, DiveLogItem> buildDiveLogItems = diveLog.buildDiveLogItems();
        DivelogHelper divelogHelper = new DivelogHelper(buildBaseDiveLogInfo.getStartTime() + "", new DiveLogNetHelper(m7828b));
        divelogHelper.m11480a(buildBaseDiveLogInfo).m11474a(buildDiveLogItems);
        return divelogHelper;
    }

    /* renamed from: e */
    private static DivelogHelper m8546e(String str) {
        return new DivelogHelper(str, new DiveLogNetHelper(NvUserManager.m7828b()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public static synchronized DiveLog m8545f(String str) {
        DiveLog diveLog;
        synchronized (DiveLogBuildHelper.class) {
            diveLog = (DiveLog) Navatics.m7933f().m3474d(DiveLog.class).m3416e().m3290a(DiveLog_.email, NvUserManager.m7828b().m7806d().getEmail()).m3291a(DiveLog_.startTime, Long.valueOf(str).longValue()).m3288b().m3301d();
        }
        return diveLog;
    }

    /* renamed from: c */
    public static Observable<DiveLog> m8548c(final String str) {
        final DiveLog diveLog;
        final DivelogHelper m8550b;
        Log.i("info1", "synchronous: " + str);
        DiveLog m8545f = m8545f(str);
        final LocalDiveLogRecord m8551a = m8551a(str);
        if (m8545f == null) {
            m8550b = m8546e(str);
            diveLog = new DiveLog();
            diveLog.setStartTime(Long.valueOf(str).longValue());
            NvUser m7806d = NvUserManager.m7828b().m7806d();
            if (m7806d == null) {
                return Observable.m3087a((Throwable) new RuntimeException("user is not present"));
            }
            diveLog.setEmail(m7806d.getEmail());
        } else {
            diveLog = m8545f;
            m8550b = m8550b(m8545f);
        }
        m8550b.m11478a(m8551a.m8497c());
        return Observable.m3097a((ObservableOnSubscribe) new ObservableOnSubscribe<DiveLog>() { // from class: com.navatics.app.framework.d.a.1
            @Override // io.reactivex.ObservableOnSubscribe
            public void subscribe(final ObservableEmitter<DiveLog> observableEmitter) throws Exception {
                DivelogHelper.this.m11484a(new BaseListener() { // from class: com.navatics.app.framework.d.a.1.1
                    @Override // com.example.divelog.dao.p036a.BaseListener
                    /* renamed from: a */
                    public void mo8536a(CommandCard commandCard) {
                        m8551a.m8503a(commandCard);
                    }

                    @Override // com.example.divelog.dao.p036a.BaseListener
                    /* renamed from: a */
                    public void mo8537a(int i) {
                        m8551a.m8504a(i);
                    }

                    @Override // com.example.divelog.dao.p036a.BaseListener
                    /* renamed from: a */
                    public void mo8538a() {
                        m8551a.m8496d();
                    }

                    @Override // com.example.divelog.dao.p036a.BaseListener
                    /* renamed from: b */
                    public void mo8535b() {
                        if (DiveLogBuildHelper.m8545f(str) != null) {
                            observableEmitter.onNext(diveLog);
                        }
                        observableEmitter.onComplete();
                    }
                });
                DivelogHelper.this.setDataUpdateListener(new DivelogHelper.InterfaceC0813a() { // from class: com.navatics.app.framework.d.a.1.2
                    @Override // com.example.divelog.dao.p036a.DivelogHelper.InterfaceC0813a
                    /* renamed from: a */
                    public void mo8544a(BaseDiveLogInfo baseDiveLogInfo) {
                        new Gson();
                        diveLog.updateBaseInfo(baseDiveLogInfo);
                    }

                    @Override // com.example.divelog.dao.p036a.DivelogHelper.InterfaceC0813a
                    /* renamed from: a */
                    public void mo8542a(String str2, DiveLogItem diveLogItem) {
                        char c;
                        int hashCode = str2.hashCode();
                        if (hashCode == -423962367) {
                            if (str2.equals(CommandCard.ADD_ITEM)) {
                                c = 0;
                            }
                            c = 65535;
                        } else if (hashCode != 1060373799) {
                            if (hashCode == 1608750281 && str2.equals(CommandCard.UPDATE_ITEM)) {
                                c = 2;
                            }
                            c = 65535;
                        } else {
                            if (str2.equals(CommandCard.DELETE_ITEM)) {
                                c = 1;
                            }
                            c = 65535;
                        }
                        switch (c) {
                            case 0:
                                new Gson();
                                diveLog.addDiveLogDetail(diveLogItem);
                                return;
                            case 1:
                                diveLog.deleteDiveLogDetail(diveLogItem);
                                return;
                            case 2:
                                diveLog.updateDiveLogDetail(diveLogItem);
                                return;
                            default:
                                return;
                        }
                    }

                    @Override // com.example.divelog.dao.p036a.DivelogHelper.InterfaceC0813a
                    /* renamed from: a */
                    public void mo8543a(String str2) {
                        DiveLog m8545f2 = DiveLogBuildHelper.m8545f(str2);
                        if (m8545f2 != null) {
                            DiveLogBuildHelper.m8554a(m8545f2).m3069c(Observable.m3082b()).m3071c(new Consumer<Boolean>() { // from class: com.navatics.app.framework.d.a.1.2.1
                                @Override // io.reactivex.p096b.Consumer
                                /* renamed from: a */
                                public void accept(Boolean bool) throws Exception {
                                }
                            });
                        }
                    }

                    @Override // com.example.divelog.dao.p036a.DivelogHelper.InterfaceC0813a
                    /* renamed from: b */
                    public void mo8541b(String str2) {
                        DiveLogBuildHelper.m8549b(str2);
                    }

                    @Override // com.example.divelog.dao.p036a.DivelogHelper.InterfaceC0813a
                    /* renamed from: c */
                    public void mo8540c(String str2) {
                        diveLog.setFakeDelete(false);
                        diveLog.save();
                    }
                });
                DivelogHelper.this.m11483a(new DivelogHelper.InterfaceC0814b() { // from class: com.navatics.app.framework.d.a.1.3
                });
                try {
                    DivelogHelper.this.m11486a();
                } catch (Exception e) {
                    e.printStackTrace();
                    observableEmitter.onError(new Throwable("synchronous failed"));
                    observableEmitter.onComplete();
                }
            }
        });
    }

    /* renamed from: a */
    public static Observable<Boolean> m8554a(final DiveLog diveLog) {
        NvUserManager.m7828b().m7806d();
        final DivelogHelper m8550b = m8550b(diveLog);
        final LocalDiveLogRecord m8552a = m8552a(diveLog, m8550b.m11473b());
        m8550b.m11478a(m8552a.m8497c());
        return Observable.m3097a((ObservableOnSubscribe) new ObservableOnSubscribe<Boolean>() { // from class: com.navatics.app.framework.d.a.2
            @Override // io.reactivex.ObservableOnSubscribe
            public void subscribe(final ObservableEmitter<Boolean> observableEmitter) throws Exception {
                DivelogHelper.this.m11484a(new BaseListener() { // from class: com.navatics.app.framework.d.a.2.1
                    @Override // com.example.divelog.dao.p036a.BaseListener
                    /* renamed from: a */
                    public void mo8536a(CommandCard commandCard) {
                        m8552a.m8503a(commandCard);
                    }

                    @Override // com.example.divelog.dao.p036a.BaseListener
                    /* renamed from: a */
                    public void mo8537a(int i) {
                        m8552a.m8504a(i);
                    }

                    @Override // com.example.divelog.dao.p036a.BaseListener
                    /* renamed from: a */
                    public void mo8538a() {
                        m8552a.m8496d();
                    }

                    @Override // com.example.divelog.dao.p036a.BaseListener
                    /* renamed from: b */
                    public void mo8535b() {
                        diveLog.setStatus(2);
                        diveLog.save();
                        observableEmitter.onNext(true);
                        observableEmitter.onComplete();
                    }
                });
                try {
                    DivelogHelper.this.m11486a();
                } catch (Exception e) {
                    e.printStackTrace();
                    observableEmitter.onError(new Throwable("upload failed"));
                    observableEmitter.onComplete();
                }
            }
        });
    }

    /* renamed from: a */
    private static LocalDiveLogRecord m8552a(DiveLog diveLog, Map<String, DiveLogItem> map) {
        LocalDiveLogRecord m8551a = m8551a(diveLog.getStartTime() + "");
        m8551a.m8501a(diveLog.buildCommand(map));
        return m8551a;
    }

    /* renamed from: a */
    public static Observable<Boolean> m8553a(DiveLog diveLog, CommandCard commandCard) {
        final LocalDiveLogRecord m8551a = m8551a(diveLog.getStartTime() + "");
        commandCard.setVersion(m8551a.m8505a() + 1);
        m8551a.m8499b(commandCard);
        final DivelogHelper m8550b = m8550b(diveLog);
        m8550b.m11478a(m8551a.m8497c());
        return Observable.m3097a((ObservableOnSubscribe) new ObservableOnSubscribe<Boolean>() { // from class: com.navatics.app.framework.d.a.3
            @Override // io.reactivex.ObservableOnSubscribe
            public void subscribe(final ObservableEmitter<Boolean> observableEmitter) throws Exception {
                DivelogHelper.this.m11484a(new BaseListener() { // from class: com.navatics.app.framework.d.a.3.1
                    @Override // com.example.divelog.dao.p036a.BaseListener
                    /* renamed from: a */
                    public void mo8536a(CommandCard commandCard2) {
                        m8551a.m8503a(commandCard2);
                    }

                    @Override // com.example.divelog.dao.p036a.BaseListener
                    /* renamed from: a */
                    public void mo8537a(int i) {
                        m8551a.m8504a(i);
                    }

                    @Override // com.example.divelog.dao.p036a.BaseListener
                    /* renamed from: a */
                    public void mo8538a() {
                        m8551a.m8496d();
                    }

                    @Override // com.example.divelog.dao.p036a.BaseListener
                    /* renamed from: b */
                    public void mo8535b() {
                        observableEmitter.onNext(true);
                        observableEmitter.onComplete();
                    }
                });
                try {
                    DivelogHelper.this.m11486a();
                } catch (Exception e) {
                    e.printStackTrace();
                    observableEmitter.onError(new Throwable("synchronous failed"));
                }
            }
        });
    }
}
