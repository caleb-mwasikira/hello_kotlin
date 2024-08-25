import java.time.LocalDate
import java.time.Month

/**
 * Create a function that takes two dates and returns the number of days
 * between the first and second date.
 */

fun daysBetween(dateOne: LocalDate, dateTwo: LocalDate): Int {
    if (dateOne == dateTwo) {
        return 0
    }

    // set startDate as smallest date and endDate as largest date
    val startDate: LocalDate = if (dateOne < dateTwo) dateOne else dateTwo
    val endDate: LocalDate = if (dateOne > dateTwo) dateOne else dateTwo

    // if same year and same month
    if (startDate.year == endDate.year && startDate.month == endDate.month) {
        return endDate.dayOfMonth - startDate.dayOfMonth
    }

    // if different year and same or different month
    var currentYear: Int = startDate.year
    var monthValue = startDate.monthValue
    var totalDays = 0

    while (true) {
        // numbers divisible by 12 will give a remainder of 0
        val num: Int = if (monthValue % 12 == 0) 12 else monthValue % 12
        val currentMonth = Month.of(num)
        val isLeapYear = (currentYear % 4) == 0

        if (currentYear == endDate.year && currentMonth == endDate.month) {
            totalDays += endDate.dayOfMonth
            break
        }

        if (currentYear == startDate.year && currentMonth == startDate.month) {
            val daysLeftInMonth: Int = currentMonth.length(isLeapYear) - startDate.dayOfMonth
            totalDays += daysLeftInMonth
        } else {
            // add entire month
            totalDays += currentMonth.length(isLeapYear)
        }

        // increment monthValue and update currentYear
        monthValue++
        currentYear = startDate.year + (monthValue / 12)
    }
    return totalDays
}

fun main() {
    val tests: Map<Int, Pair<LocalDate, LocalDate>> = mapOf(
        1956 to Pair(
            LocalDate.of(2015, Month.MAY, 14),
            LocalDate.of(2020, Month.SEPTEMBER, 20),
        ),
        4 to Pair(
            LocalDate.of(2019, Month.DECEMBER, 28),
            LocalDate.of(2020, Month.JANUARY, 1),
        ),
        137 to Pair(
            LocalDate.of(2019, Month.DECEMBER, 25),
            LocalDate.of(2020, Month.MAY, 10),
        ),
        0 to Pair(
            LocalDate.of(2019, Month.MAY, 25),
            LocalDate.of(2019, Month.MAY, 25),
        )
    )

    for ((expectedNumDays, dates) in tests) {
        val numDays = daysBetween(dates.first, dates.second)
        if (numDays != expectedNumDays) {
            println("incorrect algorithm")
        } else {
            println("correct algorithm")
        }

        println(dates)
        println("expected days between: $expectedNumDays")
        println("result: $numDays\n")
    }
}
