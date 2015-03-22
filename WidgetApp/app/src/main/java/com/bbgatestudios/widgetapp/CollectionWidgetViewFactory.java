///////////////////////////////
/////John Brandenburg/////////
//////////MDF3 1502///////////

package com.bbgatestudios.widgetapp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService.RemoteViewsFactory;

public class CollectionWidgetViewFactory implements RemoteViewsFactory {
	
	private static final int ID_CONSTANT = 0x0101010;
	
	private ArrayList<Contact> mContactDataList;
	private Context mContext;
	
	public CollectionWidgetViewFactory(Context context) {
		mContext = context;
		mContactDataList = new ArrayList<Contact>();
	}

	@Override
	public void onCreate() {
        mContactDataList = new ArrayList<Contact>();
        mContactDataList.add(new Contact("John", "Brandenburg", "jmbburg26@gmail.com", "619-750-2219"));
        mContactDataList.add(new Contact("Amanda", "Brandenburg", "mrsjmbburg@gmail.com", "619-2458-9854"));
        mContactDataList.add(new Contact("Douglas", "Brandenburg", "papabnsd@gmail.com", "586-350-6021"));
	}

	@Override
	public int getCount() {
		return mContactDataList.size();
	}

	@Override
	public long getItemId(int position) {
		return ID_CONSTANT + position;
	}

	@Override
	public RemoteViews getLoadingView() {
		return null;
	}

	@Override
	public RemoteViews getViewAt(int position) {
		
		Contact contact = mContactDataList.get(position);
		
		RemoteViews itemView = new RemoteViews(mContext.getPackageName(), R.layout.contact_item);
		
		itemView.setTextViewText(R.id.fname, contact.getFirst());
		itemView.setTextViewText(R.id.lname, contact.getLast());
		itemView.setTextViewText(R.id.email, contact.getEmail());
		
		Intent intent = new Intent();
		intent.putExtra(CollectionWidgetProvider.EXTRA_ITEM, contact);
		itemView.setOnClickFillInIntent(R.id.contact_item, intent);
		
		return itemView;
	}

	@Override
	public int getViewTypeCount() {
		return 1;
	}

	@Override
	public boolean hasStableIds() {
		return true;
	}

	@Override
	public void onDataSetChanged() {
		// Heavy lifting code can go here without blocking the UI.
		// You would update the data in your collection here as well.
	}

	@Override
	public void onDestroy() {
		mContactDataList.clear();
	}
}