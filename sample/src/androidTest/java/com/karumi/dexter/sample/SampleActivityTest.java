/*
 * Copyright (C) 2016 Karumi.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.karumi.dexter.sample;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class SampleActivityTest {

  private UiDevice device;

  @Rule
  public ActivityTestRule<SampleActivity> mActivityRule =
      new ActivityTestRule<>(SampleActivity.class);

  @Before public void setUp() throws Exception {
    device = UiDevice.getInstance(getInstrumentation());
  }

  @Test
  public void onGrantCameraPermissionThenFeedbackTextShowsItsGranted() throws Exception {
    whenCameraButtonIsClicked();

    device.findObject(new UiSelector().text("Allow")).click();
  }

  @Test
  public void buttonShouldUpdateTextNope() throws UiObjectNotFoundException {
    whenCameraButtonIsClicked();

    device.findObject(new UiSelector().text("Deny")).click();
  }

  private void whenCameraButtonIsClicked() {
    onView(withId(R.id.camera_permission_button)).perform(click());
  }

  private void thenCameraPermissionIsGranted() throws Exception {
    device.findObject(new UiSelector().text("Allow")).click();
  }
}
