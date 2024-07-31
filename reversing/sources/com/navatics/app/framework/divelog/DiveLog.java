package com.navatics.app.framework.divelog;

import android.util.Log;
import com.example.divelog.dao.entity.BaseDiveLogInfo;
import com.example.divelog.dao.entity.CommandCard;
import com.example.divelog.dao.entity.DiveLogItem;
import com.google.gson.Gson;
import com.navatics.app.framework.GroundStation;
import com.navatics.app.framework.Navatics;
import com.navatics.app.framework.NvBuoy;
import com.navatics.app.framework.NvRobot;
import com.navatics.app.framework.p052d.DiveLogBuildHelper;
import com.navatics.robot.utils.C2160n;
import io.objectbox.Box;
import io.objectbox.BoxStore;
import io.objectbox.annotation.Backlink;
import io.objectbox.annotation.Entity;
import io.objectbox.annotation.InterfaceC2825Id;
import io.objectbox.annotation.Transient;
import io.objectbox.relation.ToMany;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;

@Entity
/* loaded from: classes.dex */
public class DiveLog {
    public static final int STATUS_FINISHED = 2;
    public static final int STATUS_FROM_SERVER = 3;
    public static final int STATUS_LOGGING = 1;
    public static final int STATUS_PREPARING = 0;
    private static final String TAG = "DiveLog";
    transient BoxStore __boxStore;
    int averageDepth;
    @Transient
    private NvBuoy buoy;
    String comment;
    Date date;
    @Transient
    boolean debug;
    String email;
    long endTime;
    @Backlink
    public ToMany<DiveLogEntry> entries = new ToMany<>(this, DiveLog_.entries);
    boolean fakeDelete = false;
    @Transient
    private GroundStation groundStation;
    @InterfaceC2825Id

    /* renamed from: id */
    long f4332id;
    String latitude;
    String longitude;
    int maxDepth;
    int maxTemp;
    int minDepth;
    int minTemp;
    String place;
    @Transient
    private NvRobot robot;
    long startTime;
    int status;
    int temperature;
    boolean uploaded;
    String weather;

    /* renamed from: com.navatics.app.framework.divelog.DiveLog$a */
    /* loaded from: classes.dex */
    public interface InterfaceC1769a {
        /* renamed from: a */
        boolean m8514a(int i, DiveLogEntry diveLogEntry);
    }

    /* renamed from: com.navatics.app.framework.divelog.DiveLog$b */
    /* loaded from: classes.dex */
    public interface InterfaceC1770b {
        void onItem(int i, DiveLogEntry diveLogEntry);
    }

    public static float convertDepthToRealValue(int i) {
        return ((i * (-1.0f)) / 65535.0f) * 100.0f;
    }

    public DiveLog() {
    }

    public DiveLog(NvRobot nvRobot, NvBuoy nvBuoy, GroundStation groundStation, String str, Date date, long j, int i, int i2) {
        Log.i("DiveLog", "constructor 2 of DiveLog");
        this.robot = nvRobot;
        this.buoy = nvBuoy;
        this.groundStation = groundStation;
        this.email = str;
        this.date = date;
        this.startTime = j;
        this.temperature = i;
    }

    public boolean isFakeDelete() {
        return this.fakeDelete;
    }

    public void setFakeDelete(boolean z) {
        this.fakeDelete = z;
    }

    public boolean isDebug() {
        return this.debug;
    }

    public void setDebug(boolean z) {
        this.debug = z;
    }

    public NvRobot getRobot() {
        return this.robot;
    }

    public NvBuoy getBuoy() {
        return this.buoy;
    }

    public GroundStation getGroundStation() {
        return this.groundStation;
    }

    public boolean isFinish() {
        return this.endTime != 0;
    }

