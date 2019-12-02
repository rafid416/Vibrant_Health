package com.rafid.vibrant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.maps.MapView;

public class Main9Activity extends AppCompatActivity {

    Button emailButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9);

        emailButton = findViewById(R.id.emailButton);
    }



    public void emailus (View view){
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("message/rfc822");
        i.putExtra(Intent.EXTRA_EMAIL, new String[]{"rafid.asira@triosstudent.com"});
        i.putExtra(Intent.EXTRA_SUBJECT, "Vibrant Health Comments");
//        i.putExtra(Intent.EXTRA_TEXT, userName + "sent a message about " + subject + " " + message);
        try {
            startActivity(Intent.createChooser(i, "send mail.."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(this, "There are no email clients installed. ", Toast.LENGTH_SHORT).show();
        }

    }


}
