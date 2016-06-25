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
/**
 * Renders a single component of media.
 *
 * <p>Internally, a renderer's lifecycle is managed by the owning {@link ExoPlayer}. The player
 * will transition its renderers through various states as the overall playback state changes. The
 * valid state transitions are shown below, annotated with the methods that are invoked during each
 * transition.
 * <p align="center"><img src="../../../../../images/trackrenderer_state.png"
 *     alt="TrackRenderer state transitions"
 *     border="0"/></p>
 */
public abstract class TrackRenderer implements ExoPlayerComponent {

  /**
   * Represents an unknown time or duration. Equal to {@link C#UNKNOWN_TIME_US}.
   */
  public static final long UNKNOWN_TIME_US = C.UNKNOWN_TIME_US; // -1
}
