package bm.it.mobile.extensions.float

import android.content.Context
import android.util.DisplayMetrics

object FloatExtensionsImpl {

    fun convertDpToPixel(context: Context, dp: Float): Float {
        val metrics = context.resources.displayMetrics
        return dp * (metrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT)
    }
}
