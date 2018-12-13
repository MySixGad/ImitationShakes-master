package com.oklg.imitationshakes.weight

import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import android.util.AttributeSet
import android.view.MotionEvent
import com.oklg.imitationshakes.R
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer

/**
 * Created by LG on 2018/9/4.
 */
class EmptyControlVideo : StandardGSYVideoPlayer {
    constructor(context: Context?, fullFlag: Boolean?) : super(context, fullFlag)
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)


    override fun getLayoutId(): Int {
        return R.layout.empty_video
    }


    override fun touchSurfaceMoveFullLogic(absDeltaX: Float, absDeltaY: Float) {
        super.touchSurfaceMoveFullLogic(absDeltaX, absDeltaY)
        //不给触摸快进，如果需要，屏蔽下方代码即可
        mChangePosition = false

        //不给触摸音量，如果需要，屏蔽下方代码即可
        mChangeVolume = false

        //不给触摸亮度，如果需要，屏蔽下方代码即可
        mBrightness = false

    }


    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        return false
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        return true
    }

    override fun touchDoubleUp() {
//        super.touchDoubleUp()
    }
}