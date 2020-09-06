package bm.it.mobile.extensions.integer

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.RoundedBitmapDrawable
import bm.it.mobile.extensions.bitmap.convertToRoundedBitmap

object IntegerExtensionsImpl {

    fun convertDrawableToBitmap(context: Context, id: Int): Bitmap {
        return BitmapFactory.decodeResource(context.resources, id)
    }

    fun convertDrawableToRoundedBitmap(context: Context, id: Int): RoundedBitmapDrawable? {
        val bitmap: Bitmap = id.convertDrawableToBitmap(context)
        return bitmap.convertToRoundedBitmap(context)
    }

    fun convertPixelToDp(context: Context, num: Int): Int {
        val scale: Float = context.resources.displayMetrics.density
        return (num * scale + 0.5f).toInt()
    }

    fun getColor(context: Context, id: Int): Int {
        return ContextCompat.getColor(context, id)
    }
}
