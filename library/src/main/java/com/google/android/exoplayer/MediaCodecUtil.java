package com.google.android.exoplayer;

import java.io.IOException;

/**
 * Created by Elvis.He on 2016/6/23.
 */
public class MediaCodecUtil {
  private static DecoderInfo passthroughDecoderInfo;

  public static DecoderInfo getDecoderInfo(String mimeType, boolean requiresSecureDecoder) {
    return null;
  }

  public static DecoderInfo getPassthroughDecoderInfo() {
    return passthroughDecoderInfo;
  }

  public static class DecoderQueryException extends IOException {

    private DecoderQueryException(Throwable cause) {
      super("Failed to query underlying media codecs", cause);
    }

  }
}
