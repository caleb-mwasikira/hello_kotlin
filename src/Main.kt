import kotlin.system.exitProcess

fun generateLuckyNumber(min: Int = 0, max: Int = 100): Int {
    return (Math.random() * max).toInt() + min
}

fun playGame() {
    val maxNum = 100
    val minNum = 0
    val luckyNumber = generateLuckyNumber(minNum, maxNum)
    var userGuess: Int?
    var numGuesses = 5

    do {
        if (numGuesses == 0) {
            println("no more guesses left. You lose.")
            println("the lucky number was $luckyNumber\n")
            break
        }

        print("guess the lucky number between $minNum and $maxNum\n> ")
        val userInput = readlnOrNull()
        if (userInput == null) {
            println("you chose not to play. Goodbye :/")
            break
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
        println("$numGuesses guesses left!\n")
    } while (userGuess != luckyNumber)
}

fun main() {
    var playAgain = true

    while (playAgain) {
        playGame()

        print("do you wish to play again? (y/n)\n> ")
        val userInput = readlnOrNull() ?: run {
            println("you chose not to play. Goodbye :/")
            exitProcess(1)
        }

        playAgain = userInput.lowercase() == "y"
        if (playAgain) {
            println("\n") // add some spacing
        }
    }

    println("exiting program. Goodbye")
}