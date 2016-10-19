package com.example.jhon_pc.proyectofinalaseguradora.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by JHON-PC on 17/10/2016.
 */

public class Session {

    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    Context context;

    public Session (Context context){
        this.context = context;
        preferences = context.getSharedPreferences("PreferenciaSession", Context.MODE_PRIVATE);
        editor = preferences.edit();
    }

    public void AsignarAutenticacion(boolean logueado){
        editor.putBoolean("Autenticado",logueado);
        editor.commit();
    }

    public boolean Autenticado(){
        return preferences.getBoolean("Autenticado", false);
    }

    public void BorrarPreferencias(){
        context.getSharedPreferences("PreferenciaSession", 0).edit().clear().commit();
    }
}
