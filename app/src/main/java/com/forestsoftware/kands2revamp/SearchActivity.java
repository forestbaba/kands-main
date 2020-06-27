package com.forestsoftware.kands2revamp;
//
//
//import android.content.Intent;
//import android.content.SharedPreferences;
//import android.graphics.Typeface;
//import android.os.Bundle;
//import android.preference.PreferenceManager;
//import android.support.v7.app.AppCompatActivity;
//import android.text.Editable;
//import android.text.TextWatcher;
//import android.util.Log;
//import android.view.View;
//import android.widget.AdapterView;
//import android.widget.ArrayAdapter;
//import android.widget.EditText;
//import android.widget.ListView;
//import android.widget.RelativeLayout;
//import android.widget.TextView;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//
//
//public class SearchActivity extends AppCompatActivity {
//    private EditText filterText;
//    RelativeLayout parent_lay;
//
//    CustomSearchListAdapter adapter;
//    private ArrayAdapter<String> listAdapter;
//    TextView l, t;
//
//    ListView itemList;
//    //just added
//    private DbBackend databaseObject;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.search_);
//
//        filterText = (EditText) findViewById(R.id.editText);
//        l = (TextView) findViewById(R.id.lis);
//        itemList = (ListView) findViewById(R.id.listView);
//        parent_lay = (RelativeLayout) findViewById(R.id.parent_search);
//
//
//        DbBackend dbBackend = new DbBackend(SearchActivity.this);
//        String[] terms = dbBackend.dictionaryWords();
//        String[] meaning = dbBackend.dictionaryMeaning();
//
//        int pos = 0;
//        final ItemObject uu = new ItemObject();
//        ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
//        for (int i = 0; i < terms.length; i++) {
//            HashMap<String, String> hashMap = new HashMap<>();//create a hashmap to store the data in key value pair
//            hashMap.put("name", terms[i]);
//            pos = i;
//            uu.setId(terms.length);
//            arrayList.add(hashMap);//add the hashmap into arrayList
//            Log.e("MMMMMMMMM SIZE :", "" + i);
//
//        }
////        for (int i = 0; i < meaning.length; i++) {
////            HashMap<String, String> hashMap = new HashMap<>();//create a hashmap to store the data in key value pair
////            hashMap.put("meaning", meaning[i]);
////            arrayList.add(hashMap);//add the hashmap into arrayList
////        }
//
//        String[] from = {"name"};//string array
//        int[] to = {R.id.lis};
//
//        adapter = new CustomSearchListAdapter(this, arrayList, R.layout.list_item_search, from, to);
//
//        itemList.setAdapter(adapter);
//        itemList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                // make Toast when click
//                //   Toast.makeText(getApplicationContext(), "Position " + position, Toast.LENGTH_LONG).show();
//
//                   l = (TextView) view.findViewById(R.id.lis);
//                String sx = l.getText().toString();
//
//                Intent intent = new Intent(getApplicationContext(), xplain.class);
//                intent.putExtra("DIC", sx);
////                intent.putExtra("DICTIONARY_ID", Integer.parseInt(sx));
//                //                  Toast.makeText(getApplicationContext(), "Position " + position, Toast.LENGTH_LONG).show();
//                startActivity(intent);
//            }
//        });
//
//        filterText.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                SearchActivity.this.adapter.getFilter().filter(s);
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//            }
//        });
//        Typeface t1 = Typeface.createFromAsset(getAssets(), "fonts/aristcr.ttf");
////        Typeface t2 = Typeface.createFromAsset(getAssets(),"fonts/Bems.ttf");
//        Typeface t3 = Typeface.createFromAsset(getAssets(), "fonts/DroidSerif.ttf");
//        Typeface t4 = Typeface.createFromAsset(getAssets(), "fonts/Menbs.ttf");
//
//        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
//
//        String getTheTheme = sharedPreferences.getString("change_theme", "White");
//        switch (getTheTheme) {
//            case "White":
//
//                filterText.setBackgroundColor(getResources().getColor(R.color.color_white));
//                filterText.setTextColor(getResources().getColor(R.color.color_black));
//                parent_lay.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.color_white));
//                break;
//
//            case "Black":
//                filterText.setBackgroundColor(getResources().getColor(R.color.color_black));
//                filterText.setTextColor(getResources().getColor(R.color.color_white));
//                parent_lay.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.color_black));
//                break;
//
//            case "Grey":
//                filterText.setBackgroundColor(getResources().getColor(R.color.colour_grey));
//                filterText.setTextColor(getResources().getColor(R.color.color_black));
//                parent_lay.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.colour_grey));
//                break;
//
//            case "Brown":
//                filterText.setBackgroundColor(getResources().getColor(R.color.colour_brown));
//                filterText.setTextColor(getResources().getColor(R.color.color_white));
//                parent_lay.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.colour_brown));
//                break;
//
//        }
//
//
//        String getTheFont = sharedPreferences.getString("change_font", null);
////        switch (getTheFont) {
////
////
////            case "Aristic":
////                filterText.setTypeface(t1);
//////                l.setTypeface(t1);
////
////
////                //   Toast.makeText(getApplicationContext(),"Theme Selected is "+ getTheTheme,Toast.LENGTH_SHORT).show();
////                break;
////
////            case "Sans Serif":
////                filterText.setTypeface(Typeface.SANS_SERIF);
////                l.setTypeface(Typeface.SANS_SERIF);
////
////                // Toast.makeText(getApplicationContext(),"Theme Selected is "+  getTheTheme,Toast.LENGTH_SHORT).show();
////                break;
////            case "Monospace":
////                filterText.setTypeface(Typeface.MONOSPACE);
////                l.setTypeface(Typeface.MONOSPACE);
////
////                // Toast.makeText(getApplicationContext(),"Theme Selected is "+  getTheTheme,Toast.LENGTH_SHORT).show();
////                break;
////
////            case "Sans":
////                filterText.setTypeface(Typeface.SERIF);
////                l.setTypeface(Typeface.SERIF);
////
////                // Toast.makeText(getApplicationContext(),"Theme Selected is "+  getTheTheme,Toast.LENGTH_SHORT).show();
////                break;
////            case "Droid Serif":
////                filterText.setTypeface(t3);
////                l.setTypeface(t3);
////
////                // Toast.makeText(getApplicationContext(),"Theme Selected is "+  getTheTheme,Toast.LENGTH_SHORT).show();
////                break;
////            case "Menbs":
////                filterText.setTypeface(t4);
////                l.setTypeface(t4);
////
////
////                // Toast.makeText(getApplicationContext(),"Theme Selected is "+  getTheTheme,Toast.LENGTH_SHORT).show();
////                break;
////        }
//    }
//}
//


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class SearchActivity extends AppCompatActivity {

    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    public static ArrayList<QuizObject> data;
    DictionaryDatabase db ;
    ArrayList<String> wordcombimelist;
    ArrayList<String> meancombimelist;
    LinkedHashMap<String, String> namelist;
    SearchView searchView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
//        recyclerView.setHasFixedSize(true);
        db=  new DictionaryDatabase(this);
        searchView = (SearchView) findViewById(R.id.searchView);
//        searchView.setQueryHint("Search Here");
//        searchView.setQueryRefinementEnabled(true);
        layoutManager = new LinearLayoutManager(this);
//        recyclerView.setLayoutManager(layoutManager);
//        recyclerView.setItemAnimator(new DefaultItemAnimator());
        data = new ArrayList<QuizObject>();
        fetchData();


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {return  false; }

            @Override
            public boolean onQueryTextChange(String newText) {


                newText = newText.toLowerCase();

                final ArrayList<QuizObject> filteredList = new ArrayList<QuizObject>();

                for (int i = 0; i < wordcombimelist.size(); i++) {

                    final String text = wordcombimelist.get(i).toLowerCase();
                    if (text.contains(newText)) {

                        filteredList.add(new QuizObject(wordcombimelist.get(i),meancombimelist.get(i)));
                    }
                }
                adapter = new CustomAdapter(filteredList);
                recyclerView.setAdapter(adapter);


                return true;
            }
        });


    }
    public void fetchData()
    {
        db =new DictionaryDatabase(this);
        try {

            db.createDataBase();
            db.openDataBase();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


        namelist=new LinkedHashMap<>();
        int ii;
        SQLiteDatabase sd = db.getReadableDatabase();
        Cursor cursor = sd.query("quiz" ,null, null, null, null, null, null);
        ii=cursor.getColumnIndex("word");
        wordcombimelist=new ArrayList<String>();
        meancombimelist= new ArrayList<String>();
        while (cursor.moveToNext()){
            namelist.put(cursor.getString(ii), cursor.getString(cursor.getColumnIndex("definition")));
        }
        Iterator entries = namelist.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry thisEntry = (Map.Entry) entries.next();
            wordcombimelist.add(String.valueOf(thisEntry.getKey()));
            meancombimelist.add("- "+ String.valueOf(thisEntry.getValue()));
        }

        for (int i = 0; i < wordcombimelist.size(); i++) {
            data.add(new QuizObject(wordcombimelist.get(i), meancombimelist.get(i)));
        }
        adapter = new CustomAdapter(data);
        recyclerView.setAdapter(adapter);
    }
}
