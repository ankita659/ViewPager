package com.example.viewpager.slider_pager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.viewpager.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity_slider extends AppCompatActivity {
    private ArrayList<Model_Slide>modelSlides;
    private ViewPager sliderpager;
    private TabLayout indicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_slider);
        sliderpager=(ViewPager)findViewById(R.id.slider_pager);
        indicator=(TabLayout)findViewById(R.id.indicator_main);
     modelSlides=new ArrayList<>();
     modelSlides.add(new Model_Slide(R.drawable.dory,"Dory"));
        modelSlides.add(new Model_Slide(R.drawable.zootopia,"Zootopia"));
        modelSlides.add(new Model_Slide(R.drawable.lorax,"Lorax"));
        modelSlides.add(new Model_Slide(R.drawable.trainyourdragon,"Train Your Dragon"));
        modelSlides.add(new Model_Slide(R.drawable.tangled,"Tangled"));
        modelSlides.add(new Model_Slide(R.drawable.moana,"Moana"));
        modelSlides.add(new Model_Slide(R.drawable.toystory,"Toy Story"));
        SliderAdapter adapter=new SliderAdapter(this,modelSlides);
        sliderpager.setAdapter(adapter);
        Timer timer=new Timer();
        timer.scheduleAtFixedRate(new MainActivity_slider.sliderTimer(),4000,4000);
        indicator.setupWithViewPager(sliderpager,true);
    }
    class sliderTimer extends TimerTask{

        @Override
        public void run() {
            MainActivity_slider.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if ((sliderpager.getCurrentItem()<modelSlides.size()-1))
                    {
                        sliderpager.setCurrentItem(sliderpager.getCurrentItem()+1);
                    }else {
                        sliderpager.setCurrentItem(0);
                    }
                }
            });
        }
    }
}
