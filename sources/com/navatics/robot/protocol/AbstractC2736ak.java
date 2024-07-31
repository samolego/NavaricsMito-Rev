package com.navatics.robot.protocol;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.Locale;
import org.apache.commons.pool2.KeyedObjectPool;
import org.apache.commons.pool2.impl.GenericKeyedObjectPool;
import org.apache.commons.pool2.impl.GenericKeyedObjectPoolConfig;
import org.apache.log4j.C3044k;

/* renamed from: com.navatics.robot.protocol.ak */
/* loaded from: classes.dex */
public abstract class ReplyMessage extends InputMessage {

    /* renamed from: d */
    private static final C3044k f6270d = C3044k.m1564a(ReplyMessage.class);

    /* renamed from: e */
    private static KeyedObjectPool<String, ReplyMessage> f6271e;

    /* renamed from: a */
    abstract void mo6355a(DataInputStream dataInputStream) throws IOException;

    @Override // com.navatics.robot.protocol.InputMessage
    /* renamed from: e */
    public int mo6451e() {
        return 0;
    }

    /* renamed from: c */
    private static boolean m6518c() {
        try {
            Class.forName("java.lang.management.ManagementFactory");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    /* renamed from: h */
    static void m6517h() {
        if (f6271e == null) {
            synchronized (ReplyMessage.class) {
                if (f6271e == null) {
                    GenericKeyedObjectPoolConfig genericKeyedObjectPoolConfig = new GenericKeyedObjectPoolConfig();
                    genericKeyedObjectPoolConfig.m2117a(m6518c());
                    f6271e = new GenericKeyedObjectPool(new ReplyMessageFactory(), genericKeyedObjectPoolConfig);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ReplyMessage() {
        super(64);
    }

    /* renamed from: i */
    public static ErrorResponse m6516i() {
        m6517h();
        try {
            return (ErrorResponse) f6271e.mo2070a(ErrorResponse.class.getSimpleName());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public static ReplyMessage m6519a(DataInputStream dataInputStream, OutputMessage outputMessage) {
        ReplyMessage replyMessage;
        if (outputMessage == null) {
            f6270d.mo1504b((Object) "obtain ReplyMessage with NULL request!");
            return null;
        }
        m6517h();
        try {
            if (outputMessage instanceof CameraSettingMessage) {
                CameraSettingMessage cameraSettingMessage = (CameraSettingMessage) outputMessage;
                switch (cameraSettingMessage.m6440c()) {
                    case 1:
                        if (cameraSettingMessage.m6439d() == 0) {
                            replyMessage = f6271e.mo2070a(StatusResponse.class.getSimpleName());
                            break;
                        } else {
                            replyMessage = f6271e.mo2070a(GetResolutionReply.class.getSimpleName());
                            break;
                        }
                    case 2:
                        if (cameraSettingMessage.m6439d() == 0) {
                            replyMessage = f6271e.mo2070a(StatusResponse.class.getSimpleName());
                            break;
                        } else {
                            replyMessage = f6271e.mo2070a(GetFrameRateReply.class.getSimpleName());
                            break;
                        }
                    case 3:
                        if (cameraSettingMessage.m6439d() == 0) {
                            replyMessage = f6271e.mo2070a(StatusResponse.class.getSimpleName());
                            break;
                        } else {
                            replyMessage = f6271e.mo2070a(GetWideAngleModeReply.class.getSimpleName());
                            break;
                        }
                    case 4:
                    case 5:
                    default:
                        replyMessage = null;
                        break;
                    case 6:
                        if (cameraSettingMessage.m6439d() == 0) {
                            throw new RuntimeException("OP_SD_INFO doesn't have set op");
                        }
                        replyMessage = f6271e.mo2070a(GetSDCardInfoReply.class.getSimpleName());
                        break;
                    case 7:
                        if (cameraSettingMessage.m6439d() == 0) {
                            replyMessage = f6271e.mo2070a(StatusResponse.class.getSimpleName());
                            break;
                        } else {
                            replyMessage = f6271e.mo2070a(GetExposureModeReply.class.getSimpleName());
                            break;
                        }
                    case 8:
                        if (cameraSettingMessage.m6439d() == 0) {
                            replyMessage = f6271e.mo2070a(StatusResponse.class.getSimpleName());
                            break;
                        } else {
                            replyMessage = f6271e.mo2070a(GetShutterSpeedReply.class.getSimpleName());
                            break;
                        }
                    case 9:
                        if (cameraSettingMessage.m6439d() == 0) {
                            replyMessage = f6271e.mo2070a(StatusResponse.class.getSimpleName());
                            break;
                        } else {
                            replyMessage = f6271e.mo2070a(GetExposureTargetReply.class.getSimpleName());
                            break;
                        }
                    case 10:
                        if (cameraSettingMessage.m6439d() == 0) {
                            replyMessage = f6271e.mo2070a(StatusResponse.class.getSimpleName());
                            break;
                        } else {
                            replyMessage = f6271e.mo2070a(GetWhiteBalanceModeReply.class.getSimpleName());
                            break;
                        }
                    case 11:
                        if (cameraSettingMessage.m6439d() == 0) {
                            replyMessage = f6271e.mo2070a(StatusResponse.class.getSimpleName());
                            break;
                        } else {
                            replyMessage = f6271e.mo2070a(GetWhiteBalanceValueReply.class.getSimpleName());
                            break;
                        }
                    case 12:
                        if (cameraSettingMessage.m6439d() == 0) {
                            replyMessage = f6271e.mo2070a(StatusResponse.class.getSimpleName());
                            break;
                        } else {
                            replyMessage = f6271e.mo2070a(GetEffectValueReply.class.getSimpleName());
                            break;
                        }
                    case 13:
                        if (cameraSettingMessage.m6439d() == 0) {
                            replyMessage = f6271e.mo2070a(StatusResponse.class.getSimpleName());
                            break;
                        } else {
                            replyMessage = f6271e.mo2070a(GetISOReply.class.getSimpleName());
                            break;
                        }
                }
            } else if (outputMessage instanceof GetCameraModeMessage) {
                replyMessage = f6271e.mo2070a(GetCameraModeReply.class.getSimpleName());
            } else if (outputMessage instanceof CalibrateGyroMessage) {
                replyMessage = f6271e.mo2070a(StatusResponse.class.getSimpleName());
            } else if (outputMessage instanceof CalibrateAccMessage) {
                replyMessage = f6271e.mo2070a(StatusResponse.class.getSimpleName());
            } else if (outputMessage instanceof CalibrateCompassMessage) {
                replyMessage = f6271e.mo2070a(StatusResponse.class.getSimpleName());
            } else if (outputMessage instanceof CalibratePayloadMessage) {
                replyMessage = f6271e.mo2070a(StatusResponse.class.getSimpleName());
            } else if (outputMessage instanceof RecordStartMessage) {
                replyMessage = f6271e.mo2070a(StatusResponse.class.getSimpleName());
            } else if (outputMessage instanceof RecordStopMessage) {
                replyMessage = f6271e.mo2070a(StatusResponse.class.getSimpleName());
            } else if (outputMessage instanceof TakePhotoMessage) {
                replyMessage = f6271e.mo2070a(StatusResponse.class.getSimpleName());
            } else if (outputMessage instanceof SwitchModeMessage) {
                replyMessage = f6271e.mo2070a(StatusResponse.class.getSimpleName());
            } else if (outputMessage instanceof ParameterSettingMessage) {
                replyMessage = f6271e.mo2070a(StatusResponse.class.getSimpleName());
            } else if (outputMessage instanceof GetFirmwareVersionMessage) {
                replyMessage = f6271e.mo2070a(GetFirmwareVersionReply.class.getSimpleName());
            } else {
                f6270d.mo1504b((Object) ("cannot handle response for request : " + RobotMessage.m6505c(outputMessage.m6503k())));
                replyMessage = null;
            }
            if (replyMessage != null) {
                try {
                    replyMessage.mo6355a(dataInputStream);
                    return replyMessage;
                } catch (Exception e) {
                    e = e;
                    e.printStackTrace();
                    f6270d.mo1503b("obtain StatusMessage error !", e);
                    if (replyMessage != null) {
                        replyMessage.mo6369a();
                    }
                    return null;
                }
            }
            return replyMessage;
        } catch (Exception e2) {
            e = e2;
            replyMessage = null;
        }
    }

    @Override // com.navatics.robot.protocol.RobotMessage
    /* renamed from: a */
    public void mo6369a() {
        super.mo6369a();
        try {
            f6271e.mo2068a(getClass().getSimpleName(), this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    public void mo6375b() {
        m6504j();
    }

    public String toString() {
        return String.format(Locale.getDefault(), "ReplyMessage(0x%02x, 0x%02x)", Integer.valueOf(m6534g()), Integer.valueOf(m6503k()));
    }
}
