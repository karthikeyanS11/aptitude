package com.example.adminaptitude;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class AddQuestions extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_questions);

        ActionBar name = getSupportActionBar();
        name.setTitle("Add Questions");
    }
}
