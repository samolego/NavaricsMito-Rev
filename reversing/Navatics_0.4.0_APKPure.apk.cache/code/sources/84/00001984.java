package com.navatics.app.player.widget.media;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TextView;
import com.navatics.app.R;

/* compiled from: TableLayoutBinder.java */
/* renamed from: com.navatics.app.player.widget.media.f, reason: use source file name */
/* loaded from: classes.dex */
public class TableLayoutBinder {

    /* renamed from: a */
    public ViewGroup f5025a;

    /* renamed from: b */
    public TableLayout f5026b;

    /* renamed from: c */
    private Context f5027c;

    public TableLayoutBinder(Context context, TableLayout tableLayout) {
        this.f5027c = context;
        this.f5025a = tableLayout;
        this.f5026b = tableLayout;
    }

    /* renamed from: a */
    public View m5379a(String str, String str2) {
        return m5378a(R.layout.table_media_info_row2, str, str2);
    }

    /* renamed from: a */
    public View m5377a(int i, String str) {
        return m5379a(this.f5027c.getString(i), str);
    }

    /* renamed from: a */
    public View m5378a(int i, String str, String str2) {
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.f5027c).inflate(i, (ViewGroup) this.f5026b, false);
        m5382a(viewGroup, str, str2);
        this.f5026b.addView(viewGroup);
        return viewGroup;
    }

    /* renamed from: a */
    public a m5380a(View view) {
        a aVar = (a) view.getTag();
        if (aVar != null) {
            return aVar;
        }
        a aVar2 = new a();
        aVar2.f5028a = (TextView) view.findViewById(R.id.name);
        aVar2.f5029b = (TextView) view.findViewById(R.id.value);
        view.setTag(aVar2);
        return aVar2;
    }

    /* renamed from: a */
    public void m5382a(View view, String str, String str2) {
        a m5380a = m5380a(view);
        m5380a.m5383a(str);
        m5380a.m5384b(str2);
    }

    /* renamed from: a */
    public void m5381a(View view, String str) {
        m5380a(view).m5384b(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: TableLayoutBinder.java */
    /* renamed from: com.navatics.app.player.widget.media.f$a */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a */
        public TextView f5028a;

        /* renamed from: b */
        public TextView f5029b;

        private a() {
        }

        /* renamed from: a */
        public void m5383a(String str) {
            TextView textView = this.f5028a;
            if (textView != null) {
                textView.setText(str);
            }
        }

        /* renamed from: b */
        public void m5384b(String str) {
            TextView textView = this.f5029b;
            if (textView != null) {
                textView.setText(str);
            }
        }
    }
}