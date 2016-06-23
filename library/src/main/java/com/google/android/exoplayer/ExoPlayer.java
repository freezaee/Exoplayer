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

import android.os.Looper;

/**
 * An extensible media player exposing traditional high-level media player functionality, such as
 * the ability to prepare, play, pause and seek.
 *
 * <p>Topics covered here are:
 * <ol>
 * <li><a href="#Assumptions">Assumptions and player composition</a>
 * <li><a href="#Threading">Threading model</a>
 * <li><a href="#State">Player state</a>
 * </ol>
 *
 * <a name="Assumptions"></a>
 * <h3>Assumptions and player construction</h3>
 *
 * <p>The implementation is designed to make no assumptions about (and hence impose no restrictions
 * on) the type of the media being played, how and where it is stored, or how it is rendered.
 * Rather than implementing the loading and rendering of media directly, {@link ExoPlayer} instead
 * delegates this work to one or more {@link TrackRenderer}s, which are injected when the player
 * is prepared. Hence {@link ExoPlayer} is capable of loading and playing any media for which a
 * {@link TrackRenderer} implementation can be provided.
 *
 * <p>{@link MediaCodecAudioTrackRenderer} and {@link MediaCodecVideoTrackRenderer} can be used for
 * the common cases of rendering audio and video. These components in turn require an
 * <i>upstream</i> {@link SampleSource} to be injected through their constructors, where upstream
 * is defined to denote a component that is closer to the source of the media. This pattern of
 * upstream dependency injection is actively encouraged, since it means that the functionality of
 * the player is built up through the composition of components that can easily be exchanged for
 * alternate implementations. For example a {@link SampleSource} implementation may require a
 * further upstream data loading component to be injected through its constructor, with different
 * implementations enabling the loading of data from various sources.
 *
 * <a name="Threading"></a>
 * <h3>Threading model</h3>
 *
 * <p>The figure below shows the {@link ExoPlayer} threading model.</p>
 * <p align="center"><img src="../../../../../images/exoplayer_threading_model.png"
 *     alt="MediaPlayer state diagram"
 *     border="0"/></p>
 *
 * <ul>
 * <li>It is recommended that instances are created and accessed from a single application thread.
 * An application's main thread is ideal. Accessing an instance from multiple threads is
 * discouraged, however if an application does wish to do this then it may do so provided that it
 * ensures accesses are synchronized.
 * </li>
 * <li>Registered {@link Listener}s are invoked on the thread that created the {@link ExoPlayer}
 * instance.</li>
 * <li>An internal playback thread is responsible for managing playback and invoking the
 * {@link TrackRenderer}s in order to load and play the media.</li>
 * <li>{@link TrackRenderer} implementations (or any upstream components that they depend on) may
 * use additional background threads (e.g. to load data). These are implementation specific.</li>
 * </ul>
 *
 * <a name="State"></a>
 * <h3>Player state</h3>
 *
 * <p>The components of an {@link ExoPlayer}'s state can be divided into two distinct groups. State
 * accessed by {@link #getSelectedTrack(int)} and {@link #getPlayWhenReady()} is only ever
 * changed by invoking the player's methods, and are never changed as a result of operations that
 * have been performed asynchronously by the playback thread. In contrast, the playback state
 * accessed by {@link #getPlaybackState()} is only ever changed as a result of operations
 * completing on the playback thread, as illustrated below.</p>
 * <p align="center"><img src="../../../../../images/exoplayer_state.png"
 *     alt="ExoPlayer state"
 *     border="0"/></p>
 *
 * <p>The possible playback state transitions are shown below. Transitions can be triggered either
 * by changes in the state of the {@link TrackRenderer}s being used, or as a result of
 * {@link #prepare(TrackRenderer[])}, {@link #stop()} or {@link #release()} being invoked.</p>
 * <p align="center"><img src="../../../../../images/exoplayer_playbackstate.png"
 *     alt="ExoPlayer playback state transitions"
 *     border="0"/></p>
 */
public interface ExoPlayer {

  /**
   * The player is neither prepared or being prepared.
   */
  public static final int STATE_IDLE = 1;
  /**
   * The player is being prepared.
   */
  public static final int STATE_PREPARING = 2;
  /**
   * The player is prepared but not able to immediately play from the current position. The cause
   * is {@link TrackRenderer} specific, but this state typically occurs when more data needs
   * to be buffered for playback to start.
   */
  public static final int STATE_BUFFERING = 3;
  /**
   * The player is prepared and able to immediately play from the current position. The player will
   * be playing if {@link #getPlayWhenReady()} returns true, and paused otherwise.
   */
  public static final int STATE_READY = 4;
  /**
   * The player has finished playing the media.
   */
  public static final int STATE_ENDED = 5;

}
