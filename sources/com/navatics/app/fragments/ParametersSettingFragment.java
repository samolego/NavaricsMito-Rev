package com.navatics.app.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.p008v4.app.Fragment;
import android.support.p008v4.view.InputDeviceCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import com.navatics.app.R;
import com.navatics.app.framework.GroundStation;
import com.navatics.app.framework.Navatics;
import com.navatics.app.framework.NvConnection;
import com.navatics.app.framework.NvRobot;
import com.navatics.app.framework.international.TextViewInternationalHelper;
import com.navatics.app.widget.ParametersInputDialog;
import com.navatics.robot.transport.NvDimension;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.C3044k;

/* loaded from: classes.dex */
public class ParametersSettingFragment extends Fragment {

    /* renamed from: g */
    private static final C3044k f4147g = C3044k.m1564a(ParametersSettingFragment.class);

    /* renamed from: a */
    ListView f4148a;

    /* renamed from: b */
    Button f4149b;

    /* renamed from: c */
    Button f4150c;

    /* renamed from: d */
    C1739a f4151d;

    /* renamed from: e */
    ImageView f4152e;

    /* renamed from: f */
    List<C1741b> f4153f;

    @Override // android.support.p008v4.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.parameters_setting_panel, viewGroup, false);
        Context context = getContext();
        if (context == null) {
            return null;
        }
        this.f4148a = (ListView) inflate.findViewById(R.id.listParametersSetting);
        this.f4152e = (ImageView) inflate.findViewById(R.id.tvListIndicator);
        this.f4149b = (Button) inflate.findViewById(R.id.btnResume);
        this.f4149b.setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.fragments.ParametersSettingFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                for (C1741b c1741b : ParametersSettingFragment.this.f4153f) {
                    c1741b.m8719a();
                }
                ParametersSettingFragment.this.f4151d.notifyDataSetChanged();
            }
        });
        this.f4150c = (Button) inflate.findViewById(R.id.btnSave);
        this.f4150c.setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.fragments.ParametersSettingFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SharedPreferences.Editor edit = ParametersSettingFragment.this.getContext().getSharedPreferences(ParametersSettingFragment.this.getResources().getString(R.string.pref_setting_name), 0).edit();
                HashMap hashMap = new HashMap();
                for (C1741b c1741b : ParametersSettingFragment.this.f4153f) {
                    c1741b.m8718a(edit);
                    hashMap.put(c1741b.f4163c, Integer.valueOf(c1741b.m8717b()));
                }
                edit.apply();
                GroundStation m7931h = Navatics.m7931h();
                String str = null;
                if (m7931h != null) {
                    NvConnection m8098m = m7931h.m8098m();
                    if (m8098m != null) {
                        NvRobot nvRobot = (NvRobot) m8098m.m7898a(InputDeviceCompat.SOURCE_TOUCHSCREEN);
                        if (nvRobot != null) {
                            Toast.makeText(ParametersSettingFragment.this.getContext(), ParametersSettingFragment.this.getString(R.string.save_success), 0).show();
                            nvRobot.m7704a((Map<String, Object>) hashMap);
                        } else {
                            str = "robot is null";
                        }
                    } else {
                        str = "No connection found";
                    }
                } else {
                    str = "Controller is not connected";
                }
                if (str != null) {
                    Toast.makeText(ParametersSettingFragment.this.getContext(), str, 0).show();
                }
            }
        });
        SharedPreferences sharedPreferences = context.getSharedPreferences(getResources().getString(R.string.pref_setting_name), 0);
        this.f4153f = new ArrayList();
        this.f4153f.add(new C1741b(1, getResources().getString(R.string.max_yaw_speed), getResources().getString(R.string.pref_key_max_yaw_speed), sharedPreferences, 30, 2.55f));
        this.f4153f.add(new C1741b(2, getResources().getString(R.string.max_forward_speed), getResources().getString(R.string.pref_key_max_forward_speed), sharedPreferences, 30, 2.55f));
        this.f4153f.add(new C1741b(3, getResources().getString(R.string.max_dive_speed), getResources().getString(R.string.pref_key_max_dive_speed), sharedPreferences, 30, 2.55f));
        this.f4153f.add(new C1741b(4, getResources().getString(R.string.max_depth), getResources().getString(R.string.pref_key_max_depth), sharedPreferences, 30, 2.55f));
        this.f4151d = new C1739a(this.f4153f, sharedPreferences);
        this.f4148a.setAdapter((ListAdapter) this.f4151d);
        this.f4148a.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.navatics.app.fragments.ParametersSettingFragment.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (i + i2 < i3 - 1) {
                    ParametersSettingFragment.this.f4152e.setVisibility(0);
                } else {
                    ParametersSettingFragment.this.f4152e.setVisibility(4);
                }
            }
        });
        return inflate;
    }

    @Override // android.support.p008v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        f4147g.mo1511a((Object) "onDestroyView");
    }

    /* renamed from: com.navatics.app.fragments.ParametersSettingFragment$a */
    /* loaded from: classes.dex */
    class C1739a extends BaseAdapter {

        /* renamed from: a */
        List<C1741b> f4157a;

        /* renamed from: b */
        SharedPreferences f4158b;

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return null;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return 0L;
        }

        C1739a(List<C1741b> list, SharedPreferences sharedPreferences) {
            this.f4158b = sharedPreferences;
            this.f4157a = list;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            List<C1741b> list = this.f4157a;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            C1742c c1742c;
            if (ParametersSettingFragment.this.getContext() == null) {
                return view;
            }
            if (view == null) {
                LayoutInflater layoutInflater = (LayoutInflater) ParametersSettingFragment.this.getContext().getSystemService("layout_inflater");
                if (layoutInflater == null) {
                    throw new RuntimeException("Can't get LAYOUT_INFLATER_SERVICE service");
                }
                view = layoutInflater.inflate(R.layout.parameters_setting_list_item, viewGroup, false);
                c1742c = new C1742c(this.f4158b);
                c1742c.f4169a = (TextView) view.findViewById(R.id.txTitle);
                c1742c.f4170b = (SeekBar) view.findViewById(R.id.valueBar);
                c1742c.f4171c = (TextView) view.findViewById(R.id.paraValueText);
                c1742c.f4171c.setTag(c1742c);
                c1742c.f4171c.setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.fragments.ParametersSettingFragment.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        ParametersInputDialog parametersInputDialog = new ParametersInputDialog();
                        parametersInputDialog.m7164a((C1742c) view2.getTag());
                        if (ParametersSettingFragment.this.getFragmentManager() != null) {
                            parametersInputDialog.show(ParametersSettingFragment.this.getFragmentManager(), "ParametersInputDialog");
                        }
                    }
                });
                if (this.f4157a.get(i).f4161a == 4) {
                    c1742c.f4172d = new TextViewInternationalHelper(c1742c.f4171c, NvDimension.f6538b);
                    c1742c.f4172d.m8055a(0);
                }
                c1742c.f4170b.setOnSeekBarChangeListener(c1742c);
                view.setTag(c1742c);
            } else {
                c1742c = (C1742c) view.getTag();
            }
            c1742c.f4174f = this.f4157a.get(i);
            c1742c.f4169a.setText(this.f4157a.get(i).f4162b);
            c1742c.f4170b.setProgress(this.f4157a.get(i).f4164d);
            ParametersSettingFragment.this.m8721a(c1742c.f4174f, c1742c);
            return view;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m8721a(C1741b c1741b, C1742c c1742c) {
        if (c1741b.f4161a == 4) {
            c1742c.f4172d.m8056a((int) ((((c1741b.f4164d * 1.0f) / 100.0f) * 39.0f) + 1.0f), NvDimension.f6538b.f6543c);
        } else if (c1741b.f4161a == 5) {
            TextView textView = c1742c.f4171c;
            textView.setText(((int) (((c1741b.f4164d * 1.0f) / 100.0f) * 45.0f)) + "°");
        } else {
            c1742c.f4171c.setText(getResources().getString(R.string.parameter_setting_list_item_value_text, Integer.valueOf(c1741b.f4164d)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.navatics.app.fragments.ParametersSettingFragment$c */
    /* loaded from: classes.dex */
    public class C1742c implements SeekBar.OnSeekBarChangeListener, ParametersInputDialog.InterfaceC1944a {

        /* renamed from: a */
        TextView f4169a;

        /* renamed from: b */
        SeekBar f4170b;

        /* renamed from: c */
        TextView f4171c;

        /* renamed from: d */
        TextViewInternationalHelper f4172d;

        /* renamed from: e */
        SharedPreferences f4173e;

        /* renamed from: f */
        C1741b f4174f;

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
        }

        C1742c(SharedPreferences sharedPreferences) {
            this.f4173e = sharedPreferences;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            C1741b c1741b = this.f4174f;
            c1741b.f4164d = i;
            ParametersSettingFragment.this.m8721a(c1741b, this);
        }

        @Override // com.navatics.app.widget.ParametersInputDialog.InterfaceC1944a
        /* renamed from: a */
        public void mo7160a(ParametersInputDialog parametersInputDialog) {
            this.f4174f.f4164d = parametersInputDialog.m7165a();
            ParametersSettingFragment.this.m8721a(this.f4174f, this);
            this.f4170b.setProgress(this.f4174f.f4164d);
            C3044k c3044k = ParametersSettingFragment.f4147g;
            c3044k.mo1511a((Object) ("onParametersInputOK value = " + this.f4174f.f4164d));
        }

        @Override // com.navatics.app.widget.ParametersInputDialog.InterfaceC1944a
        /* renamed from: b */
        public void mo7159b(ParametersInputDialog parametersInputDialog) {
            ParametersSettingFragment.f4147g.mo1511a((Object) "onParametersInputCancel");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.navatics.app.fragments.ParametersSettingFragment$b */
    /* loaded from: classes.dex */
    public class C1741b {

        /* renamed from: a */
        int f4161a;

        /* renamed from: b */
        String f4162b;

        /* renamed from: c */
        String f4163c;

        /* renamed from: d */
        int f4164d;

        /* renamed from: e */
        int f4165e;

        /* renamed from: f */
        float f4166f;

        /* renamed from: g */
        SharedPreferences f4167g;

        C1741b(int i, String str, String str2, SharedPreferences sharedPreferences, int i2, float f) {
            this.f4161a = i;
            this.f4162b = str;
            this.f4163c = str2;
            this.f4165e = i2;
            this.f4167g = sharedPreferences;
            this.f4166f = f;
            this.f4164d = this.f4167g.getInt(str2, i2);
        }

        /* renamed from: a */
        void m8718a(SharedPreferences.Editor editor) {
            editor.putInt(this.f4163c, this.f4164d);
        }

        /* renamed from: a */
        void m8719a() {
            this.f4164d = this.f4167g.getInt(this.f4163c, this.f4165e);
        }

        /* renamed from: b */
        int m8717b() {
            return (int) (this.f4164d * this.f4166f);
        }
    }
}
