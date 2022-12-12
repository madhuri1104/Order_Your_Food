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
            import com.example.orderyourfood.User;
            import com.google.android.gms.tasks.OnCompleteListener;
            import com.google.android.gms.tasks.Task;
            import com.google.firebase.auth.AuthResult;
            import com.google.firebase.auth.FirebaseAuth;
            import com.google.firebase.auth.FirebaseUser;
            import com.google.firebase.firestore.FirebaseFirestore;
//         import com.google.firebase.auth.FirebaseAuth;

//            import com.google.firebase.firestore.FirebaseFirestore;
//            import com.google.firebase.firestore.auth.User;

public class RegisterActivity extends AppCompatActivity {

    FirebaseAuth auth;

    ProgressDialog dialog;
    FirebaseUser muser;
    FirebaseFirestore database;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        getSupportActionBar().hide();


        // String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\.+[a-z]+";

        Button reg,log;
        reg=findViewById(R.id.signupB);
        log=findViewById(R.id.sign);

        EditText nam,ema,pas,vil,mob;
        nam=findViewById(R.id.username);
        ema=findViewById(R.id.emailID);
        pas=findViewById(R.id.passward);
        vil=findViewById(R.id.villege);
        mob=findViewById(R.id.mobile);

        auth=FirebaseAuth.getInstance();
        muser=auth.getCurrentUser();
        database=FirebaseFirestore.getInstance();

        dialog=new ProgressDialog(this);
        dialog.setMessage("Creating new Account....");

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email,pass,name1,confirm,vill,mobi;
                name1=nam.getText().toString();
                email=ema.getText().toString();
                pass=pas.getText().toString();
                vill=vil.getText().toString();
                mobi=mob.getText().toString();

                User user=new User(name1,email,pass,vill,mobi);

                if(email.isEmpty()) {
                    Toast.makeText(RegisterActivity.this,"enter email address",Toast.LENGTH_SHORT).show();
                }else if (!email.matches(emailPattern)) {
                        Toast.makeText(RegisterActivity.this,"Invalid email address",Toast.LENGTH_SHORT).show();
                }
                else if(pass.isEmpty() || pass.length()<8){
                    Toast.makeText(RegisterActivity.this,"Password is too short",Toast.LENGTH_SHORT).show();

                }
                else{
                    dialog.show();
                    auth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            String uid = task.getResult().getUser().getUid();
                            if(task.isSuccessful()){

                                database.collection("users").document(uid).set(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if(task.isSuccessful()){
                                            dialog.dismiss();
                                            Toast.makeText(RegisterActivity.this,"Register Successful",Toast.LENGTH_SHORT).show();
                                            startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
                                            finish();
                                        }
                                        else{
                                            dialog.dismiss();
                                            Toast.makeText(RegisterActivity.this, task.getException().getLocalizedMessage(), Toast.LENGTH_SHORT).show();

                                        }
                                    }
                                });

                            }
                            else{
                                dialog.dismiss();
                                Toast.makeText(RegisterActivity.this, task.getException().getLocalizedMessage(), Toast.LENGTH_SHORT).show();

                            }
                        }
                    });
                }

            }
        });

        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
                finish();
            }
        });
    }
}
