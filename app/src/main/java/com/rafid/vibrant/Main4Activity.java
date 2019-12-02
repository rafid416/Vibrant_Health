package com.rafid.vibrant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class Main4Activity extends AppCompatActivity {

    String yourBmi, gender;
    TextView weighText,bmiText,textView19,textView32,textView28,textView36,textView30,textView31,textView26,textView37,textView27,textView35,textView25,textView34,textView33,textView29;
    ImageView weightImage, extremeUnder, under, normal, over,obeseOne,obeseTwo,morbid;
    ProgressBar progressBar2;
    Animation fade;
    double c = 0;
    int p =0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        yourBmi = getIntent().getStringExtra("newBmi");
        gender = getIntent().getStringExtra("bmiGender");

        setTitle("Body Mass Index");
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        textView28 = findViewById(R.id.textView28);
        textView36 = findViewById(R.id.textView36);
        textView30 = findViewById(R.id.textView30);
        textView31 = findViewById(R.id.textView31);
        textView37 = findViewById(R.id.textView37);
        textView26 = findViewById(R.id.textView26);
        textView27 = findViewById(R.id.textView27);
        textView35 = findViewById(R.id.textView35);
        textView25 = findViewById(R.id.textView25);
        textView34 = findViewById(R.id.textView34);
        textView33 = findViewById(R.id.textView33);
        textView29 = findViewById(R.id.textView29);
        textView19 = findViewById(R.id.textView19);
        textView32 = findViewById(R.id.textView32);
        extremeUnder = findViewById(R.id.extremeUnder);
        under = findViewById(R.id.under);
        over = findViewById(R.id.over);
        normal = findViewById(R.id.normal);
        obeseOne = findViewById(R.id.obeseOne);
        obeseTwo = findViewById(R.id.obeseTwo);
        morbid = findViewById(R.id.morbid);
        weighText = findViewById(R.id.weightText);
        bmiText = findViewById(R.id.bmiText);
        weightImage = findViewById(R.id.weightImage);
        progressBar2 = findViewById(R.id.progressBar2);
        Drawable draw = getResources().getDrawable(R.drawable.customprogressbar);
        progressBar2.setProgressDrawable(draw);
        fade = AnimationUtils.loadAnimation(this, R.anim.fadeinout);
        fade.reset();

        Toast.makeText(this, yourBmi, Toast.LENGTH_LONG).show();



        Double numberBmi = Double.parseDouble(yourBmi);

        if (gender.equals("Male")){

            if (numberBmi >= 40.01) {
                numberBmi*=100;
                p = numberBmi.intValue();
                weighText.setText("Morbid Obese");
                weighText.setTextColor(Color.RED);
                weightImage.setImageResource(R.drawable.bmimorbidobesem);
                bmiText.setText(yourBmi);
                bmiText.setTextColor(Color.RED);

            }
            if ((numberBmi <= 40) && (numberBmi >=35.01 )) {
                numberBmi*=100;
                p = numberBmi.intValue();
                weighText.setText("Obese Class Two");
                weighText.setTextColor(Color.RED);
                weightImage.setImageResource(R.drawable.bmoobeseclasstwo);
                bmiText.setText(yourBmi);
                bmiText.setTextColor(Color.RED);

            }
            if ((numberBmi <= 35) && (numberBmi >=30.01 )) {
                numberBmi*=100;
                p = numberBmi.intValue();
                weighText.setText("Obese Class One");
                weighText.setTextColor(Color.RED);
                weightImage.setImageResource(R.drawable.bmiobeseclassone);
                bmiText.setText(yourBmi);
                bmiText.setTextColor(Color.RED);
            }
            if ((numberBmi <= 30) && (numberBmi >=25.01 )) {
                numberBmi*=100;
                p = numberBmi.intValue();
                weighText.setText("Over Weight");
                weighText.setTextColor(Color.YELLOW);
                weightImage.setImageResource(R.drawable.bmioverweight);
                bmiText.setText(yourBmi);
                bmiText.setTextColor(Color.YELLOW);
            }
            if ((numberBmi <= 25) && (numberBmi >=18.60 )) {
                numberBmi*=100;
                p = numberBmi.intValue();
                weighText.setText("Normal Weight");
                weighText.setTextColor(Color.GREEN);
                weightImage.setImageResource(R.drawable.bminormal);
                bmiText.setText(yourBmi);
                bmiText.setTextColor(Color.GREEN);

            }
            if ((numberBmi <= 18.59) && (numberBmi >=16.00 )) {
                numberBmi*=100;
                p = numberBmi.intValue();
                weighText.setText("Under Weight");
                weighText.setTextColor(Color.YELLOW);
                weightImage.setImageResource(R.drawable.bmiunderweigh);
                bmiText.setText(yourBmi);
                bmiText.setTextColor(Color.YELLOW);
            }
            if (numberBmi <= 15.99) {
                numberBmi*=100;
                p = numberBmi.intValue();
                weighText.setText("Extremely Under Weight");
                weighText.setTextColor(Color.rgb(184, 47, 2));
                weightImage.setImageResource(R.drawable.extremeunderweightm);
                bmiText.setText(yourBmi);
                bmiText.setTextColor(Color.rgb(184, 47, 2));
            }
        } else {

            if (numberBmi >= 40.01) {
                numberBmi*=100;
                p = numberBmi.intValue();
                weighText.setText("Morbid Obese");
                weighText.setTextColor(Color.RED);
                weightImage.setImageResource(R.drawable.bmimorbidobesef);
                bmiText.setText(yourBmi);
                bmiText.setTextColor(Color.RED);
            }
            if ((numberBmi <= 40) && (numberBmi >=35.01 )) {
                numberBmi*=100;
                p = numberBmi.intValue();
                weighText.setText("Obese Class Two");
                weighText.setTextColor(Color.RED);
                weightImage.setImageResource(R.drawable.bmiobeseclasstwof);
                bmiText.setText(yourBmi);
                bmiText.setTextColor(Color.RED);
            }
            if ((numberBmi <= 35) && (numberBmi >=30.01 )) {
                numberBmi*=100;
                p = numberBmi.intValue();
                weighText.setText("Obese Class One");
                weighText.setTextColor(Color.RED);
                weightImage.setImageResource(R.drawable.bmiobeseclassonef);
                bmiText.setText(yourBmi);
                bmiText.setTextColor(Color.RED);
            }
            if ((numberBmi <= 30) && (numberBmi >=25.01 )) {
                numberBmi*=100;
                p = numberBmi.intValue();
                weighText.setText("Over Weight");
                weighText.setTextColor(Color.YELLOW);
                weightImage.setImageResource(R.drawable.bmioverweightf);
                bmiText.setText(yourBmi);
                bmiText.setTextColor(Color.YELLOW);
            }
            if ((numberBmi <= 25) && (numberBmi >=18.60 )) {
                numberBmi*=100;
                p = numberBmi.intValue();
                weighText.setText("Normal Weight");
                weighText.setTextColor(Color.GREEN);
                weightImage.setImageResource(R.drawable.bminormalf);
                bmiText.setText(yourBmi);
                bmiText.setTextColor(Color.GREEN);
            }
            if ((numberBmi <= 18.59) && (numberBmi >=16.00 )) {
                numberBmi*=100;
                p = numberBmi.intValue();
                weighText.setText("Under Weight");
                weighText.setTextColor(Color.YELLOW);
                weightImage.setImageResource(R.drawable.bmiunderweightf);
                bmiText.setText(yourBmi);
                bmiText.setTextColor(Color.YELLOW);
            }
            if (numberBmi <= 15.99) {
                numberBmi*=100;
                p = numberBmi.intValue();
                weighText.setText("Extremely Under Weight");
                weighText.setTextColor(Color.rgb(184, 47, 2));
                weightImage.setImageResource(R.drawable.bmiextremeunderf);
                bmiText.setText(yourBmi);
                bmiText.setTextColor(Color.rgb(184, 47, 2));
            }
        }
        progressBar2.setProgress(p);
        if (numberBmi/100 >40.01){
            morbid.setVisibility(View.VISIBLE);
            morbid.clearAnimation();
            morbid.startAnimation(fade);
            textView28.setTextColor(Color.RED);
            textView36.setTextColor(Color.RED);
            progressBar2.setBackgroundColor(Color.RED);
        }
        if ((numberBmi/100 <= 40) && (numberBmi/100 >=35.01 )) {
            obeseTwo.setVisibility(View.VISIBLE);
            obeseTwo.clearAnimation();
            obeseTwo.startAnimation(fade);
            textView30.setTextColor(Color.RED);
            textView31.setTextColor(Color.RED);
        }
        if ((numberBmi/100 <= 35) && (numberBmi/100 >=30.01 )) {
            obeseOne.setVisibility(View.VISIBLE);
            obeseOne.clearAnimation();
            obeseOne.startAnimation(fade);
            textView26.setTextColor(Color.RED);
            textView37.setTextColor(Color.RED);
        }
        if ((numberBmi/100 <= 30) && (numberBmi/100 >=25.01 )) {
            over.setVisibility(View.VISIBLE);
            over.clearAnimation();
            over.startAnimation(fade);
            textView27.setTextColor(Color.YELLOW);
            textView35.setTextColor(Color.YELLOW);
        }
        if ((numberBmi/100 <= 25) && (numberBmi/100 >=18.60 )) {
            normal.setVisibility(View.VISIBLE);
            normal.clearAnimation();
            normal.startAnimation(fade);
            textView25.setTextColor(Color.GREEN);
            textView34.setTextColor(Color.GREEN);
        }
        if ((numberBmi/100 <= 18.59) && (numberBmi/100 >=16.00 )) {
            under.setVisibility(View.VISIBLE);
            under.clearAnimation();
            under.startAnimation(fade);
            textView29.setTextColor(Color.YELLOW);
            textView33.setTextColor(Color.YELLOW);
        }
        if (numberBmi/100 <= 15.99) {
            extremeUnder.setVisibility(View.VISIBLE);
            extremeUnder.clearAnimation();
            extremeUnder.startAnimation(fade);
            textView19.setTextColor(Color.rgb(184, 47, 2));
            textView32.setTextColor(Color.rgb(184, 47, 2));
        }

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

