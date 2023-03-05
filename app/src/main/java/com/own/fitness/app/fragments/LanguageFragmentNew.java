package com.own.fitness.app.fragments;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.own.fitness.app.R;
import com.own.fitness.app.adapters.LanguageAdapter;
import com.own.fitness.app.aputils.AppUtils;
import com.own.fitness.app.aputils.CommonMethods;
import com.own.fitness.app.aputils.RecyclerItemClickListener;
import com.own.fitness.app.sortnameclass.c.b;

import java.util.Objects;

public class LanguageFragmentNew extends Fragment {
    CommonMethods commonMethods;
    SharedPreferences.Editor editor;
    String languageToLoad;
    SharedPreferences launchDataPreferences1;
    SharedPreferences.Editor prefsEditor;

    public void a(LanguageAdapter languageAdapter, String[] strArr,  int i) {
        ((FragmentActivity) Objects.requireNonNull(getActivity())).finish();
        languageAdapter.notifyDataSetChanged();
        this.languageToLoad = strArr[i];
        this.editor.putInt("position", i);
        this.editor.apply();
        this.prefsEditor = this.launchDataPreferences1.edit();
        this.prefsEditor.putString("languageToLoad", this.languageToLoad);
        this.prefsEditor.putBoolean("language", true);
        this.prefsEditor.apply();
        AppUtils.ifLanguageChnaged = true;
        this.commonMethods.updateLocale(this.languageToLoad);
        startActivity(getActivity().getIntent());
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FragmentActivity activity = getActivity();
        this.commonMethods = new CommonMethods(activity);
        this.launchDataPreferences1 = PreferenceManager.getDefaultSharedPreferences(activity);
        this.languageToLoad = this.launchDataPreferences1.getString("languageToLoad", "en");
        this.editor = PreferenceManager.getDefaultSharedPreferences(activity).edit();
        String[] strArr = {"en", "zh", "ru", "fr", "es", "ar", "ja", "de", "ko", "pt", "it", "in", "nl"};
        for (int i = 0; i < strArr.length; i++) {
            if (this.languageToLoad.equalsIgnoreCase(strArr[i])) {
                this.editor.putInt("position", i);
            }
        }
        View inflate = layoutInflater.inflate(R.layout.fragment_language_new, viewGroup, false);
        ((Toolbar) inflate.findViewById(R.id.languagetoolbar)).setNavigationOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ((FragmentActivity) Objects.requireNonNull(LanguageFragmentNew.this.getActivity())).onBackPressed();
            }
        });
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R.id.recycler_language);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), 1, false);
        LanguageAdapter languageAdapter = new LanguageAdapter(getResources().getStringArray(R.array.languagenames), getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(languageAdapter);
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getActivity(), new b(this, languageAdapter, strArr)));
        return inflate;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