    public void save() {
        Log.i("DiveLog", "save: ");
        try {
            Navatics.m7933f().m3474d(DiveLog.class).m3421b((Box) this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete() {
        Log.i("info1", "delete: delete ");
        DiveLogBuildHelper.m8551a(this.startTime + "").m8500b();
        Navatics.m7933f().m3485a(new Runnable() { // from class: com.navatics.app.framework.divelog.DiveLog.1
            @Override // java.lang.Runnable
            public void run() {
                Box m3474d = Navatics.m7933f().m3474d(DiveLogEntry.class);
                Iterator<DiveLogEntry> it = DiveLog.this.entries.iterator();
                while (it.hasNext()) {
                    m3474d.m3418c((Box) it.next());
                }
                Navatics.m7933f().m3474d(DiveLog.class).m3424b(DiveLog.this.f4332id);
            }
        });
    }

    public long getId() {
        return this.f4332id;
    }

    public Date getDate() {
        return this.date;
    }

    public long getStartTime() {
        return this.startTime;
    }

    public long getEndTime() {
        return getMaxEndTime();
    }

    private long getMaxEndTime() {
        long j = this.endTime;
        long j2 = 0;
        if (j != 0) {
            return j;
        }
        Iterator<DiveLogEntry> it = getEntries().iterator();
        while (it.hasNext()) {
            DiveLogEntry next = it.next();
            if (next.getTimestamp() > j2) {
                j2 = next.getTimestamp();
            }
        }
        this.endTime = j2;
        return j2;
    }

    public int getMaxDepth() {
        int i = this.maxDepth;
        if (i != 0) {
            return i;
        }
        Iterator<DiveLogEntry> it = getEntries().iterator();
        int i2 = 0;
        while (it.hasNext()) {
            DiveLogEntry next = it.next();
            if (next.getStateDepth() > i2) {
                i2 = next.getStateDepth();
            }
        }
        this.maxDepth = i2;
        return this.maxDepth;
    }

    public int getAverageDepth() {
        return this.averageDepth;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setStartTime(long j) {
        this.startTime = j;
    }

    public void setEndTime(long j) {
        this.endTime = j;
    }

    public void setMaxDepth(int i) {
        this.maxDepth = i;
    }

    public void setAverageDepth(int i) {
        this.averageDepth = i;
    }

    public ToMany<DiveLogEntry> getEntries() {
        return this.entries;
    }

    public int getTemperature() {
        return this.temperature;
    }

    public void setTemperature(int i) {
        this.temperature = i;
    }

    public String getComment() {
        return this.comment;
    }

    public void setComment(String str) {
        this.comment = str;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String str) {
        this.email = str;
    }

    public String getPlace() {
        return this.place;
    }

    public void setPlace(String str) {
        this.place = str;
    }

    public String getLongitude() {
        return this.longitude;
    }

    public void setLongitude(String str) {
        this.longitude = str;
    }

    public String getLatitude() {
        return this.latitude;
    }

    public void setLatitude(String str) {
        this.latitude = str;
    }

    public String getWeather() {
        return this.weather;
    }

    public void setWeather(String str) {
        this.weather = str;
    }

    public boolean isUploaded() {
        return this.uploaded;
    }

    public void setUploaded(boolean z) {
        this.uploaded = z;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public int getMinDepth() {
        return this.minDepth;
    }

    public void setMinDepth(int i) {
        this.minDepth = i;
    }

    public int getMaxTemp() {
        return this.maxTemp;
    }

    public void setMaxTemp(int i) {
        this.maxTemp = i;
    }

    public int getMinTemp() {
        return this.minTemp;
    }

    public void setMinTemp(int i) {
        this.minTemp = i;
    }

    public List<DiveLogEntry> filterEntry(InterfaceC1769a interfaceC1769a) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.entries.size(); i++) {
            DiveLogEntry diveLogEntry = this.entries.get(i);
            if (interfaceC1769a.m8514a(i, diveLogEntry)) {
                arrayList.add(diveLogEntry);
            }
        }
        return arrayList;
    }

    public void transverse(InterfaceC1770b interfaceC1770b) {
        for (int i = 0; i < this.entries.size(); i++) {
            interfaceC1770b.onItem(i, this.entries.get(i));
        }
    }

    public BaseDiveLogInfo buildBaseDiveLogInfo() {
        BaseDiveLogInfo baseDiveLogInfo = new BaseDiveLogInfo();
        baseDiveLogInfo.setId(this.f4332id);
        baseDiveLogInfo.setWeather(this.weather);
        baseDiveLogInfo.setAverageDepth(this.averageDepth);
        baseDiveLogInfo.setComment(this.comment);
        baseDiveLogInfo.setDiveDate(this.date);
        baseDiveLogInfo.setEmail(this.email);
        baseDiveLogInfo.setEndTime(this.endTime);
        baseDiveLogInfo.setLatitude(this.latitude);
        baseDiveLogInfo.setMaxDepth(this.maxDepth);
        baseDiveLogInfo.setLongitude(this.longitude);
        baseDiveLogInfo.setMaxTemp(this.maxTemp);
        baseDiveLogInfo.setMinDepth(this.minDepth);
        baseDiveLogInfo.setMinTemp(this.minTemp);
        baseDiveLogInfo.setDivePlace(this.place);
        baseDiveLogInfo.setStartTime(this.startTime);
        baseDiveLogInfo.setStatus(this.status);
        baseDiveLogInfo.setTemperature(this.temperature);
        baseDiveLogInfo.setUploaded(this.uploaded);
        baseDiveLogInfo.setSource(0);
        baseDiveLogInfo.setTimeZoneOffset(TimeZone.getDefault().getRawOffset());
        return baseDiveLogInfo;
    }

    public void updateBaseInfo(BaseDiveLogInfo baseDiveLogInfo) {
        this.weather = baseDiveLogInfo.getWeather();
        this.averageDepth = baseDiveLogInfo.getAverageDepth();
        this.comment = baseDiveLogInfo.getComment();
        this.date = baseDiveLogInfo.getDiveDate();
        this.email = baseDiveLogInfo.getEmail();
        this.endTime = baseDiveLogInfo.getEndTime();
        this.latitude = baseDiveLogInfo.getLatitude();
        this.maxDepth = baseDiveLogInfo.getMaxDepth();
        this.longitude = baseDiveLogInfo.getLongitude();
        this.maxTemp = baseDiveLogInfo.getMaxTemp();
        this.minTemp = baseDiveLogInfo.getMinTemp();
        this.place = baseDiveLogInfo.getDivePlace();
        this.startTime = baseDiveLogInfo.getStartTime();
        this.status = baseDiveLogInfo.getStatus();
        this.temperature = baseDiveLogInfo.getTemperature();
        new Gson();
        save();
    }

    public void updateDiveLogDetail(DiveLogItem diveLogItem) {
        Iterator<DiveLogEntry> it = this.entries.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (it.next().getDetailIndex().equals(diveLogItem.getIndex())) {
                DiveLogEntry.buildByDiveLogItem(diveLogItem).parent.setTargetId(this.f4332id);
                break;
            }
        }
        save();
    }

    public void addDiveLogDetail(DiveLogItem diveLogItem) {
        DiveLogEntry buildByDiveLogItem = DiveLogEntry.buildByDiveLogItem(diveLogItem);
        buildByDiveLogItem.parent.setTargetId(this.f4332id);
        this.entries.add(buildByDiveLogItem);
        save();
    }

    public void deleteDiveLogDetail(DiveLogItem diveLogItem) {
        if (diveLogItem == null) {
            return;
        }
        Iterator<DiveLogEntry> it = this.entries.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            DiveLogEntry next = it.next();
            if (next.getDetailIndex().equals(diveLogItem.getIndex())) {
                this.entries.remove(next);
                break;
            }
        }
        save();
    }

    public List<CommandCard> buildCommand(Map<String, DiveLogItem> map) {
        ArrayList arrayList = new ArrayList();
        BaseDiveLogInfo buildBaseDiveLogInfo = buildBaseDiveLogInfo();
        CommandCard builder = CommandCard.builder();
        arrayList.add(builder.setStartTime(this.startTime + "").setCommand(CommandCard.CREATE).setJson(buildBaseDiveLogInfo).setVersion(1));
        int i = 0;
        for (DiveLogItem diveLogItem : map.values()) {
            CommandCard builder2 = CommandCard.builder();
            arrayList.add(builder2.setStartTime(this.startTime + "").setDetailIndex(diveLogItem.getIndex()).setVersion(i + 2).setJson(diveLogItem).setCommand(CommandCard.ADD_ITEM));
            i++;
        }
        return arrayList;
    }

    public Map<String, DiveLogItem> buildDiveLogItems() {
        DiveLogItem buildDivelogItem;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<DiveLogEntry> it = this.entries.iterator();
        while (it.hasNext()) {
            DiveLogEntry next = it.next();
            if (C2160n.m5855a((CharSequence) next.getDetailIndex())) {
                String uuid = UUID.randomUUID().toString();
                buildDivelogItem = next.buildDivelogItem(this.startTime + "", uuid);
            } else {
                buildDivelogItem = next.buildDivelogItem(this.startTime + "", next.getDetailIndex());
            }
            Log.i("info1", "buildDiveLogItems: " + buildDivelogItem.getIndex());
            linkedHashMap.put(buildDivelogItem.getIndex(), buildDivelogItem);
        }
        return linkedHashMap;
    }
}
