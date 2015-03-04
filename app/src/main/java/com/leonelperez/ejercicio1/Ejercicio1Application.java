package com.leonelperez.ejercicio1;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseUser;

/**
 * Created by leonel_gpr on 26/02/15.
 */
public class Ejercicio1Application extends Application {

    public void onCreate() {
        super.onCreate();

        // Add your initialization code here
        Parse.initialize(this, "uRUgGd6pxphwYSHCWaVZexW1Smcka3s7lYlAcmJS", "Jqj0cqJyMtie9Z93v0JvPlcx6F2rsp5ejZ6rDWpR");

        ParseUser.enableAutomaticUser();
        ParseACL defaultACL = new ParseACL();

        // If you would like all objects to be private by default, remove this line.
        defaultACL.setPublicReadAccess(true);

        ParseACL.setDefaultACL(defaultACL, true);
    }
}
