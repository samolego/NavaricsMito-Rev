package com.navatics.robot.protocol;

import java.security.InvalidParameterException;
import org.apache.commons.pool2.BaseKeyedPooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;

/* renamed from: com.navatics.robot.protocol.al */
/* loaded from: classes.dex */
public class ReplyMessageFactory extends BaseKeyedPooledObjectFactory<String, ReplyMessage> {
    @Override // org.apache.commons.pool2.BaseKeyedPooledObjectFactory, org.apache.commons.pool2.KeyedPooledObjectFactory
    /* renamed from: a */
    public /* bridge */ /* synthetic */ void mo2190a(Object obj, PooledObject pooledObject) throws Exception {
        m6513a((String) obj, (PooledObject<ReplyMessage>) pooledObject);
    }

    @Override // org.apache.commons.pool2.BaseKeyedPooledObjectFactory
    /* renamed from: a */
    public ReplyMessage mo2193b(String str) throws Exception {
        if (str.equals(StatusResponse.class.getSimpleName())) {
            return new StatusResponse();
        }
        if (str.equals(GetResolutionReply.class.getSimpleName())) {
            return new GetResolutionReply();
        }
        if (str.equals(GetFrameRateReply.class.getSimpleName())) {
            return new GetFrameRateReply();
        }
        if (str.equals(GetWideAngleModeReply.class.getSimpleName())) {
            return new GetWideAngleModeReply();
        }
        if (str.equals(GetSDCardInfoReply.class.getSimpleName())) {
            return new GetSDCardInfoReply();
        }
        if (str.equals(GetExposureModeReply.class.getSimpleName())) {
            return new GetExposureModeReply();
        }
        if (str.equals(GetShutterSpeedReply.class.getSimpleName())) {
            return new GetShutterSpeedReply();
        }
        if (str.equals(GetExposureTargetReply.class.getSimpleName())) {
            return new GetExposureTargetReply();
        }
        if (str.equals(GetWhiteBalanceModeReply.class.getSimpleName())) {
            return new GetWhiteBalanceModeReply();
        }
        if (str.equals(GetWhiteBalanceValueReply.class.getSimpleName())) {
            return new GetWhiteBalanceValueReply();
        }
        if (str.equals(GetEffectValueReply.class.getSimpleName())) {
            return new GetEffectValueReply();
        }
        if (str.equals(GetISOReply.class.getSimpleName())) {
            return new GetISOReply();
        }
        if (str.equals(ErrorResponse.class.getSimpleName())) {
            return new ErrorResponse();
        }
        if (str.equals(GetCameraModeReply.class.getSimpleName())) {
            return new GetCameraModeReply();
        }
        if (str.equals(GetFirmwareVersionReply.class.getSimpleName())) {
            return new GetFirmwareVersionReply();
        }
        throw new InvalidParameterException("Unknown obj type : " + str);
    }

    @Override // org.apache.commons.pool2.BaseKeyedPooledObjectFactory
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public PooledObject<ReplyMessage> mo2194a(ReplyMessage replyMessage) {
        return new DefaultPooledObject(replyMessage);
    }

    /* renamed from: a */
    public void m6513a(String str, PooledObject<ReplyMessage> pooledObject) throws Exception {
        pooledObject.mo2097a().mo6375b();
    }
}
