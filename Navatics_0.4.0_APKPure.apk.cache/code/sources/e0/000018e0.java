package com.navatics.app.framework;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v4.view.InputDeviceCompat;
import com.navatics.app.framework.annotation.SearchState;
import com.navatics.app.framework.p044b.EventPipeline;
import com.navatics.app.framework.user.NvUser;
import com.navatics.app.framework.user.NvUserManager;
import com.navatics.app.framework.user.SSUsrInfo;
import com.navatics.robot.transport.INvGroundStation;
import com.navatics.robot.transport.KeyMapProvider;
import com.navatics.robot.transport.NvBatteryInfo;
import com.navatics.robot.transport.NvDeviceInfo;
import com.navatics.robot.transport.NvError;
import com.navatics.robot.transport.NvEvent;
import com.navatics.robot.transport.NvEventHandler;
import com.navatics.robot.transport.NvSocket;
import com.navatics.robot.transport.p056b.NvAction;
import com.navatics.robot.utils.StringUtils;
import com.navatics.xlog.WLog;
import com.takisoft.fix.support.p059v7.preference.PreferenceFragmentCompatDividers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.apache.log4j.Logger;

/* compiled from: GroundStation.java */
/* renamed from: com.navatics.app.framework.g, reason: use source file name */
/* loaded from: classes.dex */
public class GroundStation implements NvEventHandler {

    /* renamed from: a */
    private static final String f4671a = "g";

    /* renamed from: b */
    private static final Logger logger = Logger.getLogger(GroundStation.class);

    /* renamed from: c */
    private INvGroundStation iNvGroundStation;

    /* renamed from: d */
    private NvUser user;

    /* renamed from: f */
    private int state;

    /* renamed from: h */
    private NvConnection connection;

    /* renamed from: r */
    private EventPipeline eventPipeline;

    /* renamed from: s */
    private boolean enableAuth;

    /* renamed from: t */
    private boolean controllerAutoLogin;

    /* renamed from: u */
    private boolean rollerAutoLogin;

    /* renamed from: v */
    private boolean enableAutoConn;

    /* renamed from: e */
    private GroundStationStatus groundStationStatus = new GroundStationStatus(this);

    /* renamed from: g */
    private NvBatteryInfo batteryInfo = new NvBatteryInfo();

    /* renamed from: i */
    private List<NvConnection> nvConnections = new ArrayList();

    /* renamed from: j */
    private HashMap<NvSocket, NvConnection> socket2connectionMap = new HashMap<>();

    /* renamed from: k */
    private List<NvGroundStationHandler> groundStationHandlers = new CopyOnWriteArrayList();

    /* renamed from: l */
    private HashMap<String, NvDeviceEntry> serialNumber2deviceEntryMap = new HashMap<>();

    /* renamed from: m */
    private List<NvDeviceEntry> deviceEntries1 = new ArrayList();

    /* renamed from: n */
    private List<NvDeviceEntry> deviceEntries2 = new ArrayList();

    /* renamed from: o */
    private List<NvDeviceEntry> deviceEntries3 = new ArrayList();

    /* renamed from: p */
    private List<GroundStationDeviceItemUpdateHandler> itemUpdateHandlers = new ArrayList();

    /* renamed from: q */
    @SearchState
    private int f4687q = 2;

    /* renamed from: n */
    public void m4886n() {
    }

    /* renamed from: o */
    public void m4887o() {
    }

    public GroundStation(INvGroundStation iNvGroundStation) {
        this.iNvGroundStation = iNvGroundStation;
        this.iNvGroundStation.mo6591a(this);
        this.state = 0;
        this.eventPipeline = new EventPipeline();
        setup();
    }

    /* renamed from: a */
    public EventPipeline getEventPipeline() {
        return this.eventPipeline;
    }

    /* renamed from: v */
    private void setup() {
        Context context = Navatics.getContext();
        SharedPreferences sharedPreferences = context.getSharedPreferences("developer_setting", 0);
        this.enableAuth = sharedPreferences.getBoolean("enableAuth", context.getResources().getBoolean(R.bool.enable_auth));
        this.controllerAutoLogin = sharedPreferences.getBoolean("controllerAutoLogin", context.getResources().getBoolean(R.bool.controller_auto_login));
        this.rollerAutoLogin = sharedPreferences.getBoolean("rollerAutoLogin", context.getResources().getBoolean(R.bool.roller_auto_login));
        this.enableAutoConn = sharedPreferences.getBoolean("enableAutoConn", context.getResources().getBoolean(R.bool.enable_auto_connect));
    }

    @NonNull
    public String toString() {
        return "GroundStation[id=" + this.iNvGroundStation.getId() + "]";
    }

    /* renamed from: b */
    public long getRemoteId() {
        return this.iNvGroundStation.getId();
    }

