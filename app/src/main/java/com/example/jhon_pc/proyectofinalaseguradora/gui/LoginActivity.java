package com.example.jhon_pc.proyectofinalaseguradora.gui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jhon_pc.proyectofinalaseguradora.R;
import com.example.jhon_pc.proyectofinalaseguradora.util.ValidateCharacters;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    //region SOLO PARA PRUEBAS
    private final String MI_EMAIL = "jhonstaling58@hotmail.com";
    private final String MI_CONTRASENA = "12345678";

    //endregion

    EditText txtEmail, txtContrasena;
    Button btnAutenticar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtEmail = (EditText) findViewById(R.id.txtEmail);
        txtContrasena = (EditText) findViewById(R.id.txtContasena);
        btnAutenticar = (Button) findViewById(R.id.btnAutenticar);
        btnAutenticar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        boolean validarCantidadCaracteres, validarEmail;
        ValidateCharacters vc = new ValidateCharacters();
        validarEmail = vc.ValidarEmail(txtEmail.getText().toString());
        validarCantidadCaracteres = vc.ValidarContrasena(txtContrasena.getText().toString());

        //region VALIDACIONES CANTIDAD DE CARACTERES CONTRASEÑA Y FORMATO CORRECTO EN EMAIL
        if(validarEmail == true && validarCantidadCaracteres == true){
            String contrasena = txtContrasena.getText().toString();
            String email = txtEmail.getText().toString();
            if(email.equals(MI_EMAIL) && contrasena.equals(MI_CONTRASENA))
            {
                Intent intent = new Intent(LoginActivity.this, PrincipalActivity.class);
                startActivity(intent);
                UsuarioCorrecto();
            }
            else
                UsuarioIncorrecto();
        }
        else {
            if(validarCantidadCaracteres == false){
                ValidarFocoContrasena();
                if(validarEmail == false){
                    ValidarFocoEmail();
                }
            }
            if(validarEmail == false){
                ValidarFocoEmail();
                if(validarCantidadCaracteres == false) {
                    ValidarFocoContrasena();
                }
            }
        }
        //endregion
    }

    //regionVALIDAR MENSAJE AUTENTICACIÓN
    public void UsuarioCorrecto(){
        Toast bienvenido = Toast.makeText(this,getString(R.string.usuario_autenticado), Toast.LENGTH_SHORT);
        bienvenido.show();
    }

    public void UsuarioIncorrecto(){
        Toast incorrecto = Toast.makeText(this, R.string.usuario_incorrecto, Toast.LENGTH_SHORT);
        incorrecto.show();
    }
    //endregion
    //regionVALIDAR FOCO CAMPOS DE TEXTO
    public void ValidarFocoEmail(){
        if(txtEmail.isFocusable() == false)
            txtEmail.setError(" ");
        else
            txtEmail.setError(getString(R.string.email_incorrecto));
    }

    public void ValidarFocoContrasena(){
        if(txtContrasena.isFocusable() == false){
            txtContrasena.setError(" ");
        }else{
            txtContrasena.setError(getString(R.string.siete_caracteres));
        }
    }
    //endregion

}
