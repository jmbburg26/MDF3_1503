package com.bbgatestudios.mdf3_1503;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by John on 3/5/2015.
 */
public class TrackData {
    private List<Track> track = new ArrayList<Track>();
    public List<Track> getTracks() {
        return track;
    }

    public TrackData() {
        track.add(new Track("Another Day Of Grace", "/raw/grace", "Glorious Gospel"));
        track.add(new Track("Someday", "/raw/someday", "Glorious Gospel"));
        track.add(new Track("I Stand In Awe", "/raw/stand_in_awe", "Glorious Gospel"));
    }
}
