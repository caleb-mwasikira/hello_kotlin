import kotlin.math.pow
import kotlin.math.sqrt

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

fun <T : Number> sum(numbers: List<T>): T {
//    val total = numbers.fold(0) { acc, i -> acc + i }
    var total = 0.0
    for (number in numbers) {
        total += number.toDouble()
    }
    return total as T
}

fun <T : Number> multiply(numbers: List<T>): T {
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

fun generateRandomArray(size: Int, min: Int = 0, max: Int = 100): List<Int> {
    val numbers = mutableListOf<Int>()
    if (size <= 0 || max < min) {
        return numbers
    }

    for (index in 0..<size) {
        val randomNumber: Int = (Math.random() * max).toInt() + min
        numbers.add(index, randomNumber)
    }
    return numbers
}

/**
 * calculates the standard deviation of a dataset.
 * Standard Deviation = √(Σ(x - μ)² / N)
 */
fun standardDeviation(numbers: List<Int>): Double {
    // step 1: calculate the mean
    val mean: Double = sum(numbers).toDouble() / numbers.size.toDouble()

    // step 2: find the difference between each data point and the mean.
    // step 3: square each of the differences in step 2
    val squareDiff: List<Double> = numbers.map{ num ->
        (num - mean).pow(2.0)
    }

    // step 4: calculate the variance.
    // add up all the squared differences. divide the sum by the total number of values
    val variance: Double = sum(squareDiff) / squareDiff.size

    // step 5: the square root of the variance is the standard deviation
    return sqrt(variance)
}

fun main() {
//    val numberOne = enterNumber()
//    val numberTwo = enterNumber(0.0, 10.0)
//    val twoNumbers = listOf(numberOne, numberTwo)
//
//    println("%.4f + %.4f = %.4f".format(numberOne, numberTwo, sum(twoNumbers)))
//    println("%.4f * %.4f = %.4f".format(numberOne, numberTwo, multiply(twoNumbers)))
//
//    val divideResult = divide(numberOne, numberTwo)
//    print("%.4f / %.4f = ".format(numberOne, numberTwo))
//    if (divideResult == null) print("undefined") else print("%.4f".format(divideResult))
//    println()

    val numbers: List<Int> = generateRandomArray(10)
    val stdDeviation: Double = standardDeviation(numbers)
    println("numbers: $numbers\nstandard deviation: %.2f".format(stdDeviation))
}