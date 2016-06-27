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
package com.google.android.exoplayer.dash.mpd;

import com.google.android.exoplayer.upstream.Loader;
import com.google.android.exoplayer.upstream.UriDataSource;

import java.io.IOException;

/**
 * Resolves a {@link UtcTimingElement}.
 */
public final class UtcTimingElementResolver implements Loader.Callback {

  @Override
  public void onLoadCanceled(Loader.Loadable loadable) {

  }

  @Override
  public void onLoadCompleted(Loader.Loadable loadable) {

  }

  @Override
  public void onLoadError(Loader.Loadable loadable, IOException exception) {

  }

  /**
   * Callback for timing element resolution.
   */
  public interface UtcTimingCallback {

    /**
     * Invoked when the element has been resolved.
     *
     * @param utcTiming             The element that was resolved.
     * @param elapsedRealtimeOffset The offset between the resolved UTC time and
     *                              {@link SystemClock#elapsedRealtime()} in milliseconds, specified as the UTC time minus
     *                              the local elapsed time.
     */
    void onTimestampResolved(UtcTimingElement utcTiming, long elapsedRealtimeOffset);

    /**
     * Invoked when the element was not successfully resolved.
     *
     * @param utcTiming The element that was not resolved.
     * @param e         The cause of the failure.
     */
    void onTimestampError(UtcTimingElement utcTiming, IOException e);
  }

  /**
   * Resolves a {@link UtcTimingElement}.
   *
   * @param uriDataSource A source to use should loading from a URI be necessary.
   * @param timingElement The element to resolve.
   * @param timingElementElapsedRealtime The {@link SystemClock#elapsedRealtime()} timestamp at
   *     which the element was obtained. Used if the element contains a timestamp directly.
   * @param callback The callback to invoke on resolution or failure.
   */

  public static void resolveTimingElement(UriDataSource uriDataSource,
                                          UtcTimingElement timingElement, long timingElementElapsedRealtime,
                                          UtcTimingCallback callback) {
  }


}