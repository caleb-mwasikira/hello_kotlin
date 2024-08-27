/**
 * Create a function that takes an array of strings and returns an array
 * with only the strings that have numbers in them. If there are no strings
 * containing numbers, return an empty array.
 *
 * Examples
 * numInStr(["1a", "a", "2b", "b"]) ➞ ["1a", "2b"]
 * numInStr(["abc", "abc10"]) ➞ ["abc10"]
 * numInStr(["abc", "ab10c", "a10bc", "bcd"]) ➞ ["ab10c", "a10bc"]
 * numInStr(["this is a test", "test1"]) ➞ ["test1"]
 */

fun numInStr(strs: List<String>): List<String> {
    val found = mutableListOf<String>()

    for (str in strs) {
        var hasDigit = false

        for (char in str) {
            if (char.isDigit()) {
                hasDigit = true
                break
            }
        }

        if (hasDigit) {
            found.add(str)
        }
    }
    return found
}

fun main() {
    val tests: Map<List<String>, List<String>> = mapOf(
        listOf("1a", "a", "2b", "b") to listOf("1a", "2b"),
        listOf("abc", "abc10") to listOf("abc10"),
        listOf("abc", "ab10c", "a10bc", "bcd") to listOf("ab10c", "a10bc"),
        listOf("this is a test", "test1") to listOf("test1")
    )

    for ((testInput, expectedResult) in tests) {
        val result: List<String> = numInStr(testInput)

        if (result != expectedResult) {
            println("incorrect algorithm")
        } else {
            println("correct algorithm")
        }

        println("input: $testInput")
        println("expected result: $expectedResult")
        println("result: $result\n")
    }
}
