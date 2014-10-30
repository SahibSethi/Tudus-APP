package com.example.tudus.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;



public class TudusOpenHelper extends SQLiteOpenHelper {

	

//	
	
	public TudusOpenHelper(Context context) {
 		super(context, DATABASE, null, VERSION);
		// TODO Auto-generated constructor stub
	}

	public static final String DATABASE = "tudus";
	
	private static final int VERSION = 1;
	
	public static final String TUDUS_TABLE_NAME = "tudu";
	
	public static final String TUDUS_CODE_COLUMN = "code";

	public static final String TUDUS_TITLE_COLUMN = "title";
	
	public static final String TUDUS_DATE_COLUMN = "date";
	
	public static final String TUDUS_DESCRIPTION_COLUMN = "description";
	
	public static final String TUDUS_ID = "_ID";
	
	
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL("CREATE TABLE " + TUDUS_TABLE_NAME + " ( " + TUDUS_ID + 
				" INTEGER PRIMARY KEY, " +TUDUS_TITLE_COLUMN+ " TEXT, " + 
				TUDUS_CODE_COLUMN + " TEXT, " + TUDUS_DATE_COLUMN + " TEXT," +
				TUDUS_DESCRIPTION_COLUMN + " TEXT)");
		int x = 0;
		int j = x;
		ContentValues cv = new ContentValues();
		cv.put(TudusOpenHelper.TUDUS_CODE_COLUMN, "ASAP");
		cv.put(TudusOpenHelper.TUDUS_TITLE_COLUMN, "Hello");
		cv.put(TudusOpenHelper.TUDUS_DATE_COLUMN, "21/12/14");
		cv.put(TudusOpenHelper.TUDUS_DESCRIPTION_COLUMN, "blah");
		db.insert(TudusOpenHelper.TUDUS_TABLE_NAME, null, cv);
		
		ContentValues cv2 = new ContentValues();
		cv2.put(TudusOpenHelper.TUDUS_CODE_COLUMN, "WHEN FREE");
		cv2.put(TudusOpenHelper.TUDUS_TITLE_COLUMN, "Hello");
		cv2.put(TudusOpenHelper.TUDUS_DATE_COLUMN, "21/12/14");
		cv2.put(TudusOpenHelper.TUDUS_DESCRIPTION_COLUMN, "blah");
		db.insert(TudusOpenHelper.TUDUS_TABLE_NAME, null, cv2);
		

	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub

	}

}
