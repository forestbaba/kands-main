package com.forestsoftware.kands2revamp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class DbObject {

    public static DictionaryDatabase dbHelper;
    private SQLiteDatabase db;

    public DbObject(Context context) {
        dbHelper = new DictionaryDatabase(context);
        this.db = dbHelper.getReadableDatabase();

//
//        File dbFile = myContext.getDatabasePath(DB_NAME);
//        return dbFile.exists();
    }

    public SQLiteDatabase getDbConnection(){
        return this.db;
    }

    public void closeDbConnection(){
        if(this.db != null){
            this.db.close();
        }
    }

}

