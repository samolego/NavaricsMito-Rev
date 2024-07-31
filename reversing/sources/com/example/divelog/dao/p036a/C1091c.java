package com.example.divelog.dao.p036a;

import android.util.Log;
import com.example.divelog.dao.entity.BaseDiveLogInfo;
import com.example.divelog.dao.entity.CommandCard;
import com.example.divelog.dao.entity.DiveLogItem;
import com.example.divelog.dao.entity.LocalDiveLogRecordCard;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* renamed from: com.example.divelog.dao.a.c */
/* loaded from: classes.dex */
public class DivelogHelper<T extends CommandCard> {

    /* renamed from: b */
    public static String f1398b = "CLIENT: ";

    /* renamed from: e */
    private IDiveLogNetHelper f1402e;

    /* renamed from: g */
    private String f1404g;

    /* renamed from: j */
    private BaseListener f1407j;

    /* renamed from: k */
    private InterfaceC0813a f1408k;

    /* renamed from: l */
    private InterfaceC0814b f1409l;

    /* renamed from: c */
    private int f1400c = 3;

    /* renamed from: f */
    private Map<String, DiveLogItem> f1403f = new LinkedHashMap();

    /* renamed from: h */
    private int f1405h = 0;

    /* renamed from: i */
    private Executor f1406i = Executors.newSingleThreadExecutor();

    /* renamed from: d */
    private LocalDiveLogRecordCard f1401d = new LocalDiveLogRecordCard();

    /* renamed from: a */
    BaseDiveLogInfo f1399a = new BaseDiveLogInfo();

    /* compiled from: DivelogHelper.java */
    /* renamed from: com.example.divelog.dao.a.c$a */
    /* loaded from: classes.dex */
    public interface InterfaceC0813a {
        /* renamed from: a */
        void mo8544a(BaseDiveLogInfo baseDiveLogInfo);

        /* renamed from: a */
        void mo8543a(String str);

        /* renamed from: a */
        void mo8542a(String str, DiveLogItem diveLogItem);

        /* renamed from: b */
        void mo8541b(String str);

        /* renamed from: c */
        void mo8540c(String str);
    }

    /* compiled from: DivelogHelper.java */
    /* renamed from: com.example.divelog.dao.a.c$b */
    /* loaded from: classes.dex */
    public interface InterfaceC0814b {
    }

    public DivelogHelper(String str, IDiveLogNetHelper iDiveLogNetHelper) {
        this.f1404g = str;
        this.f1402e = iDiveLogNetHelper;
        this.f1401d.m11460a(0);
    }

    /* renamed from: a */
    public void m11484a(BaseListener baseListener) {
        this.f1407j = baseListener;
    }

    /* renamed from: a */
    public DivelogHelper m11480a(BaseDiveLogInfo baseDiveLogInfo) {
        this.f1399a = baseDiveLogInfo;
        return this;
    }

    /* renamed from: a */
    public DivelogHelper m11474a(Map<String, DiveLogItem> map) {
        this.f1403f = map;
        return this;
    }

    /* renamed from: a */
    public DivelogHelper m11478a(LocalDiveLogRecordCard localDiveLogRecordCard) {
        this.f1401d = localDiveLogRecordCard;
        return this;
    }

