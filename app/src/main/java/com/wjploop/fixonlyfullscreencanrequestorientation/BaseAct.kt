package com.wjploop.fixonlyfullscreencanrequestorientation

import android.app.Activity
import android.content.pm.ActivityInfo
import android.content.res.TypedArray
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import java.lang.Exception


/**
 *
 */
abstract class BaseAct : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        if (Build.VERSION.SDK_INT == Build.VERSION_CODES.O && isTranslucentOrFloating()) {
            val result = fixOrientation()
            Log.d("wolf", "onCreate fixOrientation when Oreo, result=$result")
        }
        super.onCreate(savedInstanceState)
    }

    //去除代码中请求的情况
    override fun setRequestedOrientation(requestedOrientation: Int) {
        if (Build.VERSION.SDK_INT == Build.VERSION_CODES.O && isTranslucentOrFloating()) {
            Log.d("wolf", "avoid calling setRequestOrientation when Oren and is not fullScreen")
            return
        }
        super.setRequestedOrientation(requestedOrientation)
    }
    //去除配置中请求的情况
    private fun fixOrientation(): Boolean {
        try {
            val field = Activity::class.java.getDeclaredField("mActivityInfo")
            field.isAccessible = true
            val activityInfo = field.get(this) as ActivityInfo
            activityInfo.screenOrientation = ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED
            field.isAccessible = false
            return true
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return false
    }
    //判断activity是不是符合全屏非透明的情况
    private fun isTranslucentOrFloating(): Boolean {
        var isTranslucentOrFloating = false
        try {
            val styleRes =
                Class.forName("com.android.internal.R${'$'}styleable").getField("Window").get(null) as IntArray
            val typeArray = obtainStyledAttributes(styleRes)
            val method = ActivityInfo::class.java.getMethod("isTranslucentOrFloating", TypedArray::class.java)
            method.isAccessible = true
            isTranslucentOrFloating = method.invoke(null, typeArray) as Boolean
            method.isAccessible = false
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return isTranslucentOrFloating
    }
}