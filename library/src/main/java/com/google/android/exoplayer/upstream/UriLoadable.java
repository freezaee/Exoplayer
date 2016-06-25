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

import com.google.android.exoplayer.ParserException;
import com.google.android.exoplayer.upstream.Loader.Loadable;

import java.io.IOException;
import java.io.InputStream;

/**
 * A {@link Loadable} for loading an object from a URI.
 *
 * @param <T> The type of the object being loaded.
 */
public final class UriLoadable<T> implements Loadable {

  /**
   * Parses an object from loaded data.
   */
  public interface Parser<T> {

    /**
     * Parses an object from a response.
     *
     * @param connectionUrl The source of the response, after any redirection.
     * @param inputStream An {@link InputStream} from which the response data can be read.
     * @return The parsed object.
     * @throws ParserException If an error occurs parsing the data.
     * @throws IOException If an error occurs reading data from the stream.
     */
    T parse(String connectionUrl, InputStream inputStream) throws ParserException, IOException;

  }

    @Override
    public void cancelLoad() {
        
    }

    @Override
    public boolean isLoadCanceled() {
        return false;
    }

    @Override
    public void load() throws IOException, InterruptedException {

    }
}
