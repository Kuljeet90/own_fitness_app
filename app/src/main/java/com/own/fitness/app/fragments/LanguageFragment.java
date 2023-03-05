package com.own.fitness.app.fragments;

import com.own.fitness.app.sortnameclass.c.a;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.own.fitness.app.R;
import com.own.fitness.app.adapters.LanguageAdapter;
import com.own.fitness.app.aputils.CommonMethods;
import com.own.fitness.app.aputils.RecyclerItemClickListener;
import java.util.Locale;
import java.util.Objects;

public class LanguageFragment extends Fragment {


     String f813a;
     SharedPreferences b;
     SharedPreferences c;
     CommonMethods commonMethods;
     SharedPreferences.Editor prefsEditor;

    private void updateLocale(String str) {
        Locale locale = new Locale(str);
        Resources resources = getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        Configuration configuration = resources.getConfiguration();
        configuration.locale = locale;
        resources.updateConfiguration(configuration, displayMetrics);
    }

    public  void a(LanguageAdapter languageAdapter, String[] strArr, SharedPreferences.Editor editor, int i) {
        ((FragmentActivity) Objects.requireNonNull(getActivity())).finish();
        languageAdapter.notifyDataSetChanged();
        this.f813a = strArr[i];
        editor.putInt("position", i);
        editor.apply();
        this.b = PreferenceManager.getDefaultSharedPreferences(getActivity().getApplicationContext());
        this.prefsEditor = this.b.edit();
        this.prefsEditor.putString("languageToLoad", this.f813a);
        this.prefsEditor.apply();
        this.commonMethods.updateLocale(this.f813a);
        startActivity(getActivity().getIntent());
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.commonMethods = new CommonMethods(getActivity());
        this.b = PreferenceManager.getDefaultSharedPreferences(getActivity().getApplicationContext());
        this.f813a = this.b.getString("languageToLoad", "en");
        Log.d("languageToLoad", "LanguageFragment: " + this.f813a);
        this.c = ((FragmentActivity) Objects.requireNonNull(getActivity())).getSharedPreferences("radio_button", 0);
        SharedPreferences.Editor edit = this.c.edit();
        View inflate = layoutInflater.inflate(R.layout.fragment_language_new, viewGroup, false);
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R.id.recycler_language);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), 1, false);
        LanguageAdapter languageAdapter = new LanguageAdapter(getResources().getStringArray(R.array.languagenames), getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(languageAdapter);
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getActivity(), new a(this, languageAdapter, new String[]{"en", "zh", "ru", "fr", "es", "ar", "ja", "de", "ko", "pt", "it", "in", "nl"}, edit)));
        return inflate;
    }
}
