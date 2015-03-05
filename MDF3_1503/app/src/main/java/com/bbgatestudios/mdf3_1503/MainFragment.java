///////////////////////////////
/////John Brandenburg/////////
//////////MDF3 1503///////////

package com.bbgatestudios.mdf3_1503;

import android.app.Fragment;
import android.app.ListFragment;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by john_brandenburg on 3/3/15.
 */
public class MainFragment extends ListFragment {

    List<Track> songs = new TrackData().getTracks();
    private SongListener sListener;

    public interface SongListener{
        public void startService();
        public ArrayList<Track> getSongs();
    }

    public MainFragment(){
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TrackArrayAdapter adapter = new TrackArrayAdapter(getActivity(),
                R.layout.track_list_item,
                songs);
        setListAdapter(adapter);

        MediaPlayer player = new MediaPlayer();
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState){

        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        return rootView;
    }
}
