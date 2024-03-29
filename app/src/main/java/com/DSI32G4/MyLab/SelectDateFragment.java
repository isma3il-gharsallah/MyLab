package com.DSI32G4.MyLab;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.widget.DatePicker;

import androidx.fragment.app.DialogFragment;

import com.DSI32G4.MyLab.ui.share.UpdateProfile;

import java.util.Calendar;


public class SelectDateFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {
   static String s="";

    public static String getS() {
        return s;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Calendar calendar = Calendar.getInstance();
        int yy = calendar.get(Calendar.YEAR);
        int mm = calendar.get(Calendar.MONTH);
        int dd = calendar.get(Calendar.DAY_OF_MONTH);
        return new DatePickerDialog(getActivity(), this, yy, mm, dd);
    }


    public void onDateSet(DatePicker view, int yy, int mm, int dd) {
        populateSetDate(yy, mm+1, dd);
    }
    public void populateSetDate(int year, int month, int day) {
       UpdateProfile.getDd().setText(day+"/"+month+"/"+year) ;
    }

}