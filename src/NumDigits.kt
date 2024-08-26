/**
 * Create a function that will return an integer number corresponding
 * to the amount of digits in the given integer num.
 *
 * Examples
 * numDigits(1000) ➞ 4
 * numDigits(12) ➞ 2
 * numDigits(1305981031) ➞ 10
 * numDigits(0) ➞ 1
 *
 * Notes
 * Try to solve this challenge without using strings!
 */

fun numDigits(number: Int): Int {
    var numDigits = 1
    var num = Math.abs(number) // no negative integers

    while(num > 9) {
        num /= 10
        numDigits++
    }
    return numDigits
}

fun main() {
    val tests: Map<Int, Int> = mapOf(
        1000 to 4,
        12 to 2,
        1305981031 to 10,
        0 to 1,
        -123456 to 6,
        99999999 to 8,
    )

    for ((number, expectedResult) in tests) {
        val result: Int = numDigits(number)
        if (result != expectedResult) {
            println("incorrect algorithm")
        } else {
            println("correct algorithm")
        }

        println("numDigits($number) -> $expectedResult")
        println("result: $result\n")
    }
}