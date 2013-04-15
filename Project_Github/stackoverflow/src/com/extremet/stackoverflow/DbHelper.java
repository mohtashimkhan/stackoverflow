package com.extremet.stackoverflow;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
/**
 * @author Mkhan eXtreme Team
 *
 */



public class DbHelper extends SQLiteOpenHelper

{
	public static final String DATABASE_NAME="new.db";
	public static final String TABLE_NAME="user_login";
	public static final String C_ID="_id";
	public static final String REPUTATION="reputation";
	public static final String CREATION_DATE="creation_date";
	public static final String DISPLAY_NAME="display_name";
	public static final String EMAIL="email_hash";
	public static final String LAST_ACCSESS_DATE="last_accsess_date";
	public static final String WEBSITE="website_url";
	public static final String LOCATION="location";
	public static final String AGE="age";
	public static final String ABOUT_ME="about_me";
	public static final String VIEWS="views";
	public static final String UP_VOTES="up_votes";
	public static final String DOWN_VOTES="down_votes";
	public static final String USERNAME="username";
	public static final String PASSWORD="password";
	private static final int DATABASE_VERSION = 1;
	private static final String DB_ADMIN = "INSERT INTO "+TABLE_NAME+"values(1, admin, password, admin@gmail.com);";
	
	private final String createDb = "create table if not exists " + TABLE_NAME+ " ( "
			+ C_ID + "integer primary key autoincrement,"
	        + REPUTATION +"int,"
	        + CREATION_DATE +"int,"
			+ DISPLAY_NAME + "text,"
			+ EMAIL + "text,"
			+ LAST_ACCSESS_DATE + "text,"
			+ WEBSITE + "text,"
			+ LOCATION +"text,"
			+ AGE +"int,"
			+ USERNAME+"text,"
			+ PASSWORD+"text,"
			+ ABOUT_ME + "text,"
			+ VIEWS + "int,"
			+ UP_VOTES + "int,"
			+ DOWN_VOTES + "int,";	
	
	public DbHelper(Context context) {
		super(context, DATABASE_NAME,null, DATABASE_VERSION);
		
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		
		try{
			//Create Database
			db.execSQL(createDb);
			//create admin account
			db.execSQL(DB_ADMIN);
			System.out.println("In onCreate");
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("drop table " + TABLE_NAME );

	}

}
