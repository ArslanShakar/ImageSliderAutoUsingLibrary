package com.practice.imagesliderautolibrary;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.Toast;

import com.smarteist.autoimageslider.DefaultSliderView;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderLayout;
import com.smarteist.autoimageslider.SliderView;

public class MainActivity extends AppCompatActivity {

    private SliderLayout sliderLayout;
    private int[] imagesArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        * Library Guides Url
        * https://github.com/smarteist/android-image-slider
        * */

        imagesArray = new int[]{R.drawable.one, R.drawable.two, R.drawable.three, R.drawable.four};

        sliderLayout = findViewById(R.id.imageSlider);
        sliderLayout.setIndicatorAnimation(IndicatorAnimations.SLIDE);
        sliderLayout.setScrollTimeInSec(2);

        //setSliderViews();

        setSliderViewsTwo();
    }

    private void setSliderViewsTwo() {

        for (int i = 0; i < imagesArray.length; i++) {


            DefaultSliderView sliderView = new DefaultSliderView(this);

            sliderView.setImageDrawable(imagesArray[i]);

            sliderView.setImageScaleType(ImageView.ScaleType.CENTER_CROP);
            sliderView.setDescription("setDescription " + (i + 1));

            final int finalI = i;
            sliderView.setOnSliderClickListener(new SliderView.OnSliderClickListener() {
                @Override
                public void onSliderClick(SliderView sliderView) {
                    Toast.makeText(MainActivity.this, "This is slider " + (finalI + 1), Toast.LENGTH_SHORT).show();
                }
            });

            //at last add this view in your layout :
            sliderLayout.addSliderView(sliderView);
        }
    }

    /***************************************************************************************/
    private void setSliderViews() {
        for (int i = 0; i <= 3; i++) {


            DefaultSliderView sliderView = new DefaultSliderView(this);


            switch (i) {
                case 0:
                    //sliderView.setImageUrl("https://images.pexels.com/photos/547114/pexels-photo-547114.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260");
                    sliderView.setImageDrawable(R.drawable.one);
                    sliderView.setDescription("image one");
                    break;
                case 1:
                    //sliderView.setImageUrl("https://images.pexels.com/photos/218983/pexels-photo-218983.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260");
                    sliderView.setImageDrawable(R.drawable.two);
                    sliderView.setDescription("image " + (i + 1));
                    break;
                case 2:
                    //sliderView.setImageUrl("https://images.pexels.com/photos/747964/pexels-photo-747964.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260");
                    sliderView.setImageDrawable(R.drawable.three);
                    sliderView.setDescription("image three");
                    break;
                case 3:
                    //sliderView.setImageUrl("https://images.pexels.com/photos/929778/pexels-photo-929778.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260");
                    sliderView.setImageDrawable(R.drawable.four);
                    sliderView.setDescription("image four");
                    break;
            }

            sliderView.setImageScaleType(ImageView.ScaleType.CENTER_CROP);
            //sliderView.setDescription("setDescription " + (i + 1));

            final int finalI = i;
            sliderView.setOnSliderClickListener(new SliderView.OnSliderClickListener() {
                @Override
                public void onSliderClick(SliderView sliderView) {
                    Toast.makeText(MainActivity.this, "This is slider " + (finalI + 1), Toast.LENGTH_SHORT).show();
                }
            });

            //at last add this view in your layout :
            sliderLayout.addSliderView(sliderView);
        }
    }
}
