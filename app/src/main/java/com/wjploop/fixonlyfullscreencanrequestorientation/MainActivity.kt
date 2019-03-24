package com.wjploop.fixonlyfullscreencanrequestorientation

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /**
         * 启动一个非全屏的activity,不该由自己来决定屏幕旋转方向，而是该由父activity来决定
         */
        error.setOnClickListener {
            startActivity(Intent(this,ErrorActivity::class.java))
        }
        normal.setOnClickListener {
            startActivity(Intent(this,NormalAct::class.java))
        }

    }
}
