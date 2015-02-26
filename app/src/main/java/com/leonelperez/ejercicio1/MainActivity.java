package com.leonelperez.ejercicio1;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.List;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Parse.enableLocalDatastore(this);
        Parse.initialize(this, "xBCjEXeDGNhbhgDMOoDcd8cWvzWAH2mfS23oBrhX", "tsLtyHtyjPHW3mJvvSrKyw9ibevskxlhc3945Bms");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Enable Local Datastore.


        //Prueba parse connect
        /*ParseObject testObject = new ParseObject("TestObject");
        testObject.put("foo", "Leonel");
        testObject.saveInBackground();*/
        ParseQuery<ParseObject> query = ParseQuery.getQuery("bar");
        query.findInBackground(new FindCallback<ParseObject>() {

                @Override
                public void done(List<ParseObject> parseObjects, com.parse.ParseException e) {
                    if (e == null) {

                        for(ParseObject obj:parseObjects){

                            Log.i("DEBUG " , "BAR : " + obj.get("name") + " DESCRIPCION : " + obj.get("description") + " LAT/LONG : " + obj.get("latitude") + obj.get("longitude"));

                        }

                    } else {
                        Log.d("DEBUG", "Error: " + e.getMessage());
                    }
                }
            });



}


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
