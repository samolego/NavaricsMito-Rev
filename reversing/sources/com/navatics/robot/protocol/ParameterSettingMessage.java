package com.navatics.robot.protocol;

import android.content.Context;
import java.util.Map;
import org.apache.log4j.C3044k;

/* renamed from: com.navatics.robot.protocol.ag */
/* loaded from: classes.dex */
public class ParameterSettingMessage extends OutputMessage {

    /* renamed from: d */
    private static C3044k f6243d = C3044k.m1564a(ParameterSettingMessage.class);

    /* renamed from: e */
    private static final Object f6244e = new Object();

    /* renamed from: f */
    private static int f6245f;

    /* renamed from: g */
    private static ParameterSettingMessage f6246g;

    /* renamed from: h */
    private ParameterSettingMessage f6247h;

    /* renamed from: i */
    private int f6248i;

    /* renamed from: j */
    private int f6249j;

    /* renamed from: k */
    private int f6250k;

    /* renamed from: l */
    private int f6251l;

    /* renamed from: m */
    private int f6252m;

    /* renamed from: n */
    private byte[] f6253n;

    private ParameterSettingMessage() {
        super(49);
        this.f6253n = new byte[7];
    }

    /* renamed from: a */
    public static ParameterSettingMessage m6527a(Map<String, Object> map) {
        ParameterSettingMessage m6526c = m6526c();
        for (String str : map.keySet()) {
            Context m6533a = NvProtocol.m6533a();
            Object obj = map.get(str);
            if (m6533a.getResources().getString(R.string.pref_key_max_yaw_speed).equals(str)) {
                if (obj instanceof Integer) {
                    m6526c.f6248i = ((Integer) obj).intValue();
                } else {
                    m6526c.f6248i = 0;
                }
            } else if (m6533a.getResources().getString(R.string.pref_key_max_forward_speed).equals(str)) {
                if (obj instanceof Integer) {
                    m6526c.f6249j = ((Integer) obj).intValue();
                } else {
                    m6526c.f6249j = 0;
                }
            } else if (m6533a.getResources().getString(R.string.pref_key_max_dive_speed).equals(str)) {
                if (obj instanceof Integer) {
                    m6526c.f6250k = ((Integer) obj).intValue();
                } else {
                    m6526c.f6250k = 0;
                }
            } else if (m6533a.getResources().getString(R.string.pref_key_max_depth).equals(str)) {
                if (obj instanceof Integer) {
                    m6526c.f6251l = ((Integer) obj).intValue();
                } else {
                    m6526c.f6251l = 0;
                }
            } else if (m6533a.getResources().getString(R.string.pref_key_max_pitch_angle).equals(str)) {
                if (obj instanceof Integer) {
                    m6526c.f6252m = ((Integer) obj).intValue();
                } else {
                    m6526c.f6252m = 0;
                }
            } else {
                C3044k c3044k = f6243d;
                c3044k.mo1504b((Object) ("unknown parameter : " + str));
            }
        }
        return m6526c;
    }

    /* renamed from: c */
    private static ParameterSettingMessage m6526c() {
        synchronized (f6244e) {
            ParameterSettingMessage parameterSettingMessage = f6246g;
            if (parameterSettingMessage == null) {
                return new ParameterSettingMessage();
            }
            f6246g = parameterSettingMessage.f6247h;
            f6245f--;
            parameterSettingMessage.f6247h = null;
            parameterSettingMessage.m6504j();
            return parameterSettingMessage;
        }
    }

    @Override // com.navatics.robot.protocol.RobotMessage
    /* renamed from: a */
    public final void mo6369a() {
        super.mo6369a();
        this.f6248i = 0;
        this.f6249j = 0;
        this.f6250k = 0;
        this.f6251l = 0;
        this.f6252m = 0;
        synchronized (f6244e) {
            if (f6245f < 20) {
                f6245f++;
                this.f6247h = f6246g;
                f6246g = this;
            }
        }
    }

    @Override // com.navatics.robot.protocol.OutputMessage
    /* renamed from: b */
    public byte[] mo6368b() {
        byte[] bArr = this.f6253n;
        bArr[0] = 49;
        bArr[1] = (byte) this.f6248i;
        bArr[2] = (byte) this.f6249j;
        bArr[3] = (byte) this.f6250k;
        bArr[4] = (byte) this.f6251l;
        bArr[5] = (byte) this.f6252m;
        return bArr;
    }

    public String toString() {
        return "MSG_SET_PARAMETER(0xF0, " + String.format("0x%02x, 0x%02x, 0x%02x, 0x%02x, 0x%02x, 0x%02x", Integer.valueOf(m6503k()), Byte.valueOf(this.f6253n[1]), Byte.valueOf(this.f6253n[2]), Byte.valueOf(this.f6253n[3]), Byte.valueOf(this.f6253n[4]), Byte.valueOf(this.f6253n[5])) + ")";
    }
}
