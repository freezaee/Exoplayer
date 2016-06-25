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
package com.google.android.exoplayer.dash.mpd;

import com.google.android.exoplayer.ParserException;
import com.google.android.exoplayer.upstream.UriLoadable;

import org.xml.sax.helpers.DefaultHandler;

import java.io.IOException;
import java.io.InputStream;

/**
 * A parser of media presentation description files.
 */
public class MediaPresentationDescriptionParser extends DefaultHandler
    implements UriLoadable.Parser<MediaPresentationDescription> {
    @Override
    public MediaPresentationDescription parse(String connectionUrl, InputStream inputStream) throws ParserException, IOException {
        return null;
    }
}
