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

import com.google.android.exoplayer.ExoPlayerLibraryInfo;

import android.os.Looper;
import android.text.TextUtils;

/**
 * Provides methods for asserting the truth of expressions and properties.
 */
public final class Assertions {

  private Assertions() {}

  /**
   * Ensures the truth of an expression involving one or more arguments passed to the calling
   * method.
   *
   * @param expression A boolean expression.
   * @throws IllegalArgumentException If {@code expression} is false.
   */
  public static void checkArgument(boolean expression) {
    if (ExoPlayerLibraryInfo.ASSERTIONS_ENABLED && !expression) {
      throw new IllegalArgumentException();
    }
  }
  public static String checkNotEmpty(String string) {
    if (ExoPlayerLibraryInfo.ASSERTIONS_ENABLED && TextUtils.isEmpty(string)) {
      throw new IllegalArgumentException();
    }
    return string;
  }
}
