package com.sqlite.tfnews2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;

public class DBAdapter {

	/*private static final String DB_NAME="news.db";
	private static final String coun_table="coun";
	private static final String hot_table="hot";
	private static final String edu_table="edu";
	private static final String eco_table="eco";
	private static final String pe_table="pe";
	private static final int DB_VERSION=1;*/
	
	public static final String KEY_ID="id";
	public static final String KEY_NAME="name";
	public static final String KEY_PART="part";
	
	private SQLiteDatabase db;
	private final Context context;
	//private DBOpenHelper dbopenhelper;
	
	public DBAdapter(Context _context){
		context=_context;
	}
	
	public void close(){
		if(db !=null){
			db.close();
			db=null;
		}
	}
	
	public void open()throws SQLiteException{
		
		db=SQLiteDatabase.openOrCreateDatabase("/data/data/com.sqlite.tfnews2/news.db", null);
		//Log.e("!","打开数据库");
		/*dbopenhelper = new DBOpenHelper(context,DB_NAME,null,DB_VERSION);
		try{
			db=dbopenhelper.getWritableDatabase();
			//Log.e("jingru", "openwr");
		}
		catch(SQLiteException ex){
			db=dbopenhelper.getReadableDatabase();
		}*/
	}
	
	public long insert(String type,News news){
		ContentValues newValues=new ContentValues();
		newValues.put(KEY_PART, news.part);
		newValues.put(KEY_NAME, news.name);
		return db.insert(type, null, newValues);
	}
	
	public News[] queryAllData(String type){
		Cursor results=db.query(type, new String[]{KEY_ID,KEY_NAME,KEY_PART}, null, null, null, null, null, null);
		return ConvertTonews(type,results);
	}
	
	public News[] queryOneData(String type,long id){
		Cursor results=db.query(type,new String[]{KEY_ID,KEY_NAME,KEY_PART}, KEY_ID+"="+id, null, null, null, null, null);
		return ConvertTonews(type,results);
	}
	
	private News[] ConvertTonews(String type,Cursor cursor){
		int resultCounts=cursor.getCount();
		if (resultCounts==0||!cursor.moveToFirst()){
			//Log.e("query","空数据");
			return null;
		}
		//Log.e("query","非空数据"+resultCounts);
		News[] news=new News[resultCounts];
		for(int i=0;i<resultCounts;i++){
			news[i]=new News();
			news[i].ID=cursor.getInt(0);
			news[i].name=cursor.getString(cursor.getColumnIndex(KEY_NAME));
			news[i].part=cursor.getString(cursor.getColumnIndex(KEY_PART));
			//Log.v("！","获取第一组");
			cursor.moveToNext();
		}
		return news;
	}
	
	public long deleteAllData(String type){
		return db.delete(type, null, null);
	}
	
	public long deleteOneData(String type,long id){
		return db.delete(type, KEY_ID+"="+id , null);
	}
	
	public long updateOngData(String type,long id,News news){
		ContentValues updateValues=new ContentValues();
		updateValues.put(KEY_NAME, news.name);
		updateValues.put(KEY_PART, news.part);
		return db.update(type, updateValues, KEY_ID+"="+id, null);
	}
	
	/*private static class DBOpenHelper extends SQLiteOpenHelper{

		public DBOpenHelper(Context context, String name,
				CursorFactory factory, int version) {
			super(context, name, factory, version);
			// TODO Auto-generated constructor stub
		}

		private static final String DB_CREATE="creat table"+coun_table+"("+KEY_ID+"integer primary key autoincreament,"
				+KEY_NAME+"text not null"+KEY_PART+"text not null)"+","+"creat table"+edu_table+"("+KEY_ID+"integer primary key autoincreament,"
				+KEY_NAME+"text not null"+KEY_PART+"text not null)"+","+"creat table"+eco_table+"("+KEY_ID+"integer primary key autoincreament,"
				+KEY_NAME+"text not null"+KEY_PART+"text not null)"+","+"creat table"+hot_table+"("+KEY_ID+"integer primary key autoincreament,"
				+KEY_NAME+"text not null"+KEY_PART+"text not null)"+","+"creat table"+pe_table+"("+KEY_ID+"integer primary key autoincreament,"
				+KEY_NAME+"text not null"+KEY_PART+"text not null)";
		
		@Override
		public void onCreate(SQLiteDatabase _db) {
			// TODO Auto-generated method stub
			_db.execSQL(DB_CREATE);
		}

		@Override
		public void onUpgrade(SQLiteDatabase _db, int _oldVersion, int _newVersion) {
			// TODO Auto-generated method stub
			//_db.execSQL("DROP TABLE*");
			onCreate(_db);
		}
		
	}*/
}
