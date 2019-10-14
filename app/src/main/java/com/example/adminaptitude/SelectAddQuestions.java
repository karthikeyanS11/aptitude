package com.example.adminaptitude;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SelectAddQuestions extends AppCompatActivity
{
    Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_add_questions);

        ActionBar name = getSupportActionBar();
        name.setTitle("Add Questions");

        init();

        add.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i=new Intent(SelectAddQuestions.this,AddQuestions.class);
                startActivity(i);
            }
        });
    }
    private void init() {
        add=findViewById(R.id.add_question);
    }
}
