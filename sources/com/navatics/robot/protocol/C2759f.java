package com.navatics.robot.protocol;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Map;
import org.apache.log4j.C3044k;

/* renamed from: com.navatics.robot.protocol.f */
/* loaded from: classes.dex */
public class CameraSettingMessage extends OutputMessage {

    /* renamed from: d */
    private static C3044k f6404d = C3044k.m1564a(CameraSettingMessage.class);

    /* renamed from: e */
    private static final Object f6405e = new Object();

    /* renamed from: f */
    private static int f6406f;

    /* renamed from: g */
    private static CameraSettingMessage f6407g;

    /* renamed from: h */
    private CameraSettingMessage f6408h;

    /* renamed from: i */
    private int f6409i;

    /* renamed from: j */
    private int f6410j;

    /* renamed from: k */
    private Map<String, Object> f6411k;

    /* renamed from: l */
    private byte[] f6412l;

    private CameraSettingMessage() {
        super(80);
        this.f6409i = -1;
        this.f6410j = -1;
    }

    /* renamed from: a */
    public static CameraSettingMessage m6443a(int i, int i2, Map<String, Object> map) {
        CameraSettingMessage m6438f = m6438f();
        m6438f.f6409i = i;
        m6438f.f6410j = i2;
        m6438f.f6411k = map;
        return m6438f;
    }

    /* renamed from: f */
    private static CameraSettingMessage m6438f() {
        synchronized (f6405e) {
            CameraSettingMessage cameraSettingMessage = f6407g;
            if (cameraSettingMessage == null) {
                return new CameraSettingMessage();
            }
            f6407g = cameraSettingMessage.f6408h;
            f6406f--;
            cameraSettingMessage.f6408h = null;
            cameraSettingMessage.m6504j();
            return cameraSettingMessage;
        }
    }

    /* renamed from: c */
    public int m6440c() {
        return this.f6409i;
    }

    /* renamed from: d */
    public int m6439d() {
        return this.f6410j;
    }

    @Override // com.navatics.robot.protocol.RobotMessage
    /* renamed from: a */
    public final void mo6369a() {
        super.mo6369a();
        Map<String, Object> map = this.f6411k;
        if (map != null) {
            map.clear();
        }
        synchronized (f6405e) {
            if (f6406f < 5) {
                f6406f++;
                this.f6408h = f6407g;
                f6407g = this;
            }
        }
    }

    @Override // com.navatics.robot.protocol.OutputMessage
    /* renamed from: b */
    public byte[] mo6368b() {
        switch (this.f6409i) {
            case 1:
                return m6435i();
            case 2:
                return m6434l();
            case 3:
                return m6433m();
            case 4:
            default:
                return null;
            case 5:
                return m6437g();
            case 6:
                return m6436h();
            case 7:
                return m6432n();
            case 8:
                return m6430p();
            case 9:
                return m6431o();
            case 10:
                return m6426t();
            case 11:
                return m6428r();
            case 12:
                return m6427s();
            case 13:
                return m6429q();
        }
    }

    /* renamed from: g */
    private byte[] m6437g() {
        if (this.f6410j == 1) {
            throw new RuntimeException("OP_FORMAT_SD doesn't have OP_DIR_GET op");
        }
        byte[] bArr = {(byte) m6503k(), (byte) (this.f6409i | (this.f6410j << 7))};
        this.f6412l = bArr;
        return bArr;
    }

    /* renamed from: h */
    private byte[] m6436h() {
        if (this.f6410j == 0) {
            throw new RuntimeException("OP_SD_INFO doesn't have OP_DIR_SET op");
        }
        byte[] bArr = {(byte) m6503k(), (byte) (this.f6409i | (this.f6410j << 7))};
        this.f6412l = bArr;
        return bArr;
    }

