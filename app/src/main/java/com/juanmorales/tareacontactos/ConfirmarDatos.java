package com.juanmorales.tareacontactos;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConfirmarDatos extends AppCompatActivity {

    public static TextView tvNombre;
    public static TextView tvFecha;
    public static TextView tvTelefono;
    public static TextView tvEmail;
    public static TextView tvDescripcion;

    public String nombre;
    public String fecha;
    public String telefono;
    public String email;
    public String descripcion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_datos);

        final Button botonEditar = (Button)findViewById(R.id.btnEditar);

        Bundle datos = getIntent().getExtras();
        nombre = datos.getString(getResources().getString(R.string.pnombre));
        fecha  = datos.getString(getResources().getString(R.string.pfecha));
        telefono  = datos.getString(getResources().getString(R.string.ptelefono));
        email  = datos.getString(getResources().getString(R.string.pemail));
        descripcion  = datos.getString(getResources().getString(R.string.pdescripcion));

        tvNombre = (TextView) findViewById(R.id.txtNombreDato);
        tvFecha = (TextView) findViewById(R.id.txtFechaDato);
        tvTelefono = (TextView) findViewById(R.id.txtTelefonoDato);
        tvEmail = (TextView) findViewById(R.id.txtEmailDato);
        tvDescripcion = (TextView) findViewById(R.id.txtDescripcionDato);

        tvNombre.setText(nombre);
        tvFecha.setText(fecha);
        tvTelefono.setText(telefono);
        tvEmail.setText(email);
        tvDescripcion.setText(descripcion);

        assert botonEditar != null;
        botonEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ConfirmarDatos.this, MainActivity.class);

                intent.putExtra(getResources().getString(R.string.pnombre), nombre.toString());
                intent.putExtra(getResources().getString(R.string.pfecha), fecha.toString());
                intent.putExtra(getResources().getString(R.string.ptelefono), telefono.toString());
                intent.putExtra(getResources().getString(R.string.pemail), email.toString());
                intent.putExtra(getResources().getString(R.string.pdescripcion), descripcion.toString());

                startActivity(intent);
                finish(); //finalizando la actividad



            }
        });

    }

    public boolean onKeyDown(int keyCode, KeyEvent event){
        if (keyCode == KeyEvent.KEYCODE_BACK){
            Intent intent = new Intent(ConfirmarDatos.this, MainActivity.class);
            startActivity(intent);
        }
        return super.onKeyDown(keyCode, event);
    }
}
