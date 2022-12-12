package com.example.orderyourfood.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.orderyourfood.Domain.FoodDomain;
import com.example.orderyourfood.Domain.RiceDomain;
import com.example.orderyourfood.Helper.ManagementCart;
import com.example.orderyourfood.Interface.ChangeNumber;
import com.example.orderyourfood.R;

import java.util.ArrayList;

public class cartListAdapter extends RecyclerView.Adapter<cartListAdapter.ViewHolder> {

    public ArrayList<FoodDomain> ListFoodSelected;
    ArrayList<RiceDomain> ListFoodSelected_rice;

   private ManagementCart managementCart;
   ChangeNumber changeNumber;

    public cartListAdapter(ArrayList<FoodDomain> ListFoodSelected, ArrayList<RiceDomain> ListFoodSelected_rice, Context context, ChangeNumber changeNumber) {

        this.ListFoodSelected =ListFoodSelected ;
        this.ListFoodSelected_rice =ListFoodSelected_rice ;
        managementCart=new ManagementCart(context);
        this.changeNumber=changeNumber;

    }

    @NonNull
    @Override
    public cartListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate= LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_cart,parent,false);

        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull cartListAdapter.ViewHolder holder, int position) {

holder.title.setText(ListFoodSelected.get(position).getTitle());
holder.feeEachItem.setText("Rs."+ListFoodSelected.get(position).getFee());
holder.totalEachItem.setText("Rs."+Math.round((ListFoodSelected.get(position).getNumberInCart()*ListFoodSelected.get(position).getFee())));
holder.num.setText(String.valueOf(ListFoodSelected.get(position).getNumberInCart()));


int drawableResourceId=holder.itemView.getContext().getResources().getIdentifier(ListFoodSelected.get(position).getPic(),"drawable",holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext()).load(drawableResourceId).into(holder.pic);

  holder.plusItem.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
          managementCart.plusNumFood(ListFoodSelected, position, new ChangeNumber() {
              @Override
              public void changed() {
                  notifyDataSetChanged();
                  changeNumber.changed();
              }
          });
      }
  });

        holder.minusItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                managementCart.minusNumFood(ListFoodSelected, position, new ChangeNumber() {
                    @Override
                    public void changed() {
                        notifyDataSetChanged();
                        changeNumber.changed();
                    }
                });
            }
        });
    }

    @Override
    public int getItemCount() {
        return ListFoodSelected.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView title,feeEachItem,totalEachItem,num;
        ImageView pic,plusItem,minusItem;
        ConstraintLayout check;

        public ViewHolder(@NonNull View itemView){
            super(itemView);

            title=itemView.findViewById(R.id.title_cart_inside);
            pic=itemView.findViewById(R.id.img_cart_inside);
            totalEachItem=itemView.findViewById(R.id.total_cart_inside);
            feeEachItem=itemView.findViewById(R.id.feeEachItem);
            plusItem=itemView.findViewById(R.id.plus_cart);
            minusItem=itemView.findViewById(R.id.minus_cart);
            num=itemView.findViewById(R.id.count_order_cart);
            check=itemView.findViewById(R.id.add_cart_cat);
        }
    }
}

