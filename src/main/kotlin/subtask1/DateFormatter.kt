package subtask1

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*
import kotlin.reflect.KClass

class DateFormatter {


    // TODO: Complete the following function
    fun toTextDay(day: String, month: String, year: String): String {
        var dateInput = getDate(day) + "/" + getMonth(month) + "/" + getYear(year)
        return if (validInputDate(dateInput)) {
            var date = SimpleDateFormat("dd/MM/yyyy").parse(dateInput)
            day + " " + createStringFromDate(date)
        } else {
            "Такого дня не существует"
        }
    }

    fun createStringFromDate(date: Date): String {
        var days = mapOf(
            Calendar.MONDAY to "понедельник",
            Calendar.TUESDAY to "вторник",
            Calendar.WEDNESDAY to "среда",
            Calendar.THURSDAY to "четверг",
            Calendar.FRIDAY to "пятница",
            Calendar.SATURDAY to "суббота",
            Calendar.SUNDAY to "воскресенье"
        )

        var months = mapOf(
            Calendar.JANUARY to "января",
            Calendar.FEBRUARY to "февраля",
            Calendar.MARCH to "марта",
            Calendar.APRIL to "апреля",
            Calendar.MAY to "мая",
            Calendar.JUNE to "июня",
            Calendar.JULY to "июля",
            Calendar.AUGUST to "августа",
            Calendar.SEPTEMBER to "сентября",
            Calendar.OCTOBER to "октября",
            Calendar.NOVEMBER to "ноября",
            Calendar.DECEMBER to "декабря"
        )


        val c = Calendar.getInstance()
        c.time = date
        val month = c[Calendar.MONTH]
        val dayOfWeek = c[Calendar.DAY_OF_WEEK]
        return months.get(month) + ", " + days.get(dayOfWeek)
    }


    fun getDate(s: String): String {
        if (s.length > 2)
            return "bad input"
        var input = s
        while (!(input.length == 2)) {
            input = "0" + s;
        }

        return input
    }

    fun getMonth(s: String): String {
        return getDate(s);
    }

    fun getYear(s: String): String {
        if (s.length > 4)
            return "bad input"
        var input = s
        while (!(input.length == 4)) {
            input = "0" + s;
        }

        return input
    }

    fun validInputDate(input: String): Boolean {
        val formatString = "dd/MM/yyyy"

        try {
            val format = SimpleDateFormat(formatString)
            format.isLenient = false
            format.parse(input)
        } catch (e: ParseException) {
            return false
        } catch (e: IllegalArgumentException) {
            return false
        }

        return true
    }

}
