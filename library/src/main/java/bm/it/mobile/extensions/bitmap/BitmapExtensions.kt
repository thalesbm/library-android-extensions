package bm.it.mobile.extensions.bitmap

import android.content.Context
import android.graphics.Bitmap
import android.net.Uri
import androidx.core.graphics.drawable.RoundedBitmapDrawable
import java.io.File

fun Bitmap.convertToUri(context: Context): Uri =
    BitmapExtensionsImpl.convertToUri(
        context,
        this
    )

fun Bitmap.convertToByteArray(): ByteArray =
    BitmapExtensionsImpl.convertToByteArray(this)

fun Bitmap.convertToBase64(): String =
    BitmapExtensionsImpl.convertToBase64(this)

fun Bitmap.convertToRoundedBitmap(context: Context): RoundedBitmapDrawable? =
    BitmapExtensionsImpl.toRoundedBitmap(
        context,
        this
    )

fun Bitmap.getCropped(): Bitmap =
    BitmapExtensionsImpl.getCropped(this)

fun Bitmap.convertToSmallBitmap(): Bitmap =
    BitmapExtensionsImpl.convertToSmallBitmap(this)

fun Bitmap.saveToFile(file: File) =
    BitmapExtensionsImpl.saveBitmapInFile(
        this,
        file
    )