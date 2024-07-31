package com.navatics.app.fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialog;
import android.support.p008v4.app.Fragment;
import android.support.p008v4.app.LoaderManager;
import android.support.p008v4.content.CursorLoader;
import android.support.p008v4.content.Loader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListAdapter;
import com.navatics.app.R;
import com.navatics.app.activities.PhotoViewer;
import com.navatics.app.fragments.IMultiSelectPage;
import com.navatics.app.framework.provider.PhotosProvider;
import com.navatics.app.model.Photo;
import com.navatics.app.model.PhotoContainer;
import com.navatics.app.utils.ImageLoader;
import com.navatics.nvtsshare.NvtsShare;
import com.navatics.robot.utils.DpiUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.log4j.C3044k;

/* loaded from: classes.dex */
public class MediaLibraryPhotoFragment extends Fragment implements LoaderManager.LoaderCallbacks<Cursor>, IMultiSelectPage {

    /* renamed from: a */
    public static final C3044k f4106a = C3044k.m1564a(MediaLibraryPhotoFragment.class);

    /* renamed from: b */
    private PhotoContainer f4107b;

    /* renamed from: d */
    private C1723b f4109d;

    /* renamed from: e */
    private IMultiSelectPage.Mode f4110e;

    /* renamed from: i */
    private IMultiSelectPageContainer f4114i;

    /* renamed from: c */
    private List<Photo> f4108c = new ArrayList();

    /* renamed from: f */
    private InterfaceC1747a f4111f = new C1722a();

    /* renamed from: g */
    private InterfaceC1747a f4112g = new C1724c();

    /* renamed from: h */
    private InterfaceC1747a f4113h = this.f4111f;

    /* renamed from: a */
    public static /* synthetic */ void m8757a(DialogInterface dialogInterface, int i) {
    }

    /* renamed from: lambda$EkFcgB4Zi_N6qgGhrvQy-xc6WCU */
    public static /* synthetic */ void m13043lambda$EkFcgB4Zi_N6qgGhrvQyxc6WCU(MediaLibraryPhotoFragment mediaLibraryPhotoFragment, DialogInterface dialogInterface, int i) {
        mediaLibraryPhotoFragment.m8748b(dialogInterface, i);
    }

    public static /* synthetic */ void lambda$FkmTRGi0w_BK_HuCau2t36EcCvc(MediaLibraryPhotoFragment mediaLibraryPhotoFragment, BottomSheetDialog bottomSheetDialog, View view) {
        mediaLibraryPhotoFragment.m8740e(bottomSheetDialog, view);
    }

    /* renamed from: lambda$Hp3L3m7Jgni-gq5-zf4GHfPRdps */
    public static /* synthetic */ void m13044lambda$Hp3L3m7Jgnigq5zf4GHfPRdps(MediaLibraryPhotoFragment mediaLibraryPhotoFragment, BottomSheetDialog bottomSheetDialog, View view) {
        mediaLibraryPhotoFragment.m8742d(bottomSheetDialog, view);
    }

    public static /* synthetic */ void lambda$fjTUyqhBqZ0apnKjhcMArMUulxs(DialogInterface dialogInterface, int i) {
        m8757a(dialogInterface, i);
    }

    /* renamed from: lambda$hOoVOZFIHqC459eIEqd59Na-sEE */
    public static /* synthetic */ void m13045lambda$hOoVOZFIHqC459eIEqd59NasEE(MediaLibraryPhotoFragment mediaLibraryPhotoFragment, BottomSheetDialog bottomSheetDialog, View view) {
        mediaLibraryPhotoFragment.m8744c(bottomSheetDialog, view);
    }

    public static /* synthetic */ void lambda$iWUmpoiZ5XYS3vgmR19mfpdF0W0(BottomSheetDialog bottomSheetDialog, View view) {
        bottomSheetDialog.dismiss();
    }

    public static /* synthetic */ void lambda$l4satSPFarOyk5hGLUI7nldzCyo(MediaLibraryPhotoFragment mediaLibraryPhotoFragment, AdapterView adapterView, View view, int i, long j) {
        mediaLibraryPhotoFragment.m8754a(adapterView, view, i, j);
    }

    /* renamed from: lambda$mBXOzD1rifMcsQ1dfI9h-fgAFa4 */
    public static /* synthetic */ void m13046lambda$mBXOzD1rifMcsQ1dfI9hfgAFa4(MediaLibraryPhotoFragment mediaLibraryPhotoFragment, BottomSheetDialog bottomSheetDialog, View view) {
        mediaLibraryPhotoFragment.m8747b(bottomSheetDialog, view);
    }

