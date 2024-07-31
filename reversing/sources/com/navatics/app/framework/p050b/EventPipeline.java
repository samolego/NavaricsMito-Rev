package com.navatics.app.framework.p050b;

import android.support.p008v4.view.InputDeviceCompat;
import android.util.SparseArray;
import com.navatics.app.framework.annotation.EventExecutorType;
import com.navatics.robot.transport.NvEvent;
import com.navatics.robot.transport.NvEventLoop;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.C3044k;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* renamed from: com.navatics.app.framework.b.l */
/* loaded from: classes.dex */
public class EventPipeline {

    /* renamed from: a */
    private static final C3044k f4264a = C3044k.m1564a(EventPipeline.class);

    /* renamed from: b */
    private SparseArray<List<C1751a>> f4265b = new SparseArray<>();

    /* renamed from: c */
    private SparseArray<List<C1751a>> f4266c = new SparseArray<>();

    /* renamed from: d */
    private SparseArray<EventHandlerValidator> f4267d = new SparseArray<>();

    /* renamed from: e */
    private SparseArray<EventTypeHandlerValidator> f4268e = new SparseArray<>();

    /* renamed from: f */
    private Map<Object, List<C1751a>> f4269f = new HashMap();

    /* renamed from: g */
    private SparseArray<C1752b> f4270g = new SparseArray<>();

    public static /* synthetic */ void lambda$Nu38jwcUkLxlKLMny6oAXvm2ADU(List list, C1751a c1751a) {
        list.remove(c1751a);
    }

    public static /* synthetic */ void lambda$WQdJ7bAivcRcdxBC4bizLWokjXY(EventPipeline eventPipeline, C1751a c1751a, Object[] objArr) {
        eventPipeline.m8572c(c1751a, objArr);
    }

    /* renamed from: lambda$ohqi6jk-GmhmjhyGeBM_AL4Z1VU */
    public static /* synthetic */ void m13058lambda$ohqi6jkGmhmjhyGeBM_AL4Z1VU(EventPipeline eventPipeline, C1751a c1751a, Object[] objArr) {
        eventPipeline.m8571d(c1751a, objArr);
    }

    /* compiled from: EventPipeline.java */
    /* renamed from: com.navatics.app.framework.b.l$b */
    /* loaded from: classes.dex */
    public static class C1752b {

        /* renamed from: a */
        int f4277a;

        /* renamed from: b */
        Object[] f4278b;

        public C1752b(int i, Object[] objArr) {
            this.f4277a = i;
            this.f4278b = objArr;
        }
    }

    /* compiled from: EventPipeline.java */
    /* renamed from: com.navatics.app.framework.b.l$a */
    /* loaded from: classes.dex */
    public static class C1751a {

        /* renamed from: a */
        Object f4271a;

        /* renamed from: b */
        Method f4272b;

        /* renamed from: c */
        int f4273c;

        /* renamed from: d */
        int f4274d;

        /* renamed from: e */
        Runnable f4275e;
        @EventExecutorType

        /* renamed from: f */
        int f4276f;

        public C1751a(Object obj, Method method, int i, int i2) {
            this.f4271a = obj;
            this.f4272b = method;
            this.f4273c = i;
            this.f4274d = i2;
            if (i != 0 && this.f4274d != 0) {
                throw new RuntimeException("event and eventType can't be unspecified at the same time");
            }
        }
    }

