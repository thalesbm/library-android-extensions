package bm.it.mobile.extensions.float

import android.content.Context

fun Float.convertDpToPixel(context: Context): Float =
    FloatExtensionsImpl.convertDpToPixel(
        context,
        this
    )