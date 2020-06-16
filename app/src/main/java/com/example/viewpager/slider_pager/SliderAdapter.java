package com.example.viewpager.slider_pager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.viewpager.R;
import com.example.viewpager.slider_pager.Model_Slide;

import java.util.ArrayList;

public class SliderAdapter extends PagerAdapter {
    private Context context;
    private ArrayList<Model_Slide>mList;

    public SliderAdapter(Context context, ArrayList<Model_Slide> mList) {
        this.context = context;
        this.mList = mList;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        LayoutInflater layoutInflater=(LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE) ;
        View view=layoutInflater.inflate(R.layout.item_layout_slider,null);
        ImageView slideimg=view.findViewById(R.id.imageview_slider);
        TextView title=view.findViewById(R.id.textView_title);
        slideimg.setImageResource(mList.get(position).getImage());
        title.setText(mList.get(position).getTitle());
        container.addView(view);
        return view;

    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public boolean isViewFromObject( View view,  Object object) {
        return view ==object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