    public EventPipeline() {
        this.f4265b.put(65566, new ArrayList());
        this.f4265b.put(16711687, new ArrayList());
        this.f4265b.put(65547, new ArrayList());
        this.f4265b.put(65548, new ArrayList());
        this.f4265b.put(65546, new ArrayList());
        this.f4265b.put(65543, new ArrayList());
        this.f4265b.put(65567, new ArrayList());
        this.f4265b.put(16711688, new ArrayList());
        this.f4265b.put(65541, new ArrayList());
        this.f4265b.put(196610, new ArrayList());
        this.f4265b.put(16711689, new ArrayList());
        this.f4265b.put(65568, new ArrayList());
        this.f4265b.put(65545, new ArrayList());
        this.f4265b.put(65571, new ArrayList());
        this.f4265b.put(65570, new ArrayList());
        this.f4265b.put(65569, new ArrayList());
        this.f4265b.put(65549, new ArrayList());
        this.f4265b.put(InputDeviceCompat.SOURCE_TRACKBALL, new ArrayList());
        this.f4265b.put(65544, new ArrayList());
        this.f4265b.put(196609, new ArrayList());
        this.f4265b.put(IjkMediaPlayer.OnNativeInvokeListener.CTRL_WILL_HTTP_OPEN, new ArrayList());
        this.f4266c.put(255, new ArrayList());
        this.f4266c.put(1, new ArrayList());
        this.f4266c.put(2, new ArrayList());
        this.f4266c.put(3, new ArrayList());
        this.f4267d.put(65566, new GroundStationUnbindSuccessValidator());
        this.f4267d.put(16711687, new GroundStationUnbindErrorValidator());
        this.f4267d.put(65547, new GroundStationConnectedValidator());
        this.f4267d.put(65548, new GroundStationDisconnectedValidator());
        this.f4267d.put(65546, new GroundStationAuthSuccessValidator());
        this.f4267d.put(65543, new DeviceAuthSuccessValidator());
        this.f4267d.put(65567, new DeviceUnbindSuccessValidator());
        this.f4267d.put(16711688, new DeviceUnbindErrorValidator());
        this.f4267d.put(65541, new DeviceDisconnectedValidator());
        this.f4267d.put(196610, new CurConnectionChangedEventValidator());
        this.f4267d.put(16711689, new GroundStationInitFailedValidator());
        this.f4267d.put(65568, new GroundStationNewInstanceValidator());
        this.f4267d.put(65545, new GroundStationBindSuccessValidator());
        this.f4267d.put(65571, new SearchStateChangedValidator());
        this.f4267d.put(65570, new DeviceConnectingEventValidator());
        this.f4267d.put(65569, new DeviceNewInstanceEventValidator());
        this.f4267d.put(65549, new GroundStationDestroyedEventValidator());
        this.f4267d.put(InputDeviceCompat.SOURCE_TRACKBALL, new DeviceConnectedEventValidator());
        this.f4267d.put(65544, new DeviceBindSuccessValidator());
        this.f4267d.put(196609, new CurGroundStationChangedEventValidator());
        this.f4267d.put(IjkMediaPlayer.OnNativeInvokeListener.CTRL_WILL_HTTP_OPEN, new GroundStationStateUpdateEventValidator());
        this.f4268e.put(255, new EventTypeHandlerValidatorImpl());
        this.f4268e.put(1, new EventTypeHandlerValidatorImpl());
        this.f4268e.put(2, new EventTypeHandlerValidatorImpl());
        this.f4268e.put(3, new EventTypeHandlerValidatorImpl());
    }

    /* renamed from: a */
    public void m8581a(int i, Object... objArr) {
        List<C1751a> list = this.f4265b.get(i);
        if (list != null) {
            for (C1751a c1751a : list) {
                m8579a(c1751a, objArr);
            }
        }
        for (C1751a c1751a2 : this.f4266c.get(NvEvent.m6260a(i))) {
            m8579a(c1751a2, objArr);
        }
    }

    /* renamed from: a */
    private void m8579a(final C1751a c1751a, final Object... objArr) {
        switch (c1751a.f4276f) {
            case 1:
                NvEventLoop.m6231b().mo6286a(new Runnable() { // from class: com.navatics.app.framework.b.-$$Lambda$l$ohqi6jk-GmhmjhyGeBM_AL4Z1VU
                    @Override // java.lang.Runnable
                    public final void run() {
                        EventPipeline.m13058lambda$ohqi6jkGmhmjhyGeBM_AL4Z1VU(EventPipeline.this, c1751a, objArr);
                    }
                });
                return;
            case 2:
                NvEventLoop.m6232a().mo6286a(new Runnable() { // from class: com.navatics.app.framework.b.-$$Lambda$l$WQdJ7bAivcRcdxBC4bizLWokjXY
                    @Override // java.lang.Runnable
                    public final void run() {
                        EventPipeline.lambda$WQdJ7bAivcRcdxBC4bizLWokjXY(EventPipeline.this, c1751a, objArr);
                    }
                });
                return;
            default:
                m8571d(c1751a, objArr);
                return;
        }
    }

