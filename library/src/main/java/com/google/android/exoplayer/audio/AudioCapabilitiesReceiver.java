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
package com.google.android.exoplayer.audio;

import android.content.Context;

/**
 * Notifies a listener when the audio playback capabilities change. Call {@link #register} to start
 * (or resume) receiving notifications, and {@link #unregister} to stop.
 */
public final class AudioCapabilitiesReceiver {

  /**
   * Listener notified when audio capabilities change.
   */
  public interface Listener {

    /**
     * Called when the audio capabilities change.
     *
     * @param audioCapabilities Current audio capabilities for the device.
     */
    void onAudioCapabilitiesChanged(AudioCapabilities audioCapabilities);

  }


  /**
   * Constructs a new audio capabilities receiver.
   *
   * @param context Context for registering to receive broadcasts.
   * @param listener Listener to notify when audio capabilities change.
   */
  public AudioCapabilitiesReceiver(Context context, Listener listener) {
  }
  public AudioCapabilities register() {
    return null;
  }

  /**
   * Unregisters to stop notifying the listener when audio capabilities change.
   */
  public void unregister() {
  }
}
