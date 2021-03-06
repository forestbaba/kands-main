package com.forestsoftware.kands2revamp.testers;

/**
 * Created by Adeoy3 on 6/26/2017.
 */


import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.forestsoftware.kands2revamp.ItemObject;
import com.forestsoftware.kands2revamp.R;


/**
 * Created by Tan on 3/14/2016.
 */

public class CustomAdapter extends CursorAdapter {
    TextView txtId, txtName, txtEmail;
    private LayoutInflater mInflater;

    public CustomAdapter(Context context, Cursor c, int flags) {
        super(context, c, flags);
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        
    }


    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        View view = mInflater.inflate(R.layout.item, parent, false);
        ViewHolder holder = new ViewHolder();
        holder.txtId = (TextView) view.findViewById(R.id.txtId);
        holder.txtName = (TextView) view.findViewById(R.id.txtName);
        holder.txtEmail = (TextView) view.findViewById(R.id.txtEmail);
        view.setTag(holder);
        return view;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        //If you want to have zebra lines color effect uncomment below code
        if(cursor.getPosition()%2==1) {
             //view.setBackgroundResource(R.drawable.item_list_backgroundcolor);
        } else {
          //  view.setBackgroundResource(R.drawable.item_list_backgroundcolor2);
        }

        ViewHolder holder = (ViewHolder) view.getTag();
        holder.txtId.setText(cursor.getString(cursor.getColumnIndex(ItemObject.KEY_ID)));
        holder.txtName.setText(cursor.getString(cursor.getColumnIndex(ItemObject.KEY_word)));
        holder.txtEmail.setText(cursor.getString(cursor.getColumnIndex(ItemObject.KEY_meaning)));



    }

    static class ViewHolder {
        TextView txtId;
        TextView txtName;
        TextView txtEmail;
    }
}