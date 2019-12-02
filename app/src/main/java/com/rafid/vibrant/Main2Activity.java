package com.rafid.vibrant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        setTitle("Vibrant Health Calculators");
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
            case R.id.about:
                Intent i1 = new Intent(this, Main9Activity.class );
                startActivity(i1);
                break;


        }

        return true;
    }


    public void bmi(View view){
        Intent i = new Intent(this, Main3Activity.class);
            startActivity(i);
    }

    public void weightloss (View view){
        Intent j = new Intent(this, Main5Activity.class);
        startActivity(j);
    }

    public void bac (View view){
        Intent k = new Intent(this, Main7Activity.class);
        startActivity(k);
    }
}
