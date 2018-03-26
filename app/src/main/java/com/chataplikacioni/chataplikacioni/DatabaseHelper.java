package com.chataplikacioni.chataplikacioni;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.*;

import java.util.ArrayList;

/**
 * Created by gimi on 3/26/2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Klienti.db";
    public static final String TABLE_Kategoria = "tblKategoria";
    public static final String Col_IDKategoria = "IDKategoria";
    public static final String Col_Kategoria = "Kategoria";

    public static final String TABLE_Roli = "tblRoli";
    public static final String Col_IDRoli = "IDRoli";
    public static final String Col_Roli = "Roli";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME,null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+TABLE_Kategoria+" ("+Col_IDKategoria+" INTEGER PRIMARY KEY autoincrement, "+Col_Kategoria+" TEXT)");
        db.execSQL("CREATE TABLE "+TABLE_Roli+" ("+Col_IDRoli+" INTEGER PRIMARY KEY, "+Col_Roli+" TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_Kategoria);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_Roli);
        onCreate(db);
    }

    public boolean addData(String Kategoria){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Col_Kategoria, Kategoria);
        long result = db.insert(TABLE_Kategoria, null, contentValues);

        if (result == -1){
            return false;
        }
        else {
            return true ;
        }
    }

    public Cursor getListContents(){
        SQLiteDatabase db = getWritableDatabase();
        Cursor data = db.rawQuery("Select * from " + TABLE_Kategoria, null);
        return data;
    }

    public int delete(){
        SQLiteDatabase db = getWritableDatabase();
        return db.delete(TABLE_Kategoria, null, null);
    }

}
