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
package com.google.android.exoplayer.text;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/**
 * A view for rendering rich-formatted captions.
 */
public final class SubtitleLayout extends View {

  /**
   * The default fractional text size.
   *
   * @see #setFractionalTextSize(float, boolean)
   */
  public static final float DEFAULT_TEXT_SIZE_FRACTION = 0.0533f;
    public SubtitleLayout(Context context) {
    this(context, null);
  }

  public SubtitleLayout(Context context, AttributeSet attrs) {
    super(context, attrs);
    }

  /**
   * Sets the text size to be a fraction of the view's remaining height after its top and bottom
   * padding have been subtracted.
   * <p>
   * Equivalent to {@code #setFractionalTextSize(fractionOfHeight, false)}.
   *
   * @param fractionOfHeight A fraction between 0 and 1.
   */
  public void setFractionalTextSize(float fractionOfHeight) {
    setFractionalTextSize(fractionOfHeight, false);
  }

  /**
   * Sets the text size to be a fraction of the height of this view.
   *
   * @param fractionOfHeight A fraction between 0 and 1.
   * @param ignorePadding Set to true if {@code fractionOfHeight} should be interpreted as a
   *     fraction of this view's height ignoring any top and bottom padding. Set to false if
   *     {@code fractionOfHeight} should be interpreted as a fraction of this view's remaining
   *     height after the top and bottom padding has been subtracted.
   */
  public void setFractionalTextSize(float fractionOfHeight, boolean ignorePadding) {
  }

  /**
   * Sets the caption style.
   *
   * @param style A style for the view.
   */
  public void setStyle(CaptionStyleCompat style) {
  }
}
