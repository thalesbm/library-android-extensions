package bm.it.mobile.extensions.byteArray

import android.content.Context
import android.graphics.Bitmap
import androidx.core.graphics.drawable.RoundedBitmapDrawable

fun ByteArray.convertToBase64(): String =
    ByteExtensionsImpl.convertToBase64(this)

fun ByteArray.convertToBitmap(): Bitmap =
    ByteExtensionsImpl.convertToBitmap(this)

fun ByteArray.convertToRoundedBitmap(context: Context): RoundedBitmapDrawable? =
    ByteExtensionsImpl.convertToRoundedBitmap(
        context,
        this
    )