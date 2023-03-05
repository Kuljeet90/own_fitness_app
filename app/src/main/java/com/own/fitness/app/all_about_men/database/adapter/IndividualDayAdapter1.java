package com.own.fitness.app.all_about_men.database.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.getkeepsafe.android.multistateanimation.MultiStateAnimation;
import com.own.fitness.app.R;
import com.own.fitness.app.adapters.WorkoutData;
import com.own.fitness.app.all_about_men.database.activity.ExcDetailsActivityNew1;
import com.own.fitness.app.all_about_men.database.b.a1;


import java.util.ArrayList;
import java.util.HashMap;

public class IndividualDayAdapter1 extends RecyclerView.Adapter<IndividualDayAdapter1.ViewHolder> {
    HashMap<String, ArrayList<Integer>> arrayListHashMap;
    Context context;
    String day;
    int dynumber;
    int screenWidth;
    ArrayList<WorkoutData> workoutDataList;

    public class ViewHolder extends RecyclerView.ViewHolder {


         TextView f781a;
         TextView b;
         ImageView c;
         CardView d;
         ImageView e;

        public ViewHolder(IndividualDayAdapter1 individualDayAdapter, View view) {
            super(view);
            this.f781a = (TextView) view.findViewById(R.id.exerciseName);
            this.b = (TextView) view.findViewById(R.id.rotation);
            this.b.setTextColor(view.getResources().getColor(R.color.men_color));
            this.c = (ImageView) view.findViewById(R.id.animation);
            this.d = (CardView) view.findViewById(R.id.cardViewInRecycler);
            this.e = (ImageView) view.findViewById(R.id.line_image);
        }
    }

    public IndividualDayAdapter1(Context context2, String str, ArrayList<WorkoutData> arrayList, int i) {
        this.context = context2;
        this.screenWidth = i;
        this.day = str;
        this.workoutDataList = arrayList;
    }




    public void a(ViewHolder viewHolder, int i) {
        int adapterPosition = viewHolder.getAdapterPosition();
        if (adapterPosition < this.workoutDataList.size()) {
            Intent intent = new Intent(this.context, ExcDetailsActivityNew1.class);
            Bundle bundle = new Bundle();
            bundle.putIntArray("framesIdArray", this.workoutDataList.get(i).getImageIdList());
            bundle.putString("excName", this.workoutDataList.get(i).getExcName());
            bundle.putInt("excNameDescResId", this.workoutDataList.get(i).getExcDescResId());
            bundle.putString("day", this.day);
            bundle.putInt("day_num", this.dynumber);
            bundle.putInt("excPosition", adapterPosition);
            bundle.putInt("excCycle", this.workoutDataList.get(i).getExcCycles());
            intent.putExtras(bundle);
            this.context.startActivity(intent);
        }
    }

    public int getItemCount() {
        return this.workoutDataList.size();
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        StringBuilder sb;
        TextView textView;
        if (i < this.workoutDataList.size()) {
            viewHolder.d.setVisibility(View.VISIBLE);
            WorkoutData workoutData = this.workoutDataList.get(i);
            MultiStateAnimation.SectionBuilder sectionBuilder = new MultiStateAnimation.SectionBuilder("loading_row" + viewHolder.getAdapterPosition());
            for (int addFrame : workoutData.getImageIdList()) {
                sectionBuilder.addFrame(addFrame);
            }
            sectionBuilder.setOneshot(false);
            sectionBuilder.setFrameDuration(1000);
            new MultiStateAnimation.Builder(viewHolder.c).addSection(sectionBuilder).build(this.context).transitionNow("loading_row" + viewHolder.getAdapterPosition());
            viewHolder.f781a.setText(this.workoutDataList.get(i).getExcName().replace("_", " ").toUpperCase());
            if (workoutData.getImageIdList().length > 1) {
                textView = viewHolder.b;
                sb = new StringBuilder();
                sb.append("x");
                sb.append(this.workoutDataList.get(i).getExcCycles());
            } else {
                textView = viewHolder.b;
                sb = new StringBuilder();
                sb.append(this.workoutDataList.get(i).getExcCycles());
                sb.append(" Sec");
            }
            textView.setText(sb.toString());
        } else {
            viewHolder.d.setVisibility(View.GONE);
        }
        if (i == this.workoutDataList.size() - 1) {
            viewHolder.e.setVisibility(View.GONE);
        } else {
            viewHolder.e.setVisibility(View.VISIBLE);
        }
        if (Build.VERSION.SDK_INT < 23) {
            viewHolder.e.setVisibility(View.GONE);
        }
        viewHolder.d.setOnClickListener(new a1(this, viewHolder, i));
    }

    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(this, LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_days_new, viewGroup, false));
    }
}
