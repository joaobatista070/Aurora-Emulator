package com.project_aurora.emu.compositor

import android.content.Context
import android.util.AttributeSet
import android.view.Surface
import android.view.SurfaceHolder
import android.view.SurfaceView
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.graphics.Rect
import android.graphics.RectF
import android.graphics.Typeface
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.view.View

import com.project_aurora.emu.NativeCode
import com.project_aurora.emu.R

class Pointer(
    private var bitmap: Bitmap,
    ) {
    private var x: Float = 0f
    private var y: Float = 0f
    
    fun updateCursorPosition(surfaceView: SurfaceView, _x: Float, _y: Float) {
        x = _x
        y = _y
        surfaceView.invalidate() 
    }
    
    fun createCursor(c: Canvas) {
        c?.drawBitmap(bitmap, x - bitmap.width / 2, y - bitmap.height / 2, null)
    }

    init {
    
    }
}
