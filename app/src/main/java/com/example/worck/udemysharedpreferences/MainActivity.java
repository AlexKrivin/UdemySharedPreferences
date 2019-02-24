package com.example.worck.udemysharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPreferences = this.getSharedPreferences(" com.example.worck.udemysharedpreferences", Context.MODE_PRIVATE);

        ArrayList<String> fiends = new ArrayList();
        fiends.add("Joey");
        fiends.add("Monica");
        fiends.add("Chandler");
        fiends.add("Rachel");

        try {

            sharedPreferences.edit().putString("fiends",ObjectSerializer.serialize(fiends)).apply();

        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<String> newFriends = new ArrayList<>();
        try {
            newFriends = (ArrayList<String>)ObjectSerializer.deserialize(sharedPreferences.getString("friends",ObjectSerializer.serialize(new ArrayList<String>())));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
