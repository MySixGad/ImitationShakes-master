package com.oklg.imitationshakes.utils

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.view.View


/**
 *
 * 控制类
 * Created by LG on 2018/8/21.
 */
public class PDManager {

    var context: Activity;

    constructor(context: Activity) {
        this.context = context;
    }

    /**
     * 打开ac
     */
    fun ToStartActivity(clazz: Any, isFinish: Boolean) {
        context.startActivity(Intent(context, clazz as Class<Any>))
        if (isFinish)
            context.finish()
    }


     fun transparentBar() {
        val window = context.window
        if (Build.VERSION.SDK_INT >= 21) {
            val decorView =window.decorView
            decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
            window.statusBarColor = Color.TRANSPARENT
        }
    }

}