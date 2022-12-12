package com.example.orderyourfood.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.orderyourfood.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class ProfileActivity extends AppCompatActivity {
    public TextView name,email,village,mobile;

    public Button btn;
    ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        bottomNavigation();

        getSupportActionBar().hide();


        dialog=new ProgressDialog(this);
        dialog.setMessage("Loading....");

        name=findViewById(R.id.username_p_up);
        email=findViewById(R.id.emailID_p);
        village=findViewById(R.id.villege_p_up);
        mobile=findViewById(R.id.mobile_p_up);
        btn=findViewById(R.id.button_update);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProfileActivity.this,UpdateProfileActivity.class));

            }
        });
    }

    public void onStart()
    {
        dialog.show();
        super.onStart();
        FirebaseUser user= FirebaseAuth.getInstance().getCurrentUser();
        String currentid=user.getUid();
        DocumentReference reference;
        FirebaseFirestore firestore=FirebaseFirestore.getInstance();
        reference=firestore.collection("users").document(currentid);
        reference.get()
                .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        if(task.getResult().exists()){
                            dialog.dismiss();
                            String emailResult=task.getResult().getString("email");
                            String nameResult=task.getResult().getString("name");
                            String villageResult=task.getResult().getString("village");
                            String mobileResult=task.getResult().getString("mobile");


                            name.setText(nameResult);
                            email.setText(emailResult);
                            village.setText(villageResult);
                            mobile.setText(mobileResult);


                        }
                        else
                        {
                            dialog.dismiss();
                            startActivity(new Intent(ProfileActivity.this,LoginActivity.class));
                        }
                    }
                });


    }

    private void bottomNavigation() {
        LinearLayout homeBtn=findViewById(R.id.homeBtn);
        LinearLayout cartBtn=findViewById(R.id.cart);
        LinearLayout profile=findViewById(R.id.profile);
        LinearLayout settings=findViewById(R.id.settings);

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProfileActivity.this,MainActivity.class));
                finish();
            }
        });

        cartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProfileActivity.this, CartActivity.class));
                finish();
            }
        });

//        profile.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(ProfileActivity.this, ProfileActivity.class));
//            }
//        });

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProfileActivity.this, SettingsActivity.class));
                finish();
            }
        });
    }
}