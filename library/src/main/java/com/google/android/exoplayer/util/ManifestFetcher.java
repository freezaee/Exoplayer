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

import com.google.android.exoplayer.upstream.Loader;
import com.google.android.exoplayer.upstream.Loader.Loadable;
import com.google.android.exoplayer.upstream.UriDataSource;
import com.google.android.exoplayer.upstream.UriLoadable;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;

import java.io.IOException;

/**
 * Performs both single and repeated loads of media manifests.
 * <p>
 * Client code is responsible for ensuring that only one load is taking place at any one time.
 * Typical usage of this class is as follows:
 * <ol>
 * <li>Create an instance.</li>
 * <li>Obtain an initial manifest by calling {@link #singleLoad(Looper, ManifestCallback)} and
 *     waiting for the callback to be invoked.</li>
 * <li>For on-demand playbacks, the loader is no longer required. For live playbacks, the loader
 *     may be required to periodically refresh the manifest. In this case it is injected into any
 *     components that require it. These components will call {@link #requestRefresh()} on the
 *     loader whenever a refresh is required.</li>
 * </ol>
 *
 * @param <T> The type of manifest.
 */
public class ManifestFetcher<T> implements Loader.Callback {

  /**
   * Interface definition for a callback to be notified of {@link ManifestFetcher} events.
   */
  public interface EventListener {

    public void onManifestRefreshStarted();

    public void onManifestRefreshed();

    public void onManifestError(IOException e);

  }

  /**
   * Callback for the result of a single load.
   *
   * @param <T> The type of manifest.
   */
  public interface ManifestCallback<T> {

    /**
     * Invoked when the load has successfully completed.
     *
     * @param manifest The loaded manifest.
     */
    void onSingleManifest(T manifest);

    /**
     * Invoked when the load has failed.
     *
     * @param e The cause of the failure.
     */
    void onSingleManifestError(IOException e);

  }


  private final UriLoadable.Parser<T> parser;
  private final UriDataSource uriDataSource;
  private final Handler eventHandler;
  private final EventListener eventListener;

  /* package */ volatile String manifestUri;

  /**
   * @param manifestUri The manifest location.
   * @param uriDataSource The {@link UriDataSource} to use when loading the manifest.
   * @param parser A parser to parse the loaded manifest data.
   */
  public ManifestFetcher(String manifestUri, UriDataSource uriDataSource,
      UriLoadable.Parser<T> parser) {
    this(manifestUri, uriDataSource, parser, null, null);
  }

  /**
   * @param manifestUri The manifest location.
   * @param uriDataSource The {@link UriDataSource} to use when loading the manifest.
   * @param parser A parser to parse the loaded manifest data.
   * @param eventHandler A handler to use when delivering events to {@code eventListener}. May be
   *     null if delivery of events is not required.
   * @param eventListener A listener of events. May be null if delivery of events is not required.
   */
  public ManifestFetcher(String manifestUri, UriDataSource uriDataSource,
      UriLoadable.Parser<T> parser, Handler eventHandler, EventListener eventListener) {
    this.parser = parser;
    this.manifestUri = manifestUri;
    this.uriDataSource = uriDataSource;
    this.eventHandler = eventHandler;
    this.eventListener = eventListener;
  }
  /**
   * Performs a single manifest load.
   *
   * @param callbackLooper The looper associated with the thread on which the callback should be
   *     invoked.
   * @param callback The callback to receive the result.
   */
  public void singleLoad(Looper callbackLooper, final ManifestCallback<T> callback) {
    SingleFetchHelper fetchHelper = new SingleFetchHelper(
        new UriLoadable<>(manifestUri, uriDataSource, parser), callbackLooper, callback);
    fetchHelper.startLoading();
  }
  @Override
  public void onLoadCanceled(Loadable loadable) {
    // Do nothing.
  }



  private class SingleFetchHelper implements Loader.Callback {

    private final UriLoadable<T> singleUseLoadable;
    private final Looper callbackLooper;
    private final ManifestCallback<T> wrappedCallback;
    private final Loader singleUseLoader;

    private long loadStartTimestamp;

    public SingleFetchHelper(UriLoadable<T> singleUseLoadable, Looper callbackLooper,
        ManifestCallback<T> wrappedCallback) {
      this.singleUseLoadable = singleUseLoadable;
      this.callbackLooper = callbackLooper;
      this.wrappedCallback = wrappedCallback;
      singleUseLoader = new Loader("manifestLoader:single");
    }

    public void startLoading() {
      loadStartTimestamp = SystemClock.elapsedRealtime();
      singleUseLoader.startLoading(callbackLooper, singleUseLoadable, this);
    }

    @Override
    public void onLoadCanceled(Loadable loadable) {
      
    }

    @Override
    public void onLoadCompleted(Loadable loadable) {

    }

    @Override
    public void onLoadError(Loadable loadable, IOException exception) {

    }
  }
    @Override
    public void onLoadCompleted(Loadable loadable) {

    }

    @Override
    public void onLoadError(Loadable loadable, IOException exception) {

    }
}
