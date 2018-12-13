package com.oklg.imitationshakes.weight


import android.app.ActionBar
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.view.Gravity
import android.view.View
import android.view.WindowManager
import android.widget.TextView
import com.oklg.imitationshakes.R

/**
 *
 * kotlin自定义view用法
 * Created by LG on 2018/8/24.
 */
class MainDialog : Dialog {

    private var iscancelable: Boolean = false
    private var isBackCancelable: Boolean = false
    internal var context: Context? = null;
    internal var view: View? = null;

    constructor(context: Context, view: View, isCancelable: Boolean, isBackCancelable: Boolean) : super(context, R.style.MyDialog) {
        this.context = context
        this.view = view;
        this.iscancelable = isCancelable
        this.isBackCancelable = isBackCancelable
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(view)
        setCancelable(iscancelable)
        setCanceledOnTouchOutside(isBackCancelable)
        val window = window
        window.setGravity(Gravity.BOTTOM)
        val params = window.attributes
        params.width = ActionBar.LayoutParams.MATCH_PARENT
        params.height = 1300
        window.attributes = params
    }


}