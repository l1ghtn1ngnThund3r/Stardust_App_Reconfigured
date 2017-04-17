package com.appdesign.stardust.stardust_app_reconfigured;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.*;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.*;

import java.util.ArrayList;

/**
 * Food Menu for Stardust App
 * Created by avz95 on 4/9/17.
 */

public class FoodMenu extends AppCompatActivity {

    //List of Menu Items and their descriptions
    String[] menuItem = {"Waffles", "Quesadilla", "Cuban Sandwich", "Lulu Salad"};
    String[] itemDescription = {"Golden and crispy", "Cheesy with a side of chips", "Pickles!!"
            , "A lot of super foods"};
    //Array to Handle the List View
    ArrayList<FoodMenu.MenuObject> foodMenu;


    @Override
    protected void onCreate(Bundle foodInstanceState) {

        super.onCreate(foodInstanceState);
        //These lines set the Title in the android bar and change
        // the symbol to the sandwich drawable
        setTitle("Food Menu");
        if (getActionBar() != null) getActionBar().setIcon(R.drawable.sandwich);
        setContentView(R.layout.food_menu);

        //Create and populate the foodMenu with MenuObject objects containing appropriate
        //menu information
        foodMenu = new ArrayList<>();
        FoodMenuAdapter foodAdapter = new FoodMenuAdapter(this, foodMenu);
        ListView listView = (ListView) findViewById(R.id.listViewFood);
        if (listView != null) listView.setAdapter(foodAdapter);
        for (int i = 0; i < menuItem.length; i++){
            foodAdapter.add(new FoodMenu.MenuObject(menuItem[i], itemDescription[i]));
        }

    }

    //Object to encapsulate menuItem and description data for ListView
    private class MenuObject {

        private String menuItemText;
        private String descriptionText;

        private MenuObject(String menuItem, String description) {
            this.menuItemText = menuItem;
            this.descriptionText = description;
        }
    }

    //Custom ArrayAdapter to handle FoodMenu.MenuObject
    private class FoodMenuAdapter extends ArrayAdapter<FoodMenu.MenuObject> {

        private FoodMenuAdapter(Context context, ArrayList<FoodMenu.MenuObject> menuItems) {

            super(context, 0, menuItems);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            // Get the data item for this position
            MenuObject foodObject = getItem(position);

            // Check if an existing view is being reused, otherwise inflate the view -- remember to inflate the
            //xml that contains the layout not the one referenced by the page layout doc
            //Example -> menu_layout is the layout for listView
            // The Food Menu's listMenuFood is a reference to the layout not the actual layout
            //to be inflated
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.menu_layout, parent, false);
            }

            // Lookup view for data population
            TextView menuItem = (TextView) convertView.findViewById(R.id.itemTitle);
            TextView description = (TextView) convertView.findViewById(R.id.description);
            ImageView image = (ImageView) convertView.findViewById(R.id.image_layout_menu);

            //Fix to display Food Items instead of Drinks
            if (foodObject != null) {
                menuItem.setText(foodObject.menuItemText);
                description.setText(foodObject.descriptionText);
                image.setImageResource(R.drawable.sandwich);
            }

            // Return the constructed view to display on screen
            return convertView;

        }
    }




}
