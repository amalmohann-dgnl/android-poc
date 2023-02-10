
package com.reactpoclibrary;

import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

public class RNAndroidPocModule extends ReactContextBaseJavaModule {
  private static final String REACT_CLASS = "RNAndroidPoc";
  private ImageView mImageView;
  private final ReactApplicationContext reactContext;

  //  constructor
  public RNAndroidPocModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  //  change the image on call based on the param
  @ReactMethod
  public void changeImage(String image) {
    Log.d("changeImage","invoke completed");
    Toast.makeText(this.reactContext, image, Toast.LENGTH_LONG).show();
    if (image.equals("image1")) {
      mImageView.setImageResource(R.drawable.image1);
    } else if (image.equals("image2")) {
      mImageView.setImageResource(R.drawable.image1);
    }
  }

  // obligatory member function for package
  @Override
  public String getName() {
    return REACT_CLASS;
  }
}