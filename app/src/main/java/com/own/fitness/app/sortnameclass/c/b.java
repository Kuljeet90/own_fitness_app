package com.own.fitness.app.sortnameclass.c;

import android.view.View;
import com.own.fitness.app.adapters.LanguageAdapter;
import com.own.fitness.app.fragments.LanguageFragmentNew;
import com.own.fitness.app.aputils.RecyclerItemClickListener;


public final  class b implements RecyclerItemClickListener.onItemClickListener {


    private final  LanguageFragmentNew f33a;
    private final  LanguageAdapter b;
    private final  String[] c;

    public  b(LanguageFragmentNew languageFragmentNew, LanguageAdapter languageAdapter, String[] strArr) {
        this.f33a = languageFragmentNew;
        this.b = languageAdapter;
        this.c = strArr;
    }

    public final void OnItem(View view, int i) {
        this.f33a.a(this.b, this.c,  i);
    }
}
