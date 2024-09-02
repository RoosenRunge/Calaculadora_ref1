package com.example.calaculadora_ref1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.calaculadora_ref1.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    //  private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    //1 criando as variáveis botão para navegar entre as telas
    private Button calcBtc;
    private Button webBtc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);
        //2 - associando as variáveis as elementos correspondentes do layout
        calcBtc = findViewById(R.id.calcXML);
        webBtc = findViewById(R.id.webXML);

        //3- criando listener+ handler (classe anônima) para o ocionamento do botão da da calculadora
        calcBtc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //criação da intent para chamar a calculadora
                Intent calcIntent = new Intent(MainActivity.this,  Calculadora.class);
                //Intent calcIntent = new Intent("calc");
                //chamando a calculadora
                startActivity(calcIntent);
            }
        });
        //4- criandolistener+ handler (classe anônima) para o acionamento do botão do  browser
        webBtc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //criação da intent para chamar a calculadora
                Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ft.unicamp.br/"));
                //criação da intent para chamar a calculadora
                startActivity(webIntent);
            }
        });




        /*NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAnchorView(R.id.fab)
                        .setAction("Action", null).show();
            }
        });*/
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

    /*@Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }*/
}