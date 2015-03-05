package com.bbgatestudios.mdf3_1503;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by John on 3/5/2015.
 */
public class TrackArrayAdapter extends ArrayAdapter<Track> {
    private Context context;
    private List<Track> trackObjects;

    public TrackArrayAdapter (Context context, int resource, List<Track> objects) {
        super(context, resource, objects);
        this.context = context;
        this.trackObjects = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Track track = trackObjects.get(position);

        LayoutInflater inflater =
                (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.track_list_item, null);

        TextView song_name = (TextView) view.findViewById(R.id.trackArtist);
        song_name.setText(track.getTrackArtist());

        TextView song_title = (TextView) view.findViewById(R.id.trackTitle);
        song_title.setText(track.getTrackName());

        return view;
    }
}
