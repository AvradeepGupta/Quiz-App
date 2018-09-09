package com.example.avrad.myquiz;

import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;

import static java.sql.Types.VARCHAR;

public class DbHelper extends SQLiteOpenHelper {
	
	private static final String DATABASE_NAME="mydb";//Thread-0

	public DbHelper(Context context) {
		super(context, DATABASE_NAME, null, 1);
    }
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE IF NOT EXISTS 'security' (name VARCHAR" +
				", password VARCHAR);");
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, 
			int newVersion) {
	 	db.execSQL("DROP TABLE IF EXISTS security ");
		onCreate(db);
	}
	
}