    /* renamed from: b */
    public void m8575b(int i, Object... objArr) {
        m8582a(i, true, objArr);
    }

    /* renamed from: a */
    public void m8582a(int i, boolean z, Object... objArr) {
        if (this.f4270g.get(i) != null && !z) {
            throw new RuntimeException("can't not override sticky event : " + i);
        }
        m8581a(i, objArr);
        this.f4270g.put(i, new C1752b(i, objArr));
    }

    /* renamed from: a */
    public void m8583a(int i) {
        this.f4270g.remove(i);
    }

    /* renamed from: b */
    public void m8571d(C1751a c1751a, Object... objArr) {
        try {
            if (!c1751a.f4272b.isAccessible()) {
                c1751a.f4272b.setAccessible(true);
            }
            c1751a.f4272b.invoke(c1751a.f4271a, objArr);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e2) {
            e2.printStackTrace();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    /* renamed from: a */
    private void m8580a(final C1751a c1751a, Object obj) {
        final List<C1751a> list;
        if (c1751a.f4273c != 0) {
            list = this.f4265b.get(c1751a.f4273c);
        } else {
            list = this.f4266c.get(c1751a.f4274d);
        }
        c1751a.f4275e = new Runnable() { // from class: com.navatics.app.framework.b.-$$Lambda$l$Nu38jwcUkLxlKLMny6oAXvm2ADU
            @Override // java.lang.Runnable
            public final void run() {
                EventPipeline.lambda$Nu38jwcUkLxlKLMny6oAXvm2ADU(list, c1751a);
            }
        };
        list.add(c1751a);
        List<C1751a> list2 = this.f4269f.get(obj);
        if (list2 == null) {
            list2 = new ArrayList<>();
            this.f4269f.put(obj, list2);
        }
        list2.add(c1751a);
        if (c1751a.f4274d != 0) {
            return;
        }
        if (c1751a.f4273c != 0) {
            C1752b c1752b = this.f4270g.get(c1751a.f4273c);
            if (c1752b != null) {
                m8579a(c1751a, c1752b.f4278b);
                return;
            }
            return;
        }
        int size = this.f4270g.size();
        for (int i = 0; i < size; i++) {
            C1752b valueAt = this.f4270g.valueAt(i);
            if (NvEvent.m6259a(valueAt.f4277a, c1751a.f4274d)) {
                m8579a(c1751a, valueAt.f4278b);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:67:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00a6  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m8578a(java.lang.Class r9, java.lang.Object r10) {
        /*
            r8 = this;
            java.lang.reflect.Method[] r0 = r9.getDeclaredMethods()
            int r1 = r0.length
            r2 = 0
        L6:
            if (r2 >= r1) goto Lcd
            r3 = r0[r2]
            java.lang.Class<com.navatics.app.framework.annotation.EventHandler> r4 = com.navatics.app.framework.annotation.EventHandler.class
            boolean r4 = r3.isAnnotationPresent(r4)
            if (r4 == 0) goto Lc9
            java.lang.Class<com.navatics.app.framework.annotation.EventHandler> r4 = com.navatics.app.framework.annotation.EventHandler.class
            java.lang.annotation.Annotation r4 = r3.getAnnotation(r4)
            com.navatics.app.framework.annotation.EventHandler r4 = (com.navatics.app.framework.annotation.EventHandler) r4
            int r5 = r4.m8586a()
            if (r5 == 0) goto L4b
            android.util.SparseArray<com.navatics.app.framework.b.m> r6 = r8.f4268e
            java.lang.Object r6 = r6.get(r5)
            com.navatics.app.framework.b.m r6 = (com.navatics.app.framework.p050b.EventTypeHandlerValidator) r6
            if (r6 != 0) goto L46
            org.apache.log4j.k r3 = com.navatics.app.framework.p050b.EventPipeline.f4264a
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "No validator for event "
            r5.append(r6)
            int r4 = r4.m8585b()
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            r3.mo1504b(r4)
            goto Lc9
        L46:
            com.navatics.app.framework.b.l$a r5 = r6.mo8570a(r10, r3, r5)
            goto L78
        L4b:
            android.util.SparseArray<com.navatics.app.framework.b.k> r5 = r8.f4267d
            int r6 = r4.m8585b()
            java.lang.Object r5 = r5.get(r6)
            com.navatics.app.framework.b.k r5 = (com.navatics.app.framework.p050b.EventHandlerValidator) r5
            if (r5 != 0) goto L74
            org.apache.log4j.k r3 = com.navatics.app.framework.p050b.EventPipeline.f4264a
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "No validator for event "
            r5.append(r6)
            int r4 = r4.m8585b()
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            r3.mo1504b(r4)
            goto Lc9
        L74:
            com.navatics.app.framework.b.l$a r5 = r5.mo8569a(r10, r3)
        L78:
            if (r5 != 0) goto La6
            org.apache.log4j.k r5 = com.navatics.app.framework.p050b.EventPipeline.f4264a
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "method :"
            r6.append(r7)
            java.lang.String r3 = r3.getName()
            r6.append(r3)
            java.lang.String r3 = " register for event "
            r6.append(r3)
            int r3 = r4.m8585b()
            r6.append(r3)
            java.lang.String r3 = " failed because of method validation failed"
            r6.append(r3)
            java.lang.String r3 = r6.toString()
            r5.mo1504b(r3)
            goto Lc9
        La6:
            int r3 = r4.m8584c()
            switch(r3) {
                case 0: goto Lc4;
                case 1: goto Lc4;
                case 2: goto Lc4;
                default: goto Lad;
            }
        Lad:
            org.apache.log4j.k r4 = com.navatics.app.framework.p050b.EventPipeline.f4264a
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "unknown executor type : "
            r5.append(r6)
            r5.append(r3)
            java.lang.String r3 = r5.toString()
            r4.mo1504b(r3)
            goto Lc9
        Lc4:
            r5.f4276f = r3
            r8.m8580a(r5, r10)
        Lc9:
            int r2 = r2 + 1
            goto L6
        Lcd:
            java.lang.Class r9 = r9.getSuperclass()
            java.lang.Class<android.app.Activity> r0 = android.app.Activity.class
            if (r9 == r0) goto Lec
            java.lang.Class<android.support.v7.app.AppCompatActivity> r0 = android.support.p011v7.app.AppCompatActivity.class
            if (r9 == r0) goto Lec
            java.lang.Class<android.support.v4.app.Fragment> r0 = android.support.p008v4.app.Fragment.class
            if (r9 == r0) goto Lec
            java.lang.Class<android.support.v4.app.FragmentActivity> r0 = android.support.p008v4.app.FragmentActivity.class
            if (r9 == r0) goto Lec
            java.lang.Class<java.lang.Object> r0 = java.lang.Object.class
            if (r9 == r0) goto Lec
            if (r9 != 0) goto Le8
            goto Lec
        Le8:
            r8.m8578a(r9, r10)
            return
        Lec:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.navatics.app.framework.p050b.EventPipeline.m8578a(java.lang.Class, java.lang.Object):void");
    }

    /* renamed from: a */
    public void m8577a(Object obj) {
        m8578a(obj.getClass(), obj);
    }

    /* renamed from: b */
    public void m8573b(Object obj) {
        List<C1751a> list = this.f4269f.get(obj);
        if (list != null) {
            for (C1751a c1751a : list) {
                c1751a.f4275e.run();
            }
        }
    }
}
