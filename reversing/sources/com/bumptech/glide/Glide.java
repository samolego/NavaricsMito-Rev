package com.bumptech.glide;

import android.content.ComponentCallbacks2;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.p008v4.app.FragmentActivity;
import android.util.Log;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.p022a.ArrayPool;
import com.bumptech.glide.load.engine.p022a.BitmapPool;
import com.bumptech.glide.load.engine.p023b.MemoryCache;
import com.bumptech.glide.load.engine.p025d.BitmapPreFiller;
import com.bumptech.glide.load.p018a.DataRewinder;
import com.bumptech.glide.load.p018a.InputStreamRewinder;
import com.bumptech.glide.load.p020b.AssetUriLoader;
import com.bumptech.glide.load.p020b.ByteArrayLoader;
import com.bumptech.glide.load.p020b.ByteBufferEncoder;
import com.bumptech.glide.load.p020b.ByteBufferFileLoader;
import com.bumptech.glide.load.p020b.DataUrlLoader;
import com.bumptech.glide.load.p020b.FileLoader;
import com.bumptech.glide.load.p020b.GlideUrl;
import com.bumptech.glide.load.p020b.MediaStoreFileLoader;
import com.bumptech.glide.load.p020b.ResourceLoader;
import com.bumptech.glide.load.p020b.StreamEncoder;
import com.bumptech.glide.load.p020b.StringLoader;
import com.bumptech.glide.load.p020b.UnitModelLoader;
import com.bumptech.glide.load.p020b.UriLoader;
import com.bumptech.glide.load.p020b.UrlUriLoader;
import com.bumptech.glide.load.p020b.p021a.HttpGlideUrlLoader;
import com.bumptech.glide.load.p020b.p021a.HttpUriLoader;
import com.bumptech.glide.load.p020b.p021a.MediaStoreImageThumbLoader;
import com.bumptech.glide.load.p020b.p021a.MediaStoreVideoThumbLoader;
import com.bumptech.glide.load.p020b.p021a.UrlLoader;
import com.bumptech.glide.load.resource.bitmap.BitmapDrawableDecoder;
import com.bumptech.glide.load.resource.bitmap.BitmapDrawableEncoder;
import com.bumptech.glide.load.resource.bitmap.BitmapEncoder;
import com.bumptech.glide.load.resource.bitmap.ByteBufferBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.bumptech.glide.load.resource.bitmap.ResourceBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.StreamBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.UnitBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.VideoDecoder;
import com.bumptech.glide.load.resource.p026a.ByteBufferRewinder;
import com.bumptech.glide.load.resource.p027b.ResourceDrawableDecoder;
import com.bumptech.glide.load.resource.p027b.UnitDrawableDecoder;
import com.bumptech.glide.load.resource.p028c.FileDecoder;
import com.bumptech.glide.load.resource.p029d.ByteBufferGifDecoder;
import com.bumptech.glide.load.resource.p029d.GifDrawable;
import com.bumptech.glide.load.resource.p029d.GifDrawableEncoder;
import com.bumptech.glide.load.resource.p029d.GifFrameResourceDecoder;
import com.bumptech.glide.load.resource.p029d.StreamGifDecoder;
import com.bumptech.glide.load.resource.p030e.BitmapBytesTranscoder;
import com.bumptech.glide.load.resource.p030e.BitmapDrawableTranscoder;
import com.bumptech.glide.load.resource.p030e.DrawableBytesTranscoder;
import com.bumptech.glide.load.resource.p030e.GifDrawableBytesTranscoder;
import com.bumptech.glide.manager.ConnectivityMonitorFactory;
import com.bumptech.glide.manager.RequestManagerRetriever;
import com.bumptech.glide.p015b.GlideModule;
import com.bumptech.glide.p015b.ManifestParser;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.p031a.ImageViewTargetFactory;
import com.bumptech.glide.request.p031a.Target;
import com.bumptech.glide.util.C0791i;
import com.bumptech.glide.util.Preconditions;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* renamed from: com.bumptech.glide.e */
/* loaded from: classes.dex */
public class Glide implements ComponentCallbacks2 {

