package jetbrains.kotlin.course.warmup

import kotlin.math.absoluteValue
import kotlin.math.max

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

fun countPartialMatches(secret: String, guess: String): Int = (countExactMatches(secret, guess) - countAllMatches(secret, guess)).absoluteValue

fun countExactMatches(secret: String, guess: String): Int = secret.filterIndexed { index, symbol ->  guess[index] == symbol}.length

fun countAllMatches(secret: String, guess: String): Int {
    val firstResult = secret.filter { it in guess }.length
    val secondResult = guess.filter { it in secret }.length
    return minOf(firstResult, secondResult)

}

fun isComplete(secret: String, guess: String): Boolean = secret == guess

fun playGame(secret: String, wordLength: Int, maxAttemptsCount: Int): Unit {

    var isComplete: Boolean
    do {
        println("Please input your guess. It should be of length $wordLength.")
        val guess = safeReadLine()
        isComplete = isComplete(secret, guess)
    } while (!isComplete)
}

fun printRoundResults(secret: String, guess: String) {
    val exactMatches = countExactMatches(secret, guess)
    val partialMatches = countPartialMatches(secret, guess)
    println("Your guess has $exactMatches full matches and $partialMatches partial matches.")
}

fun isWon(complete: Boolean, attempts: Int, maxAttemptsCount: Int): Boolean {
    return maxAttemptsCount >= attempts && complete
}

fun isLost(complete: Boolean, attempts: Int, maxAttemptsCount: Int): Boolean {
    return maxAttemptsCount <= attempts && complete
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
