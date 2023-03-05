package com.own.fitness.app.adapters;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.own.fitness.app.R;

public class LanguageAdapter extends RecyclerView.Adapter<LanguageAdapter.ViewHolder> {

    SharedPreferences f782a;
    String[] arr;

    int b;
    Context context;

    String[] langshortname = {"en", "zh", "ru", "fr", "es", "ar", "ja", "de", "ko", "pt", "it", "in", "nl"};
    SharedPreferences launchDataPreferences1;
    SharedPreferences.Editor prefsEditor;

    public class ViewHolder extends RecyclerView.ViewHolder {


        TextView f783a;
        RadioButton b;

        public ViewHolder(@NonNull LanguageAdapter languageAdapter, View view) {
            super(view);
            languageAdapter.f782a = languageAdapter.context.getSharedPreferences("radio_button", 0);
            this.f783a = (TextView) view.findViewById(R.id.language_name);
            this.b = (RadioButton) view.findViewById(R.id.radio_button);
        }
    }

    public LanguageAdapter(String[] strArr, Context context2) {
        this.arr = strArr;
        this.context = context2;
        this.launchDataPreferences1 = PreferenceManager.getDefaultSharedPreferences(context2.getApplicationContext());
        this.prefsEditor = this.launchDataPreferences1.edit();
        this.b = getIndexOf(this.langshortname, this.launchDataPreferences1.getString("languageToLoad", "en"));
    }

    public int getIndexOf(String[] strArr, String str) {
        for (int i = 0; i < strArr.length; i++) {
            if (str.equals(strArr[i])) {
                return i;
            }
        }
        return -1;
    }

    public int getItemCount() {
        return this.arr.length;
    }

    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.f783a.setText(this.arr[i]);
        viewHolder.b.setChecked(i == this.b);
    }

    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(this, LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.language_row, viewGroup, false));
    }


}
