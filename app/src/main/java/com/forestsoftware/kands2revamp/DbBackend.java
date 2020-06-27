package com.forestsoftware.kands2revamp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DbBackend extends DbObject {

    private final String DATABASE_TABLE = "title";

    public DbBackend(Context context) {
        super(context);
    }

    ////////////////////////////////////////

    public List<ItemObject> searchDictionaryWords(String searchWord) {
        List<ItemObject> mItems = new ArrayList<ItemObject>();
        String query = "Select * from dictionary where title like " + "'%" + searchWord + "%'";
        Cursor cursor = this.getDbConnection().rawQuery(query, null);
        ArrayList<String> wordTerms = new ArrayList<String>();
        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                String word = cursor.getString(cursor.getColumnIndexOrThrow("title"));
                mItems.add(new ItemObject(id, word));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return mItems;
    }
    ItemObject itemObject = new ItemObject();
    public ArrayList<HashMap<String, String>> getStudentList() {
        //Open connection to read only
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery = "SELECT  " +
                itemObject.KEY_ID + "," +
                itemObject.KEY_word + "," +
                itemObject.KEY_meaning +
                " FROM " + itemObject.TABLE;

        //Student student = new Student();
        ArrayList<HashMap<String, String>> songList = new ArrayList<HashMap<String, String>>();

        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list

        if (cursor.moveToFirst()) {
            do {
                HashMap<String, String> song = new HashMap<String, String>();
                song.put("_id", cursor.getString(cursor.getColumnIndex(itemObject.KEY_ID)));
                song.put("title", cursor.getString(cursor.getColumnIndex(itemObject.KEY_word)));
                song.put("contents", cursor.getString(cursor.getColumnIndex(itemObject.KEY_meaning)));

                songList.add(song);

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return songList;

    }

    public Cursor  getStudentListByKeyword(String search) {
        //Open connection to read only
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery =  "SELECT  rowid as " +
                itemObject.KEY_ID + "," +
//                itemObject.KEY_ROWID + "," +
                itemObject.KEY_word + "," +
                itemObject.KEY_meaning +
                " FROM " + itemObject.TABLE +
                " WHERE " +  itemObject.KEY_word + "  LIKE  '%" +search + "%' "
                ;


        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list

        if (cursor == null) {
            return null;
        } else if (!cursor.moveToFirst()) {
            cursor.close();
            return null;
        }
        return cursor;


    }


    String mean = "";

    public List<ItemObject> searchDictionarymeaning2(String searchMeaning) {
        mean = searchMeaning;
        List<ItemObject> mItems = new ArrayList<ItemObject>();
        String query = "Select * from dictionary where contents like " + "'%" + searchMeaning + "%'";
        Cursor cursor = this.getDbConnection().rawQuery(query, null);
        //  ArrayList<String> wordTerms = new ArrayList<String>();
        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                String word = cursor.getString(cursor.getColumnIndexOrThrow("title"));
                String meaning = cursor.getString(cursor.getColumnIndexOrThrow("contents"));
                mItems.add(new ItemObject(id, meaning));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return mItems;
    }

    public String getSearch() {
        return mean;
    }

    public List<ItemObject> searchDictionarymeaning(String searchMeaning) {
        mean = searchMeaning;
        List<ItemObject> mItems = new ArrayList<ItemObject>();
        String query = "Select * from dictionary where contents like " + "'%" + searchMeaning + "%'";
        Cursor cursor = this.getDbConnection().rawQuery(query, null);
        //  ArrayList<String> wordTerms = new ArrayList<String>();
        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                String word = cursor.getString(cursor.getColumnIndexOrThrow("title"));
                String meaning = cursor.getString(cursor.getColumnIndexOrThrow("contents"));
                mItems.add(new ItemObject(id, word, meaning));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return mItems;
    }

    public List<ItemObject> searchDictionarymeaning() {
        String mean = getSearch();
        //    mean = searchMeaning;
        List<ItemObject> mItems = new ArrayList<ItemObject>();
        String query = "Select * from dictionary where contents like " + "'%" + mean + "%'";
        Cursor cursor = this.getDbConnection().rawQuery(query, null);
        //  ArrayList<String> wordTerms = new ArrayList<String>();
        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
//                String word = cursor.getString(cursor.getColumnIndexOrThrow("title"));
                String meaning = cursor.getString(cursor.getColumnIndexOrThrow("contents"));
                mItems.add(new ItemObject(id, meaning));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return mItems;
    }

    public String getEmployeeName(String empNo) {
        Cursor cursor = null;
        String contents = "";
        try {
            cursor = this.getDbConnection().rawQuery("SELECT contents FROM dictionary WHERE title=?", new String[]{contents + ""});
            if (cursor.getCount() > 0) {
                cursor.moveToFirst();
                contents = cursor.getString(cursor.getColumnIndex("contents"));
            }
            return contents;
        } finally {
            cursor.close();
        }
    }
//
//    public long getTaskCount(long tasklist_Id) {
//        return DatabaseUtils.queryNumEntries(readableDatabase, TABLE_NAME);
//    }
//
//    public long getProfilesCount() {
//
//        SQLiteDatabase db = this.getReadableDatabase();
//        long cnt  = DatabaseUtils.queryNumEntries(db, "dictionary");
//        db.close();
//        return cnt;
//    }

    ////////////////////////////////////


    public String[] dictionaryWords() {
//        String query = "Select * from dictionary";
//        Cursor cursor = this.getDbConnection().rawQuery(query, null);
//        ArrayList<String> wordTerms = new ArrayList<String>();
//        if (cursor.moveToFirst()) {
//            do {
//                String word = cursor.getString(cursor.getColumnIndexOrThrow("title"));
//                wordTerms.add(word);
//            } while (cursor.moveToNext());
//        }
//        cursor.close();
//        String[] dictionaryWords = new String[wordTerms.size()];
//        dictionaryWords = wordTerms.toArray(dictionaryWords);
//        return dictionaryWords;
        return null;
    }

    public String[] dictionaryMeaning() {
        String query = "Select * from dictionary";
        Cursor cursor = this.getDbConnection().rawQuery(query, null);
        ArrayList<String> wordTerms = new ArrayList<String>();
        if (cursor.moveToFirst()) {
            do {
                String word = cursor.getString(cursor.getColumnIndexOrThrow("contents"));
                wordTerms.add(word);
            } while (cursor.moveToNext());
        }
        cursor.close();
        String[] dictionaryWords = new String[wordTerms.size()];
        dictionaryWords = wordTerms.toArray(dictionaryWords);
        return dictionaryWords;
    }

    public String[] dictionaryNumber() {
        String query = "Select * from dictionary";
        Cursor cursor = this.getDbConnection().rawQuery(query, null);
        ArrayList<String> wordTerms = new ArrayList<String>();
        if (cursor.moveToFirst()) {
            do {
                String word = cursor.getString(cursor.getColumnIndexOrThrow("number"));
                wordTerms.add(word);
            } while (cursor.moveToNext());
        }
        cursor.close();
        String[] dictionaryWords = new String[wordTerms.size()];
        dictionaryWords = wordTerms.toArray(dictionaryWords);
        return dictionaryWords;
    }
//    public Integer[] dictionaryNumber()
//    {
//        String query = "Select * from dictionary";
//        Cursor cursor = this.getDbConnection().rawQuery(query, null);
//        ArrayList<Integer> wordTerms = new ArrayList<Integer>();
//        if(cursor.moveToFirst())
//        {
//            do{
//                int word = cursor.getInt(cursor.getColumnIndexOrThrow("number"));
//                wordTerms.add(word);
//            }while(cursor.moveToNext());
//        }
//        cursor.close();
//        Integer [] dictionaryWords = new Integer[wordTerms.size()];
//        dictionaryWords = wordTerms.toArray(dictionaryWords);
//        return dictionaryWords;
//    }


    public String[] songNumber() {
        String query = "Select * from dictionary";
        Cursor cursor = this.getDbConnection().rawQuery(query, null);
        ArrayList<String> songNumber = new ArrayList<String>();
        if (cursor.moveToFirst()) {
            do {
                String n = cursor.getString(cursor.getColumnIndexOrThrow("number"));
                songNumber.add(n);
            } while (cursor.moveToNext());
        }
        cursor.close();
        String[] dictionaryWords = new String[songNumber.size()];
        dictionaryWords = songNumber.toArray(dictionaryWords);
        return dictionaryWords;
    }

    public QuizObject getQuizById(int quizId) {

        QuizObject quizObject = null;
        String query = "select * from dictionary where _id = " + quizId;
        Cursor cursor = this.getDbConnection().rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                String word = cursor.getString(cursor.getColumnIndexOrThrow("title"));
                String meaning = cursor.getString(cursor.getColumnIndexOrThrow("contents"));
                quizObject = new QuizObject(word, meaning);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return quizObject;
    }

    public QuizObject getQuizByname(String titleId) {

        QuizObject quizObject = null;
        String query = "select * from dictionary where title = " + titleId;
        Cursor cursor = this.getDbConnection().rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                String word = cursor.getString(cursor.getColumnIndexOrThrow("title"));
                String meaning = cursor.getString(cursor.getColumnIndexOrThrow("contents"));
                quizObject = new QuizObject(word, meaning);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return quizObject;
    }

    public String getQuizByTitle(String title) {
        Cursor cursor = null;
        String empName = "";
        try {
            cursor = this.getDbConnection().rawQuery("SELECT contents FROM dictionary WHERE title=?", new String[]{title + ""});

//            if(cursor==null)
//            {
//                return null;
//            }
//            else if(!cursor.moveToFirst())
//            {
//                cursor.close();
//                return null;
//            }
//            return cursor;


            if (cursor.getCount() > 0) {
                cursor.moveToFirst();
                empName = cursor.getString(cursor.getColumnIndex("contents"));
            }
            return empName;
        } finally {
            cursor.close();
        }
    }

    public String getauthWithid() {
        String query = new String("select title from quiz where ID = 1");
        Cursor result = this.getDbConnection().rawQuery(query, null);
        String returnString = ""; // Your default if none is found
        if (result.moveToFirst()) {
            returnString = result.getString(result.getColumnIndex("title"));
        }
        result.close();
        return returnString;
    }

    public ArrayList<String> getRecords() {
        ArrayList<String> data = new ArrayList<String>();
        Cursor cursor = this.getDbConnection().query(DATABASE_TABLE, new String[]{"column titles"}, null, null, null, null, null);
        String fieldToAdd = null;
        while (cursor.moveToNext()) {
            fieldToAdd = cursor.getString(0);
            data.add(fieldToAdd);
        }
        cursor.close();  // dont forget to close the cursor after operation done
        return data;
    }


}
