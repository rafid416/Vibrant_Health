package com.rafid.vibrant;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static android.graphics.Color.RED;
import static android.graphics.Color.red;

public class Main6Activity extends AppCompatActivity {

    ImageView mainImage;
    Animation rotate;
    String myBmr;
    TextView displayCalories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);


        setTitle("Basic Metabolic Rate");
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        displayCalories = findViewById(R.id.displayCalories);
        myBmr = getIntent().getStringExtra("newBmr");
//        Toast.makeText(this, myBmr, Toast.LENGTH_SHORT).show();

        mainImage = findViewById(R.id.mainImage);
        rotate = AnimationUtils.loadAnimation(this, R.anim.rotate);
        rotate.reset();
        mainImage.clearAnimation();
        mainImage.startAnimation(rotate);

        displayCalories.setText(myBmr);
    }

    public boolean onCreateOptionsMenu (Menu menu){
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId())
        {
            case android.R.id.home:
                onBackPressed();
                return true;

            case R.id.about:
                Intent i1 = new Intent(this, Main9Activity.class );
                startActivity(i1);
                break;

        }

        return true;
    }
}
