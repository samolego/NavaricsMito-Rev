package com.senseplay.sdk.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.senseplay.sdk.screen.DualScreen;
import com.senseplay.sdk.screen.DualScreenHelper;
import com.senseplay.sdk.screen.DualScreenListener;

/* loaded from: classes2.dex */
public abstract class DualActivity extends BaseActivity implements DualScreenListener {
    private DualScreen dualScreen;
    private DualScreenHelper dualScreenHelper;

    protected abstract View getDualView();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.senseplay.sdk.activity.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initDual();
    }

    private void initDual() {
        this.dualScreenHelper = DualScreenHelper.getInstance(this);
        this.dualScreenHelper.showScreen(this);
    }

    @Override // com.senseplay.sdk.screen.DualScreenListener
    public void dualDisplay(DualScreen dualScreen) {
        if (dualScreen != null) {
            this.dualScreen = dualScreen;
            dualScreen.setLayoutView(getDualView());
            dualScreen.show();
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        DualScreenHelper dualScreenHelper = this.dualScreenHelper;
        if (dualScreenHelper != null) {
            dualScreenHelper.onActivityResult(i);
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        DualScreen dualScreen = this.dualScreen;
        if (dualScreen != null) {
            dualScreen.dismiss();
        }
    }
}
