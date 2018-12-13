package com.oklg.imitationshakes

import android.media.MediaPlayer
import android.net.Uri
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.widget.*
import com.facebook.drawee.gestures.GestureDetector
import com.oklg.imitationshakes.utils.PDManager
import com.oklg.imitationshakes.weight.EmptyControlVideo
import com.oklg.imitationshakes.weight.MainDialog
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer
import android.view.animation.Animation.RELATIVE_TO_SELF
import android.view.animation.ScaleAnimation
import android.view.animation.AnimationSet
import android.view.animation.TranslateAnimation
import com.shuyu.gsyvideoplayer.listener.GSYVideoProgressListener
import com.shuyu.gsyvideoplayer.video.GSYADVideoPlayer

class MainActivity : BaseActivity() {
    val context by lazy { this }
    val pdManager = PDManager(context)
    lateinit var video: EmptyControlVideo
    lateinit var heart_to: ImageView
    lateinit var comment: ImageView
    lateinit var fsdf: ListView
    lateinit var anmin_line: View
    lateinit var mDetector: GestureDetector
    lateinit var uri: Uri
    var x1 = 0f
    var y1 = 0f
    var mPostion = 0

    var a1 = "http://video.7k.cn/app_video/20171202/6c8cf3ea/v.m3u8.mp4"
    var a2 = "http://9890.vod.myqcloud.com/9890_4e292f9a3dd011e6b4078980237cc3d3.f20.mp4"
    var a3 = "https://res.exexm.com/cw_145225549855002"
    var a4 = "http://7xjmzj.com1.z0.glb.clouddn.com/20171026175005_JObCxCE2.mp4"

    var path_list = arrayOf(a1, a2,a3,a4)
    var isFoucs = false;


    override fun setContentViewPrevics() {
        pdManager.transparentBar()
    }

    override fun setMainView(): Int {
        return R.layout.activity_main;
    }

    override fun initview() {
        video = findViewById<EmptyControlVideo>(R.id.video)
        heart_to = findViewById<ImageView>(R.id.heart_to)
        comment = findViewById<ImageView>(R.id.comment)
        anmin_line = findViewById<View>(R.id.anmin_line)
        video.isTouchWiget == false
        video.hideSmallVideo()

        val aset_3 = AnimationSet(true)
        val aa_3 = ScaleAnimation(0f, 1f, 0f, 3f, Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, 1f)
        aa_3.duration = 400
        aa_3.repeatCount=100
        aset_3.addAnimation(aa_3)
        anmin_line.startAnimation(aset_3)


        //增加封面
        val imageView = ImageView(this)
        imageView.scaleType = ImageView.ScaleType.CENTER_CROP
        imageView.setImageResource(R.mipmap.xxx1)
        video.setThumbImageView(imageView)

        video

    }

    override fun initData() {
        uri = Uri.parse(path_list.get(mPostion))
        video.setUp(path_list[0], true, "")
        video.startPlayLogic()

        heart_to.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {

                if (!isFoucs) {
                    heart_to.setImageResource(R.mipmap.hearted_main)
                    isFoucs = true;
                } else {
                    heart_to.setImageResource(R.mipmap.heart_main)
                    isFoucs = false;
                }
            }
        })

        comment.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                val view = View.inflate(context, R.layout.main_dialog_bootom, null)
                val mainDialog = MainDialog(context, view, true, true)

                if (mainDialog.isShowing) {
                    mainDialog.dismiss()
                } else {
                    mainDialog.show()
                }

                fsdf = view.findViewById<ListView>(R.id.fsdf)
                //
                fsdf.adapter = object : BaseAdapter() {
                    override fun getItem(p0: Int): Any {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }

                    override fun getItemId(p0: Int): Long {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }

                    override fun getCount(): Int {

                        return 12;
                    }

                    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
                        val view = View.inflate(context, R.layout.main_comment_item, null)
                        return view
                    }
                }
            }
        })



    }

    /**
     * 下一个
     */
    fun nextVideo() {
        mPostion++
        if (mPostion > path_list.size-1){
            mPostion = path_list.size - 1
        }else{
            video.setUp(path_list[mPostion], true, "")
            video.startPlayLogic()
        }
    }


    /**
     * 上一个
     */
    fun upVideo() {
        mPostion--
        if (mPostion < 0){
            mPostion = 0
        }else{
            video.setUp(path_list[mPostion], true, "")
            video.startPlayLogic()
        }
    }


    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if (event?.getAction() == MotionEvent.ACTION_DOWN) {
            x1 = event.getX();
            y1 = event.getY();
        }
        if (event?.getAction() == MotionEvent.ACTION_UP) {
            val x2 = event.getX();
            val y2 = event.getY();
            if (y1 - y2 > 50) {

                nextVideo()

            } else if (y2 - y1 > 50) {

                upVideo()

            } else if (x1 - x2 > 50) {
                Toast.makeText(context, "向左滑", Toast.LENGTH_SHORT).show();
            } else if (x2 - x1 > 50) {
                Toast.makeText(context, "向右滑", Toast.LENGTH_SHORT).show();
            }
        }
        return super.onTouchEvent(event);
    }


}
