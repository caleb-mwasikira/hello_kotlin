/**
 * Create a function that determines whether a number is Oddish or Evenish.
 * A number is Oddish if the sum of all of its digits is odd,
 * and a number is Evenish if the sum of all of its digits is even.
 * If a number is Oddish, return "Oddish". Otherwise, return "Evenish".
 *
 * For example, oddishOrEvenish(121) should return "Evenish",
 * since 1 + 2 + 1 = 4.
 *
 * oddishOrEvenish(41) should return "Oddish", since 4 + 1 = 5.
 */

fun oddishOrEvenish(number: Int): String {
    val numberStr = "$number"

    val sumOfDigits = numberStr.fold(0) { acc, char ->
        // convert character to integer
        val num = Character.getNumericValue(char)
        acc + num
    }
    return if(sumOfDigits % 2 == 0) "Evenish" else "Oddish"
}

fun main() {
    val tests: Map<Int, String> = mapOf(
        41 to "Oddish",
        121 to "Evenish"
    )

    for ((test, expectedResult) in tests) {
        val result: String = oddishOrEvenish(test)
        if (result != expectedResult) {
            println("incorrect algorithm!")
        } else {
            println("correct algorithm")
        }

        println("test: $test")
        println("expected result: $expectedResult")
        println("result: $result\n")
    }
}