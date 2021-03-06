package com.example.climb;

import android.app.Application;

import com.example.climb.models.Beta;
import com.example.climb.models.Location;
import com.example.climb.models.Route;
import com.example.climb.models.User;
import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application
{
    @Override
    public void onCreate()
    {
        super.onCreate();

        ParseObject.registerSubclass(Location.class);
        ParseObject.registerSubclass(Route.class);
        ParseObject.registerSubclass(User.class);
        ParseObject.registerSubclass(Beta.class);

        // Must register data objects with Parse before calling initialize
        //ParseObject.registerSubclass(Post.class);

        // configure settings based on heroku's settings
        // clientKey is not needed unless explicitly configured
        // any network interceptors must be added with the configuration builder given this syntax
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("climb-parse")      // APP_ID
                .clientKey("mountain-goat")
                .server("https://climb-parse.herokuapp.com/parse/").build());  // ensure the url uses https so the web traffic is encrypted
    }
}
