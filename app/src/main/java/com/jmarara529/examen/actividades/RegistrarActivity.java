package com.jmarara529.examen.actividades;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.jmarara529.examen.R;

public class RegistrarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registrar);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText nombre = findViewById(R.id.EditTextNombre);
        EditText apellidos = findViewById(R.id.EditTextApellidos);

        Spinner spinner = findViewById(R.id.spinner);

        // Obtener el array de cadenas desde los recursos
        String[] items = getResources().getStringArray(R.array.item);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        Button aceptar = findViewById(R.id.botonAceptar);
        Button cancelar = findViewById(R.id.botonCancelar);

        aceptar.setOnClickListener(v -> {
            String textoNombre = String.valueOf(nombre.getText());
            String textoApellidos = String.valueOf(apellidos.getText());

            if (textoNombre.isEmpty() || textoApellidos.isEmpty()){
                alerError();
            }else{
                Toast.makeText(this, "Todo correcto, falta implementar registro en sqlite", Toast.LENGTH_SHORT).show();
                Intent intentHomeActivity = new Intent(this, HomeActivity.class);
                startActivity(intentHomeActivity);
            }

        });

        cancelar.setOnClickListener(v -> {
            Intent intentLoginActivity = new Intent(this, LoginActivity.class);
            startActivity(intentLoginActivity);

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