package com.example.orderyourfood.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.orderyourfood.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {


    FirebaseAuth auth;
    ProgressDialog dialog;
    Button signIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();
        // binding=ActivityLoginBinding.inflate(getLayoutInflater());
        // setContentView(binding.getRoot());
        auth =FirebaseAuth.getInstance();
        dialog=new ProgressDialog(this);
        dialog.setMessage("Logging in....");
        Button log=findViewById(R.id.forgotSubmit);
        EditText em,pass;
        em=findViewById(R.id.emailID);
        pass=findViewById(R.id.password);
//
//
               if(auth.getCurrentUser()!=null){

            startActivity(new Intent(LoginActivity.this,MainActivity.class));
            finish();
        }



        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email,pass1;
                email=em.getText().toString();
                pass1=pass.getText().toString();
                dialog.show();
                auth.signInWithEmailAndPassword(email,pass1).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            dialog.dismiss();
                            startActivity(new Intent(LoginActivity.this,MainActivity.class));
                            finish();
                        }
                        else
                        {
                            dialog.dismiss();
                            Toast.makeText(LoginActivity.this,task.getException().getLocalizedMessage(),Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }

        });
        Button reg=findViewById(R.id.sign);
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
                finish();
            }
        });

TextView index=findViewById(R.id.index);

        index.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,ForgotPassActivity.class));
                finish();
            }
        });

    }
}