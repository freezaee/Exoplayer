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
package com.google.android.exoplayer.util;


import android.widget.TextView;

/**
 * A helper class for periodically updating debug information displayed by a {@link TextView}.
 */
public final class DebugTextViewHelper implements Runnable {

  /**
   * Provides debug information about an ongoing playback.
   */
  public interface Provider {

  }
  /**
   * @param debuggable The {@link Provider} from which debug information should be obtained.
   * @param textView The {@link TextView} that should be updated to display the information.
   */
  public DebugTextViewHelper(Provider debuggable, TextView textView) {
  }

  /**
   * Starts periodic updates of the {@link TextView}.
   * <p>
   * Should be called from the application's main thread.
   */
  public void start() {
  }

  /**
   * Stops periodic updates of the {@link TextView}.
   * <p>
   * Should be called from the application's main thread.
   */
  public void stop() {
  }

  @Override
  public void run() {
  }
}
