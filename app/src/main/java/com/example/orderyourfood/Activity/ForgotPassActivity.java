package com.example.orderyourfood.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.orderyourfood.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPassActivity extends AppCompatActivity {
    EditText txtEmail;
    String email;
    Button forgot;
    FirebaseAuth auth;
    ProgressDialog dia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_pass);
        getSupportActionBar().setTitle("Forgot Password");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        auth=FirebaseAuth.getInstance();
        dia=new ProgressDialog(this);
        txtEmail=findViewById(R.id.emailID);
        forgot=findViewById(R.id.forgotSubmit);
        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateData();
            }
        });

    }

    private void validateData() {
        email=txtEmail.getText().toString();
        if(email.isEmpty()){
            txtEmail.setError("Required");
        }
        else
        {
            forgotPassword();
        }
    }

    private void forgotPassword() {
        auth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    Toast.makeText(ForgotPassActivity.this, "Check Your Email", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(ForgotPassActivity.this,LoginActivity.class));
                    finish();
                }
                else
                {
                    Toast.makeText(ForgotPassActivity.this, "Error"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}