    /* renamed from: a */
    private static volatile Glide f423a;

    /* renamed from: b */
    private static volatile boolean f424b;

    /* renamed from: c */
    private final Engine f425c;

    /* renamed from: d */
    private final BitmapPool f426d;

    /* renamed from: e */
    private final MemoryCache f427e;

    /* renamed from: f */
    private final BitmapPreFiller f428f;

    /* renamed from: g */
    private final GlideContext f429g;

    /* renamed from: h */
    private final Registry f430h;

    /* renamed from: i */
    private final ArrayPool f431i;

    /* renamed from: j */
    private final RequestManagerRetriever f432j;

    /* renamed from: k */
    private final ConnectivityMonitorFactory f433k;

    /* renamed from: l */
    private final List<RequestManager> f434l = new ArrayList();

    /* renamed from: m */
    private MemoryCategory f435m = MemoryCategory.NORMAL;

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
    }

    @NonNull
    /* renamed from: a */
    public static Glide m12523a(@NonNull Context context) {
        if (f423a == null) {
            synchronized (Glide.class) {
                if (f423a == null) {
                    m12513c(context);
                }
            }
        }
        return f423a;
    }

    /* renamed from: c */
    private static void m12513c(@NonNull Context context) {
        if (f424b) {
            throw new IllegalStateException("You cannot call Glide.get() in registerComponents(), use the provided Glide instance instead");
        }
        f424b = true;
        m12511d(context);
        f424b = false;
    }

    /* renamed from: d */
    private static void m12511d(@NonNull Context context) {
        m12522a(context, new GlideBuilder());
    }

    /* renamed from: a */
    private static void m12522a(@NonNull Context context, @NonNull GlideBuilder glideBuilder) {
        Context applicationContext = context.getApplicationContext();
        GeneratedAppGlideModule m12505i = m12505i();
        List<GlideModule> emptyList = Collections.emptyList();
        if (m12505i == null || m12505i.mo12554c()) {
            emptyList = new ManifestParser(applicationContext).m12553a();
        }
        if (m12505i != null && !m12505i.mo12557a().isEmpty()) {
            Set<Class<?>> mo12557a = m12505i.mo12557a();
            Iterator<GlideModule> it = emptyList.iterator();
            while (it.hasNext()) {
                GlideModule next = it.next();
                if (mo12557a.contains(next.getClass())) {
                    if (Log.isLoggable("Glide", 3)) {
                        Log.d("Glide", "AppGlideModule excludes manifest GlideModule: " + next);
                    }
                    it.remove();
                }
            }
        }
        if (Log.isLoggable("Glide", 3)) {
            Iterator<GlideModule> it2 = emptyList.iterator();
            while (it2.hasNext()) {
                Log.d("Glide", "Discovered GlideModule from manifest: " + it2.next().getClass());
            }
        }
        glideBuilder.m12502a(m12505i != null ? m12505i.mo12556b() : null);
        for (GlideModule glideModule : emptyList) {
            glideModule.mo9571a(applicationContext, glideBuilder);
        }
        if (m12505i != null) {
            m12505i.mo9571a(applicationContext, glideBuilder);
        }
        Glide m12503a = glideBuilder.m12503a(applicationContext);
        for (GlideModule glideModule2 : emptyList) {
            glideModule2.mo9572a(applicationContext, m12503a, m12503a.f430h);
        }
        if (m12505i != null) {
            m12505i.mo9572a(applicationContext, m12503a, m12503a.f430h);
        }
        applicationContext.registerComponentCallbacks(m12503a);
        f423a = m12503a;
    }

    @Nullable
    /* renamed from: i */
    private static GeneratedAppGlideModule m12505i() {
        try {
            return (GeneratedAppGlideModule) Class.forName("com.bumptech.glide.b").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (ClassNotFoundException unused) {
            if (Log.isLoggable("Glide", 5)) {
                Log.w("Glide", "Failed to find GeneratedAppGlideModule. You should include an annotationProcessor compile dependency on com.github.bumptech.glide:compiler in your application and a @GlideModule annotated AppGlideModule implementation or LibraryGlideModules will be silently ignored");
            }
            return null;
        } catch (IllegalAccessException e) {
            m12518a(e);
            return null;
        } catch (InstantiationException e2) {
            m12518a(e2);
            return null;
        } catch (NoSuchMethodException e3) {
            m12518a(e3);
            return null;
        } catch (InvocationTargetException e4) {
            m12518a(e4);
            return null;
        }
    }

    /* renamed from: a */
    private static void m12518a(Exception exc) {
        throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", exc);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Glide(@NonNull Context context, @NonNull Engine engine, @NonNull MemoryCache memoryCache, @NonNull BitmapPool bitmapPool, @NonNull ArrayPool arrayPool, @NonNull RequestManagerRetriever requestManagerRetriever, @NonNull ConnectivityMonitorFactory connectivityMonitorFactory, int i, @NonNull RequestOptions requestOptions, @NonNull Map<Class<?>, TransitionOptions<?, ?>> map) {
        this.f425c = engine;
        this.f426d = bitmapPool;
        this.f431i = arrayPool;
        this.f427e = memoryCache;
        this.f432j = requestManagerRetriever;
        this.f433k = connectivityMonitorFactory;
        this.f428f = new BitmapPreFiller(memoryCache, bitmapPool, (DecodeFormat) requestOptions.m11661n().m12014a(Downsampler.f1045a));
        Resources resources = context.getResources();
        this.f430h = new Registry();
        this.f430h.m12627a((ImageHeaderParser) new DefaultImageHeaderParser());
        Downsampler downsampler = new Downsampler(this.f430h.m12628a(), resources.getDisplayMetrics(), bitmapPool, arrayPool);
        ByteBufferGifDecoder byteBufferGifDecoder = new ByteBufferGifDecoder(context, this.f430h.m12628a(), bitmapPool, arrayPool);
        ResourceDecoder<ParcelFileDescriptor, Bitmap> m11893b = VideoDecoder.m11893b(bitmapPool);
        ByteBufferBitmapDecoder byteBufferBitmapDecoder = new ByteBufferBitmapDecoder(downsampler);
        StreamBitmapDecoder streamBitmapDecoder = new StreamBitmapDecoder(downsampler, arrayPool);
        ResourceDrawableDecoder resourceDrawableDecoder = new ResourceDrawableDecoder(context);
        ResourceLoader.C0665c c0665c = new ResourceLoader.C0665c(resources);
        ResourceLoader.C0666d c0666d = new ResourceLoader.C0666d(resources);
        ResourceLoader.C0664b c0664b = new ResourceLoader.C0664b(resources);
        ResourceLoader.C0663a c0663a = new ResourceLoader.C0663a(resources);
        BitmapEncoder bitmapEncoder = new BitmapEncoder(arrayPool);
        BitmapBytesTranscoder bitmapBytesTranscoder = new BitmapBytesTranscoder();
        GifDrawableBytesTranscoder gifDrawableBytesTranscoder = new GifDrawableBytesTranscoder();
        ContentResolver contentResolver = context.getContentResolver();
        this.f430h.m12624a(ByteBuffer.class, new ByteBufferEncoder()).m12624a(InputStream.class, new StreamEncoder(arrayPool)).m12617a("Bitmap", ByteBuffer.class, Bitmap.class, byteBufferBitmapDecoder).m12617a("Bitmap", InputStream.class, Bitmap.class, streamBitmapDecoder).m12617a("Bitmap", ParcelFileDescriptor.class, Bitmap.class, m11893b).m12617a("Bitmap", AssetFileDescriptor.class, Bitmap.class, VideoDecoder.m11895a(bitmapPool)).m12622a(Bitmap.class, Bitmap.class, UnitModelLoader.C0670a.m12288b()).m12617a("Bitmap", Bitmap.class, Bitmap.class, new UnitBitmapDecoder()).m12623a(Bitmap.class, (ResourceEncoder) bitmapEncoder).m12617a("BitmapDrawable", ByteBuffer.class, BitmapDrawable.class, new BitmapDrawableDecoder(resources, byteBufferBitmapDecoder)).m12617a("BitmapDrawable", InputStream.class, BitmapDrawable.class, new BitmapDrawableDecoder(resources, streamBitmapDecoder)).m12617a("BitmapDrawable", ParcelFileDescriptor.class, BitmapDrawable.class, new BitmapDrawableDecoder(resources, m11893b)).m12623a(BitmapDrawable.class, (ResourceEncoder) new BitmapDrawableEncoder(bitmapPool, bitmapEncoder)).m12617a("Gif", InputStream.class, GifDrawable.class, new StreamGifDecoder(this.f430h.m12628a(), byteBufferGifDecoder, arrayPool)).m12617a("Gif", ByteBuffer.class, GifDrawable.class, byteBufferGifDecoder).m12623a(GifDrawable.class, (ResourceEncoder) new GifDrawableEncoder()).m12622a(GifDecoder.class, GifDecoder.class, UnitModelLoader.C0670a.m12288b()).m12617a("Bitmap", GifDecoder.class, Bitmap.class, new GifFrameResourceDecoder(bitmapPool)).m12621a(Uri.class, Drawable.class, resourceDrawableDecoder).m12621a(Uri.class, Bitmap.class, new ResourceBitmapDecoder(resourceDrawableDecoder, bitmapPool)).m12626a((DataRewinder.InterfaceC0616a<?>) new ByteBufferRewinder.C0737a()).m12622a(File.class, ByteBuffer.class, new ByteBufferFileLoader.C0637b()).m12622a(File.class, InputStream.class, new FileLoader.C0647e()).m12621a(File.class, File.class, new FileDecoder()).m12622a(File.class, ParcelFileDescriptor.class, new FileLoader.C0643b()).m12622a(File.class, File.class, UnitModelLoader.C0670a.m12288b()).m12626a((DataRewinder.InterfaceC0616a<?>) new InputStreamRewinder.C0621a(arrayPool)).m12622a(Integer.TYPE, InputStream.class, c0665c).m12622a(Integer.TYPE, ParcelFileDescriptor.class, c0664b).m12622a(Integer.class, InputStream.class, c0665c).m12622a(Integer.class, ParcelFileDescriptor.class, c0664b).m12622a(Integer.class, Uri.class, c0666d).m12622a(Integer.TYPE, AssetFileDescriptor.class, c0663a).m12622a(Integer.class, AssetFileDescriptor.class, c0663a).m12622a(Integer.TYPE, Uri.class, c0666d).m12622a(String.class, InputStream.class, new DataUrlLoader.C0640c()).m12622a(Uri.class, InputStream.class, new DataUrlLoader.C0640c()).m12622a(String.class, InputStream.class, new StringLoader.C0669c()).m12622a(String.class, ParcelFileDescriptor.class, new StringLoader.C0668b()).m12622a(String.class, AssetFileDescriptor.class, new StringLoader.C0667a()).m12622a(Uri.class, InputStream.class, new HttpUriLoader.C0626a()).m12622a(Uri.class, InputStream.class, new AssetUriLoader.C0624c(context.getAssets())).m12622a(Uri.class, ParcelFileDescriptor.class, new AssetUriLoader.C0623b(context.getAssets())).m12622a(Uri.class, InputStream.class, new MediaStoreImageThumbLoader.C0627a(context)).m12622a(Uri.class, InputStream.class, new MediaStoreVideoThumbLoader.C0628a(context)).m12622a(Uri.class, InputStream.class, new UriLoader.C0675d(contentResolver)).m12622a(Uri.class, ParcelFileDescriptor.class, new UriLoader.C0673b(contentResolver)).m12622a(Uri.class, AssetFileDescriptor.class, new UriLoader.C0672a(contentResolver)).m12622a(Uri.class, InputStream.class, new UrlUriLoader.C0676a()).m12622a(URL.class, InputStream.class, new UrlLoader.C0629a()).m12622a(Uri.class, File.class, new MediaStoreFileLoader.C0652a(context)).m12622a(GlideUrl.class, InputStream.class, new HttpGlideUrlLoader.C0625a()).m12622a(byte[].class, ByteBuffer.class, new ByteArrayLoader.C0630a()).m12622a(byte[].class, InputStream.class, new ByteArrayLoader.C0634d()).m12622a(Uri.class, Uri.class, UnitModelLoader.C0670a.m12288b()).m12622a(Drawable.class, Drawable.class, UnitModelLoader.C0670a.m12288b()).m12621a(Drawable.class, Drawable.class, new UnitDrawableDecoder()).m12620a(Bitmap.class, BitmapDrawable.class, new BitmapDrawableTranscoder(resources)).m12620a(Bitmap.class, byte[].class, bitmapBytesTranscoder).m12620a(Drawable.class, byte[].class, new DrawableBytesTranscoder(bitmapPool, bitmapBytesTranscoder, gifDrawableBytesTranscoder)).m12620a(GifDrawable.class, byte[].class, gifDrawableBytesTranscoder);
        this.f429g = new GlideContext(context, arrayPool, this.f430h, new ImageViewTargetFactory(), requestOptions, map, engine, i);
    }

    @NonNull
    /* renamed from: a */
    public BitmapPool m12525a() {
        return this.f426d;
    }

    @NonNull
    /* renamed from: b */
    public ArrayPool m12517b() {
        return this.f431i;
    }

    @NonNull
    /* renamed from: c */
    public Context m12514c() {
        return this.f429g.getBaseContext();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public ConnectivityMonitorFactory m12512d() {
        return this.f433k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    /* renamed from: e */
    public GlideContext m12510e() {
        return this.f429g;
    }

    /* renamed from: f */
    public void m12508f() {
        C0791i.m11575a();
        this.f427e.m12136a();
        this.f426d.mo12183a();
        this.f431i.mo12202a();
    }

    /* renamed from: a */
    public void m12524a(int i) {
        C0791i.m11575a();
        this.f427e.mo12135a(i);
        this.f426d.mo12182a(i);
        this.f431i.mo12201a(i);
    }

    @NonNull
    /* renamed from: g */
    public RequestManagerRetriever m12507g() {
        return this.f432j;
    }

    @NonNull
    /* renamed from: e */
    private static RequestManagerRetriever m12509e(@Nullable Context context) {
        Preconditions.m11579a(context, "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
        return m12523a(context).m12507g();
    }

    @NonNull
    /* renamed from: b */
    public static RequestManager m12516b(@NonNull Context context) {
        return m12509e(context).m11779a(context);
    }

    @NonNull
    /* renamed from: a */
    public static RequestManager m12521a(@NonNull FragmentActivity fragmentActivity) {
        return m12509e(fragmentActivity).m11776a(fragmentActivity);
    }

    @NonNull
    /* renamed from: h */
    public Registry m12506h() {
        return this.f430h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean m12519a(@NonNull Target<?> target) {
        synchronized (this.f434l) {
            for (RequestManager requestManager : this.f434l) {
                if (requestManager.m12434b(target)) {
                    return true;
                }
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m12520a(RequestManager requestManager) {
        synchronized (this.f434l) {
            if (this.f434l.contains(requestManager)) {
                throw new IllegalStateException("Cannot register already registered manager");
            }
            this.f434l.add(requestManager);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public void m12515b(RequestManager requestManager) {
        synchronized (this.f434l) {
            if (!this.f434l.contains(requestManager)) {
                throw new IllegalStateException("Cannot unregister not yet registered manager");
            }
            this.f434l.remove(requestManager);
        }
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        m12524a(i);
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        m12508f();
    }
}
