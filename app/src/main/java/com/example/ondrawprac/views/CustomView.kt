package com.example.ondrawprac.views

import android.content.ContentValues.TAG
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.util.Log
import android.view.View
import androidx.core.graphics.green
import com.example.ondrawprac.R

class CustomView @JvmOverloads constructor(context: Context?, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
    View(context, attrs, defStyleAttr) {

    companion object {
    }

    private var viewWidth = 0f  // window - margin의 width
    private var viewHeight = 0f // window - margin의 height
    private var textWidth = 70.0f // textsize 20f의 숫자 0~9 중에서 가장 넓은 width가 11임 bpm은 최대 3자리이므로 33에 여유값2
    private var textHeight = 40.0f // textsize 20f의 글자중 가장 높은 height가 18임 거기다 여유값 1을 더줘서 19



    private val textPaint = Paint().apply { color = context!!.getColor(R.color.design_default_color_secondary)
    this.isAntiAlias = true
    textSize = 35f }

    //그래프의 틀을 그리는 함수
    private fun drawgrid(canvas: Canvas){
        canvas.drawRect(textWidth, 0f, viewWidth, viewHeight - textHeight, paint)
        canvas.drawLine(textWidth + (viewWidth-textWidth)/4,0f, textWidth + (viewWidth-textWidth)/4, viewHeight - textHeight, paint)
        canvas.drawLine(textWidth + (viewWidth-textWidth)/2,0f, textWidth + (viewWidth-textWidth)/2, viewHeight - textHeight, paint)
        canvas.drawLine(textWidth + 3 * (viewWidth-textWidth)/4,0f, textWidth + 3 * (viewWidth-textWidth)/4, viewHeight - textHeight, paint)
        canvas.drawText("오전 12시", textWidth, viewHeight - 4f, textPaint)
        canvas.drawText("오전 6시", textWidth + (viewWidth-textWidth)/4, viewHeight - 4f, textPaint)
        canvas.drawText("오후 12시", textWidth + (viewWidth-textWidth)/2, viewHeight - 4f, textPaint)
        canvas.drawText("오후 6시", textWidth + 3 * (viewWidth-textWidth)/4, viewHeight - 4f, textPaint)
    }




    //Paint
    val paint = Paint().apply { this.color = context!!.getColor(R.color.design_default_color_secondary)
    this.strokeWidth = 2.0f
    this.style = Paint.Style.STROKE}

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        viewWidth = w.toFloat()
        viewHeight = h.toFloat()


    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        Log.d(TAG, "onDraw: executed")
        drawgrid(canvas)



//            val rect = Rect()
//            textPaint.getTextBounds("시", 0, 1, rect)
//            var textWidth = rect.height()
//            Log.d(TAG, "onSizeChanged: $textWidth")



    }
}