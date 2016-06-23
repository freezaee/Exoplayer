package com.google.android.exoplayer.util;

import android.text.TextUtils;

import com.google.android.exoplayer.ExoPlayerLibraryInfo;

/**
 * Created by Elvis.He on 2016/6/23.
 */
public class Assertions {
  public static String checkNotEmpty(String string) {
    if (ExoPlayerLibraryInfo.ASSERTIONS_ENABLED && TextUtils.isEmpty(string)) {
      throw new IllegalArgumentException();
    }
    return string;
  }
}
