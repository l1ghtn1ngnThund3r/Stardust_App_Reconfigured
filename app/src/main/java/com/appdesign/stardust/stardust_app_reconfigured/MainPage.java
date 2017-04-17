package com.appdesign.stardust.stardust_app_reconfigured;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
/**
 * Created by avz95 on 4/5/17.
 */

public class MainPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setTitle("Dust");
        setContentView(R.layout.home_page);


        Button coffeeMenu = (Button) findViewById(R.id.coffee_menu);
        if (coffeeMenu != null) {
            coffeeMenu.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(MainPage.this, MainActivity.class));
            }
        });}
        Button foodMenu = (Button) findViewById(R.id.food_menu);
        if (foodMenu != null){
        foodMenu.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                //Change MainActivity.class to the Food Menu when ready=
                startActivity(new Intent(MainPage.this, FoodMenu.class));
            }
        });}



    }



}
