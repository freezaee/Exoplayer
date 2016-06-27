package com.google.android.exoplayer.extractor;

import com.google.android.exoplayer.upstream.DataSource;

/**
 * Created by Elvis.He on 2016/6/27.
 */
public class DefaultTrackOutput {
    private int writeIndex;

    public int getWriteIndex() {
        return writeIndex;
    }

    public int sampleData(DataSource dataSource, int maxValue, boolean b) {
        return 0;
    }

    public void sampleMetadata(long startTimeUs, int sampleFlagSync, int sampleSize, int i, Object o) {

    }
}
