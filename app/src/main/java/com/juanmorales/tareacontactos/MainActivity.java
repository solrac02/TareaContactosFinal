package com.juanmorales.tareacontactos;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.view.Menu;
import android.view.MenuItem;



import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    public static TextInputEditText tiet_nombre;
    public static TextInputEditText tiet_fechaSeleccionada;
    public static TextInputEditText tiet_telefono;
    public static TextInputEditText tiet_email;
    public static TextInputEditText tiet_descripcion;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tiet_nombre = (TextInputEditText)findViewById(R.id.txtNombre);
        tiet_fechaSeleccionada = (TextInputEditText) findViewById(R.id.txtFecha);
        tiet_telefono = (TextInputEditText)findViewById(R.id.txtTelefono);
        tiet_email = (TextInputEditText)findViewById(R.id.txtEmail);
        tiet_descripcion= (TextInputEditText)findViewById(R.id.txtDescripcion);
        final Button botonSiguiente = (Button)findViewById(R.id.btnSiguiente);



        botonSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ConfirmarDatos.class);

                intent.putExtra(getResources().getString(R.string.pnombre), tiet_nombre.getText().toString());
                intent.putExtra(getResources().getString(R.string.pfecha), tiet_fechaSeleccionada.getText().toString());
                intent.putExtra(getResources().getString(R.string.ptelefono), tiet_telefono.getText().toString());
                intent.putExtra(getResources().getString(R.string.pemail), tiet_email.getText().toString());
                intent.putExtra(getResources().getString(R.string.pdescripcion), tiet_descripcion.getText().toString());

                startActivity(intent);
                finish(); //finalizando la actividad


            }
        });

        Bundle datos = getIntent().getExtras();
        if (datos !=null) {
            String nombreC = datos.getString(getResources().getString(R.string.pnombre));
            String fechaC = datos.getString(getResources().getString(R.string.pfecha));
            String telefonoC = datos.getString(getResources().getString(R.string.ptelefono));
            String emailC = datos.getString(getResources().getString(R.string.pemail));
            String descripcionC = datos.getString(getResources().getString(R.string.pdescripcion));

            tiet_nombre.setText(nombreC);
            tiet_fechaSeleccionada.setText(fechaC);
            tiet_telefono.setText(telefonoC);
            tiet_email.setText(emailC);
            tiet_descripcion.setText(descripcionC);
        }

    }


    public static class DatePickerFragment extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {


        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }


        public void onDateSet(DatePicker view, int year, int month, int day) {
            // Do something with the date chosen by the user
            tiet_fechaSeleccionada.setText((month + 1) + "/" + day + "/" + year);

        }

    }

    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }



}
