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
package com.google.android.exoplayer.demo;

import android.annotation.TargetApi;
import android.media.MediaDrm;

import com.google.android.exoplayer.drm.MediaDrmCallback;

import java.util.UUID;

/**
 * A {@link MediaDrmCallback} for Widevine test content.
 */
@TargetApi(18)
public class WidevineTestMediaDrmCallback implements MediaDrmCallback {
  public WidevineTestMediaDrmCallback(String contentId, String provider) {
  }

  @Override
  public byte[] executeProvisionRequest(UUID uuid, MediaDrm.ProvisionRequest request) throws Exception {
    return new byte[0];
  }

  @Override
  public byte[] executeKeyRequest(UUID uuid, MediaDrm.KeyRequest request) throws Exception {
    return new byte[0];
  }
}
