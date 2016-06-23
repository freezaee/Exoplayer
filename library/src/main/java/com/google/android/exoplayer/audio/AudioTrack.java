package com.google.android.exoplayer.audio;

/**
 * Created by Elvis.He on 2016/6/23.
 */
public final class AudioTrack {

  /**
   * Thrown when a failure occurs instantiating an {@link android.media.AudioTrack}.
   */
  public static final class InitializationException extends Exception {
  }

  /**
   * Thrown when a failure occurs writing to an {@link android.media.AudioTrack}.
   */
  public static final class WriteException extends Exception {
  }
}
