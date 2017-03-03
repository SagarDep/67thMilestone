package com.bml67.android.a67thmilestonebml;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bluejamesbond.text.DocumentView;
import com.bluejamesbond.text.style.TextAlignment;

public class WriteItUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_it_up);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DocumentView documentView = new DocumentView(this, DocumentView.PLAIN_TEXT);  // Support plain text
        documentView.getDocumentLayoutParams().setTextAlignment(TextAlignment.JUSTIFIED);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.favorites_fab_write_it_up);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fdhandler fdh = new fdhandler(getApplicationContext(),null,null,1);
                favouritesdatabase fd = new favouritesdatabase("Write-it-up","1st March | 6:30 pm","GA-L02");
                fdh.addfavouriteevent(fd);
                Toast.makeText(getApplicationContext(),"Event added to your Favourites",Toast.LENGTH_LONG).show();
                Intent i = new Intent(getApplicationContext(), MyService.class);
                startService(i);
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ImageView email1 = (ImageView) findViewById(R.id.email1_write_it_up);
        email1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String[] addresses = {"sumang.garg.15cse@bml.edu.in"};

                String subject = "Fest";
                composeEmail(addresses, subject);

            }
        });

        ImageView call1 = (ImageView) findViewById(R.id.call1_write_it_up);
        call1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialPhoneNumber("07056550050");
            }
        });

        ImageView email2 = (ImageView) findViewById(R.id.email2_write_it_up);
        email2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String[] addresses = {"yash.gaur.15cse@bml.edu.in"};

                String subject = "Fest";
                composeEmail(addresses, subject);

            }
        });

        ImageView call2 = (ImageView) findViewById(R.id.call2_write_it_up);
        call2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialPhoneNumber("08571967919");
            }
        });

    }

    public void openSchedule(View view){
        Intent i = new Intent(this, ScheduleActivity.class);
        startActivity(i);
    }
    private void composeEmail(String[] addresses, String subject) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setType("*//*");
        intent.setData(Uri.parse("mailto:"));     //only e-mail apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);


        if(intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void dialPhoneNumber ( String phoneNumber ) {
        Intent intent = new Intent ( Intent.ACTION_DIAL);
        intent . setData ( Uri . parse ( "tel:" + phoneNumber ));
        if ( intent . resolveActivity ( getPackageManager ()) != null) {
            startActivity ( intent );
        }

    }

}
