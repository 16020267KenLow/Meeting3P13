package sg.edu.rp.c346.meeting3;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    BroadcastReceiver br = new Receiver();
    RadioButton rb1;
    RadioButton rb2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        filter.addAction("android.intent.action.WALLPAPER_CHANGED");
        this.registerReceiver(br, filter);

        rb1 = findViewById(R.id.radioButton);
        rb2 = findViewById(R.id.radioButton2);
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor prefEdit = prefs.edit();
        if(rb1.isChecked()){

            prefEdit.putString("option" ,getString(R.string.first) );
        }
        if(rb2.isChecked()){
            prefEdit.putString("option" ,getString(R.string.second) );
        }
        prefEdit.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String advice = prefs.getString("option","None");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
