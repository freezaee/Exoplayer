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


/**
 * Miscellaneous utility functions.
 */
public final class Util {
  /**
   * Value returned by {@link #inferContentType(String)} for DASH manifests.
   */
  public static final int TYPE_DASH = 0;

  /**
   * Value returned by {@link #inferContentType(String)} for Smooth Streaming manifests.
   */
  public static final int TYPE_SS = 1;

  /**
   * Value returned by {@link #inferContentType(String)} for HLS manifests.
   */
  public static final int TYPE_HLS = 2;

  /**
   * Value returned by {@link #inferContentType(String)} for files other than DASH, HLS or Smooth
   * Streaming manifests.
   */
  public static final int TYPE_OTHER = 3;

}
