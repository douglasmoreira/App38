package com.example.app38;

import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements ImageSwitcher.ViewFactory {

    LinearLayout linearLayoutHorizontal;
    ImageSwitcher imgSwitcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        linearLayoutHorizontal = findViewById(R.id.linearLayoutHorizontal);
        imgSwitcher = findViewById(R.id.imgSwitcher);

        imgSwitcher.setFactory(MainActivity.this);

        imgSwitcher.setInAnimation(AnimationUtils.loadAnimation(MainActivity.this,android.R.anim.slide_in_left));
        imgSwitcher.setOutAnimation(AnimationUtils.loadAnimation(MainActivity.this,android.R.anim.slide_out_right));

        for(int index = 0; index <Animal.animalImages.length;index++){
            final int i = index;
            ImageView imageView = new ImageView(MainActivity.this);
            imageView.setImageResource(Animal.animalImages[index]);
            letsSetLayoutParamsForImageView(imageView);
            imageView.setPadding(100,100,100,100);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    imgSwitcher.setImageResource(Animal.animalImages[i]);
                    Toast.makeText(MainActivity.this, "This is " +
                            Animal.animalNames[i],Toast.LENGTH_SHORT).show();
                }
            });
            linearLayoutHorizontal.addView(imageView);
        }
    }

    public void letsSetLayoutParamsForImageView(ImageView imageView){
        imageView.setLayoutParams(new LinearLayout.LayoutParams
                (1000,1000));
    }

    @Override
    public View makeView() {

        ImageView imgView = new ImageView(MainActivity.this);
        imgView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imgView.setLayoutParams(new ImageSwitcher.LayoutParams
                (ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT));
        return imgView;
    }
}
