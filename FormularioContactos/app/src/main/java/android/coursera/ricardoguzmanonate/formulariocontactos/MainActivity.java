package android.coursera.ricardoguzmanonate.formulariocontactos;

import android.app.DatePickerDialog;
import android.app.DialogFragment;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.text.SimpleDateFormat;

public class MainActivity extends AppCompatActivity {

    private DatePickerDialog fechaNacimientoDatePickerDialog;
    private EditText etFechaNacimiento;
    private EditText etNombreCompleto;
    private EditText etTelefono;
    private EditText etEmail;
    private EditText etDescripcionContacto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etFechaNacimiento = (EditText) findViewById(R.id.etFechaNacimiento);
        etNombreCompleto = (EditText) findViewById(R.id.etNombreCompleto);
        etTelefono = (EditText) findViewById(R.id.etTelefono);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etDescripcionContacto = (EditText) findViewById(R.id.etDescripcionContacto);

        Bundle parametros = getIntent().getExtras();
        if(parametros!=null) {
            etNombreCompleto.setText(parametros.getString(getResources().getString(R.string.pnombreCompleto)));
            etFechaNacimiento.setText(parametros.getString(getResources().getString(R.string.pfechaNacimiento)));
            etTelefono.setText(parametros.getString(getResources().getString(R.string.ptelefono)));
            etEmail.setText(parametros.getString(getResources().getString(R.string.pemail)));
            etDescripcionContacto.setText(parametros.getString(getResources().getString(R.string.pdescripcionContacto)));
        }
    }

    public void pickFechaNacimiento(View view){
        DialogFragment datePicker = new DatePickerFragment();
        datePicker.show(getFragmentManager(),"datePicker");
    }

    public void siguienteDatos(View view){
        Intent intent = new Intent(MainActivity.this,ConfirmarDatos.class);
        intent.putExtra(getResources().getString(R.string.pnombreCompleto),
                etNombreCompleto.getText().toString());
        intent.putExtra(getResources().getString(R.string.pfechaNacimiento),
                etFechaNacimiento.getText().toString());
        intent.putExtra(getResources().getString(R.string.ptelefono),
                etTelefono.getText().toString());
        intent.putExtra(getResources().getString(R.string.pemail),
                etEmail.getText().toString());
        intent.putExtra(getResources().getString(R.string.pdescripcionContacto),
                etDescripcionContacto.getText().toString());
        startActivity(intent);
        finish();
    }
}
