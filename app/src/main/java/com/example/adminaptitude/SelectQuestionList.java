package com.example.adminaptitude;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SelectQuestionList extends AppCompatActivity
{
    Button fetch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_question_list);

        ActionBar name = getSupportActionBar();
        name.setTitle("Question List");

        init();

        fetch.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i=new Intent(SelectQuestionList.this,QuestionList.class);
                startActivity(i);
            }
        });
    }
    private void init() {
        fetch=findViewById(R.id.fetch_question);
    }
}
