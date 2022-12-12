package com.example.orderyourfood.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.orderyourfood.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Transaction;

public class UpdateProfileActivity extends AppCompatActivity {
    public TextView name,email,village,mobile;

    public Button btn;
    ProgressDialog dialog;

    FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
    DatabaseReference reference;
    DocumentReference documentReference;
    FirebaseFirestore db=FirebaseFirestore.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_profile);

        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        dialog=new ProgressDialog(this);
        dialog.setMessage("Loading....");

        name=findViewById(R.id.username_p_up);
        village=findViewById(R.id.villege_p_up);
        mobile=findViewById(R.id.mobile_p_up);
        btn=findViewById(R.id.button_update2);

        FirebaseUser user= FirebaseAuth.getInstance().getCurrentUser();
        String currentuid=user.getUid();
        documentReference=db.collection("users").document(currentuid);



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                updateProfile();
            }
        });
    }

    protected void onStart(){
        super.onStart();


        documentReference.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if(task.getResult().exists())
                {
                    String nameResult=task.getResult().getString("name");
                    String villageResult=task.getResult().getString("village");
                    String mobileResult=task.getResult().getString("mobile");

                    name.setText(nameResult);
                    village.setText(villageResult);
                    mobile.setText(mobileResult);
                }
                else{
                    Toast.makeText(UpdateProfileActivity.this,"No profile",Toast.LENGTH_SHORT);
                }
            }
        });
    }
    private void updateProfile() {
        String nameResult=name.getText().toString();
        String villageResult=village.getText().toString();
        String mobileResult=mobile.getText().toString();

        FirebaseUser user1= FirebaseAuth.getInstance().getCurrentUser();
        String currentid=user1.getUid();

        final DocumentReference sfdoc=db.collection("users").document(currentid);
        db.runTransaction(new Transaction.Function<Void>() {
                    @Override
                    public Void apply(Transaction transaction) throws FirebaseFirestoreException {
                        // DocumentSnapshot snapshot = transaction.get(sfDocRef);


                        transaction.update(sfdoc, "name",nameResult );
                        transaction.update(sfdoc, "village",villageResult );
                        transaction.update(sfdoc, "mobile",mobileResult );


                        // Success
                        return null;
                    }
                }).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(UpdateProfileActivity.this, "Successfully Updated", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(UpdateProfileActivity.this,ProfileActivity.class));
                        finish();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(UpdateProfileActivity.this, "Update Failed", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}