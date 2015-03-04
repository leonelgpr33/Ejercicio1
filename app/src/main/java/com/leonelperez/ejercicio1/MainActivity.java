package com.leonelperez.ejercicio1;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;


import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    ListView verlista;
    List<ParseObject> ob;
    ProgressDialog mProgressDialog;
    ListViewAdapter adapter;
    private List<bar> ListaBar = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the view from listview_main.xml
        setContentView(R.layout.activity_main);
        // Execute RemoteDataTask AsyncTask
        new RemoteDataTask().execute();
    }

    // RemoteDataTask AsyncTask
    private class RemoteDataTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Create a progressdialog
            mProgressDialog = new ProgressDialog(MainActivity.this);
            // Set progressdialog title
            mProgressDialog.setTitle("Copeo List");
            // Set progressdialog message
            mProgressDialog.setMessage("Loading...");
            mProgressDialog.setIndeterminate(false);
            // Show progressdialog
            mProgressDialog.show();
        }

        @Override
        protected Void doInBackground(Void... params) {
// Create the array
            ListaBar = new ArrayList<bar>();
            try {
// Locate the class table named "Country" in Parse.com
                ParseQuery<ParseObject> query = new ParseQuery<ParseObject>(
                "bar");
// Locate the column named "ranknum" in Parse.com and order list
// by ascending
                query.orderByAscending("createdAt");
                ob = query.find();
                for (ParseObject lugar : ob) {
                    bar sede = new bar();
                    ParseFile picBar=lugar.getParseFile("logo");
                    sede.setName((String) lugar.get("Name"));
                    sede.setDescription((String) lugar.get("Description"));
                    sede.setLatitude((String) lugar.get("Latitud"));
                    sede.setLongitude((String) lugar.get("Longitud"));

                    sede.setImage(picBar.getData());

                    ListaBar.add(sede);
                }
            } catch (ParseException e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
// Locate the listview in listview_main.xml
            verlista = (ListView) findViewById(R.id.tblLista);
// Pass the results into ListViewAdapter.java
            adapter = new ListViewAdapter(MainActivity.this,
                    ListaBar);
// Binds the Adapter to the ListView
            verlista.setAdapter(adapter);
// Close the progressdialog
            mProgressDialog.dismiss();
        }
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