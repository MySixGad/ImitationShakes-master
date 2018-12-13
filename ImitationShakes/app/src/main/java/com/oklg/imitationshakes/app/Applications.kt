package com.oklg.imitationshakes.app

import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco

/**
 * Created by LG on 2018/8/22.
 */
class Applications : Application() {

    override fun onCreate() {
        super.onCreate()
        Fresco.initialize(this);
    }
}