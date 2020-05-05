package com.cdac.qrcodescanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DisplayActivity extends AppCompatActivity {

    private EditText pId,pName,mReplace,cost,replaceDate,description,manufacDate,repairman,verifiedBy;
    private Button mUpdateData,mSendData;
    private String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        pId=(EditText) findViewById(R.id.pId);
        pId.setEnabled(false);
        pName=(EditText) findViewById(R.id.pName);
        pName.setEnabled(false);
        mReplace=(EditText) findViewById(R.id.mReplace);
        mReplace.setEnabled(false);
        cost=(EditText) findViewById(R.id.cost);
        cost.setEnabled(false);
        replaceDate=(EditText) findViewById(R.id.replaceDate);
        replaceDate.setEnabled(false);
        description=(EditText) findViewById(R.id.description);
        description.setEnabled(false);
        manufacDate=(EditText) findViewById(R.id.manufacDate);
        manufacDate.setEnabled(false);
        repairman=(EditText) findViewById(R.id.repairman);
        repairman.setEnabled(false);
        verifiedBy=(EditText) findViewById(R.id.verifiedBy);
        verifiedBy.setEnabled(false);

        mUpdateData=(Button)findViewById(R.id.update);
        mSendData=(Button)findViewById(R.id.send);

        Intent o = getIntent();
        id=o.getStringExtra("pId");

        pId.setText(id);
        pName.setText(o.getStringExtra("ProductName"));
        mReplace.setText(o.getStringExtra("MaterialReplaced"));
        cost.setText(o.getStringExtra("Cost"));
        replaceDate.setText(o.getStringExtra("DateRepaired"));
        description.setText(o.getStringExtra("Description"));
        manufacDate.setText(o.getStringExtra("ManufacturingDate"));
        repairman.setText(o.getStringExtra("Repairman"));
        verifiedBy.setText(o.getStringExtra("VerifiedBy"));

        mUpdateData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mReplace.setEnabled(true);
                cost.setEnabled(true);
                replaceDate.setEnabled(true);
                description.setEnabled(true);
                manufacDate.setEnabled(true);
                repairman.setEnabled(true);
                verifiedBy.setEnabled(true);
            }
        });
        mSendData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference dRef = FirebaseDatabase.getInstance().getReference().child(id);
                dRef.child("ProductName").setValue(pName.getText().toString());
                dRef.child("MaterialReplaced").setValue(mReplace.getText().toString());
                dRef.child("Cost").setValue(cost.getText().toString());
                dRef.child("DateRepaired").setValue(replaceDate.getText().toString());
                dRef.child("Description").setValue(description.getText().toString());
                dRef.child("ManufacturingDate").setValue(manufacDate.getText().toString());
                dRef.child("Repairman").setValue(repairman.getText().toString());
                dRef.child("VerifiedBy").setValue(verifiedBy.getText().toString());

                Toast.makeText(getApplicationContext(),"Values Updated",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
