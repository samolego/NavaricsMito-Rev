package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.EncodeStrategy;

/* compiled from: DiskCacheStrategy.java */
/* renamed from: com.bumptech.glide.load.engine.h, reason: use source file name */
/* loaded from: classes.dex */
public abstract class DiskCacheStrategy {

    /* renamed from: a */
    public static final DiskCacheStrategy f899a = new DiskCacheStrategy() { // from class: com.bumptech.glide.load.engine.h.1
        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        /* renamed from: a */
        public boolean mo901a() {
            return true;
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        /* renamed from: b */
        public boolean mo904b() {
            return true;
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        /* renamed from: a */
        public boolean mo902a(DataSource dataSource) {
            return dataSource == DataSource.REMOTE;
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        /* renamed from: a */
        public boolean mo903a(boolean z, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return (dataSource == DataSource.RESOURCE_DISK_CACHE || dataSource == DataSource.MEMORY_CACHE) ? false : true;
        }
    };

    /* renamed from: b */
    public static final DiskCacheStrategy f900b = new DiskCacheStrategy() { // from class: com.bumptech.glide.load.engine.h.2
        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        /* renamed from: a */
        public boolean mo901a() {
            return false;
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        /* renamed from: a */
        public boolean mo902a(DataSource dataSource) {
            return false;
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        /* renamed from: a */
        public boolean mo903a(boolean z, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return false;
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        /* renamed from: b */
        public boolean mo904b() {
            return false;
        }
    };

    /* renamed from: c */
    public static final DiskCacheStrategy f901c = new DiskCacheStrategy() { // from class: com.bumptech.glide.load.engine.h.3
        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        /* renamed from: a */
        public boolean mo901a() {
            return false;
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        /* renamed from: a */
        public boolean mo903a(boolean z, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return false;
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        /* renamed from: b */
        public boolean mo904b() {
            return true;
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        /* renamed from: a */
        public boolean mo902a(DataSource dataSource) {
            return (dataSource == DataSource.DATA_DISK_CACHE || dataSource == DataSource.MEMORY_CACHE) ? false : true;
        }
    };

    /* renamed from: d */
    public static final DiskCacheStrategy f902d = new DiskCacheStrategy() { // from class: com.bumptech.glide.load.engine.h.4
        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        /* renamed from: a */
        public boolean mo901a() {
            return true;
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        /* renamed from: a */
        public boolean mo902a(DataSource dataSource) {
            return false;
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        /* renamed from: b */
        public boolean mo904b() {
            return false;
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        /* renamed from: a */
        public boolean mo903a(boolean z, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return (dataSource == DataSource.RESOURCE_DISK_CACHE || dataSource == DataSource.MEMORY_CACHE) ? false : true;
        }
    };

    /* renamed from: e */
    public static final DiskCacheStrategy f903e = new DiskCacheStrategy() { // from class: com.bumptech.glide.load.engine.h.5
        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        /* renamed from: a */
        public boolean mo901a() {
            return true;
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        /* renamed from: b */
        public boolean mo904b() {
            return true;
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        /* renamed from: a */
        public boolean mo902a(DataSource dataSource) {
            return dataSource == DataSource.REMOTE;
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        /* renamed from: a */
        public boolean mo903a(boolean z, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return ((z && dataSource == DataSource.DATA_DISK_CACHE) || dataSource == DataSource.LOCAL) && encodeStrategy == EncodeStrategy.TRANSFORMED;
        }
    };

    /* renamed from: a */
    public abstract boolean mo901a();

    /* renamed from: a */
    public abstract boolean mo902a(DataSource dataSource);

    /* renamed from: a */
    public abstract boolean mo903a(boolean z, DataSource dataSource, EncodeStrategy encodeStrategy);

    /* renamed from: b */
    public abstract boolean mo904b();
}