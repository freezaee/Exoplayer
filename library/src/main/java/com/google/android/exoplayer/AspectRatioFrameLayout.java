package com.google.android.exoplayer;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/**
 * A {@link FrameLayout} that resizes itself to match a specified aspect ratio.
 */
public final class AspectRatioFrameLayout extends FrameLayout {
  public AspectRatioFrameLayout(Context context) {
    super(context);
  }

  public AspectRatioFrameLayout(Context context, AttributeSet attrs) {
    super(context, attrs);
    }
}
