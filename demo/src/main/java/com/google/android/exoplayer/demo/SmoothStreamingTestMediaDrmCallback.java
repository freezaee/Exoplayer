package com.google.android.exoplayer.demo;

import android.annotation.TargetApi;
import android.media.MediaDrm;

import com.google.android.exoplayer.drm.MediaDrmCallback;

import java.util.UUID;

/**
 * Demo {@link StreamingDrmSessionManager} for smooth streaming test content.
 */
@TargetApi(18)
public class SmoothStreamingTestMediaDrmCallback implements MediaDrmCallback {
    @Override
    public byte[] executeProvisionRequest(UUID uuid, MediaDrm.ProvisionRequest request) throws Exception {
        return new byte[0];
    }

    @Override
    public byte[] executeKeyRequest(UUID uuid, MediaDrm.KeyRequest request) throws Exception {
        return new byte[0];
    }
}
