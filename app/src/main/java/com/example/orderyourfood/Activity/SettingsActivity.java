package com.example.orderyourfood.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.orderyourfood.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SettingsActivity extends AppCompatActivity {



    private FirebaseAuth firebaseAuth;
    ProgressDialog dia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        firebaseAuth = FirebaseAuth.getInstance();
        dia = new ProgressDialog(this);
        getSupportActionBar().setTitle("Settings");

        bottomNavigation();
    }

    private void bottomNavigation() {
        LinearLayout homeBtn=findViewById(R.id.homeBtn);
        LinearLayout cartBtn=findViewById(R.id.cart);
        LinearLayout profile=findViewById(R.id.profile);
        LinearLayout settings=findViewById(R.id.settings);
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SettingsActivity.this,MainActivity.class));
                finish();
            }
        });

        cartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SettingsActivity.this, CartActivity.class));
                finish();
            }
        });

//        settings.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(SettingsActivity.this, SettingsActivity.class));
//            }
//        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SettingsActivity.this, ProfileActivity.class));
                finish();
            }
        });
    }


    public void Logout(View view) {
        firebaseAuth.signOut();
        finish();
        startActivity(new Intent(SettingsActivity.this, LoginActivity.class));
    }

    public void deleteAccount(View view) {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            dia.setMessage("Deleting your account..Please Wait!!");
            dia.show();
            user.delete().addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {
                        dia.dismiss();
                        Toast.makeText(getApplicationContext(), "Account deleted", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(SettingsActivity.this, RegisterActivity.class));
                        finish();
                    } else {
                        dia.dismiss();
                        Toast.makeText(getApplicationContext(), "Account could not be deleted", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}