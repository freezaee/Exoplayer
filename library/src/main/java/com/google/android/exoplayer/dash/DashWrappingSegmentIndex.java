package com.google.android.exoplayer.dash;

import com.google.android.exoplayer.dash.mpd.RangedUri;
import com.google.android.exoplayer.extractor.ChunkIndex;

/**
 * Created by Elvis.He on 2016/6/27.
 */
public class DashWrappingSegmentIndex implements DashSegmentIndex {
    public DashWrappingSegmentIndex(ChunkIndex seekMap, String s) {

    }

    @Override
    public int getSegmentNum(long timeUs, long periodDurationUs) {
        return 0;
    }

    @Override
    public long getTimeUs(int segmentNum) {
        return 0;
    }

    @Override
    public long getDurationUs(int segmentNum, long periodDurationUs) {
        return 0;
    }

    @Override
    public RangedUri getSegmentUrl(int segmentNum) {
        return null;
    }

    @Override
    public int getFirstSegmentNum() {
        return 0;
    }

    @Override
    public int getLastSegmentNum(long periodDurationUs) {
        return 0;
    }

    @Override
    public boolean isExplicit() {
        return false;
    }
}
