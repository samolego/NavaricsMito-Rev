package com.navatics.app.framework.firmware;

import com.adapt.SPM_Manager;
import com.common.SP_ACK;
import com.navatics.p057cv.C1990a;
import com.navatics.robot.protocol.InputMessage;
import com.navatics.robot.protocol.OutputMessage;
import com.navatics.robot.protocol.UpdateFinishMessage;
import com.navatics.robot.protocol.UpdateReplyForCrcMessage;
import com.navatics.robot.protocol.UpdateReplyMessage;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

/* renamed from: com.navatics.app.framework.firmware.k */
/* loaded from: classes.dex */
public class SenseThinkSocket extends RobotSocket {
    SenseThinkSocket() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SenseThinkSocket(UpdateLogger updateLogger) {
        super(updateLogger);
    }

    @Override // com.navatics.app.framework.firmware.RobotSocket
    /* renamed from: a */
    public boolean mo8162a(OutputMessage outputMessage) throws IOException {
        UpdateLogger a = m8166a();
        a.mo8157a("send bytes : [" + outputMessage.toString() + "]");
        SPM_Manager.GetInstance().GetUserCmd().SendCmd((byte) -16, outputMessage.mo6368b());
        return false;
    }

    @Override // com.navatics.app.framework.firmware.RobotSocket
    /* renamed from: a */
    public InputMessage mo8163a(long j) throws IOException, InterruptedException, TimeoutException {
        SPM_Manager GetInstance = SPM_Manager.GetInstance();
        TimeoutTracker timeoutTracker = new TimeoutTracker(j);
        timeoutTracker.m8161a();
        while (true) {
            InputMessage inputMessage = null;
            if (!timeoutTracker.m8160b()) {
                SP_ACK GetAckInfo = GetInstance.GetUserCmd().GetAckInfo();
                if (GetAckInfo == null) {
                    Thread.sleep(50L);
                } else {
                    byte[] bArr = GetAckInfo.parameters;
                    if (bArr.length != 0 && GetAckInfo.paramLen > 0) {
                        UpdateLogger a = m8166a();
                        a.mo8155b("data : " + C1990a.m6854a(bArr));
                        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr, 0, bArr.length));
                        try {
                            if (dataInputStream.readUnsignedByte() != 241) {
                                dataInputStream.close();
                            } else {
                                int readUnsignedByte = dataInputStream.readUnsignedByte();
                                if (readUnsignedByte != 23) {
                                    switch (readUnsignedByte) {
                                        case 37:
                                            inputMessage = UpdateReplyMessage.m6456a(dataInputStream);
                                            break;
                                        case 38:
                                            inputMessage = UpdateReplyForCrcMessage.m6461a(dataInputStream);
                                            break;
                                        default:
                                            UpdateLogger a2 = m8166a();
                                            a2.mo8153d("unknown message id : " + String.format("0x%02x", Integer.valueOf(readUnsignedByte)));
                                            break;
                                    }
                                } else {
                                    inputMessage = UpdateFinishMessage.m6467a(dataInputStream);
                                }
                                dataInputStream.close();
                                if (inputMessage != null) {
                                    return inputMessage;
                                }
                            }
                        } catch (EOFException e) {
                            e.printStackTrace();
                            UpdateLogger a3 = m8166a();
                            a3.mo8154c("Got EOFException from input, input length : " + bArr.length);
                        }
                    }
                }
            } else if (timeoutTracker.m8160b()) {
                throw new TimeoutException("recv timeout after " + j + "ms");
            } else {
                return null;
            }
        }
    }
}
