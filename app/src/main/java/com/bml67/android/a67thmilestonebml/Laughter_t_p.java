package com.bml67.android.a67thmilestonebml;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.bluejamesbond.text.DocumentView;
import com.bluejamesbond.text.style.TextAlignment;

/**
 * Created by Student on 20/2/2017.
 */

public class Laughter_t_p extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.laughter_t_p);
        DocumentView documentView = new DocumentView(this, DocumentView.PLAIN_TEXT);  // Support plain text
        documentView.getDocumentLayoutParams().setTextAlignment(TextAlignment.JUSTIFIED);
    }


}