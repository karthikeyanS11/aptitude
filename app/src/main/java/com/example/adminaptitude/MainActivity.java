package com.example.adminaptitude;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity
{
    private static final String TAG ="MainActivity";

    private static final int REQUEST_CODE = 1;
    private static final String[] PERMISSIONS = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.CAMERA};

    EditText UserName,Password;
    Button Login;
    ImageView PasswordVisible,passwordUnVisible;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar name = getSupportActionBar();
        name.setTitle("Admin Login");

        UserName=(EditText)findViewById(R.id.edt_uname);
        Password=(EditText)findViewById(R.id.edt_password);
        Login=(Button)findViewById(R.id.button);
        passwordUnVisible=findViewById(R.id.passwordunvisible);
        PasswordVisible = (ImageView) findViewById(R.id.passwordVisible);
        passwordUnVisible.setVisibility(View.INVISIBLE);

        init();
        verifyPermissions();
    }

    public void init()
    {
        PasswordVisible.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                PasswordVisible.setVisibility(View.GONE);
                passwordUnVisible.setVisibility(View.VISIBLE);
                Password.setTransformationMethod(null);
            }
        });

        passwordUnVisible.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                passwordUnVisible.setVisibility(View.GONE);
                PasswordVisible.setVisibility(View.VISIBLE);
                Password.setTransformationMethod(new PasswordTransformationMethod());
            }
        });
        Login.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if (UserName.getText().toString().trim().equalsIgnoreCase(""))
                {
                    UserName.setError("Could not be empty");
                }else
                {
                    if(Password.getText().toString().trim().isEmpty()) {
                        Password.setError("Could not be empty");
                    }
                    else {
                        Intent i = new Intent(MainActivity.this, IndexPage.class);
                        startActivity(i);
                    }
                }
            }
        });
    }
    private void verifyPermissions()
    {
        Log.v("VerifyPermission","Checking Permission");

        int permissionReadEx = ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE);

        int permissionWriteEx = ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if (permissionReadEx!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(
                    MainActivity.this,
                    PERMISSIONS,REQUEST_CODE
            );
        }

        if (permissionWriteEx!=PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(
                    MainActivity.this,
                    PERMISSIONS,REQUEST_CODE
            );
        }
    }
}