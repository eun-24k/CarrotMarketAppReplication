package com.example.carrotmarketappreplication

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class MyDecoration() : RecyclerView.ItemDecoration() {
    override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDrawOver(c, parent, state)
        val widthMargin = 0f   // 좌우 Margin
        val height = 1f         // 사각형의 height

        val left = parent.paddingLeft.toFloat()
        val right = parent.width - parent.paddingRight.toFloat()
        val paint = Paint().apply { color = Color.GRAY }
        for(i in 0 until parent.childCount) {
            val view = parent.getChildAt(i)
            val top = view.bottom.toFloat() + (view.layoutParams as RecyclerView.LayoutParams).bottomMargin
            val bottom = top + height   // 세로 길이 = 5 (bottom - top = height)

            // 좌표 (left, top) / (right, bottom) 값을 대각선으로 가지는 사각형
            c.drawRect(left + widthMargin, top, right - widthMargin, bottom, paint)
        }
    }
}