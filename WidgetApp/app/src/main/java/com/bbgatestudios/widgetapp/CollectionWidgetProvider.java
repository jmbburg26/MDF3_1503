///////////////////////////////
/////John Brandenburg/////////
//////////MDF3 1502///////////
package com.bbgatestudios.widgetapp;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

public class CollectionWidgetProvider extends AppWidgetProvider {
	
	public static final String ACTION_VIEW_DETAILS = "com.bbgatestudios.ACTION_VIEW_DETAILS";
	public static final String EXTRA_ITEM = "com.bbgatestudios.CollectionWidgetProvider.EXTRA_ITEM";
	
	@Override
	public void onUpdate(Context context, AppWidgetManager appWidgetManager,
			int[] appWidgetIds) {
		
		for(int i = 0; i < appWidgetIds.length; i++) {
			
			int widgetId = appWidgetIds[i];
			
			Intent intent = new Intent(context, CollectionWidgetService.class);
			intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, widgetId);
			
			RemoteViews widgetView = new RemoteViews(context.getPackageName(), R.layout.widget_layout);
			widgetView.setRemoteAdapter(R.id.contact_list, intent);
			widgetView.setEmptyView(R.id.contact_list, R.id.empty);
			
			Intent detailIntent = new Intent(ACTION_VIEW_DETAILS);
			PendingIntent pIntent = PendingIntent.getBroadcast(context, 0, detailIntent, PendingIntent.FLAG_UPDATE_CURRENT);
			widgetView.setPendingIntentTemplate(R.id.contact_list, pIntent);
			
			appWidgetManager.updateAppWidget(widgetId, widgetView);
		}
		
		super.onUpdate(context, appWidgetManager, appWidgetIds);
	}
	
	@Override
	public void onReceive(Context context, Intent intent) {
		
		if(intent.getAction().equals(ACTION_VIEW_DETAILS)) {
			Contact contact = (Contact)intent.getSerializableExtra(EXTRA_ITEM);
			if(contact != null) {
				Intent details = new Intent(context, DetailActivity.class);
				details.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				details.putExtra(DetailActivity.EXTRA_ITEM, contact);
				context.startActivity(details);
			}
		}
		
		super.onReceive(context, intent);
	}
}