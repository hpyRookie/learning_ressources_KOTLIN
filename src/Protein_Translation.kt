/* translate RNA sequence into protein */

const val RNA = "AUGUUUUCUUAAAUG"

fun splitInThreeSequence(rna: String): List<String> {
    /* Use this function for separating sequence into codons that could be interpreted as protein */
    return rna.chunked(3)
}

fun convertCondonsInProtein(Codons:List<String>): String {
    /* use a dictionary to assimilate codons sequence and protein based on the documentation */
    val list:MutableList<String> = mutableListOf()


    val tableOfProtein: MutableMap<String, String> = mutableMapOf(
        "AUG" to "Methionine",
        "UUU" to "Phenylalanine" ,
        "UCU" to "Serine",
        "UAA" to "Stop"
    )

    for (codon in Codons) {
        if (tableOfProtein[codon]=="Stop") {
            println("End of the translation")
            break
        }
        tableOfProtein[codon]?.let { list.add(it) }

    }

    return list.joinToString(", ") // Join the list into a single string
}

fun main(args: Array<String>) {
    val condons = splitInThreeSequence(RNA)
    println(condons)
    val protein = convertCondonsInProtein(condons)
    println(protein)  // Output: Methionine, Phenylalanine, Serine, Stop
}