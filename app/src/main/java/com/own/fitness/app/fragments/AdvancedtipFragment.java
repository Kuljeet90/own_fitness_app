package com.own.fitness.app.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import com.own.fitness.app.R;
import com.own.fitness.app.adapters.Pageradapter_advtips;
import com.own.fitness.app.aputils.DepthPageTransformer;

public class AdvancedtipFragment extends Fragment {


     ViewPager f806a;
     ImageView b;
     ImageView c;




    public void jumpToNextPage() {
        this.b.setVisibility(View.VISIBLE);
        ViewPager viewPager = this.f806a;
        viewPager.setCurrentItem(viewPager.getCurrentItem() + 1, true);
        if (this.f806a.getCurrentItem() + 1 == 10) {
            this.c.setVisibility(View.INVISIBLE);
        }
    }

    public void jumpToPreviousPage() {
        this.c.setVisibility(View.VISIBLE);
        if (this.f806a.getCurrentItem() - 1 == 0) {
            this.b.setVisibility(View.INVISIBLE);
        }
        ViewPager viewPager = this.f806a;
        viewPager.setCurrentItem(viewPager.getCurrentItem() - 1, true);
    }

    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_advancedtip, viewGroup, false);
        FragmentManager supportFragmentManager = getActivity().getSupportFragmentManager();
        this.f806a = (ViewPager) inflate.findViewById(R.id.viewPager);
        this.b = (ImageView) inflate.findViewById(R.id.previoustip);
        this.c = (ImageView) inflate.findViewById(R.id.nexttip);
        this.f806a.setAdapter(new Pageradapter_advtips(supportFragmentManager));
        this.f806a.setClipToPadding(false);
        this.f806a.setPadding(20, 0, 20, 0);
        this.f806a.setPageMargin(12);
        this.f806a.setPageTransformer(true, new DepthPageTransformer());
        this.f806a.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            public void onPageScrollStateChanged(int i) {
                Log.d("", "Hello");
            }

            public void onPageScrolled(int i, float f, int i2) {
                ImageView imageView = AdvancedtipFragment.this.b;
                if (i == 0) {
                    imageView.setVisibility(View.INVISIBLE);
                } else {
                    imageView.setVisibility(View.VISIBLE);
                }
                if (i == 9) {
                    AdvancedtipFragment.this.c.setVisibility(View.INVISIBLE);
                } else {
                    AdvancedtipFragment.this.c.setVisibility(View.VISIBLE);
                }
            }

            public void onPageSelected(int i) {
                Log.d("", "Hello");
            }
        });
        this.b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AdvancedtipFragment advancedtipFragment = AdvancedtipFragment.this;
                advancedtipFragment.jumpToPreviousPage();
            }
        });
        this.c.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AdvancedtipFragment advancedtipFragment = AdvancedtipFragment.this;
                advancedtipFragment.jumpToNextPage();
            }
        });
        return inflate;
    }
}
