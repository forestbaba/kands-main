package com.forestsoftware.kands2revamp;

/**
 * Created by Adeoy3 on 4/27/2017.
 */

public class ItemObject {
    private int id;
    private String word;
    private String meaning;

    public static final String KEY_ID = "_id";
    public static final String KEY_ROWID = "id";
    public static final String KEY_word = "title";
    public static final String KEY_meaning = "contents";
    public static final String TABLE = "dictionary";

    private int [] l;

    public ItemObject()
    {

    }

    public ItemObject(int id, String word) {
        this.id = id;
        this.word = word;
    }

    public ItemObject(int id, String word, String meaning) {
        this.id = id;
        this.word = word;
        this.meaning = meaning;
    }

    public int getId()
    {
        return this.id;
    }

    public String getWord() {
        return this.word;
    }

    public String getMeaning()
    {
        return this.meaning;
    }
    public void setId(int i)
    {
        i = id;
    }
    public void setI(int [] i)
    {
         l = i;
    }
    public int [] getl()
    {
        return this.l;

    }
}
