package uz.otamurod.socialmediakmp.common.util

import kotlinx.datetime.LocalDateTime

object DateFormatter {
    // Function to capitalize the first letter of the month name
    private fun formatMonth(month: String): String {
        return month.replaceFirstChar { it.titlecase() }
    }

    fun parseDate(dateString: String): String {
        return try {
            val parsedDateTime = LocalDateTime.parse(dateString)

            buildString {
                append(formatMonth(parsedDateTime.month.name.lowercase()))
                append(" ${parsedDateTime.dayOfMonth}, ")
                append("${parsedDateTime.time.hour}:${parsedDateTime.time.minute}")
            }
        } catch (error: IllegalArgumentException) {
            dateString
        }
    }
}