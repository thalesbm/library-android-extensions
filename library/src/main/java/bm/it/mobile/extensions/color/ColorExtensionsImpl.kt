package bm.it.mobile.extensions.color

import android.content.res.Resources
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.FragmentActivity

object ColorExtensionsImpl {

    fun getDrawable(activity: FragmentActivity, id: Int) =
        ContextCompat.getColor(activity, id)

    fun getDrawable(resources: Resources, id: Int) =
        ResourcesCompat.getColor(resources, id, null)

}
