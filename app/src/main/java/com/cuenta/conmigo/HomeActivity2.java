package com.cuenta.conmigo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomeActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);
    }


    public void nav(View view){
        Intent miIntent = new Intent(this,MainActivity.class);
        startActivity(miIntent);
    }
}