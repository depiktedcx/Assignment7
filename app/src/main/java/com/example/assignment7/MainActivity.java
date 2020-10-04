package com.example.assignment7;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionbar_MainScreen = getSupportActionBar();
        actionbar_MainScreen.hide();


    }

    public void buttonClickStart(View D){

       Intent gameMain = new Intent(this,GameScreanMain.class);
        startActivity(gameMain);
    }
}