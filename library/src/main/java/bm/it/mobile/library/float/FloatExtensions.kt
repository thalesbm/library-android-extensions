package bm.it.mobile.library.float

import android.content.Context

fun Float.convertDpToPixel(context: Context): Float =
    FloatExtensionsImpl.convertDpToPixel(context, this)