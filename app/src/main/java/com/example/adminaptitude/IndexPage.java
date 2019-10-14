package com.example.adminaptitude;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.adminaptitude.Adapter.GridAdapter;

public class IndexPage extends AppCompatActivity
    {
        GridView grid;
        String[] cards = {"Candidate List","Candidate Report","Questions List","Add Questions","Add Category","Delete Category"};

        int[] images= {R.drawable.candidatelist,R.drawable.candidatereport,
                R.drawable.questionlist,R.drawable.addquestions,R.drawable.addcategory,R.drawable.deletecategory};

        @Override
        protected void onCreate(Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_index_page);
            grid=findViewById(R.id.gridView);

            ActionBar name = getSupportActionBar();
            name.setTitle("Index");

            GridAdapter customAdapter = new GridAdapter(getApplicationContext(), cards,images);
            grid.setAdapter(customAdapter);

            grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id)
                {
                    if(position==0)
                    {
                        Intent intent = new Intent(IndexPage.this, CandidateList.class);
                        startActivity(intent);
                    }
                    else if (position==1)
                    {
                        Intent intent = new Intent(IndexPage.this, CandidateReport.class);
                        startActivity(intent);
                    }
                    else if (position==2)
                    {
                        Intent intent = new Intent(IndexPage.this, SelectQuestionList.class);
                        startActivity(intent);
                    }
                    else if (position==3)
                    {
                        Intent intent = new Intent(IndexPage.this, SelectAddQuestions.class);
                        startActivity(intent);
                    }
                    else if (position==4)
                    {
                        Intent intent = new Intent(IndexPage.this, AddCategory.class);
                        startActivity(intent);
                    }
                    else if (position==5)
                    {
                        Intent intent = new Intent(IndexPage.this, SelectDeleteCategory.class);
                        startActivity(intent);
                    }
                }
            });
        }
    }