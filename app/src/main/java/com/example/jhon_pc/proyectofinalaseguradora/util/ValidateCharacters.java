package com.example.jhon_pc.proyectofinalaseguradora.util;

import android.text.TextUtils;

/**
 * Created by JHON-PC on 14/10/2016.
 */

public class ValidateCharacters {

    private final int CANTIDAD_CONTASENA = 8;

    //VALIDAMOS QUE LA CONTRASEÑA CONTENGA MAS DE 8 CARACTERES PARA PODER INGRESAR
    public Boolean ValidarContrasena(String contrasena){
        if(contrasena.toString().length() < CANTIDAD_CONTASENA)
            return false;
        else
            return true;
    }

    public Boolean ValidarEmail(CharSequence email) {
        if (TextUtils.isEmpty(email)) {
            return false;
        }
        else {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
        }
    }
}
