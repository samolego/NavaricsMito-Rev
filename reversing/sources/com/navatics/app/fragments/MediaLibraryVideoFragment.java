package com.navatics.app.fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.p008v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.Toast;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.p031a.Target;
import com.navatics.app.R;
import com.navatics.app.activities.VideoPlayerActivity;
import com.navatics.app.fragments.IMultiSelectPage;
import com.navatics.app.framework.Settings;
import com.navatics.app.utils.ImageLoader;
import com.navatics.robot.utils.DpiUtils;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.C3044k;

/* loaded from: classes.dex */
public class MediaLibraryVideoFragment extends Fragment implements IMultiSelectPage {

    /* renamed from: a */
    public static final C3044k f4121a = C3044k.m1564a(MediaLibraryPhotoFragment.class);

    /* renamed from: b */
    private String f4122b;

    /* renamed from: c */
    private List<C1733c> f4123c;

    /* renamed from: e */
    private C1731b f4125e;

    /* renamed from: f */
    private IMultiSelectPage.Mode f4126f;

    /* renamed from: j */
    private IMultiSelectPageContainer f4130j;

    /* renamed from: d */
    private List<C1733c> f4124d = new ArrayList();

    /* renamed from: g */
    private InterfaceC1747a f4127g = new C1730a();

    /* renamed from: h */
    private InterfaceC1747a f4128h = new C1734d();

    /* renamed from: i */
    private InterfaceC1747a f4129i = this.f4127g;

    /* renamed from: c */
    public static MediaLibraryVideoFragment m8732c() {
        f4121a.mo1511a((Object) "MediaLibraryVideoFragment.newInstance");
        Bundle bundle = new Bundle();
        MediaLibraryVideoFragment mediaLibraryVideoFragment = new MediaLibraryVideoFragment();
        mediaLibraryVideoFragment.setArguments(bundle);
        return mediaLibraryVideoFragment;
    }

    @Override // com.navatics.app.fragments.IMultiSelectPage
    /* renamed from: a */
    public void mo8736a(IMultiSelectPageContainer iMultiSelectPageContainer) {
        this.f4130j = iMultiSelectPageContainer;
    }

    @Override // android.support.p008v4.app.Fragment
    public void onResume() {
        super.onResume();
        m8730d();
    }