    /* renamed from: i */
    private byte[] m6435i() {
        byte[] bArr;
        if (this.f6410j == 0) {
            bArr = new byte[3];
        } else {
            bArr = new byte[2];
        }
        bArr[0] = (byte) m6503k();
        int i = this.f6409i;
        int i2 = this.f6410j;
        bArr[1] = (byte) (i | (i2 << 7));
        if (i2 == 0) {
            bArr[2] = (byte) ((Integer) this.f6411k.get("key_res")).intValue();
        }
        this.f6412l = bArr;
        return bArr;
    }

    /* renamed from: l */
    private byte[] m6434l() {
        byte[] bArr;
        if (this.f6410j == 0) {
            bArr = new byte[3];
        } else {
            bArr = new byte[2];
        }
        bArr[0] = (byte) m6503k();
        int i = this.f6409i;
        int i2 = this.f6410j;
        bArr[1] = (byte) (i | (i2 << 7));
        if (i2 == 0) {
            bArr[2] = (byte) ((Integer) this.f6411k.get("key_fps")).intValue();
        }
        this.f6412l = bArr;
        return bArr;
    }

    /* renamed from: m */
    private byte[] m6433m() {
        byte[] bArr;
        if (this.f6410j == 0) {
            bArr = new byte[3];
        } else {
            bArr = new byte[2];
        }
        bArr[0] = (byte) m6503k();
        int i = this.f6409i;
        int i2 = this.f6410j;
        bArr[1] = (byte) (i | (i2 << 7));
        if (i2 == 0) {
            bArr[2] = (byte) ((Integer) this.f6411k.get("key_fov")).intValue();
        }
        this.f6412l = bArr;
        return bArr;
    }

    /* renamed from: n */
    private byte[] m6432n() {
        byte[] bArr;
        if (this.f6410j == 0) {
            bArr = new byte[3];
        } else {
            bArr = new byte[2];
        }
        bArr[0] = (byte) m6503k();
        int i = this.f6409i;
        int i2 = this.f6410j;
        bArr[1] = (byte) (i | (i2 << 7));
        if (i2 == 0) {
            bArr[2] = (byte) ((Integer) this.f6411k.get("key_exposure_mode")).intValue();
        }
        this.f6412l = bArr;
        return bArr;
    }

    /* renamed from: o */
    private byte[] m6431o() {
        byte[] bArr;
        if (this.f6410j == 0) {
            bArr = new byte[3];
        } else {
            bArr = new byte[2];
        }
        bArr[0] = (byte) m6503k();
        int i = this.f6409i;
        int i2 = this.f6410j;
        bArr[1] = (byte) (i | (i2 << 7));
        if (i2 == 0) {
            bArr[2] = (byte) ((Integer) this.f6411k.get("key_exposure_target")).intValue();
        }
        this.f6412l = bArr;
        return bArr;
    }

    /* renamed from: p */
    private byte[] m6430p() {
        byte[] bArr;
        if (this.f6410j == 0) {
            bArr = new byte[4];
        } else {
            bArr = new byte[2];
        }
        bArr[0] = (byte) m6503k();
        int i = this.f6409i;
        int i2 = this.f6410j;
        bArr[1] = (byte) (i | (i2 << 7));
        if (i2 == 0) {
            System.arraycopy(m6442a((short) ((Integer) this.f6411k.get("key_shutter_speed")).intValue()), 0, bArr, 2, 2);
        }
        this.f6412l = bArr;
        return bArr;
    }

    /* renamed from: q */
    private byte[] m6429q() {
        byte[] bArr;
        if (this.f6410j == 0) {
            bArr = new byte[3];
        } else {
            bArr = new byte[2];
        }
        bArr[0] = (byte) m6503k();
        int i = this.f6409i;
        int i2 = this.f6410j;
        bArr[1] = (byte) (i | (i2 << 7));
        if (i2 == 0) {
            bArr[2] = (byte) ((Integer) this.f6411k.get("key_iso_value")).intValue();
        }
        this.f6412l = bArr;
        return bArr;
    }

