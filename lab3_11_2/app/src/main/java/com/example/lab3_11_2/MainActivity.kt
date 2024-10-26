package com.example.lab3_11_2

import android.graphics.Color
import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var gestureDetector: GestureDetector
    private lateinit var frameLayout: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        frameLayout = findViewById(R.id.frameLayout)

        gestureDetector = GestureDetector(this, GestureListener())

        frameLayout.setOnTouchListener { v, event ->
            gestureDetector.onTouchEvent(event)
            true
        }
    }

    private inner class GestureListener : GestureDetector.SimpleOnGestureListener() {

        override fun onSingleTapUp(e: MotionEvent): Boolean {
            frameLayout.setBackgroundColor(Color.BLUE)
            return true
        }

        override fun onFling(
            e1: MotionEvent?,
            e2: MotionEvent,
            velocityX: Float,
            velocityY: Float
        ): Boolean{
            val deltaY = e2?.y?.minus(e1?.y ?: 0f) ?: 0f

            if (e1 != null) {
                return if (Math.abs(deltaY) > Math.abs(e2.x - e1.x)) {
                    if (deltaY < 0) {
                        // Swipe Up
                        frameLayout.setBackgroundColor(Color.YELLOW)
                    } else {
                        // Swipe Down
                        frameLayout.setBackgroundColor(Color.RED)
                    }
                    return true
                } else {
                   return  false
                }
            }
            return true
        }
    }
}
