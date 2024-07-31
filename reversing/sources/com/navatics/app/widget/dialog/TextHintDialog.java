package com.navatics.app.widget.dialog;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.navatics.app.R;

/* loaded from: classes.dex */
public class TextHintDialog extends BaseDialog {

    /* renamed from: a */
    private TextView f5659a;

    /* renamed from: b */
    private TextView f5660b;

    public TextHintDialog(Context context, String str, String str2) {
        super(context, R.layout.dialog_common_layout);
        m6972b(str, str2);
    }

    /* renamed from: b */
    private void m6972b(String str, String str2) {
        this.f5659a = (TextView) findViewById(R.id.tv_title);
        this.f5660b = (TextView) findViewById(R.id.tv_center_btn);
        this.f5660b.setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.widget.dialog.TextHintDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TextHintDialog.this.dismiss();
            }
        });
        m6973a(str, str2);
    }

    /* renamed from: a */
    public void m6973a(String str, String str2) {
        this.f5659a.setText(str);
        this.f5660b.setText(str2);
    }
}
