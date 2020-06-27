//
//import android.content.Context;
//import android.content.SharedPreferences;
//import android.graphics.Color;
//import android.preference.PreferenceManager;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.SimpleAdapter;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//
///**
// * Created by Adeoy3 on 3/9/2017.
// */
//
//
//
//
//
//
//
//
//
//
//
//public class CustomSearchListAdapter extends SimpleAdapter {
//    LayoutInflater inflater;
//    Context context;
//    ArrayList<HashMap<String, String>> arrayList;
//
//    public CustomSearchListAdapter(Context context, ArrayList<HashMap<String, String>> data, int resource, String[] from, int[] to)
//    {
//        super(context, data, resource, from, to);
//        this.context = context;
//        this.arrayList = data;
//        inflater.from(context);
//    }
//
//    @Override
//    public View getView(final int position, View convertView, ViewGroup parent) {
//        View view = super.getView(position, convertView, parent);
//        TextView text = (TextView) view.findViewById(R.id.lis);
//    SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
//
//        //    This line really suffered me, i was parsing null instead of a value like below, take note     String getTheTheme = sharedPreferences.getString("change_theme","");
//
//        String getTheTheme = sharedPreferences.getString("change_theme","White");
//
//        switch (getTheTheme)
//        {
//            case "White":
//                text.setTextColor(Color.parseColor("#131313"));
//                text.setBackgroundColor(context.getResources().getColor(R.color.color_white));
//                break;
//
//            case "Black":
//                text.setTextColor(context.getResources().getColor(R.color.color_white));
//                text.setBackgroundColor(context.getResources().getColor(R.color.color_black));
//               // parent_lay.setBackgroundColor(context.getResources().getColor(R.color.color_black));
//
//
//                Toast.makeText(context.getApplicationContext(),"Theme Selected is "+  getTheTheme,Toast.LENGTH_SHORT).show();
//                break;
//            case "Grey":
//                Utils.SIZE="DEFAULT";
//                text.setBackgroundColor(Color.parseColor("#c4c1c2"));
//                text.setTextColor(context.getResources().getColor(R.color.color_black));
//               // parent_lay.setBackgroundColor(Color.parseColor("#c4c1c2"));
//                // Toast.makeText(context.getApplicationContext(),"Theme Selected is "+  getTheTheme,Toast.LENGTH_SHORT).show();
//                break;
//
//            case "Brown":
//                Utils.SIZE="DEFAULT";
//                text.setBackgroundColor(Color.parseColor("#da9838"));
//                text.setTextColor(context.getResources().getColor(R.color.color_white));
//              //  parent_lay.setBackgroundColor(Color.parseColor("#a4526d"));
//               break;
//        }
//
//
//        return view;
//    }
//
//
//}
package com.forestsoftware.kands2revamp;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private ArrayList<QuizObject> dataSet;
    Boolean check=false;
    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView word,meaning;

        RelativeLayout expandable;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.expandable= (RelativeLayout)itemView.findViewById(R.id.expandableLayout);
            this.word= (TextView)itemView.findViewById(R.id.wordtext);
            this.meaning = (TextView) itemView.findViewById(R.id.meaningtext);

        }
    }

    public CustomAdapter(ArrayList<QuizObject> data)
    {
        this.dataSet = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.xx, parent, false);

        final MyViewHolder myViewHolder = new MyViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!check)
                {
                    myViewHolder.expandable.animate().alpha(0.0f).setDuration(1000);


                    myViewHolder.expandable.setVisibility(View.GONE);
                    check=true;
                    //  myViewHolder.schedule.setVisibility(View.VISIBLE);

                }
                else {
                    myViewHolder.expandable.setVisibility(View.VISIBLE);
                    myViewHolder.expandable.animate()
                            .alpha(1.0f)
                            .setDuration(1000);

                    check=false;

                }
            }
        });

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {

        TextView word1= holder.word;
        TextView meaning1 = holder.meaning;

        word1.setText(dataSet.get(listPosition).getWord());
        meaning1.setText(dataSet.get(listPosition).getDefinition());

    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}