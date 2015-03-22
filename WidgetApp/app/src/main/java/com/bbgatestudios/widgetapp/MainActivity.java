///////////////////////////////
/////John Brandenburg/////////
//////////MDF3 1502///////////
package com.bbgatestudios.widgetapp;

import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;


public class MainActivity extends Activity implements MainFragment.ContactListener {

    private final String TAG = "MAINACTIVITY";

    public static final int ADD_REQUESTCODE = 1001;
    private static final String FILENAME = "contact_list.txt";

    public ArrayList<Contact> mContactDataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new MainFragment())
                    .commit();
        }

        mContactDataList = new ArrayList<Contact>();
        mContactDataList.add(new Contact("John", "Brandenburg", "jmbburg26@gmail.com", "619-750-2219"));
        mContactDataList.add(new Contact("Amanda", "Brandenburg", "mrsjmbburg@gmail.com", "619-2458-9854"));
        mContactDataList.add(new Contact("Douglas", "Brandenburg", "papabnsd@gmail.com", "586-350-6021"));

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_settings_add:
                //Use explicit intent to bring up the input form
                Intent intent = new Intent(this, FormActivity.class);
                startActivityForResult(intent, ADD_REQUESTCODE);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(resultCode == Activity.RESULT_OK && requestCode == ADD_REQUESTCODE){
            String first = data.getStringExtra("firstName");
            String last = data.getStringExtra("lastName");
            String email = data.getStringExtra("email");
            String phone = data.getStringExtra("phone");

            Log.v("data", first);
            Log.v("data", last);
            Log.v("data", email);
            Log.v("data", phone);

            mContactDataList.add(new Contact(first, last, email, phone));

            WriteFileActivity.writeToFile(this, FILENAME, String.valueOf(mContactDataList));
            MainFragment mf = (MainFragment) getFragmentManager().findFragmentById(R.id.container);
            mf.updateListData();
        }   else {
            Log.v("Error", "Something went wrong");
        }
    }

    @Override
    public void viewContact(int position){
        Intent detailIntent = new Intent(this, DetailActivity.class);
        detailIntent.putExtra(DetailActivity.CONTACTEXTRA, mContactDataList.get(position));
        startActivity(detailIntent);
    }

    @Override
    public ArrayList<Contact>getContacts(){
        return mContactDataList;
    }


}