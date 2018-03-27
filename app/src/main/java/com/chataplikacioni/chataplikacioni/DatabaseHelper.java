package com.chataplikacioni.chataplikacioni;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by gimi on 3/26/2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Klienti.db";
    public static final String TABLE_Kategoria = "tblKategoria";
    public static final String Col_IDKategoria = "IDKategoria";
    public static final String Col_Kategoria = "Kategoria";



    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME,null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db = getWritableDatabase();
        db.execSQL("CREATE TABLE "+TABLE_Kategoria+" ("+Col_IDKategoria+" INTEGER PRIMARY KEY autoincrement, "+Col_Kategoria+" TEXT)");

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
    }

    public boolean addData(String Kategoria){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Col_Kategoria, Kategoria);
        long result = db.insert(TABLE_Kategoria, null, contentValues);

        if (result == -1)
            return false;

        else
            return true ;

    }

    public Cursor getListContents(){
        SQLiteDatabase db = getWritableDatabase();
        Cursor data = db.rawQuery("Select * from " + TABLE_Kategoria, null);
        return data;
    }

    public int deleteAll(){
        SQLiteDatabase db = getWritableDatabase();
        return db.delete(TABLE_Kategoria, null, null);
    }

}
