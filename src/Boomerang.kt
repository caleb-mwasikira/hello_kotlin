/**
 * A boomerang is a V-shaped sequence that is either upright or upside down.
 * Specifically, a boomerang can be defined as: sub-array of length 3,
 * with the first and last digits being the same and the middle digit
 * being different.
 *
 * Some boomerang examples: [3, 7, 3], [1, -1, 1], [5, 6, 5]
 *
 * [3, 7, 3, 2, 1, 5, 1, 2, 2, -2, 2]
 * // 3 boomerangs in this sequence:  [3, 7, 3], [1, 5, 1], [2, -2, 2]
 *
 * [1, 7, 1, 7, 1, 7, 1]
 * // 5 boomerangs (from left to right):
 * [1, 7, 1], [7, 1, 7], [1, 7, 1], [7, 1, 7], and [1, 7, 1]
 *
 * [5, 5, 5] (triple identical digits)
 * is NOT considered a boomerang because the middle digit
 * is identical to the first and last.
 */

fun findBoomerangs(numbers: List<Int>): List<List<Int>> {
    val boomerangs = mutableListOf<List<Int>>()
    val lastIndex = numbers.size - 1

    for (index in numbers.indices) {
        val nextIndex = index + 1
        val nextNextIndex = index + 2

        if (nextIndex >= lastIndex) {
            // out of bounds or no more boomerangs beyond this point
            break
        }

        if (numbers[index] == numbers[nextIndex]) {
            // [2, 2, ...]. Not a boomerang
            continue
        }

        if (numbers[index] == numbers[nextNextIndex]) {
            val boomerang = numbers.slice(index..nextNextIndex)
            boomerangs.add(boomerang)
        }
    }
    return boomerangs
}

fun main() {
    // map of test to expectedResult
    val tests: Map<List<Int>, List<List<Int>>> = mapOf(
        listOf(5, 5, 5) to listOf(),
        listOf(5, 3, 5) to listOf(
            listOf(5, 3, 5)
        ),
        listOf(9, 5, 9, 5, 1, 1, 1) to listOf(
            listOf(9, 5, 9), listOf(5, 9, 5)
        ),
        listOf(5, 6, 6, 7, 6, 3, 9) to listOf(
            listOf(6, 7, 6)
        ),
        listOf(4, 4, 4, 9, 9, 9, 9) to listOf(),
        listOf(3, 7, 3, 2, 1, 5, 1, 2, 2, -2, 2) to listOf(
            listOf(3, 7, 3), listOf(1, 5, 1), listOf(2, -2, 2),
        ),
        listOf(1, 7, 1, 7, 1, 7, 1) to listOf(
            listOf(1, 7, 1), listOf(7, 1, 7),
            listOf(1, 7, 1), listOf(7, 1, 7),
            listOf(1, 7, 1)
        ),
    )

    for ((test, expectedResult) in tests) {
        val result: List<List<Int>> = findBoomerangs(test)
        if (result != expectedResult) {
            println("incorrect algorithm")
        } else {
            println("correct algorithm")
        }

        println("test: $test")
        println("expected: $expectedResult")
        println("got: $result\n")
    }
}