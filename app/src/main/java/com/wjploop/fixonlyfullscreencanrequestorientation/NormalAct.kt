package com.wjploop.fixonlyfullscreencanrequestorientation

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.TextView


class NormalAct:BaseAct() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(TextView(this).apply {
            text="在一个基础公共类'BaseAct'中加入阻断其子类请求屏幕方向的逻辑"
        })
        requestedOrientation=ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
    }

}