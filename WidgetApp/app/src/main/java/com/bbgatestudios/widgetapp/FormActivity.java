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
import android.widget.EditText;


public class FormActivity extends Activity {
    EditText fName;
    EditText lName;
    EditText eMail;
    EditText pHone;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_add);

        getActionBar().setDisplayHomeAsUpEnabled(true);

        fName   = (EditText)findViewById(R.id.form_add_fname);
        lName   = (EditText)findViewById(R.id.form_add_lnamne);
        eMail  = (EditText)findViewById(R.id.form_add_email);
        pHone = (EditText)findViewById(R.id.form_add_number);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.form_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.saveButton:
//                Log.v("FistNameText", fName.getText().toString());
//                Log.v("LastNameText", lName.getText().toString());
//                Log.v("EmailText", eMail.getText().toString());
//                Log.v("EmailText", pHone.getText().toString());

                Contact contact = new Contact();
                contact.setFirst(fName.getText().toString());
                contact.setLast(lName.getText().toString());
                contact.setEmail(eMail.getText().toString());
                contact.setPhone(pHone.getText().toString());

                addToList(contact);
                break;
            case R.id.cancelButton:
                Intent cancelIntent = new Intent (this, MainActivity.class);
                Log.v("CancelText", "Add contact has been cancelled");
                startActivity(cancelIntent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void addToList(Contact contact){
        Intent intent = new Intent();
        intent.putExtra("firstName", contact.getFirst());
        intent.putExtra("lastName", contact.getLast());
        intent.putExtra("email", contact.getEmail());
        intent.putExtra("phone", contact.getPhone());

        setResult(RESULT_OK, intent);
        finish();
    }
}

