package com.reactpoclibrary;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.views.image.ImageResizeMode;
import com.facebook.react.views.image.ReactImageView;

public class RNAndroidPocImageManager extends SimpleViewManager<ReactImageView> {
    public static final String REACT_CLASS = "POCImageView";
    ReactApplicationContext reactContext;

    // constructor
    public RNAndroidPocImageManager(ReactApplicationContext reactContext) {
        this.reactContext = reactContext;
    }

    // obligatory member function for the view manager
    @NonNull
    @Override
    public String getName() {
        return REACT_CLASS;
    }

    // creating and initializing the view Instance
    @NonNull
    @Override
    protected ReactImageView createViewInstance(@NonNull ThemedReactContext themedReactContext) {
        return new ReactImageView(themedReactContext, Fresco.newDraweeControllerBuilder(), null, reactContext);
    }

    // Property setter for the Native UI component
    // setting the source of the ImageView
    @ReactProp(name = "src")
    public void setSrc(ReactImageView view, @Nullable ReadableArray sources) {
        view.setSource(sources);
    }

    //setting the borderRadius of the ImageView
    @ReactProp(name = "borderRadius", defaultFloat = 0f)
    public void setBorderRadius(ReactImageView view, float borderRadius) {
        view.setBorderRadius(borderRadius);
    }

    //setting the scale type of the ImageView
    @ReactProp(name = ViewProps.RESIZE_MODE)
    public void setResizeMode(ReactImageView view, @Nullable String resizeMode) {
        view.setScaleType(ImageResizeMode.toScaleType(resizeMode));
    }

}
