package com.maizedevelopers.maizebooks.adapters;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBAdapter {
	
	private static final boolean D = false;
	private static final String TAG = "MaizeBooks";
	
	public static class TextBook {
		String ISBN;
		String Title;
		String Author;
		String Edition;
		int MinimumPrice;
		int MaximumPrice;
		String Condition;
		
		public TextBook() { }
	}

	public static final String KEY_ROWID = "_id";
	public static final int COL_ROWID = 0;
	
	public static final String KEY_ISBN = "isbn";
	public static final String KEY_TITLE = "title";
	public static final String KEY_AUTHOR = "author";
	public static final String KEY_EDITION = "edition";
	public static final String KEY_PRICE_MIN = "min_price";
	public static final String KEY_PRICE_MAX = "max_price";
	public static final String KEY_CONDITION = "condition";
	
	public static final int COL_ISBN = 1;
	public static final int COL_TITLE = 2;
	public static final int COL_AUTHOR = 3;
	public static final int COL_EDITION = 4;
	public static final int COL_PRICE_MIN = 5;
	public static final int COL_PRICE_MAX = 6;
	public static final int COL_CONDITION = 7;
	
	public static final String[] ALL_KEYS = new String[] {
		KEY_ROWID, KEY_ISBN, KEY_TITLE, KEY_AUTHOR, KEY_EDITION, KEY_PRICE_MIN, KEY_PRICE_MAX, KEY_CONDITION
	};
	
	public static final int DATABASE_VERSION = 1;
	
	public static final String DATABASE_NAME = "MyWishList";
	public static final String DATABASE_TABLE = "mainTable";	
	
	private static final String DATABASE_CREATE_SQL = 
		"create table " + DATABASE_TABLE 
		+ " (" + KEY_ROWID + " integer primary key autoincrement, "
		+ KEY_ISBN + " string not null, "
		+ KEY_TITLE + " string not null, "
		+ KEY_AUTHOR + " string not null, "
		+ KEY_EDITION + " string not null, "
		+ KEY_PRICE_MIN + " integer not null, "
		+ KEY_PRICE_MAX + " integer not null, "
		+ KEY_CONDITION + " string not null "
		+ ");";
	
	private DatabaseHelper mDBHelper;
	private SQLiteDatabase mDB;

	public DBAdapter(Context context) {
		mDBHelper = new DatabaseHelper(context);
	}
	
	public DBAdapter open() {
		mDB = mDBHelper.getWritableDatabase();
		return this;
	}

	public void close() {
		mDBHelper.close();
	}
	
	public long insertRow(TextBook textbook) {
		
		String DEBUG_TAG = "Adapters.DBAdapter.insertRow()";
		if(D) Log.d(TAG, DEBUG_TAG);

		ContentValues initialValues = new ContentValues();
		
		initialValues.put(KEY_ISBN, textbook.ISBN);
		initialValues.put(KEY_TITLE, textbook.Title);
		initialValues.put(KEY_AUTHOR, textbook.Author);
		initialValues.put(KEY_EDITION, textbook.Edition);
		initialValues.put(KEY_CONDITION, textbook.Condition);
		initialValues.put(KEY_PRICE_MIN, textbook.MinimumPrice);
		initialValues.put(KEY_PRICE_MAX, textbook.MaximumPrice);
		
		if(D) Log.d(TAG, DEBUG_TAG + ": Inserted \"" + textbook.Title + "\"");
		
		return mDB.insert(DATABASE_TABLE, null, initialValues);
	}
	
	public boolean deleteRow(long rowId) {
		String where = KEY_ROWID + "=" + rowId;		
		return mDB.delete(DATABASE_TABLE, where, null) != 0;
	}
	
	public void deleteAll() {
		Cursor c = getAllRows();
		long rowId = c.getColumnIndexOrThrow(KEY_ROWID);
		if (c.moveToFirst()) {
			do {
				deleteRow(c.getLong((int) rowId));				
			} while (c.moveToNext());
		}
		c.close();
	}
	
	public Cursor getAllRows() {
		String where = null;
		
		Cursor c = 	mDB.query(true, DATABASE_TABLE, ALL_KEYS, where, null, null, null, null, null);
		if (c != null) {
			c.moveToFirst();
		}
		
		return c;
	}

	public Cursor getRow(long rowId) {
		String where = KEY_ROWID + "=" + rowId;
		
		Cursor c = 	mDB.query(true, DATABASE_TABLE, ALL_KEYS, where, null, null, null, null, null);
		if (c != null) {
			c.moveToFirst();
		}
		
		return c;
	}
	
	public boolean updateRow(long rowId, TextBook textbook) {
		
		String DEBUG_TAG = "Adapters.DBAdapter.updateRow()";
		if(D) Log.d(TAG, DEBUG_TAG);
		
		String where = KEY_ROWID + "=" + rowId;

		ContentValues newValues = new ContentValues();
		
		newValues.put(KEY_ISBN, textbook.ISBN);
		newValues.put(KEY_TITLE, textbook.Title);
		newValues.put(KEY_AUTHOR, textbook.Author);
		newValues.put(KEY_EDITION, textbook.Edition);
		newValues.put(KEY_CONDITION, textbook.Condition);
		newValues.put(KEY_PRICE_MIN, textbook.MinimumPrice);
		newValues.put(KEY_PRICE_MAX, textbook.MaximumPrice);
		
		if(D) Log.d(TAG, DEBUG_TAG + ": Updated \"" + textbook.Title + "\"");
		
		return mDB.update(DATABASE_TABLE, newValues, where, null) != 0;
	}
	
	
	private static class DatabaseHelper extends SQLiteOpenHelper {
		
		DatabaseHelper(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
		}

		@Override
		public void onCreate(SQLiteDatabase _db) {
			_db.execSQL(DATABASE_CREATE_SQL);			
		}

		@Override
		public void onUpgrade(SQLiteDatabase _db, int oldVersion, int newVersion) {			
			_db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
			onCreate(_db);
		}
	}
}
