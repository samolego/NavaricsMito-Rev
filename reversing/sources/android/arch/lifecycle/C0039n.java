package android.arch.lifecycle;

import java.util.HashMap;

/* renamed from: android.arch.lifecycle.n */
/* loaded from: classes.dex */
public class ViewModelStore {

    /* renamed from: a */
    private final HashMap<String, ViewModel> f73a = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final void m12848a(String str, ViewModel viewModel) {
        ViewModel put = this.f73a.put(str, viewModel);
        if (put != null) {
            put.onCleared();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final ViewModel m12849a(String str) {
        return this.f73a.get(str);
    }

    /* renamed from: a */
    public final void m12850a() {
        for (ViewModel viewModel : this.f73a.values()) {
            viewModel.onCleared();
        }
        this.f73a.clear();
    }
}
