package bm.it.mobile.extensions.drawable

import android.content.res.Resources
import androidx.fragment.app.FragmentActivity

fun Int.getDrawable(activity: FragmentActivity) =
    DrawableExtensionsImpl.getDrawable(activity, this)

fun Int.getDrawable(resources: Resources) =
    DrawableExtensionsImpl.getDrawable(resources, this)
