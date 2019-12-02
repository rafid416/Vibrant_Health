package com.rafid.vibrant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import static java.lang.Math.round;

public class Main3Activity extends AppCompatActivity {

    EditText ageInput, heightInOne, heightInTwo, weightInput;
    Spinner genderSpinner, heightSpinner, weightSpinner;
    TextView inText, cmText;
    Button calcBmi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        setTitle("Body Mass Index");
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        calcBmi = findViewById(R.id.calcBmi);
        ageInput = findViewById(R.id.ageInput);
        heightInOne = findViewById(R.id.heightInOne);
        heightInTwo = findViewById(R.id.heightInTwo);
        weightInput = findViewById(R.id.weightInput);
        genderSpinner = findViewById(R.id.genderSpinner);
        heightSpinner = findViewById(R.id.heightSpinner);
        weightSpinner = findViewById(R.id.weightSpinner);
        inText = findViewById(R.id.inText);
        cmText = findViewById(R.id.cmText);

        heightSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (heightSpinner.getSelectedItemPosition() == 1) {
                    heightInTwo.setVisibility(View.VISIBLE);
                    inText.setVisibility(View.VISIBLE);
                    cmText.setText("ft");
                    heightInTwo.setEnabled(true);
                }
                else{
                    heightInTwo.setEnabled(false);
                    heightInTwo.setVisibility(View.INVISIBLE);
                    inText.setVisibility(View.INVISIBLE);
                    cmText.setText("cm");
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                return;
            }
        });

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

    public void calcBmi (View v){
            double height=0, heightTwo = 0, weight=0;
            String age = ageInput.getText().toString();
            String gender = String.valueOf(genderSpinner.getSelectedItem());
            String weightIn = weightInput.getText().toString();
            String getHeight = heightInOne.getText().toString();
            String getHeightTwo = heightInTwo.getText().toString();
            String heightMeasurement = heightSpinner.getSelectedItem().toString();
            String weightMeasurement = weightSpinner.getSelectedItem().toString();

        if (age.equals("") || (age.equals("0"))) {
            Toast.makeText(getApplicationContext(), "Age cannot be blank or 0! Please enter a valid age", Toast.LENGTH_SHORT).show();
        } else {
                if (weightIn.equals("") || (weightIn.equals("0"))) {
                    Toast.makeText(getApplicationContext(), "Weight cannot be blank or 0! Please enter a valid weight", Toast.LENGTH_SHORT).show();
                } else {
                    if (weightMeasurement.equals("Pounds")) {
                        weight = Double.parseDouble(weightIn);
                        weight /= 2.205;
                    } else {
                        weight = Double.parseDouble(weightIn);
                    }
                }
                if (heightMeasurement.equals("Feet")) {
                    if (getHeight.equals("0") || (getHeight.equals(""))) {
                        Toast.makeText(getApplicationContext(), "Height cannot be blank or 0! Please enter a valid height", Toast.LENGTH_SHORT).show();
                    } else {
                        height = Double.parseDouble(getHeight);
                        height /= 3.281;
                    }
                    if (getHeightTwo.equals("0") || (getHeightTwo.equals(""))) {
                        heightTwo = 0;
                    } else {
                        heightTwo = Double.parseDouble(getHeightTwo);
                        heightTwo /= 39.37;
                    }
                } else {
                    if (getHeight.equals("0") || (getHeight.equals(""))) {
                        Toast.makeText(getApplicationContext(), "Height cannot be blank or 0! Please enter a valid height", Toast.LENGTH_SHORT).show();
                    } else {
                        height = Double.parseDouble(getHeight);
                        height /= 100;
                    }
                }
                if (!((getHeight.equals("0") || getHeight.equals("")) || (weightIn.equals("0") || weightIn.equals("")))) {

                    Double BMI = weight / Math.pow((height + heightTwo), 2);
                    String stringBmi = String.format("%.2f", BMI);
//                    Toast.makeText(this, stringBMI, Toast.LENGTH_SHORT).show();
                    Intent BmiResults= new Intent(this, Main4Activity.class);
                    BmiResults.putExtra("newBmi", stringBmi);
                    BmiResults.putExtra("bmiGender", gender);
                    startActivity(BmiResults);
                }
            }
        }

        public void resetBmi (View v){
            heightInOne.setText("");
            weightInput.setText("");
            if (heightInTwo.getVisibility() == View.VISIBLE){
                heightInTwo.setText("");
            }         ageInput.setText("");



        }

}