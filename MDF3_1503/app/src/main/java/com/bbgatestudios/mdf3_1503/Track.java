package com.bbgatestudios.mdf3_1503;

import android.os.Bundle;

/**
 * Created by John on 3/5/2015.
 */
public class Track {
    //	constants for field references
    public static final String TRACK_NAME = "track_name";
    public static final String TRACK_RESOURCE = "track_resource";
    public static final String TRACK_ARTIST = "track_artist";

    //	private fields
    private String trackName;
    private String trackResource;
    private String trackArtist;

    //	getters and setters
    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public String getTrackResource() {
        return trackResource;
    }

    public void setTrackResource(String trackResource) {
        this.trackResource = trackResource;
    }

    public String getTrackArtist() {
        return trackArtist;
    }

    public void setTrackArtist(String trackArtist) {
        this.trackArtist = trackArtist;
    }

    //	Used when creating the data object
    public Track(String id, String trackResource, String trackArtist) {
        this.trackName = id;
        this.trackResource = trackResource;
        this.trackArtist = trackArtist;
    }

    //	Create from a bundle
    public Track(Bundle b) {
        if (b != null) {
            this.trackName = b.getString(TRACK_NAME);
            this.trackResource = b.getString(TRACK_RESOURCE);
            this.trackArtist = b.getString(TRACK_ARTIST);
        }
    }

    //	Package data for transfer between activities
    public Bundle toBundle() {
        Bundle b = new Bundle();
        b.putString(TRACK_NAME, this.trackName);
        b.putString(TRACK_RESOURCE, this.trackResource);
        b.putString(TRACK_ARTIST, this.trackArtist);
        return b;
    }

    //	Output song data
    @Override
    public String toString() {
        return trackName;
    }
}