    /* renamed from: a */
    public void m11486a() throws IOException {
        this.f1406i.execute(new Runnable() { // from class: com.example.divelog.dao.a.c.1
            @Override // java.lang.Runnable
            public void run() {
                int i;
                try {
                    i = DivelogHelper.this.f1402e.mo8439a(DivelogHelper.this.f1404g);
                } catch (IOException e) {
                    e.printStackTrace();
                    i = 0;
                }
                if (i == DivelogHelper.this.f1401d.m11458b()) {
                    try {
                        DivelogHelper.this.m11466c(DivelogHelper.this.f1401d.m11461a());
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                } else if (i > DivelogHelper.this.f1401d.m11458b()) {
                    List<T> list = null;
                    boolean z = true;
                    while (z) {
                        try {
                            list = DivelogHelper.this.f1402e.mo8438a(DivelogHelper.this.f1404g, DivelogHelper.this.f1401d.m11458b());
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                        if (list != null && list.size() != 0) {
                            if (list.size() == 1 && list.get(0).getCommand().equals(CommandCard.DELETE)) {
                                z = false;
                            }
                            try {
                                if (DivelogHelper.this.m11475a(list) == -1) {
                                    z = false;
                                }
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            } catch (IllegalAccessException e5) {
                                e5.printStackTrace();
                            } catch (NoSuchFieldException e6) {
                                e6.printStackTrace();
                            }
                        }
                    }
                    try {
                        DivelogHelper.this.m11466c(DivelogHelper.this.f1401d.m11461a());
                    } catch (IOException e7) {
                        e7.printStackTrace();
                    }
                    DivelogHelper.this.f1407j.mo8535b();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public int m11475a(List<T> list) throws IOException, NoSuchFieldException, IllegalAccessException {
        if (list != null) {
            for (T t : list) {
                String command = t.getCommand();
                char c = 65535;
                switch (command.hashCode()) {
                    case -1785516855:
                        if (command.equals(CommandCard.UPDATE)) {
                            c = 3;
                            break;
                        }
                        break;
                    case -423962367:
                        if (command.equals(CommandCard.ADD_ITEM)) {
                            c = 2;
                            break;
                        }
                        break;
                    case 64641:
                        if (command.equals(CommandCard.ADD)) {
                            c = 1;
                            break;
                        }
                        break;
                    case 1060373799:
                        if (command.equals(CommandCard.DELETE_ITEM)) {
                            c = 6;
                            break;
                        }
                        break;
                    case 1608750281:
                        if (command.equals(CommandCard.UPDATE_ITEM)) {
                            c = 4;
                            break;
                        }
                        break;
                    case 1996002556:
                        if (command.equals(CommandCard.CREATE)) {
                            c = 0;
                            break;
                        }
                        break;
                    case 2012838315:
                        if (command.equals(CommandCard.DELETE)) {
                            c = 5;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        m11479a((DivelogHelper<T>) t);
                        break;
                    case 2:
                        m11479a((DivelogHelper<T>) t);
                        break;
                    case 3:
                        m11479a((DivelogHelper<T>) t);
                        break;
                    case 4:
                        m11479a((DivelogHelper<T>) t);
                        break;
                    case 5:
                        m11479a((DivelogHelper<T>) t);
                        break;
                    case 6:
                        m11479a((DivelogHelper<T>) t);
                        break;
                }
            }
        }
        return m11469b(list);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* renamed from: b */
    private int m11469b(List<T> list) throws NoSuchFieldException, IllegalAccessException {
        char c;
        if (this.f1408k == null) {
            return 0;
        }
        for (T t : list) {
            String command = t.getCommand();
            switch (command.hashCode()) {
                case -1785516855:
                    if (command.equals(CommandCard.UPDATE)) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case -1078216347:
                    if (command.equals(CommandCard.REUPLOAD_DIVELOG)) {
                        c = 7;
                        break;
                    }
                    c = 65535;
                    break;
                case -423962367:
                    if (command.equals(CommandCard.ADD_ITEM)) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 64641:
                    if (command.equals(CommandCard.ADD)) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 1060373799:
                    if (command.equals(CommandCard.DELETE_ITEM)) {
                        c = 6;
                        break;
                    }
                    c = 65535;
                    break;
                case 1063684525:
                    if (command.equals(CommandCard.REUPLOAD_DIVELOG_ITEM)) {
                        c = '\b';
                        break;
                    }
                    c = 65535;
                    break;
                case 1608750281:
                    if (command.equals(CommandCard.UPDATE_ITEM)) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case 1996002556:
                    if (command.equals(CommandCard.CREATE)) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case 2012838315:
                    if (command.equals(CommandCard.DELETE)) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            switch (c) {
                case 0:
                    this.f1399a = (BaseDiveLogInfo) new Gson().fromJson(t.getJson(), (Class<Object>) BaseDiveLogInfo.class);
                    this.f1408k.mo8544a(this.f1399a);
                    break;
                case 2:
                    DiveLogItem diveLogItem = (DiveLogItem) new Gson().fromJson(t.getJson(), (Class<Object>) DiveLogItem.class);
                    this.f1403f.put(t.getDetailIndex(), diveLogItem);
                    this.f1408k.mo8542a(t.getCommand(), diveLogItem);
                    break;
                case 3:
                    if ((this.f1399a.getStartTime() + "").endsWith(t.getStartTime())) {
                        try {
                            Field declaredField = this.f1399a.getClass().getDeclaredField(t.getFiledName());
                            declaredField.setAccessible(true);
                            String cls = declaredField.getType().toString();
                            if (cls.endsWith("String")) {
                                declaredField.set(this.f1399a, t.getJson());
                            } else {
                                if (!cls.endsWith("int") && !cls.endsWith("Integer")) {
                                    if (!cls.endsWith("long") && !cls.endsWith("Long")) {
                                        if (cls.endsWith("short") || cls.endsWith("Short")) {
                                            declaredField.set(this.f1399a, Short.valueOf(t.getJson()));
                                        }
                                    }
                                    declaredField.set(this.f1399a, Long.valueOf(t.getJson()));
                                }
                                declaredField.set(this.f1399a, Integer.valueOf(t.getJson()));
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        this.f1408k.mo8544a(this.f1399a);
                        break;
                    } else {
                        break;
                    }
                    break;
                case 4:
                    if (this.f1403f.containsKey(t.getDetailIndex())) {
                        DiveLogItem diveLogItem2 = this.f1403f.get(t.getDetailIndex());
                        Field declaredField2 = diveLogItem2.getClass().getDeclaredField(t.getFiledName());
                        declaredField2.setAccessible(true);
                        String cls2 = declaredField2.getType().toString();
                        if (cls2.endsWith("String")) {
                            declaredField2.set(diveLogItem2, t.getJson());
                        } else if (cls2.endsWith("int") || cls2.endsWith("Integer")) {
                            declaredField2.set(diveLogItem2, Integer.valueOf(t.getJson()));
                        } else if (cls2.endsWith("long") || cls2.endsWith("Long")) {
                            declaredField2.set(diveLogItem2, Long.valueOf(t.getJson()));
                        } else if (cls2.endsWith("short") || cls2.endsWith("Short")) {
                            declaredField2.set(diveLogItem2, Short.valueOf(t.getJson()));
                        }
                        this.f1408k.mo8542a(t.getCommand(), diveLogItem2);
                        break;
                    } else {
                        break;
                    }
                    break;
                case 5:
                    m11465d();
                    return -1;
                case 6:
                    if (this.f1403f.containsKey(t.getDetailIndex())) {
                        this.f1408k.mo8542a(t.getCommand(), this.f1403f.get(t.getDetailIndex()));
                        this.f1403f.remove(t.getDetailIndex());
                        break;
                    } else {
                        break;
                    }
                case 7:
                    try {
                        this.f1407j.mo8537a(t.getVersion());
                        m11485a(t.getVersion());
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                    return -1;
            }
            this.f1401d.m11460a(t.getVersion());
            this.f1407j.mo8537a(t.getVersion());
        }
        return 0;
    }

    public void setDataUpdateListener(InterfaceC0813a interfaceC0813a) {
        this.f1408k = interfaceC0813a;
    }

    /* renamed from: a */
    public void m11483a(InterfaceC0814b interfaceC0814b) {
        this.f1409l = interfaceC0814b;
    }

    /* renamed from: a */
    private int m11479a(T t) throws IOException {
        if (this.f1401d.m11461a() == null || this.f1401d.m11461a().size() < 1) {
            return 0;
        }
        ConflictHelper conflictHelper = new ConflictHelper();
        for (int size = this.f1401d.m11461a().size() - 1; size >= 0; size--) {
            conflictHelper.m11487a(t, this.f1401d.m11461a().get(size));
        }
        return 0;
    }

    /* renamed from: c */
    private void m11468c() {
        Collections.sort(this.f1401d.m11461a());
        HashMap hashMap = new HashMap();
        for (int size = this.f1401d.m11461a().size() - 1; size >= 0; size--) {
            T t = this.f1401d.m11461a().get(size);
            if (t.getCommand().equals(CommandCard.UPDATE) || t.getCommand().equals(CommandCard.UPDATE_ITEM)) {
                if (t.getCommand() == CommandCard.UPDATE_ITEM && m11476a(this.f1404g, t.getDetailIndex()) == null) {
                    this.f1401d.m11461a().remove(t);
                } else {
                    if (hashMap.containsKey(t.getCommand() + t.getFiledName())) {
                        this.f1401d.m11461a().remove(t);
                    } else {
                        hashMap.put(t.getCommand() + t.getFiledName(), "1");
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private void m11485a(int i) throws IOException {
        Log.i(f1398b, "uploadWholeDiveLog: ");
        this.f1401d.m11461a().clear();
        this.f1401d.m11460a(i);
        this.f1407j.mo8538a();
        InterfaceC0813a interfaceC0813a = this.f1408k;
        if (interfaceC0813a != null) {
            interfaceC0813a.mo8543a(this.f1399a.getStartTime() + "");
        }
    }

    /* renamed from: d */
    private void m11465d() {
        this.f1401d.m11461a().clear();
        InterfaceC0813a interfaceC0813a = this.f1408k;
        if (interfaceC0813a != null) {
            interfaceC0813a.mo8541b(this.f1404g);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: c */
    public int m11466c(List<T> list) throws IOException {
        char c;
        int intValue;
        if (list == null || list.size() < 1) {
            this.f1407j.mo8535b();
            return 0;
        }
        m11468c();
        ArrayList<CommandCard> arrayList = new ArrayList();
        for (T t : list) {
            arrayList.add(t);
        }
        for (CommandCard commandCard : arrayList) {
            String command = commandCard.getCommand();
            switch (command.hashCode()) {
                case -1785516855:
                    if (command.equals(CommandCard.UPDATE)) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case -1319431563:
                    if (command.equals(CommandCard.RESTRORE_DIVELOG)) {
                        c = '\b';
                        break;
                    }
                    c = 65535;
                    break;
                case -423962367:
                    if (command.equals(CommandCard.ADD_ITEM)) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 64641:
                    if (command.equals(CommandCard.ADD)) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 2401804:
                    if (command.equals(CommandCard.NODO)) {
                        c = 7;
                        break;
                    }
                    c = 65535;
                    break;
                case 1060373799:
                    if (command.equals(CommandCard.DELETE_ITEM)) {
                        c = 6;
                        break;
                    }
                    c = 65535;
                    break;
                case 1608750281:
                    if (command.equals(CommandCard.UPDATE_ITEM)) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case 1996002556:
                    if (command.equals(CommandCard.CREATE)) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case 2012838315:
                    if (command.equals(CommandCard.DELETE)) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            switch (c) {
                case 0:
                    BaseDiveLogInfo m11477a = m11477a(this.f1404g);
                    if (m11477a != null) {
                        m11470b("CREATE " + m11477a.getId());
                        intValue = this.f1402e.mo8441a(m11477a).intValue();
                        break;
                    } else {
                        continue;
                    }
                case 1:
                default:
                    intValue = -1;
                    break;
                case 2:
                    DiveLogItem m11476a = m11476a(this.f1404g, commandCard.getDetailIndex());
                    if (m11476a != null) {
                        m11470b("ADD_ITME " + m11476a.getIndex() + " " + m11476a.getWeather());
                        intValue = this.f1402e.mo8440a(m11476a, this.f1401d.m11458b()).intValue();
                        break;
                    } else {
                        continue;
                    }
                case 3:
                    String json = commandCard.getJson();
                    intValue = this.f1402e.mo8436a(this.f1399a.getStartTime() + "", commandCard.getFiledName(), (BaseDiveLogInfo) new Gson().fromJson(json, (Class<Object>) BaseDiveLogInfo.class), this.f1401d.m11458b()).intValue();
                    break;
                case 4:
                    String json2 = commandCard.getJson();
                    DiveLogItem diveLogItem = (DiveLogItem) new Gson().fromJson(json2, (Class<Object>) DiveLogItem.class);
                    m11470b("UPDATE_ITEM " + json2);
                    diveLogItem.setStartTime(commandCard.getStartTime());
                    diveLogItem.setIndex(commandCard.getDetailIndex());
                    intValue = this.f1402e.mo8435a(this.f1399a.getStartTime() + "", commandCard.getFiledName(), diveLogItem, this.f1401d.m11458b()).intValue();
                    break;
                case 5:
                    intValue = this.f1402e.mo8434b(this.f1404g, this.f1401d.m11458b()).intValue();
                    break;
                case 6:
                    m11470b("DELETE_ITEM " + commandCard.getDetailIndex());
                    intValue = this.f1402e.mo8437a(this.f1404g, commandCard.getDetailIndex(), this.f1401d.m11458b()).intValue();
                    break;
                case 7:
                    intValue = this.f1401d.m11458b();
                    break;
                case '\b':
                    intValue = this.f1401d.m11458b();
                    m11463e();
                    break;
            }
            if (intValue == -1) {
                return intValue;
            }
            if (intValue == -2 && this.f1409l != null) {
                this.f1400c--;
                return intValue;
            }
            this.f1401d.m11461a().remove(commandCard);
            this.f1401d.m11460a(intValue);
            this.f1407j.mo8536a((BaseListener) commandCard);
            this.f1407j.mo8537a(intValue);
        }
        this.f1407j.mo8535b();
        return 0;
    }

    /* renamed from: a */
    public DiveLogItem m11476a(String str, String str2) {
        return this.f1403f.get(str2);
    }

    /* renamed from: e */
    private void m11463e() {
        InterfaceC0813a interfaceC0813a = this.f1408k;
        if (interfaceC0813a != null) {
            interfaceC0813a.mo8540c(this.f1399a.getStartTime() + "");
        }
    }

    /* renamed from: a */
    public BaseDiveLogInfo m11477a(String str) {
        return this.f1399a;
    }

    /* renamed from: b */
    public Map<String, DiveLogItem> m11473b() {
        return this.f1403f;
    }

    /* renamed from: b */
    private void m11470b(String str) {
        PrintStream printStream = System.out;
        printStream.println(f1398b + str);
    }
}
