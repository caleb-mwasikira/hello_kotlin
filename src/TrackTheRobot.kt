/**
 * A robot roams around a 2D grid. It starts at (0, 0) facing North.
 * After each time it moves, the robot rotates 90 degrees clockwise.
 * Given the amount the robot has moved each time, you have to
 * calculate the robot's final position.
 *
 * To illustrate, if the robot is given the movements 20, 30, 10, 40
 * then it will move:
 *
 * 20 steps North, now at (0, 20)
 * 30 steps East, now at (30, 20)
 * 10 steps South. now at (30, 10)
 * 40 steps West, now at (-10, 10)
 * ...and will end up at coordinates (-10, 10).
 *
 * Examples
 * trackRobot(20, 30, 10, 40) ➞ [-10, 10]
 * trackRobot() ➞ [0, 0]
 * // No movement means the robot stays at (0, 0).
 *
 * trackRobot(-10, 20, 10) ➞ [20, -20]
 * // The amount to move can be negative.
 *
 * Notes
 * Each movement is an integer (whole number).
 */

enum class Direction(val intValue: Int) {
    NORTH(0),
    EAST(1),
    SOUTH(2),
    WEST(3);

    companion object {
        private fun fromIntValue(intValue: Int): Direction? {
            return entries.find { direction -> direction.intValue == intValue }
        }

        /**
         * circularly rotate robot 90deg clockwise
         */
        fun rotateClockwise(direction: Direction): Direction {
            val newDirectionValue: Int = (direction.intValue + 1) % entries.size
            val newDirection: Direction = Direction.fromIntValue(newDirectionValue) ?: NORTH
            return newDirection
        }
    }
}

fun trackRobot(movement: List<Int>): Pair<Int, Int> {
    var direction: Direction = Direction.NORTH
    var xPos: Int = 0
    var yPos: Int = 0

    for (mov in movement) {
        when (direction) {
            Direction.NORTH -> yPos += mov
            Direction.SOUTH -> yPos -= mov
            Direction.EAST -> xPos += mov
            Direction.WEST -> xPos -= mov
        }

        direction = Direction.rotateClockwise(direction)
    }
    return Pair(xPos, yPos)
}

fun main() {
    val tests: Map<List<Int>, Pair<Int, Int>> = mapOf(
        listOf(20, 30, 10, 40) to Pair(-10, 10),
        listOf<Int>() to Pair(0, 0),
        listOf(-10, 20, 10) to Pair(20, -20),
    )

    for ((movement, expectedPos) in tests) {
        val pos = trackRobot(movement)

        if (pos != expectedPos) {
            println("incorrect algorithm")
        } else {
            println("correct algorithm")
        }

        println("input: $movement")
        println("expected position: $expectedPos")
        println("result: $pos\n")
    }
}