package com.android.docpreter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import org.json.JSONObject;

import java.util.ArrayList;

public class SqliteHelper extends SQLiteOpenHelper {
    private static final String REC_TAB = "receipts";
    private static final String INEFFECT = "ineffect";
    private static final String ASSIGNED = "assigned";
    private static final String OFFLINE = "offline";

    public SqliteHelper(@Nullable Context context) {
        super(context, "userData.db", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String catQuery = "CREATE TABLE " +REC_TAB+" ("+INEFFECT+" TEXT(100), "+ASSIGNED+" TEXT(100), "+ OFFLINE +" TEXT(100))";
        sqLiteDatabase.execSQL(catQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public void addRecipt(String recId){
        SQLiteDatabase dBase = this.getWritableDatabase();
        ContentValues cv =new ContentValues();
        cv.put(INEFFECT,recId);
        dBase.insert(REC_TAB,null,cv);
    }
    public ArrayList<String> getReceipt(){
        ArrayList<String> al = new ArrayList<>();
        String fetchStmt = "SELECT "+ASSIGNED+" FROM "+ REC_TAB;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(fetchStmt,null);
        if(cursor.moveToFirst()){
            do{
                String temp = cursor.getString(0);
                al.add(temp);
            }while(cursor.moveToNext());
        }else{
        }
        cursor.close();
        db.close();
        return al;
    }
}
