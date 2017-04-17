package com.appdesign.stardust.stardust_app_reconfigured;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;

import java.util.*;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.content.Context;
import android.widget.*;

//MAIN ACTIVITY == **** DRINK MENU ****
public class MainActivity extends AppCompatActivity {

    //Array of Menu Items and their descriptions
    //Change to ArrayList<String> [NYI]
    String[] menuItem = {"Coffee", "Americano", "Espresso", "Tangerine"};
    String[] itemDescription = {"Black and Delicious, cream is optional", "Hot Water and a lot of Caffeine", "A lot of caffeine"
    ,"A light, crisp Floridian Beer"};

    //Array to Handle the List View
    ArrayList<MenuObject> objectMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Drink Menu");
        setContentView(R.layout.drink_menu);
        objectMenu = new ArrayList<>();
        MenuAdapter menuAdapter = new MenuAdapter(this, objectMenu);
        ListView listView = (ListView) findViewById(R.id.listView);
        if (listView != null)
            listView.setAdapter(menuAdapter);
        for (int i = 0; i < menuItem.length; i++)
        {
            menuAdapter.add(new MenuObject(menuItem[i],itemDescription[i]));
        }

    }

//Object to encapsulate menuItem and description data
    private class MenuObject {

        private String menuItemText;
        private String descriptionText;

        private MenuObject(String menuItem, String description) {
            this.menuItemText = menuItem;
            this.descriptionText = description;

        }
    }
    //Custom ArrayAdapter to handle MenuObject objects
    private class MenuAdapter extends ArrayAdapter<MenuObject>{

        private MenuAdapter(Context context, ArrayList<MenuObject> menuItems){

            super(context,0,menuItems);
        }
        @Override

        public View getView(int position, View convertView, ViewGroup parent) {

            // Get the data item for this position
            MenuObject menuObject = getItem(position);

            // Check if an existing view is being reused, otherwise inflate the view
            if (convertView == null) {

                convertView = LayoutInflater.from(getContext()).inflate(R.layout.menu_layout, parent, false);

            }

            // Lookup view for data population
            TextView menuItem = (TextView) convertView.findViewById(R.id.itemTitle);
            TextView description = (TextView) convertView.findViewById(R.id.description);
            ImageView imageView = (ImageView) convertView.findViewById(R.id.image_layout_menu);

            // Populate the data into the template view using the data object
            if(menuObject != null) {
                menuItem.setText(menuObject.menuItemText);
                description.setText(menuObject.descriptionText);
                if (menuObject.menuItemText.equals("Tangerine"))
                {
                    imageView.setImageResource(R.drawable.tang_beer);
                }
            }

            // Return the completed view to render on screen

            return convertView;

        }
    }








}