    /* renamed from: c */
    public boolean isControllerAuthed() {
        return this.iNvGroundStation.isControllerAuthed();
    }

    /* renamed from: d */
    public boolean isRemoteBinded() {
        return this.iNvGroundStation.isRemoteBinded();
    }

    /* renamed from: e */
    public boolean isValid() {
        return this.iNvGroundStation.isValid();
    }

    /* renamed from: a */
    public void loginToController(Map<String, Object> properties) {
        this.iNvGroundStation.tryLoginToController(properties);
        updateState();
    }

    /* renamed from: b */
    public void m4873b(Map<String, Object> map) {
        this.iNvGroundStation.mo6594b(map);
        updateState();
    }

    /* renamed from: c */
    public void m4874c(Map<String, Object> map) {
        this.iNvGroundStation.tryLoginToController2(map);
    }

    /* renamed from: w */
    private SSUsrInfo getSSUsrInfo() {
        NvUser user = NvUserManager.getInstance().getUser();
        if (user == null) {
            logger.log((Object) "user is null");
            return null;
        }
        if (user.getSsUsrInfo() == null) {
            logger.log((Object) "user doesn't have ss info");
            return null;
        }
        return user.getSsUsrInfo().getTarget();
    }

    /* renamed from: f */
    public void m4878f() {
        SSUsrInfo sSUsrInfo = getSSUsrInfo();
        if (sSUsrInfo == null) {
            logger.log((Object) "ssUsrInfo is null");
            m4832a(16711686, new NvError(49, "ss usr info is empty", this.iNvGroundStation));
            return;
        }
        String serialNumber = getDeviceInfo().getSerialNumber();
        String uuid = sSUsrInfo.getUuid();
        String accessToken = sSUsrInfo.getAccessToken();
        HashMap hashMap = new HashMap();
        hashMap.put("sn", serialNumber);
        hashMap.put("uuid", uuid);
        hashMap.put("access_token", accessToken);
        this.iNvGroundStation.tryLoginToController2(hashMap);
    }

    /* renamed from: a */
    public void m4861a(long j) {
        this.iNvGroundStation.mo6589a(j);
    }

    /* renamed from: a */
    public void setUser(NvUser nvUser) {
        this.user = nvUser;
    }

    /* renamed from: g */
    public NvDeviceInfo getDeviceInfo() {
        return this.iNvGroundStation.getDeviceInfo();
    }

    /* renamed from: h */
    public GroundStationStatus getGroundStationStatus() {
        return this.groundStationStatus;
    }

    /* renamed from: i */
    public int getState() {
        return this.state;
    }

    /* renamed from: x */
    private void updateState() {
        updateState(false);
    }

    /* renamed from: a */
    private synchronized void updateState(boolean z) {
        if (!this.iNvGroundStation.isValid()) {
            this.state = -1;
        } else {
            switch (this.state) {
                case 0:
                    if (this.iNvGroundStation.mo6602i()) {
                        this.state = 1;
                        break;
                    }
                    break;
                case 1:
                    if (this.iNvGroundStation.isControllerAuthed()) {
                        this.state = 4;
                        break;
                    } else if (!this.iNvGroundStation.isRemoteBinded()) {
                        this.state = 2;
                        break;
                    } else {
                        this.state = 0;
                        break;
                    }
                case 2:
                    if (this.iNvGroundStation.mo6601h()) {
                        this.state = 3;
                        break;
                    }
                    break;
                case 3:
                    if (z) {
                        this.state = 2;
                        break;
                    } else if (this.iNvGroundStation.isRemoteBinded()) {
                        this.state = 0;
                        break;
                    }
                    break;
                case 4:
                    if (this.iNvGroundStation.mo6603j() || !this.nvConnections.isEmpty() || !this.deviceEntries1.isEmpty()) {
                        this.state = 5;
                        break;
                    }
                    break;
                case 5:
                    if (!this.iNvGroundStation.mo6603j() && this.nvConnections.isEmpty() && this.deviceEntries1.isEmpty()) {
                        this.state = 4;
                        break;
                    }
                    break;
            }
        }
        logger.conditionalLog((Object) ("GND State : " + this.state));
    }

    /* renamed from: a */
    private void handleDeviceAuthSuccess(NvSocket nvSocket) {
        if (this.socket2connectionMap.get(nvSocket) == null) {
            logger.log((Object) "handleDeviceAuthSuccess can not find connection for socket");
            return;
        }
        NvDeviceEntry nvDeviceEntry = this.serialNumber2deviceEntryMap.get(nvSocket.getDeviceInfo().getSerialNumber());
        if (nvDeviceEntry == null) {
            throw new RuntimeException("wtf?! handleDeviceAuthSuccess can't find NvDeviceEntry");
        }
        this.deviceEntries2.remove(nvDeviceEntry);
        nvDeviceEntry.m5186q();
        C1618ag.m4390a().m4400a(nvSocket.getDeviceInfo());
    }

