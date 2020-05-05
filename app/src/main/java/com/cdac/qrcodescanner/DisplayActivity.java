package com.cdac.qrcodescanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.firebase.client.Firebase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DisplayActivity extends AppCompatActivity {

    private EditText textSN,textmDate;
    private Button mUpdateData,mSendData;
    private Firebase mRefb;
    private String sn,mdate;
    private FirebaseDatabase mDatabase;
    private DatabaseReference mRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        //Firebase.setAndroidContext(this);

        textSN=(EditText) findViewById(R.id.textViewSN);
        textmDate=(EditText) findViewById(R.id.textViewmDate);
        mUpdateData=(Button)findViewById(R.id.update);
        mSendData=(Button)findViewById(R.id.send);

        Intent o = getIntent();
        sn=o.getStringExtra("sn");
        mdate=o.getStringExtra("mdate");
        textSN.setText(sn);
        textmDate.setText(mdate);

        //mDatabase = FirebaseDatabase.getInstance();
        //mRef = mDatabase.getReference(sn);
        //mRef.child("ManufacturingDate").setValue(mdate);

        mUpdateData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        mSendData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //DatabaseReference updateData = FirebaseDatabase.getInstance().getReference("server/saving-data/fireblog").child(sn);
                //updateData.child("ManufacturingDate").setValue(textmDate.getText());
            }
        });
    }
}
