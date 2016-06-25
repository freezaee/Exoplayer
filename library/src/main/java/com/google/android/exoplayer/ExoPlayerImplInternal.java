/*
 * Copyright (C) 2014 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.android.exoplayer;

import com.google.android.exoplayer.ExoPlayer.ExoPlayerComponent;
import com.google.android.exoplayer.util.PriorityHandlerThread;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Process;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Implements the internal behavior of {@link ExoPlayerImpl}.
 */
/* package */ final class ExoPlayerImplInternal implements Handler.Callback {

  private static final String TAG = "ExoPlayerImplInternal";

  private final Handler handler;
  private final HandlerThread internalPlaybackThread;
  private final Handler eventHandler;
  private final StandaloneMediaClock standaloneMediaClock;
  private final AtomicInteger pendingSeekCount;
  private final List<TrackRenderer> enabledRenderers;
  private final MediaFormat[][] trackFormats;
  private final int[] selectedTrackIndices;
  private final long minBufferUs;
  private final long minRebufferUs;

  private boolean playWhenReady;
  private int state;
  private long lastSeekPositionMs;

  private volatile long durationUs;
  private volatile long positionUs;
  private volatile long bufferedPositionUs;

  public ExoPlayerImplInternal(Handler eventHandler, boolean playWhenReady,
      int[] selectedTrackIndices, int minBufferMs, int minRebufferMs) {
    this.eventHandler = eventHandler;
    this.playWhenReady = playWhenReady;
    this.minBufferUs = minBufferMs * 1000L;
    this.minRebufferUs = minRebufferMs * 1000L;
    this.selectedTrackIndices = Arrays.copyOf(selectedTrackIndices, selectedTrackIndices.length);
    this.state = ExoPlayer.STATE_IDLE;
    this.durationUs = TrackRenderer.UNKNOWN_TIME_US;
    this.bufferedPositionUs = TrackRenderer.UNKNOWN_TIME_US;

    standaloneMediaClock = new StandaloneMediaClock();
    pendingSeekCount = new AtomicInteger();
    enabledRenderers = new ArrayList<>(selectedTrackIndices.length);
    trackFormats = new MediaFormat[selectedTrackIndices.length][];
    // Note: The documentation for Process.THREAD_PRIORITY_AUDIO that states "Applications can
    // not normally change to this priority" is incorrect.
    internalPlaybackThread = new PriorityHandlerThread("ExoPlayerImplInternal:Handler",
        Process.THREAD_PRIORITY_AUDIO);
    internalPlaybackThread.start();
    handler = new Handler(internalPlaybackThread.getLooper(), this);
  }

  public Looper getPlaybackLooper() {
    return internalPlaybackThread.getLooper();
  }

  public long getCurrentPosition() {
    return pendingSeekCount.get() > 0 ? lastSeekPositionMs : (positionUs / 1000);
  }

  public long getBufferedPosition() {
    return bufferedPositionUs == TrackRenderer.UNKNOWN_TIME_US ? ExoPlayer.UNKNOWN_TIME
        : bufferedPositionUs / 1000;
  }

  public long getDuration() {
    return durationUs == TrackRenderer.UNKNOWN_TIME_US ? ExoPlayer.UNKNOWN_TIME
        : durationUs / 1000;
  }

  public void prepare(TrackRenderer... renderers) {
  }

  public void seekTo(long positionMs) {
  }

  public void stop() {
  }

  public void setRendererSelectedTrack(int rendererIndex, int trackIndex) {
  }

  public void sendMessage(ExoPlayerComponent target, int messageType, Object message) {
  }

  public synchronized void blockingSendMessage(ExoPlayerComponent target, int messageType,
      Object message) {
  }

  public synchronized void release() {
  }

  @Override
  public boolean handleMessage(Message msg) {
        return false;
    }
}
