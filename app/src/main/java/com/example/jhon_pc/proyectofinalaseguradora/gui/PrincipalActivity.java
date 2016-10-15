package com.example.jhon_pc.proyectofinalaseguradora.gui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.jhon_pc.proyectofinalaseguradora.R;

public class PrincipalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder mensajeSalir = new AlertDialog.Builder(this);
        mensajeSalir.setTitle(R.string.alerta);
        mensajeSalir.setMessage(R.string.msj_seguro_salir);
        mensajeSalir.setCancelable(false);
        mensajeSalir.setPositiveButton(R.string.msj_salir, new DialogInterface.OnClickListener(){public void onClick(DialogInterface mensajeSalir, int id){Aceptar();}});
        mensajeSalir.setNegativeButton(R.string.msj_no, new DialogInterface.OnClickListener(){public void onClick(DialogInterface mensajeSalir, int id){Cancelar();}});
        mensajeSalir.show();

    }
    public void Aceptar() {
        finish();
    }
    public void Cancelar(){}


}
