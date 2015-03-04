package com.leonelperez.ejercicio1;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.ByteArrayInputStream;

/**
 * Created by leonel_gpr on 26/02/15.
 */
public class SingleItemView extends Activity{
    // Declare Variables
    TextView txtName;
    TextView txtDescription;
    TextView txtLatitude;
    TextView txtLongitude;
    ImageView picBar;

    String name;
    String description;
    String latitude;
    String longitude;
    byte[] imageBar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.singleitemview);
// Retrieve data from MainActivity on item click event
        Intent i = getIntent();
// Get the results of rank
        name = i.getStringExtra("name");
// Get the results of country
        description = i.getStringExtra("description");
// Get the results of population
        latitude = i.getStringExtra("latitude");
        longitude = i.getStringExtra("longitude");
        imageBar = i.getByteArrayExtra("image");

// Locate the TextViews in singleitemview.xml
        txtName = (TextView) findViewById(R.id.name);
        txtDescription = (TextView) findViewById(R.id.description);
        txtLatitude = (TextView) findViewById(R.id.latitude);
        txtLongitude = (TextView) findViewById(R.id.longitude);
        picBar = (ImageView) findViewById(R.id.imgBar);


// Load the results into the TextViews
        txtName.setText(name);
        txtDescription.setText(description);
        txtLatitude.setText(latitude);
        txtLongitude.setText(longitude);
        picBar.setImageDrawable(Drawable.createFromStream(new ByteArrayInputStream(imageBar), name));

    }
}
