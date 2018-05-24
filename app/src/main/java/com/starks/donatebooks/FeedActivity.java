package com.starks.donatebooks;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FeedActivity extends AppCompatActivity {


    FirebaseDatabase database;
    DatabaseReference myRef,myref2;
    List<Postfeed> list;
    RecyclerView recyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);
        recyclerview = (RecyclerView) findViewById(R.id.rview);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference().child("books");





                myRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        list = new ArrayList<>();
                        // StringBuffer stringbuffer = new StringBuffer();
                        for(DataSnapshot dataSnapshot1 :dataSnapshot.getChildren()){

                            Postfeed userdetails = dataSnapshot1.getValue(Postfeed.class);
                            Postfeed listdata = new Postfeed();
                            String name=userdetails.getStrBookName();
                            String locat=userdetails.getStrLoc();
                            String cat=userdetails.getStrCategory();
                            String subcat=userdetails.getStrSubcat();
                            String desc=userdetails.getDescription();
                            String cont=userdetails.getCinfo();
                            listdata.setStrBookName(name);
                            listdata.setStrLoc(locat);
                            listdata.setStrCategory(cat);
                            listdata.setStrSubcat(subcat);
                            listdata.setDescription(desc);
                            listdata.setCinfo(cont);
                            list.add(listdata);
                            // Toast.makeText(MainActivity.this,""+name,Toast.LENGTH_LONG).show();

                        }

                        RecyclerAdapter recycler = new RecyclerAdapter(list);
                        RecyclerView.LayoutManager layoutmanager = new LinearLayoutManager(FeedActivity.this);
                        recyclerview.setLayoutManager(layoutmanager);
                        recyclerview.setItemAnimator( new DefaultItemAnimator());
                        recyclerview.setAdapter(recycler);

                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        // Failed to read value
                        //  Log.w(TAG, "Failed to read value.", error.toException());
                    }
                });

            }



}
