package bm.it.mobile.extensions.date

import java.text.SimpleDateFormat
import java.util.*

object DateExtensionsImpl {

    fun formatToBrazilianDate(date: Date) : String {
        return SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).format(date)
    }

    fun formatToBrazilianDateWithHour(date: Date) : String {
        return SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.ENGLISH).format(date)
    }

    fun formatDate(pattern: String, date: Date) : String {
        return SimpleDateFormat(pattern, Locale.ENGLISH).format(date)
    }

    fun compareToDate(date1: Date, date2: Date): Boolean {
        val cal1 = Calendar.getInstance()
        val cal2 = Calendar.getInstance()
        cal1.time = date1
        cal2.time = date2
        return (cal1[Calendar.YEAR] == cal2[Calendar.YEAR]
                && cal1[Calendar.DAY_OF_YEAR] == cal2[Calendar.DAY_OF_YEAR])
    }
}
