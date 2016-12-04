package android.coursera.ricardoguzmanonate.formulariocontactos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ConfirmarDatos extends AppCompatActivity {

    private TextView tvNombre;
    private TextView tvFechaNacimiento;
    private TextView tvTelefono;
    private TextView tvEmail;
    private TextView tvDescripcion;

    String vNombre;
    String vFechaNacimiento;
    String vTelefono;
    String vEmail;
    String vDescripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_datos);

        tvFechaNacimiento = (TextView) findViewById(R.id.tvFechaNacimiento);
        tvNombre = (TextView) findViewById(R.id.tvNombre);
        tvTelefono = (TextView) findViewById(R.id.tvTelefono);
        tvEmail = (TextView) findViewById(R.id.tvEmail);
        tvDescripcion = (TextView) findViewById(R.id.tvDescripcion);

        Bundle parametros = getIntent().getExtras();
        vNombre=parametros.getString(getResources().getString(R.string.pnombreCompleto));
        tvNombre.setText(getResources().getString(R.string.nombreCompleto)+":"
                +vNombre);

        vFechaNacimiento=parametros.getString(getResources().getString(R.string.pfechaNacimiento));
        tvFechaNacimiento.setText(getResources().getString(R.string.fechaNacimiento)+":"
                +vFechaNacimiento);

        vTelefono=parametros.getString(getResources().getString(R.string.ptelefono));
        tvTelefono.setText(getResources().getString(R.string.telefono)+":"
                +vTelefono);

        vEmail=parametros.getString(getResources().getString(R.string.pemail));
        tvEmail.setText(getResources().getString(R.string.email)+":"
                +vEmail);

        vDescripcion=parametros.getString(getResources().getString(R.string.pdescripcionContacto));
        tvDescripcion.setText(getResources().getString(R.string.descripcionContacto)+":"
                +vDescripcion);
    }

    public void editarDatos(View view){
        Intent intent = new Intent(ConfirmarDatos.this,MainActivity.class);
        intent.putExtra(getResources().getString(R.string.pnombreCompleto),
                vNombre);
        intent.putExtra(getResources().getString(R.string.pfechaNacimiento),
                vFechaNacimiento);
        intent.putExtra(getResources().getString(R.string.ptelefono),
                vTelefono);
        intent.putExtra(getResources().getString(R.string.pemail),
                vEmail);
        intent.putExtra(getResources().getString(R.string.pdescripcionContacto),
                vDescripcion);
        startActivity(intent);
    }
}
