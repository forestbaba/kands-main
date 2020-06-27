package com.forestsoftware.kands2revamp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Adeoy3 on 4/27/2017.
 */

public class SearchAdapter extends BaseAdapter
{
    private Context mContext;
    private LayoutInflater layoutInflater;
    private List<ItemObject> listItemStorage;
    private ArrayList<ItemObject> theArray;
    private QuizObject qo;
    public SearchAdapter(Context context, List<ItemObject> customizedListView)
    {
        mContext = context;
        layoutInflater =(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        listItemStorage = customizedListView;
        this.theArray = new ArrayList<ItemObject>();
        this.theArray.addAll(listItemStorage);
    }
    @Override
    public int getCount() { return listItemStorage.size(); }
    @Override
    public Object getItem(int position) { return listItemStorage.get(position); }
    @Override
    public long getItemId(int position) { return position; }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent)
    {
        ViewHolder listViewHolder;
        if(convertView == null){ listViewHolder = new ViewHolder();
            convertView = layoutInflater.inflate(R.layout.item_list, parent, false);
            listViewHolder.dictionaryWord = (TextView)convertView.findViewById(R.id.list_item_search);
            convertView.setTag(listViewHolder); }else{ listViewHolder = (ViewHolder)convertView.getTag();
        }
        listViewHolder.dictionaryWord.setText(listItemStorage.get(position).getWord());
        listViewHolder.dictionaryMeaning.setText(listItemStorage.get(position).getMeaning());

        convertView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // Send single item click data to SingleItemView Class
//                Intent intent = new Intent(MainActivity.this, SettingsActivity2.class);

                Intent intent = new Intent(mContext, SongOverviewActivitySearch.class);


                // Pass all data rank
                intent.putExtra("word" ,(listItemStorage.get(position).getWord()));
                intent.putExtra("meaning" ,(listItemStorage.get(position).getMeaning()));

                // Pass all data country
               // intent.putExtra("country",(worldpopulationlist.get(position).getCountry()));
                // Pass all data population
                //intent.putExtra("population",(worldpopulationlist.get(position).getPopulation()));
                // Pass all data flag
                // Start SingleItemView Class
                mContext.startActivity(intent);
            }
        });

        return convertView;
    }
    static class ViewHolder
    {
        TextView dictionaryWord;
        TextView dictionaryMeaning;// just added
    }

}
