package bm.it.mobile.library.byteArray

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Base64
import androidx.core.graphics.drawable.RoundedBitmapDrawable
import bm.it.mobile.library.bitmap.convertToRoundedBitmap

object ByteExtensionsImpl {

    fun convertToBase64(bytes: ByteArray): String {
        return Base64.encodeToString(bytes, Base64.NO_WRAP)
    }

    fun convertToBitmap(bytes: ByteArray): Bitmap {
        return BitmapFactory.decodeByteArray(bytes, 0, bytes.size)
    }

    fun convertToRoundedBitmap(context: Context, bytes: ByteArray): RoundedBitmapDrawable? {
        val bitmap: Bitmap = bytes.convertToBitmap()
        return bitmap.convertToRoundedBitmap(context)
    }
}
