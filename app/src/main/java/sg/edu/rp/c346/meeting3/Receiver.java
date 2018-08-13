package sg.edu.rp.c346.meeting3;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.widget.Toast;

/**
 * Created by 16020267 on 13/8/2018.
 */

public class Receiver extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        String advice = prefs.getString("option","None");
        Toast my_toast = Toast.makeText(context,advice, Toast.LENGTH_LONG);
        my_toast.show();
    }
}
