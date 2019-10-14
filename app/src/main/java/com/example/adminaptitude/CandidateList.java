package com.example.adminaptitude;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.adminaptitude.Adapter.CandidateAdapter;
import com.example.adminaptitude.ModelData.Modeldata;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class CandidateList extends AppCompatActivity
{
    FloatingActionButton fab;
    Context context;
    RecyclerView recyclerView;
    RecyclerView.Adapter recyclerViewAdapter;
    RecyclerView.LayoutManager recylerViewLayoutManager;

    CandidateAdapter adapter;
    private DatabaseReference databaseReference;
    ArrayList<Modeldata> data;
    ImageView close;
    ProgressDialog progressDialog;
    Calendar myCalender = Calendar.getInstance();

    private void init()
    {
        fab = findViewById(R.id.fab);
        recyclerView = findViewById(R.id.recycler);
        close = (ImageView) findViewById(R.id.delete);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_candidate_list);

        ActionBar name = getSupportActionBar();
        name.setTitle("Candidate List");

        progressDialog = new ProgressDialog(CandidateList.this);
        progressDialog.setMessage("Loading...");
        progressDialog.setTitle("Candidate List");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.show();
        progressDialog.setCancelable(false);

        new Thread(new Runnable()
        {
            public void run()
            {
                try
                {
                    Thread.sleep(5000);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                progressDialog.dismiss();
            }
        }).start();

        init();
        recylerViewLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(recylerViewLayoutManager);

        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setHasFixedSize(true);

        databaseReference= FirebaseDatabase.getInstance().getReference().child("candidates");
        databaseReference.addValueEventListener(new ValueEventListener()
        {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                 data= new ArrayList<>();
                 for(DataSnapshot postSnapshot : dataSnapshot.getChildren())
                 {
                     Modeldata model =postSnapshot.getValue(Modeldata.class);
                     data.add(model);
                 }
                 adapter = new CandidateAdapter(data,context);
                 recyclerView.setAdapter(adapter);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError)
            {
                Toast.makeText(CandidateList.this,"Something Wrong",Toast.LENGTH_SHORT)
                        .show();
            }
        });
        fab.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                LayoutInflater li = LayoutInflater.from(CandidateList.this);
                View candidate = li.inflate(R.layout.addcandidate,null);
                Log.v("Clicked", "Working");

                AlertDialog.Builder alertDialog = new AlertDialog.Builder(CandidateList.this);
                alertDialog.setTitle("Candidate Details");
                alertDialog.setView(candidate);

                final TextInputEditText name, userid, mobile, email, password,dob;

                name = (TextInputEditText) candidate.findViewById(R.id.add_name);
                userid = (TextInputEditText) candidate.findViewById(R.id.add_userid);
                mobile = (TextInputEditText) candidate.findViewById(R.id.add_mobile);
                email = (TextInputEditText) candidate.findViewById(R.id.add_email);
                password = (TextInputEditText) candidate.findViewById(R.id.add_password);
                dob = (TextInputEditText) candidate.findViewById(R.id.add_dob);

                final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener()
                {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth)
                    {
                        myCalender.set(Calendar.YEAR, year);
                        myCalender.set(Calendar.MONTH, monthOfYear);
                        myCalender.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                        updateLabel();
                    }
                    private void updateLabel()
                    {
                        String myFormat = "MM/dd/yy";
                        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
                        dob.setText(sdf.format(myCalender.getTime()));
                    }
                };
                dob.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        new DatePickerDialog(CandidateList.this, date, myCalender
                                .get(Calendar.YEAR), myCalender.get(Calendar.MONTH),
                                myCalender.get(Calendar.DAY_OF_MONTH)).show();
                    }
                });
                alertDialog.setCancelable(false)
                        .setPositiveButton("Add", new DialogInterface.OnClickListener()
                        {
                            @Override
                            public void onClick(DialogInterface dialog, int which)
                            {
                                FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
                                databaseReference = firebaseDatabase.getReference().child("candidates").child(userid.getText().toString());

                                String getname=name.getText().toString();
                                databaseReference.child("name").setValue(getname);

                                String getid=userid.getText().toString();
                                databaseReference.child("userid").setValue(getid);

                                String getmobile=mobile.getText().toString();
                                databaseReference.child("mobile").setValue(getmobile);

                                String getmail=email.getText().toString();
                                databaseReference.child("email").setValue(getmail);

                                String getpass=password.getText().toString();
                                databaseReference.child("password").setValue(getpass);

                                String getdob = dob.getText().toString();
                                databaseReference.child("dob").setValue(getdob);
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener()
                        {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                        AlertDialog alertDialog1 = alertDialog.create();
                        alertDialog1.show();
                        alertDialog1.setCanceledOnTouchOutside(true);
            }
        });
    }
}