    /* renamed from: b */
    private void handleDeviceAuthSuccess2(NvSocket nvSocket) {
        NvConnection nvConnection = this.socket2connectionMap.get(nvSocket);
        if (nvConnection == null) {
            logger.log((Object) "handleDeviceAuthSuccess can not find connection for socket");
            return;
        }
        NvDeviceEntry nvDeviceEntry = this.serialNumber2deviceEntryMap.get(nvSocket.getDeviceInfo().getSerialNumber());
        if (nvDeviceEntry == null) {
            throw new RuntimeException("wtf?! handleDeviceAuthSuccess can't find NvDeviceEntry");
        }
        nvDeviceEntry.m5183n();
        if (this.rollerAutoLogin) {
            handlerGNDSTAConnected(nvConnection);
        }
    }

    /* renamed from: c */
    private void handleDeviceConnected(NvSocket nvSocket) {
        NvDeviceEntry nvDeviceEntry = this.serialNumber2deviceEntryMap.get(nvSocket.getDeviceInfo().getSerialNumber());
        if (nvDeviceEntry == null) {
            throw new RuntimeException("wtf?! handleDeviceConnected can't find NvDeviceEntry");
        }
        logger.conditionalLog3((Object) "handleDeviceConnected 1");
        MitoConnection mitoConnection = new MitoConnection(this, nvSocket);
        this.nvConnections.add(mitoConnection);
        this.socket2connectionMap.put(nvSocket, mitoConnection);
        logger.conditionalLog3((Object) "handleDeviceConnected 2");
        this.deviceEntries1.remove(nvDeviceEntry);
        nvDeviceEntry.m5170a(mitoConnection);
        logger.conditionalLog3((Object) "handleDeviceConnected 3");
        if (this.connection == null) {
            m4838b(mitoConnection);
        }
        logger.conditionalLog3((Object) "handleDeviceConnected 4");
        handlerGNDSTAConnected(mitoConnection);
    }

    /* renamed from: a */
    private void handlerGNDSTAConnected(NvConnection nvConnection) {
        NvUser user = NvUserManager.getInstance().getUser();
        if (user == null) {
            logger.conditionalLog3((Object) "handlerGNDSTAConnected, no active user now");
            return;
        }
        NvDeviceInfo deviceInfo = nvConnection.getDeviceInfo();
        logger.conditionalLog3((Object) "handleDeviceConnected new device");
        logger.conditionalLog3((Object) deviceInfo.toString());
        if (user.getSsUsrInfo() == null) {
            logger.conditionalLog2("user not bind to sensethink account");
            m4832a(16711681, new NvError(255, "user not bind to sensethink account"));
            return;
        }
        SSUsrInfo target = user.getSsUsrInfo().getTarget();
        if (target == null) {
            logger.conditionalLog2("user not bind to sensethink account or db is corrupt.");
            m4832a(16711681, new NvError(255, "user not bind to sensethink account or db is corrupt."));
            return;
        }
        if (StringUtils.isEmpty((CharSequence) target.uuid)) {
            logger.conditionalLog2("user sensethink uuid is null");
            m4832a(16711681, new NvError(255, "user sensethink uuid is null."));
            return;
        }
        NvDeviceEntry nvDeviceEntry = this.serialNumber2deviceEntryMap.get(nvConnection.getDeviceInfo().getSerialNumber());
        if (nvDeviceEntry == null) {
            throw new RuntimeException("wtf?! handleDeviceConnected can't find NvDeviceEntry");
        }
        nvDeviceEntry.m5185p();
        this.deviceEntries2.add(nvDeviceEntry);
        HashMap hashMap = new HashMap();
        hashMap.put("uuid", target.uuid);
        nvConnection.m5053a(hashMap);
    }

    /* renamed from: a */
    public KeyMapProvider m4860a(Context context) {
        return this.iNvGroundStation.mo6588a(context);
    }

