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

import com.google.android.exoplayer.demo.player.DemoPlayer.RendererBuilder;
import com.google.android.exoplayer.drm.MediaDrmCallback;
import android.content.Context;

/**
 * A {@link RendererBuilder} for DASH.
 */
public class DashRendererBuilder implements RendererBuilder {
  public DashRendererBuilder(Context context, String userAgent, String url,
      MediaDrmCallback drmCallback) {
  }

    @Override
    public void buildRenderers(DemoPlayer player) {

    }

    @Override
    public void cancel() {

    }
}
