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

import com.google.android.exoplayer.util.Assertions;
import com.google.android.exoplayer.util.Predicate;

import java.io.IOException;
import java.util.HashMap;

/**
 * A {@link HttpDataSource} that uses Android's {@link HttpURLConnection}.
 * <p>
 * By default this implementation will not follow cross-protocol redirects (i.e. redirects from
 * HTTP to HTTPS or vice versa). Cross-protocol redirects can be enabled by using the
 * {@link #DefaultHttpDataSource(String, Predicate, TransferListener, int, int, boolean)}
 * constructor and passing {@code true} as the final argument.
 */
public class DefaultHttpDataSource implements HttpDataSource {

  /**
   * The default connection timeout, in milliseconds.
   */
  public static final int DEFAULT_CONNECT_TIMEOUT_MILLIS = 8 * 1000;
  /**
   * The default read timeout, in milliseconds.
   */
  public static final int DEFAULT_READ_TIMEOUT_MILLIS = 8 * 1000;

  private final boolean allowCrossProtocolRedirects;
  private final int connectTimeoutMillis;
  private final int readTimeoutMillis;
  private final String userAgent;
  private final Predicate<String> contentTypePredicate;
  private final HashMap<String, String> requestProperties;
  private final TransferListener listener;

  /**
   * @param userAgent The User-Agent string that should be used.
   * @param contentTypePredicate An optional {@link Predicate}. If a content type is
   *     rejected by the predicate then a {@link HttpDataSource.InvalidContentTypeException} is
   *     thrown from {@link #open(DataSpec)}.
   */
  public DefaultHttpDataSource(String userAgent, Predicate<String> contentTypePredicate) {
    this(userAgent, contentTypePredicate, null);
  }

  /**
   * @param userAgent The User-Agent string that should be used.
   * @param contentTypePredicate An optional {@link Predicate}. If a content type is
   *     rejected by the predicate then a {@link HttpDataSource.InvalidContentTypeException} is
   *     thrown from {@link #open(DataSpec)}.
   * @param listener An optional listener.
   */
  public DefaultHttpDataSource(String userAgent, Predicate<String> contentTypePredicate,
      TransferListener listener) {
    this(userAgent, contentTypePredicate, listener, DEFAULT_CONNECT_TIMEOUT_MILLIS,
        DEFAULT_READ_TIMEOUT_MILLIS);
  }

  /**
   * @param userAgent The User-Agent string that should be used.
   * @param contentTypePredicate An optional {@link Predicate}. If a content type is
   *     rejected by the predicate then a {@link HttpDataSource.InvalidContentTypeException} is
   *     thrown from {@link #open(DataSpec)}.
   * @param listener An optional listener.
   * @param connectTimeoutMillis The connection timeout, in milliseconds. A timeout of zero is
   *     interpreted as an infinite timeout.
   * @param readTimeoutMillis The read timeout, in milliseconds. A timeout of zero is interpreted
   *     as an infinite timeout.
   */
  public DefaultHttpDataSource(String userAgent, Predicate<String> contentTypePredicate,
      TransferListener listener, int connectTimeoutMillis, int readTimeoutMillis) {
    this(userAgent, contentTypePredicate, listener, connectTimeoutMillis, readTimeoutMillis, false);
  }

  /**
   * @param userAgent The User-Agent string that should be used.
   * @param contentTypePredicate An optional {@link Predicate}. If a content type is
   *     rejected by the predicate then a {@link HttpDataSource.InvalidContentTypeException} is
   *     thrown from {@link #open(DataSpec)}.
   * @param listener An optional listener.
   * @param connectTimeoutMillis The connection timeout, in milliseconds. A timeout of zero is
   *     interpreted as an infinite timeout. Pass {@link #DEFAULT_CONNECT_TIMEOUT_MILLIS} to use
   *     the default value.
   * @param readTimeoutMillis The read timeout, in milliseconds. A timeout of zero is interpreted
   *     as an infinite timeout. Pass {@link #DEFAULT_READ_TIMEOUT_MILLIS} to use the default value.
   * @param allowCrossProtocolRedirects Whether cross-protocol redirects (i.e. redirects from HTTP
   *     to HTTPS and vice versa) are enabled.
   */
  public DefaultHttpDataSource(String userAgent, Predicate<String> contentTypePredicate,
      TransferListener listener, int connectTimeoutMillis, int readTimeoutMillis,
      boolean allowCrossProtocolRedirects) {
    this.userAgent = Assertions.checkNotEmpty(userAgent);
    this.contentTypePredicate = contentTypePredicate;
    this.listener = listener;
    this.requestProperties = new HashMap<>();
    this.connectTimeoutMillis = connectTimeoutMillis;
    this.readTimeoutMillis = readTimeoutMillis;
    this.allowCrossProtocolRedirects = allowCrossProtocolRedirects;
  }
    @Override
    public String getUri() {
        return null;
    }

    @Override
    public long open(DataSpec dataSpec) throws IOException {
        return 0;
    }

    @Override
    public void close() throws IOException {

    }

    @Override
    public int read(byte[] buffer, int offset, int readLength) throws IOException {
        return 0;
    }
}