    /* renamed from: d */
    private void handleDeviceDisConnected(NvSocket nvSocket) {
        NvConnection nvConnection = this.socket2connectionMap.get(nvSocket);
        if (nvConnection == null) {
            logger.log((Object) "handleDeviceDisConnected can not find connection for socket");
            return;
        }
        NvDeviceEntry nvDeviceEntry = this.serialNumber2deviceEntryMap.get(nvSocket.getDeviceInfo().getSerialNumber());
        if (nvDeviceEntry == null) {
            logger.log((Object) "handleDeviceDisConnected can't find NvDeviceEntry");
            return;
        }
        if (nvConnection == this.connection) {
            m4838b((NvConnection) null);
        }
        this.nvConnections.remove(nvConnection);
        this.socket2connectionMap.remove(nvSocket);
        this.serialNumber2deviceEntryMap.remove(nvSocket.getDeviceInfo().getSerialNumber());
        this.deviceEntries3.remove(nvDeviceEntry);
        nvDeviceEntry.m5187r();
        m4843c(nvConnection);
        nvConnection.mo4943b();
        List<NvSocket> mo6606m = this.iNvGroundStation.mo6606m();
        if (mo6606m == null || mo6606m.isEmpty()) {
            WLog.m7004i(f4671a, "enter search because of device disconnect");
            searchDevices();
            return;
        }
        throw new RuntimeException("Oops! Shouldn't reach here, please check your code");
    }

    /* renamed from: y */
    private void m4856y() {
        Iterator<NvGroundStationHandler> it = this.groundStationHandlers.iterator();
        while (it.hasNext()) {
            it.next().mo4126c(this);
        }
        List<NvSocket> mo6606m = this.iNvGroundStation.mo6606m();
        if (mo6606m == null || mo6606m.isEmpty()) {
            logger.conditionalLog3((Object) "we don't have a active conn");
            searchDevices();
            return;
        }
        for (NvSocket nvSocket : mo6606m) {
            NvDeviceInfo deviceInfo = nvSocket.getDeviceInfo();
            String serialNumber = deviceInfo.getSerialNumber();
            NvDeviceEntry nvDeviceEntry = new NvDeviceEntry(this, deviceInfo);
            this.serialNumber2deviceEntryMap.put(serialNumber, nvDeviceEntry);
            this.deviceEntries3.add(nvDeviceEntry);
            handleDeviceConnected(nvSocket);
        }
    }

    /* renamed from: z */
    private void m4857z() {
        Iterator<NvGroundStationHandler> it = this.groundStationHandlers.iterator();
        while (it.hasNext()) {
            it.next().mo3424a(this);
        }
        if (this.controllerAutoLogin) {
            Navatics.doGroundStationAuthentication(this);
        }
    }

    /* renamed from: A */
    private void m4825A() {
        this.eventPipeline.m4435a(65566, this);
        Iterator<NvGroundStationHandler> it = this.groundStationHandlers.iterator();
        while (it.hasNext()) {
            it.next().mo4454d(this);
        }
    }

    /* renamed from: e */
    private void handleDeviceUnbindSuccess(NvSocket nvSocket) {
        NvConnection nvConnection = this.socket2connectionMap.get(nvSocket);
        if (nvConnection == null) {
            logger.log((Object) "handleDeviceUnbindSuccess can not find connection for socket");
            return;
        }
        NvDeviceEntry nvDeviceEntry = this.serialNumber2deviceEntryMap.get(nvSocket.getDeviceInfo().getSerialNumber());
        if (nvDeviceEntry == null) {
            throw new RuntimeException("wtf?! handleDeviceUnbindSuccess can't find NvDeviceEntry");
        }
        nvDeviceEntry.m5184o();
        nvConnection.m5070q();
        nvConnection.closeConnection();
    }

    /* renamed from: b */
    private void m4838b(NvConnection nvConnection) {
        NvConnection nvConnection2 = this.connection;
        if (nvConnection2 != null) {
            nvConnection2.logConnectionBackground();
        } else {
            nvConnection2 = null;
        }
        this.connection = nvConnection;
        NvConnection nvConnection3 = this.connection;
        if (nvConnection3 != null) {
            nvConnection3.logConnectionForeground();
        }
        m4834a(nvConnection2, this.connection);
    }

    /* renamed from: a */
    private void m4834a(NvConnection nvConnection, NvConnection nvConnection2) {
        this.eventPipeline.m4437b(196610, nvConnection, nvConnection2);
        Iterator<NvGroundStationHandler> it = this.groundStationHandlers.iterator();
        while (it.hasNext()) {
            it.next().onConnectionChanged(this, nvConnection, nvConnection2);
        }
    }

    /* renamed from: a */
    public NvConnection m4859a(String str) {
        for (NvConnection nvConnection : this.nvConnections) {
            if (nvConnection.getDeviceInfo().getSerialNumber().equals(str)) {
                return nvConnection;
            }
        }
        return null;
    }

    /* renamed from: b */
    public NvConnection m4870b(long j) {
        for (NvConnection nvConnection : this.nvConnections) {
            if (nvConnection.getConnectionId() == j) {
                return nvConnection;
            }
        }
        return null;
    }

