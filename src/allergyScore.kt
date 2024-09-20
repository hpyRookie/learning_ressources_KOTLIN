
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
    val scoreInBinary=convertScoreToBinary(score).reversed()
    val resultList=computeAllergyTest(scoreInBinary)
    val resultString=resultList.joinToString(", ") // convert list to string
    return resultString
    }


fun main(args: Array<String>) {
    println(allergyTest(160))
}