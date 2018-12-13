package com.oklg.imitationshakes

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * Created by LG on 2018/8/22.
 */
abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentViewPrevics()
        setContentView(setMainView());
        initview();
        initData();
    }

    abstract fun setContentViewPrevics()

    abstract fun setMainView(): Int

    abstract fun initview()

    abstract fun initData()

}