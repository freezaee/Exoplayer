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
package com.google.android.exoplayer.demo.player;

import com.google.android.exoplayer.dash.mpd.MediaPresentationDescription;
import com.google.android.exoplayer.dash.mpd.MediaPresentationDescriptionParser;
import com.google.android.exoplayer.dash.mpd.UtcTimingElement;
import com.google.android.exoplayer.dash.mpd.UtcTimingElementResolver.UtcTimingCallback;
import com.google.android.exoplayer.demo.player.DemoPlayer.RendererBuilder;
import com.google.android.exoplayer.drm.MediaDrmCallback;
import com.google.android.exoplayer.upstream.DefaultUriDataSource;
import com.google.android.exoplayer.upstream.UriDataSource;
import com.google.android.exoplayer.util.ManifestFetcher;
import android.content.Context;

import java.io.IOException;

/**
 * A {@link RendererBuilder} for DASH.
 */
public class DashRendererBuilder implements RendererBuilder {

  private static final String TAG = "DashRendererBuilder";

  private final Context context;
  private final String userAgent;
  private final String url;
  private final MediaDrmCallback drmCallback;

  private AsyncRendererBuilder currentAsyncBuilder;

  public DashRendererBuilder(Context context, String userAgent, String url,
      MediaDrmCallback drmCallback) {
    this.context = context;
    this.userAgent = userAgent;
    this.url = url;
    this.drmCallback = drmCallback;
  }

  @Override
  public void buildRenderers(DemoPlayer player) {
    currentAsyncBuilder = new AsyncRendererBuilder(context, userAgent, url, drmCallback, player);
    currentAsyncBuilder.init();
  }

    @Override
    public void cancel() {

    }

  private static final class AsyncRendererBuilder
      implements ManifestFetcher.ManifestCallback<MediaPresentationDescription>, UtcTimingCallback {

    private final Context context;
    private final String userAgent;
    private final MediaDrmCallback drmCallback;
    private final DemoPlayer player;
    private final ManifestFetcher<MediaPresentationDescription> manifestFetcher;
    private final UriDataSource manifestDataSource;


    public AsyncRendererBuilder(Context context, String userAgent, String url,
        MediaDrmCallback drmCallback, DemoPlayer player) {
      this.context = context;
      this.userAgent = userAgent;
      this.drmCallback = drmCallback;
      this.player = player;
      MediaPresentationDescriptionParser parser = new MediaPresentationDescriptionParser();
      manifestDataSource = new DefaultUriDataSource(context, userAgent);
      manifestFetcher = new ManifestFetcher<>(url, manifestDataSource, parser);
    }

    public void init() {
      manifestFetcher.singleLoad(player.getMainHandler().getLooper(), this);
    }
    @Override
    public void onSingleManifest(MediaPresentationDescription manifest) {

    }

    @Override
    public void onSingleManifestError(IOException e) {

    }

    @Override
    public void onTimestampResolved(UtcTimingElement utcTiming, long elapsedRealtimeOffset) {

    }

    @Override
    public void onTimestampError(UtcTimingElement utcTiming, IOException e) {

    }
  }

}
