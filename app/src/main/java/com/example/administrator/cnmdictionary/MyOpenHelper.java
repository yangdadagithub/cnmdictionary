package com.example.administrator.cnmdictionary;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2015/7/29.
 */
public class MyOpenHelper extends SQLiteOpenHelper {
    final String sql="create table user(_id integer primary key autoincrement,word,detail)";
    public MyOpenHelper(Context context,String name,SQLiteDatabase.CursorFactory factory,int vision){
        super(context,name,factory,vision);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
