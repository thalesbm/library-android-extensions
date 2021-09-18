package bm.it.mobile.extensions.string

import android.content.Context
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Matrix
import android.graphics.drawable.Drawable
import android.media.ExifInterface
import android.util.Base64
import android.util.Log
import androidx.core.content.res.ResourcesCompat
import androidx.core.graphics.drawable.RoundedBitmapDrawable
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory
import bm.it.mobile.extensions.bitmap.convertToBase64
import bm.it.mobile.extensions.bitmap.convertToByteArray
import bm.it.mobile.extensions.bitmap.convertToRoundedBitmap
import bm.it.mobile.extensions.bitmap.convertToSmallBitmap
import bm.it.mobile.extensions.byteArray.convertToBase64
import org.apache.commons.io.IOUtils
import java.io.FileInputStream
import java.security.MessageDigest

object StringExtensionsImpl {

    fun convertImagePathToBitmap(path: String): Bitmap {
        return BitmapFactory.decodeFile(path)
    }

    @Throws(IllegalArgumentException::class)
    fun convertBase64ToBitmap(input: String): Bitmap {
        val decodedByte = Base64.decode(input, 0)
        return BitmapFactory.decodeByteArray(decodedByte, 0, decodedByte.size)
    }

    fun convertImageDrawableNameToDrawable(context: Context, imageName: String): Drawable? {
        val res: Resources = context.resources
        val resourceId = res.getIdentifier(imageName, "drawable", context.packageName)
        return ResourcesCompat.getDrawable(res, resourceId, null)
    }

    fun convertImageFileNameToRoundedImage(
        context: Context,
        fileName: String
    ): RoundedBitmapDrawable? {
        val roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(context.resources, fileName)
        roundedBitmapDrawable.isCircular = true
        return roundedBitmapDrawable
    }

    fun convertBase64ToRoundedBitmap(context: Context, base64: String): RoundedBitmapDrawable? {
        val bitmap: Bitmap = base64.convertBase64ToBitmap()
        return bitmap.convertToRoundedBitmap(context)
    }

    fun convertBase64ToByteArray(base64: String): ByteArray {
        val bitmap: Bitmap = base64.convertBase64ToBitmap()
        return bitmap.convertToByteArray()
    }

    fun convertImagePathToBitmapResizeImage(path: String): Bitmap {
        val bitmap = path.convertImagePathToBitmap()
        return bitmap.convertToSmallBitmap()
    }

    fun convertImagePathToBase64(path: String): String {
        val bitmap = path.convertImagePathToBitmap()
        return bitmap.convertToBase64()
    }

    fun rotateImageFromImagePath(path: String): Bitmap {
        var defaultOrientation = -1
        var myBitmap = path.convertImagePathToBitmap()
        try {
            val exif = ExifInterface(path)
            val orientation = exif.getAttributeInt(
                ExifInterface.TAG_ORIENTATION,
                ExifInterface.ORIENTATION_NORMAL
            )
            when (orientation) {
                ExifInterface.ORIENTATION_ROTATE_270 -> defaultOrientation = 270
                ExifInterface.ORIENTATION_ROTATE_180 -> defaultOrientation = 180
                ExifInterface.ORIENTATION_ROTATE_90 -> defaultOrientation = 90
            }
            Log.v("", "Exif orientation: $orientation")
        } catch (e: Exception) {
            e.printStackTrace()
        }
        val matrix = Matrix()
        matrix.postRotate(defaultOrientation.toFloat())
        myBitmap = Bitmap.createBitmap(
            myBitmap,
            0,
            0,
            myBitmap.width,
            myBitmap.height,
            matrix,
            true
        )
        return myBitmap
    }

    fun convertImagePathToDigestSHA256(path: String): String {
        var digest = ""
        try {
            val file = FileInputStream(path)
            val byteArr: ByteArray = IOUtils.toByteArray(file)
            val md = MessageDigest.getInstance("SHA-256")
            val digestByte = md.digest(byteArr)
            digest = digestByte.convertToBase64()
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }
        return digest
    }

    fun convertToFloat(text: String): Float {
        val value = text.replace(",", ".")
        return if (value.isEmpty()) {
            0F
        } else {
            value.toFloat()
        }
    }
}
