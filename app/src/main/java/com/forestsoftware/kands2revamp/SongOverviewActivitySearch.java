package com.forestsoftware.kands2revamp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.TypedValue;
import android.view.Menu;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Created by ADEOY3 on 10/31/2016.
 */

public class SongOverviewActivitySearch extends AppCompatActivity
{

    String word;
    String meaning;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        Utils.setThemeToActivity(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song_overview_activity);

        getSupportActionBar().setTitle("Song Overview");




        final TextView showSong = (TextView) findViewById(R.id.textView2);
        final TextView title = (TextView) findViewById(R.id.textView);
        final LinearLayout lin = (LinearLayout) findViewById(R.id.overview);
        final ScrollView scroll = (ScrollView) findViewById(R.id.the_Scroll);

        Intent intent = getIntent();
        //Bundle bundle = intent.getExtras();

        word = intent.getStringExtra("word");
        meaning = intent.getStringExtra("meaning");

       // title.setText(word);
        //showSong.setText(meaning);



        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        String getFontSizeName = sharedPreferences.getString("example_list","Medium");
        switch (getFontSizeName)
        {
            case "Small":
                showSong.setTextSize(TypedValue.COMPLEX_UNIT_PX,30);
                title.setTextSize(TypedValue.COMPLEX_UNIT_PX,30);

               // Toast.makeText(getApplicationContext(),"Value selected is "+getFontSizeName,Toast.LENGTH_SHORT).show();
                break;

            case "Medium":
                showSong.setTextSize(TypedValue.COMPLEX_UNIT_PX,60);
                title.setTextSize(TypedValue.COMPLEX_UNIT_PX,60);
              //  Toast.makeText(getApplicationContext(),"Value selected is "+getFontSizeName,Toast.LENGTH_SHORT).show();
                break;
            case "Large":
                showSong.setTextSize(TypedValue.COMPLEX_UNIT_PX,100);
                title.setTextSize(TypedValue.COMPLEX_UNIT_PX,100);
               // Toast.makeText(getApplicationContext(),"Value selected is "+getFontSizeName,Toast.LENGTH_SHORT).show();
                break;
        }
//
//
//
        String getTheTheme = sharedPreferences.getString("change_theme","");
        switch (getTheTheme)
        {

            case "White":
                showSong.setBackgroundColor(getResources().getColor(R.color.color_white));
                showSong.setTextColor(getResources().getColor(R.color.color_black));
                title.setBackgroundColor(getResources().getColor(R.color.color_white));
                title.setTextColor(getResources().getColor(R.color.color_black));
                lin.setBackgroundColor(getResources().getColor(R.color.color_white));
        //        getWindow().setNavigationBarColor(getResources().getColor(R.color.color_black));

                scroll.setBackgroundColor(getResources().getColor(R.color.color_white));
                break;

            case "Black":
                showSong.setBackgroundColor(getResources().getColor(R.color.color_black));
                showSong.setTextColor(getResources().getColor(R.color.color_white));
                title.setBackgroundColor(getResources().getColor(R.color.color_black));
                title.setTextColor(getResources().getColor(R.color.color_white));
                lin.setBackgroundColor(getResources().getColor(R.color.color_black));
                scroll.setBackgroundColor(getResources().getColor(R.color.color_black));


                break;
            case "Grey":
//                Utils.SIZE="DEFAULT";
                showSong.setBackgroundColor(getResources().getColor(R.color.colour_grey));
                showSong.setTextColor(getResources().getColor(R.color.color_black));
                title.setBackgroundColor(getResources().getColor(R.color.colour_grey));
                title.setTextColor(getResources().getColor(R.color.color_black));
                lin.setBackgroundColor(getResources().getColor(R.color.colour_grey));
                scroll.setBackgroundColor(getResources().getColor(R.color.colour_grey));
                break;



            case "Brown":
//                Utils.SIZE="DEFAULT";
                showSong.setBackgroundColor(getResources().getColor(R.color.colour_brown));
                showSong.setTextColor(getResources().getColor(R.color.color_white));
                title.setBackgroundColor(getResources().getColor(R.color.colour_brown));
                title.setTextColor(getResources().getColor(R.color.color_white));
                scroll.setBackgroundColor(getResources().getColor(R.color.colour_brown));
                lin.setBackgroundColor(getResources().getColor(R.color.colour_brown));
                break;
        }



        Typeface tx = Typeface.createFromAsset(getAssets(),"fonts/DroidSerif.ttf");
        Typeface t1 = Typeface.createFromAsset(getAssets(),"fonts/aristcr.ttf");
        Typeface t2 = Typeface.createFromAsset(getAssets(),"fonts/Bems.ttf");
        Typeface t3 = Typeface.createFromAsset(getAssets(),"fonts/DroidSerif.ttf");
        Typeface t4 = Typeface.createFromAsset(getAssets(),"fonts/Menbs.ttf");

        String getTheFont = sharedPreferences.getString("change_font","Sans Serif");
        switch (getTheFont)
        {
           // Typeface tx = Typeface.createFromAsset(getAssets(),"fonts/DroidSansFallback.ttf");
//            Typeface t1 = Typeface.createFromAsset(getAssets(),"fonts/aristcr.ttf");
//            Typeface t2 = Typeface.createFromAsset(getAssets(),"fonts/Bems.ttf");
//            Typeface t3 = Typeface.createFromAsset(getAssets(),"fonts/DroidSerif.ttf");
//            Typeface t4 = Typeface.createFromAsset(getAssets(),"fonts/Menbs.ttf");


            case "Aristic":
                showSong.setTypeface(t1);
                title.setTypeface(t1);
                break;

            case "Sans Serif":
                showSong.setTypeface(Typeface.SANS_SERIF);
                title.setTypeface(Typeface.SANS_SERIF);
                break;
            case "Monospace":
               showSong.setTypeface(Typeface.MONOSPACE);
                title.setTypeface(Typeface.MONOSPACE);
                break;

            case "Sans":
                showSong.setTypeface(Typeface.SERIF);
                title.setTypeface(Typeface.SERIF);
                break;
            case "Droid Serif":
                showSong.setTypeface(tx);
                title.setTypeface(tx);
                break;
            case "Menbs":
                    showSong.setTypeface(t4);
                title.setTypeface(t4);
               break;
        }


    }
    public float getTextSize(TextView textView)
    {
        return textView.getTextSize();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
       // getMenuInflater().inflate(R.menu.menu_song, menu);
        return true;
    }
    public TextView getShowSong()
    {
        final TextView showSong = (TextView) findViewById(R.id.textView2);
        return showSong;
    }
}