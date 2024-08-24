fun enterNumber(min: Double = Double.MIN_VALUE, max: Double = Double.MAX_VALUE): Double {
    var number: Double? = null
    val prompt = if (min == Double.MIN_VALUE && max == Double.MAX_VALUE) {
        "Enter a number: "
    } else {
        "Enter a number between $min and $max: "
    }

    do {
        print(prompt)
        val input: String = readlnOrNull() ?: continue

        number = input.toDoubleOrNull()
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

fun <T : Number> sum(vararg numbers: T): T {
//    val total = numbers.fold(0) { acc, i -> acc + i }
    var total = 0.0
    for (number in numbers) {
        total += number.toDouble()
    }
    return total as T
}

fun <T : Number> multiply(vararg numbers: T): T {
    if (numbers.isEmpty()) {
        return 0.0 as T
    }

//    val result = numbers.fold(1) { acc, i -> acc * i}
    var result = 1.0
    for (number in numbers) {
        result *= number.toDouble()
    }
    return result as T
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
    val numberTwo = enterNumber(0.0, 10.0)

    println("%.4f + %.4f = %.4f".format(numberOne, numberTwo, sum(numberOne, numberTwo)))
    println("%.4f * %.4f = %.4f".format(numberOne, numberTwo, multiply(numberOne, numberTwo)))

    val divideResult = divide(numberOne, numberTwo)
    print("%.4f / %.4f = ".format(numberOne, numberTwo))
    if (divideResult == null) print("undefined") else print("%.4f".format(divideResult))
}