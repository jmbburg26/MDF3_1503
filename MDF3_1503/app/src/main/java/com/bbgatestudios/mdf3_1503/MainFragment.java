///////////////////////////////
/////John Brandenburg/////////
//////////MDF3 1503///////////

package com.bbgatestudios.mdf3_1503;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by john_brandenburg on 3/3/15.
 */
public class MainFragment extends ListFragment {

    public MainFragment(){
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        SongArrayAdapter adapter = new SongArrayAdapter(getActivity(),
//                R.layout.song_list_item,
//                songs);
//        setListAdapter(adapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState){

        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        return rootView;
    }
}
