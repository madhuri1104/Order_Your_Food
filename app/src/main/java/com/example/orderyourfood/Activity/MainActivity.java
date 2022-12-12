package com.example.orderyourfood.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.orderyourfood.Adapter.CategoryAdapter;
import com.example.orderyourfood.Adapter.RecommendedAdapter;
import com.example.orderyourfood.Domain.CategoryDomain;
import com.example.orderyourfood.Domain.FoodDomain;
import com.example.orderyourfood.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
RecyclerView.Adapter adapter,adapter2;
private RecyclerView catlist,popularlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();


        recycleCategory();
        recyclePopular();
        bottomNavigation();

    }
    public void onStart()
    {
       TextView name;
        name=findViewById(R.id.user_name_home);
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
                            String nameResult=task.getResult().getString("name");

                            name.setText("Hello "+nameResult);
                        }
                        else
                        {
                            startActivity(new Intent(MainActivity.this,LoginActivity.class));
                        }
                    }
                });


    }

    private void bottomNavigation() {
        LinearLayout homeBtn=findViewById(R.id.homeBtn);
        LinearLayout cartBtn=findViewById(R.id.cart);
        LinearLayout profile=findViewById(R.id.profile);
        LinearLayout settings=findViewById(R.id.settings);

//        homeBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(MainActivity.this,MainActivity.class));
//                finish();
//            }
//        });

        cartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, CartActivity.class));
                finish();
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ProfileActivity.class));
                finish();
            }
        });

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SettingsActivity.class));
                finish();
            }
        });
    }

    private void recyclePopular(){
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        popularlist=findViewById(R.id.view2);

        popularlist.setLayoutManager(linearLayoutManager);

        ArrayList<FoodDomain> foodList= new ArrayList<>();

        foodList.add(new FoodDomain("Pepperoni pizza","pizza1","slices pepperoni, mozzerella cheese, fresh organo, ground black pepper",130.0,5,20,1000));
        foodList.add(new FoodDomain("Cheese Burger","burger","beef, Gouda cheese, Special sauce, Lettuce, tomato",80.0,4,10,1000));
        foodList.add(new FoodDomain("Vegetable pizza","pizza2","Olive oil, Vegetable oil, pitted kalamata, cherry tomato, fresh organo, basil",150.0,5,15,1000));
        foodList.add(new FoodDomain("Hot Coffee","coffee"," Hot coffee,Darkly colored, bitter ",50.0,5,15,1000));
        foodList.add(new FoodDomain("Chicken Kebab","c3","Olive oil, spicy, grilled, delicious, hot",250.0,5,15,1000));
        foodList.add(new FoodDomain("Fish Kebab","fi1","Olive oil, spicy, grilled, delicious, hot",250.0,5,15,1000));
        foodList.add(new FoodDomain("Chocolate Toppings","i1","delicious, decadent, creamy, rich, sweet, and nutritious",100.0,5,15,1000));
        foodList.add(new FoodDomain("Kadai Chicken","cu5","A super tasty North Indian Style Chicken curry with a flavor-packed and rich masala. Goes well with rice and roti.",190.0,5,15,1000));
        foodList.add(new FoodDomain("Coca Cola","d8","delicious, cold, warm",60.0,5,15,1000));
        foodList.add(new FoodDomain("Chicken Dum Biryani","r3","spicy, grilled, delicious, hot",210.0,5,15,1000));


        adapter2=new RecommendedAdapter(foodList);
        popularlist.setAdapter(adapter2);
    }
    private void recycleCategory(){
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        catlist=findViewById(R.id.view1);
        catlist.setLayoutManager(linearLayoutManager);

        ArrayList<CategoryDomain> categoryList= new ArrayList<>();

        categoryList.add(new CategoryDomain("Pizza","cat_1"));
        categoryList.add(new CategoryDomain("Burger","cat_2"));
        categoryList.add(new CategoryDomain("Rice","rice"));
        categoryList.add(new CategoryDomain("Drink","cat_4"));
        categoryList.add(new CategoryDomain("Ice-Cream","icecream"));
        categoryList.add(new CategoryDomain("Curry","curry"));
        categoryList.add(new CategoryDomain("Chicken","c1"));
        categoryList.add(new CategoryDomain("Roti","roti"));
        adapter= new CategoryAdapter(categoryList);

        catlist.setAdapter(adapter);
    }


}