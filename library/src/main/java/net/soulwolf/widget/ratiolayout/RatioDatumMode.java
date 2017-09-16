/*
 * <pre>
 * Copyright 2015 The Android Open Source Project for Android-RatioLayout
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * </pre>
 */
package net.soulwolf.widget.ratiolayout;

/**
 * author: Amphiaraus
 * since : 2017/9/13 上午10:39.
 */
public enum RatioDatumMode {
    DATUM_AUTO(0),
    DATUM_WIDTH(1),
    DATUM_HEIGHT(2);

    final int mode;

    RatioDatumMode(int mode) {
        this.mode = mode;
    }

    public static RatioDatumMode valueOf(int mode) {
        if (mode == DATUM_WIDTH.mode) {
            return DATUM_WIDTH;
        }
        if (mode == DATUM_HEIGHT.mode) {
            return DATUM_HEIGHT;
        }
        return DATUM_AUTO;
    }
}
