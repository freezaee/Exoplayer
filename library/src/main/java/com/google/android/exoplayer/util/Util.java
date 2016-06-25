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

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * Miscellaneous utility functions.
 */
public final class Util {

  /**
   * Like {@link android.os.Build.VERSION#SDK_INT}, but in a place where it can be conveniently
   * overridden for local testing.
   */
  public static final int SDK_INT =
      (Build.VERSION.SDK_INT == 23 && Build.VERSION.CODENAME.charAt(0) == 'N') ? 24
      : Build.VERSION.SDK_INT;

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

  /**
   * Returns true if the URI is a path to a local file or a reference to a local file.
   *
   * @param uri The uri to test.
   */
  public static boolean isLocalFileUri(Uri uri) {
    String scheme = uri.getScheme();
    return TextUtils.isEmpty(scheme) || scheme.equals("file");
  }

  /**
   * Tests two objects for {@link Object#equals(Object)} equality, handling the case where one or
   * both may be null.
   *
   * @param o1 The first object.
   * @param o2 The second object.
   * @return {@code o1 == null ? o2 == null : o1.equals(o2)}.
   */
  public static boolean areEqual(Object o1, Object o2) {
    return o1 == null ? o2 == null : o1.equals(o2);
  }
  /**
   * Instantiates a new single threaded executor whose thread has the specified name.
   *
   * @param threadName The name of the thread.
   * @return The executor.
   */
  public static ExecutorService newSingleThreadExecutor(final String threadName) {
    return Executors.newSingleThreadExecutor(new ThreadFactory() {
      @Override
      public Thread newThread(Runnable r) {
        return new Thread(r, threadName);
      }
    });
  }


  /**
   * Returns a user agent string based on the given application name and the library version.
   *
   * @param context A valid context of the calling application.
   * @param applicationName String that will be prefix'ed to the generated user agent.
   * @return A user agent string generated using the applicationName and the library version.
   */
  public static String getUserAgent(Context context, String applicationName) {
    String versionName;
    try {
      String packageName = context.getPackageName();
      PackageInfo info = context.getPackageManager().getPackageInfo(packageName, 0);
      versionName = info.versionName;
    } catch (NameNotFoundException e) {
      versionName = "?";
    }
    return applicationName + "/" + versionName + " (Linux;Android " + Build.VERSION.RELEASE
        + ") " + "ExoPlayerLib/" + ExoPlayerLibraryInfo.VERSION;
  }

  /**
   * Makes a best guess to infer the type from a file name.
   *
   * @param fileName Name of the file. It can include the path of the file.
   * @return One of {@link #TYPE_DASH}, {@link #TYPE_SS}, {@link #TYPE_HLS} or {@link #TYPE_OTHER}.
   */
  public static int inferContentType(String fileName) {
    if (fileName == null) {
      return TYPE_OTHER;
    } else if (fileName.endsWith(".mpd")) {
      return TYPE_DASH;
    } else if (fileName.endsWith(".ism")) {
      return TYPE_SS;
    } else if (fileName.endsWith(".m3u8")) {
      return TYPE_HLS;
    } else {
      return TYPE_OTHER;
    }
  }
}
