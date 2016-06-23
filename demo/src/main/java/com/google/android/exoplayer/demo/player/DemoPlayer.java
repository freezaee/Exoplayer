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
package com.google.android.exoplayer.demo.player;

import com.google.android.exoplayer.util.DebugTextViewHelper;
import com.google.android.exoplayer.util.PlayerControl;
import android.view.Surface;

/**
 * Created by Elvis.He on 2016/6/23.
 */

public class DemoPlayer implements DebugTextViewHelper.Provider {
  /**
   * Builds renderers for the player.
   */
  public interface RendererBuilder {
    /**
     * Builds renderers for playback.
     *
     * @param player The player for which renderers are being built. {@link DemoPlayer#onRenderers}
     *     should be invoked once the renderers have been built. If building fails,
     *     {@link DemoPlayer#onRenderersError} should be invoked.
     */
    void buildRenderers(DemoPlayer player);
    /**
     * Cancels the current build operation, if there is one. Else does nothing.
     * <p>
     * A canceled build operation must not invoke {@link DemoPlayer#onRenderers} or
     * {@link DemoPlayer#onRenderersError} on the player, which may have been released.
     */
    void cancel();
  }

  /**
   * A listener for core events.
   */
  public interface Listener {
  }

  /**
   * A listener for internal errors.
   * <p>
   * These errors are not visible to the user, and hence this listener is provided for
   * informational purposes only. Note however that an internal error may cause a fatal
   * error if the player fails to recover. If this happens, {@link Listener#onError(Exception)}
   * will be invoked.
   */
  public interface InternalErrorListener {
  }

  /**
   * A listener for debugging information.
   */
  public interface InfoListener {
  }

  /**
   * A listener for receiving notifications of timed text.
   */
  public interface CaptionListener {
  }

  /**
   * A listener for receiving ID3 metadata parsed from the media stream.
   */
  public interface Id3MetadataListener {
  }
  public static final int TYPE_VIDEO = 0;
  public static final int TYPE_AUDIO = 1;
  public static final int TYPE_TEXT = 2;
  private final PlayerControl playerControl;
  public DemoPlayer(RendererBuilder rendererBuilder) {
    playerControl = new PlayerControl();
  }

  public PlayerControl getPlayerControl() {
    return playerControl;
  }

  public void addListener(Listener listener) {
  }
  public void setInternalErrorListener(InternalErrorListener listener) {
  }

  public void setInfoListener(InfoListener listener) {
  }

  public void setCaptionListener(CaptionListener listener) {
  }

  public void setMetadataListener(Id3MetadataListener listener) {
  }
    public void setSurface(Surface surface) {
    }
  public void blockingClearSurface() {
  }

  public int getTrackCount(int type) {
    return 2;
  }
  public void setBackgrounded(boolean backgrounded) {
  }

  public void prepare() {
  }
  public void setPlayWhenReady(boolean playWhenReady) {
  }

  public void seekTo(long positionMs) {
  }
  public void release() {
  }
  public long getCurrentPosition() {
    return 0;
  }
}
