package bm.it.mobile.extensions.date

import java.util.*

fun Date.formatDate(pattern: String): String =
    DateExtensionsImpl.formatDate(pattern, this)

fun Date.formatToBrazilianDate(): String =
    DateExtensionsImpl.formatToBrazilianDate(this)

fun Date.formatToBrazilianDateWithHour(): String =
    DateExtensionsImpl.formatToBrazilianDateWithHour(this)

fun Date.compareToDate(date: Date): Boolean =
    DateExtensionsImpl.compareToDate(this, date)