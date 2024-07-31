package com.navatics.app.player.widget.media;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TextView;
import com.navatics.app.R;

/* renamed from: com.navatics.app.player.widget.media.f */
/* loaded from: classes.dex */
public class TableLayoutBinder {

    /* renamed from: a */
    public ViewGroup f5003a;

    /* renamed from: b */
    public TableLayout f5004b;

    /* renamed from: c */
    private Context f5005c;

    public TableLayoutBinder(Context context, TableLayout tableLayout) {
        this.f5005c = context;
        this.f5003a = tableLayout;
        this.f5004b = tableLayout;
    }

    /* renamed from: a */
    public View m7528a(String str, String str2) {
        return m7532a(R.layout.table_media_info_row2, str, str2);
    }

    /* renamed from: a */
    public View m7533a(int i, String str) {
        return m7528a(this.f5005c.getString(i), str);
    }

    /* renamed from: a */
    public View m7532a(int i, String str, String str2) {
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.f5005c).inflate(i, (ViewGroup) this.f5004b, false);
        m7529a(viewGroup, str, str2);
        this.f5004b.addView(viewGroup);
        return viewGroup;
    }

    /* renamed from: a */
    public C1885a m7531a(View view) {
        C1885a c1885a = (C1885a) view.getTag();
        if (c1885a == null) {
            C1885a c1885a2 = new C1885a();
            c1885a2.f5006a = (TextView) view.findViewById(R.id.name);
            c1885a2.f5007b = (TextView) view.findViewById(R.id.value);
            view.setTag(c1885a2);
            return c1885a2;
        }
        return c1885a;
    }

    /* renamed from: a */
    public void m7529a(View view, String str, String str2) {
        C1885a m7531a = m7531a(view);
        m7531a.m7527a(str);
        m7531a.m7526b(str2);
    }

    /* renamed from: a */
    public void m7530a(View view, String str) {
        m7531a(view).m7526b(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: TableLayoutBinder.java */
    /* renamed from: com.navatics.app.player.widget.media.f$a */
    /* loaded from: classes.dex */
    public static class C1885a {

        /* renamed from: a */
        public TextView f5006a;

        /* renamed from: b */
        public TextView f5007b;

        private C1885a() {
        }

        /* renamed from: a */
        public void m7527a(String str) {
            TextView textView = this.f5006a;
            if (textView != null) {
                textView.setText(str);
            }
        }

        /* renamed from: b */
        public void m7526b(String str) {
            TextView textView = this.f5007b;
            if (textView != null) {
                textView.setText(str);
            }
        }
    }
}
