package bm.it.mobile.extensions.drawable

import android.content.res.Resources
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.FragmentActivity

object DrawableExtensionsImpl {

    fun getDrawable(activity: FragmentActivity, id: Int) =
        ContextCompat.getDrawable(activity, id)

    fun getDrawable(resources: Resources, id: Int) =
        ResourcesCompat.getDrawable(resources, id, null)
}
