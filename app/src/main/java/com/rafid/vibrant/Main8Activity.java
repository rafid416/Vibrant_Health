package com.rafid.vibrant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Main8Activity extends AppCompatActivity {

    ImageView image;
    TextView percent, message;
    Animation rotate;
    String bac;
    double alcoholLevel=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);

        setTitle("Blood Alcohol Content");
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        percent = findViewById(R.id.percent);
        message = findViewById(R.id.message);
        bac = getIntent().getStringExtra("newBac");
//        Toast.makeText(this, myBmr, Toast.LENGTH_SHORT).show();
        percent.setText(bac);

        image = findViewById(R.id.image);
        rotate = AnimationUtils.loadAnimation(this, R.anim.rotate);
        rotate.reset();
        image.clearAnimation();
        image.startAnimation(rotate);

        alcoholLevel=Double.parseDouble(bac);
        alcoholLevel/=100;
        if ((alcoholLevel >= 0) && (alcoholLevel <=0.03)){
            message.setText("Normal Behaviour, no impairment");
        }
        if ((alcoholLevel > 0.03) && (alcoholLevel <=0.06)){
            message.setText("Mild euphoria and impairment, decreased inhibitions");
        }
        if ((alcoholLevel > 0.06) && (alcoholLevel <=0.10)){
            message.setText("Buzzed, euphoric, increased impairment");
        }
        if ((alcoholLevel > 0.10) && (alcoholLevel <=0.20)){
            message.setText("Drunk, emotional swings, slurred speech, nausea, loss of reaction time and motor control");
        }
        if ((alcoholLevel > 0.20) && (alcoholLevel <=0.30)){
            message.setText("Confused, nauseated, no common sense, blackout");
        }
        if ((alcoholLevel > 0.30) && (alcoholLevel <=0.40)){
            message.setText("Possibly unconscious, can't move, loss of bladder function, risk of death");
        }
        if (alcoholLevel > 0.40){
            message.setText("Unconscious, coma, impaired breathing, risk of death");
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
