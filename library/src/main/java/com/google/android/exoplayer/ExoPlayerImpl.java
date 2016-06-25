package com.google.android.exoplayer;

/**
 * Created by Elvis.He on 2016/6/25.
 */
public class ExoPlayerImpl implements ExoPlayer {
    public ExoPlayerImpl(int rendererCount, int minBufferMs, int minRebufferMs) {

    }

    @Override
    public void addListener(Listener listener) {

    }

    @Override
    public int getPlaybackState() {
        return 0;
    }

    @Override
    public int getTrackCount(int rendererIndex) {
        return 0;
    }

    @Override
    public MediaFormat getTrackFormat(int rendererIndex, int trackIndex) {
        return null;
    }

    @Override
    public void setSelectedTrack(int rendererIndex, int trackIndex) {

    }

    @Override
    public int getSelectedTrack(int rendererIndex) {
        return 0;
    }

    @Override
    public void setPlayWhenReady(boolean playWhenReady) {

    }

    @Override
    public boolean getPlayWhenReady() {
        return false;
    }

    @Override
    public void seekTo(long positionMs) {

    }

    @Override
    public void stop() {

    }

    @Override
    public void release() {

    }

    @Override
    public void sendMessage(ExoPlayerComponent target, int messageType, Object message) {

    }

    @Override
    public void blockingSendMessage(ExoPlayerComponent target, int messageType, Object message) {

    }

    @Override
    public long getDuration() {
        return 0;
    }

    @Override
    public long getCurrentPosition() {
        return 0;
    }

    @Override
    public long getBufferedPosition() {
        return 0;
    }

    @Override
    public int getBufferedPercentage() {
        return 0;
    }
}
