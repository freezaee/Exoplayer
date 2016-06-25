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
package com.google.android.exoplayer.upstream;

import java.io.IOException;

/**
 * Manages the background loading of {@link Loadable}s.
 */
public final class Loader {
  /**
   * Interface definition of an object that can be loaded using a {@link Loader}.
   */
  public interface Loadable {

    /**
     * Cancels the load.
     */
    void cancelLoad();

    /**
     * Whether the load has been canceled.
     *
     * @return True if the load has been canceled. False otherwise.
     */
    boolean isLoadCanceled();

    /**
     * Performs the load, returning on completion or cancelation.
     *
     * @throws IOException
     * @throws InterruptedException
     */
    void load() throws IOException, InterruptedException;

  }

  /**
   * Interface definition for a callback to be notified of {@link Loader} events.
   */
  public interface Callback {

    /**
     * Invoked when loading has been canceled.
     *
     * @param loadable The loadable whose load has been canceled.
     */
    void onLoadCanceled(Loadable loadable);

    /**
     * Invoked when the data source has been fully loaded.
     *
     * @param loadable The loadable whose load has completed.
     */
    void onLoadCompleted(Loadable loadable);

    /**
     * Invoked when the data source is stopped due to an error.
     *
     * @param loadable The loadable whose load has failed.
     */
    void onLoadError(Loadable loadable, IOException exception);

  }
}
