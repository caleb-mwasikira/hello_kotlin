/**
 * Write a function that takes a string input and returns the string in a reversed case and order.
 *
 * Examples
 * invert("dLROW YM sI HsEt") ➞ "TeSh iS my worlD"
 * invert("ytInIUgAsnOc") ➞ "CoNSaGuiNiTY"
 * invert("step on NO PETS") ➞ "step on NO PETS"
 * invert("XeLPMoC YTiReTXeD") ➞ "dExtErIty cOmplEx"
 *
 */

fun invert(str: String): String {
    var resultStr: String = ""
    val strCharArray = str.toCharArray()

    for (i in strCharArray.size - 1 downTo 0) {
        val char: Char = strCharArray[i]

        val invertedChar: Char = if (char.isUpperCase()) {
            char.lowercaseChar()
        } else {
            char.uppercaseChar()
        }
        resultStr += invertedChar
    }

    return resultStr
}

fun main() {
    val tests: Map<String, String> = mapOf(
        "dLROW YM sI HsEt" to "TeSh iS my worlD",
        "ytInIUgAsnOc" to "CoNSaGuiNiTY",
        "step on NO PETS" to "step on NO PETS",
        "XeLPMoC YTiReTXeD" to "dExtErIty cOmplEx"
    )

    for ((str, expectedResult) in tests) {
        val result = invert(str)
        if (result != expectedResult) {
            println("incorrect algorithm")
        } else {
            println("correct algorithm")
        }

        println("input: $str")
        println("expected result: $expectedResult")
        println("result: $result\n")
    }
}