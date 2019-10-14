package com.example.adminaptitude.Adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.adminaptitude.CandidateList;
import com.example.adminaptitude.ModelData.Modeldata;
import com.example.adminaptitude.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import android.app.AlertDialog;

public class CandidateAdapter extends RecyclerView.Adapter<CandidateAdapter.ViewHolder>
{
    private ArrayList<Modeldata> modeldataList;
    private Context context;
    DatabaseReference databaseReference;

    public CandidateAdapter(ArrayList<Modeldata> models, Context context)
    {
        this.modeldataList = models;
        this.context = context;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View v = layoutInflater.inflate(R.layout.candidatecardview, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int i)
    {
        final Modeldata modeldata = modeldataList.get(i);

        holder.name.setText(modeldata.getName());
        holder.userid.setText(modeldata.getUserid());
        holder.mobile.setText(modeldata.getMobile());
        holder.email.setText(modeldata.getEmail());
        holder.password.setText(modeldata.getPassword());
        holder.dob.setText(modeldata.getDob());

        holder.close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(holder.email.getContext());
                alertDialogBuilder.setTitle("Confirm Exit..!!!");
                alertDialogBuilder.setIcon(R.drawable.question);
                alertDialogBuilder.setMessage("Are you sure, You want to delete?");
                alertDialogBuilder.setCancelable(false);

                alertDialogBuilder.setPositiveButton("Delete", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        String a =modeldata.getUserid();
                        FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
                        databaseReference = firebaseDatabase.getReference().child("candidates").child(a);
                        databaseReference.removeValue();
                    }
                });
                alertDialogBuilder.setNeutralButton("Cancel", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        dialog.cancel();
                    }
                });
                AlertDialog alertDialog1 = alertDialogBuilder.create();
                alertDialog1.show();
                alertDialog1.setCanceledOnTouchOutside(true);
            }
        });
    }
    @Override
    public int getItemCount()
    {
        return modeldataList.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        public TextView name, userid, email, mobile, password,dob;
        ImageView close;

        public ViewHolder( View itemView) {
            super(itemView);

            this.name = itemView.findViewById(R.id.edu_name);
            this.userid = itemView.findViewById(R.id.edu_userid);
            this.mobile = itemView.findViewById(R.id.edu_mobile);
            this.email = itemView.findViewById(R.id.edu_email);
            this.password = itemView.findViewById(R.id.edu_password);
            this.dob = itemView.findViewById(R.id.edu_dob);
            this.close = itemView.findViewById(R.id.delete);

        }
    }
}
