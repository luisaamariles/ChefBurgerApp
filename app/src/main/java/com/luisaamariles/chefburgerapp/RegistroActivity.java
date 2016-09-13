package com.luisaamariles.chefburgerapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Luisa Maria Amariles on 05/09/2016.
 */
public class RegistroActivity  extends AppCompatActivity {
    EditText eName,ePass,eRPass,Email;
    TextView datos;
    String Pass,RPass;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.registro);
        eName = (EditText) findViewById(R.id.eName);
        ePass = (EditText) findViewById(R.id.ePass);
        eRPass = (EditText) findViewById(R.id.eRPass);
        Email = (EditText) findViewById(R.id.eEmail);
        datos = (TextView) findViewById(R.id.datos);
        Button Aceptar = (Button) findViewById(R.id.bAceptar);
        Button Cancelar = (Button) findViewById(R.id.bCancelar);
        Aceptar.setOnClickListener(onClickListener);
        Cancelar.setOnClickListener(onClickListener);
        getSupportActionBar().hide();
        //Bundle extras = getIntent().getExtras();

    }
    private OnClickListener onClickListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.bAceptar:
                    //DO something
                    String vacio1= eName.getText().toString();
                    String vacio2= ePass.getText().toString();
                    String vacio3= eRPass.getText().toString();
                    String vacio4= Email.getText().toString();

                    if (vacio1.equals("") || vacio2.equals("") || vacio3.equals("") || vacio4.equals("")) {
                        datos.setText("Campos vacios");
                    }else{
                        Pass= ePass.getText().toString();
                        RPass= eRPass.getText().toString();

                        if(Pass.toString().equals(RPass)) {
                            Intent intent = new Intent();
                            intent.putExtra("Name", eName.getText().toString());
                            intent.putExtra("Pass", ePass.getText().toString());
                            intent.putExtra("Email", Email.getText().toString());
                            //intent.putExtra("Email",Email.getText().toString());
                            setResult(RESULT_OK, intent);
                            finish();
                        }else{
                            datos.setText("Las contraseñas no coinciden!");
                            ePass.setText("");
                            eRPass.setText("");
                        }
                    }
                    break;
                case R.id.bCancelar:
                    //DO something

                    Intent intent = new Intent();
                    setResult(RESULT_CANCELED,intent);
                    finish();
                    break;
            }

        }
    };
}
