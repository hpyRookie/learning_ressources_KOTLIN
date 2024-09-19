
fun getFactorOfAInteger(n:Int):List<Int>{
    val listOfFactors = mutableListOf<Int>()
    for (i in 1..10) {
        if (n % i == 0){
            //println("$i is a factor of $n")
            listOfFactors.add(i)
        }
    }
    return listOfFactors
}

fun computeAliquotSum(listN: List<Int>): Int {
    var sum=0
    for(i in 0.. listN.size-1){
        sum+=listN[i] //compute sum of factors
    }
    return sum
}

fun categorizeNumberWithNicomachusClassification(number:Int,aliquotSum:Int){
    if (number==aliquotSum){
        println("$number is a PERFECT Number")
    }
    else if (number<aliquotSum){
        println("$number is a ABUNDANT Number")
    }
    else{
        println("$number is a DEFICIENT Number")
    }
}
fun main(args: Array<String>) {
    val n=mutableListOf(6, 28, 12, 24, 11)
    for (i in n.indices) {
        print("Compute Aliquot sum of ${n[i]} = ")
        val alSum = computeAliquotSum(getFactorOfAInteger(n[i]))
        println(alSum)
        println("********")
        categorizeNumberWithNicomachusClassification(n[i], alSum)
        println()
    }

}