/**
 * In a board game, a piece may advance 1-6 tiles forward depending
 * on the number rolled on a six-sided die. If you advance your
 * piece onto the same tile as another player's piece, both of
 * you earn a bonus.
 *
 * Can you reach your friend's tile number in the next roll?
 * Create a function that takes your position a and your friend's
 * position b and returns a boolean representation of whether it's
 * possible to earn a bonus on any die roll.
 *
 * Tips:-
 *     i)  You cannot move backward.
 *     ii) If you are already on the same tile, return false,
 *     as you would be advancing away.
 *     iii)Expect only positive integer inputs.
 */

fun possibleBonus(myPos: Int, opponentPos: Int): Boolean {
    val isOnSamePos = myPos == opponentPos
    val isAheadOfOpponent = myPos > opponentPos
    if (isOnSamePos || isAheadOfOpponent) {
        return false
    }
    return (opponentPos - myPos) <= 6
}

fun main() {
    val tests: Map<Pair<Int, Int>, Boolean> = mapOf(
        Pair(3, 7) to true,
        Pair(1, 9) to false,
        Pair(5, 3) to false,
    )

    for((positions, expectedResult) in tests) {
        val result: Boolean = possibleBonus(positions.first, positions.second)
        if (result != expectedResult) {
            println("incorrect algorithm")
        } else {
            println("correct algorithm")
        }

        println(positions)
        println("expected result: $expectedResult")
        println("result: $result\n")
    }
}