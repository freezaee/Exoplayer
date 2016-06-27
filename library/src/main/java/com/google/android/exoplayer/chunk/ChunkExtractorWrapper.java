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
package com.google.android.exoplayer.chunk;

import com.google.android.exoplayer.MediaFormat;
import com.google.android.exoplayer.drm.DrmInitData;
import com.google.android.exoplayer.extractor.Extractor;
import com.google.android.exoplayer.extractor.ExtractorInput;
import com.google.android.exoplayer.extractor.ExtractorOutput;
import com.google.android.exoplayer.extractor.SeekMap;
import com.google.android.exoplayer.extractor.TrackOutput;
import com.google.android.exoplayer.util.Assertions;
import com.google.android.exoplayer.util.ParsableByteArray;

import java.io.IOException;

/**
 * An {@link Extractor} wrapper for loading chunks containing a single track.
 * <p>
 * The wrapper allows switching of the {@link SingleTrackOutput} that receives parsed data.
 */
public class ChunkExtractorWrapper implements ExtractorOutput, TrackOutput {

  /**
   * Receives stream level data extracted by the wrapped {@link Extractor}.
   */
  public interface SingleTrackOutput extends TrackOutput {

    /**
     * @see ExtractorOutput#seekMap(SeekMap)
     */
    void seekMap(SeekMap seekMap);

    /**
     * @see ExtractorOutput#drmInitData(DrmInitData)
     */
    void drmInitData(DrmInitData drmInitData);

  }

  private final Extractor extractor;

  /**
   * @param extractor The extractor to wrap.
   */
  public ChunkExtractorWrapper(Extractor extractor) {
    this.extractor = extractor;
  }
}
