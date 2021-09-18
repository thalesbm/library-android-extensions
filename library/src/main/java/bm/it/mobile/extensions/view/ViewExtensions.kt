package bm.it.mobile.extensions.view

import android.graphics.Bitmap
import android.view.View

fun View.getBitmap(): Bitmap = ViewExtensionsImpl.getBitmap(this)
