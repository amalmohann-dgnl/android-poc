
package com.reactpoclibrary;

import android.widget.ImageView;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

public class RNAndroidPocModule extends ReactContextBaseJavaModule {
  private static final String MODULE_NAME = "RNAndroidPoc";
  private ImageView mImageView;
  private final ReactApplicationContext reactContext;

  public RNAndroidPocModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @ReactMethod
  public void changeImage(String image) {
    Toast.makeText(context, image, Toast.LENGTH_LONG).show();
    if (image.equals("image1")) {
      mImageView.setImageResource(R.drawable.image1);
    } else if (image.equals("image2")) {
      mImageView.setImageResource(R.drawable.image1);
    }
  }

  @Override
  public String getName() {
    return MODULE_NAME;
  }
}