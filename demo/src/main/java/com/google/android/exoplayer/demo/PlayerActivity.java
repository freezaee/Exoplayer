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
package com.google.android.exoplayer.demo;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TextView;

import com.google.android.exoplayer.AspectRatioFrameLayout;
import java.net.CookieManager;
import java.net.CookiePolicy;

import com.google.android.exoplayer.text.SubtitleLayout;


public class PlayerActivity extends Activity  implements SurfaceHolder.Callback , OnClickListener{

    // For use within demo app code.
    public static final String CONTENT_ID_EXTRA = "content_id";
    public static final String CONTENT_TYPE_EXTRA = "content_type";
    public static final String PROVIDER_EXTRA = "provider";
  private static final String TAG = "PlayerActivity";
  private static final CookieManager defaultCookieManager;
  static {
    defaultCookieManager = new CookieManager();
    defaultCookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ORIGINAL_SERVER);
  }

  private MediaController mediaController;
  private View debugRootView;
  private View shutterView;
  private AspectRatioFrameLayout videoFrame;
  private SurfaceView surfaceView;
  private TextView debugTextView;
  private TextView playerStateTextView;
  private SubtitleLayout subtitleLayout;
  private Button videoButton;
  private Button audioButton;
  private Button textButton;
  private Button retryButton;


  // Activity lifecycle

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.player_activity);
    View root = findViewById(R.id.root);
    root.setOnTouchListener(new OnTouchListener() {
      @Override
      public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
          toggleControlsVisibility();
        } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
          view.performClick();
        }
        return true;
      }
    });
    root.setOnKeyListener(new OnKeyListener() {
      @Override
      public boolean onKey(View v, int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK || keyCode == KeyEvent.KEYCODE_ESCAPE
            || keyCode == KeyEvent.KEYCODE_MENU) {
          return false;
        }
        return mediaController.dispatchKeyEvent(event);
      }
    });

    shutterView = findViewById(R.id.shutter);
    debugRootView = findViewById(R.id.controls_root);

    videoFrame = (AspectRatioFrameLayout) findViewById(R.id.video_frame);
    surfaceView = (SurfaceView) findViewById(R.id.surface_view);
    surfaceView.getHolder().addCallback(this);
    debugTextView = (TextView) findViewById(R.id.debug_text_view);

    playerStateTextView = (TextView) findViewById(R.id.player_state_view);
    subtitleLayout = (SubtitleLayout) findViewById(R.id.subtitles);

    retryButton = (Button) findViewById(R.id.retry_button);
    retryButton.setOnClickListener(this);
    videoButton = (Button) findViewById(R.id.video_controls);
    audioButton = (Button) findViewById(R.id.audio_controls);
    textButton = (Button) findViewById(R.id.text_controls);

    }
  @Override
  public void onClick(View view) {
  }
  private void toggleControlsVisibility()  {
  }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        
    }

  @Override
  public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
    // Do nothing.
  }

  @Override
  public void surfaceDestroyed(SurfaceHolder holder) {

    }
}
