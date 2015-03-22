///////////////////////////////
/////John Brandenburg/////////
//////////MDF3 1502///////////

package com.bbgatestudios.widgetapp;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class MainFragment extends Fragment{
    private final String TAG = "MAINFRAGMENT";

    private ContactListener mListener;
    private static ListView contactListView;
    private static ContactAdapter contactAdapter;

    public interface ContactListener{
        public void viewContact(int position);
        public ArrayList<Contact> getContacts();
    }



    public MainFragment(){
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public void onAttach(Activity activity){
        super.onAttach(activity);

        if (activity instanceof ContactListener){
            mListener = (ContactListener) activity;
        }else {
            throw new IllegalArgumentException("Containing activity must implement DetailListener interface");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        contactListView = (ListView) getView().findViewById(R.id.list);
        contactAdapter = new ContactAdapter(getActivity(), mListener.getContacts());
        contactListView.setAdapter(contactAdapter);
    }

    public void updateListData(){
        ListView contactList = (ListView) getView().findViewById(R.id.list);
        BaseAdapter contactAdapter = (BaseAdapter) contactList.getAdapter();
        contactAdapter.notifyDataSetChanged();
    }
}