    /* renamed from: r */
    private byte[] m6428r() {
        byte[] bArr;
        if (this.f6410j == 0) {
            bArr = new byte[4];
        } else {
            bArr = new byte[2];
        }
        bArr[0] = (byte) m6503k();
        int i = this.f6409i;
        int i2 = this.f6410j;
        bArr[1] = (byte) (i | (i2 << 7));
        if (i2 == 0) {
            bArr[2] = (byte) ((Integer) this.f6411k.get("key_wb_red_channel_value")).intValue();
            bArr[3] = (byte) ((Integer) this.f6411k.get("key_wb_blue_channel_value")).intValue();
        }
        this.f6412l = bArr;
        return bArr;
    }

    /* renamed from: s */
    private byte[] m6427s() {
        byte[] bArr;
        if (this.f6410j == 0) {
            bArr = new byte[6];
        } else {
            bArr = new byte[2];
        }
        bArr[0] = (byte) m6503k();
        int i = this.f6409i;
        int i2 = this.f6410j;
        bArr[1] = (byte) (i | (i2 << 7));
        if (i2 == 0) {
            bArr[2] = (byte) ((Integer) this.f6411k.get("key_brightness")).intValue();
            bArr[3] = (byte) ((Integer) this.f6411k.get("key_sharpness")).intValue();
            bArr[4] = (byte) ((Integer) this.f6411k.get("key_contrast")).intValue();
            bArr[5] = (byte) ((Integer) this.f6411k.get("key_saturation")).intValue();
        }
        this.f6412l = bArr;
        return bArr;
    }

    /* renamed from: t */
    private byte[] m6426t() {
        byte[] bArr;
        if (this.f6410j == 0) {
            bArr = new byte[3];
        } else {
            bArr = new byte[2];
        }
        bArr[0] = (byte) m6503k();
        int i = this.f6409i;
        int i2 = this.f6410j;
        bArr[1] = (byte) (i | (i2 << 7));
        if (i2 == 0) {
            bArr[2] = (byte) ((Integer) this.f6411k.get("key_wb_mode")).intValue();
        }
        this.f6412l = bArr;
        return bArr;
    }

    /* renamed from: a */
    private byte[] m6442a(short s) {
        return ByteBuffer.allocate(2).order(ByteOrder.BIG_ENDIAN).putShort(s).array();
    }

    /* renamed from: a */
    public static int m6444a(int i) {
        switch (i) {
            case 1:
                return 100;
            case 2:
                return 200;
            case 3:
                return 400;
            case 4:
                return 800;
            case 5:
                return 1600;
            case 6:
                return 3200;
            case 7:
                return 6400;
            default:
                throw new RuntimeException("unknown iso value : " + i);
        }
    }

    /* renamed from: b */
    public static int m6441b(int i) {
        switch (i) {
            case 0:
                return 1;
            case 1:
                return 2;
            case 2:
                return 3;
            case 3:
                return 4;
            case 4:
                return 5;
            case 5:
                return 6;
            case 6:
                return 7;
            default:
                throw new RuntimeException("unknown iso index : " + i);
        }
    }

    public String toString() {
        String str = this.f6410j == 1 ? "Get" : "Set";
        String str2 = "unknown";
        switch (this.f6409i) {
            case 1:
                str2 = "res";
                break;
            case 2:
                str2 = "fps";
                break;
            case 3:
                str2 = "fov";
                break;
            case 6:
                str2 = "sd-info";
                break;
            case 7:
                str2 = "exposure-mode";
                break;
            case 8:
                str2 = "shutter-speed";
                break;
            case 9:
                str2 = "exposure-value";
                break;
            case 10:
                str2 = "white-balance-mode";
                break;
            case 11:
                str2 = "white-balance-value";
                break;
            case 13:
                str2 = "iso";
                break;
        }
        StringBuilder sb = new StringBuilder();
        Map<String, Object> map = this.f6411k;
        if (map != null) {
            for (String str3 : map.keySet()) {
                sb.append(String.format("key=%s,value=%S;", str3, this.f6411k.get(str3)));
            }
        }
        return String.format("MSG_CAMERA_SETTING(op = %s, dir = %s, param=[%s])", str2, str, sb.toString());
    }
}
