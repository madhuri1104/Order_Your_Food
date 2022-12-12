package com.example.orderyourfood.Helper;

import android.content.Context;
import android.widget.Toast;

import com.example.orderyourfood.Domain.FoodDomain;
import com.example.orderyourfood.Domain.RiceDomain;
import com.example.orderyourfood.Interface.ChangeNumber;

import java.util.ArrayList;

public class ManagementCart {

    private Context context;
    private TinyDB tinyDB;



    public ManagementCart(Context context){
        this.context=context;
        this.tinyDB=new TinyDB(context);

    }

    public void inserfood_cat(RiceDomain item){
        ArrayList<RiceDomain> ListFood1=getListCart1();
        boolean existAlready=false;
        int n=0;

        for (int i=0;i<ListFood1.size();i++){
            if(ListFood1.get(i).getTitle().equals(item.getTitle())){
                existAlready=true;
                n=i;
                break;
            }
        }

        if(existAlready){
            ListFood1.get(n).setNumberInCart(item.getNumberInCart());
        }
        else{
            ListFood1.add(item);
        }
        tinyDB.putListObject_rice("CardList",ListFood1);
        Toast.makeText(context, "Added to your cart", Toast.LENGTH_SHORT).show();
    }

    public void inserfood(FoodDomain item){
        ArrayList<FoodDomain> ListFood=getListCart();
        boolean existAlready=false;
        int n=0;

        for (int i=0;i<ListFood.size();i++){
            if(ListFood.get(i).getTitle().equals(item.getTitle())){
                existAlready=true;
                n=i;
                break;
            }
        }

        if(existAlready){
            ListFood.get(n).setNumberInCart(item.getNumberInCart());
        }
        else{
            ListFood.add(item);
        }
        tinyDB.putListObject("CardList",ListFood);
        Toast.makeText(context, "Added to your cart", Toast.LENGTH_SHORT).show();
    }


    public  ArrayList<FoodDomain>getListCart(){
        //tinyDB.getListObject("CardList");
        return tinyDB.getListObject("CardList");
    }

    public  ArrayList<RiceDomain>getListCart1(){
        //tinyDB.getListObject("CardList");
        return tinyDB.getListObject_rice("CardList");
    }

    public  void minusNumFood(ArrayList<FoodDomain> listfood, int position, ChangeNumber changeNumber ){
if(listfood.get(position).getNumberInCart()==1){
    listfood.remove(position);

}
else{
    listfood.get(position).setNumberInCart(listfood.get(position).getNumberInCart()-1);

}
        tinyDB.putListObject("CardList",listfood);

        changeNumber.changed();
    }

    public  void plusNumFood(ArrayList<FoodDomain> listfood, int position, ChangeNumber changeNumber ){

            listfood.get(position).setNumberInCart(listfood.get(position).getNumberInCart()+1);


        tinyDB.putListObject("CardList",listfood);

        changeNumber.changed();

    }

    public Double getTotalFee(){
        ArrayList<FoodDomain>listfood2=getListCart();
        double fee=0;
        for(int i=0;i<listfood2.size();i++){
            fee+=(listfood2.get(i).getFee())*(listfood2.get(i).getNumberInCart());

        }
        return fee;
    }
}
