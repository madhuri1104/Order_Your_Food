package com.example.orderyourfood.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.orderyourfood.Adapter.cartListAdapter;
import com.example.orderyourfood.Helper.ManagementCart;
import com.example.orderyourfood.Interface.ChangeNumber;
import com.example.orderyourfood.R;

public class CartActivity extends AppCompatActivity {
private RecyclerView.Adapter adapter;
private RecyclerView recyclerViewList;
private ManagementCart managementCart;
private TextView TotalFeeTxt,taxtxt,deliveryTxt,totalTxt,emptyTxt;
private double tax;
private ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        getSupportActionBar().hide();
        managementCart=new ManagementCart(this);
        ConstraintLayout check ;
check=findViewById(R.id.add_cart_cat);
        initView();
       initList();
        calculateCart();

        bottomNavigation();

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String total=totalTxt.getText().toString();
                Intent intent=new Intent(CartActivity.this,PaymentActivity.class);
                intent.putExtra("keyname",total);
                startActivity(intent);
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
                startActivity(new Intent(CartActivity.this,MainActivity.class));
                finish();
            }
        });

//        cartBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(CartActivity.this, CartActivity.class));
//            }
//        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CartActivity.this, ProfileActivity.class));
                finish();
            }
        });

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CartActivity.this, SettingsActivity.class));
                finish();
            }
        });
    }

    private void initList() {
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerViewList.setLayoutManager(linearLayoutManager);

        adapter=new cartListAdapter(managementCart.getListCart(),managementCart.getListCart1(), this, new ChangeNumber() {

            public void changed() {
                calculateCart();
            }
        });
recyclerViewList.setAdapter(adapter);

if(managementCart.getListCart().isEmpty()){
    emptyTxt.setVisibility(View.VISIBLE);
    scrollView.setVisibility(View.GONE);
}
else{
    emptyTxt.setVisibility(View.GONE);
    scrollView.setVisibility(View.VISIBLE);
}
    }

    private void calculateCart() {
        double percentTax=0.02;
        double delivery=10;

        tax=Math.round((managementCart.getTotalFee()*percentTax)*100.0)/100.0;
        double total=Math.round((managementCart.getTotalFee()+tax+delivery)*100.0)/100.0;
        double itemTotal=Math.round((managementCart.getTotalFee())*100.0)/100.0;

        TotalFeeTxt.setText("RS."+itemTotal);
        taxtxt.setText("RS."+tax);
        deliveryTxt.setText("RS."+delivery);
        totalTxt.setText("RS."+total);
    }

    private void initView() {
        TotalFeeTxt=findViewById(R.id.itemTotal);
        taxtxt=findViewById(R.id.tax);
        deliveryTxt=findViewById(R.id.delivery);
        totalTxt=findViewById(R.id.totalAmount);
        recyclerViewList=findViewById(R.id.view_cart);
        scrollView=findViewById(R.id.scrollView3);

        emptyTxt=findViewById(R.id.empty);





    }
}