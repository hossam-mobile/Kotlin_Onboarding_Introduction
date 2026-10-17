package jetbrains.kotlin.course.warmup

// You will use this function later
fun getGameRules(wordLength: Int, maxAttemptsCount: Int, secretExample: String) =
    "Welcome to the game! $newLineSymbol" +
            newLineSymbol +
            "Two people play this game: one chooses a word (a sequence of letters), " +
            "the other guesses it. In this version, the computer chooses the word: " +
            "a sequence of $wordLength letters (for example, $secretExample). " +
            "The user has several attempts to guess it (the max number is $maxAttemptsCount). " +
            "For each attempt, the number of complete matches (letter and position) " +
            "and partial matches (letter only) is reported. $newLineSymbol" +
            newLineSymbol +
            "For example, with $secretExample as the hidden word, the BCDF guess will " +
            "give 1 full match (C) and 1 partial match (B)."


fun generateSecret() = "ABCD"

fun countPartialMatches(secret: String, guess: String): Int = TODO("Not implemented yet!")

fun countExactMatches(secret: String, guess: String): Int = secret.filterIndexed { index, symbol ->  guess[index] == symbol}.length

fun isComplete(secret: String, guess: String): Boolean = secret == guess

fun playGame(secret: String, wordLength: Int, maxAttemptsCount: Int): Unit {

    var isComplete: Boolean
    do {
        println("Please input your guess. It should be of length $wordLength.")
        val guess = safeReadLine()
        isComplete = isComplete(secret, guess)
    } while (!isComplete)
}

fun main() {
    // Write your solution here

    val wordLength: Int = 4
    val maxAttemptsCount: Int = 3
    val secretExample: String = "ACEB"

    val gameRules: String = getGameRules(wordLength, maxAttemptsCount, secretExample)

    println(gameRules)

    val secret = generateSecret()

    playGame(secret, wordLength, maxAttemptsCount)
}
