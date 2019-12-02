package com.rafid.vibrant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Main7Activity extends AppCompatActivity {

    Spinner genderSpinner, timeSpinner, weightSpinner, volumeSpinner;
    EditText timeInput, weightInput, alcoholInput, volumeInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);


        setTitle("Blood Alcohol Content");
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        genderSpinner = findViewById(R.id.genderSpinner);
        timeSpinner = findViewById(R.id.timeSpinner);
        weightSpinner = findViewById(R.id.weightSpinner);
        volumeSpinner = findViewById(R.id.volumeSpinner);
        timeInput = findViewById(R.id.timeInput);
        weightInput = findViewById(R.id.weightInput);
        alcoholInput = findViewById(R.id.alcoholInput);
        volumeInput = findViewById(R.id.volumeInput);
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

    public void bac (View v){
        String alcoholPerc = alcoholInput.getText().toString();
        String volume = volumeInput.getText().toString();
        String timePassed = timeInput.getText().toString();
        String weightIn = weightInput.getText().toString();


        String volumeUnit = String.valueOf(volumeSpinner.getSelectedItem());
        String time = String.valueOf(timeSpinner.getSelectedItem());
        String weight = String.valueOf(weightSpinner.getSelectedItem());
        String gender = String.valueOf(genderSpinner.getSelectedItem());


        if (alcoholPerc.equals("") || (alcoholPerc.equals("0"))) {
            Toast.makeText(getApplicationContext(), "Drink Alcohol level cannot be blank or 0! Please enter a valid number", Toast.LENGTH_SHORT).show();
        } else{
            double alcPerc = Double.parseDouble(alcoholPerc);
            double volumeConsumed=0;
            double weightConv=0;
            double timePass=0;


            if (volume.equals("") || (volume.equals("0"))) {
                Toast.makeText(getApplicationContext(), "Volume consumes cannot be blank or 0! Please enter a valid number", Toast.LENGTH_SHORT).show();
            } else {
                volumeConsumed = Double.parseDouble(volume);
                if (volumeUnit.equals("ML")) {
                    volumeConsumed = (volumeConsumed/29.574)*(alcPerc/100);
                } else {
                    volumeConsumed = volumeConsumed* (alcPerc/100);
                }
            }
            if (timePassed.equals("") || (timePassed.equals("0"))) {
                Toast.makeText(getApplicationContext(), "Time Passed cannot be blank or 0! Please enter a valid time", Toast.LENGTH_SHORT).show();
            } else {
                timePass = Double.parseDouble(timePassed);
                if (time.equals("Minutes")){
                    timePass /= 60;
                }
            }
//
            if (weightIn.equals("") || (weightIn.equals("0"))) {
                Toast.makeText(getApplicationContext(), "Weight cannot be blank or 0! Please enter a valid weight", Toast.LENGTH_SHORT).show();
            } else{
                weightConv = Double.parseDouble(weightIn);
                if(weight.equals("Kilograms")){
                    weightConv*=2.205;
                }
            }
            double bloodAlcohol;
            if (gender.equals("Male")){
                bloodAlcohol = ((volumeConsumed*5.14/(weightConv*.73)) - (0.015 * timePass))*100;
            } else {
                bloodAlcohol = ((volumeConsumed*5.14/(weightConv*.66)) - (0.015 * timePass))*100;
            }
            if (bloodAlcohol < 0){
                bloodAlcohol = 0;
            }
            String alcoholLevel = String.format("%.3f", bloodAlcohol);
//            String volumedrank = String.valueOf(volumeConsumed);
//            Toast.makeText(getApplicationContext(), alcoholLevel, Toast.LENGTH_SHORT).show();


            Intent BacResult= new Intent(this, Main8Activity.class);
            BacResult.putExtra("newBac", alcoholLevel);
            startActivity(BacResult);
        }


    }

    public void reset (View v){
        volumeInput.setText("");
        alcoholInput.setText("");
        timeInput.setText("");
        weightInput.setText("");
    }
}
