
fun convertScoreToBinary(base10: Int): String {
    if (base10 == 0) return "0" // Handle the case for 0 explicitly

    var base2 = ""
    var quotient = base10

    while (quotient != 0) {
        base2 = (quotient % 2).toString() + base2 // Prepend the current bit
        quotient /= 2 // Update quotient
    }

    return base2 // Return the binary string
}

fun computeAllergyTest(scoreInBinary:String):List<String> {
    val listAllergy=mutableListOf<String>()
    // Map for allergy scores
    val allergens = listOf("eggs", "peanuts", "shellfish", "strawberries", "tomatoes", "chocolate", "pollen", "cats")

    for (i in scoreInBinary.indices) {
        if (scoreInBinary[i] == '1') {
            if (i < allergens.size) {
                listAllergy.add(allergens[i]) // Add the corresponding allergen
            }

        }
    }
    return listAllergy
    }

fun allergyTest(score:Int):String  {
    val scoreCtrl=handleCaseScoreValueCannotBeContainedOn8Bits(score)
    val scoreInBinary=convertScoreToBinary(scoreCtrl).reversed()
    val resultList=computeAllergyTest(scoreInBinary)
    val resultString=resultList.joinToString(", ") // convert list to string
    return resultString
    }

fun handleCaseScoreValueCannotBeContainedOn8Bits(score:Int):Int {
    return if ((score >= 256) && (score<512))
        score-256
    else if ((score >=512 && (score<1024)))
        score-512
    else
        score-1024

}

fun main(args: Array<String>) {
    println(allergyTest(160))
    println(allergyTest(257))
    println(allergyTest(1026))
}