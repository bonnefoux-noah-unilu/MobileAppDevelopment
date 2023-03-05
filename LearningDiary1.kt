import kotlin.random.Random

fun main(){
    var random = generateRandomNumber()
    println(random)

    while(true){
        println("Please enter a 4 digit number")
        var userInput = readLine()
        if (userInput == null || userInput.length != 4) {
            println("Please enter a 4 digit number")
            continue
        }
        checkGuess(userInput, random)
        if (checkGuess(userInput, random).second == 4) {
            println("You guessed the number!")
            break
        } else {
            println("${checkGuess(userInput, random).first}:${checkGuess(userInput, random).second}")
        }

    }
    
}


fun generateRandomNumber(): String {
    var random = Random.nextInt(1000, 9999) 
    var randomString = random.toString()
    var randomSet = randomString.toSet() 
    if (randomSet.size == 4) {
        return randomString
    } else {
        return generateRandomNumber() 
    }
}

fun checkGuess(guess: String, actual: String) : Pair<Int,Int>{
    val numCorrect = guess.count{it in actual}
    val numExact = guess.zip(actual).count{it.first == it.second}
    return Pair(numCorrect, numExact)
}


  
