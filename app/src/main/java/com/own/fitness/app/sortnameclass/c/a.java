package com.own.fitness.app.sortnameclass.c;

import android.content.SharedPreferences;
import android.view.View;
import com.own.fitness.app.adapters.LanguageAdapter;
import com.own.fitness.app.fragments.LanguageFragment;
import com.own.fitness.app.aputils.RecyclerItemClickListener;


public final  class a implements RecyclerItemClickListener.onItemClickListener {


    private final  LanguageFragment f32a;
    private final  LanguageAdapter b;
    private final  String[] c;
    private final  SharedPreferences.Editor d;

    public  a(LanguageFragment languageFragment, LanguageAdapter languageAdapter, String[] strArr, SharedPreferences.Editor editor) {
        this.f32a = languageFragment;
        this.b = languageAdapter;
        this.c = strArr;
        this.d = editor;
    }

    public final void OnItem(View view, int i) {
        this.f32a.a(this.b, this.c, this.d,  i);
    }
}
