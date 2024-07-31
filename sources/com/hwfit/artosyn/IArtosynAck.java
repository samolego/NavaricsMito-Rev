package com.hwfit.artosyn;

import com.common.ARTOSYN_DEV_INFO;
import com.common.ARTOSYN_GND_STATUS;

/* loaded from: classes.dex */
public interface IArtosynAck {
    void devInfo(ARTOSYN_DEV_INFO artosyn_dev_info);

    void gndStatus(ARTOSYN_GND_STATUS artosyn_gnd_status);

    void rfInfo(RfMsg rfMsg);
}