    /* renamed from: a */
    public void m4862a(final GroundStationDeviceItemUpdateHandler groundStationDeviceItemUpdateHandler) {
        if (groundStationDeviceItemUpdateHandler == null) {
            throw new RuntimeException("handle is null");
        }
        this.itemUpdateHandlers.add(groundStationDeviceItemUpdateHandler);
        if (groundStationDeviceItemUpdateHandler instanceof AbstractGndStaDeviceItemUpdateHandler) {
            ((AbstractGndStaDeviceItemUpdateHandler) groundStationDeviceItemUpdateHandler).m6558a(new NvAction() { // from class: com.navatics.app.framework.-$$Lambda$g$5TCDHtbJo04F1lQlhMWznJXMP_c
                @Override // com.navatics.robot.transport.p056b.NvAction
                public final void run() {
                    GroundStation.this.m4842c(groundStationDeviceItemUpdateHandler);
                }
            });
        }
        if (this.deviceEntries3.isEmpty()) {
            return;
        }
        groundStationDeviceItemUpdateHandler.onDeviceItemListUpdate(this.deviceEntries3);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void m4842c(GroundStationDeviceItemUpdateHandler groundStationDeviceItemUpdateHandler) {
        this.itemUpdateHandlers.remove(groundStationDeviceItemUpdateHandler);
    }

    /* renamed from: a */
    public void notifySearchStateChanged(final NvGroundStationHandler nvGroundStationHandler) {
        if (nvGroundStationHandler == null) {
            throw new RuntimeException("handle is null");
        }
        this.groundStationHandlers.add(nvGroundStationHandler);
        if (nvGroundStationHandler instanceof AbstractGroundStationHandler) {
            ((AbstractGroundStationHandler) nvGroundStationHandler).m6558a(new NvAction() { // from class: com.navatics.app.framework.-$$Lambda$g$theq5WPtZDBqAvuS5eYHPQ0K7R0
                @Override // com.navatics.robot.transport.p056b.NvAction
                public final void run() {
                    GroundStation.this.m4844c(nvGroundStationHandler);
                }
            });
        }
        logger.conditionalLog3((Object) ("1 notifySearchStateChanged " + this.f4687q));
        nvGroundStationHandler.mo3920a(this, this.f4687q);
        for (NvDeviceEntry nvDeviceEntry : this.deviceEntries3) {
            if (nvDeviceEntry.m5179j() == 2) {
                nvGroundStationHandler.mo4124a(this, nvDeviceEntry.m5167a());
            }
        }
        for (NvDeviceEntry nvDeviceEntry2 : this.deviceEntries3) {
            if (nvDeviceEntry2.m5179j() == 7) {
                nvGroundStationHandler.onConnectionChanged(this, (NvConnection) null, nvDeviceEntry2.m5188s());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void m4844c(NvGroundStationHandler nvGroundStationHandler) {
        this.groundStationHandlers.remove(nvGroundStationHandler);
    }

    /* renamed from: j */
    public boolean m4882j() {
        Iterator<NvConnection> it = this.nvConnections.iterator();
        while (it.hasNext()) {
            if (it.next().isAuthed()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: k */
    public void m4883k() {
        Iterator<GroundStationDeviceItemUpdateHandler> it = this.itemUpdateHandlers.iterator();
        while (it.hasNext()) {
            it.next().onDeviceItemListUpdate(this.deviceEntries3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public void onItemBinding(String serialNumber) {
        NvDeviceEntry nvDeviceEntry = this.serialNumber2deviceEntryMap.get(serialNumber);
        if (nvDeviceEntry == null) {
            logger.log((Object) "onItemBinding item is null");
        } else {
            nvDeviceEntry.m5182m();
        }
    }

    /* renamed from: b */
    private void m4840b(NvEvent nvEvent) {
        switch (nvEvent.f6591b) {
            case 65538:
                if (m4882j() || hasDevices()) {
                    return;
                }
                searchDevices();
                return;
            case PreferenceFragmentCompatDividers.DIVIDER_DEFAULT /* 65539 */:
                List<NvDeviceInfo> list = (List) nvEvent.f6595f;
                if (list == null) {
                    list = new ArrayList();
                }
                long currentTimeMillis = System.currentTimeMillis();
                boolean z = false;
                for (NvDeviceInfo nvDeviceInfo : list) {
                    String serialNumber = nvDeviceInfo.getSerialNumber();
                    NvDeviceEntry nvDeviceEntry = this.serialNumber2deviceEntryMap.get(serialNumber);
                    if (nvDeviceEntry == null) {
                        logger.conditionalLog((Object) ("new device : " + nvDeviceInfo));
                        nvDeviceEntry = new NvDeviceEntry(this, nvDeviceInfo);
                        this.serialNumber2deviceEntryMap.put(serialNumber, nvDeviceEntry);
                        this.deviceEntries3.add(nvDeviceEntry);
                        z = true;
                    }
                    nvDeviceEntry.m5169a(currentTimeMillis);
                }
                Iterator<NvDeviceEntry> it = this.deviceEntries3.iterator();
                while (it.hasNext()) {
                    NvDeviceEntry next = it.next();
                    if (next.m5171b() && currentTimeMillis - next.m5189t() > 5000) {
                        String serialNumber2 = next.m5167a().getSerialNumber();
                        logger.conditionalLog2("remove inactive device : " + serialNumber2);
                        this.serialNumber2deviceEntryMap.remove(serialNumber2);
                        it.remove();
                        z = true;
                    }
                }
                if (z) {
                    m4883k();
                }
                NvDeviceInfo m4413j = C1618ag.m4390a().m4413j();
                if (!this.enableAutoConn || m4413j == null) {
                    return;
                }
                NvDeviceEntry nvDeviceEntry2 = this.serialNumber2deviceEntryMap.get(m4413j.getSerialNumber());
                if (nvDeviceEntry2 == null || !nvDeviceEntry2.m5171b()) {
                    return;
                }
                logger.conditionalLog3((Object) "we found one idle item we met before, initialize the connection to it");
                connectDevice(nvDeviceEntry2.m5167a(), null, false);
                return;
            default:
                return;
        }
    }

    /* renamed from: B */
    private void m4826B() {
        Iterator<NvGroundStationHandler> it = this.groundStationHandlers.iterator();
        while (it.hasNext()) {
            it.next().mo4125b(this);
        }
    }

    /* renamed from: C */
    private void m4827C() {
        Iterator<NvGroundStationHandler> it = this.groundStationHandlers.iterator();
        while (it.hasNext()) {
            it.next().destroyDevice(this.iNvGroundStation.getDeviceInfo());
        }
    }

    /* renamed from: a */
    private void m4831a(@SearchState int i) {
        Iterator<NvGroundStationHandler> it = this.groundStationHandlers.iterator();
        while (it.hasNext()) {
            it.next().mo3920a(this, i);
        }
    }

    /* renamed from: a */
    private void m4835a(NvDeviceInfo nvDeviceInfo) {
        Iterator<NvGroundStationHandler> it = this.groundStationHandlers.iterator();
        while (it.hasNext()) {
            it.next().mo4124a(this, nvDeviceInfo);
        }
    }

    /* renamed from: c */
    private void m4843c(NvConnection nvConnection) {
        Iterator<NvGroundStationHandler> it = this.groundStationHandlers.iterator();
        while (it.hasNext()) {
            it.next().mo4453b(this, nvConnection);
        }
    }

    /* renamed from: l */
    public void searchDevices() {
        if (this.iNvGroundStation.isValid()) {
            this.iNvGroundStation.searchDevices();
            updateState();
        }
    }

    /* renamed from: a */
    public void m4865a(NvDeviceInfo nvDeviceInfo, Map<String, Object> map) {
        connectDevice(nvDeviceInfo, map, true);
    }

    /* renamed from: a */
    public void connectDevice(NvDeviceInfo nvDeviceInfo, Map<String, Object> properties, boolean z) {
        if (!nvDeviceInfo.isValid()) {
            logger.log((Object) ("NvDeviceInfo is not valid : " + nvDeviceInfo));
            return;
        }
        if (!this.deviceEntries1.isEmpty() && m4892t() < 2) {
            logger.log((Object) "The underlying ground station implementation only allow to connect to 1 device at the same time. ");
            return;
        }
        NvDeviceEntry nvDeviceEntry = this.serialNumber2deviceEntryMap.get(nvDeviceInfo.getSerialNumber());
        if (nvDeviceEntry == null) {
            String str = "connect met unknown device : " + nvDeviceInfo.getSerialNumber();
            logger.log((Object) str);
            if (z) {
                m4832a(16711681, new NvError(56, str, nvDeviceInfo));
                return;
            }
            return;
        }
        if (!this.iNvGroundStation.isValid()) {
            logger.log((Object) "connect : GroundStation is already invalid.");
            return;
        }
        if (this.deviceEntries1.contains(nvDeviceEntry)) {
            logger.conditionalLog2("trying to connect to device already in connecting list : " + nvDeviceInfo.getSerialNumber());
            return;
        }
        this.deviceEntries1.add(nvDeviceEntry);
        nvDeviceEntry.m5181l();
        updateState();
        m4835a(nvDeviceInfo);
        this.iNvGroundStation.mo6590a(nvDeviceInfo, properties);
    }

    /* renamed from: m */
    public NvConnection getConnection() {
        return this.connection;
    }

    /* renamed from: p */
    public NvBatteryInfo getBatteryInfo() {
        return this.batteryInfo;
    }

    /* renamed from: q */
    public int m4889q() {
        return this.iNvGroundStation.mo6595c();
    }

    /* renamed from: r */
    public int m4890r() {
        return this.iNvGroundStation.mo6597d();
    }

    /* renamed from: s */
    public int m4891s() {
        return this.iNvGroundStation.mo6598e();
    }

    /* renamed from: t */
    public int m4892t() {
        return this.iNvGroundStation.mo6605l();
    }

    /* renamed from: u */
    public boolean hasDevices() {
        return !this.deviceEntries1.isEmpty();
    }

    /* renamed from: c */
    private void notifySearchStateChanged(NvEvent nvEvent) {
        int i = nvEvent.f6591b;
        if (i != 65549) {
            switch (i) {
                case 65537:
                    this.f4687q = 0;
                    logger.conditionalLog3((Object) ("2 notifySearchStateChanged " + this.f4687q));
                    m4831a(this.f4687q);
                    m4840b(nvEvent);
                    return;
                case 65538:
                    this.f4687q = 2;
                    logger.conditionalLog3((Object) ("3 notifySearchStateChanged " + this.f4687q));
                    m4831a(this.f4687q);
                    m4840b(nvEvent);
                    return;
                case PreferenceFragmentCompatDividers.DIVIDER_DEFAULT /* 65539 */:
                    m4840b(nvEvent);
                    return;
                case InputDeviceCompat.SOURCE_TRACKBALL /* 65540 */:
                    logger.conditionalLog3((Object) "DEVICE_CONNECTED");
                    handleDeviceConnected((NvSocket) nvEvent.f6595f);
                    return;
                case 65541:
                    logger.conditionalLog3((Object) "DEVICE_DISCONNECTED");
                    handleDeviceDisConnected((NvSocket) nvEvent.f6595f);
                    return;
                default:
                    switch (i) {
                        case 65543:
                            logger.conditionalLog3((Object) "DEVICE_AUTH_SUCCESS");
                            handleDeviceAuthSuccess((NvSocket) nvEvent.f6595f);
                            return;
                        case 65544:
                            logger.conditionalLog3((Object) "DEVICE_BIND_SUCCESS");
                            handleDeviceAuthSuccess2((NvSocket) ((NvError) nvEvent.f6595f).m6633c());
                            return;
                        case 65545:
                            logger.conditionalLog3((Object) "GNDSTA_BIND_SUCCESS");
                            m4857z();
                            return;
                        case 65546:
                            logger.conditionalLog3((Object) "GNDSTA_AUTH_SUCCESS");
                            m4856y();
                            return;
                        default:
                            switch (i) {
                                case 65566:
                                    logger.conditionalLog3((Object) "GNDSTA_UNBIND_SUCCESS");
                                    m4825A();
                                    return;
                                case 65567:
                                    logger.conditionalLog3((Object) "DEVICE_UNBIND_SUCCESS");
                                    handleDeviceUnbindSuccess((NvSocket) ((NvError) nvEvent.f6595f).m6633c());
                                    return;
                                default:
                                    return;
                            }
                    }
            }
        }
        logger.conditionalLog3((Object) "GNDSTA_DESTROYED");
        m4829E();
    }

    /* renamed from: D */
    private void m4828D() {
        Iterator<NvConnection> it = this.nvConnections.iterator();
        while (it.hasNext()) {
            it.next().mo4943b();
        }
    }

    /* renamed from: E */
    private void m4829E() {
        m4828D();
        m4827C();
    }

    /* renamed from: d */
    private void m4848d(NvEvent nvEvent) {
        this.batteryInfo.setLevel(this.iNvGroundStation.getBatteryLevel());
        m4826B();
    }

    /* renamed from: e */
    private void m4850e(NvEvent nvEvent) {
        if (nvEvent.f6591b != 131075) {
            return;
        }
        m4848d(nvEvent);
    }

    /* renamed from: f */
    private void handleErrorEvent(NvEvent nvEvent) {
        switch (nvEvent.f6591b) {
            case 16711681:
                NvError nvError = (NvError) nvEvent.f6595f;
                NvDeviceInfo nvDeviceInfo = (NvDeviceInfo) nvError.m6633c();
                NvDeviceEntry nvDeviceEntry = this.serialNumber2deviceEntryMap.get(nvDeviceInfo.getSerialNumber());
                if (nvDeviceEntry == null) {
                    logger.log((Object) ("can't find device for sn " + nvDeviceInfo.getSerialNumber()));
                    return;
                }
                nvDeviceEntry.m5168a(16711681, nvError);
                this.deviceEntries1.remove(nvDeviceEntry);
                logger.conditionalLog2("handleErrorEvent DEVICE_CONN_ERR");
                m4832a(16711681, (NvError) nvEvent.f6595f);
                searchDevices();
                return;
            case 16711682:
                logger.conditionalLog2("handleErrorEvent DEVICE_AUTH_ERR");
                NvError nvError2 = (NvError) nvEvent.f6595f;
                NvSocket nvSocket = (NvSocket) nvError2.m6633c();
                if (nvSocket == null) {
                    logger.log((Object) "DEVICE_AUTH_ERR can't get socket from extra of NvError");
                    return;
                }
                NvConnection nvConnection = this.socket2connectionMap.get(nvSocket);
                if (nvConnection == null) {
                    logger.log((Object) ("handleErrorEvent can not find connection for socket" + nvSocket.getSocketId()));
                    return;
                }
                NvDeviceEntry nvDeviceEntry2 = this.serialNumber2deviceEntryMap.get(nvSocket.getDeviceInfo().getSerialNumber());
                if (nvDeviceEntry2 == null) {
                    logger.log((Object) ("can't find device for sn " + nvSocket.getDeviceInfo().getSerialNumber()));
                    return;
                }
                this.deviceEntries2.remove(nvDeviceEntry2);
                if (nvError2.m6630a() == 52) {
                    nvDeviceEntry2.m5184o();
                    m4847d(nvConnection);
                    return;
                } else {
                    nvError2.m6631a(nvSocket.getDeviceInfo());
                    nvDeviceEntry2.m5168a(16711682, nvError2);
                    return;
                }
            case 16711683:
                logger.conditionalLog2("handleErrorEvent DEVICE_BIND_ERR");
                NvError nvError3 = (NvError) nvEvent.f6595f;
                NvSocket nvSocket2 = (NvSocket) nvError3.m6633c();
                if (nvSocket2 == null) {
                    logger.log((Object) "DEVICE_BIND_ERR can't get socket from extra of NvError");
                    return;
                }
                if (this.socket2connectionMap.get(nvSocket2) == null) {
                    logger.log((Object) ("handleErrorEvent can not find connection for socket " + nvSocket2.getSocketId()));
                    return;
                }
                NvDeviceEntry nvDeviceEntry3 = this.serialNumber2deviceEntryMap.get(nvSocket2.getDeviceInfo().getSerialNumber());
                if (nvDeviceEntry3 == null) {
                    logger.log((Object) ("can't find device for sn " + nvSocket2.getDeviceInfo().getSerialNumber()));
                    return;
                }
                logger.log((Object) "notify conn bind err");
                nvDeviceEntry3.m5168a(16711683, nvError3);
                return;
            case 16711684:
            default:
                return;
            case 16711685:
                logger.conditionalLog2("handleErrorEvent GNDSTA_AUTH_ERR");
                if (((NvError) nvEvent.f6595f).m6630a() == 52) {
                    m4830F();
                    return;
                } else {
                    m4832a(16711685, (NvError) nvEvent.f6595f);
                    return;
                }
            case 16711686:
                m4832a(16711686, (NvError) nvEvent.f6595f);
                return;
            case 16711687:
                NvError nvError4 = (NvError) nvEvent.f6595f;
                this.eventPipeline.m4435a(16711687, this, nvError4);
                m4832a(16711687, nvError4);
                return;
            case 16711688:
                NvError nvError5 = (NvError) nvEvent.f6595f;
                NvSocket nvSocket3 = (NvSocket) nvError5.m6633c();
                if (nvSocket3 == null) {
                    logger.log((Object) "DEVICE_AUTH_ERR can't get socket from extra of NvError");
                    return;
                }
                NvConnection nvConnection2 = this.socket2connectionMap.get(nvSocket3);
                if (nvConnection2 == null) {
                    logger.log((Object) ("handleErrorEvent can not find connection for socket" + nvSocket3.getSocketId()));
                    return;
                }
                nvConnection2.m5052a(nvError5);
                return;
        }
    }

    /* renamed from: F */
    private void m4830F() {
        Navatics.m4991b(this);
    }

    /* renamed from: d */
    private void m4847d(NvConnection nvConnection) {
        Iterator<NvGroundStationHandler> it = this.groundStationHandlers.iterator();
        while (it.hasNext()) {
            it.next().onNewDevice1(this, nvConnection);
        }
    }

    /* renamed from: a */
    private void m4832a(int i, NvError nvError) {
        Iterator<NvGroundStationHandler> it = this.groundStationHandlers.iterator();
        while (it.hasNext()) {
            it.next().connect(this, i, nvError);
        }
    }

    @Override // com.navatics.robot.transport.NvEventHandler
    /* renamed from: a */
    public void handleEvent(NvEvent nvEvent) {
        updateState();
        int i = nvEvent.f6590a;
        if (i != 255) {
            switch (i) {
                case 1:
                    notifySearchStateChanged(nvEvent);
                    return;
                case 2:
                    m4850e(nvEvent);
                    return;
                default:
                    return;
            }
        }
        handleErrorEvent(nvEvent);
    }
}