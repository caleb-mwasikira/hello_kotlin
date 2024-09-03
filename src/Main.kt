

fun fizzBuzz(number: Int): String {
    val result = when {
        number % 15 == 0 -> "FizzBuzz"
        number % 3 == 0 -> "Fizz"
        number % 5 == 0 -> "Buzz"
        else -> "$number"
    }
    return result
}

fun main(args: Array<String>) {
    for (number in 100 downTo 0 step 2) {
        val result = fizzBuzz(number)
        println(result)
    }
}