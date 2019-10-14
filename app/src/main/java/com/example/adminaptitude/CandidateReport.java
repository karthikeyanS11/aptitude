package com.example.adminaptitude;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class CandidateReport extends AppCompatActivity {

    Spinner sp1,sp2;
    Button b1;
    RecyclerView recyclerView;
    RecyclerView.Adapter recyclerViewAdapter;
    RecyclerView.LayoutManager recylerViewLayoutManager;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_candidate_report);
        ActionBar name = getSupportActionBar();
        name.setTitle("Candidate Report");
        init();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CandidateReport.this, "Api functions", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void init() {
        sp1 = findViewById(R.id.select_category);
        sp2 = findViewById(R.id.select_candidate);
        b1 = findViewById(R.id.Report);
    }
}
