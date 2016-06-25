package com.google.android.exoplayer.upstream;

import java.io.IOException;

/**
 * Created by Elvis.He on 2016/6/25.
 */
public class FileDataSource implements UriDataSource {
    public FileDataSource(TransferListener listener) {

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
