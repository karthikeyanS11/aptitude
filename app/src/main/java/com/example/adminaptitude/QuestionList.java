package com.example.adminaptitude;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.example.adminaptitude.Adapter.CandidateAdapter;
import com.example.adminaptitude.Adapter.QuestionAdapter;
import com.example.adminaptitude.ModelData.Modeldata;

import java.util.ArrayList;
import java.util.List;

public class QuestionList extends AppCompatActivity {

    Context context;
    RecyclerView recyclerView;
    RecyclerView.Adapter recyclerViewAdapter;
    RecyclerView.LayoutManager recylerViewLayoutManager;

    private void init() {
        recyclerView = findViewById(R.id.recycler_qsn);
    }

    private List<Modeldata.ModelQuestion> modelquestion()
    {
        List<Modeldata.ModelQuestion> question = new ArrayList<>();

        question.add(new Modeldata.ModelQuestion("What is Aptitude?", "Answer 1", "Answer 2",
                "Answer 3", "Answer 4","Correcct Answer"));
        return question;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_list);

        ActionBar name = getSupportActionBar();
        name.setTitle("Question List");

        init();
        recylerViewLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(recylerViewLayoutManager);

        recyclerViewAdapter = new QuestionAdapter(modelquestion(), context);
        recyclerView.setAdapter(recyclerViewAdapter);

        recyclerView.setHasFixedSize(true);
    }
}
