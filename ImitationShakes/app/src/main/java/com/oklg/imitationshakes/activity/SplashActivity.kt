package com.oklg.imitationshakes.activity

import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.util.Log
import android.view.View
import android.view.Window
import android.widget.ImageView
import com.oklg.imitationshakes.BaseActivity
import com.oklg.imitationshakes.MainActivity
import com.oklg.imitationshakes.R
import com.oklg.imitationshakes.adapter.SpImageAdapter
import com.oklg.imitationshakes.utils.DBManager
import com.oklg.imitationshakes.utils.PDManager
import java.util.*

class SplashActivity : BaseActivity() {
    private lateinit var sp_icon: ImageView
    private lateinit var viewpager_sp: ViewPager
    var img_list = arrayOf(R.mipmap.a02, R.mipmap.a03)
    var mPostion = 0
    var isScrolled = false
    val context by lazy { this }
    val dbManager = DBManager(context = this)
    val pbManager = PDManager(context)
    val timer = Timer()

    override fun setContentViewPrevics() {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
    }

    override fun setMainView(): Int {
        return R.layout.activity_splash
    }

    override fun initview() {
        sp_icon = findViewById<ImageView>(R.id.sp_icon);
        viewpager_sp = findViewById<ViewPager>(R.id.viewpager_sp);
        sp_icon.setImageResource(R.mipmap.sp_icon);
        viewpager_sp.adapter = SpImageAdapter(img_list, context, viewpager_sp)
        viewpager_sp.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}

            override fun onPageSelected(position: Int) {
                mPostion = position;
            }

            override fun onPageScrollStateChanged(state: Int) {

                when (state) {
                    ViewPager.SCROLL_STATE_DRAGGING -> {
                        isScrolled = false;
                    }

                    ViewPager.SCROLL_STATE_SETTLING -> {
                        isScrolled = true;
                    }

                    ViewPager.SCROLL_STATE_IDLE -> {
                        if (viewpager_sp.getCurrentItem() == viewpager_sp.getAdapter()?.getCount() as Int - 1 && !isScrolled) {
                            pbManager.ToStartActivity(MainActivity::class.java, true)
                            dbManager.spSetBoolean(false, dbManager.SPKEY_SPFRISTIN)
                        }
                        isScrolled = true;
                    }
                }

            }
        })

    }

    override fun initData() {
        //是否第一次使用
        judgeFristUse();
    }

    /**
     * 是否第一次使用
     */
    private fun judgeFristUse() {
        if (dbManager.spGetBoolean(dbManager.SPKEY_SPFRISTIN)) {
            viewpager_sp.visibility = View.VISIBLE
            sp_icon.visibility = View.GONE

        } else {
            viewpager_sp.visibility = View.GONE
            sp_icon.visibility = View.VISIBLE
            AdverTime();
        }
    }


    /**
     * 添加广告计时
     */
    private fun AdverTime() {
        timer.schedule(object : TimerTask() {
            override fun run() {
                pbManager.ToStartActivity(MainActivity::class.java, true)
                timer.cancel()
            }
        }, 3000)
    }


}
