package com.example.orderyourfood.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.orderyourfood.Domain.FoodDomain;
import com.example.orderyourfood.Helper.ManagementCart;
import com.example.orderyourfood.R;

public class ShowDetailsActivity extends AppCompatActivity {
private TextView add_cart,titletxt,feetxt,desctxt,cont_order;
private ImageView plus,minus,picfood;
private FoodDomain object;
int num_ord=1;
private ManagementCart mngcrt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_details);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mngcrt=new ManagementCart(this);

        initView();
        getBundle();
    }

    private void getBundle() {
        object=(FoodDomain) getIntent().getSerializableExtra("object");

        titletxt.setText(object.getTitle());

        feetxt.setText("Rs."+object.getFee());

      int drawSourceId=this.getResources().getIdentifier(object.getPic(), "drawable",this.getPackageName());
      Glide.with(this).load(drawSourceId).into(picfood);
      //  picfood.setImageResource(drawSourceId);
        desctxt.setText(object.getDesc());
        cont_order.setText(String.valueOf(num_ord));

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num_ord=num_ord+1;
                cont_order.setText(String.valueOf(num_ord));
            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(num_ord>1){
                    num_ord=num_ord-1;

                }
                cont_order.setText(String.valueOf(num_ord));

            }
        });

        add_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                object.setNumberInCart(num_ord);
                mngcrt.inserfood(object);
            }
        });
    }

    private void initView() {
        add_cart=findViewById(R.id.add_cart);
        titletxt=findViewById(R.id.tit_detail);
        feetxt=findViewById(R.id.fee_det);
        desctxt=findViewById(R.id.desc_food);
        cont_order=findViewById(R.id.count_order_cart);

        plus=findViewById(R.id.plus_cart);
        minus=findViewById(R.id.minus_cart);

        picfood=findViewById(R.id.pic_det);




    }
}