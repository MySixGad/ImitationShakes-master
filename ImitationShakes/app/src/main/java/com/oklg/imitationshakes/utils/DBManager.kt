package com.oklg.imitationshakes.utils

import android.R.id.edit
import android.content.Context
import android.content.SharedPreferences.Editor


/**
 * 数据管理类
 * Created by LG on 2018/8/21.
 */
public class DBManager {

    public val SP_NAME = "FDY";
    public val SPKEY_SPFRISTIN = "SPKEY_SPFRISTIN";
    public var context: Context;

    constructor(context: Context) {
        this.context = context
    }

    /**
     * 保存字符串的sp
     */
    public fun spSetString(str: String, key: String) {
        val sharedPreferences = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE)
        var editor = sharedPreferences.edit()
        editor.putString(SPKEY_SPFRISTIN, str)
        editor.commit()
    }

    /**
     * 获取字符串sp
     */
    public fun spGetString(key: String): String {
        val sharedPreferences = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE)
        val string = sharedPreferences.getString(key, "noe")
        return string;

    }

   /**
     * 保存BOOLEAN的sp
     */
    public fun spSetBoolean(be: Boolean, key: String) {
        val sharedPreferences = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE)
        var editor = sharedPreferences.edit()
        editor.putBoolean(SPKEY_SPFRISTIN, be)
        editor.commit()
    }

    /**
     * 获取BOOLEAN的sp
     */
    public fun spGetBoolean(key: String): Boolean {
        val sharedPreferences = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE)
        val string = sharedPreferences.getBoolean(key, true)
        return string;

    }


}