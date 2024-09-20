import kotlin.math.pow

fun convertNumberToBase10(n:Int,base:Int):Int {
    val str = n.toString().reversed()//reverse so the list will have correct index
    var sum = 0
    for (i in str.indices) {
        val digit = str[i].toString().toInt() // Convert each character to digit
        sum += digit * base.toDouble().pow(i.toDouble()).toInt() // Calculate the contribution to the sum
    }
    return sum
}

fun main(args: Array<String>) {
    println(convertNumberToBase10(101010,2))
    println(convertNumberToBase10(42,10))
    println(convertNumberToBase10(1120,3))
}