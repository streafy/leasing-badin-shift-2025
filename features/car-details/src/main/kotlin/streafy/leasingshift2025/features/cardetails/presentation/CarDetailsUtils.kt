package streafy.leasingshift2025.features.cardetails.presentation

import android.content.Context
import streafy.leasingshift2025.features.cardetails.R
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId
import java.time.format.TextStyle
import java.time.temporal.ChronoUnit
import java.util.Locale

fun formatRentDuration(rentStart: Long, rentEnd: Long, context: Context): String {
    val rentStartInstant = Instant.ofEpochMilli(rentStart)
    val rentStartLocalDate = LocalDate.ofInstant(rentStartInstant, ZoneId.systemDefault())
    val rentStartMonth = rentStartLocalDate.month.getDisplayName(TextStyle.FULL, Locale("ru", "RU"))
    val rentStartDay = rentStartLocalDate.dayOfMonth

    val rentEndInstant = Instant.ofEpochMilli(rentEnd)
    val rentEndLocalDate = LocalDate.ofInstant(rentEndInstant, ZoneId.systemDefault())
    val rentEndMonth = rentEndLocalDate.month.getDisplayName(TextStyle.FULL, Locale("ru", "RU"))
    val rentEndDay = rentEndLocalDate.dayOfMonth

    val daysBetween = ChronoUnit.DAYS.between(rentStartLocalDate, rentEndLocalDate).toInt()
    val daysBetweenString = context.resources.getQuantityString(
        R.plurals.car_details_days_plurals, daysBetween, daysBetween
    )

    return when {
        daysBetween == 0 -> "$rentStartDay $rentStartMonth"
        rentStartMonth == rentEndMonth -> "$rentStartDay - $rentEndDay $rentStartMonth ($daysBetweenString)"
        else -> "$rentStartDay $rentStartMonth – $rentEndDay $rentEndMonth ($daysBetweenString)"
    }
}

fun daysBetweenTimestamps(start: Long, end: Long): Int {
    val startInstant = Instant.ofEpochMilli(start)
    val startLocalDate = LocalDate.ofInstant(startInstant, ZoneId.systemDefault())

    val endInstant = Instant.ofEpochMilli(end)
    val endLocalDate = LocalDate.ofInstant(endInstant, ZoneId.systemDefault())

    return ChronoUnit.DAYS.between(startLocalDate, endLocalDate).toInt()
}
