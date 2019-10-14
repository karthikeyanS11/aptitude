package com.example.adminaptitude;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SelectDeleteCategory extends AppCompatActivity {

    Button Delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_delete_category);

        ActionBar name = getSupportActionBar();
        name.setTitle("Delete Category");

        init();

        Delete.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

            }
        });
    }
    private void init() {
        Delete=findViewById(R.id.delete_category);
    }
}

