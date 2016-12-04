package android.coursera.ricardoguzmanonate.formulariocontactos;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * Created by ricgu on 04/12/2016.
 */

public class DatePickerFragment extends DialogFragment
    implements DatePickerDialog.OnDateSetListener{

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Locale locale = getResources().getConfiguration().locale;
        Locale.setDefault(locale);
        final Calendar c = Calendar.getInstance();
        int anio= c.get(Calendar.YEAR);
        int mes= c.get(Calendar.MONTH);
        int dia= c.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog dialog = new DatePickerDialog(getActivity(),this,anio,mes,dia);
        dialog.getDatePicker().setMaxDate(c.getTimeInMillis());
        return dialog;
    }

    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        String  mes;
        if((view.getMonth()+1)<10)
            mes="0"+(view.getMonth()+1);
        else
            mes=""+(view.getMonth()+1);
        String dia;
        if(view.getDayOfMonth()<10)
            dia="0"+view.getDayOfMonth();
        else
            dia=""+view.getDayOfMonth();
        EditText etFechaNacimiento = (EditText) getActivity().findViewById(R.id.etFechaNacimiento);
        etFechaNacimiento.setText(dia+"/"
                +mes+"/"+view.getYear());
    }
}
