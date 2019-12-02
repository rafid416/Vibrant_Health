package com.rafid.vibrant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView logo;
    Animation myAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        logo = findViewById(R.id.logo);
        myAnim = AnimationUtils.loadAnimation(this, R.anim.scale);
        myAnim.reset();
        logo.clearAnimation();
        logo.startAnimation(myAnim);


        new Handler().postDelayed(new Runnable() {
            Intent i = new Intent(getApplicationContext(), Main2Activity.class);
            public void run() {
                startActivity(i);
            }
        }, 3000);

    }
}
