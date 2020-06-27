package com.forestsoftware.kands2revamp;//package com.forestsoftware.ks;
//
//import android.app.SearchManager;
//import android.content.Intent;
//import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
//import android.view.View;
//import android.widget.AdapterView;
//import android.widget.ListView;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import java.util.List;

/**
 * Created by Adeoy3 on 4/27/2017.
 */

/*public class SearchActivity2 extends AppCompatActivity {
    private ListView listView;
    private DbBackend databaseObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_activity_2);
// create database object databaseObject = new DbBackend(SearchableActivity.this);
        databaseObject = new DbBackend(SearchActivity2.this);
        listView = (ListView) findViewById(R.id.listView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DbBackend dbBackend = new DbBackend(getApplicationContext());
                Intent intent = new Intent(SearchActivity2.this, SongOverviewActivity.class);
                /// intent.putExtra("title", dbBackend.getRecords().get(position).get));
                startActivity(intent);


                TextView t = (TextView) view.findViewById(R.id.list_item_search);
                String studentId = t.getText().toString();
                List<ItemObject> dictionaryObject = databaseObject.searchDictionaryWords(studentId);
                Intent objIndent = new Intent(getApplicationContext(), SongOverviewActivity.class);
                // objIndent.putExtra("DICTIONARY_ID", dbBackend.getEmployeeName(studentId));
                // startActivity(objIndent);

                //       DbBackend dbBackend = new DbBackend(getApplicationContext());
//                QuizObject allQuizQuestions = dbBackend.getQuizById(position);
//
//                DictionaryDatabase b = new DictionaryDatabase(getApplicationContext());
                String mo = dbBackend.getEmployeeName("Emi y'o gbadura");
                Toast.makeText(getApplicationContext(), "The ID is: " + mo, Toast.LENGTH_LONG).show();
                //   Intent intent = new Intent(getApplicationContext(), SongOverviewActivity.class);


            }
        });
        handleIntent(getIntent());
    }

    @Override
    protected void onNewIntent(Intent intent) {
        setIntent(intent);
        handleIntent(intent);
    }

    private void handleIntent(Intent intent) {
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            doMySearch(query);
        }
    }

    private void doMySearch(String query) {
        List<ItemObject> dictionaryObject = databaseObject.searchDictionaryWords(query);
        SearchAdapter mSearchAdapter = new SearchAdapter(SearchActivity2.this, dictionaryObject);
        listView.setAdapter(mSearchAdapter);
    }
}
*/