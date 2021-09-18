package bm.it.mobile.extensions.integer

import android.content.Context
import android.graphics.Bitmap
import androidx.core.graphics.drawable.RoundedBitmapDrawable

fun Int.convertDrawableToBitmap(context: Context): Bitmap =
    IntegerExtensionsImpl.convertDrawableToBitmap(context, this)

fun Int.convertDrawableToRoundedBitmap(context: Context): RoundedBitmapDrawable? =
    IntegerExtensionsImpl.convertDrawableToRoundedBitmap(context, this)

fun Int.convertPixelToDp(context: Context): Int =
    IntegerExtensionsImpl.convertPixelToDp(context, this)

fun Int.getColor(context: Context): Int =
    IntegerExtensionsImpl.getColor(context, this)
