package com.luisaamariles.chefburgerapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    String Nombre, Contrasena, Mail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().show();
        Bundle extras = getIntent().getExtras();
        Nombre = extras.getString("Name");
        Contrasena = extras.getString("Pass");
        Mail=extras.getString("Email");
       // Toast.makeText(this, "user: "+Nombre+" contrasena: "+Contrasena+"email"+Mail, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.miperfil:
                Intent intent = new Intent(this, MiperfilActivity.class);
                intent.putExtra("Name",Nombre.toString());
                intent.putExtra("Pass",Contrasena.toString());
                intent.putExtra("Email",Mail.toString());
                startActivity(intent);
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}

