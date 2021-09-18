package bm.it.mobile.extensions.string

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import androidx.core.graphics.drawable.RoundedBitmapDrawable

fun String.convertToFloat(): Float =
    StringExtensionsImpl.convertToFloat(this)

fun String.convertImagePathToBitmap(): Bitmap =
    StringExtensionsImpl.convertImagePathToBitmap(this)

fun String.convertBase64ToBitmap(): Bitmap =
    StringExtensionsImpl.convertBase64ToBitmap(this)

fun String.convertImageDrawableNameToDrawable(context: Context): Drawable? =
    StringExtensionsImpl.convertImageDrawableNameToDrawable(context, this)

fun String.convertImageFileNameToRoundedImage(context: Context): RoundedBitmapDrawable? =
    StringExtensionsImpl.convertImageFileNameToRoundedImage(context, this)

fun String.convertBase64ToRoundedBitmap(context: Context): RoundedBitmapDrawable? =
    StringExtensionsImpl.convertBase64ToRoundedBitmap(context, this)

fun String.convertBase64ToByteArray(): ByteArray =
    StringExtensionsImpl.convertBase64ToByteArray(this)

fun String.convertImagePathToBitmapResizeImage(): Bitmap =
    StringExtensionsImpl.convertImagePathToBitmapResizeImage(this)

fun String.convertImagePathToBase64(): String =
    StringExtensionsImpl.convertImagePathToBase64(this)

fun String.rotateImageFromImagePath(): Bitmap =
    StringExtensionsImpl.rotateImageFromImagePath(this)

fun String.convertImagePathToDigestSHA256(): String =
    StringExtensionsImpl.convertImagePathToDigestSHA256(this)
