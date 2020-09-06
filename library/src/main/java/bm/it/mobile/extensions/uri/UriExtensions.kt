package bm.it.mobile.extensions.uri

import android.content.Context
import android.net.Uri

fun Uri.convertToString(context: Context): String =
    UriExtensionsImpl.convertToString(context, this)