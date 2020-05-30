package bm.it.mobile.library.uri

import android.content.Context
import android.database.Cursor
import android.net.Uri
import android.provider.MediaStore

object UriExtensionsImpl {

    fun convertToString(context: Context, uri: Uri): String {
        val projection = arrayOf(MediaStore.Images.Media.DATA)
        val cursor: Cursor = context.contentResolver.query(uri, projection, null, null, null)
        if (cursor != null) {
            val columnIndex = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA)
            cursor.moveToFirst()
            val columnRealPath = cursor.getString(columnIndex)
            cursor.close()
            return columnRealPath
        }
        return ""
    }
}
