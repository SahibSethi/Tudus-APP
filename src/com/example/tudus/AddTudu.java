package com.example.tudus;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.tudus.data.TudusOpenHelper;

public class AddTudu extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_tudu);
		Spinner dropdown = (Spinner)findViewById(R.id.spinner);
		String[] items = new String[]{"ASAP", "When Free", "Long Run"};
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, items);
		dropdown.setAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_tudu, menu);
		return true;
	}
	public void onClickDone(View view){
				saveData();
				this.finish();
	}
	
	public void saveData(){
		
		Spinner dropdown = (Spinner)findViewById(R.id.spinner);
		String codeEntered = dropdown.getSelectedItem().toString();
		
		EditText title = (EditText) findViewById(R.id.editText1);
		String titleEntered = title.getText().toString();
		
		
		String dateEntered = DatePickerFragment.getDate();
		
		EditText description = (EditText) findViewById(R.id.editText4);
		String descriptionEntered = description.getText().toString();
	
		
		
		TudusOpenHelper imHelper = new TudusOpenHelper(getApplicationContext());
		SQLiteDatabase db = imHelper.getWritableDatabase();
		
		ContentValues cv = new ContentValues();
		cv.put(TudusOpenHelper.TUDUS_CODE_COLUMN, codeEntered);
		
		
		
		cv.put(TudusOpenHelper.TUDUS_TITLE_COLUMN, titleEntered);
		
		
		cv.put(TudusOpenHelper.TUDUS_DATE_COLUMN, dateEntered);
		
		
		cv.put(TudusOpenHelper.TUDUS_DESCRIPTION_COLUMN, descriptionEntered);
		
		
		
		db.insert(TudusOpenHelper.TUDUS_TABLE_NAME, null, cv);
		
// SAVING DATA THROUGH SHAREDPREFERENCES		

//		Tudus object = new Tudus(titleEntered , codeEntered ,dateEntered );
//		
//		
//		
//		Set<String> currentTudus = MainActivity.sp.getStringSet("tudus", null);
//		Set<String> newTudus = new HashSet<String>();
//		SharedPreferences.Editor editor = MainActivity.sp.edit();
//		 if(currentTudus != null){
//			 newTudus.addAll(currentTudus);
//		 
//		 }
//		 if(!newTudus.contains(titleEntered+"_"+codeEntered+"_"+dateEntered+"_")){
//		 newTudus.add(titleEntered+"_"+codeEntered+"_"+dateEntered+"_");
//		 MainActivity.list.add(object);
//			MainActivity.adapter.notifyDataSetChanged();
//		 }
//		 
//		 editor.putStringSet("tudus", newTudus);
//		 editor.commit();
//		

	}
	
	public void showDatePickerDialog(View v) {
	    DialogFragment newFragment = new DatePickerFragment();
	    newFragment.show(getSupportFragmentManager(), "datePicker");
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
