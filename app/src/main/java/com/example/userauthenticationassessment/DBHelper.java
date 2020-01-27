package com.example.userauthenticationassessment;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    private static  final int Database_Version=1;
    private static final  String Database_Name="informations.db";
    private static final  String Table_Name="UserCredentials";
    private static final  String Column_Id="id";
    private static final  String Column_Fname="first";
    private static final  String Column_Lname="last";
    private static final  String Column_Email="email";
    private static final  String Column_Pass="pass";
    SQLiteDatabase db;
    private static final String Table_Create= "create table UserCredentials(id integer primary key not null, first text not null, last text not null, email text not null, pass teinformatxt not null);";

    public DBHelper(Context context){
        super(context,Database_Name,null,Database_Version);

    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Table_Create);
        this.db=db;
    }
    public void insertInfo(Information information){
         db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        String query="select * from UserCredentials";
        Cursor cursor=db.rawQuery(query,null);
        int count=cursor.getCount();

        values.put(Column_Id,count);
        values.put(Column_Fname,information.getFname());
        values.put(Column_Lname,information.getLname());
        values.put(Column_Email,information.getEmail());
        values.put(Column_Pass,information.getPass());

        db.insert(Table_Name,null,values);
        db.close();
    }

    public String searchPass(String email){
        db=this.getReadableDatabase();
        String query="select email,pass from "+Table_Name;
        Cursor cursor=db.rawQuery(query,null);
        String a,b;
        b="not found";
        if (cursor.moveToFirst()){
            do {
                a=cursor.getString(0);
                if(a.equals(email)){
                    b=cursor.getString(1);
                    break;
                }
            }
            while (cursor.moveToNext());
        }
        return b;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query="DROP TABLE IF EXISTS " +Table_Name;
        db.execSQL(query);
        this.onCreate(db);
    }
}
