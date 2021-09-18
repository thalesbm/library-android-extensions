package bm.it.mobile.extensions.color

import android.content.res.Resources
import androidx.fragment.app.FragmentActivity

fun Int.getColor(activity: FragmentActivity) =
    ColorExtensionsImpl.getDrawable(activity, this)

fun Int.getColor(resources: Resources) =
    ColorExtensionsImpl.getDrawable(resources, this)
