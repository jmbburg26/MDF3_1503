///////////////////////////////
/////John Brandenburg/////////
//////////MDF3 1502///////////

package com.bbgatestudios.widgetapp;

import android.content.Intent;
import android.widget.RemoteViewsService;

public class CollectionWidgetService extends RemoteViewsService {

	@Override
	public RemoteViewsFactory onGetViewFactory(Intent intent) {
		return new CollectionWidgetViewFactory(getApplicationContext());
	}
}