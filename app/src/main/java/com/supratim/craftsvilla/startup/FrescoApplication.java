package com.supratim.craftsvilla.startup;

import android.app.Application;
import com.supratim.craftsvilla.cache.ImagePipelineConfigFactory;
import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by supratim on 2015/6/24.
 */
public class FrescoApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this, ImagePipelineConfigFactory.getImagePipelineConfig(this));
    }

}
