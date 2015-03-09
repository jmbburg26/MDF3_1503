///////////////////////////////
/////John Brandenburg/////////
//////////MDF3 1503///////////

package com.bbgatestudios.mdf3_1503;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.widget.Toast;

import java.io.IOException;

/**
 * Created by John on 3/6/2015.
 */
public class AudioService extends Service {

    public class AudioServiceBinder extends Binder {
        public AudioService getService() {
            return AudioService.this;
        }
    }

    private static final int FOREGROUND_NOTIFICATION = 0x01001;
    private static final String SAVE_POSITION = "MainActivity.SAVE_POSITION";

    MediaPlayer mPlayer;
    boolean mActivityResumed;
    boolean mPrepared;
    int mAudioPosition;

    public void onCreate() {

        super.onCreate();
        Toast.makeText(this, "Service Created", Toast.LENGTH_SHORT).show();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        NotificationManager mgr =
                (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);

        Notification.Builder builder = new Notification.Builder(this);
        builder.setSmallIcon(R.drawable.message_outline);
        builder.setContentTitle("Playing Music");
        builder.setContentText("Blah Blah Song Playing");
        builder.setAutoCancel(false);
        builder.setOngoing(true);

        startForeground(FOREGROUND_NOTIFICATION, builder.build());

        mPlayer.start();

        Toast.makeText(this, "Service Started", Toast.LENGTH_SHORT).show();
        return Service.START_NOT_STICKY;
    }

    protected void onStart() {

        if(mPlayer == null) {

            mPlayer = new MediaPlayer();
            mPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mPlayer.setOnPreparedListener((MediaPlayer.OnPreparedListener) this);

            try {
                mPlayer.setDataSource(this, Uri.parse("android.resource://" + getPackageName() + "/raw/menu_music"));
            } catch(IOException e) {
                e.printStackTrace();

                mPlayer.release();
                mPlayer = null;
            }
        }
    }


    protected void onStop() {

        mPlayer.stop();
        mPlayer.release();

        if(mPlayer != null && mPlayer.isPlaying()) {
            mPlayer.stop();
            mPrepared = false;
        }
    }

    protected void onSaveInstanceState(Bundle outState) {
        //super.onSaveInstanceState(outState);
        if(mPlayer != null) {
            outState.putInt(SAVE_POSITION, mPlayer.getCurrentPosition());
        }
    }

    @Override
    public void onDestroy() {
        mPlayer.stop();

        if(mPlayer != null) {
            mPlayer.release();
        }

        Toast.makeText(this, "Service Stopped", Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }

    public void onPrepared(MediaPlayer mp) {
        mPrepared = true;

        if(mPlayer != null && mActivityResumed) {
            mPlayer.seekTo(mAudioPosition);
        }
    }

    protected void onResume() {

        mActivityResumed = true;
        if(mPlayer != null && !mPrepared) {
            mPlayer.prepareAsync();
        } else if(mPlayer != null && mPrepared) {
            mPlayer.seekTo(mAudioPosition);
            mPlayer.start();
        }
    }

    protected void onPause() {
        mActivityResumed = false;

        if(mPlayer != null && mPlayer.isPlaying()) {
            mPlayer.pause();
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return new AudioServiceBinder();
    }

    public void showToast() {
        Toast.makeText(this, "Practice text!", Toast.LENGTH_SHORT).show();
    }
}
