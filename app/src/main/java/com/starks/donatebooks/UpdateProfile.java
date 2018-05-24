package com.starks.donatebooks;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UpdateProfile extends AppCompatActivity {

    EditText editText1,editText2,editText3;
    Button updbtn;
    FirebaseUser user;
    String uid,email;
    DatabaseReference db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_profile);

        editText1 = (EditText) findViewById(R.id.name);
        editText2 = (EditText) findViewById(R.id.phone);
        editText3 = (EditText) findViewById(R.id.qualify);

        updbtn = (Button)findViewById(R.id.btn_update);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        db = FirebaseDatabase.getInstance().getReference();

        updbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                post();
            }
        });

    }
    private void post() {
        String strname = editText1.getText().toString();
        String strphone = editText2.getText().toString();
        String strqua = editText3.getText().toString();


        if (!TextUtils.isEmpty(strname) && !TextUtils.isEmpty(strphone) && !TextUtils.isEmpty(strqua)) {

            //getting a unique id using push().getKey() method
            user = FirebaseAuth.getInstance().getCurrentUser();
            uid = user.getUid();

            //String id = db.push().getKey();


          //  Postfeed pf = new Postfeed(id,bloodtype,location,cat,subcat,desc,cinfo);
            Profile profile = new Profile(strname,strphone,strqua);

            db.child("profile").child(uid).setValue(profile);



            //displaying a success toast
            Toast.makeText(this, "Profile Updated Succesfully", Toast.LENGTH_LONG).show();

            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
            finish();

        } else {
            //if the value is not given displaying a toast
            Toast.makeText(this, "Please enter correct Details", Toast.LENGTH_LONG).show();
        }
    }
}
