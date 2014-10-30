package com.example.tudus;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.tudus.data.TudusOpenHelper;



public class MainActivity extends ActionBarActivity {
		
	public static CustomArrayAdapter adapter;
	public static ArrayList<Tudus> list;
	ListView lv;
	public static SharedPreferences sp;
	public static Set<String> currentTudus; 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		updateData();
		
			}
		@Override
		public void onWindowFocusChanged(boolean hasFocus) {
			// TODO Auto-generated method stub
			super.onWindowFocusChanged(hasFocus);
			updateData();
		}
	public void updateData(){
		TudusOpenHelper imHelper = new TudusOpenHelper(this);
		SQLiteDatabase db = imHelper.getReadableDatabase();
		list = new ArrayList<Tudus>();
			
		
				String selection,groupBy,having,orderBy;
				//String[] selectionArgs;
				String[] columns = {
						TudusOpenHelper.TUDUS_CODE_COLUMN,
						TudusOpenHelper.TUDUS_ID,
						TudusOpenHelper.TUDUS_DATE_COLUMN,
						TudusOpenHelper.TUDUS_DESCRIPTION_COLUMN,
						TudusOpenHelper.TUDUS_TITLE_COLUMN
				};
				
				
				Cursor c = db.query(TudusOpenHelper.TUDUS_TABLE_NAME, columns, null, null, null, null, null);
				Set<String> curentTudus = new HashSet<String>();
				while(c.moveToNext()){
					String codes = c.getString(c.getColumnIndex(TudusOpenHelper.TUDUS_CODE_COLUMN));
					String dates = c.getString(c.getColumnIndex(TudusOpenHelper.TUDUS_DATE_COLUMN));
					String des = c.getString(c.getColumnIndex(TudusOpenHelper.TUDUS_DESCRIPTION_COLUMN));
					String title = c.getString(c.getColumnIndex(TudusOpenHelper.TUDUS_TITLE_COLUMN));
					Tudus object = new Tudus (title , codes , dates);
					list.add(object); 
				}
				
					
					
					
					//		sp  = getSharedPreferences("blah", Context.MODE_PRIVATE);
			//		int i = 0;
			//		Set<String> gotem = sp.getStringSet("tudus", null);
			//		list = new ArrayList<Tudus>();
			//		if(gotem != null){
			//		for(String s:gotem){
			//			String title = "",code = "",date = "";
			//			i=0;
			//			while(s.charAt(i) != '_'){
			//			title += s.charAt(i);
			//			i++;
			//			}
			//			i++;
			//			while(s.charAt(i) != '_'){
			//				code += s.charAt(i);
			//				i++;
			//			}
			//			i++;
			//			while(s.charAt(i) != '_'){
			//				date += s.charAt(i);
			//				i++;
			//			}
			//		
			//			
			//			
			//		}
			//		}
					
					//list.add(object);
					lv = (ListView)findViewById(R.id.listView1);
					adapter = new CustomArrayAdapter(this ,android.R.layout.simple_list_item_1,list);
					lv.setAdapter(adapter);
					adapter.notifyDataSetChanged();

	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
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
		if( id == R.id.add){
			Intent in = new Intent(getApplicationContext(),AddTudu.class);
			
			startActivity(in);
		}
		return super.onOptionsItemSelected(item);
	}
}
