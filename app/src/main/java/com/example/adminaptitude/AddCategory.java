package com.example.adminaptitude;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.example.adminaptitude.Adapter.SpinnerAdapter;
import com.example.adminaptitude.Adapter.SpinnerAdapterCategory;
import com.example.adminaptitude.Adapter.SpinnerAdapterSet;
import com.example.adminaptitude.Adapter.SpinnerAdapterSubCategory;
import com.example.adminaptitude.ModelData.ModelClassForSet;
import com.example.adminaptitude.ModelData.ModelClassForSubCategory;
import com.example.adminaptitude.ModelData.ModelClassForType;
import com.example.adminaptitude.ModelData.ModelcalssForCategory;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class AddCategory extends AppCompatActivity
{
    SpinnerAdapter spinnerAdapter;
    SpinnerAdapterCategory spinnerAdapterCategory;
    SpinnerAdapterSubCategory spinnerAdapterSubCategory;
    SpinnerAdapterSet spinnerAdapterSet;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    EditText editText,eduText1,eduText2,eduText3;
    Button btn_add,btn_add1,btn_add2,btn_add3;
    Spinner spinner,spinner1,spinner2,spinner3;
    String clickedItemType,ItemCategory,ItemSubcategory,ItemSet;
    public String a,b,c;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_category);

        ActionBar name = getSupportActionBar();
        name.setTitle("Add Category");

        btn_add=findViewById(R.id.add_type);
        btn_add1=findViewById(R.id.add_category);
        btn_add2=findViewById(R.id.add_subcategory);
        btn_add3=findViewById(R.id.add_set);

        editText = findViewById(R.id.edu_type);
        eduText1 =findViewById(R.id.edu_category);
        eduText2 = findViewById(R.id.edu_subcategory);
        eduText3 = findViewById(R.id.edu_set);

        spinner = (Spinner)findViewById(R.id.select_type2);
        spinner1= (Spinner)findViewById(R.id.select_category2);
        spinner2 =(Spinner)findViewById(R.id.select_subcategory2);
        spinner3 = (Spinner)findViewById(R.id.select_set2);

        databaseReference =FirebaseDatabase.getInstance().getReference().child("type");
        databaseReference.addValueEventListener(new ValueEventListener()
        {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                ArrayList<ModelClassForType> item;
                item=new ArrayList<>();
                for (DataSnapshot postSnapshot: dataSnapshot.getChildren())
                {
                    ModelClassForType model1 =postSnapshot.getValue(ModelClassForType.class);
                    item.add(model1);
                    Log.v("AddType","Response from firebase"+model1);
                }
                spinnerAdapter = new SpinnerAdapter(AddCategory.this,0,item);
                spinner.setAdapter(spinnerAdapter);

            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError)
            {

            }
        });

        categoryspinner();
        subcategoryspinner();
        setspinner();

        btn_add.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String getType  = editText.getText().toString();
                if(getType.isEmpty())
                {
                    editText.setError("enter type");
                    editText.setFocusable(true);
                }
                else {
                    firebaseDatabase = FirebaseDatabase.getInstance();
                    databaseReference = firebaseDatabase.getReference().child("type");
                    databaseReference.push().child("typename").setValue(getType);
                    editText.setText("");
                }
            }
        });

        btn_add1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String getCategory  = eduText1.getText().toString();
                if(getCategory.isEmpty())
                {
                    eduText1.setError("enter category");
                    eduText1.setFocusable(true);
                }
                else {
                    firebaseDatabase = FirebaseDatabase.getInstance();
                    databaseReference = firebaseDatabase.getReference().child(a);

                    databaseReference.push().child("categoryname").setValue(getCategory);
                    eduText1.setText("");
                }
            }
        });

        btn_add2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String getSubCategory  = eduText2.getText().toString();
                if(getSubCategory.isEmpty())
                {
                    eduText2.setError("enter subcategory");
                    eduText2.setFocusable(true);
                }
                else
                {
                    firebaseDatabase =FirebaseDatabase.getInstance();
                    databaseReference=firebaseDatabase.getReference().child(b);

                    databaseReference.push().child("subcategoryname").setValue(getSubCategory);
                    eduText2.setText("");
                }
            }
        });

        btn_add3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String getSet  = eduText3.getText().toString();
                if(getSet.isEmpty())
                {
                    eduText3.setError("enter set");
                    eduText3.setFocusable(true);
                }
                else
                {
                    firebaseDatabase =FirebaseDatabase.getInstance();
                    databaseReference=firebaseDatabase.getReference().child(c);
                    databaseReference.push().child("setname").setValue(getSet);
                    eduText3.setText("");
                }
            }
        });
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                ModelClassForType clickedItem = (ModelClassForType) parent.getItemAtPosition(position);
                clickedItemType = clickedItem.getTypename();
                Toast.makeText(AddCategory.this, clickedItemType+"Selected", Toast.LENGTH_SHORT).show();

                SharedPreferences sharedtype= getSharedPreferences("type",MODE_PRIVATE);
                SharedPreferences.Editor edit = sharedtype.edit();
                edit.putString("first",clickedItemType);
                edit.apply();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {

            }
        });
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                ModelcalssForCategory clickedItem = (ModelcalssForCategory) parent.getItemAtPosition(position);
                ItemCategory = clickedItem.getCategoryname();
                Toast.makeText(AddCategory.this, a+"Selected", Toast.LENGTH_SHORT).show();

                SharedPreferences sharedcategory= getSharedPreferences("category",MODE_PRIVATE);
                SharedPreferences.Editor edit1 = sharedcategory.edit();
                edit1.putString("second",ItemCategory);
                edit1.apply();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {

            }
        });

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                ModelClassForSubCategory clickedItem = (ModelClassForSubCategory) parent.getItemAtPosition(position);
                ItemSubcategory = clickedItem.getSubcategoryname();
                Toast.makeText(AddCategory.this, b+"Selected", Toast.LENGTH_SHORT).show();

                SharedPreferences sharedsubcategory= getSharedPreferences("subcategory",MODE_PRIVATE);
                SharedPreferences.Editor edit2 = sharedsubcategory.edit();
                edit2.putString("third",ItemSubcategory);
                edit2.apply();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {

            }
        });

        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                ModelClassForSet clickedItem = (ModelClassForSet) parent.getItemAtPosition(position);
                ItemSet = clickedItem.getSetname();
                Toast.makeText(AddCategory.this, c+"Selected", Toast.LENGTH_SHORT).show();

                SharedPreferences sharedset= getSharedPreferences("set",MODE_PRIVATE);
                SharedPreferences.Editor edit3 = sharedset.edit();
                edit3.putString("fourth",ItemSet);
                edit3.apply();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {

            }
        });
    }

    public void categoryspinner()
    {
        SharedPreferences sharedget = getSharedPreferences("type",MODE_PRIVATE);
        a = sharedget.getString("first","demo");

        databaseReference = FirebaseDatabase.getInstance().getReference().child(a);
        databaseReference.addValueEventListener(new ValueEventListener()
        {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                ArrayList<ModelcalssForCategory> categoryitem;
                categoryitem = new ArrayList<>();
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren())
                {
                    ModelcalssForCategory model2 = postSnapshot.getValue(ModelcalssForCategory.class);
                    categoryitem.add(model2);
                }
                spinnerAdapterCategory = new SpinnerAdapterCategory(AddCategory.this, 0, categoryitem);
                spinner1.setAdapter(spinnerAdapterCategory);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
    public void subcategoryspinner()
    {
        SharedPreferences sharedget1 = getSharedPreferences("category",MODE_PRIVATE);
        b = sharedget1.getString("second","demo");

        databaseReference = FirebaseDatabase.getInstance().getReference().child(b);
        databaseReference.addValueEventListener(new ValueEventListener()
        {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                ArrayList<ModelClassForSubCategory> subcategoryitem;
                subcategoryitem = new ArrayList<>();
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    ModelClassForSubCategory model3 = postSnapshot.getValue(ModelClassForSubCategory.class);
                    subcategoryitem.add(model3);
                }
                spinnerAdapterSubCategory = new SpinnerAdapterSubCategory(AddCategory.this, 0, subcategoryitem);
                spinner2.setAdapter(spinnerAdapterSubCategory);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void setspinner()
    {
        SharedPreferences sharedget2 = getSharedPreferences("subcategory",MODE_PRIVATE);
        c = sharedget2.getString("third","demo");

        databaseReference = FirebaseDatabase.getInstance().getReference().child(c);
        databaseReference.addValueEventListener(new ValueEventListener()
        {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                ArrayList<ModelClassForSet> setitem;
                setitem = new ArrayList<>();
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    ModelClassForSet model4 = postSnapshot.getValue(ModelClassForSet.class);
                    setitem.add(model4);
                }
                spinnerAdapterSet = new SpinnerAdapterSet(AddCategory.this, 0, setitem);
                spinner3.setAdapter(spinnerAdapterSet);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
