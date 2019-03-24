package com.wjploop.fixonlyfullscreencanrequestorientation

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView


class ErrorActivity :AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation=ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        setContentView(
            TextView(this).apply {
                text="hello"
            }
        )
    }



}