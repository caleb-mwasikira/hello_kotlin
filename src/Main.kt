import kotlin.system.exitProcess

fun main() {
    val maxNum = 100
    val minNum = 0
    val luckyNumber = (Math.random() * maxNum).toInt() + minNum
    var userGuess: Int?
    var numGuesses = 5

    do {
        if (numGuesses == 0) {
            println("no more guesses left. You lose :(")
            break
        }

        println("Guess the lucky number between $minNum and $maxNum")
        val userInput = readlnOrNull()
        if (userInput == null) {
            println("you chose not to play. Goodbye :/")
            exitProcess(1)
        }

        // validate userInput is an integer
        userGuess = userInput.toIntOrNull()
        if (userGuess == null) {
            println("please select a number between $minNum and $maxNum")
            continue
        }

        // validate user's guess is between minNum and maxNum
        if (userGuess < minNum || userGuess > maxNum) {
            println("please select a number between $minNum and $maxNum")
            continue
        }

        // hot or cold
        if (userGuess > luckyNumber) {
            println("too high")
        } else if (userGuess < luckyNumber) {
            println("too low")
        } else {
            println("you are right. the lucky number is indeed $luckyNumber")
        }

        numGuesses--
        println("$numGuesses guesses left!")
    } while (userGuess != luckyNumber)
}