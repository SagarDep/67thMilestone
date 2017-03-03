package com.bml67.android.a67thmilestonebml;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bluejamesbond.text.DocumentView;
import com.bluejamesbond.text.style.TextAlignment;

public class BlackBox extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_black_box);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DocumentView documentView = new DocumentView(this, DocumentView.PLAIN_TEXT);  // Support plain text
        documentView.getDocumentLayoutParams().setTextAlignment(TextAlignment.JUSTIFIED);



        // Get a support ActionBar corresponding to this toolbar
        ActionBar ab = getSupportActionBar();

        // Enable the Up button
        ab.setDisplayHomeAsUpEnabled(true);

        FloatingActionButton favorites_fab = (FloatingActionButton) findViewById(R.id.favorites_fab_black_box);
        favorites_fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fdhandler fdh = new fdhandler(getApplicationContext(),null,null,1);
                favouritesdatabase fd = new favouritesdatabase("Black Box","1st March | 1:00 pm","ECE-LAB(GA 201)");
                fdh.addfavouriteevent(fd);
                Toast.makeText(getApplicationContext(),"Event added to your Favourites",Toast.LENGTH_LONG).show();
                Intent i = new Intent(getApplicationContext(), MyService.class);
                startService(i);
            }
        });

//        FloatingActionButton location_fab = (FloatingActionButton) findViewById(R.id.location_fab);
//        location_fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Location/Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        ImageView email1 = (ImageView) findViewById(R.id.email1_black_box);
        email1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String[] addresses = {"saif.jahangir.14ece@bml.edu.in"};

                String subject = "Fest";
                composeEmail(addresses, subject);

            }
        });

        ImageView call1 = (ImageView) findViewById(R.id.call1_black_box);
        call1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialPhoneNumber("09728058903");
            }
        });

        ImageView email2 = (ImageView) findViewById(R.id.email2_black_box);
        email2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String[] addresses = {"anant.khandelwal.14me@bml.edu.in"};

                String subject = "Fest";
                composeEmail(addresses, subject);

            }
        });

        ImageView call2 = (ImageView) findViewById(R.id.call2_black_box);
        call2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialPhoneNumber("07742787205");
            }
        });


    }




    private void composeEmail(String[] addresses, String subject) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setType("*//*");
        intent.setData(Uri.parse("mailto:"));     //only e-mail apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);


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
