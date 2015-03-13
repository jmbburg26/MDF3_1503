///////////////////////////////
/////John Brandenburg/////////
//////////MDF3 1503///////////

package com.bbgatestudios.mdf3_1503;

import android.app.Fragment;
import android.app.ListFragment;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by john_brandenburg on 3/3/15.
 */
public class MainFragment extends Fragment{

    private static final int STANDARD_NOTIFICATION = 0x01001;
    private static final int EXPANDED_NOTIFICATION = 0x01002;

    private NotificationManager mManager;

    public MainFragment(){
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState){


        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        final Button playButton = (Button) rootView.findViewById(R.id.play_button);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playClicked(v);
            }
        });
        return rootView;
    }

    public void playClicked(View v){
        onStart();

        Notification.Builder builder = new Notification.Builder(getActivity());
        builder.setSmallIcon(R.drawable.message_outline);
        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.message_outline));
        builder.setContentTitle("Standard Title");
        builder.setContentText("Standard Message");
        builder.setAutoCancel(true);
        mManager.notify(STANDARD_NOTIFICATION, builder.build());
    }
}