    /* renamed from: c */
    public static MediaLibraryPhotoFragment m8745c() {
        f4106a.mo1511a((Object) "MediaLibraryPhotoFragment.newInstance");
        Bundle bundle = new Bundle();
        MediaLibraryPhotoFragment mediaLibraryPhotoFragment = new MediaLibraryPhotoFragment();
        mediaLibraryPhotoFragment.setArguments(bundle);
        return mediaLibraryPhotoFragment;
    }

    @Override // com.navatics.app.fragments.IMultiSelectPage
    /* renamed from: a */
    public void mo8736a(IMultiSelectPageContainer iMultiSelectPageContainer) {
        this.f4114i = iMultiSelectPageContainer;
    }

    @Override // android.support.p008v4.app.Fragment
    public void onResume() {
        super.onResume();
        f4106a.mo1511a((Object) "onResume");
    }

    @Override // android.support.p008v4.app.LoaderManager.LoaderCallbacks
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        if (getContext() == null) {
            return null;
        }
        return new CursorLoader(getContext(), PhotosProvider.f4766a, null, null, null, null);
    }

    @Override // android.support.p008v4.app.LoaderManager.LoaderCallbacks
    /* renamed from: a */
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        this.f4107b = PhotoContainer.from(cursor);
        this.f4109d.notifyDataSetChanged();
    }

    @Override // android.support.p008v4.app.LoaderManager.LoaderCallbacks
    public void onLoaderReset(Loader<Cursor> loader) {
        this.f4107b = PhotoContainer.emptyList();
        this.f4109d.notifyDataSetChanged();
    }

    @Override // android.support.p008v4.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.media_photo_fragment, viewGroup, false);
        if (viewGroup2 == null) {
            throw new IllegalStateException("Cann't inflate layout of Photo fragment of Media Library");
        }
        this.f4109d = new C1723b();
        GridView gridView = (GridView) viewGroup2.findViewById(R.id.raw_photo_gridview);
        gridView.setVerticalScrollBarEnabled(false);
        gridView.setFastScrollEnabled(false);
        gridView.setAdapter((ListAdapter) this.f4109d);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.navatics.app.fragments.-$$Lambda$MediaLibraryPhotoFragment$l4satSPFarOyk5hGLUI7nldzCyo
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                MediaLibraryPhotoFragment.lambda$l4satSPFarOyk5hGLUI7nldzCyo(MediaLibraryPhotoFragment.this, adapterView, view, i, j);
            }
        });
        getLoaderManager().initLoader(0, null, this);
        return viewGroup2;
    }

    /* renamed from: a */
    public /* synthetic */ void m8754a(AdapterView adapterView, View view, int i, long j) {
        this.f4113h.mo8704a(view, i);
    }

    @Override // com.navatics.app.fragments.IMultiSelectPage
    /* renamed from: a */
    public void mo8738a(IMultiSelectPage.Mode mode) {
        C3044k c3044k = f4106a;
        c3044k.mo1511a((Object) ("onModeChange = " + mode));
        this.f4110e = mode;
        if (this.f4110e == IMultiSelectPage.Mode.CommonMode) {
            this.f4113h = this.f4111f;
            for (Photo photo : this.f4108c) {
                m8749a(photo, false);
            }
            this.f4108c.clear();
            C1723b c1723b = this.f4109d;
            if (c1723b != null) {
                c1723b.notifyDataSetChanged();
            }
        } else if (this.f4110e == IMultiSelectPage.Mode.MultiSelectMode) {
            this.f4113h = this.f4112g;
        }
    }

    @Override // com.navatics.app.fragments.IMultiSelectPage
    /* renamed from: a */
    public void mo8739a() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Delete " + this.f4108c.size() + " files ? ");
        builder.setMessage(getActivity().getString(R.string.files_removed_not_recovered));
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() { // from class: com.navatics.app.fragments.-$$Lambda$MediaLibraryPhotoFragment$EkFcgB4Zi_N6qgGhrvQy-xc6WCU
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                MediaLibraryPhotoFragment.m13043lambda$EkFcgB4Zi_N6qgGhrvQyxc6WCU(MediaLibraryPhotoFragment.this, dialogInterface, i);
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() { // from class: com.navatics.app.fragments.-$$Lambda$MediaLibraryPhotoFragment$fjTUyqhBqZ0apnKjhcMArMUulxs
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                MediaLibraryPhotoFragment.lambda$fjTUyqhBqZ0apnKjhcMArMUulxs(dialogInterface, i);
            }
        });
        builder.create().show();
    }

    /* renamed from: b */
    public /* synthetic */ void m8748b(DialogInterface dialogInterface, int i) {
        Iterator<Photo> it = this.f4108c.iterator();
        while (it.hasNext()) {
            if (new File(it.next().getUri()).delete()) {
                it.remove();
            }
        }
        this.f4114i.mo8703a(this.f4108c.size());
    }

    @Override // com.navatics.app.fragments.IMultiSelectPage
    /* renamed from: b */
    public void mo8734b() {
        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(getActivity());
        View inflate = getLayoutInflater().inflate(R.layout.share_panel_layout, (ViewGroup) null);
        ((ImageView) inflate.findViewById(R.id.ivFacebook)).setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.fragments.-$$Lambda$MediaLibraryPhotoFragment$FkmTRGi0w_BK_HuCau2t36EcCvc
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MediaLibraryPhotoFragment.lambda$FkmTRGi0w_BK_HuCau2t36EcCvc(MediaLibraryPhotoFragment.this, bottomSheetDialog, view);
            }
        });
        ((ImageView) inflate.findViewById(R.id.ivTwitter)).setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.fragments.-$$Lambda$MediaLibraryPhotoFragment$Hp3L3m7Jgni-gq5-zf4GHfPRdps
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MediaLibraryPhotoFragment.m13044lambda$Hp3L3m7Jgnigq5zf4GHfPRdps(MediaLibraryPhotoFragment.this, bottomSheetDialog, view);
            }
        });
        ((ImageView) inflate.findViewById(R.id.tvInstagram)).setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.fragments.-$$Lambda$MediaLibraryPhotoFragment$hOoVOZFIHqC459eIEqd59Na-sEE
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MediaLibraryPhotoFragment.m13045lambda$hOoVOZFIHqC459eIEqd59NasEE(MediaLibraryPhotoFragment.this, bottomSheetDialog, view);
            }
        });
        ((ImageView) inflate.findViewById(R.id.ivWeChat)).setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.fragments.-$$Lambda$MediaLibraryPhotoFragment$mBXOzD1rifMcsQ1dfI9h-fgAFa4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MediaLibraryPhotoFragment.m13046lambda$mBXOzD1rifMcsQ1dfI9hfgAFa4(MediaLibraryPhotoFragment.this, bottomSheetDialog, view);
            }
        });
        ((ImageButton) inflate.findViewById(R.id.btnCancel)).setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.fragments.-$$Lambda$MediaLibraryPhotoFragment$iWUmpoiZ5XYS3vgmR19mfpdF0W0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MediaLibraryPhotoFragment.lambda$iWUmpoiZ5XYS3vgmR19mfpdF0W0(BottomSheetDialog.this, view);
            }
        });
        bottomSheetDialog.setContentView(inflate);
        bottomSheetDialog.show();
    }

    /* renamed from: e */
    public /* synthetic */ void m8740e(BottomSheetDialog bottomSheetDialog, View view) {
        NvtsShare.m6614a(getActivity()).m6589d().m6596a(this.f4108c.get(0).getUri()).mo6594a();
        bottomSheetDialog.dismiss();
    }

    /* renamed from: d */
    public /* synthetic */ void m8742d(BottomSheetDialog bottomSheetDialog, View view) {
        NvtsShare.m6614a(getActivity()).m6591b().m6597a(this.f4108c.get(0).getUri()).mo6594a();
        bottomSheetDialog.dismiss();
    }

    /* renamed from: c */
    public /* synthetic */ void m8744c(BottomSheetDialog bottomSheetDialog, View view) {
        NvtsShare.m6614a(getActivity()).m6590c().m6596a(this.f4108c.get(0).getUri()).mo6594a();
        bottomSheetDialog.dismiss();
    }

    /* renamed from: b */
    public /* synthetic */ void m8747b(BottomSheetDialog bottomSheetDialog, View view) {
        NvtsShare.m6614a(getActivity()).m6592a().m6597a(this.f4108c.get(0).getUri()).mo6594a();
        bottomSheetDialog.dismiss();
    }

    @Override // com.navatics.app.fragments.IMultiSelectPage
    /* renamed from: a */
    public void mo8735a(boolean z) {
        if (z) {
            return;
        }
        for (Photo photo : this.f4108c) {
            m8749a(photo, false);
        }
        this.f4108c.clear();
    }

    /* renamed from: a */
    public void m8749a(Photo photo, boolean z) {
        photo.setTag("MediaLibraryPhotoFragment", z ? "MediaLibraryPhotoFragment_val" : null);
    }

    /* renamed from: a */
    public boolean m8750a(Photo photo) {
        Object tag = photo.getTag("MediaLibraryPhotoFragment");
        return tag != null && tag.equals("MediaLibraryPhotoFragment_val");
    }

    /* renamed from: com.navatics.app.fragments.MediaLibraryPhotoFragment$b */
    /* loaded from: classes.dex */
    public class C1723b extends BaseAdapter {
        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return 0L;
        }

        C1723b() {
            MediaLibraryPhotoFragment.this = r1;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (MediaLibraryPhotoFragment.this.f4107b == null) {
                return 0;
            }
            return MediaLibraryPhotoFragment.this.f4107b.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return MediaLibraryPhotoFragment.this.f4107b.get(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            C1725d c1725d;
            if (view == null) {
                view = MediaLibraryPhotoFragment.this.getLayoutInflater().inflate(R.layout.photo_frag_gridview_item, (ViewGroup) null);
                c1725d = new C1725d();
                c1725d.f4118a = (ImageView) view.findViewById(R.id.item_img);
                c1725d.f4119b = (ImageView) view.findViewById(R.id.ivSelectIndicator);
                view.setTag(c1725d);
            } else {
                c1725d = (C1725d) view.getTag();
            }
            Photo photo = MediaLibraryPhotoFragment.this.f4107b.get(i);
            if (MediaLibraryPhotoFragment.this.m8750a(photo)) {
                c1725d.f4119b.setVisibility(0);
            } else {
                c1725d.f4119b.setVisibility(4);
            }
            ImageLoader.m7398a().m7396a(MediaLibraryPhotoFragment.this.getActivity(), photo.getUri(), R.mipmap.ic_launcher, R.mipmap.category_normal, DpiUtils.m5887a(MediaLibraryPhotoFragment.this.getContext(), 2.0f), c1725d.f4118a);
            return view;
        }
    }

    /* renamed from: com.navatics.app.fragments.MediaLibraryPhotoFragment$d */
    /* loaded from: classes.dex */
    class C1725d {

        /* renamed from: a */
        ImageView f4118a;

        /* renamed from: b */
        ImageView f4119b;

        C1725d() {
            MediaLibraryPhotoFragment.this = r1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.navatics.app.fragments.MediaLibraryPhotoFragment$a */
    /* loaded from: classes.dex */
    public class C1722a implements InterfaceC1747a {
        C1722a() {
            MediaLibraryPhotoFragment.this = r1;
        }

        @Override // com.navatics.app.fragments.InterfaceC1747a
        /* renamed from: a */
        public void mo8704a(View view, int i) {
            Intent intent = new Intent(MediaLibraryPhotoFragment.this.getContext(), PhotoViewer.class);
            intent.putExtra("key_path_of_photo", i);
            MediaLibraryPhotoFragment.this.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.navatics.app.fragments.MediaLibraryPhotoFragment$c */
    /* loaded from: classes.dex */
    public class C1724c implements InterfaceC1747a {
        C1724c() {
            MediaLibraryPhotoFragment.this = r1;
        }

        @Override // com.navatics.app.fragments.InterfaceC1747a
        /* renamed from: a */
        public void mo8704a(View view, int i) {
            Photo photo = MediaLibraryPhotoFragment.this.f4107b.get(i);
            MediaLibraryPhotoFragment mediaLibraryPhotoFragment = MediaLibraryPhotoFragment.this;
            mediaLibraryPhotoFragment.m8749a(photo, !mediaLibraryPhotoFragment.m8750a(photo));
            if (MediaLibraryPhotoFragment.this.m8750a(photo)) {
                MediaLibraryPhotoFragment.this.f4108c.add(photo);
            } else {
                MediaLibraryPhotoFragment.this.f4108c.remove(photo);
            }
            MediaLibraryPhotoFragment.this.f4114i.mo8703a(MediaLibraryPhotoFragment.this.f4108c.size());
            MediaLibraryPhotoFragment.this.f4109d.notifyDataSetChanged();
        }
    }
}
