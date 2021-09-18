package bm.it.mobile.extensions.view

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.view.View
import android.view.ViewGroup

object ViewExtensionsImpl {

    fun getBitmap(view: View): Bitmap {
        var width = view.width
        var height = view.height
        var executeLayout = false
        if (width == 0 && height == 0) {
            val metrics = view.context.resources.displayMetrics
            view.layoutParams = ViewGroup.LayoutParams(
                View.MeasureSpec.EXACTLY,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            view.measure(
                View.MeasureSpec.makeMeasureSpec(
                    metrics.widthPixels,
                    View.MeasureSpec.EXACTLY
                ),
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            width = view.measuredWidth
            height = view.measuredHeight
            executeLayout = true
        }
        val returnedBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(returnedBitmap)
        val backgroundDrawable = view.background
        if (backgroundDrawable != null) {
            backgroundDrawable.draw(canvas)
        } else {
            canvas.drawColor(Color.WHITE)
        }
        if (executeLayout) {
            view.layout(0, 0, width, height)
        }
        view.draw(canvas)
        return returnedBitmap
    }
}