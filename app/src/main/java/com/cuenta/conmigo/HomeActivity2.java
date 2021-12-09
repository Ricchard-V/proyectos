package com.cuenta.conmigo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.cuenta.conmigo.fragments.Formgastos;
import com.cuenta.conmigo.fragments.Gastos;
import com.cuenta.conmigo.fragments.Main;
import com.cuenta.conmigo.fragments.Personas;
import com.google.android.material.navigation.NavigationView;

public class HomeActivity2 extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

        DrawerLayout drawerLayout;
        ActionBarDrawerToggle actionBarDrawerToggle;
        Toolbar toolbar;
        NavigationView navigationView;

        //variables para cargar los fragmentos

        FragmentManager fragmentManager;
        FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.home);
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,(R.string.close));
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
        actionBarDrawerToggle.syncState();

        //carga de fragmentos

        fragmentManager =  getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.menu_container, new Main());
        fragmentTransaction.commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        drawerLayout.closeDrawer(GravityCompat.START);
        if (item.getItemId() == R.id.inicio){
            fragmentManager =  getSupportFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.menu_container, new Main());
            fragmentTransaction.commit();
        }
        if (item.getItemId() == R.id.ingresos){
            fragmentManager =  getSupportFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.menu_container, new Personas());
            fragmentTransaction.commit();
        }

        if (item.getItemId() == R.id.gastos){
            fragmentManager =  getSupportFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.menu_container, new Gastos());
            fragmentTransaction.commit();
        }
        return false;
    }

    public void newGastos(View view) {
        fragmentManager =  getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.menu_container, new Formgastos());
        fragmentTransaction.commit();
    }
}