fun enterNumber(min: Int = Int.MIN_VALUE, max: Int = Int.MAX_VALUE): Int {
    var number: Int? = null
    val prompt: String = if (min == Int.MIN_VALUE || max == Int.MAX_VALUE) {
        "Enter a number: "
    } else {
        "Enter a number between $min and $max: "
    }

    do {
        print(prompt)
        val input: String = readlnOrNull() ?: continue

        number = input.toIntOrNull()
        if (number == null) {
            println("input is not a valid integer\n")
            continue
        }

        if (number < min || number > max) {
            // number not within range
            println("please enter a number between $min and $max\n")
            number = null
        }
    } while (number == null)

    return number
}

fun sum(vararg numbers: Int): Int {
//    val total = numbers.fold(0) { acc, i -> acc + i}
    var total = 0
    for (number in numbers) {
        total += number
    }
    return total
}

fun multiply(vararg numbers: Int): Int {
//    val result = numbers.fold(1) { acc, i -> acc * i}
    var result = 1
    for (number in numbers) {
        result *= number
    }
    return result
}

fun divide(numOne: Double, numTwo: Double): Double? {
    if (numTwo == 0.0) {
        // check divisor not zero. prevent divide by zero errors
        return null
    }

    return numOne / numTwo
}

fun main() {
    val numberOne = enterNumber()
    val numberTwo = enterNumber(0, 10)

    println("$numberOne + $numberTwo = ${sum(numberOne, numberTwo)}")
    println("$numberOne * $numberTwo = ${multiply(numberOne, numberTwo)}")
    println("$numberOne / $numberTwo = ${divide(numberOne.toDouble(), numberTwo.toDouble()) ?: "undefined"}")
}