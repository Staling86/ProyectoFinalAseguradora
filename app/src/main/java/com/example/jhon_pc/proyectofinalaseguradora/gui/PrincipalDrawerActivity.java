package com.example.jhon_pc.proyectofinalaseguradora.gui;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.jhon_pc.proyectofinalaseguradora.R;
import com.example.jhon_pc.proyectofinalaseguradora.util.Constantes;
import com.example.jhon_pc.proyectofinalaseguradora.util.Session;

public class PrincipalDrawerActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private Session session;
    private Constantes constantes;

    TextView correoAutenticado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal_drawer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        session = new Session(this);
        if(!session.Autenticado()){
            Logout();
        }

    }

    @Override
    public void onBackPressed() {
        /*DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }*/

        AlertDialog.Builder mensajeSalir = new AlertDialog.Builder(this);
        mensajeSalir.setTitle(R.string.alerta);
        mensajeSalir.setMessage(R.string.msj_seguro_salir);
        mensajeSalir.setCancelable(false);
        mensajeSalir.setPositiveButton(R.string.msj_salir, new DialogInterface.OnClickListener(){public void onClick(DialogInterface mensajeSalir, int id){Aceptar();}});
        mensajeSalir.setNegativeButton(R.string.msj_no, new DialogInterface.OnClickListener(){public void onClick(DialogInterface mensajeSalir, int id){Cancelar();}});
        mensajeSalir.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation_drawer, menu);

        constantes = new Constantes();
        correoAutenticado = (TextView) findViewById(R.id.lblCorreo);
        correoAutenticado.setText(constantes.MI_EMAIL);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        /*int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);*/
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void Logout(){
        session.AsignarAutenticacion(false);
        finish();
        startActivity(new Intent(PrincipalDrawerActivity.this, LoginActivity.class));
    }

    public void Aceptar() {
        session.BorrarPreferencias();
        finish();
    }

    public void Cancelar(){}
}
