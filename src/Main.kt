import java.util.*

fun main() {
    var isPlayAgain: Boolean
    val gameOptions = arrayOf("Rock", "Paper", "Scissors")

    do {
        val userChoice = getUserChoice(gameOptions)
        val gameChoice = getGameChoice(gameOptions)

        println("You chose $userChoice, I chose $gameChoice")
        val userWin = (userChoice == "Rock" && gameChoice == "Scissors") ||
                (userChoice == "Paper" && gameChoice == "Rock") ||
                (userChoice == "Scissors" && gameChoice == "Paper")
        val isDraw = userChoice == gameChoice

        if (userWin) {
            println("You win!")
        } else if (isDraw) {
            println("Draw")
        } else {
            println("I win!")
        }

        isPlayAgain = askToPlayAgain()
    } while (isPlayAgain)

    println("Exiting program... Bye :)")
}

fun askToPlayAgain(): Boolean {
    var userChoice = ""
    val validChoices = arrayOf("y", "n")

    while (userChoice !in validChoices) {
        println("Do you wish to play again? y/n")
        userChoice = (readlnOrNull() ?: "").lowercase()

        if (userChoice !in validChoices) println("Invalid option selected, please select either y/n")
    }
    println()
    return userChoice == "y"
}

fun getUserChoice(gameOptions: Array<String>): String {
    println("Select one of the following: ")
    for ((index, option) in gameOptions.withIndex()) {
        println("$index) $option")
    }

    var userChoice = ""
    while(userChoice !in gameOptions) {
        val userInput: String = readlnOrNull() ?: ""

        if (userInput.toIntOrNull() != null) {
            // user selected gameOption by index
            val selectedIndex = userInput.toInt()
            if (selectedIndex >=0 && selectedIndex < gameOptions.size) {
                userChoice = gameOptions[selectedIndex]
            }
        } else {
            // user selected gameOption by string
            userChoice = userInput.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
        }

        if(userChoice !in gameOptions) println("Invalid option selected $userInput")
    }
    return userChoice
}

fun getGameChoice(gameOptions: Array<String>): String {
    val randomIndex: Int = (Math.random() * gameOptions.size).toInt()
    return gameOptions[randomIndex]
}