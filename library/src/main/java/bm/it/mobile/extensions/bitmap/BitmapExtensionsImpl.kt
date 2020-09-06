package bm.it.mobile.extensions.bitmap

import android.content.Context
import android.graphics.*
import android.net.Uri
import android.provider.MediaStore
import android.util.Base64
import androidx.core.graphics.drawable.RoundedBitmapDrawable
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileOutputStream
import java.io.IOException

object BitmapExtensionsImpl {

    fun convertToUri(context: Context, bitmap: Bitmap): Uri {
        val path = MediaStore.Images.Media.insertImage(
            context.contentResolver,
            bitmap,
            "Title",
            null
        )
        return Uri.parse(path)
    }

    fun convertToByteArray(bitmap: Bitmap): ByteArray {
        val outputStream = ByteArrayOutputStream()
        var tam = 50
        var compressed: Boolean
        do {
            compressed = bitmap.compress(Bitmap.CompressFormat.JPEG, tam, outputStream)
            tam -= 10
        } while (!compressed && tam != 0)
        return outputStream.toByteArray()
    }

    fun convertToBase64(bitmap: Bitmap): String {
        val byteArrayOutputStream = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.JPEG, 70, byteArrayOutputStream)
        val byteArray = byteArrayOutputStream.toByteArray()
        return Base64.encodeToString(byteArray, Base64.NO_WRAP)
    }

    fun toRoundedBitmap(context: Context, bitmap: Bitmap): RoundedBitmapDrawable? {
        val roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(context.resources, bitmap)
        roundedBitmapDrawable.isCircular = true
        return roundedBitmapDrawable
    }

    fun getCropped(bitmap: Bitmap): Bitmap {
        val output = Bitmap.createBitmap(bitmap.width, bitmap.height, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(output)
        val color = -0xbdbdbe
        val paint = Paint()
        val rect = Rect(0, 0, bitmap.width, bitmap.height)
        paint.isAntiAlias = true
        canvas.drawARGB(0, 0, 0, 0)
        paint.color = color
        canvas.drawCircle(
            bitmap.width / 2.toFloat(),
            bitmap.height / 2.toFloat(),
            bitmap.width / 2.toFloat(),
            paint
        )
        paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC_IN)
        canvas.drawBitmap(bitmap, rect, rect, paint)
        return output
    }

    fun convertToSmallBitmap(largeBitmap: Bitmap): Bitmap {
        val imageStream = ByteArrayOutputStream()
        largeBitmap.compress(Bitmap.CompressFormat.JPEG, 90, imageStream)
        val imageBytes = imageStream.toByteArray()
        return BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.size)
    }

    @Throws(IOException::class)
    fun saveBitmapInFile(bitmap: Bitmap, file: File) {
        val mFileOutStream = FileOutputStream(file)
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, mFileOutStream)
        mFileOutStream.flush()
        mFileOutStream.close()
    }
}
