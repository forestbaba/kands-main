package com.forestsoftware.kands2revamp;

import android.os.Build;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Created by Adeoy3 on 7/12/2017.
 */

//public class xplain {xplain
//}
public class xplain extends AppCompatActivity
{

    final TextView showSong = (TextView) findViewById(R.id.textView2);
    final TextView title = (TextView) findViewById(R.id.textView);
    final LinearLayout lin = (LinearLayout) findViewById(R.id.overview);
    final ScrollView scroll = (ScrollView) findViewById(R.id.the_Scroll);


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Utils.setThemeToActivity(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song_overview_activity);

        Bundle extra = getIntent().getExtras();
        String xt = extra.getString("DIC");

        showSong.setText(xt);




    }}