const val number = 153

fun isNbAnArmstrongNumber(n: Int): Boolean {
    val str=n.toString() //convert the number to a string so we could access any digit
    val power=str.length
    var sum =0
    for (i in 0 until power) { // Use until to avoid IndexOutOfBoundsException
        val digit = str[i].toString().toInt() // Convert Char to Int correctly
        sum += Math.pow(digit.toDouble(), power.toDouble()).toInt() // Convert to Double and then to Int
    }

    return sum == n // Compare the sum to the original number
}

fun improvedIsNbAnArmstrongNumber(n: Int): Boolean {
    var temp = n
    var sum = 0
    val power = n.toString().length // Count the number of digits

    while (temp > 0) {
        val digit = temp % 10 // Get the last digit
        sum += Math.pow(digit.toDouble(), power.toDouble()).toInt() // Calculate the power and add to sum
        temp /= 10 // Remove the last digit
    }

    return sum == n // Check if the sum equals the original number
}

fun main(args: Array<String>) {
    println("is ${number} a Armstrong Number")
    println(isNbAnArmstrongNumber(number))
    println(improvedIsNbAnArmstrongNumber(number))
}