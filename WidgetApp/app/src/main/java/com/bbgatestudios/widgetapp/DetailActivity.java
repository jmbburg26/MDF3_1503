///////////////////////////////
/////John Brandenburg/////////
//////////MDF3 1502///////////

package com.bbgatestudios.widgetapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class DetailActivity extends Activity {

    private final String TAG = "DETAILACTIVITY";

    private Contact mContact;

    public static final String EXTRA_ITEM = "com.bbgatestudios.DetailsActivity.EXTRA_ITEM";
    public static final String CONTACTEXTRA = "com.bbgatestudios.widgetapp.Contact";

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        if (savedInstanceState == null){
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new DetailFragment())
                    .commit();
        }

        Intent detailIntent = getIntent();
        if (detailIntent != null){
            mContact = (Contact) detailIntent.getSerializableExtra(CONTACTEXTRA);
        }
    }


    public Contact getContact(){
        return mContact;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.detail_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

}