    @Override // android.support.p008v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.media_video_fragment, (ViewGroup) null, false);
        if (viewGroup2 == null) {
            throw new IllegalStateException("Cann't inflate layout of Video fragment of Media Library");
        }
        m8728e();
        this.f4125e = new C1731b();
        GridView gridView = (GridView) viewGroup2.findViewById(R.id.raw_video_gridview);
        gridView.setVerticalScrollBarEnabled(false);
        gridView.setFastScrollEnabled(false);
        gridView.setAdapter((ListAdapter) this.f4125e);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.navatics.app.fragments.MediaLibraryVideoFragment.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                MediaLibraryVideoFragment.this.f4129i.mo8704a(view, i);
            }
        });
        return viewGroup2;
    }

    @Override // com.navatics.app.fragments.IMultiSelectPage
    /* renamed from: a */
    public void mo8738a(IMultiSelectPage.Mode mode) {
        C3044k c3044k = f4121a;
        c3044k.mo1511a((Object) ("onModeChange = " + mode));
        this.f4126f = mode;
        if (this.f4126f == IMultiSelectPage.Mode.CommonMode) {
            this.f4129i = this.f4127g;
            for (C1733c c1733c : this.f4124d) {
                c1733c.f4140b = false;
            }
            this.f4124d.clear();
            this.f4125e.notifyDataSetChanged();
        } else if (this.f4126f == IMultiSelectPage.Mode.MultiSelectMode) {
            this.f4129i = this.f4128h;
        }
    }

    @Override // com.navatics.app.fragments.IMultiSelectPage
    /* renamed from: a */
    public void mo8739a() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Delete " + this.f4124d.size() + " files ? ");
        builder.setMessage("Your files will be deleted immediately and CAN NOT be recovered.");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() { // from class: com.navatics.app.fragments.MediaLibraryVideoFragment.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                for (C1733c c1733c : MediaLibraryVideoFragment.this.f4124d) {
                    new File(c1733c.f4139a).delete();
                    MediaLibraryVideoFragment.this.f4123c.remove(c1733c);
                }
                MediaLibraryVideoFragment.this.f4124d.clear();
                MediaLibraryVideoFragment.this.f4130j.mo8703a(0);
                MediaLibraryVideoFragment.this.m8730d();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() { // from class: com.navatics.app.fragments.MediaLibraryVideoFragment.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        builder.create().show();
    }

    @Override // com.navatics.app.fragments.IMultiSelectPage
    /* renamed from: b */
    public void mo8734b() {
        Toast.makeText(getContext(), "share clicked", 0).show();
    }

    @Override // com.navatics.app.fragments.IMultiSelectPage
    /* renamed from: a */
    public void mo8735a(boolean z) {
        if (z) {
            return;
        }
        for (C1733c c1733c : this.f4124d) {
            c1733c.f4140b = false;
        }
        this.f4124d.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m8730d() {
        m8728e();
        this.f4125e.notifyDataSetChanged();
    }

    /* renamed from: e */
    private void m8728e() {
        this.f4122b = Settings.m8618a().m8607e();
        File file = new File(this.f4122b);
        if (!file.exists()) {
            file.mkdirs();
        }
        File[] listFiles = file.listFiles(new FileFilter() { // from class: com.navatics.app.fragments.MediaLibraryVideoFragment.4
            @Override // java.io.FileFilter
            public boolean accept(File file2) {
                String name = file2.getName();
                return name.endsWith(".mp4") || name.endsWith(".avi") || name.endsWith(".mkv");
            }
        });
        if (listFiles != null && listFiles.length > 0) {
            ArrayList arrayList = new ArrayList();
            for (File file2 : listFiles) {
                arrayList.add(new C1733c(file2.getPath(), false));
            }
            this.f4123c = arrayList;
            return;
        }
        this.f4123c = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.navatics.app.fragments.MediaLibraryVideoFragment$c */
    /* loaded from: classes.dex */
    public class C1733c {

        /* renamed from: a */
        String f4139a;

        /* renamed from: b */
        boolean f4140b;

        C1733c(String str, boolean z) {
            this.f4139a = str;
            this.f4140b = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.navatics.app.fragments.MediaLibraryVideoFragment$b */
    /* loaded from: classes.dex */
    public class C1731b extends BaseAdapter {
        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return 0L;
        }

        C1731b() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (MediaLibraryVideoFragment.this.f4123c == null) {
                return 0;
            }
            return MediaLibraryVideoFragment.this.f4123c.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return MediaLibraryVideoFragment.this.f4123c.get(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            final C1735e c1735e;
            C1733c c1733c = (C1733c) MediaLibraryVideoFragment.this.f4123c.get(i);
            if (view == null) {
                view = MediaLibraryVideoFragment.this.getLayoutInflater().inflate(R.layout.photo_frag_gridview_item, (ViewGroup) null);
                c1735e = new C1735e();
                c1735e.f4143a = (ImageView) view.findViewById(R.id.item_img);
                c1735e.f4144b = (ImageView) view.findViewById(R.id.ivSelectIndicator);
                c1735e.f4145c = (ImageView) view.findViewById(R.id.iv_pause);
                view.setTag(c1735e);
            } else {
                c1735e = (C1735e) view.getTag();
            }
            if (((C1733c) MediaLibraryVideoFragment.this.f4123c.get(i)).f4140b) {
                c1735e.f4144b.setVisibility(0);
            } else {
                c1735e.f4144b.setVisibility(4);
            }
            c1735e.f4145c.setVisibility(0);
            ImageLoader.m7398a().m7395a(MediaLibraryVideoFragment.this.getActivity(), c1733c.f4139a, R.mipmap.ic_launcher, R.drawable.video_gallery_item_err, DpiUtils.m5887a(MediaLibraryVideoFragment.this.getContext(), 2.0f), c1735e.f4143a, new RequestListener<Drawable>() { // from class: com.navatics.app.fragments.MediaLibraryVideoFragment.b.1
                @Override // com.bumptech.glide.request.RequestListener
                /* renamed from: a  reason: avoid collision after fix types in other method */
                public boolean mo8723a(Drawable drawable, Object obj, Target<Drawable> target, DataSource dataSource, boolean z) {
                    return false;
                }

                @Override // com.bumptech.glide.request.RequestListener
                /* renamed from: a */
                public boolean mo8724a(@Nullable GlideException glideException, Object obj, Target<Drawable> target, boolean z) {
                    c1735e.f4145c.setVisibility(8);
                    return false;
                }
            });
            return view;
        }
    }

    /* renamed from: com.navatics.app.fragments.MediaLibraryVideoFragment$e */
    /* loaded from: classes.dex */
    class C1735e {

        /* renamed from: a */
        ImageView f4143a;

        /* renamed from: b */
        ImageView f4144b;

        /* renamed from: c */
        ImageView f4145c;

        C1735e() {
        }
    }

    /* renamed from: com.navatics.app.fragments.MediaLibraryVideoFragment$a */
    /* loaded from: classes.dex */
    class C1730a implements InterfaceC1747a {
        C1730a() {
        }

        @Override // com.navatics.app.fragments.InterfaceC1747a
        /* renamed from: a */
        public void mo8704a(View view, int i) {
            Intent intent = new Intent(MediaLibraryVideoFragment.this.getContext(), VideoPlayerActivity.class);
            intent.putExtra("videoPath", ((C1733c) MediaLibraryVideoFragment.this.f4123c.get(i)).f4139a);
            MediaLibraryVideoFragment.this.startActivity(intent);
        }
    }

    /* renamed from: com.navatics.app.fragments.MediaLibraryVideoFragment$d */
    /* loaded from: classes.dex */
    class C1734d implements InterfaceC1747a {
        C1734d() {
        }

        @Override // com.navatics.app.fragments.InterfaceC1747a
        /* renamed from: a */
        public void mo8704a(View view, int i) {
            C1733c c1733c = (C1733c) MediaLibraryVideoFragment.this.f4123c.get(i);
            c1733c.f4140b = !c1733c.f4140b;
            if (c1733c.f4140b) {
                MediaLibraryVideoFragment.this.f4124d.add(c1733c);
            } else {
                MediaLibraryVideoFragment.this.f4124d.remove(c1733c);
            }
            MediaLibraryVideoFragment.this.f4130j.mo8703a(MediaLibraryVideoFragment.this.f4124d.size());
            MediaLibraryVideoFragment.this.f4125e.notifyDataSetChanged();
        }
    }
}
