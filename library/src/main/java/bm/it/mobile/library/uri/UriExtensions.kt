package bm.it.mobile.library.uri

import android.content.Context
import android.net.Uri

fun Uri.convertToString(context: Context): String = UriExtensionsImpl.convertToString(context, this)