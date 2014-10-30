package com.example.tudus;

import java.util.Calendar;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.Button;
import android.widget.DatePicker;

public class DatePickerFragment extends DialogFragment
implements DatePickerDialog.OnDateSetListener {
public static int dayChosen;
public static int monthChosen;
public static int yearChosen;
@Override
public Dialog onCreateDialog(Bundle savedInstanceState) {
// Use the current date as the default date in the picker
Calendar c = Calendar.getInstance();
int year = c.get(Calendar.YEAR);
int month = c.get(Calendar.MONTH);
int day = c.get(Calendar.DAY_OF_MONTH);

// Create a new instance of DatePickerDialog and return it
return new DatePickerDialog(getActivity(), this, year, month, day);
}

public static String getDate(){
	String str;
	
	str = dayChosen+"/"+monthChosen+"/"+yearChosen;
	
	
	return str;
}
public  void onDateSet(DatePicker view, int year, int month, int day) {
// Do something with the date chosen by the user
	dayChosen = day;
	monthChosen = month +1;
	yearChosen = year;
	//Button but = (Button)findViewById(R.id.button2);
	
}


}
