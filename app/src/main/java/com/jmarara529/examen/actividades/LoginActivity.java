package com.jmarara529.examen.actividades;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.jmarara529.examen.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText usuario = findViewById(R.id.EditTextUsuario);
        EditText contrasenya = findViewById(R.id.EditTextPassword);



        Button registrar = findViewById(R.id.botonRegistrar);
        Button acceder = findViewById(R.id.botonAcceder);

        registrar.setOnClickListener(v -> {

            String textoUsuario = String.valueOf(usuario.getText());
            String textoContrasenya = String.valueOf(usuario.getText());

            Log.i("plusacion","Se ha pulsado el boton registrar");

            if (textoUsuario.isEmpty() || textoContrasenya.isEmpty()){
                alerError();
            }else{

                Intent intentRegistrarActivity = new Intent(this, RegistrarActivity.class);
                startActivity(intentRegistrarActivity);

            }
        });

        acceder.setOnClickListener(v -> {

            String textoUsuario = String.valueOf(usuario.getText());
            String textoContrasenya = String.valueOf(usuario.getText());

            Log.i("pulsacion","Se ha pulsado el boton acceder");
            if (textoUsuario.isEmpty() || textoContrasenya.isEmpty()){
                alerError();
            }else{
                Toast.makeText(this, "Todo correcto, falta implementar metodo de autenticación", Toast.LENGTH_SHORT).show();
                Intent intentHomeActivity = new Intent(this, HomeActivity.class);
                startActivity(intentHomeActivity);
            }
        });

    }

    private void alerError() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Los campos suario y contraseña no pueden estar en blanco")
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

        builder.create();
        builder.show();

    }
}