package com.forestsoftware.kands2revamp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.preference.RingtonePreference;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toolbar;

import androidx.annotation.RequiresApi;

/**
 * @author appsrox.com
 */
public class SettingsActivity2 extends PreferenceActivity implements OnSharedPreferenceChangeListener {

//	private static final String TAG = "SettingsActivity";


    private static Preference.OnPreferenceChangeListener sBindPreferenceSummaryToValueListener = new Preference.OnPreferenceChangeListener() {
        @Override
        public boolean onPreferenceChange(Preference preference, Object value) {
            String stringValue = value.toString();

            if (preference instanceof ListPreference) {
                // For list preferences, look up the correct display value in
                // the preference's 'entries' list.
                ListPreference listPreference = (ListPreference) preference;
                int index = listPreference.findIndexOfValue(stringValue);

                // Set the summary to reflect the new value.
                preference.setSummary(index >= 0 ? listPreference.getEntries()[index] : null);

                //  Log.d("App RUn","Index value is "+index);

            } else if (preference instanceof RingtonePreference) {
                // For ringtone preferences, look up the correct display value
                // using RingtoneManager.
                if (TextUtils.isEmpty(stringValue)) {
                    // Empty values correspond to 'silent' (no ringtone).
                    preference.setSummary(R.string.pref_ringtone_silent);

                } else {
                    Ringtone ringtone = RingtoneManager.getRingtone(
                            preference.getContext(), Uri.parse(stringValue));

                    if (ringtone == null) {
                        // Clear the summary if there was a lookup error.
                        preference.setSummary(null);
                    } else {
                        // Set the summary to reflect the new ringtone display
                        // name.
                        String name = ringtone.getTitle(preference.getContext());
                        preference.setSummary(name);
                    }
                }

            } else {
                // For all other preferences, set the summary to the value's
                // simple string representation.
                preference.setSummary(stringValue);
            }
            return true;
        }
    };

    private static void bindPreferenceSummaryToValue(Preference preference) {
        // Set the listener to watch for value changes.

        preference.setOnPreferenceChangeListener(sBindPreferenceSummaryToValueListener);

        // Trigger the listener immediately with the preference's
        // current value.
        sBindPreferenceSummaryToValueListener.onPreferenceChange(preference,
                PreferenceManager
                        .getDefaultSharedPreferences(preference.getContext())
                        .getString(preference.getKey(), ""));
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.settings);
       // getListView().setBackgroundColor(getResources().getColor(R.color.color_black));

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        String getTheTheme = sharedPreferences.getString("change_theme", "white");
        switch (getTheTheme) {


            case "White":

                getListView().setBackgroundColor(getResources().getColor(R.color.color_white));
               setTheme(R.style.Black);


                break;

            case "Black":
                getListView().setBackgroundColor(getResources().getColor(R.color.color_black));
                setTheme(R.style.White);
                break;
            case "Grey":
                getListView().setBackgroundColor(getResources().getColor(R.color.colour_grey));
                setTheme(R.style.Black);
                break;


            case "Brown":
                getListView().setBackgroundColor(getResources().getColor(R.color.colour_brown));
                setTheme(R.style.White);
                break;
        }


    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {

        super.onPostCreate(savedInstanceState);

        Toolbar bar;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
            LinearLayout root = (LinearLayout) findViewById(android.R.id.list).getParent().getParent().getParent();
            bar = (Toolbar) LayoutInflater.from(this).inflate(R.layout.settings_toolbar, root, false);
            bar.setTitleTextColor(getResources().getColor(R.color.color_white));
            bar.setNavigationIcon(R.mipmap.ic_back);
//			bar.setNavigationOnClickListener(new View.OnClickListener() {
//				@Override
//				public void onClick(View view) {
//					Toast.makeText(getApplicationContext(),"come ooo",Toast.LENGTH_SHORT).show();
//				}
//			});
            root.addView(bar, 0); // insert at top
        } else {
            ViewGroup root = (ViewGroup) findViewById(android.R.id.content);
            ListView content = (ListView) root.getChildAt(0);

            root.removeAllViews();

            bar = (Toolbar) LayoutInflater.from(this).inflate(R.layout.settings_toolbar, root, false);


            int height;
            TypedValue tv = new TypedValue();
            if (getTheme().resolveAttribute(R.attr.actionBarSize, tv, true)) {
                height = TypedValue.complexToDimensionPixelSize(tv.data, getResources().getDisplayMetrics());
            } else {
                height = bar.getHeight();
            }

            content.setPadding(0, height, 0, 0);

            root.addView(content);
            root.addView(bar);
        }

        bar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Toast.makeText(getApplicationContext(), "come ooo", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(SettingsActivity2.this, MainActivity.class);
                startActivity(intent);

//				finish();
            }
        });

    }

    @Override
    public void onBackPressed() {
        //super.onResume();
//		getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
//		updatePreferences();
        //getApplicationContext().startActivity(new Intent(SettingsActivity2.this, MainActivity.class));
    }

    @Override
    protected void onResume() {
        super.onResume();
        getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
        updatePreferences();
    }

    @Override
    protected void onPause() {
        super.onPause();
        getPreferenceScreen().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        updatePreference(key);
    }

    private void updatePreferences() {
        //	updatePreference(OrinMe.SIZE_FORMAT);
    }

    private void updatePreference(String key) {
        Preference pref = findPreference(key);

        if (pref instanceof ListPreference) {
            ListPreference listPref = (ListPreference) pref;
            pref.setSummary(listPref.getEntry());
            return;
        }

/*		if (pref instanceof EditTextPreference){
			EditTextPreference editTextPreference =  (EditTextPreference) pref;
			if (editTextPreference.getText().trim().length() > 0){
				editTextPreference.setSummary("Entered Name is  " + editTextPreference.getText());
			}else{
				editTextPreference.setSummary("Enter Your Name");
			}
		}*/

//	    if (RemindMe.RINGTONE_PREF.equals(key)) {
//	    	Uri ringtoneUri = Uri.parse(RemindMe.getRingtone());
//	    	Ringtone ringtone = RingtoneManager.getRingtone(this, ringtoneUri);
//	        if (ringtone != null) pref.setSummary(ringtone.getTitle(this));
//	    }
    }

/*	@Override
	public boolean onPreferenceTreeClick(PreferenceScreen preferenceScreen, Preference preference) {
		
		if ("about_pref".equals(preference.getKey())) {
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setMessage("Your Message");
			builder.setPositiveButton("Close",
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int id) {
							// action on dialog close
						}
					});
			builder.show();
		}		
		
		return super.onPreferenceTreeClick(preferenceScreen, preference);
	}*/

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            Log.d(this.getClass().getName(), "back button pressed");
            //Toast.makeText(getApplicationContext(),"You press back",Toast.LENGTH_SHORT).show();
        }
        return super.onKeyDown(keyCode, event);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == android.R.id.home) {
            // Intent intent = new Intent(MainActivity.this, SearchActivity.class);
            //startActivity(intent);
           // onBackPressed();
         //   Toast.makeText(getApplicationContext(), "You press back", Toast.LENGTH_SHORT).show();

            return true;


        }


        return super.onOptionsItemSelected(item);
    }

}
