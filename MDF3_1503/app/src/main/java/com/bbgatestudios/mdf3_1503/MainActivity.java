///////////////////////////////
/////John Brandenburg/////////
//////////MDF3 1503///////////

package com.bbgatestudios.mdf3_1503;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity implements ServiceConnection{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainFragment frag = new MainFragment();
        getFragmentManager().beginTransaction()
                .add(R.id.myContainer, frag)
                .commit();


    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();


    }

    @Override
    protected void onStop() {
        super.onStop();

        //unbindService(this);
    }

    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        AudioService.AudioServiceBinder binder = (AudioService.AudioServiceBinder)service;
        AudioService myService = binder.getService();
        myService.showToast();
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {

    }
}
