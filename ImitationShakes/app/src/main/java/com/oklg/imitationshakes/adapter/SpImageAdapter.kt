package com.oklg.imitationshakes.adapter

import android.media.Image
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.oklg.imitationshakes.R
import com.oklg.imitationshakes.activity.SplashActivity

/**
 * Created by LG on 2018/8/21.
 */


public class SpImageAdapter(img_list: Array<Int>, context: SplashActivity, vp: ViewPager) : PagerAdapter() {


    var img_list = img_list;
    var context = context;
    var vp = vp;

    override fun isViewFromObject(view: View, `object`: Any): Boolean {

        return if (view === `object`) {
            true
        } else {
            false
        }
    }

    override fun getCount(): Int {
        return img_list.size
    }


    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val imageView = ImageView(context);
        imageView.setImageResource(img_list.get(position))
        container?.addView(imageView)
        return imageView
    }


    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        super.destroyItem(container, position, `object`)
    }

}